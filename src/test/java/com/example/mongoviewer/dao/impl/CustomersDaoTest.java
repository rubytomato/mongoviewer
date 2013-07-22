package com.example.mongoviewer.dao.impl;

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
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.utils.JsonLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class CustomersDaoTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR = "src/test/resources/json/Customers/";

	private static final String TEST01_DATA = RESOURCE_DIR + "data_customers_test01.json";
	private static final String TEST02_DATA = RESOURCE_DIR + "data_customer_test02.json";
	private static final String TEST03_DATA = RESOURCE_DIR + "data_customer_test03.json";

	@Qualifier(QualifierNames.DAO_CUSTOMERS)
	@Autowired
	private MongoDao<Customers> dao;

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

		List<Customers> list =
			JsonLoader.multi(TEST01_DATA, Customers.class);
		Assert.assertNotNull(list);

		dao.upsert(list);

		List<Customers> acutual = dao.list();

		for (Customers customer : acutual) {
			logger.debug(customer.toString());
		}

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Customers model = JsonLoader.single(TEST02_DATA, Customers.class);
		Assert.assertNotNull(model);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Customers actual = dao.find(model);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

		dao.remove(model);

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Customers model = JsonLoader.single(TEST03_DATA, Customers.class);
		Assert.assertNotNull(model);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Customers actual = dao.find(model);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

		dao.remove(model);

	}

	@Test
	public void test04() {
		logger.debug("test04");

		Customers model = null;
		Customers actual = null;

		model = new Customers();
		model.setCustomerNumber(119L);

		actual = dao.find(model);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

		actual = null;
		model = new Customers();
		model.setCustomerName("Havel & Zbyszek Co");

		actual = dao.find(model);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

		actual = null;
		model = new Customers();
		model.setCustomerNumber(128L);
		model.setCustomerName("Blauer See Auto, Co.");

		actual = dao.find(model);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}


}
