package com.spicy.kitchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer priceId;

	@Column(name = "basePrice")
	private double basePrice;

	@Column(name = "gst")
	private double gst;

	@Column(name = "totalPrice")
	private double totalPrice;

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Price(Integer priceId, double basePrice, double gst, double totalPrice) {
		super();
		this.priceId = priceId;
		this.basePrice = basePrice;
		this.gst = gst;
		this.totalPrice = totalPrice;
	}

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
