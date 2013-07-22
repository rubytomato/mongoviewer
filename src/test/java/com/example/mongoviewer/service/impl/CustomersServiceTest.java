package com.example.mongoviewer.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class CustomersServiceTest {
	private static Logger logger = Logger.getLogger("TEST");

	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@Before
	public void setUp() {
		logger.debug("setUp");
	}

	@After
	public void tearDown() {
		logger.debug("tearDown");
	}

	@Test
	public void test01() {
		logger.debug("test01");

		long count = customersService.count();
		Assert.assertEquals(121L, count);

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Customers searchCondition = new Customers();
		searchCondition.setCountry("USA");

		long count = customersService.count(searchCondition);
		Assert.assertEquals(36L, count);

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Customers searchCondition = new Customers();
		searchCondition.setCountry("USA");

		List<Customers> list =
			customersService.search(1, searchCondition);

	}

}
