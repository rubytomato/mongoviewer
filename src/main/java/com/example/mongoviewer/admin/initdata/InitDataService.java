package com.example.mongoviewer.admin.initdata;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.OrderDetails;
import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.collection.ProductLines;
import com.example.mongoviewer.mongodb.collection.Products;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.example.mongoviewer.utils.JsonLoader;

@Service
public class InitDataService {
	private static Logger logger = LoggerFactory.getLogger(InitDataService.class);

	private static final String RESOURCE_DIR = "classpath:json/init";

	private static final String CUSTOMERS		= RESOURCE_DIR + "/Customers/Customers.json";
	private static final String ORDERDETAILS	= RESOURCE_DIR + "/OrderDetails/OrderDetails.json";
	private static final String ORDERS			= RESOURCE_DIR + "/Orders/Orders.json";
	private static final String PAYMENTS		= RESOURCE_DIR + "/Payments/Payments.json";
	private static final String PRODUCTLINES	= RESOURCE_DIR + "/ProductLines/ProductLines.json";
	private static final String PRODUCTS		= RESOURCE_DIR + "/Products/Products.json";

	@Autowired
	private MongoService mongoService;

	@Qualifier(QualifierNames.DAO_CUSTOMERS)
	@Autowired
	private MongoDao<Customers> customersDao;

	@Qualifier(QualifierNames.DAO_ORDER_DETAILS)
	@Autowired
	private MongoDao<OrderDetails> orderDetailsDao;

	@Qualifier(QualifierNames.DAO_ORDERS)
	@Autowired
	private MongoDao<Orders> ordersDao;

	@Qualifier(QualifierNames.DAO_PAYMENTS)
	@Autowired
	private MongoDao<Payments> paymentsDao;

	@Qualifier(QualifierNames.DAO_PRODUCT_LINES)
	@Autowired
	private MongoDao<ProductLines> productLinesDao;

	@Qualifier(QualifierNames.DAO_PRODUCTS)
	@Autowired
	private MongoDao<Products> productsDao;

	@Async
	public void init() {
		logger.debug("init start");

		//コレクションの削除
		mongoService.collectionAllDrop();


		List<Customers> customersList =
			JsonLoader.multi(CUSTOMERS, Customers.class);

		List<OrderDetails> orderDetailsList =
			JsonLoader.multi(ORDERDETAILS, OrderDetails.class);

		List<Orders> ordersList =
			JsonLoader.multi(ORDERS, Orders.class);

		List<Payments> paymentsList =
			JsonLoader.multi(PAYMENTS, Payments.class);

		List<ProductLines> productLines =
			JsonLoader.multi(PRODUCTLINES, ProductLines.class);

		List<Products> products =
			JsonLoader.multi(PRODUCTS, Products.class);


		customersDao.upsert(customersList);

		orderDetailsDao.upsert(orderDetailsList);

		ordersDao.upsert(ordersList);

		paymentsDao.upsert(paymentsList);

		productLinesDao.upsert(productLines);

		productsDao.upsert(products);


		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.debug("init end");
	}

}
