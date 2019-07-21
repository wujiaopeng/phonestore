<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>
<div class="row mt">
	<div class="panel  panel-default col-md-10 col-md-offset-1">
		<div class="panel-heading col-md-12">订单详情</div>
		<div class="panel-body">
			<table class="table table-border table-bordered table-striped">
				<tbody>
					<tr>
						<td>客户名称</td>
						<td>${order.customerName }</td>
					</tr>
					<tr>
						<td>订单号</td>
						<td>${order.orderNo }</td>
					</tr>
					<tr>
						<td>总价</td>
						<td>${order.total}</td>
					</tr>
					<tr>
						<td>客户地址</td>
						<td>${order.address }</td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td>${order.phone }</td>
					</tr>
				</tbody>
			</table>
			<table class="table table-border table-bordered table-striped">
				<thead>
					<tr class="text-c">
						<th>商品名称</th>
						<th>价格</th>
						<th>颜色</th>
						<th>CPU</th>
						<th>内存</th>
						<th>购买量</th>
						<th>图片</th>
					</tr>
				</thead>
				<tbody class="getData-list" data-currpage="1">
					<c:forEach var="ordergoods" items="${ordergoodsList }"
							   varStatus="status">
						<tr class="text-c">
							<td>${ordergoods.goodName }</td>
							<td>${ordergoods.price }元</td>
							<td>${ordergoods.colorName }</td>
							<td>${ordergoods.cpu }</td>
							<td>${ordergoods.specs }</td>
							<td>${ordergoods.number}</td>
							<td><img height="80px" src="${pageContext.request.contextPath }/${ordergoods.src}"
									 alt="响应式图片"/> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="panel-footer col-md-12 ">
			<button type="button" id="back" class="col-md-1 col-md-offset-1 btn btn-primary">&nbsp;&nbsp;返回&nbsp;&nbsp;</button>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/back/common/footer.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/localjs/orderview.js"></script>