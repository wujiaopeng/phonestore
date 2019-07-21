<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>
<div class="row mt">
	<div class="panel  panel-default col-md-10 col-md-offset-1">
		<div class="panel-heading col-md-12">商品详情</div>
		<div class="panel-body">
			<table class="table table-border table-bordered table-striped">
				<tbody>
					<tr>
						<td>名称</td>
						<td>${goods.goodName }</td>
					</tr>
					<tr>
						<td>价格</td>
						<td>${goods.price}</td>
					</tr>
					<tr>
						<td>库存</td>
						<td>${goods.stock }</td>
					</tr>
					<tr>
						<td>品牌</td>
						<td>${goods.brandName }</td>
					</tr>
					<tr>
						<td>颜色</td>
						<td>${goods.colorName }</td>
					</tr>
					<tr>
						<td>内存</td>
						<td>${goods.specs }</td>
					</tr>
					<tr>
						<td>CPU</td>
						<td>${goods.cpu }</td>
					</tr>
					<tr>
						<td>商品状态</td>
						<td>${goods.goodStateName }</td>
					</tr>
					<tr>
						<td>图片</td>
						<td><img width="150px"
								src="${pageContext.request.contextPath }/${goods.src}" alt="响应式图片"></td>
					</tr>
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
	src="${pageContext.request.contextPath }/statics/localjs/goodsview.js"></script>