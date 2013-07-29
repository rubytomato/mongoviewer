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
<title><spring:message code="payments.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="payments.title" />&nbsp;<small><spring:message code="payments.desc" /></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/payments/search/1" method="get">
					<input type="text" class="input-medium" placeholder="customerNumber" name="customerNumber" value="${searchCondition.customerNumber}">
					<input type="text" class="input-medium" placeholder="checkNumber" name="checkNumber" value="${searchCondition.checkNumber}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
		</div>

		<c:if test="${not empty searchResult}">

		<%@ include file ="/WEB-INF/views/includePage/paging.jsp" %>

		<div class="row-fluid">
			<div class="span12 well">

				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>#</th>
							<th>customer Number</th>
							<th>check Number</th>
							<th>payment Date</th>
							<th>amount</th>
							<th>detail</th>
							<th>json</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td><c:out value="${list.customerNumber}"/></td>
							<td><c:out value="${list.checkNumber}"/></td>
							<td>
								<fmt:formatDate value="${list.paymentDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
							<td><c:out value="${list.amount}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/payments/detail/<c:out value="${list.id}"/>" class="btn">
									<i class="icon-edit"></i>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/payments/json/<c:out value="${list.id}"/>" class="btn">
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

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>