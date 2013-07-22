package com.example.mongoviewer.mongodb.dao;

import java.util.List;

public interface MongoDao<T> {

	public long count();

	public long count(T model);

	public T findById(String id);

	public T find(T model);

	public List<T> list(int page, T model);

	public List<T> list(T model);

	public List<T> list();

	public int upsert(T model);

	public int upsert(List<T> list);

	public void remove(T model);

}
