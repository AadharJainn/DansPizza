package ct.dp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.dao.PizzaDAO;
import ct.dp.dao.PizzaOrderDAO;
import ct.dp.service.PizzaService;

@Controller
public class UpdateController {

	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(value = "/UpdatePizzaOrder", method = RequestMethod.GET)
	public ModelAndView loadSavePizza() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdatePizzaOrder");
		modelAndView.addObject("updatePizzaOrder", new PizzaOrderBean());
		return modelAndView;

	}

	@RequestMapping(path = "/updateOrder", method = RequestMethod.POST)
	public ModelAndView updatePizzaOrder(@Valid @ModelAttribute("updatePizzaOrder") PizzaOrderBean pizzaOrderBean,
			BindingResult bindingResult) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("UpdatePizzaOrder");
		} else {
			PizzaOrderBean retPizzaOrderBean = pizzaService.tryPizza(pizzaOrderBean);
			modelAndView.setViewName("UpdateOrderSuccess");
			modelAndView.addObject("updateMessage",
					"Hi: " + retPizzaOrderBean.getCustomerName() + ", your order is updated with orderId: "
							+ retPizzaOrderBean.getOrderId() + ", Bill to be paid is: " + retPizzaOrderBean.getBill());
		}

		return modelAndView;

	}
	@ModelAttribute("orderId")
	public Map<Integer, Integer> populateOrderId() throws Exception {
		return pizzaService.updatePizzaDetails();
		
	}
	
	@ModelAttribute("pizzaNamesAndId")
	public Map<Integer, String> populatePizzaNames() throws Exception {
		return pizzaService.findAllPizzaDetails();
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}
}
