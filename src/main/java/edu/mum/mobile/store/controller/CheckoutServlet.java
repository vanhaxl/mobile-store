package edu.mum.mobile.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.mobile.store.bean.CartProduct;
import edu.mum.mobile.store.bean.Order;
import edu.mum.mobile.store.bean.OrderItem;
import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.dao.CheckoutDao;
import edu.mum.mobile.store.dao.ShoppingCartDao;
import edu.mum.mobile.store.dto.ResultDto;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingCartDao shoppingCartDao;
	private CheckoutDao checkoutDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		checkoutDao = new CheckoutDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		HttpSession session = req.getSession(true);
		if (session != null && session.getAttribute("shoppingCartDao") != null) {
			shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
		} else {
			shoppingCartDao = new ShoppingCartDao();
			session.setAttribute("shoppingCartDao", shoppingCartDao);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		if (request.getParameter("order") != null) {
			Order order = mapper.readValue(request.getParameter("order"), Order.class);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			order.setUserId(user.getId());
			List<OrderItem> items = new ArrayList<>();
			// build the item list
			for (CartProduct cart: shoppingCartDao.getMyCart()) {
				OrderItem item = new OrderItem();
				item.setProductId(cart.getProduct().getId());
				item.setProductPrice(cart.getPrice());
				item.setProductQty(cart.getQty());
				items.add(item);
			}
			success = checkoutDao.insertOrder(order, items);
		}
		if (success) {
			request.getSession().setAttribute("shoppingCartDao", null);
		}
		response.getWriter().print(mapper.writeValueAsString(new ResultDto(success)));
		
	}

}
