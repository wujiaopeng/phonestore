<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/js/advanced-datatable/css/DT_bootstrap.css" />
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>

		<div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
          	<form class="form-inline" style="padding:20px" method="post">
			  <div class="form-group col-md-3">
			  	<label  style="font-size:16px;">名称：</label>
			    <div class="input-group">
			      <input type="text" name="queryGoodName" class="form-control" id="queryname" value="${queryGoodName }">
			    </div>
			  </div>
			  <div class="form-group col-md-3">
			  	<label  style="font-size:16px;">品牌：</label>
			  	<input type="hidden" id="querybrand" value="${queryBrand }">
			    <div class="input-group">
			      <select id="brand1" name="queryBrand" class="form-control">
			      		<option value="">——请选择——</option>
			      </select>
			    </div>
			  </div>
			  <div class="form-group col-md-3">
			  	<label  style="font-size:16px;">状态：</label>
			    <div class="input-group">
			    <input type="hidden" id="querystate" value="${queryState }">
			      <select id="sta" name="queryState" class="form-control">
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
              <div class="row">

          	  </div>
              <hr>
              <table class="table  table-border table-bordered table-striped">
                <thead>
                  <tr>
                    <th>名称</th>
                    <th>价格</th>
                    <th>库存</th>
                    <th>品牌</th>
                    <th>颜色</th>
                    <th>内存</th>
                    <th>CPU</th>
                    <th>状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="goods" items="${goodsList }" varStatus="status">
					<tr>
						<td>${goods.goodName }</td>
						<td>${goods.price }元</td>
						<td>${goods.stock}台</td>
						<td>${goods.brandName }</td>
						<td>${goods.colorName }</td>
						<td>${goods.specs }G</td>
						<td>${goods.cpu }</td>
						<td id="goodState${goods.id }">${goods.goodStateName }</td>
	                    <td>
	                      <div class="btn-group">
			                <button class="btn btn-theme03" type="button">点击操作</button>
			                <button class="btn btn-theme03 dropdown-toggle" style="height:34px" aria-expanded="false" type="button" data-toggle="dropdown">
			                  <span class="caret"></span>
			                  <span class="sr-only">Toggle Dropdown</span>
			                  </button>
			                <ul class="dropdown-menu" role="menu">
			                  <li><a class="goodsView" gid="${goods.id }" href="javascript:;">查看</a></li>
			                  <li><a class="modifyGoods" gid="${goods.id }" href="javascript:;">修改</a></li>
			                  <li><a class="delGoods" gid="${goods.id }" gname="${goods.goodName }" href="javascript:;">删除</a></li>
			                  <li class="divider"></li>
			                  <c:if test="${goods.goodState==2 || goods.goodState==3 }">
			                  		<li><a class="saleSwichOpen" gname="${goods.goodName }"  saleSwitch="open" 
			                  		gid="${goods.id }"  gstate="1" href="javascript:;">上架</a></li>
			                  </c:if>
			                  <c:if test="${goods.goodState==1 }">
			                  		<li><a class="saleSwichClose" gname="${goods.goodName }"  saleSwitch="close" 
			                  		gid="${goods.id }"  gstate="2" href="javascript:;">下架</a></li>
			                  </c:if>
			                  
			                </ul>
			              </div>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/goodslist.js"></script>