package com.example.mongoviewer.mongodb.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_ORDERS)
@Repository
public class OrdersDao extends AbstractDao<Orders> {
	private static Logger logger = LoggerFactory.getLogger(OrdersDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.Orders);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(Orders model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.Orders, query);
		} else {
			return doCount(CollectionNames.Orders);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public Orders findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, Orders.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public Orders find(Orders model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		return doFindOne(query, Orders.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<Orders> list(int page, Orders model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, Orders.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, Orders.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<Orders> list(Orders model) {
		return list(1,model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<Orders> list() {
		logger.debug("list IN");
		return doFindAll(Orders.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(Orders model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, Orders.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<Orders> list) {
		logger.debug("upsert IN");
		int result = 0;
		for (Orders order : list) {
			Query query = new Query(this.makeCriteriaByPk(order));
			Update update = this.makeAllUpdate(order);
			result += doUpsert(query, update, Orders.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(Orders model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, Orders.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteriaByPk(Orders model) {
		return Criteria.where("orderNumber").is(model.getOrderNumber());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(Orders model) {
		Criteria criteria = null;

		if (model.getOrderNumber() != null && model.getOrderNumber() > 0L) {
			criteria = makeCriteria(criteria, "orderNumber", model.getOrderNumber());
		}
		if (model.getCustomerNumber() != null && model.getCustomerNumber() > 0L) {
			criteria = makeCriteria(criteria, "customerNumber", model.getCustomerNumber());
		}
		if (model.getStatus() != null && model.getStatus().length() > 0) {
			criteria = makeCriteria(criteria, "status", model.getStatus());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(Orders model) {
		Update update = new Update();

		update.set("orderNumber",	model.getOrderNumber());

		if (model.getOrderDate() == null) {
			update.unset("orderDate");
		} else {
			update.set("orderDate",		model.getOrderDate());
		}

		if (model.getRequiredDate() == null) {
			update.unset("requiredDate");
		} else {
			update.set("requiredDate",	model.getRequiredDate());
		}

		if (model.getShippedDate() == null) {
			update.unset("shippedDate");
		} else {
			update.set("shippedDate",	model.getShippedDate());
		}

		if (model.getStatus() == null) {
			update.unset("status");
		} else {
			update.set("status",		model.getStatus());
		}

		if (model.getComments() == null) {
			update.unset("comments");
		} else {
			update.set("comments",		model.getComments());
		}

		update.set("customerNumber",model.getCustomerNumber());

		return update;
	}

}
