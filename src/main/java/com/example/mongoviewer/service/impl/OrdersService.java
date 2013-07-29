package com.example.mongoviewer.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;

@Qualifier(QualifierNames.SERVICE_ORDERS)
@Service
public class OrdersService implements IService<Orders> {
	private static Logger logger = LoggerFactory.getLogger(OrdersService.class);

	@Qualifier(QualifierNames.DAO_ORDERS)
	@Autowired
	private MongoDao<Orders> dao;

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public long count(Orders searchCondition) {
		return dao.count(searchCondition);
	}

	@Override
	public Orders get(String id) {
		Orders order = 
			dao.findById(id);
		return order;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#find(java.lang.Object)
	 */
	@Override
	public Orders find(Orders searchCondition) {
		Orders order = 
			dao.findByPK(searchCondition);
		return order;
	}

	@Override
	public List<Orders> search(int page, Orders searchCondition) {

		logger.debug("search condition : " + searchCondition.toString());

		List<Orders> list =
			dao.list(page, searchCondition);

		if (list != null && !list.isEmpty()) {
			logger.debug("list size : " + list.size());
		} else {
			logger.debug("list is null");
		}

		return list;
	}

}
