package edu.mum.mobile.store.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import edu.mum.mobile.store.bean.Category;
import edu.mum.mobile.store.bean.Product;
import edu.mum.mobile.store.dao.CategoryDao;
import edu.mum.mobile.store.dao.ProductDao;

@WebServlet("/product-management")
@MultipartConfig
public class ProductManagementServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao = new CategoryDao();
	private ProductDao productDao = new ProductDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("data");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		Product newProduct = new Product();
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			newProduct.setId(Integer.valueOf(idStr));
		}

		if (fileName != null && !fileName.isEmpty()) {
			InputStream inputStream = part.getInputStream();

			File file = new File(request.getServletContext().getRealPath("/images") + "/" + fileName);
			OutputStream outputStream = new FileOutputStream(file);
			IOUtils.copy(inputStream, outputStream);
			outputStream.close();
			newProduct.setImage("images/" + fileName);
		} else if (idStr != null && !idStr.isEmpty()) {
			Product oldProduct = productDao.getProductById(Integer.valueOf(idStr));
			newProduct.setImage(oldProduct.getImage());
		}
		newProduct.setCategoryId(Integer.valueOf(request.getParameter("categoryId")));
		newProduct.setName(request.getParameter("name"));
		newProduct.setDescription(request.getParameter("description"));
		newProduct.setPrice(Double.valueOf(request.getParameter("price")));
		String activeStr = request.getParameter("active");
		if (activeStr != null && !activeStr.isEmpty()) {
			newProduct.setActive(1);
		} else {
			newProduct.setActive(0);
		}

		productDao.createOrUpdateProduct(newProduct);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryDao.getAllCategory();
		request.setAttribute("categories", categories);

		Integer productId = null;
		if (request.getParameter("productId") != null) {
			productId = Integer.valueOf(request.getParameter("productId"));
		}

		if (productId != null) {
			request.setAttribute("product", productDao.getProductById(productId));
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product-management.jsp");
		requestDispatcher.forward(request, response);
	}
}
