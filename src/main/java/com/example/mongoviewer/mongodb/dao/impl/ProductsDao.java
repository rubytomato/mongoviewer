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
import com.example.mongoviewer.mongodb.collection.Products;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_PRODUCTS)
@Repository
public class ProductsDao extends AbstractDao<Products> {
	private static Logger logger = LoggerFactory.getLogger(ProductsDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.Products);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(Products model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.Products, query);
		} else {
			return doCount(CollectionNames.Products);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public Products findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, Products.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public Products find(Products model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		return doFindOne(query, Products.class);
	}

	/* (non-Javadoc)
	 * @see com.example.mongoviewer.mongodb.dao.MongoDao#findByPK(java.lang.Object)
	 */
	@Override
	public Products findByPK(Products model) {
		logger.debug("findByPK IN");
		Query query = new Query(makeCriteriaByPk(model));
		return doFindOne(query, Products.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<Products> list(int page, Products model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Products.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(Paging.PAGE_LIMIT);
			return doFind(query, Products.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<Products> list(Products model) {
		return list(1,model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<Products> list() {
		logger.debug("list IN");
		return doFindAll(Products.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(Products model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, Products.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<Products> list) {
		int result = 0;
		for (Products product : list) {
			Query query = new Query(this.makeCriteriaByPk(product));
			Update update = this.makeAllUpdate(product);
			result += doUpsert(query, update, Products.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(Products model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, Products.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteriaByPk(Products model) {
		return Criteria.where("productCode").is(model.getProductCode());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(Products model) {
		Criteria criteria = null;

		if (model.getProductCode() != null && model.getProductCode().length() > 0) {
			criteria = makeCriteria(criteria, "productCode", model.getProductCode());
		}
		if (model.getProductLine() != null && model.getProductLine().length() > 0) {
			criteria = makeCriteria(criteria, "productLine", model.getProductLine());
		}
		if (model.getProductName() != null && model.getProductName().length() > 0) {
			criteria = makeCriteriaRegex(criteria, "productName", model.getProductName());
		}
		if (model.getProductScale() != null && model.getProductScale().length() > 0) {
			criteria = makeCriteria(criteria, "productScale", model.getProductScale());
		}
		if (model.getProductVendor() != null && model.getProductVendor().length() > 0) {
			criteria = makeCriteria(criteria, "productVendor", model.getProductVendor());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(Products model) {
		Update update = new Update();

		update.set("productName",		model.getProductName());
		update.set("productLine",		model.getProductLine());
		update.set("productScale",		model.getProductScale());
		update.set("productVendor",		model.getProductVendor());
		update.set("productDescription",model.getProductDescription());
		update.set("quantityInStock",	model.getQuantityInStock());
		update.set("buyPrice",			model.getBuyPrice());
		update.set("MSRP",				model.getMSRP());

		return update;
	}

}
