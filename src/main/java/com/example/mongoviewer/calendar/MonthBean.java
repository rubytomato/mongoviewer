package com.example.mongoviewer.calendar;

import java.io.Serializable;
import java.util.List;

public class MonthBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193653061811201772L;

	private List<WeekBean> month;

	private String prev;

	private String next;

	/**
	 * @return the month
	 */
	public List<WeekBean> getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(List<WeekBean> month) {
		this.month = month;
	}

	/**
	 * @return the prev
	 */
	public String getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(String prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}

}
