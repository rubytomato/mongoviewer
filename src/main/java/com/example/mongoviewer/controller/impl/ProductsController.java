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
import com.example.mongoviewer.mongodb.collection.Products;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;

@Controller
public class ProductsController extends BaseController implements IConstroller<Products> {
	private static Logger logger = LoggerFactory.getLogger(ProductsController.class);

	@Qualifier(QualifierNames.SERVICE_PRODUCTS)
	@Autowired
	private IService<Products> productsService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("ProductsController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("products/products");

		return modelAndView;

	}

	@RequestMapping(value = "/products/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable(value="page") String page, @ModelAttribute("products") Products searchCondition, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("ProductsController:[search] Passing through...");

		logger.debug("[page] : " + page);

		if (logger.isDebugEnabled()) {
			logger.debug(searchCondition.toString());
		}

		debug(result, request, response);

		//全件の件数
		long allCount =
			productsService.count();

		//検索条件に一致する件数
		long resultCount =
			productsService.count(searchCondition);

		int numberOfCurrentPage = calcCurrentPage(page);

		//検索条件に一致するコレクション
		List<Products> searchResult =
			productsService.search(numberOfCurrentPage, searchCondition);

		Paging paging = new Paging(allCount, resultCount, numberOfCurrentPage, "/products/search/", request.getQueryString());
		paging.makePageList();

		ModelAndView modelAndView = new ModelAndView("products/products");
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.addObject("searchResult", searchResult);
		modelAndView.addObject("paging", paging);

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.IConstroller#detail(java.lang.String)
	 */
	@RequestMapping(value = "/products/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable(value="id") String id) {
		logger.debug("ProductLinesController:[detail] Passing through...");

		Products detail =
			productsService.get(id);

		ModelAndView modelAndView = new ModelAndView("products/detail");
		modelAndView.addObject("detail", detail);

		return modelAndView;

	}

}
