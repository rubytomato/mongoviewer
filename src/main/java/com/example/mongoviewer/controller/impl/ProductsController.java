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
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.mongodb.utils.MongoStats;
import com.example.mongoviewer.service.IService;

@Controller
public class ProductsController implements IConstroller<Products> {
	private static Logger logger = LoggerFactory.getLogger(ProductsController.class);

	@Qualifier(QualifierNames.SERVICE_PRODUCTS)
	@Autowired
	private IService<Products> productsService;

	@Autowired
	private MongoService mongoService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("ProductsController:[top] Passing through...");

		MongoStats stats =
			mongoService.stats(CollectionNames.Products);

		ModelAndView modelAndView = new ModelAndView("products/products");
		modelAndView.addObject("stats", stats);

		return modelAndView;

	}

	@RequestMapping(value = "/products/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable("page") String page, @ModelAttribute("products") Products searchCondition, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("ProductsController:[search] Passing through...");

		logger.debug("[page] : " + page);

		logger.debug("productCode : " + searchCondition.getProductCode());
		logger.debug("productName : " + searchCondition.getProductName());
		logger.debug("productLine : " + searchCondition.getProductLine());
		logger.debug("productScale : " + searchCondition.getProductScale());
		logger.debug("productVendor : " + searchCondition.getProductVendor());

		logger.debug("queryString : " + request.getQueryString());
		logger.debug("contextPath : " + request.getContextPath());
		logger.debug("pathInfo : "    + request.getPathInfo());
		logger.debug("servletPath : "    + request.getServletPath());

		logger.debug("errorCount : " + result.getErrorCount());

		//全件の件数
		long allCount =
			productsService.count();

		//検索条件に一致する件数
		long resultCount =
			productsService.count(searchCondition);

		int numberOfCurrentPage = page == null ? 1 : Integer.valueOf(page).intValue();

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
	public ModelAndView detail(@PathVariable("id") String id) {
		logger.debug("ProductLinesController:[detail] Passing through...");

		Products detail =
			productsService.get(id);

		ModelAndView modelAndView = new ModelAndView("products/detail");
		modelAndView.addObject("detail", detail);

		return modelAndView;

	}

}
