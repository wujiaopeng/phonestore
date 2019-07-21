<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div class="row">
	<div class="col-sm-5">
		<div class="dataTables_info" id="datatable_info" role="status" aria-live="polite">
			共 ${param.totalCount} 条记录 ${param.currentPageNo}/${param.totalPageCount}页
		</div>
	</div>
	<div class="col-sm-7">
		<div class="dataTables_paginate paging_bootstrap pager" id="datatable_paginate">
			<ul>
				<c:choose>
					<c:when test="${param.currentPageNo == 1}">
						<li class="disabled"><a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a></li>
						<li><a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});">下一页</a></li>
					</c:when>
					<c:when test="${param.currentPageNo >= param.totalPageCount}">
						<li><a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a></li>
						<li class="disabled"><a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});">下一页</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a></li>
						<li><a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});">下一页</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script>
</html>