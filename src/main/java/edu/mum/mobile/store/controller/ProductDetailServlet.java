package edu.mum.mobile.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mobile.store.dao.ProductDao;
import edu.mum.mobile.store.dao.ProductDetailDao;

@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDao db = new ProductDao();
	ProductDetailDao db2 = new ProductDetailDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        req.setAttribute("product", db.getProductById(productId));
        req.setAttribute("product_detail", db2.getProductDetail(productId));
        req.getRequestDispatcher("/WEB-INF/jsp/product-detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
