package com.example.mongoviewer.dao.impl;

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

import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.dao.impl.PaymentsDao;
import com.example.mongoviewer.utils.JsonLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class PaymentsDaoTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR = "src/test/resources/json/Payments/";

	private static final String TEST01_DATA = RESOURCE_DIR + "data_payments_test01.json";
	private static final String TEST02_DATA = RESOURCE_DIR + "data_payment_test02.json";
	private static final String TEST03_DATA = RESOURCE_DIR + "data_payment_test03.json";

	@Autowired
	private PaymentsDao dao;

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

		List<Payments> list =
			JsonLoader.multi(TEST01_DATA, Payments.class);

		int n = dao.upsert(list);
		Assert.assertEquals(list.size(), n);

		for (Payments payment : list) {
			logger.debug(payment.toString());
		}

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Payments model = JsonLoader.single(TEST02_DATA, Payments.class);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Payments actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Payments model = JsonLoader.single(TEST03_DATA, Payments.class);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Payments actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

}
