package com.example.mongoviewer.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.Products;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;

@Qualifier(QualifierNames.SERVICE_PRODUCTS)
@Service
public class ProductsService implements IService<Products> {
	private static Logger logger = LoggerFactory.getLogger(ProductsService.class);

	@Qualifier(QualifierNames.DAO_PRODUCTS)
	@Autowired
	private MongoDao<Products> dao;

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public long count(Products searchCondition) {
		return dao.count(searchCondition);
	}

	@Override
	public Products get(String id) {
		Products product = 
			dao.findById(id);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#find(java.lang.Object)
	 */
	@Override
	public Products find(Products searchCondition) {
		Products product = 
			dao.findByPK(searchCondition);
		return product;
	}

	@Override
	public List<Products> search(int page, Products searchCondition) {

		logger.debug("search condition : " + searchCondition.toString());

		List<Products> list =
			dao.list(page, searchCondition);

		if (list != null && !list.isEmpty()) {
			logger.debug("list size : " + list.size());
		} else {
			logger.debug("list is null");
		}

		return list;
	}

}
