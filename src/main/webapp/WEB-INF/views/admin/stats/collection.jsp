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
<title><spring:message code="admin.stats.title" /></title>
</head>
<body>

<div id="wrap">

    <%@ include file ="/WEB-INF/jsp/navi.jsp" %>

    <div class="container-fluid top_start_point">

        <header class="header">
            <h2><spring:message code="admin.stats.title" />&nbsp;<small><spring:message code="admin.stats.desc"/></small></h2>
        </header>

		<div class="row-fluid">
			<h2>collection stats</h2>
			<c:if test="${not empty stats}">
				<table class="table table-borderd">
					<thead>
						<tr>
							<th>name</th>
							<th>value</th>
							<th>.</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								serverUsed
							</td>
							<td>
								${stats.serverUsed}
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td>
								ns
							</td>
							<td>
								${stats.ns}
							</td>
							<td>
								The namespace of the current collection, which follows the format [database].[collection]
							</td>
						</tr>
						<tr>
							<td>
								count
							</td>
							<td>
								${stats.count}
							</td>
							<td>
								The number of objects or documents in this collection.
							</td>
						</tr>
						<tr>
							<td>
								size
							</td>
							<td>
								${stats.size}
							</td>
							<td>
								The size of the data stored in this collection. This value does not include the size of any indexes associated with the collection, which the totalIndexSize field reports.
								The scale argument affects this value.
							</td>
						</tr>
						<tr>
							<td>
								avgObjSize
							</td>
							<td>
								${stats.avgObjSize}
							</td>
							<td>
								The average size of an object in the collection. The scale argument affects this value.
							</td>
						</tr>
						<tr>
							<td>
								storageSize
							</td>
							<td>
								${stats.storageSize}
							</td>
							<td>
								The total amount of storage allocated to this collection for document storage. The scale argument affects this value. The storageSize does not decrease as you remove or shrink documents.
							</td>
						</tr>
						<tr>
							<td>
								numExtents
							</td>
							<td>
								${stats.numExtents}
							</td>
							<td>
								The total number of contiguously allocated data file regions.
							</td>
						</tr>
						<tr>
							<td>
								nindexes
							</td>
							<td>
								${stats.nindexes}
							</td>
							<td>
								The number of indexes on the collection. All collections have at least one index on the _id field.
								Changed in version 2.2: Before 2.2, capped collections did not necessarily have an index on the _id field, and some capped collections created with pre-2.2 versions of mongod may not have an _id index.
							</td>
						</tr>
						<tr>
							<td>
								lastExtentSize
							</td>
							<td>
								${stats.lastExtentSize}
							</td>
							<td>
								The size of the last extent allocated. The scale argument affects this value.
							</td>
						</tr>
						<tr>
							<td>
								paddingFactor
							</td>
							<td>
								${stats.paddingFactor}
							</td>
							<td>
								The amount of space added to the end of each document at insert time. The document padding provides a small amount of extra space on disk to allow a document to grow slightly without needing to move the document. mongod automatically calculates this padding factor
							</td>
						</tr>
						<tr>
							<td>
								systemFlags<br>
								<small>New in version 2.2.</small>
							</td>
							<td>
								${stats.systemFlags}
							</td>
							<td>
								Reports the flags on this collection that reflect internal server options. Typically this value is 1 and reflects the existence of an index on the _id field.
							</td>
						</tr>
						<tr>
							<td>
								userFlags<br>
								<small>New in version 2.2.</small>
							</td>
							<td>
								${stats.userFlags}
							</td>
							<td>
								Reports the flags on this collection set by the user. In version 2.2 the only user flag is usePowerOf2Sizes. If usePowerOf2Sizes is enabled, userFlags will be set to 1, otherwise userFlags will be 0.
							</td>
						</tr>
						<tr>
							<td>
								totalIndexSize
							</td>
							<td>
								${stats.totalIndexSize}
							</td>
							<td>
								The total size of all indexes. The scale argument affects this value.
							</td>
						</tr>
						<tr>
							<td>
								ok
							</td>
							<td>
								${stats.ok}
							</td>
							<td>
							</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>

		<div id="push"></div>
    </div>

</div>

<%@ include file ="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>