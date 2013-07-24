<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<title><spring:message code="orders.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="orders.title" />&nbsp;<small><spring:message code="orders.desc" /></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/orders/search/1" method="get">
					<input type="text" class="input-small" placeholder="orderNumber" name="orderNumber" value="${searchCondition.orderNumber}">
					<input type="text" class="input-small" placeholder="customerNumber" name="customerNumber" value="${searchCondition.customerNumber}">
					<input type="text" class="input-small" placeholder="status" name="status" value="${searchCondition.status}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
		</div>

		<c:if test="${not empty searchResult}">
		<div class="row-fluid">
			<div class="span12">

				<c:if test="${not empty paging}">
				<div class="pagination">
					<ul>
						<li class="disabled"><a href="#">&laquo;</a></li>
						<c:forEach items="${paging.pageList}" var="list" varStatus="idx">
							<c:if test="${paging.numberOfCurrentPage == (idx.index+1)}">
								<li class="active"><a href="${pageContext.request.contextPath}${list.url}">${list.numberOfPages}</a></li>
							</c:if>
							<c:if test="${paging.numberOfCurrentPage != (idx.index+1)}">
								<li><a href="${pageContext.request.contextPath}${list.url}">${list.numberOfPages}</a></li>
							</c:if>
						</c:forEach>
						<li class="disabled"><a href="#">&raquo;</a></li>
					</ul>
				</div>
				</c:if>

				<table class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>order Number</th>
							<th>order Date</th>
							<th>required Date</th>
							<th>shipped Date</th>
							<th>status</th>
							<th>comments</th>
							<th>customer Number</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/orders/detail/<c:out value="${list.id}"/>" class="btn">
									Detail
								</a>
								<a href="${pageContext.request.contextPath}/orders/json/<c:out value="${list.id}"/>" class="btn btn-success">
									json
								</a>
							</td>
							<td><c:out value="${list.orderNumber}"/></td>
							<td>
								<fmt:formatDate value="${list.orderDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
							<td>
								<fmt:formatDate value="${list.requiredDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
							<td>
								<fmt:formatDate value="${list.shippedDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
							<td><c:out value="${list.status}"/></td>
							<td><c:out value="${list.comments}"/></td>
							<td><c:out value="${list.customerNumber}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<p>Showing ${paging.showingFrom} to ${paging.showingTo} of ${paging.resultCount} results / total ${paging.totalCount} entries.</p>
			</div>
		</div>

		</c:if>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>