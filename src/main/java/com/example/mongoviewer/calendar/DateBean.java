package com.example.mongoviewer.calendar;

import java.io.Serializable;
import java.util.Date;

public class DateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668981723571983617L;

	private Date date;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
