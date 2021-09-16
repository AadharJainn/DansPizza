package ct.dp.business.bean;

import javax.validation.constraints.NotNull;

public class UpdatePizzaOrderBean {
	@NotNull
	private Integer orderId;
	private Integer pizzaId;
	private String customerName;
	private String contactNumber;
	private Double bill;
	private Integer numberOfPiecesOrdered;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	public Integer getNumberOfPiecesOrdered() {
		return numberOfPiecesOrdered;
	}

	public void setNumberOfPiecesOrdered(Integer numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}

	@Override
	public String toString() {
		return "PizzaOrderBean [orderId=" + orderId + ", pizzaId=" + pizzaId + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", bill=" + bill + ", numberOfPiecesOrdered="
				+ numberOfPiecesOrdered + "]";
	}

}
