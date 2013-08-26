package com.example.mongoviewer.service.impl;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

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

import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.impl.OrdersDao;
import com.example.mongoviewer.service.IService;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class OrdersServiceTest {
	private static Logger logger = Logger.getLogger("TEST");

	@Tested
	@Qualifier(QualifierNames.SERVICE_ORDERS)
	@Autowired
	private IService<Orders> ordersService;

	@Mocked(stubOutClassInitialization = true)
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
	public void test01() throws Exception {
		logger.debug("test01 IN");

		//Record
		//モックに対して期待動作を宣言
		new NonStrictExpectations() {
			{
				dao.count();
				returns(1L, 2L, 3L);
			}
		};

		//テスト対象クラスの呼び出し
		Long count;
		count = ordersService.count();
		Assert.assertThat(count, is(1L));

		count = ordersService.count();
		Assert.assertThat(count, is(2L));

		count = ordersService.count();
		Assert.assertThat(count, is(3L));

		new Verifications() {
			{
				dao.count();
			}
		}; 

		logger.debug("test01 OUT");
	}

	@Test
	public void test02() throws Exception {
		logger.debug("test02 IN");

		//Record
		new Expectations() {
			{
				dao.count();
				returns(1L, 2L, 3L, 4L);
			}
		};

		Long count;
		count = ordersService.count();
		Assert.assertThat(count, is(1L));

		count = ordersService.count();
		Assert.assertThat(count, is(2L));

		count = ordersService.count();
		Assert.assertThat(count, is(3L));

		count = ordersService.count();
		Assert.assertThat(count, is(4L));

		new Verifications() {
			{
				dao.count();
			}
		};

		logger.debug("test02 OUT");
	}

	@Test
	public void test03() throws Exception {
		logger.debug("test03 IN");

		//Record
		new MockUp<OrdersDao>() {
			@Mock(invocations = 2)
			public long count() {
				return 100L;
			}
		}.getMockInstance();

		Long count;
		count = ordersService.count();
		Assert.assertThat(count, is(100L));

		count = ordersService.count();
		Assert.assertThat(count, is(100L));

		logger.debug("test03 OUT");
	}

}
