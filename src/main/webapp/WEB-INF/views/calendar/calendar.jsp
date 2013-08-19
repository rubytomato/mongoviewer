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
    <link href="${pageContext.request.contextPath}/resources/bootstrap-datepicker/css/datepicker.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-datepicker/js/locales/bootstrap-datepicker.ja.js" type="text/javascript" charset="UTF-8"></script>
<title><spring:message code="calendar.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="calendar.title" />&nbsp;<small><spring:message code="calendar.desc"/></small></h2>
        </header>

		<div class="row-fluid">
			<div class="span12">
				<form class="form-inline" action="${pageContext.request.contextPath}/customers/search/1" method="get">
					<input type="text" class="input-large" placeholder="customerNumber" name="customerNumber" value="${searchCondition.customerNumber}">
					<input type="text" class="input-medium" placeholder="customerName" name="customerName" value="${searchCondition.customerName}">
					<input type="text" class="input-small" placeholder="city" name="city" value="${searchCondition.city}">
					<input type="text" class="input-small" placeholder="country" name="country" value="${searchCondition.country}">
					<button type="submit" class="btn">search</button>
				</form>
			</div>
		</div>

		<div id="dp1" class="input-append date" data-date="2013-09-01" data-date-format="yyyy-mm-dd">
			<input class="input-small" size="16" type="text" value="2013-09-01" />
			<span class="add-on">
				<i class="icon-th"></i>
			</span>
		</div>

<script type="text/javascript">
$(function(){

	window.prettyPrint && prettyPrint();

	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

	var checkout = $('#dp1').datepicker({
		format: 'yyyy-mm-dd',
		autoclose: true,
		language: 'ja',
		startView: 'month'
	}).on('changeDate', function(ev) {
		console.log("changeDate");
		console.log(ev);
		if (ev.date.valueOf() < now.valueOf()) {
			console.log("x");
			checkout.datepicker('update', now);
		} else {
			console.log("y");
		}
	}).on('changeMonth', function(ev) {
		console.log("changeMonth");
		console.log(ev);
	});

	checkout.datepicker('setStartDate', '2013-01-01');
	checkout.datepicker('setEndDate', '2013-12-31');
/*
	var checkout = $('#dp1').datepicker({
		format: 'yyyy-mm-dd',
		//autoclose: true,
		language: 'ja'
	}).on('changeDate', function(ev) {
		checkout.hide();
		//console.log(ev);
	}).data('datepicker');
*/
});
</script>

		<div class="row-fluid">
			<div class="span3">

			</div>
			<div class="span9">
				<ul class="pager">
					<li class="previous">
						<a href="#">&larr; Older</a>
					</li>
					<li class="next">
						<a href="#">Newer &rarr;</a>
					</li>
				</ul>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th>sun</th>
							<th>mon</th>
							<th>the</th>
							<th>wed</th>
							<th>thu</th>
							<th>fri</th>
							<th>sat</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty month}">
						<c:forEach items="${month.month}" var="monthList" varStatus="idx1">
						<tr>
							<th>
								${monthList.weekOfYear}
							</th>
							<c:forEach items="${monthList.week}" var="weekList" varStatus="idx2">
							<td>
								<fmt:formatDate value="${weekList.date}" pattern="yyyy/MM/dd" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th>x</th>
							<td>
								A
							</td>
							<td>
								B
							</td>
							<td>
								C
							</td>
							<td>
								D
							</td>
							<td>
								E
							</td>
							<td>
								F
							</td>
							<td>
								G
							</td>
						</tr>
						<tr>
							<th>x</th>
							<td>
								A
							</td>
							<td>
								B
							</td>
							<td>
								C
							</td>
							<td>
								D
							</td>
							<td>
								E
							</td>
							<td>
								F
							</td>
							<td>
								G
							</td>
						</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>