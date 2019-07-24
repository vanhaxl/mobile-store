package edu.mum.mobile.store.bean;

import java.util.Objects;

public class OrderItem {
	private int id;
	private int orderId;
	private int productId;
	private double productPrice;
	private int productQty;
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof OrderItem) ) {
			return false;
		}
		OrderItem orderItem = (OrderItem) obj;
		return this.getId() == orderItem.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
}
