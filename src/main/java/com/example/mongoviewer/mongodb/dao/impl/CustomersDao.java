package com.example.mongoviewer.mongodb.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongoviewer.controller.pagination.Paging;
import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_CUSTOMERS)
@Repository
public class CustomersDao extends AbstractDao<Customers> {
	private static Logger logger = LoggerFactory.getLogger(CustomersDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.Customers);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(Customers model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.Customers, query);
		} else {
			return doCount(CollectionNames.Customers);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public Customers findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, Customers.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public Customers find(Customers model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		logger.debug(query.toString());
		return doFindOne(query, Customers.class);
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.mongodb.dao.MongoDao#findByPK(java.lang.Object)
	 */
	@Override
	public Customers findByPK(Customers model) {
		logger.debug("findByPK IN");
		Query query = new Query(makeCriteriaByPk(model));
		logger.debug(query.toString());
		return doFindOne(query, Customers.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<Customers> list(int page, Customers model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Customers.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Customers.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<Customers> list(Customers model) {
		return list(1, model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<Customers> list() {
		logger.debug("list IN");
		return doFindAll(Customers.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(Customers model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, Customers.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<Customers> list) {
		int result=0;
		for (Customers customer : list) {
			Query query = new Query(this.makeCriteriaByPk(customer));
			Update update = this.makeAllUpdate(customer);
			result += doUpsert(query, update, Customers.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(Customers model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, Customers.class);
	}


	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk()
	 */
	@Override
	protected Criteria makeCriteriaByPk(Customers model) {
		return Criteria.where("customerNumber").is(model.getCustomerNumber());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(Customers model) {
		Criteria criteria = null;

		if (model.getCustomerNumber() != null && model.getCustomerNumber() > 0L) {
			criteria = makeCriteria(criteria, "customerNumber", model.getCustomerNumber());
		}
		if (model.getCustomerName() != null && model.getCustomerName().length() > 0) {
			criteria = makeCriteria(criteria, "customerName", model.getCustomerName());
		}
		if (model.getPhone() != null && model.getPhone().length() > 0) {
			criteria = makeCriteria(criteria, "phone", model.getPhone());
		}
		if (model.getCity() != null && model.getCity().length() > 0) {
			criteria = makeCriteria(criteria, "city", model.getCity());
		}
		if (model.getCountry() != null && model.getCountry().length() > 0) {
			criteria = makeCriteria(criteria, "country", model.getCountry());
		}
		if (model.getPostalCode() != null && model.getPostalCode().length() > 0) {
			criteria = makeCriteria(criteria, "postalCode", model.getPostalCode());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(Customers model) {
		Update update = new Update();

		update.set("customerName",			model.getCustomerName());
		update.set("contactLastName",		model.getContactLastName());
		update.set("contactFirstName",		model.getContactFirstName());
		update.set("phone",					model.getPhone());
		update.set("addressLine1",			model.getAddressLine1());
		update.set("addressLine2",			model.getAddressLine2());
		update.set("city",					model.getCity());
		update.set("state",					model.getState());
		update.set("postalCode",			model.getPostalCode());
		update.set("country",				model.getCountry());
		update.set("salesRepEmployeeNumber",model.getSalesRepEmployeeNumber());
		update.set("creditLimit",			model.getCreditLimit());

		return update;
	}

}
