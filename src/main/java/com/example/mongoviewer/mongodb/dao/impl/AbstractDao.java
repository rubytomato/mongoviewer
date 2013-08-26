package com.example.mongoviewer.mongodb.dao.impl;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.dao.MongoDao;
import com.example.mongoviewer.mongodb.utils.MongoService;
import com.mongodb.WriteResult;

@Repository
public abstract class AbstractDao<T> implements MongoDao<T> {
	private static Logger logger = LoggerFactory.getLogger(AbstractDao.class);

	@Autowired
	private MongoTemplate template;

	@Autowired
	private MongoService service;

	protected long doCount(final String collection, final Query query) {
		logger.debug("doCount : " + query.toString());
		return service.countDocuments(collection, query);
	}

	protected long doCount(final String collection) {
		return service.countDocuments(collection);
	}

	protected T doFindOne(Query query, Class<T> clazz) {
		logger.debug("doFindOne : " + query.toString());
		return template.findOne(query, clazz);
	}

	protected List<T> doFind(Query query, Class<T> clazz) {
		logger.debug("doFind : " + query.toString());
		return template.find(query, clazz);
	}

	protected List<T> doFindAll(Class<T> clazz) {
		return template.findAll(clazz);
	}

	protected int doUpsert(Query query, Update update, Class<T> clazz) {
		logger.debug("doUpsert : " + query.toString());
		WriteResult wr = template.upsert(query, update, clazz);
		return wr.getN();
	}

	protected void doRemove(Query query, Class<T> clazz) {
		logger.debug("doRemove : " + query.toString());
		template.remove(query, clazz);
	}

	protected Criteria makeCriteriaById(String id) {
		return Criteria.where("id").is(id);
	}

	protected Criteria makeCriteriaRegex(Criteria criteria, String field, String param) {
		if (criteria == null) {
			criteria = Criteria.where(field).regex(param,"i");
		} else {
			criteria.and(field).regex(param,"i");
		}
		return criteria;
	}

	protected Criteria makeCriteria(Criteria criteria, String field, Object param) {
		if (criteria == null) {
			criteria = Criteria.where(field).is(param);
		} else {
			criteria.and(field).is(param);
		}
		return criteria;
	}

	protected Criteria makeWhere(String name) {
		return Criteria.where(name);
	}

	protected Criteria makeWhere(String name, Object param) {
		return Criteria.where(name).is(param);
	}

	protected int calcSkipNum(int page) {
		return (page - 1) * Paging.PAGE_LIMIT;
	}

	abstract protected Criteria makeCriteriaByPk(T model);

	abstract protected Criteria makeCriteria(T model);

	abstract protected Criteria makeCriteria(T model, Date from, Date to);

	abstract protected Update makeAllUpdate(T model);

}
