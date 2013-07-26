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
<title><spring:message code="products.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="products.title" />&nbsp;<small><spring:message code="products.desc" /></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/products/search/1" method="get">
					<input type="text" class="input-small" placeholder="productCode" name="productCode" value="${searchCondition.productCode}">
					<input type="text" class="input-medium" placeholder="productName" name="productName" value="${searchCondition.productName}">
					<input type="text" class="input-small" placeholder="productLine" name="productLine" value="${searchCondition.productLine}">
					<input type="text" class="input-small" placeholder="productScale" name="productScale" value="${searchCondition.productScale}">
					<input type="text" class="input-medium" placeholder="productVendor" name="productVendor" value="${searchCondition.productVendor}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
			<hr>
		</div>

		<c:if test="${not empty searchResult}">

		<%@ include file ="/WEB-INF/jsp/paging.jsp" %>

		<div class="row-fluid">
			<div class="span12 well">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>product Code</th>
							<th>product Name</th>
							<th>product Line</th>
							<th>product Scale</th>
							<th>product Vendor</th>
							<th>quantity In Stock</th>
							<th>buy Price</th>
							<th>MSRP</th>
							<th>detail</th>
							<th>json</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td><c:out value="${list.productCode}"/></td>
							<td><c:out value="${list.productName}"/></td>
							<td><c:out value="${list.productLine}"/></td>
							<td><c:out value="${list.productScale}"/></td>
							<td><c:out value="${list.productVendor}"/></td>
							<td><c:out value="${list.quantityInStock}"/></td>
							<td><c:out value="${list.buyPrice}"/></td>
							<td><c:out value="${list.MSRP}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/products/detail/<c:out value="${list.id}"/>" class="btn">
									<i class="icon-edit"></i>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/products/json/<c:out value="${list.id}"/>" class="btn">
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
				<p>Showing ${paging.showingFrom} to ${paging.showingTo} of ${paging.resultCount} entries / total ${paging.totalCount} entries.</p>
			</div>
		</div>

		</c:if>

		<div id="push"></div>
	</div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>