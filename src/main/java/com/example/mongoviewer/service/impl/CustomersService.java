package com.example.mongoviewer.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;

@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
@Service
public class CustomersService implements IService<Customers> {
	private static Logger logger = LoggerFactory.getLogger(CustomersService.class);

	@Qualifier(QualifierNames.DAO_CUSTOMERS)
	@Autowired
	private MongoDao<Customers> dao;

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public long count(Customers model) {
		return dao.count(model);
	}

	@Override
	public Customers get(String id) {

		Customers customer = 
			dao.findById(id);

		return customer;
	}

	@Override
	public List<Customers> search(int page, Customers searchCondition) {

		logger.debug("search condition : " + searchCondition.toString());

		List<Customers> list =
			dao.list(page, searchCondition);

		if (list != null && !list.isEmpty()) {
			logger.debug("list size : " + list.size());
		} else {
			logger.debug("list is null");
		}

		return list;
	}

}
