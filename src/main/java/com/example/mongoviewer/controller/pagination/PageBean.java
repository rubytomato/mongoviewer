package com.example.mongoviewer.controller.pagination;

import java.io.Serializable;

public class PageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634404931457668605L;

	private String numberOfPages;

	private String url;

	private boolean disable;

	public PageBean(String numberOfPages, String url, boolean disable) {
		super();
		this.numberOfPages = numberOfPages;
		this.url = url;
		this.disable = disable;
	}

	/**
	 * @return the numberOfPages
	 */
	public String getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(String numberOfPages) {
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

	/**
	 * @return the disable
	 */
	public boolean isDisable() {
		return disable;
	}

	/**
	 * @param disable the disable to set
	 */
	public void setDisable(boolean disable) {
		this.disable = disable;
	}

}
