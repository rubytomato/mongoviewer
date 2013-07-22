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

		<c:if test="${not empty stats}">
		<div class="row-fluid">
			<div class="span12 well">
				<dl>
					<dt>serverUsed</dt>
					<dd>${stats.serverUsed}</dd>
					<dt>ns</dt>
					<dd>${stats.ns}</dd>
					<dt>count</dt>
					<dd>${stats.count}</dd>
					<dt>size</dt>
					<dd>${stats.size}</dd>
					<dt>avgObjSize</dt>
					<dd>${stats.avgObjSize}</dd>
					<dt>storageSize</dt>
					<dd>${stats.storageSize}</dd>
					<dt>numExtents</dt>
					<dd>${stats.numExtents}</dd>
					<dt>nindexes</dt>
					<dd>${stats.nindexes}</dd>
					<dt>lastExtentSize</dt>
					<dd>${stats.lastExtentSize}</dd>
					<dt>paddingFactor</dt>
					<dd>${stats.paddingFactor}</dd>
					<dt>systemFlags</dt>
					<dd>${stats.systemFlags}</dd>
					<dt>userFlags</dt>
					<dd>${stats.userFlags}</dd>
					<dt>totalIndexSize</dt>
					<dd>${stats.totalIndexSize}</dd>
					<dt>ok</dt>
					<dd>${stats.ok}</dd>
				</dl>
				<c:if test="${not empty stats.indexSizes}">
					<c:forEach items="${stats.indexSizes}" var="list" varStatus="idx">
					<dl>
						<dt>${list.key}</dt>
						<dd>${list.value}</dd>
					</dl>
					</c:forEach>
				</c:if>
			</div>
		</div>
		</c:if>

		<c:if test="${not empty searchResult}">

		<c:if test="${not empty paging}">
		<div class="row-fluid">
			<div class="span12">
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
				<div class="row-fluid">
					<div class="span4 well">
						sp4
					</div>
					<div class="span8 well">
						sp8
					</div>
				</div>
			</div>
		</div>
		</c:if>

		<div class="row-fluid">
			<div class="span12">

				<table class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>product Code</th>
							<th>product Name</th>
							<th>product Line</th>
							<th>product Scale</th>
							<th>product Vendor</th>
							<th>product Description</th>
							<th>quantity In Stock</th>
							<th>buy Price</th>
							<th>MSRP</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td>
								<i class="icon-hand-up"></i>
								<a href="${pageContext.request.contextPath}/products/detail/<c:out value="${list.id}"/>">
									<c:out value="${list.id}"/>
								</a>
							</td>
							<td><c:out value="${list.productCode}"/></td>
							<td><c:out value="${list.productName}"/></td>
							<td><c:out value="${list.productLine}"/></td>
							<td><c:out value="${list.productScale}"/></td>
							<td><c:out value="${list.productVendor}"/></td>
							<td><c:out value="${list.productDescription}"/></td>
							<td><c:out value="${list.quantityInStock}"/></td>
							<td><c:out value="${list.buyPrice}"/></td>
							<td><c:out value="${list.MSRP}"/></td>
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