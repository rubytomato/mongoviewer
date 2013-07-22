package com.example.mongoviewer.mongodb.utils;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.mongodb.utils.MongoStats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class MongoServiceTest {
	private static Logger logger = Logger.getLogger("TEST");

	@Autowired
	private MongoService service;

	@Before
	public void setUp() {
		logger.debug("setUp");
	}

	@After
	public void tearDown() {
		logger.debug("tearDown");
	}

	@Test
	public void test00() {
		logger.debug("test00");

		Criteria criteria = Criteria.where("country").is("USA");
		Query query = new Query(criteria);

		long count =
			service.countDocuments(CollectionNames.Customers, query);

		logger.debug("count = " + count);

		count =
			service.countDocuments(CollectionNames.Customers);

		logger.debug("count = " + count);

	}

	@Test
	public void test01() {
		logger.debug("test01");

		MongoStats stats =
			service.stats(CollectionNames.Customers);

		logger.debug(stats.toString());

	}

}
