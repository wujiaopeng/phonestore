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
			      <input type="text" name="queryCustomerName" class="form-control" id="queryname" value="${queryCustomerName }">
			    </div>
			  </div>
			  <div class="form-group col-md-4">
			  	<label style="font-size:14px;">商品名称：</label>
			    <div class="input-group">
			      <input type="text" name="queryGoodsName" class="form-control" id="queryname" value="${queryGoodsName }">
			    </div>
			  </div>
			  <div class="form-group col-md-3">
			  	<label style="font-size:14px;">品牌：</label>
			    <div class="input-group">
			    <input type="hidden" id="querybrand" value="${queryBrand }">
			      <select id="brand1" name="queryBrand" class="form-control">
			      		<option value="">——请选择——</option>
			      		
			      </select>
			    </div>
			  </div>
			  <input type="hidden" name="pageIndex" value="1"/>
			  <button name="" id="search-submit" class="btn btn-success radius" type="submit">
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
                    <th>名称</th>
                    <th>价格</th>
                    <th>颜色</th>
                    <th>品牌</th>
                    <th>内存</th>
                    <th>数量</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="shoppingcar" items="${shoppingcarList }" varStatus="status">
					<tr>
						<td>${shoppingcar.customerName }</td>
						<td>${shoppingcar.goodName }</td>
						<td>${shoppingcar.price}</td>
						<td>${shoppingcar.colorName}</td>
						<td>${shoppingcar.brandName}</td>
						<td>${shoppingcar.specs}</td>
						<td>${shoppingcar.number}</td>
	                    <td>
	                    	<a sid="${shoppingcar.id }" class="shoppingcar fa fa-eye" title="详情" href="javascript:;" style="text-decoration: none"></a>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/shoppingcarlist.js"></script>