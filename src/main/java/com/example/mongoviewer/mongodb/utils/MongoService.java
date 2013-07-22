package com.example.mongoviewer.mongodb.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.mongoviewer.mongodb.constants.CollectionNames;
import com.mongodb.CommandResult;
import com.mongodb.DBCollection;

@Service
public class MongoService {
	private static Logger logger = LoggerFactory.getLogger(MongoService.class);

	@Autowired
	private MongoTemplate template;

	public long countDocuments(final String collection, final Query query) {

		String command =
			"{ " +
				"\"count\" : \"" + collection + "\"," +
				"\"query\" : " + query.getQueryObject().toString() +
			" }";

		logger.debug("command : " + command);

		CommandResult cr =
			template.executeCommand(command);

		logger.debug("command result : " + cr.toString());

		return cr.getLong("n");

	}

	public long countDocuments(final String collection) {

		String command =
			"{ " +
				"\"count\" : \"" + collection + "\"" +
			" }";

		logger.debug("command : " + command);

		CommandResult cr =
			template.executeCommand(command);

		logger.debug("command result : " + cr.toString());

		return cr.getLong("n");

	}

	public Set<String> getCollections() {
		Set<String> collections =
			template.getCollectionNames();
		if (!collections.isEmpty()) {
			Iterator<String> ite = collections.iterator();
			while (ite.hasNext()) {
				String name = ite.next();
				logger.debug("collection name : " + name);
			}
		}
		return collections;
	}

	public void collectionAllDrop() {
		template.dropCollection(CollectionNames.Customers);
		template.dropCollection(CollectionNames.OrderDetails);
		template.dropCollection(CollectionNames.Orders);
		template.dropCollection(CollectionNames.Payments);
		template.dropCollection(CollectionNames.ProductLines);
		template.dropCollection(CollectionNames.Products);
	}

	public MongoStats stats(final String collection) {

		DBCollection dbc =
			template.getCollection(collection);

		CommandResult cr =
			dbc.getStats();

		MongoStats stats = new MongoStats();

		stats.setServerUsed((String) cr.get("serverUsed"));
		stats.setNs((String) cr.get("ns"));
		stats.setCount((Integer) cr.get("count"));
		stats.setSize((Integer) cr.get("size"));
		stats.setAvgObjSize((Double) cr.get("avgObjSize"));
		stats.setStorageSize((Integer) cr.get("storageSize"));
		stats.setNumExtents((Integer) cr.get("numExtents"));
		stats.setNindexes((Integer) cr.get("nindexes"));
		stats.setLastExtentSize((Integer) cr.get("lastExtentSize"));
		stats.setPaddingFactor((Double) cr.get("paddingFactor"));
		stats.setSystemFlags((Integer) cr.get("systemFlags"));
		stats.setUserFlags((Integer) cr.get("userFlags"));
		stats.setTotalIndexSize((Integer) cr.get("totalIndexSize"));

		@SuppressWarnings("unchecked")
		Map<String, Object> idx = (Map<String,Object>)cr.get("indexSizes");
		if (idx != null && !idx.isEmpty()) {
			Map<String, Integer> iMap = new HashMap<>();
			for (Entry<String, Object> entry : idx.entrySet()) {
				iMap.put(entry.getKey(), (Integer) entry.getValue());
			}
			stats.setIndexSizes(iMap);
		}

		stats.setOk((Double) cr.get("ok"));

		return stats;

	}

}
