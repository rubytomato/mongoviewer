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

<title><spring:message code="index.title"/></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container top_start_point">

		<header class="header">
			<h3><spring:message code="admin.title"/></h3>
		</header>

		<div class="row-fluid">
			<div class="span12 well">
				xxx
			</div>
		</div>

		<div class="row-fluid">
			<div class="span3 well">
				<a href="${pageContext.request.contextPath}/admin/initdata" class="btn btn-large btn-inverse">
					<i class="icon-white icon-star"></i>&nbsp;データの初期化
				</a>
			</div>
			<div class="span3 well">
				<a href="${pageContext.request.contextPath}/admin/jmx" class="btn btn-large btn-primary">
					<i class="icon-white icon-star"></i>&nbsp;JMX
				</a>
			</div>
			<div class="span3 well">
				<a href="${pageContext.request.contextPath}/admin/stats" class="btn btn-large btn-primary">
					<i class="icon-white icon-star"></i>&nbsp;STATS
				</a>
			</div>
			<div class="span3 well">
				xxx
			</div>
		</div>

		<div class="row-fluid">
			<div class="span2 well">
				xxx
			</div>
			<div class="span2 well">
				xxx
			</div>
			<div class="span2 well">
				xxx
			</div>
			<div class="span2 well">
				xxx
			</div>
			<div class="span2 well">
				xxx
			</div>
			<div class="span2 well">
				xxx
			</div>
		</div>

		<div id="push"></div>
	</div> <!-- /container -->

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>
