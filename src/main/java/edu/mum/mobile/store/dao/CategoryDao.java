package edu.mum.mobile.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mobile.store.bean.Category;
import edu.mum.mobile.store.util.ConnectionManager;

public class CategoryDao {
	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<>();
		final String sql = "SELECT * FROM CATEGORY";
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Category c = new Category(rs.getInt("ID"), rs.getString("NAME"), rs.getString("DESCRIPTION"));
				categories.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
}
