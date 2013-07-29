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
<title><spring:message code="admin.stats.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="admin.stats.title" />&nbsp;<small><spring:message code="admin.stats.desc"/></small></h2>
        </header>

		<div class="row-fluid">
			<h2>collections</h2>
			<c:if test="${not empty collections}">
				<table class="table table-borderd">
					<thead>
						<tr>
							<th>#</th>
							<th>name</th>
							<th>stats</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${collections}" var="value" varStatus="idx">
						<tr>
							<td>${idx.index}</td>
							<td>${value}</td>
							<td>
								<a href="${pageContext.request.contextPath}/admin/stats/<c:out value="${value}"/>" class="btn">
									confirm
								</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>