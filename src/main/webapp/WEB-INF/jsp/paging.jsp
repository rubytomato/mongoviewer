<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<c:if test="${not empty paging}">
		<div class="row-fluid">
			<div class="span12">
				<div class="pagination">
					<ul>
						<c:if test="${not empty paging.leftArrow}">
							<li><a href="${pageContext.request.contextPath}${paging.leftArrow}"><i class="icon icon-chevron-left"></i> prev</a></li>
						</c:if>
						<c:if test="${empty paging.leftArrow}">
							<li class="disabled"><a href="#"><i class="icon icon-chevron-left"></i> prev</a></li>
						</c:if>
						<c:forEach items="${paging.pageList}" var="list" varStatus="idx">
							<c:if test="${list.disable == true}">
								<li class="active"><a href="${pageContext.request.contextPath}${list.url}">${list.numberOfPages}</a></li>
							</c:if>
							<c:if test="${list.disable == false}">
								<li><a href="${pageContext.request.contextPath}${list.url}">${list.numberOfPages}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${not empty paging.rightArrow}">
							<li><a href="${pageContext.request.contextPath}${paging.rightArrow}">next <i class="icon icon-chevron-right"></i></a></li>
						</c:if>
						<c:if test="${empty paging.rightArrow}">
							<li class="disabled"><a href="#">next <i class="icon icon-chevron-right"></i></a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		</c:if>
