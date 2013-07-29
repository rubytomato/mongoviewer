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

<title><spring:message code="index.title"/></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container top_start_point">

        <header class="header">
            <h1><spring:message code="index.title"/></h1>
            <p class="lead">新しいプロジェクトを始めるに早く使えてとてもシンプルなこのドキュメントを使ってください。<br> このHTMLの骨格を利用して作成してください。</p>
        </header>

        <div class="page-header">
            <h2>mongoviewer概要</h2>
            <p>一般的なユーザーインターフェイスコンポーネントと相互作用のためのシンプルで柔軟なHTML、CSS、およびJavascript</p>
        </div>

		<div class="row-fluid">
			<div class="span12">
				<h3>アーキテクチャー</h3>
				<ul>
					<li>Springframework Release 3.1.4</li>
				</ul>
			</div>
		</div>

        <div class="row-fluid">

            <div class="span3 well">

                <h3>小見出し<small>説明</small></h3>
                                   サイドバーカラム

            </div>

            <div class="span9 well">

                <section id="misc">
                    <div class="page-header">
                        <h2>その他<small>軽量のユーティリティ·コンポーネント</small></h2>
                    </div>
                </section>
            </div>

        </div>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th><th>title</th><th>action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                     <td>1</td><td>sample1</td><td><button type="submit" class="btn btn-success">Submit</button></td>
                </tr>
                <tr>
                     <td>2</td><td>sample2</td><td><button type="submit" class="btn btn-primary">Submit</button></td>
                </tr>
            </tbody>
        </table>

		<div id="push"></div>
	</div> <!-- /container -->

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>