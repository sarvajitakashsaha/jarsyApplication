package com.example.springboot;

import java.math.BigDecimal;

public class UserCurrencyConversionBean {
	private Long  id;
	private String from;
	private String to;
	private BigDecimal convirsionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	private String userStatus;
	private String name;
	
	
	public UserCurrencyConversionBean() {
		super();
	}


	public UserCurrencyConversionBean(Long id, String from, String to, BigDecimal convirsionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port,String userStatus,String name) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convirsionMultiple = convirsionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
		this.userStatus = userStatus;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	

	public BigDecimal getConvirsionMultiple() {
		return convirsionMultiple;
	}


	public void setConvirsionMultiple(BigDecimal convirsionMultiple) {
		this.convirsionMultiple = convirsionMultiple;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}


	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
  

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "UserCurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", convirsionMultiple="
				+ convirsionMultiple + ", quantity=" + quantity + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", port=" + port + ", userStatus=" + userStatus + ", name=" + name + "]";
	}



	
	 

}
