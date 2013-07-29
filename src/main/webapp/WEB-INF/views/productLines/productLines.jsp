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
<title><spring:message code="productLines.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="productLines.title" />&nbsp;<small><spring:message code="productLines.desc" /></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/productLines/search/1" method="get">
					<input type="text" class="input-small" placeholder="productLine" name="productLine" value="${searchCondition.productLine}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
			<hr>
		</div>

		<c:if test="${not empty searchResult}">

		<%@ include file ="/WEB-INF/views/includePage/paging.jsp" %>

		<div class="row-fluid">
			<div class="span12 well">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>productLine</th>
							<th>textDescription</th>
							<th>htmlDescription</th>
							<th>image</th>
							<th>detail</th>
							<th>json</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${searchResult}" var="list" varStatus="idx">
						<tr>
							<td><c:out value="${idx.index}"/></td>
							<td><c:out value="${list.productLine}"/></td>
							<td><c:out value="${list.textDescription}"/></td>
							<td><c:out value="${list.htmlDescription}"/></td>
							<td><c:out value="${list.image}"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/productLines/detail/<c:out value="${list.id}"/>" class="btn">
									<i class="icon-edit"></i>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/productLines/json/<c:out value="${list.id}"/>" class="btn">
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