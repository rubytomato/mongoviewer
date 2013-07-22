package com.example.mongoviewer.mongodb.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongoviewer.mongodb.collection.OrderDetails;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_ORDER_DETAILS)
@Repository
public class OrderDetailsDao extends AbstractDao<OrderDetails> {
	private static Logger logger = LoggerFactory.getLogger(OrderDetailsDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.OrderDetails);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(OrderDetails model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.OrderDetails, query);
		} else {
			return doCount(CollectionNames.OrderDetails);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public OrderDetails findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, OrderDetails.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public OrderDetails find(OrderDetails model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		return doFindOne(query, OrderDetails.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<OrderDetails> list(int page, OrderDetails model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, OrderDetails.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, OrderDetails.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<OrderDetails> list(OrderDetails model) {
		return list(1,model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<OrderDetails> list() {
		logger.debug("list IN");
		return doFindAll(OrderDetails.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(OrderDetails model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, OrderDetails.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<OrderDetails> list) {
		int result = 0;
		for (OrderDetails orderDetail : list) {
			Query query = new Query(this.makeCriteriaByPk(orderDetail));
			Update update = this.makeAllUpdate(orderDetail);
			result += doUpsert(query, update, OrderDetails.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(OrderDetails model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, OrderDetails.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteriaByPk(OrderDetails model) {
		return Criteria.where("orderNumber").is(model.getOrderNumber()).and("orderLineNumber").is(model.getOrderLineNumber());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(OrderDetails model) {
		Criteria criteria = null;

		if (model.getOrderNumber() != null && model.getOrderNumber() > 0L) {
			criteria = makeCriteria(criteria, "orderNumber", model.getOrderNumber());
		}
		if (model.getOrderLineNumber() != null && model.getOrderLineNumber() > 0) {
			criteria = makeCriteria(criteria, "orderLineNumber", model.getOrderLineNumber());
		}
		if (model.getProductCode() != null && model.getProductCode().length() > 0) {
			criteria = makeCriteria(criteria, "productCode", model.getProductCode());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(OrderDetails model) {
		Update update = new Update();

		update.set("orderNumber",		model.getOrderNumber());
		update.set("productCode",		model.getProductCode());
		update.set("quantityOrdered",	model.getQuantityOrdered());
		update.set("priceEach",			model.getPriceEach());
		update.set("customerNumber",	model.getOrderLineNumber());

		return update;
	}

}
