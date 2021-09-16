package ct.dp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct.dp.RestClient.RestClient;
import ct.dp.business.bean.PizzaBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.business.bean.UpdatePizzaOrderBean;
import ct.dp.dao.PizzaDAOWrapper;
import ct.dp.dao.PizzaOrderDAO;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaDAOWrapper pizzaDAOWrapper;

	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception {
		List<PizzaOrderBean> list = pizzaDAOWrapper.getOrderDetails(fromBill, toBill);
		if (list == null || list.size() == 0) {
			throw new Exception("No records were found for the entered Bill Range");
		}
		return list;
	}

	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) throws Exception {
		double price = pizzaDAOWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
		Double bill = pizzaOrderBean.getNumberOfPiecesOrdered() * price;
		pizzaOrderBean.setBill(bill);
		return pizzaDAOWrapper.addPizzaOrderDetails(pizzaOrderBean);
	}

	public Map<Integer, String> findAllPizzaDetails() throws Exception {
		List<PizzaBean> pizzaList = pizzaDAOWrapper.findAllPizzaDetails();
		Map<Integer, String> pizzaMap = new HashMap<Integer, String>();
		for (PizzaBean item : pizzaList) {
			pizzaMap.put(item.getPizzaId(), item.getPizzaName());
		}
		return pizzaMap;

	}

	public UpdatePizzaOrderBean tryPizza(UpdatePizzaOrderBean updatePizzaOrderBean) throws Exception {
	 RestClient restClient=new RestClient();
	 double price = pizzaDAOWrapper.getPizzaPrice(updatePizzaOrderBean.getPizzaId());
		Double bill = updatePizzaOrderBean.getNumberOfPiecesOrdered() * price;
		updatePizzaOrderBean.setBill(bill);
	 restClient.tryUpdate(updatePizzaOrderBean);
	return updatePizzaOrderBean;
	}

	public Map<Integer, Integer> updatePizzaDetails() throws Exception {
		List<UpdatePizzaOrderBean> pizzaList = pizzaDAOWrapper.updateOrderDetails();
		Map<Integer, Integer> pizzaMap = new HashMap<Integer, Integer>();
		for (UpdatePizzaOrderBean item : pizzaList) {
			pizzaMap.put(item.getOrderId(),item.getOrderId());
		}
		return pizzaMap;

	}


}
