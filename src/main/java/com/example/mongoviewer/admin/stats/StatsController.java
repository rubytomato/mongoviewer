package com.example.mongoviewer.admin.stats;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.mongodb.utils.MongoStats;

@Controller
public class StatsController {
	private static Logger logger = LoggerFactory.getLogger(StatsController.class);

	@Autowired
	private MongoService mongoService;

	@RequestMapping(value = "/admin/stats", method = RequestMethod.GET)
	public ModelAndView stats() {
		logger.debug("StatsController:[stats] Passing through...");

		Set<String> collections =
			mongoService.getCollections();

		ModelAndView modelAndView = new ModelAndView("/admin/stats/stats");
		modelAndView.addObject("collections", collections);

		return modelAndView;
	}

	@RequestMapping(value = "/admin/stats/{collection}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("collection") String collection) {
		logger.debug("StatsController:[detail] Passing through...");

		MongoStats stats =
			mongoService.stats(collection);

		ModelAndView modelAndView = new ModelAndView("/admin/stats/collection");
		modelAndView.addObject("stats", stats);

		return modelAndView;
	}

}
