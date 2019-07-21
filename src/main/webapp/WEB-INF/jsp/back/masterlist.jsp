<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/DT_bootstrap.css" />
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>

		<div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
          	<form class="form-inline" method="post" style="padding:20px">
			  <div class="form-group col-md-4 col-md-offset-1">
			  	<label for="name" style="font-size:14px;">姓名：</label>
			    <div class="input-group">
			      <input type="text" name="queryname" class="form-control" id="queryname" value="${queryname }">
			    </div>
			  </div>
			  <input type="hidden" name="pageIndex" value="1"/>
			  <button name="" id="search-submit" class="btn btn-success radius" type="submit">
					<i class="glyphicon glyphicon-search"></i> 搜索
			  </button>
			</form>	
			</div>
          </div>
        </div>
       <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <div class="row">
              	<div class="col-md-1 col-md-offset-1">
              		<button id="addMaster" class="btn btn-info"><i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加&nbsp;</button>
              	</div>
          	  </div>
              <hr>
              <table class="table  table-border table-bordered table-striped">
                <thead>
                  <tr>
                    <th>账号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>联系方式</th>
                    <th>地址</th>
                    <th>出生日期</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="master" items="${masterList }" varStatus="status">
					<tr>
						<td>${master.account }</td>
						<td>${master.name }</td>
						<td>${master.sex==1 ? '男':'女'}</td>
						<td>${master.age }</td>
						<td>${master.phone }</td>
						<td>${master.address }</td>
						<td><fmt:formatDate value="${master.birth }" pattern="yyyy-MM-dd"/></td>
	                    <td>
	                      <a mid="${master.id }" class="fa fa-pencil modifyMaster" title="修改" href="javascript:;" style="text-decoration: none"></a>
			  &nbsp;&nbsp;<a mid="${master.id }" name="${master.name }" class="fa fa-trash-o delMaster" title="删除" href="javascript:;" style="text-decoration: none"></a>
	                    </td>
	                 </tr>
	              </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		<c:import url="rollpage.jsp">
			<c:param name="totalCount" value="${totalCount}"/>
			<c:param name="currentPageNo" value="${currentPageNo}"/>
			<c:param name="totalPageCount" value="${totalPageCount}"/>
		</c:import>

<%@include file="/WEB-INF/jsp/back/common/footer.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/masterlist.js"></script>
