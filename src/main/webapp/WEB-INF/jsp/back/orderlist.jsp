<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/DT_bootstrap.css" />
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>

		<div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
          	<form class="form-inline" style="padding:20px" method="post">
			  <div class="form-group col-md-4">
			  	<label style="font-size:14px;">客户名称：</label>
			    <div class="input-group">
			      <input type="text" name="queryName" class="form-control" id="queryname" value="${queryName }">
			    </div>
			  </div>
			  <div class="form-group col-md-4">
			  	<label style="font-size:14px;">订单号：</label>
			    <div class="input-group">
			      <input type="number" name="queryOrderNo" class="form-control" value="${queryOrderNo }">
			    </div>
			  </div>
			  <div class="form-group col-md-3">
			  	<label  style="font-size:14px;">订单状态：</label>
			    <div class="input-group">
			    <input type="hidden" id="querystate" value="${queryOrderState }">
			      <select id="sta1" name="queryOrderState" class="form-control">
			      		<option value="">——请选择——</option>
			      		
			      </select>
			    </div>
			  </div>
			  <input type="hidden" name="pageIndex" value="1"/>
			  <button  id="search-submit" class="btn btn-success radius" type="submit">
					<i class="glyphicon glyphicon-search"></i> 搜索
			  </button>
			  <div></div>
			</form>	
			</div>
          </div>
        </div>
       <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <hr>
              <table class="table  table-border table-bordered table-striped">
                <thead>
                  <tr>
                    <th>客户名称</th>
                    <th>订单号</th>
                    <th>客户地址</th>
                    <th>联系电话</th>
                    <th>总额</th>
                    <th>订单状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="orders" items="${ordersList }" varStatus="status">
					<tr>
						<td>${orders.customerName }</td>
						<td>${orders.orderNo }</td>
						<td>${orders.address}</td>
						<td>${orders.phone}</td>
						<td>${orders.total}</td>
						<td>${orders.orderStateName}</td>
	                    <td>
	                      <a oid="${orders.id }" class="orders fa fa-eye" title="详情" href="javascript:;" style="text-decoration: none"></a>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/orderslist.js"></script>