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
<title>customers</title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/views/includePage/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h3><spring:message code="customers.title" />&nbsp;<small><spring:message code="customers.desc"/></small></h3>
        </header>

		<div class="row-fluid">
			<div class="span12">
			<form:form modelAttribute="customers" method="post" action="${pageContext.request.contextPath}/customers/save" cssClass="well form-horizontal">
				<form:hidden path="id"/>

				<div class="control-group">
					<form:label path="customerNumber" cssClass="control-label" for="customerNumber">Customer Number</form:label>
					<div class="controls">
						<form:input path="customerNumber" cssClass="span4"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="customerName" cssClass="control-label">Customer Name</form:label>
					<div class="controls">
						<form:input path="customerName" cssClass="span6"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="contactLastName" cssClass="control-label">Contact Last Name</form:label>
					<div class="controls">
						<form:input path="contactLastName"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="contactFirstName" cssClass="control-label">Contact First Name</form:label>
					<div class="controls">
						<form:input path="contactFirstName"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="phone" cssClass="control-label">phone</form:label>
					<div class="controls">
						<form:input path="phone"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="addressLine1" cssClass="control-label">address Line1</form:label>
					<div class="controls">
						<form:input path="addressLine1"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="addressLine2" cssClass="control-label">address Line2</form:label>
					<div class="controls">
						<form:input path="addressLine2"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="city" cssClass="control-label">city</form:label>
					<div class="controls">
						<form:input path="city"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="state" cssClass="control-label">state</form:label>
					<div class="controls">
						<form:input path="state"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="postalCode" cssClass="control-label">postal Code</form:label>
					<div class="controls">
						<form:input path="postalCode"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="country" cssClass="control-label">country</form:label>
					<div class="controls">
						<form:input path="country"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="salesRepEmployeeNumber" cssClass="control-label">sales Rep Employee Number</form:label>
					<div class="controls">
						<form:input path="salesRepEmployeeNumber"/>
					</div>
				</div>
				<div class="control-group">
					<form:label path="creditLimit" cssClass="control-label">credit Limit</form:label>
					<div class="controls">
						<form:input path="creditLimit"/>
					</div>
				</div>

				<input type="submit" value="送信" class="btn"/>
			</form:form>
			</div>
		</div>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/views/includePage/footer.jsp" %>

</body>
</html>