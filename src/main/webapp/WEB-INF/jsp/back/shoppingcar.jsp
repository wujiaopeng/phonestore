<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>
<div class="row mt">
	<div class="panel  panel-default col-md-10 col-md-offset-1">
		<div class="panel-heading col-md-12">购物车详情</div>
		<div class="panel-body col-md-12 ">
			<table class="table table-border table-bordered table-striped">
				<tbody>
					<tr>
						<td>名称</td>
						<td>${shoppingcar.goodName }</td>
					</tr>
					<tr>
						<td>顾客名</td>
						<td>${shoppingcar.customerName }</td>
					</tr>
					<tr>
						<td>价格</td>
						<td>${shoppingcar.price }元</td>
					</tr>
					<tr>
						<td>购买量</td>
						<td>${shoppingcar.number }</td>
					</tr>
					<tr>
						<td>品牌</td>
						<td>${shoppingcar.brandName }</td>
					</tr>
					<tr>
						<td>颜色</td>
						<td>${shoppingcar.colorName }</td>
					</tr>
					<tr>
						<td>内存</td>
						<td>${shoppingcar.specs }</td>
					</tr>
					<tr>
						<td>图片</td>
						<td><img src="${pageContext.request.contextPath }/${shoppingcar.src }"
								width="120px"  class="img-responsive" alt="响应式图片"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="panel-footer col-md-12">
			<button type="button" id="back" class="col-md-1 col-md-offset-1 btn btn-primary">&nbsp;&nbsp;返回&nbsp;&nbsp;</button>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/back/common/footer.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/localjs/shoppingcar.js"></script>