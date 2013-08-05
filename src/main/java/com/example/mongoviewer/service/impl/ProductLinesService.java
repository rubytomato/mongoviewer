package com.example.mongoviewer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.ProductLines;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;


@Qualifier(QualifierNames.SERVICE_PRODUCT_LINES)
@Service
public class ProductLinesService implements IService<ProductLines> {
	private static Logger logger = LoggerFactory.getLogger(ProductLinesService.class);

	@Qualifier(QualifierNames.DAO_PRODUCT_LINES)
	@Autowired
	private MongoDao<ProductLines> dao;

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#count()
	 */
	@Override
	public long count() {
		return dao.count();
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#count(java.lang.Object)
	 */
	@Override
	public long count(ProductLines searchCondition) {
		return dao.count(searchCondition);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#get(java.lang.String)
	 */
	@Override
	public ProductLines get(String id) {
		ProductLines model = 
			dao.findById(id);
		return model;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#find(java.lang.Object)
	 */
	@Override
	public ProductLines find(ProductLines searchCondition) {
		ProductLines model = 
			dao.findByPK(searchCondition);
		return model;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#search(int, java.lang.Object)
	 */
	@Override
	public List<ProductLines> search(int page, ProductLines searchCondition) {
		logger.debug("search condition : " + searchCondition.toString());

		List<ProductLines> list =
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
	public int save(ProductLines model) {
		return dao.upsert(model);
	}

}
