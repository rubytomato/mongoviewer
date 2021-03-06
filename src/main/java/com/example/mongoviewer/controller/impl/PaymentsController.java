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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.controller.IConstroller;
import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;


@Controller
@RequestMapping(value = "/payments")
public class PaymentsController extends BaseController implements IConstroller<Payments> {
	private static Logger logger = LoggerFactory.getLogger(PaymentsController.class);

	@Qualifier(QualifierNames.SERVICE_PAYMENTS)
	@Autowired
	private IService<Payments> paymentsService;

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#top()
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("PaymentsController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("payments/payments");
		modelAndView.addObject(ACTIVE_NAVI, "payments");

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#search(java.lang.String, java.lang.Object, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable(value="page") String page, @ModelAttribute("payments") Payments searchCondition,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("PaymentsController:[search] Passing through...");

		logger.debug("[page] : " + page);

		logger.debug("customerNumber : " + searchCondition.getCustomerNumber());
		logger.debug("checkNumber : " + searchCondition.getCheckNumber());
		logger.debug("paymentDate : " + searchCondition.getPaymentDate());
		logger.debug("amount : " + searchCondition.getAmount());

		debug(result, request, response);

		//全件の件数
		long allCount =
			paymentsService.count();

		//検索条件に一致する件数
		long resultCount =
			paymentsService.count(searchCondition);

		int numberOfCurrentPage = calcCurrentPage(page);

		//検索条件に一致するコレクション
		List<Payments> searchResult =
			paymentsService.search(numberOfCurrentPage, searchCondition);

		Paging paging = new Paging(allCount, resultCount, numberOfCurrentPage, "/payments/search/", request.getQueryString());
		paging.makePageList();

		ModelAndView modelAndView = new ModelAndView("payments/payments");
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.addObject("searchResult", searchResult);
		modelAndView.addObject(PAGING, paging);
		modelAndView.addObject(ACTIVE_NAVI, "payments");

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#detail(java.lang.String)
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable(value="id") String id, Model model) {
		logger.debug("PaymentsController:[detail] Passing through...");

		Payments detail =
			paymentsService.get(id);

		ModelAndView modelAndView = new ModelAndView("payments/detail");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject(ACTIVE_NAVI, "payments");

		return modelAndView;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView edit(@PathVariable(value="id") String id) {
		logger.debug("PaymentsController:[edit] Passing through...");

		Payments detail =
			paymentsService.get(id);

		ModelAndView modelAndView = new ModelAndView("payments/edit");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject(ACTIVE_NAVI, "payments");

		return modelAndView;

	}

	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Payments json(@PathVariable(value="id") String id) {
		logger.debug("PaymentsController:[json] Passing through...");

		Payments detail =
			paymentsService.get(id);

		return detail;

	}

}
