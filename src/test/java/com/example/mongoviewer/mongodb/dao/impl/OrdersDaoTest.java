package com.example.mongoviewer.mongodb.dao.impl;

import java.util.List;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.dao.impl.OrdersDao;
import com.example.mongoviewer.utils.JsonLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class OrdersDaoTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR = "src/test/resources/json/Orders/";

	private static final String TEST01_DATA = RESOURCE_DIR + "data_orders_test01.json";
	private static final String TEST02_DATA = RESOURCE_DIR + "data_order_test02.json";
	private static final String TEST03_DATA = RESOURCE_DIR + "data_order_test03.json";

	@Autowired
	private OrdersDao dao;

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

		List<Orders> list =
			JsonLoader.multi(TEST01_DATA, Orders.class);
		Assert.assertNotNull(list);

		logger.debug(list.toString());

		dao.upsert(list);

		List<Orders> acutual = dao.list();

		for (Orders order : acutual) {
			logger.debug(order.toString());
		}

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Orders model = JsonLoader.single(TEST02_DATA, Orders.class);
		Assert.assertNotNull(model);

		int n = dao.upsert(model);

		Assert.assertEquals(1, n);

		Orders actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Orders model = JsonLoader.single(TEST03_DATA, Orders.class);
		Assert.assertNotNull(model);

		int n = dao.upsert(model);

		Assert.assertEquals(1, n);

		Orders actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

}
