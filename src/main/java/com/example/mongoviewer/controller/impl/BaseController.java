package com.example.mongoviewer.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

public class BaseController {
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);

	protected static final String PAGING = "paging";
	protected static final String ACTIVE_NAVI = "activeNavi";

	protected int calcCurrentPage(String page) {
		return page == null ? 1 : Integer.valueOf(page).intValue();
	}

	protected void debug(BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		if (logger.isDebugEnabled()) {
			logger.debug("queryString : " + request.getQueryString());
			logger.debug("contextPath : " + request.getContextPath());
			logger.debug("pathInfo : "    + request.getPathInfo());
			logger.debug("servletPath : " + request.getServletPath());
			logger.debug("method : "      + request.getMethod());

			logger.debug("errorCount : " + result.getErrorCount());
		}

	}

}
