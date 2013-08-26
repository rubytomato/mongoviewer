package com.example.mongoviewer.calendar;

import java.io.Serializable;
import java.util.Date;

import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.collection.Payments;

public class DateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668981723571983617L;

	private Date date;

	private boolean isToday = false;
	private boolean isTarget = false;

	private Orders order;
	private Payments payment;

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

	/**
	 * @return the isToday
	 */
	public boolean isToday() {
		return isToday;
	}

	/**
	 * @param isToday the isToday to set
	 */
	public void setToday(boolean isToday) {
		this.isToday = isToday;
	}

	/**
	 * @return the isTarget
	 */
	public boolean isTarget() {
		return isTarget;
	}

	/**
	 * @param isTarget the isTarget to set
	 */
	public void setTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}

	/**
	 * @return the order
	 */
	public Orders getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Orders order) {
		this.order = order;
	}

	/**
	 * @return the payment
	 */
	public Payments getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payments payment) {
		this.payment = payment;
	}

}
