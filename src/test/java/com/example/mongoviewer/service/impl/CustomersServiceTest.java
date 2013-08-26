package com.example.mongoviewer.service.impl;

import java.util.ArrayList;
import java.util.List;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

import org.apache.log4j.Logger;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.impl.CustomersDao;
import com.example.mongoviewer.service.IService;
import com.example.mongoviewer.utils.JsonLoader;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-mongo-context.xml")
public class CustomersServiceTest {
	private static Logger logger = Logger.getLogger("TEST");

	private static final String RESOURCE_DIR = "src/test/resources/json/service/CustomersServiceTest/";

	private static final String TEST01_DATA = RESOURCE_DIR + "customers_test01.json";
	private static final String TEST02_DATA = RESOURCE_DIR + "customers_test02.json";
	private static final String TEST03_DATA = RESOURCE_DIR + "customers_test03.json";

	@Tested
	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@Mocked
	private CustomersDao dao;
	//private MongoDao<Customers> dao;

	//@Mocked
	//private MongoDao<Customers> dao;

	@BeforeClass
	public static void setUpClass() {
		logger.debug("setUpClass");
	}

	@AfterClass
	public static void tearDownClass() {
		logger.debug("tearDownClass");
	}

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
		new NonStrictExpectations() {
			{
				dao.count();
				times = 2;
				returns(999L,100L);
			}
		};

		long count;
		count = customersService.count();
		Assert.assertEquals(999L, count);
		count = customersService.count();
		Assert.assertEquals(100L, count);

		//Verify
		new Verifications() {
			{
				dao.count();
				times = 2;
			}
		};

		logger.debug("test01 OUT");
	}

	@Test
	public void test02() {
		logger.debug("test02 IN");

		//Record
		new NonStrictExpectations() {
			{
				dao.count(withAny(new Customers()));
				returns(123L);
			}
		};

		Customers searchCondition = new Customers();
		searchCondition.setCountry("USA");

		//Reply
		long count = customersService.count(searchCondition);
		Assert.assertEquals(123L, count);

		//Verify
		new Verifications() {
			{
				dao.count(withAny(new Customers()));
				times=1;
			}
		};

		logger.debug("test02 OUT");
	}

	@Test
	public void test03() {
		logger.debug("test03");

		//Record
		new Expectations() {
			List<Customers> list = new ArrayList<Customers>();
			{
				dao.list(1, withAny(new Customers()));
				returns(list);
			}
		};

		Customers searchCondition = new Customers();
		searchCondition.setCountry("USA");

		List<Customers> list =
			customersService.search(1, searchCondition);
		Assert.assertNotNull(list);

	}

	@Ignore("comment")
	@Test
	public void test04() {
		logger.debug("test04");

		//Record
		new MockUp<CustomersDao>() {
			@Mock(invocations = 2)
			public List<Customers> list(int page, Customers model) {
				List<Customers> list =
					JsonLoader.multi(TEST01_DATA, Customers.class);
				return list;
			}
			@Mock(invocations = 2)
			public Customers findByPK(Customers model) {
				Customers customer =
					JsonLoader.single(TEST02_DATA, Customers.class);
				return customer;
			}
/*
			@Mock
			public Customers find(Customers model) {
				return null;
			}
*/
		}.getMockInstance();


		Customers searchCondition = new Customers();
		searchCondition.setCountry("USA");

		//Reply
		List<Customers> list =
			customersService.search(1, searchCondition);
		Assert.assertNotNull(list);

		Assert.assertEquals(3, list.size());

		Customers customer =
			customersService.find(searchCondition);
		Assert.assertNotNull(customer);

	}

	@Ignore("comment")
	@Test
	public void test05() {
		logger.debug("test05 IN");

		//Record
		new MockUp<CustomersDao>() {
			@Mock(invocations = 1)
			public List<Customers> list(int page, Customers model) {
				List<Customers> list =
					JsonLoader.multi(TEST01_DATA, Customers.class);
				return list;
			}
			@Mock(invocations = 1)
			public Customers findByPK(Customers model) {
				Customers customer =
					JsonLoader.single(TEST02_DATA, Customers.class);
				return customer;
			}
			@Mock
			public Customers find(Customers model) {
				return null;
			}
		}.getMockInstance();



		//Reply


		//Verify
		new Verifications() {
			{
				Customers searchCondition = new Customers();
				searchCondition.setCountry("USA");

				List<Customers> list =
					customersService.search(1, searchCondition);
				Assert.assertNotNull(list);

				Assert.assertEquals(3, list.size());

				Customers customer =
					customersService.find(searchCondition);
				Assert.assertNotNull(customer);

			}
		};

		logger.debug("test05 OUT");
	}

	@Test
	public void test06() {
		logger.debug("test06 IN");

		Customers o1 = JsonLoader.single(TEST03_DATA, Customers.class);
		Customers o2 = JsonLoader.single(TEST03_DATA, Customers.class);

		Customers o3 = JsonLoader.single(TEST02_DATA, Customers.class);

		Assert.assertThat(o1, is(CustomersMatcher.customers(o2)));

		Assert.assertThat(o1, is(not(CustomersMatcher.customers(o3))));

		logger.debug("test06 OUT");
	}

}

class CustomersMatcher extends BaseMatcher<Customers> {

	private final Customers expected;
	private String field;
	private Object expectedValue;
	private Object actualValue;

	public static Matcher<Customers> customers(Customers expected) {
		return new CustomersMatcher(expected);
	}

	CustomersMatcher(Customers expected) {
		this.expected = expected;
	}

	@Override
	public boolean matches(Object actual) {
		if (expected == null) {
			return (actual == null);
		}
		if (!(actual instanceof Customers)) {
			return false;
		}
		Customers other = (Customers) actual;

		if (notEquals(expected.getCustomerNumber(), other.getCustomerNumber())) {
			field = "customerNumber";
			expectedValue = expected.getCustomerNumber();
			actualValue = other.getCustomerNumber();
			return false;
		}
		if (notEquals(expected.getCustomerName(), other.getCustomerName())) {
			field = "customerName";
			expectedValue = expected.getCustomerName();
			actualValue = other.getCustomerName();
			return false;
		}
		if (notEquals(expected.getContactFirstName(), other.getContactFirstName())) {
			field = "contactFirstName";
			expectedValue = expected.getContactFirstName();
			actualValue = other.getContactFirstName();
			return false;
		}
		if (notEquals(expected.getContactLastName(), other.getContactLastName())) {
			field = "contactLastName";
			expectedValue = expected.getContactLastName();
			actualValue = other.getContactLastName();
			return false;
		}
		if (notEquals(expected.getState(), other.getState())) {
			field = "state";
			expectedValue = expected.getState();
			actualValue = other.getState();
			return false;
		}
		if (notEquals(expected.getCity(), other.getCity())) {
			field = "city";
			expectedValue = expected.getCity();
			actualValue = other.getCity();
			return false;
		}
		if (notEquals(expected.getPostalCode(), other.getPostalCode())) {
			field = "postalCode";
			expectedValue = expected.getPostalCode();
			actualValue = other.getPostalCode();
			return false;
		}
		if (notEquals(expected.getAddressLine1(), other.getAddressLine1())) {
			field = "addressLine1";
			expectedValue = expected.getAddressLine1();
			actualValue = other.getAddressLine1();
			return false;
		}
		if (notEquals(expected.getAddressLine2(), other.getAddressLine2())) {
			field = "addressLine2";
			expectedValue = expected.getAddressLine2();
			actualValue = other.getAddressLine2();
			return false;
		}
		if (notEquals(expected.getCountry(), other.getCountry())) {
			field = "country";
			expectedValue = expected.getCountry();
			actualValue = other.getCountry();
			return false;
		}
		if (notEquals(expected.getPhone(), other.getPhone())) {
			field = "phone";
			expectedValue = expected.getPhone();
			actualValue = other.getPhone();
			return false;
		}
		if (notEquals(expected.getSalesRepEmployeeNumber(), other.getSalesRepEmployeeNumber())) {
			field = "salesRepEmployeeNumber";
			expectedValue = expected.getSalesRepEmployeeNumber();
			actualValue = other.getSalesRepEmployeeNumber();
			return false;
		}
		if (notEquals(expected.getCreditLimit(), other.getCreditLimit())) {
			field = "creditLimit";
			expectedValue = expected.getCreditLimit();
			actualValue = other.getCreditLimit();
			return false;
		}

		return true;
	}

	private boolean notEquals(Object obj, Object other) {
		if (obj == null) {
			return other != null;
		}
		return !obj.equals(other);
	}

	@Override
	public void describeTo(Description desc) {
		if (expected == null || field == null) {
			desc.appendValue(expected);
		} else {
			desc.appendText(field + " is ").appendValue(expectedValue).appendText(", but ").appendValue(actualValue);
		}
	}

}
