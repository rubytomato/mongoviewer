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
<title><spring:message code="customers.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="customers.title" />&nbsp;<small><spring:message code="customers.desc"/></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/customers/search/1" method="get">
					<input type="text" class="input-large" placeholder="customerNumber" name="customerNumber" value="${searchCondition.customerNumber}">
					<input type="text" class="input-medium" placeholder="customerName" name="customerName" value="${searchCondition.customerName}">
					<input type="text" class="input-small" placeholder="city" name="city" value="${searchCondition.city}">
					<input type="text" class="input-small" placeholder="country" name="country" value="${searchCondition.country}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
		</div>

		<c:if test="${not empty searchResult}">

		<%@ include file ="/WEB-INF/jsp/paging.jsp" %>

		<div class="row-fluid">
			<div class="span12 well">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>customer Number</th>
							<th>customer Name</th>
							<th>contactLast Name</th>
							<th>contactFirst Name</th>
							<th>city</th>
							<th>state</th>
							<th>postal Code</th>
							<th>country</th>
							<th>sales Rep Employee Number</th>
							<th>credit Limit</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td><c:out value="${list.customerNumber}"/></td>
							<td><c:out value="${list.customerName}"/></td>
							<td><c:out value="${list.contactLastName}"/></td>
							<td><c:out value="${list.contactFirstName}"/></td>
							<td><c:out value="${list.city}"/></td>
							<td><c:out value="${list.state}"/></td>
							<td><c:out value="${list.postalCode}"/></td>
							<td><c:out value="${list.country}"/></td>
							<td><c:out value="${list.salesRepEmployeeNumber}"/></td>
							<td><c:out value="${list.creditLimit}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/customers/detail/<c:out value="${list.id}"/>" class="btn btn-primary">
									<i class="icon-edit"></i>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/customers/json/<c:out value="${list.id}"/>" class="btn btn-primary">
									<i class="icon-download"></i>
								</a>
							</td>
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