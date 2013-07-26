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
			<h3><spring:message code="orders.title" />&nbsp;<small><spring:message code="orders.desc" /></small></h3>
        </header>

		<div class="row-fluid">
			<div class="span4 well">

				<table class="table table-hover">
					<thead>
						<tr>
							<th class="span4">field</th>
							<th class="span8">value</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>id</th>
							<td>${detail.id}</td>
						</tr>
						<tr>
							<th>order Number</th>
							<td>${detail.orderNumber}</td>
						</tr>
						<tr>
							<th>order Date</th>
							<td>
								<fmt:formatDate value="${detail.orderDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>required Date</th>
							<td>
								<fmt:formatDate value="${detail.requiredDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>shipped Date</th>
							<td>
								<fmt:formatDate value="${detail.shippedDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>status</th>
							<td>${detail.status}</td>
						</tr>
						<tr>
							<th>comments</th>
							<td>${detail.comments}</td>
						</tr>
						<tr>
							<th>customer Number</th>
							<td>${detail.customerNumber}</td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="span8 well">
				<c:if test="${not empty orderDetailList}">
				<table class="table table-striped">
					<caption>order details</caption>
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>order Number</th>
							<th>order Line Number</th>
							<th>product Code</th>
							<th>quantity Ordered</th>
							<th>priceEach</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderDetailList}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td><c:out value="${list.id}"/></td>
							<td><c:out value="${list.orderNumber}"/></td>
							<td><c:out value="${list.orderLineNumber}"/></td>
							<td><c:out value="${list.productCode}"/></td>
							<td><c:out value="${list.quantityOrdered}"/></td>
							<td><c:out value="${list.priceEach}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</c:if>

			</div>
		</div>

		<div id="push"></div>
	</div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>