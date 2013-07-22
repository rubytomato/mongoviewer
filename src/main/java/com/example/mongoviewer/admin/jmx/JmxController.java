package com.example.mongoviewer.admin.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JmxController {
	private static Logger logger = LoggerFactory.getLogger(JmxController.class);

	@Autowired
	private JmxService jmxService;

	@RequestMapping(value = "/admin/jmx", method = RequestMethod.GET)
	public String jmx() {
		logger.debug("JmxController:[jmx] Passing through...");

		//jmxService.execute();

		return "/admin/jmx/jmx";
	}

}
