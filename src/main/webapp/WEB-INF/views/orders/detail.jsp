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
            <h3><spring:message code="orders.title" /></h3>
            <p class="lead"><spring:message code="orders.desc" /></p>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<table class="table table-hover">
					<caption>Orders</caption>
					<thead>
						<tr>
							<th class="span2">1</th>
							<th class="span6">2</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>id</th>
							<td>${detail.id}</td>
						</tr>
						<tr>
							<th>orderNumber</th>
							<td>${detail.orderNumber}</td>
						</tr>
						<tr>
							<th>orderDate</th>
							<td>
								${detail.orderDate}<br>
								<fmt:formatDate value="${detail.orderDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>requiredDate</th>
							<td>
								${detail.requiredDate}<br>
								<fmt:formatDate value="${detail.requiredDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>shippedDate</th>
							<td>
								${detail.shippedDate}<br>
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
							<th>customerNumber</th>
							<td>${detail.customerNumber}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


		<c:if test="${not empty orderDetailList}">
		<div class="row-fluid">
			<div class="span12">

				<table class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>orderNumber</th>
							<th>productCode</th>
							<th>quantityOrdered</th>
							<th>priceEach</th>
							<th>orderLineNumber</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderDetailList}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td>
								<i class="icon-hand-up"></i>
								<a href="${pageContext.request.contextPath}/orderDetails/detail/<c:out value="${list.id}"/>">
									<c:out value="${list.id}"/>
								</a>
							</td>
							<td><c:out value="${list.orderNumber}"/></td>
							<td><c:out value="${list.productCode}"/></td>
							<td><c:out value="${list.quantityOrdered}"/></td>
							<td><c:out value="${list.priceEach}"/></td>
							<td><c:out value="${list.orderLineNumber}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		</c:if>

		<%@ include file ="/WEB-INF/jsp/footer.jsp" %>
	</div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>