package edu.mum.mobile.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mobile.store.bean.Product;
import edu.mum.mobile.store.util.ConnectionManager;

public class ProductDao {
	
	public List<Product> getProductByCategoryId(int categoryId) {
		List<Product> products = new ArrayList<>();
		final String sql = "SELECT * FROM PRODUCT WHERE CATEGORY_ID= ? AND ACTIVE = '1'";
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setImage(rs.getString("IMAGE"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrice(rs.getDouble("PRICE"));
				p.setAmountAvailable(rs.getInt("AMOUNT_AVAILABLE"));
				p.setCategoryId(rs.getInt("CATEGORY_ID"));
				p.setActive(rs.getInt("ACTIVE"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> search(String keyword, Integer categoryId, Integer active) {
		List<Product> products = new ArrayList<>();
		if (keyword == null) {
			keyword = "";
		}
		keyword = "%" + keyword + "%";
		String sql = "SELECT * FROM PRODUCT WHERE (NAME like ? OR DESCRIPTION like ?)";
		if (categoryId != null) {
			sql += " AND CATEGORY_ID = ?";
		}
		if (active != null) {
			sql += " AND ACTIVE = " + active;
		}
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, keyword);
			preparedStatement.setString(2, keyword);

			if (categoryId != null) {
				preparedStatement.setInt(3, categoryId);
			}
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setImage(rs.getString("IMAGE"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrice(rs.getDouble("PRICE"));
				p.setAmountAvailable(rs.getInt("AMOUNT_AVAILABLE"));
				p.setCategoryId(rs.getInt("CATEGORY_ID"));
				p.setActive(rs.getInt("ACTIVE"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}


	private void createProduct(Product newProduct) {
		String query = "INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, IMAGE, ACTIVE)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, newProduct.getName());
			ps.setString(2, newProduct.getDescription());
			ps.setDouble(3, newProduct.getPrice());
			ps.setInt(4, newProduct.getCategoryId());
			ps.setString(5, newProduct.getImage());
			ps.setInt(6, newProduct.getActive());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateProduct(Product product) {
		String query = "UPDATE PRODUCT SET NAME = ?, DESCRIPTION = ?,"
				+ " PRICE = ?, CATEGORY_ID = ?, IMAGE = ?, ACTIVE = ? WHERE ID = ?";
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getCategoryId());
			ps.setString(5, product.getImage());
			ps.setInt(6, product.getActive());
			ps.setInt(7, product.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createOrUpdateProduct(Product product) {
		if (product.getId() != null) {
			updateProduct(product);
		} else {
			createProduct(product);
		}
	}

	public Product getProductById(int id) {
		Product p = new Product();
		final String sql = "SELECT * FROM PRODUCT WHERE ID=?";
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setImage(rs.getString("IMAGE"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrice(rs.getDouble("PRICE"));
				p.setAmountAvailable(rs.getInt("AMOUNT_AVAILABLE"));
				p.setCategoryId(rs.getInt("CATEGORY_ID"));
				p.setActive(rs.getInt("ACTIVE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
