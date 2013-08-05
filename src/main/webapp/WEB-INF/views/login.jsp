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

<title><spring:message code="login.title"/></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container top_start_point">

        <header class="header">
            <h1><spring:message code="login.title"/></h1>
            <p class="lead">新しいプロジェクトを始めるに早く使えてとてもシンプルなこのドキュメントを使ってください。<br> このHTMLの骨格を利用して作成してください。</p>
        </header>

		<div class="row-fluid">
			<div class="page-header span12">
				<h3>アーキテクチャー</h3>
				<form:form action="j_spring_security_check" method="post" cssClass="well form-inline">
					<input type="text" name="j_username" size="20">
					<input type="text" name="j_password" size="20">
					<input type="submit" value="ログイン" class="btn">
				</form:form>
			</div>
			<c:if test="${not empty param.login_error}">
			<div class="alert alert-error">
				${SPRING_SECURITY_LAST_EXCEPTION.message}
			</div>
			</c:if>
		</div>

		<div id="push"></div>
	</div> <!-- /container -->

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>