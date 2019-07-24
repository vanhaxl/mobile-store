package edu.mum.mobile.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.mobile.store.dao.ShoppingCartDao;
import edu.mum.mobile.store.dto.ProductDto;

/**
 * Servlet implementation class ShoppingCartUpdateServlet
 */
@WebServlet("/shopping-cart/update")
public class ShoppingCartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ObjectMapper mapper = new ObjectMapper();
	private ShoppingCartDao shoppingCartDao;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session != null && session.getAttribute("shoppingCartDao") != null) {
			shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
		} else {
			shoppingCartDao = new ShoppingCartDao();
			session.setAttribute("shoppingCartDao", shoppingCartDao);
		}
		super.service(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		ProductDto updatedItem = mapper.readValue(request.getParameter("product"), ProductDto.class);
		System.out.println("Updated Items: " + updatedItem.toString() );
		shoppingCartDao.updateQty(updatedItem.getId(), updatedItem.getQty());
		writer.print(mapper.writeValueAsString(shoppingCartDao.getMyCart()));
	}

}
