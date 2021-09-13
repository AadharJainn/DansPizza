package ct.dp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_order")
public class PizzaOrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public PizzaOrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setNumberOfPiecesOrdered(Integer numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
	public PizzaOrderEntity(Integer orderId, Integer pizzaId, String customerName, String contactNumber, Double bill,
			Integer numberOfPiecesOrdered) {
		super();
		this.orderId = orderId;
		this.pizzaId = pizzaId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.bill = bill;
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
	

}
