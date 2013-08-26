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

<style type="text/css">
.no-space [class*="span"] {
    margin-left:0;
}
.no-space {
    margin-left:0;
}

.row-fluid [class*="NoGutter"] {
    margin-left: 0;
    background-color: #efefef;
}
.row-fluid .span1NoGutter {
    width: 8.33334%;
}
.row-fluid .span2NoGutter {
    width:16.66667%;
    margin-left:0;
}
.row-fluid .span4NoGutter {
    width:25%;
    margin-left:0;
}
.row-fluid .span3NoGutter {
    width:33.33333%;
    margin-left:0;
}

hr {
  -moz-border-bottom-colors: none;
  -moz-border-image: none;
  -moz-border-left-colors: none;
  -moz-border-right-colors: none;
  -moz-border-top-colors: none;
  border-color: #EEEEEE -moz-use-text-color #FFFFFF;
  border-style: solid none;
  border-width: 1px 0;
  margin: 18px 0;
}

</style>
<title><spring:message code="index.title"/></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h1><spring:message code="index.title"/> (h1:header)</h1>
            <p class="lead">新しいプロジェクトを始めるに早く使えてとてもシンプルなこのドキュメントを使ってください。<br> このHTMLの骨格を利用して作成してください。</p>
        </header>

        <div class="page-header">
            <h2>mongoviewer (h2:page-header)</h2>
            <p>一般的なユーザーインターフェイスコンポーネントと相互作用のためのシンプルで柔軟なHTML、CSS、およびJavascript</p>
        </div>

		<div class="row-fluid">
			<div class="span12 well">
				<h3>アーキテクチャー</h3>
				<ul>
					<li>Springframework Release 3.1.4</li>
					<li>MongoDB 2.4.4</li>
				</ul>
			</div>
		</div>

        <div class="row-fluid">
            <div class="span3 well">
                <h3>小見出し<small>(h3:span3)</small></h3>
                <p>サイドバーカラム</p>
            </div>

            <div class="span9 well">
				<h2>その他<small>(h2:span9)</small></h2>
                <section id="misc">
                    <div class="page-header">
						<p>section page-header</p>
                    </div>
                </section>
            </div>

        </div>

		<div class="row-fluid">
			<div class="span12 well">
				<h4>row span1</h4>
				<div class="row-fluid">
					<div class="span1 alert alert-info">
						n1
					</div>
					<div class="span1 alert alert-success">
						n2
					</div>
					<div class="span1 alert alert-error">
						n3
					</div>
					<div class="span1 alert alert-message">
						n4
					</div>
					<div class="span1 alert alert-block">
						n5
					</div>
					<div class="span1 alert">
						n6
					</div>
					<div class="span1 alert">
						n7
					</div>
					<div class="span1 alert">
						n8
					</div>
					<div class="span1 alert">
						n9
					</div>
					<div class="span1 alert">
						n10
					</div>
					<div class="span1 alert">
						n11
					</div>
					<div class="span1 alert">
						n12
					</div>
				</div>
				<div class="row-fluid">
					<div class="span2 alert">
						n1
					</div>
					<div class="span2 alert">
						n2
					</div>
					<div class="span2 alert">
						n3
					</div>
					<div class="span2 alert">
						n4
					</div>
					<div class="span2 alert">
						n5
					</div>
					<div class="span2 alert">
						n6
					</div>
				</div>
			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<h4>row span1</h4>
				<div class="row-fluid">
					<div class="span1 alert alert-info">
						n1
					</div>
					<div class="span1 alert alert-success">
						n2
					</div>
					<div class="span1 alert alert-error">
						n3
					</div>
					<div class="span1 alert alert-message">
						n4
					</div>
					<div class="span1 alert alert-block">
						n5
					</div>
					<div class="span1 alert">
						n6
					</div>
					<div class="span1 alert">
						n7
					</div>
					<div class="span1 alert">
						n8
					</div>
					<div class="span1 alert">
						n9
					</div>
					<div class="span1 alert">
						n10
					</div>
					<div class="span1 alert">
						n11
					</div>
					<div class="span1 alert">
						n12
					</div>
				</div>
				<div class="row-fluid">
					<div class="span2 alert">
						n1
					</div>
					<div class="span2 alert">
						n2
					</div>
					<div class="span2 alert">
						n3
					</div>
					<div class="span2 alert">
						n4
					</div>
					<div class="span2 alert">
						n5
					</div>
					<div class="span2 alert">
						n6
					</div>
				</div>
			</div>
		</div>

		<hr>

		<div class="row-fluid">
			<div class="span1NoGutter">
				n1
			</div>
			<div class="span1NoGutter">
				n2
			</div>
			<div class="span1NoGutter">
				n3
			</div>
			<div class="span1NoGutter">
				n4
			</div>
			<div class="span1NoGutter">
				n5
			</div>
			<div class="span1NoGutter">
				n6
			</div>
			<div class="span1NoGutter">
				n7
			</div>
			<div class="span1NoGutter">
				n8
			</div>
			<div class="span1NoGutter">
				n9
			</div>
			<div class="span1NoGutter">
				n10
			</div>
			<div class="span1NoGutter">
				n11
			</div>
			<div class="span1NoGutter">
				n12
			</div>
		</div>

		<div class="row-fluid show-grid">
			<div class="span2NoGutter">
				n1
			</div>
			<div class="span2NoGutter">
				n2
			</div>
			<div class="span2NoGutter">
				n3
			</div>
			<div class="span2NoGutter">
				n4
			</div>
			<div class="span2NoGutter">
				n5
			</div>
			<div class="span2NoGutter">
				n6
			</div>
		</div>

		<hr>

		<div class="row-fluid">
		<div class="span4">
			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
				<div class="unit grey bloat">
					<h3>herpity</h3>
					<p>herp herp herp</p>
				</div>
			</a>
		</div>

		<div class="span4">
			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
				<div class="unit grey bloat">
             		<h3>derpity</h3>
             		<p>derp derp derp</p>
            	</div>
            </a>
         </div>

		<div class="span4">
			<a href="#">
				<div class="unit grey bloat">
	             <h3>durrr</h3>
    	         <p>durrr durrr durr</p>
	            </div>
			</a>
		</div>
		</div>

		<div class="row-fluid">
			<div class="span12">

				<!-- start accord -->
				<!-- end accord -->

				<div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div id="collapseOne" class="accordion-body collapse">
							<div class="accordion-inner">
								<div class="expanded">
									<p>chicka chika</p>
								</div>
							</div>
						</div>
					</div>
					<div class="accordion-group">
						<div id="collapseTwo" class="accordion-body collapse">
							<div class="accordion-inner">
								<div class="expanded">
									<p>chewwwaawawaa</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row-fluid">
			<h4>table</h4>
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
		</div>

		<div id="push"></div>
	</div> <!-- /container -->

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>