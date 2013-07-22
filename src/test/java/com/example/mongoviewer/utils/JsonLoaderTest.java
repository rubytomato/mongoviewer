package com.example.mongoviewer.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.Orders;

public class JsonLoaderTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR_CUSTOMERS = "src/test/resources/json/Customers/";

	private static final String DATA_CUSTOMERS_TEST01 = RESOURCE_DIR_CUSTOMERS + "data_customers_test01.json";
	private static final String DATA_CUSTOMERS_TEST02 = RESOURCE_DIR_CUSTOMERS + "data_customer_test02.json";
	private static final String DATA_CUSTOMERS_TEST03 = RESOURCE_DIR_CUSTOMERS + "data_customer_test03.json";

	private static final String RESOURCE_DIR_ORDERS = "src/test/resources/json/Orders/";

	private static final String DATA_ORDERS_TEST04 = RESOURCE_DIR_ORDERS + "data_orders_test01.json";
	private static final String DATA_ORDERS_TEST05 = RESOURCE_DIR_ORDERS + "data_order_test02.json";
	private static final String DATA_ORDERS_TEST06 = RESOURCE_DIR_ORDERS + "data_order_test03.json";

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

		List<Customers> actual =
			JsonLoader.multi(DATA_CUSTOMERS_TEST01, Customers.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

		for (Customers model : actual) {
			logger.debug(model);
		}

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Customers actual =
			JsonLoader.single(DATA_CUSTOMERS_TEST02, Customers.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Customers actual =
			JsonLoader.single(DATA_CUSTOMERS_TEST03, Customers.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}

	@Test
	public void test04() {
		logger.debug("test04");

		List<Orders> actual =
			JsonLoader.multi(DATA_ORDERS_TEST04, Orders.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}

	@Test
	public void test05() {
		logger.debug("test05");

		Orders actual =
			JsonLoader.single(DATA_ORDERS_TEST05, Orders.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}

	@Test
	public void test06() {
		logger.debug("test06");

		Orders actual =
			JsonLoader.single(DATA_ORDERS_TEST06, Orders.class);
		Assert.assertNotNull(actual);

		logger.debug(actual.toString());

	}

}
