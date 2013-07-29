package com.example.mongoviewer.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.controller.IConstroller;
import com.example.mongoviewer.mongodb.collection.Customers;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController implements IConstroller<Customers> {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.controller.IConstroller#top()
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView top() {
		logger.debug("IndexController:[top] Passing through...");

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activeNavi", "home");

		return modelAndView;

	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.controller.IConstroller#search(java.lang.String, java.lang.Object, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView search(String page, Customers searchCondition,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.controller.IConstroller#detail(java.lang.String)
	 */
	@Override
	public ModelAndView detail(String id) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.controller.IConstroller#edit(java.lang.String)
	 */
	@Override
	public ModelAndView edit(String id) {
		return null;
	}

}
