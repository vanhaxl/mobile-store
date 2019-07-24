package edu.mum.mobile.store.dao;

import edu.mum.mobile.store.bean.*;
import edu.mum.mobile.store.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
	public List<OrderDetail> getOrdersByUser(int userId) {
		List<OrderDetail> result = new ArrayList<>();
		String sql = "select *, oi.ID as ORDER_ITEM_ID from `ORDER` o inner join ORDER_ITEM oi on o.ID = oi.ORDER_ID"
				+ " inner join PRODUCT p on oi.PRODUCT_ID = p.ID WHERE o.USER_ID = ? ORDER BY o.ORDER_DATE DESC";
		try {
			PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				Product product = new Product();
				product.setId(rs.getInt("PRODUCT_ID"));
				product.setDescription(rs.getString("DESCRIPTION"));
				product.setName(rs.getString("NAME"));
				product.setImage(rs.getString("IMAGE"));
				orderDetail.setProduct(product);

				Order order = new Order();
				order.setId(rs.getInt("ORDER_ID"));
				order.setOrderDate(rs.getString("ORDER_DATE"));
				order.setPaymentMethod(rs.getString("PAYMENT_METHOD"));
				order.setStatus(rs.getString("STATUS"));
				order.setFullName(rs.getString("FULL_NAME"));
				order.setComment(rs.getString("COMMENT"));
				order.setTotal(rs.getDouble("TOTAL"));
				orderDetail.setOrder(order);

				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt("ORDER_ITEM_ID"));
				orderItem.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				orderItem.setProductQty(rs.getInt("PRODUCT_QTY"));
				orderDetail.setOrderItem(orderItem);

				result.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
