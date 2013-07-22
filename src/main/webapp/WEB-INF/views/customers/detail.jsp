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
<title>customers</title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h3><spring:message code="customers.title" /></h3>
            <p class="lead">customers collectionのメンテナンス</p>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="span1">1</th>
							<th class="span11">2</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>id</th>
							<td>${detail.id}</td>
						</tr>
						<tr>
							<th>customerNumber</th>
							<td>${detail.customerNumber}</td>
						</tr>
						<tr>
							<th>customerName</th>
							<td>${detail.customerName}</td>
						</tr>
						<tr>
							<th>contactLastName</th>
							<td>${detail.contactLastName}</td>
						</tr>
						<tr>
							<th>contactFirstName</th>
							<td>${detail.contactFirstName}</td>
						</tr>
						<tr>
							<th>phone</th>
							<td>${detail.phone}</td>
						</tr>
						<tr>
							<th>addressLine1</th>
							<td>${detail.addressLine1}</td>
						</tr>
						<tr>
							<th>addressLine2</th>
							<td>${detail.addressLine2}</td>
						</tr>
						<tr>
							<th>city</th>
							<td>${detail.city}</td>
						</tr>
						<tr>
							<th>state</th>
							<td>${detail.state}</td>
						</tr>
						<tr>
							<th>postalCode</th>
							<td>${detail.postalCode}</td>
						</tr>
						<tr>
							<th>country</th>
							<td>${detail.country}</td>
						</tr>
						<tr>
							<th>salesRepEmployeeNumber</th>
							<td>${detail.salesRepEmployeeNumber}</td>
						</tr>
						<tr>
							<th>creditLimit</th>
							<td>${detail.creditLimit}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<c:if test="${not empty orderList}">
		<div class="row-fluid">
			<div class="span12">

				<table class="table table-bordered table-striped table-condensed">
					<caption>order details</caption>
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>orderNumber</th>
							<th>orderDate</th>
							<th>requiredDate</th>
							<th>shippedDate</th>
							<th>status</th>
							<th>comments</th>
							<th>customerNumber</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderList}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td>
								<c:out value="${list.id}"/>
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
		</c:if>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>