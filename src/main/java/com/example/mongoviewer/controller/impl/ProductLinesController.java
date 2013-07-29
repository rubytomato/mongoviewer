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
import com.example.mongoviewer.mongodb.collection.ProductLines;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.service.IService;

@Controller
@RequestMapping(value = "/productLines")
public class ProductLinesController extends BaseController implements IConstroller<ProductLines> {
	private static Logger logger = LoggerFactory.getLogger(ProductLinesController.class);

	@Qualifier(QualifierNames.SERVICE_PRODUCT_LINES)
	@Autowired
	private IService<ProductLines> productLinesService;

	@Autowired
	private MongoService mongoService;

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.Constroller#top()
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("ProductLinesController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("productLines/productLines");
		modelAndView.addObject(ACTIVE_NAVI, "productlines");

		return modelAndView;

	}


	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.Constroller#search(java.lang.String, java.lang.Object, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
	@Override
	public ModelAndView search(@PathVariable(value="page") String page, @ModelAttribute("productLines") ProductLines searchCondition,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("ProductLinesController:[search] Passing through...");

		logger.debug("[page] : " + page);

		logger.debug("productLine : " + searchCondition.getProductLine());

		debug(result, request, response);

		//全件の件数
		long allCount =
			productLinesService.count();

		//検索条件に一致する件数
		long resultCount =
			productLinesService.count(searchCondition);

		int numberOfCurrentPage = calcCurrentPage(page);

		//検索条件に一致するコレクション
		List<ProductLines> searchResult =
			productLinesService.search(numberOfCurrentPage, searchCondition);

		Paging paging = new Paging(allCount, resultCount, numberOfCurrentPage, "/productLines/search/", request.getQueryString());
		paging.makePageList();

		ModelAndView modelAndView = new ModelAndView("productLines/productLines");
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.addObject("searchResult", searchResult);
		modelAndView.addObject(PAGING, paging);
		modelAndView.addObject(ACTIVE_NAVI, "productlines");

		return modelAndView;

	}


	/* (non-Javadoc)
	 * @see net.blogdns.gontata.controller.Constroller#detail(java.lang.String)
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable(value="id") String id) {
		logger.debug("ProductLinesController:[detail] Passing through...");

		ProductLines detail =
			productLinesService.get(id);

		ModelAndView modelAndView = new ModelAndView("productLines/detail");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject(ACTIVE_NAVI, "productlines");

		return modelAndView;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView edit(@PathVariable(value="id") String id) {
		logger.debug("ProductLinesController:[edit] Passing through...");

		ProductLines detail =
			productLinesService.get(id);

		ModelAndView modelAndView = new ModelAndView("productLines/edit");
		modelAndView.addObject("detail", detail);
		modelAndView.addObject(ACTIVE_NAVI, "productlines");

		return modelAndView;

	}

	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProductLines json(@PathVariable(value="id") String id) {
		logger.debug("ProductLinesController:[json] Passing through...");

		ProductLines detail =
			productLinesService.get(id);

		return detail;

	}

}
