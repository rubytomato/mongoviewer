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
import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_PAYMENTS)
@Repository
public class PaymentsDao extends AbstractDao<Payments> {
	private static Logger logger = LoggerFactory.getLogger(PaymentsDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.Payments);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(Payments model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.Payments, query);
		} else {
			return doCount(CollectionNames.Payments);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public Payments findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, Payments.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public Payments find(Payments model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		return doFindOne(query, Payments.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<Payments> list(int page, Payments model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Payments.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Payments.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<Payments> list(Payments model) {
		return list(1,model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<Payments> list() {
		logger.debug("list IN");
		return doFindAll(Payments.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(Payments model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, Payments.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<Payments> list) {
		int result = 0;
		for (Payments payment : list) {
			Query query = new Query(this.makeCriteriaByPk(payment));
			Update update = this.makeAllUpdate(payment);
			result += doUpsert(query, update, Payments.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(Payments model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, Payments.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteriaByPk(Payments model) {
		return Criteria.where("customerNumber").is(model.getCustomerNumber()).and("checkNumber").is(model.getCheckNumber());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(Payments model) {
		Criteria criteria = null;

		if (model.getCustomerNumber() != null && model.getCustomerNumber() > 0) {
			criteria = makeCriteria(criteria, "customerNumber", model.getCustomerNumber());
		}
		if (model.getCheckNumber() != null && model.getCheckNumber().length() > 0) {
			criteria = makeCriteria(criteria, "checkNumber", model.getCheckNumber());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(Payments model) {
		Update update = new Update();

		update.set("customerNumber",model.getCustomerNumber());
		update.set("checkNumber",	model.getCheckNumber());
		update.set("paymentDate",	model.getPaymentDate());
		update.set("amount",		model.getAmount());

		return update;
	}

}
