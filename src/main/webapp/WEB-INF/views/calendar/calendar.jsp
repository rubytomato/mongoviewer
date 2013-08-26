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
				<form class="form-inline" action="${pageContext.request.contextPath}/calendar" method="get">
					<input type="text" class="input-small" placeholder="customerNumber" name="customerNumber" value="${customerNumber}">

					<div id="dp1" class="input-append date" data-date="${target}" data-date-format="yyyy-mm-dd">
					<input type="text" class="input-small" placeholder="target" name="target" size="16" value="${target}" />
					<span class="add-on">
						<i class="icon-th"></i>
					</span>
					</div>

					<button type="submit" class="btn">search</button>
				</form>
			</div>
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
			//checkout.datepicker('update', now);
		} else {
			console.log("y");
		}
	}).on('changeMonth', function(ev) {
		console.log("changeMonth");
		console.log(ev);
	});

	checkout.datepicker('setStartDate', '2011-01-01');
	checkout.datepicker('setEndDate', '2014-12-31');
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
			<div class="span3 well">
				<p>customer</p>
				<c:if test="${not empty customer}">
				<table>
					<thead>
						<tr>
							<th></th>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>customer Number</th>
							<td>${customer.customerNumber}</td>
						</tr>
						<tr>
							<th>customer Name</th>
							<td>${customer.customerName}</td>
						</tr>
						<tr>
							<th>contact Last Name</th>
							<td>${customer.contactLastName}</td>
						</tr>
						<tr>
							<th>contact First Name</th>
							<td>${customer.contactFirstName}</td>
						</tr>
						<tr>
							<th>phone</th>
							<td>${customer.phone}</td>
						</tr>
						<tr>
							<th>address Line1</th>
							<td>${customer.addressLine1}</td>
						</tr>
						<tr>
							<th>address Line2</th>
							<td>${customer.addressLine2}</td>
						</tr>
						<tr>
							<th>city</th>
							<td>${customer.city}</td>
						</tr>
						<tr>
							<th>state</th>
							<td>${customer.state}</td>
						</tr>
						<tr>
							<th>postal Code</th>
							<td>${customer.postalCode}</td>
						</tr>
						<tr>
							<th>country</th>
							<td>${customer.country}</td>
						</tr>
						<tr>
							<th>sales Rep Employee Number</th>
							<td>${customer.salesRepEmployeeNumber}</td>
						</tr>
						<tr>
							<th>credit Limit</th>
							<td>${customer.creditLimit}</td>
						</tr>
					</tbody>
				</table>
				</c:if>
			</div>
			<div class="span9 well">
				<ul class="pager">
					<li class="previous">
						<a href="${pageContext.request.contextPath}${month.prev}">&larr; Older</a>
					</li>
					<li class="next">
						<a href="${pageContext.request.contextPath}${month.next}">Newer &rarr;</a>
					</li>
				</ul>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th colspan="2">-</th>
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
							<th colspan="2">
								${monthList.weekOfYear}
							</th>
							<c:forEach items="${monthList.week}" var="weekList" varStatus="idx2">
							<td>
								<fmt:formatDate value="${weekList.date}" pattern="yyyy/MM/dd" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th colspan="2">o</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${weekList.today}">
									(d)
								</c:if>
								<c:if test="${weekList.target}">
									(g)
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th rowspan="3">O</th>
							<th>order Number</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.order}">
									${weekList.order.orderNumber}
								</c:if>
								<c:if test="${empty weekList.order}">
									-
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th>order Date</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.order}">
									<fmt:formatDate value="${weekList.order.orderDate}" pattern="yyyy/MM/dd" />
								</c:if>
								<c:if test="${empty weekList.order}">
									-
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th>status</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.order}">
									${weekList.order.status}
								</c:if>
								<c:if test="${empty weekList.order}">
									-
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th rowspan="3">P</th>
							<th>check Number</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.payment}">
									${weekList.payment.checkNumber}
								</c:if>
								<c:if test="${empty weekList.payment}">
									-
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th>payment Date</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.payment}">
									<fmt:formatDate value="${weekList.payment.paymentDate}" pattern="yyyy/MM/dd" />
								</c:if>
								<c:if test="${empty weekList.payment}">
									-
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<th>amount</th>
							<c:forEach items="${monthList.week}" var="weekList">
							<td>
								<c:if test="${not empty weekList.payment}">
									${weekList.payment.amount}
								</c:if>
								<c:if test="${empty weekList.payment}">
									-
								</c:if>
							</td>
							</c:forEach>
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