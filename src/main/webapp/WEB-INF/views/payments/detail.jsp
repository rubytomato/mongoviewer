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
			<h3><spring:message code="payments.title" />&nbsp;<small><spring:message code="payments.desc" /></small></h3>
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
							<th>customer Number</th>
							<td>${detail.customerNumber}</td>
						</tr>
						<tr>
							<th>check Number</th>
							<td>${detail.checkNumber}</td>
						</tr>
						<tr>
							<th>payment Date</th>
							<td>
								<fmt:formatDate value="${detail.paymentDate}" pattern="yyyy/MM/dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>amount</th>
							<td>${detail.amount}</td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="span8 well">
			</div>
		</div>

		<div id="push"></div>
	</div>

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>