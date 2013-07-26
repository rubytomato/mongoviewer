package com.example.mongoviewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IConstroller<T> {

	public ModelAndView top();

	public ModelAndView search(String page, T searchCondition, BindingResult result, HttpServletRequest request, HttpServletResponse response);

	public ModelAndView detail(String id);

	public ModelAndView edit(String id);

}
