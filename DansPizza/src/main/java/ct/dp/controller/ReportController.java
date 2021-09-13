package ct.dp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ct.dp.business.bean.BillRangeBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.service.PizzaService;

@Controller
public class ReportController {

	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(value = "LoadBillRangeReport")
	public ModelAndView loadDateRangeReportPage() {
		ModelAndView andView = new ModelAndView("OrderReport");
		andView.addObject("billRangeObj", new BillRangeBean());
		return andView;
	}

	@RequestMapping(value = "FetchRecordsWithinDateRange", method = RequestMethod.POST)
	public ModelAndView getOrderDetails(@ModelAttribute("billRangeObj") BillRangeBean billRangeBean) throws Exception {
		List<PizzaOrderBean> listPizzaOrderBean = pizzaService.getOrderDetails(billRangeBean.getFromPrice(),
				billRangeBean.getToPrice());
		ModelAndView andView = new ModelAndView("OrderReport");
		andView.addObject("pizzaOrderList", listPizzaOrderBean);
		return andView;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}

}
