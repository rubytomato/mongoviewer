package com.example.mongoviewer.calendar;

import java.io.Serializable;
import java.util.List;

public class MonthBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193653061811201772L;

	private List<WeekBean> month;

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

}
