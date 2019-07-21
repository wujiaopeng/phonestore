<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/js/bootstrap-fileupload/bootstrap-fileupload.css">
<div class="row mt">
	<div class="panel col-md-10 col-md-offset-1">
		<div class="panel-body col-md-12 ">
			<h4>修改商品信息</h4>
			<div class="form-panel">
				<div class=" form">
					<form class="cmxform form-horizontal style-form" id="myForm"
						method="post" enctype="multipart/form-data"
						action="${pageContext.request.contextPath }/goods/savemodifygoods">
						<input type="hidden" name="id"  value="${goods.id }"/>
						<div class="form-group ">
							<label
								class="control-label col-md-2 col-md-offset-1">商品名：</label>
							<div class="col-md-7">
								<input class=" form-control" id="goodName" name="goodName"
									type="text" value="${goods.goodName }" />
							</div>
							<font size="1" class="col-md-2 message2" color="red"></font>
						</div>
						<div class="form-group ">
							<label
								class="control-label  col-md-2 col-md-offset-1">价格：</label>
							<div class="col-md-7">
								<input class="form-control " id="price" type="number"
									name="price" value="${goods.price}" />
							</div>
							<font size="1" class="col-md-2 message3" color="red"></font>
						</div>
						<div class="form-group ">
							<label class="control-label  col-md-2 col-md-offset-1">库存：</label>
							<div class="col-md-7">
								<input class="form-control " id="stock" type="number" 
								name="stock"  value="${goods.stock }" />
							</div>
							<font size="1" class="col-md-2 message4" color="red"></font>
						</div>
						<div class="form-group ">
							<label  class="control-label  col-md-2 col-md-offset-1">内存：</label>
							<div class="col-md-7">
								<input class="form-control " id="specs" type="text" name="specs" 
								 value="${goods.specs }"/>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label  col-md-2 col-md-offset-1">品牌：</label>
							<div class="col-md-7">
								<input type="hidden" id="bra" value="${goods.brand }"/>
								<div class="input-group col-md-12">
									<select id="brand1" name="brand" class="form-control">
										<option value="">——请选择——</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group ">
							<label  class="control-label col-md-2 col-md-offset-1">颜色：</label>
							<div class="col-md-7">
							<input type="hidden" id="col" value="${goods.colorId }">
								<div class="input-group col-md-12">
									<select id="color1" name="colorId" class="form-control">
										<option value="">——请选择——</option>
									</select>
								</div>
							</div>
							<font size="1" class="col-md-2 message5" color="red"></font>
						</div>
						<div class="form-group ">
							<label  class="control-label  col-md-2 col-md-offset-1">CPU：</label>
							<div class="col-md-7">
								<input class="form-control " id="cpu" type="text" name="cpu"
								value="${goods.cpu }" />
							</div>
						</div>
						<div class="form-group ">
							<label  class="control-label  col-md-2 col-md-offset-1">商品状态：</label>
							<div class="col-md-7">
								<input type="hidden" name="goodState" value="${goods.goodState }">
								<input readonly="readonly" class="form-control " id="state" type="text" name="goodState1"
								value="${goods.goodStateName }" />
							</div>
						</div>
						<div class="form-group">
							<label
								class="control-label  col-md-2 col-md-offset-1">手机图片：</label>
							<div class="col-md-9">
								<input type="hidden" name="src" value="${goods.src }"/>
								<div class="fileupload fileupload-new"
									data-provides="fileupload">
									<div class="fileupload-new thumbnail"
										style="width: 200px; height: 150px;">
										<img
											src="${pageContext.request.contextPath }/${goods.src }"
											alt="没有图片">
									</div>
									<div class="fileupload-preview fileupload-exists thumbnail"
										style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
									<div>
										<span class="btn btn-theme02 btn-file"> <span
											class="fileupload-new"><i class="fa fa-paperclip"></i>
												选择图片</span> <span class="fileupload-exists"><i
												class="fa fa-undo"></i> 更改</span> 
												<input type="file" name="uploadImage" class="default">
										</span>
									</div>
								</div>
								<span>
									上传图片不能大于500kb </span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<button id="addBtn" class="btn btn-theme" type="button">提交</button>
								<button id="back" class="btn btn-theme04" type="button">返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- /form-panel -->
		</div>
	</div>
	<!-- panel -->
</div>

<%@include file="/WEB-INF/jsp/back/common/footer.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/localjs/modifygoods.js"></script>