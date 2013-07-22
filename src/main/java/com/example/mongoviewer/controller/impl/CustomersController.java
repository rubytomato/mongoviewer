package com.example.mongoviewer.controller.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.controller.IConstroller;
import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.service.IService;

@Controller
public class CustomersController implements IConstroller<Customers> {
	private static Logger logger = LoggerFactory.getLogger(CustomersController.class);

	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@Qualifier(QualifierNames.SERVICE_ORDERS)
	@Autowired
	private IService<Orders> ordersService;

	@Autowired
	private MongoService mongoService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("CustomersController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("customers/customers");

		return modelAndView;

	}

	@RequestMapping(value = "/customers/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable("page") String page, @ModelAttribute("customers") Customers searchCondition, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("CustomersController:[search] Passing through...");

		logger.debug("[page] : " + page);

		logger.debug("customerNumber : " + searchCondition.getCustomerNumber());
		logger.debug("customerName : " + searchCondition.getCustomerName());
		logger.debug("phone : " + searchCondition.getPhone());
		logger.debug("city : " + searchCondition.getCity());
		logger.debug("country : " + searchCondition.getCountry());

		logger.debug("queryString : " + request.getQueryString());
		logger.debug("contextPath : " + request.getContextPath());
		logger.debug("pathInfo : "    + request.getPathInfo());
		logger.debug("servletPath : "    + request.getServletPath());

		logger.debug("errorCount : " + result.getErrorCount());

		//全件の件数
		long totalCount =
			customersService.count();

		//検索条件に一致する件数
		long resultCount =
			customersService.count(searchCondition);

		int numberOfCurrentPage = page == null ? 1 : Integer.valueOf(page).intValue();

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

	@RequestMapping(value = "/customers/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable("id") String id) {
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
}
