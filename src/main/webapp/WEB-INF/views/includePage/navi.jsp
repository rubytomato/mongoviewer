<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target="nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="${pageContext.request.contextPath}"><spring:message code="navi.project.brand"/></a>
          <div class="nav-collapse collapse">
            <ul class="nav">

              <li class="<c:if test="${activeNavi == 'customers'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/customers"><spring:message code="navi.menu.customers"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'payments'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/payments"><spring:message code="navi.menu.payments"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'orders'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/orders"><spring:message code="navi.menu.orders"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'products'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/products"><spring:message code="navi.menu.products"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'productlines'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/productLines"><spring:message code="navi.menu.productlines"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'calendar'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/calendar"><spring:message code="navi.menu.calendar"/></a>
              </li>

              <li class="<c:if test="${activeNavi == 'admin'}">active</c:if>">
                <a href="${pageContext.request.contextPath}/admin"><spring:message code="navi.menu.admin"/></a>
              </li>

            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
