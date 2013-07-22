<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target="nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="${pageContext.request.contextPath}"><spring:message code="navi.project.name"/></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="${pageContext.request.contextPath}/customers"><spring:message code="navi.menu.label_1"/></a></li>
              <li><a href="${pageContext.request.contextPath}/payments"><spring:message code="navi.menu.label_2"/></a></li>
              <li><a href="${pageContext.request.contextPath}/orders"><spring:message code="navi.menu.label_3"/></a></li>
              <li><a href="${pageContext.request.contextPath}/products"><spring:message code="navi.menu.label_4"/></a></li>
              <li><a href="${pageContext.request.contextPath}/productLines"><spring:message code="navi.menu.label_5"/></a></li>
              <li><a href="${pageContext.request.contextPath}/admin"><spring:message code="navi.menu.label_6"/></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
