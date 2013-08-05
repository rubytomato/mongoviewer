package com.example.mongoviewer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.service.IService;


@Qualifier(QualifierNames.SERVICE_PAYMENTS)
@Service
public class PaymentsService implements IService<Payments> {
	private static Logger logger = LoggerFactory.getLogger(PaymentsService.class);

	@Qualifier(QualifierNames.DAO_PAYMENTS)
	@Autowired
	private MongoDao<Payments> dao;

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
	public long count(Payments searchCondition) {
		return dao.count(searchCondition);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#get(java.lang.String)
	 */
	@Override
	public Payments get(String id) {
		Payments model = 
			dao.findById(id);
		return model;
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.service.IService#find(java.lang.Object)
	 */
	@Override
	public Payments find(Payments searchCondition) {
		Payments model = 
			dao.findByPK(searchCondition);
		return model;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.service.Service#search(int, java.lang.Object)
	 */
	@Override
	public List<Payments> search(int page, Payments searchCondition) {
		logger.debug("search condition : " + searchCondition.toString());

		List<Payments> list =
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
	public int save(Payments model) {
		return dao.upsert(model);
	}

}
