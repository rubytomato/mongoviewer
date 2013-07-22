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

import com.example.mongoviewer.mongodb.collection.Products;
import com.example.mongoviewer.mongodb.dao.impl.ProductsDao;
import com.example.mongoviewer.utils.JsonLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class ProductsDaoTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR = "src/test/resources/json/Products/";

	private static final String TEST01_DATA = RESOURCE_DIR + "data_products_test01.json";
	private static final String TEST02_DATA = RESOURCE_DIR + "data_product_test02.json";
	private static final String TEST03_DATA = RESOURCE_DIR + "data_product_test03.json";

	@Autowired
	private ProductsDao dao;

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

		List<Products> list =
			JsonLoader.multi(TEST01_DATA, Products.class);

		int n = dao.upsert(list);
		Assert.assertEquals(list.size(), n);

		for (Products product : list) {
			logger.debug(product.toString());
		}

	}

	@Test
	public void test02() {
		logger.debug("test02");

		Products model = JsonLoader.single(TEST02_DATA, Products.class);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Products actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

	@Test
	public void test03() {
		logger.debug("test03");

		Products model = JsonLoader.single(TEST03_DATA, Products.class);

		int n = dao.upsert(model);
		Assert.assertEquals(1, n);

		Products actual = dao.find(model);
		Assert.assertNotNull(actual);

		dao.remove(model);

	}

}
