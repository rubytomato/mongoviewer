package com.example.mongoviewer.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.calendar.DateBean;
import com.example.mongoviewer.calendar.MonthBean;
import com.example.mongoviewer.calendar.WeekBean;
import com.example.mongoviewer.mongodb.collection.Customers;
import com.example.mongoviewer.mongodb.collection.Orders;
import com.example.mongoviewer.mongodb.collection.Payments;
import com.example.mongoviewer.mongodb.constants.QualifierNames;
import com.example.mongoviewer.service.IService;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Qualifier(QualifierNames.SERVCIE_CUSTOMERS)
	@Autowired
	private IService<Customers> customersService;

	@Qualifier(QualifierNames.SERVICE_ORDERS)
	@Autowired
	private IService<Orders> ordersService;

	@Qualifier(QualifierNames.SERVICE_PAYMENTS)
	@Autowired
	private IService<Payments> paymentsService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView top(
			@RequestParam(value="target", required=false) String target,
			@RequestParam(value="customerNumber", required=false) String customerNumber) {
		logger.debug("CalendarController:[top] Passing through...");

		if (customerNumber != null) {
			logger.debug("customerNumber : " + customerNumber);
		}
		if (target != null) {
			logger.debug("target : " + target);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar today = Calendar.getInstance(TimeZone.getDefault(), Locale.JAPAN);
		today = DateUtils.truncate(today, Calendar.DATE);

		Calendar cal = null;

		if (target != null && target.length() > 0) {
			String tmp = target.replaceAll("-", "");
			cal = Calendar.getInstance();
			try {
				Date d = sdf.parse(tmp);
				cal.setTime(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//targetがnullの場合はtodayを使用する
			cal = (Calendar) today.clone();
		}
	
		Calendar targetCal = (Calendar) today.clone();

		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		logger.debug("sunday : " + sdf.format(cal.getTime()));


		Map<Date, Orders> orderMap = new HashMap<Date, Orders>();
		Map<Date, Payments> paymentMap = new HashMap<Date, Payments>();

		Customers customer = null;
		if (customerNumber != null && customerNumber.length() > 0) {

			Customers searchCondition = new Customers();
			searchCondition.setCustomerNumber(Long.valueOf(customerNumber));
			customer = customersService.find(searchCondition);

			if (customer != null) {
				Date from = new Date(cal.getTime().getTime());
				Date to = new Date(cal.getTime().getTime() + 3024000000L);

				Orders orders = new Orders();
				orders.setCustomerNumber(Long.valueOf(customerNumber));
				List<Orders> orderList =
					ordersService.search(1, orders, from, to);
				if (orderList != null && !orderList.isEmpty()) {
					logger.debug("order list size : " + orderList.size());
					for (Orders order : orderList) {
						orderMap.put(order.getOrderDate(), order);
					}
				} else {
					logger.debug("order list is null");
				}

				Payments payments = new Payments();
				payments.setCustomerNumber(Long.valueOf(customerNumber));
				List<Payments> paymentList =
					paymentsService.search(1, payments, from, to);
				if (paymentList != null && !paymentList.isEmpty()) {
					logger.debug("payment list size : " + paymentList.size());
					for (Payments payment : paymentList) {
						paymentMap.put(payment.getPaymentDate(), payment);
					}
				} else {
					logger.debug("payment list is null");
				}

			}

		}


		MonthBean month = new MonthBean();
		List<WeekBean> weekList = new ArrayList<>();

		String prev = "/calendar?customerNumber=";
		if (customerNumber != null) {
			prev = prev + customerNumber.toString();
		}
		prev = prev + "&target=" + sdf.format(new Date(cal.getTime().getTime() - 604800000L));
		month.setPrev(prev);

		String next = "/calendar?customerNumber=";
		if (customerNumber != null) {
			prev = next + customerNumber.toString();
		}
		next = next + "&target=" + sdf.format(new Date(cal.getTime().getTime() + 604800000L));
		month.setNext(next);

		//5週
		for (int j=0; j<5; j++) {

			WeekBean week = new WeekBean();
			week.setWeekOfYear(cal.get(Calendar.WEEK_OF_YEAR));

			//日ごとのデータを格納するlist
			List<DateBean> dateList = new ArrayList<>();

			for (int i=0; i<7; i++) {
				//日ごとのデータを格納するbean
				DateBean date = new DateBean();
				date.setDate(new Date(cal.getTime().getTime()));

				if (today.getTime().getTime() == cal.getTime().getTime()) {
					date.setToday(true);
				}

				if (targetCal.getTime().getTime() == cal.getTime().getTime()) {
					date.setTarget(true);
				}

				if (orderMap.containsKey(cal.getTime())) {
					Orders order = orderMap.get(cal.getTime());
					date.setOrder(order);
				}
				if (paymentMap.containsKey(cal.getTime())) {
					Payments payment = paymentMap.get(cal.getTime());
					date.setPayment(payment);
				}
				//logger.debug("date : " + sdf.format(date.getDate()));
				dateList.add(date);
				cal.add(Calendar.DATE, 1);
			}
			week.setWeek(dateList);
			weekList.add(week);

		}
		month.setMonth(weekList);

		ModelAndView modelAndView = new ModelAndView("calendar/calendar");
		modelAndView.addObject("month", month);
		modelAndView.addObject("customer", customer);
		modelAndView.addObject("target", target);
		modelAndView.addObject("customerNumber", customerNumber);
		modelAndView.addObject(ACTIVE_NAVI, "calendar");

		return modelAndView;

	}

}
