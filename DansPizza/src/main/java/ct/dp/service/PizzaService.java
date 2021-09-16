package ct.dp.service;

import java.util.List;
import java.util.Map;

import ct.dp.RestClient.RestClient;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.business.bean.UpdatePizzaOrderBean;

public interface PizzaService {	
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception;
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) throws Exception;
	public Map<Integer,String> findAllPizzaDetails()throws Exception;
	public UpdatePizzaOrderBean tryPizza(UpdatePizzaOrderBean updatePizzaOrderBean) throws Exception ;
	public Map<Integer, Integer> updatePizzaDetails()throws Exception;
	
}