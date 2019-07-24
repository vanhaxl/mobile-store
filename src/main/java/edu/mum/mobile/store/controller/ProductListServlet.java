package edu.mum.mobile.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.mobile.store.bean.Category;
import edu.mum.mobile.store.bean.Product;
import edu.mum.mobile.store.dao.CategoryDao;
import edu.mum.mobile.store.dao.ProductDao;

@WebServlet("/product-list")
@MultipartConfig
public class ProductListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = new ProductDao();
	private CategoryDao categoryDao = new CategoryDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String categoryIdStr = request.getParameter("categoryId");
		HttpSession session = request.getSession();
		session.setAttribute("keyword", keyword);

		Integer categoryId = null;
		if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
			try {
				categoryId = Integer.valueOf(categoryIdStr);
			} catch (NumberFormatException ex) {
				//this is a little hack...
			}
		}
		session.setAttribute("categoryId", categoryId);

		int active = 0;
		String activeStr = request.getParameter("active");
		if (activeStr != null && !activeStr.isEmpty()) {
			active = 1;
		}
		session.setAttribute("active", active);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String keyword = (String) session.getAttribute("keyword");
		Integer categoryId = null;
		Object categoryIdObj = session.getAttribute("categoryId");
		if (categoryIdObj != null) {
			categoryId = (Integer) categoryIdObj;
		}

		Integer active = 1;
		Object activeObj = session.getAttribute("active");
		if (activeObj != null) {
			active = (Integer) activeObj;
		} else {
			session.setAttribute("active", active);
		}
		List<Product> allProducts = productDao.search(keyword, categoryId, active);
		request.setAttribute("products", allProducts);

		List<Category> categories = categoryDao.getAllCategory();
		request.setAttribute("categories", categories);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product-list.jsp");
		requestDispatcher.forward(request, response);
	}
}
