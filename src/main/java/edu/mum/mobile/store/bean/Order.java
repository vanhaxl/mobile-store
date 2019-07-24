package edu.mum.mobile.store.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
	private int id;
	private int userId;
	private String status;
	private String fullName;
	private String address;
	private String paymentMethod;
	private String comment;
	private String orderDate;
	private double total;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof Order) ) {
			return false;
		}
		Order order = (Order) obj;
		return this.getId() == order.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
}
