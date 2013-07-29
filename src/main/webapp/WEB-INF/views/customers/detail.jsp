<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/includePage/header.jsp" %>
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

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h3><spring:message code="customers.title" />&nbsp;<small><spring:message code="customers.desc"/></small></h3>
        </header>

		<div class="row-fluid">
			<div class="span4 well">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="span4"></th>
							<th class="span8"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>id</th>
							<td>${detail.id}</td>
						</tr>
						<tr>
							<th>customer Number</th>
							<td>${detail.customerNumber}</td>
						</tr>
						<tr>
							<th>customer Name</th>
							<td>${detail.customerName}</td>
						</tr>
						<tr>
							<th>contact Last Name</th>
							<td>${detail.contactLastName}</td>
						</tr>
						<tr>
							<th>contact First Name</th>
							<td>${detail.contactFirstName}</td>
						</tr>
						<tr>
							<th>phone</th>
							<td>${detail.phone}</td>
						</tr>
						<tr>
							<th>address Line1</th>
							<td>${detail.addressLine1}</td>
						</tr>
						<tr>
							<th>address Line2</th>
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
							<th>postal Code</th>
							<td>${detail.postalCode}</td>
						</tr>
						<tr>
							<th>country</th>
							<td>${detail.country}</td>
						</tr>
						<tr>
							<th>sales Rep Employee Number</th>
							<td>${detail.salesRepEmployeeNumber}</td>
						</tr>
						<tr>
							<th>credit Limit</th>
							<td>${detail.creditLimit}</td>
						</tr>
					</tbody>
				</table>

				<a href="${pageContext.request.contextPath}/customers/edit/<c:out value="${detail.id}"/>" class="btn btn-large btn-primary">
					Edit
				</a>

			</div>
			<div class="span8 well">

				<c:if test="${not empty orderList}">
				<table class="table table-striped">
					<caption>order list</caption>
					<thead>
						<tr>
							<th>#</th>
							<th>order Number</th>
							<th>order Date</th>
							<th>required Date</th>
							<th>shipped Date</th>
							<th>status</th>
							<th>customer Number</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderList}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
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
							<td><c:out value="${list.customerNumber}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/orders/detail/<c:out value="${list.id}"/>" class="btn btn-primary">
									Detail
								</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</c:if>

			</div>
		</div>

		<div class="row-fluid">
			<div class="span6 well">
				<h5>JSON&nbsp;<small>json pretty print</small></h5>
			<c:if test="${not empty json}">
			<textarea rows="10" class="span12">${json}</textarea>
			</c:if>
			</div>
			<div class="span6 well">
				<pre class="prettyprint linenums">${json}</pre>
			</div>
		</div>

		<div id="push"></div>
	</div>

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>