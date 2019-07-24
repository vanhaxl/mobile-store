package edu.mum.mobile.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.mobile.store.dao.ProductDao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns= {"/product"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();
	private ProductDao productDao = new ProductDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("categoryId") != null) {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			String text = request.getParameter("search");
			PrintWriter writer = response.getWriter();
			writer.print(mapper.writeValueAsString(productDao.search(text, categoryId, 1)));
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
