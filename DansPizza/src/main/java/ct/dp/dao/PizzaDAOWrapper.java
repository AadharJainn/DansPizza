package ct.dp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ct.dp.business.bean.PizzaBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.entity.PizzaEntity;
import ct.dp.entity.PizzaOrderEntity;

@Repository
@Transactional(value = "txManager")
public class PizzaDAOWrapper {

	@Autowired
	private PizzaDAO pizzaDAO;

	@Autowired
	private PizzaOrderDAO pizzaOrderDAO;

	@PersistenceContext
	EntityManager entityManager;

	public List<PizzaBean> findAllPizzaDetails() throws Exception {

		List<PizzaBean> list = new ArrayList<PizzaBean>();
		try {
			List<PizzaEntity> listEntity = pizzaDAO.findAllPizzaDetails();

			for (PizzaEntity pizzaEntity : listEntity) {
				PizzaBean pizzaBean = convertPizzaEntityToBean(pizzaEntity);
				list.add(pizzaBean);
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	
	public List<PizzaOrderBean> updateOrderDetails() throws Exception {

		List<PizzaOrderBean> list = new ArrayList<PizzaOrderBean>();
		try {
			List<PizzaOrderEntity> listOrderEntity = pizzaDAO.findOrderDetails();

			for (PizzaOrderEntity pizzaOrderEntity : listOrderEntity) {
				PizzaOrderBean pizzaOrderBean = convertPizzaOrderEntityToBean(pizzaOrderEntity);
				list.add(pizzaOrderBean);
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	

	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) throws Exception {
		PizzaOrderBean pizzaOrderBeanRet = null;
		PizzaOrderEntity pizzaOrderEntity = convertPizzaOrderBeanToEntity(pizzaOrderBean); // using BeanUtils
		try {

			pizzaOrderBeanRet = convertPizzaOrderEntityToBean(pizzaOrderDAO.save(pizzaOrderEntity));
		} catch (Exception exception) {
			throw exception;
		}
		return pizzaOrderBeanRet;
	}

	public Double getPizzaPrice(Integer pizzaId) throws Exception {
		double price = 0;
		PizzaEntity pizzaEntity = entityManager.find(PizzaEntity.class, pizzaId);
		if (pizzaEntity != null) {
			price = pizzaEntity.getPrice();
		}
		return price;
	}

	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception {
		List<PizzaOrderBean> listPizzaOrderBean = null;
		try {
			Query query = entityManager.createQuery("select k from PizzaOrderEntity k where k.bill>=?1 and k.bill<=?2");
			query.setParameter(1, fromBill);
			query.setParameter(2, toBill);

			@SuppressWarnings("unchecked")
			List<PizzaOrderEntity> listPizzaOrderEntity = query.getResultList();

			listPizzaOrderBean = new ArrayList<PizzaOrderBean>();

			for (PizzaOrderEntity entity : listPizzaOrderEntity) {
				PizzaOrderBean pizzaOrderBean = convertPizzaOrderEntityToBean(entity);
				listPizzaOrderBean.add(pizzaOrderBean);
			}
		} catch (Exception exception) {
			throw exception;
		}
		return listPizzaOrderBean;
	}

	// Utility Methods.......
	public static PizzaOrderBean convertPizzaOrderEntityToBean(PizzaOrderEntity entity) {
		PizzaOrderBean pizzaOrderBean = new PizzaOrderBean();
		BeanUtils.copyProperties(entity, pizzaOrderBean);
		return pizzaOrderBean;
	}

	public static PizzaOrderEntity convertPizzaOrderBeanToEntity(PizzaOrderBean bean) {
		PizzaOrderEntity entity = new PizzaOrderEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

	// Utility Methods.......
	public static PizzaBean convertPizzaEntityToBean(PizzaEntity entity) {
		PizzaBean pizzaBean = new PizzaBean();
		BeanUtils.copyProperties(entity, pizzaBean);
		return pizzaBean;
	}

	public static PizzaEntity convertPizzaBeanToEntity(PizzaBean bean) {
		PizzaEntity entity = new PizzaEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
}
