package com.example.mongoviewer.controller.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.controller.IConstroller;
import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;

@Controller
@RequestMapping(value = "/customers")
public class CustomersController extends BaseController implements IConstroller<Customers> {
	private static Logger logger = LoggerFactory.getLogger(CustomersController.class);

	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@Qualifier(QualifierNames.SERVICE_ORDERS)
	@Autowired
	private IService<Orders> ordersService;

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("CustomersController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("customers/customers");

		return modelAndView;

	}

	@RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable(value="page") String page, @ModelAttribute("customers") Customers searchCondition, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("CustomersController:[search] Passing through...");

		logger.debug("[page] : " + page);

		if (logger.isDebugEnabled()) {
			logger.debug(searchCondition.toString());
		}

		debug(result, request, response);

		//全件の件数
		long totalCount =
			customersService.count();

		//検索条件に一致する件数
		long resultCount =
			customersService.count(searchCondition);

		int numberOfCurrentPage = calcCurrentPage(page);

		//検索条件に一致するコレクション
		List<Customers> searchResult =
			customersService.search(numberOfCurrentPage, searchCondition);

		Paging paging = new Paging(totalCount, resultCount, numberOfCurrentPage, "/customers/search/", request.getQueryString());
		paging.makePageList();

		ModelAndView modelAndView = new ModelAndView("customers/customers");
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.addObject("searchResult", searchResult);
		modelAndView.addObject("paging", paging);

		return modelAndView;

	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable(value="id") String id) {
		logger.debug("CustomersController:[detail] Passing through...");

		Customers customer =
			customersService.get(id);

		Orders order = new Orders();
		order.setCustomerNumber(customer.getCustomerNumber());

		List<Orders> orderList =
			ordersService.search(1, order);

		ModelAndView modelAndView = new ModelAndView("customers/detail");
		modelAndView.addObject("detail", customer);
		modelAndView.addObject("orderList", orderList);

		return modelAndView;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView edit(@PathVariable(value="id") String id) {
		logger.debug("CustomersController:[edit] Passing through...");

		Customers customer =
			customersService.get(id);

		ModelAndView modelAndView = new ModelAndView("customers/edit");
		modelAndView.addObject("customers", customer);

		return modelAndView;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Customers customer, BindingResult result, Model model) {
		logger.debug("CustomersController:[save] Passing through...");

		if (result.hasErrors()) {
			return "customers/edit";
		}

		if (customer == null) {
			logger.debug("customer is null");
		} else {
			logger.debug(customer.toString());
		}

		model.addAttribute("detail", customer);

		return "redirect:detail/" + customer.getId();

	}

	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Customers json(@PathVariable(value="id") String id) {
		logger.debug("CustomersController:[json] Passing through...");

		Customers customer =
			customersService.get(id);

		return customer;

	}

	@ExceptionHandler(NullPointerException.class)
	public String NullPointerException(IllegalStateException ex) {
		return "error/nullpointer";
	}

	@ExceptionHandler
	@ResponseBody
	public String handleException(IllegalStateException ex) {
		return "Handled exception: " + ex.getMessage();
	}

}
