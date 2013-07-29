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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.controller.IConstroller;
import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.OrderDetails;
import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController extends BaseController implements IConstroller<Orders> {
	private static Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Qualifier(QualifierNames.SERVICE_ORDERS)
	@Autowired
	private IService<Orders> ordersService;

	@Qualifier(QualifierNames.SERVICE_ORDER_DETAILS)
	@Autowired
	private IService<OrderDetails> orderDetailsService;

	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("OrdersController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("orders/orders");
		modelAndView.addObject(ACTIVE_NAVI, "orders");

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#search(java.lang.String, java.lang.Object, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable(value="page") String page, @ModelAttribute("orders") Orders searchCondition,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("OrdersController:[search] Passing through...");

		logger.debug("[page] : " + page);

		logger.debug("orderNumber : " + searchCondition.getOrderNumber());
		logger.debug("customerNumber : " + searchCondition.getCustomerNumber());
		logger.debug("status : " + searchCondition.getStatus());

		debug(result, request, response);

		//全件の件数
		long allCount =
			ordersService.count();

		//検索条件に一致する件数
		long resultCount =
			ordersService.count(searchCondition);

		int numberOfCurrentPage = calcCurrentPage(page);

		//検索条件に一致するコレクション
		List<Orders> searchResult =
			ordersService.search(numberOfCurrentPage, searchCondition);

		Paging paging = new Paging(allCount, resultCount, numberOfCurrentPage, "/orders/search/", request.getQueryString());
		paging.makePageList();

		ModelAndView modelAndView = new ModelAndView("orders/orders");
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.addObject("searchResult", searchResult);
		modelAndView.addObject(PAGING, paging);
		modelAndView.addObject(ACTIVE_NAVI, "orders");

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#detail(java.lang.String)
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable(value="id") String id) {
		logger.debug("OrdersController:[detail] Passing through...");

		Orders detail =
			ordersService.get(id);

		OrderDetails searchCondition = new OrderDetails();
		searchCondition.setOrderNumber(detail.getOrderNumber());

		List<OrderDetails> list =
			orderDetailsService.search(1, searchCondition);

		Customers searchCustomer = new Customers();
		searchCustomer.setCustomerNumber(detail.getCustomerNumber());

		Customers customer =
			customersService.find(searchCustomer);

		ModelAndView modelAndView = new ModelAndView("orders/detail");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject("orderDetailList", list);
		modelAndView.addObject("customer", customer);
		modelAndView.addObject(ACTIVE_NAVI, "orders");

		return modelAndView;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView edit(@PathVariable(value="id") String id) {
		logger.debug("OrdersController:[edit] Passing through...");

		Orders detail =
			ordersService.get(id);

		ModelAndView modelAndView = new ModelAndView("orders/edit");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject(ACTIVE_NAVI, "orders");

		return modelAndView;

	}

	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Orders json(@PathVariable(value="id") String id) {
		logger.debug("OrdersController:[json] Passing through...");

		Orders detail =
			ordersService.get(id);
		
		return detail;

	}

}
