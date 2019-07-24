package edu.mum.mobile.store.controller;

import edu.mum.mobile.store.bean.Order;
import edu.mum.mobile.store.bean.OrderDetail;
import edu.mum.mobile.store.bean.User;
import edu.mum.mobile.store.dao.OrderDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myaccount")
public class MyAccountServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderDao orderDao = new OrderDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;
		List<OrderDetail> orderDetails = new ArrayList<>();
		if (session !=  null && session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
			orderDetails = orderDao.getOrdersByUser(user.getId());
			request.setAttribute("orders", standadizeOrders(orderDetails));
		}
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/my-account.jsp");
		requestDispatcher.forward(request, response);
	}

	public List<Order> standadizeOrders(List<OrderDetail> orderDetails) {
		final List<Order> orders = new ArrayList<>();
		orderDetails.stream().forEach(orderDetail -> {
			Order order = orderDetail.getOrder();
			if (!orders.contains(orderDetail.getOrder())) {
				orders.add(orderDetail.getOrder());
			} else {
				order = orders.stream().filter(o -> o.getId() ==
						orderDetail.getOrder().getId()).findFirst().get();
			}
			order.addOrderItem(orderDetail.getOrderItem());
			orderDetail.getOrderItem().setProduct(orderDetail.getProduct());
		});
		return orders;
	}


}
