package com.example.mongoviewer.calendar;

import java.io.Serializable;
import java.util.List;

public class WeekBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7869030848858443024L;

	private int weekOfYear;

	private List<DateBean> week;

	/**
	 * @return the weekOfYear
	 */
	public int getWeekOfYear() {
		return weekOfYear;
	}

	/**
	 * @param weekOfYear the weekOfYear to set
	 */
	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	/**
	 * @return the week
	 */
	public List<DateBean> getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(List<DateBean> week) {
		this.week = week;
	}

}
