package edu.mum.mobile.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.mum.mobile.store.bean.Order;
import edu.mum.mobile.store.bean.OrderItem;
import edu.mum.mobile.store.util.ConnectionManager;

public class CheckoutDao {
	
	public boolean insertOrder(Order order, List<OrderItem> items) {
		boolean success = true;
		final String sql = "INSERT INTO `ORDER` (USER_ID, FULL_NAME, ADDRESS, PAYMENT_METHOD, COMMENT, TOTAL)"
				+ "	VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setString(2, order.getFullName());
			preparedStatement.setString(3, order.getAddress());
			preparedStatement.setString(4, order.getPaymentMethod());
			preparedStatement.setString(5, order.getComment());
			preparedStatement.setDouble(6, calTotal(items));
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			order.setId(rs.getInt(1));
			
			for(OrderItem item: items) {
				insertOrderItem(order.getId(), item);
			}
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	private boolean insertOrderItem(int orderId, OrderItem item) {
		boolean success = true;
		final String sql = "INSERT INTO ORDER_ITEM (ORDER_ID, PRODUCT_ID, PRODUCT_PRICE, PRODUCT_QTY)"
				+ "	VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			preparedStatement.setInt(2, item.getProductId());
			preparedStatement.setDouble(3, item.getProductPrice());
			preparedStatement.setInt(4, item.getProductQty());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}
	
	private double calTotal(List<OrderItem> items) {
		double total = 0 ;
		total = items.stream().mapToDouble( i -> i.getProductPrice() * i.getProductQty()).sum();
		return total;
	}
}
