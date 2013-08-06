package com.example.mongoviewer.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongoviewer.calendar.DateBean;
import com.example.mongoviewer.calendar.MonthBean;
import com.example.mongoviewer.calendar.WeekBean;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView top() {
		logger.debug("CalendarController:[top] Passing through...");

		Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.JAPAN);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMM/d EEE");
		logger.debug("sunday : " + sdf.format(cal.getTime()));

		MonthBean month = new MonthBean();
		List<WeekBean> weekList = new ArrayList<>();

		for (int j=0; j<5; j++) {
			WeekBean week = new WeekBean();
			week.setWeekOfYear(cal.get(Calendar.WEEK_OF_YEAR));
			List<DateBean> dateList = new ArrayList<>();
			for (int i=0; i<7; i++) {
				DateBean date = new DateBean();
				date.setDate(new Date(cal.getTime().getTime()));
				logger.debug("date : " + sdf.format(date.getDate()));
				dateList.add(date);
				cal.add(Calendar.DATE, 1);
			}
			week.setWeek(dateList);
			weekList.add(week);
		}
		month.setMonth(weekList);

		ModelAndView modelAndView = new ModelAndView("calendar/calendar");
		modelAndView.addObject("month", month);
		modelAndView.addObject(ACTIVE_NAVI, "calendar");

		return modelAndView;

	}

}
