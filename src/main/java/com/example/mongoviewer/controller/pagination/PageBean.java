package com.example.mongoviewer.controller.pagination;

import java.io.Serializable;

public class PageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634404931457668605L;

	private int numberOfPages;

	private String url;

	public PageBean(int numberOfPages, String url) {
		super();
		this.numberOfPages = numberOfPages;
		this.url = url;
	}

	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
