package com.example.mongoviewer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.OrderDetails;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;


@Qualifier(QualifierNames.SERVICE_ORDER_DETAILS)
@Service
public class OrderDetailsService implements IService<OrderDetails> {
	private static Logger logger = LoggerFactory.getLogger(OrderDetailsService.class);

	@Qualifier(QualifierNames.DAO_ORDER_DETAILS)
	@Autowired
	private MongoDao<OrderDetails> dao;

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.IService#count()
	 */
	@Override
	public long count() {
		return dao.count();
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.IService#count(java.lang.Object)
	 */
	@Override
	public long count(OrderDetails searchCondition) {
		return dao.count(searchCondition);
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#find(java.lang.Object)
	 */
	@Override
	public OrderDetails find(OrderDetails searchCondition) {
		OrderDetails orderDetails =
			dao.findByPK(searchCondition);
		return orderDetails;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.IService#get(java.lang.String)
	 */
	@Override
	public OrderDetails get(String id) {
		OrderDetails orderDetails = 
			dao.findById(id);
		return orderDetails;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.IService#search(int, java.lang.Object)
	 */
	@Override
	public List<OrderDetails> search(int page, OrderDetails searchCondition) {
		logger.debug("search condition : " + searchCondition.toString());

		List<OrderDetails> list =
			dao.list(page, searchCondition);

		if (list != null && !list.isEmpty()) {
			logger.debug("list size : " + list.size());
		} else {
			logger.debug("list is null");
		}

		return list;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#save(java.lang.Object)
	 */
	@Override
	public int save(OrderDetails model) {
		return dao.upsert(model);
	}

}
