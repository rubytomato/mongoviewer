package com.example.mongoviewer.mongodb.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongoviewer.mongodb.collection.ProductLines;
import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.example.mongoviewer.mongodb.constants.QualifierNames;

@Qualifier(QualifierNames.DAO_PRODUCT_LINES)
@Repository
public class ProductLinesDao extends AbstractDao<ProductLines> {
	private static Logger logger = LoggerFactory.getLogger(ProductLinesDao.class);

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count()
	 */
	@Override
	public long count() {
		return doCount(CollectionNames.ProductLines);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#count(java.lang.Object)
	 */
	@Override
	public long count(ProductLines model) {
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			return doCount(CollectionNames.ProductLines, query);
		} else {
			return doCount(CollectionNames.ProductLines);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#findById(java.lang.String)
	 */
	@Override
	public ProductLines findById(String id) {
		logger.debug("findById IN");
		Query query = new Query(makeCriteriaById(id));
		return doFindOne(query, ProductLines.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#find(java.lang.Object)
	 */
	@Override
	public ProductLines find(ProductLines model) {
		logger.debug("find IN");
		Query query = new Query(makeCriteria(model));
		return doFindOne(query, ProductLines.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(int, java.lang.Object)
	 */
	@Override
	public List<ProductLines> list(int page, ProductLines model) {
		logger.debug("list IN");
		Criteria criteria = makeCriteria(model);
		if (criteria != null) {
			Query query = new Query(criteria);
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, ProductLines.class);
		} else {
			Query query = new Query();
			query.skip(calcSkipNum(page)).limit(LIMIT);
			return doFind(query, ProductLines.class);
		}
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list(java.lang.Object)
	 */
	@Override
	public List<ProductLines> list(ProductLines model) {
		return list(1,model);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#list()
	 */
	@Override
	public List<ProductLines> list() {
		logger.debug("list IN");
		return doFindAll(ProductLines.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.lang.Object)
	 */
	@Override
	public int upsert(ProductLines model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		Update update = this.makeAllUpdate(model);
		return doUpsert(query, update, ProductLines.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#upsert(java.util.List)
	 */
	@Override
	public int upsert(List<ProductLines> list) {
		int result = 0;
		for (ProductLines productLine : list) {
			Query query = new Query(this.makeCriteriaByPk(productLine));
			Update update = this.makeAllUpdate(productLine);
			result += doUpsert(query, update, ProductLines.class);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.MongoDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(ProductLines model) {
		Query query = new Query(this.makeCriteriaByPk(model));
		doRemove(query, ProductLines.class);
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByPk(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteriaByPk(ProductLines model) {
		return Criteria.where("productLine").is(model.getProductLine());
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeCriteriaByAll(java.lang.Object)
	 */
	@Override
	protected Criteria makeCriteria(ProductLines model) {
		Criteria criteria = null;

		if (model.getProductLine() != null && model.getProductLine().length() > 0) {
			criteria = makeCriteria(criteria, "productLine", model.getProductLine());
		}

		return criteria;
	}

	/* (non-Javadoc)
	 * @see net.blogdns.gontata.mongodb.dao.AbstractDao#makeAllUpdate(java.lang.Object)
	 */
	@Override
	protected Update makeAllUpdate(ProductLines model) {
		Update update = new Update();

		update.set("productLine",		model.getProductLine());
		update.set("textDescription",	model.getTextDescription());
		update.set("htmlDescription",	model.getHtmlDescription());
		update.set("image",				model.getImage());

		return update;
	}

}
