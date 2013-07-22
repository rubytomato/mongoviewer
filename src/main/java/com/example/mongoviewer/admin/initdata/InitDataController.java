package com.example.mongoviewer.admin.initdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class InitDataController {
	private static Logger logger = LoggerFactory.getLogger(InitDataController.class);

	@Autowired
	private InitDataService initDataService;

	@RequestMapping(value = "/admin/initdata", method = RequestMethod.GET)
	public String init() {
		logger.debug("InitDataController:[init] Passing through...");

		//initDataService.init();

		return "/admin/initdata/init";

	}

}
