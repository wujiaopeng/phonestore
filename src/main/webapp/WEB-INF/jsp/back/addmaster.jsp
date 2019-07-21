<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/back/common/head.jsp"%>
<div class="row mt">
	<div class="panel col-md-10 col-md-offset-1">
		<div class="panel-body col-md-12 ">
			<h4>添加用户</h4>	
			<div class="form-panel">
				<div class=" form">
					<form class="cmxform form-horizontal style-form" id="myForm" 
					method="post" action="${pageContext.request.contextPath }/system/savemaster">
						<div class="form-group ">
							<label for="account" class="control-label col-md-1 col-md-offset-1">账号：</label>
							<div class="col-md-8">
								<input class=" form-control" id="account" name="account" type="text"  />
							</div>
							<font size="1" class="col-md-2 message2" color="red"></font>
						</div>
						<div class="form-group ">
							<label for="password" class="control-label  col-md-1 col-md-offset-1">密码：</label>
							<div class="col-md-8">
								<input class="form-control " id="password" type="password"
									name="password" />
							</div>
							<font size="1" class="col-md-2 message3" color="red"></font>
						</div>
						<div class="form-group ">
							<label for="name" class="control-label  col-md-1 col-md-offset-1">姓名：</label>
							<div class="col-md-8">
								<input class="form-control " id="name" type="text"
									name="name"/>
							</div>
							<font size="1" class="col-md-2 message4" color="red"></font>
						</div>
						<div class="form-group ">
							<label class="control-label  col-md-1 col-md-offset-1">性别：</label>
							<div class="col-md-8">
								<label class="col-md-3"><input type="radio"name="sex" value="1" checked="checked"/>男</label>
								<label class="col-md-3"><input type="radio"name="sex" value="2"/>女</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="age" class="control-label  col-md-1 col-md-offset-1">年纪：</label>
							<div class="col-md-8">
								<input class="form-control " id="age" type="number" name="age" />
							</div>
						</div>
						<div class="form-group ">
							<label for="phone" class="control-label col-md-1 col-md-offset-1">手机号：</label>
							<div class="col-md-8">
								<input class="form-control " id="phone" type="text" name="phone" />
							</div>
							<font size="1" class="col-md-2 message5" color="red"></font>
						</div>
						<div class="form-group ">
							<label for="address" class="control-label  col-md-1 col-md-offset-1">地址：</label>
							<div class="col-lg-8">
								<input class="form-control " id="address" type="text" name="address" />
							</div>
						</div>
						<div class="form-group ">
							<label for="birth" class="control-label  col-md-1 col-md-offset-1">生日：</label>
							<div class="col-lg-8">
								<input class="form_datetime form-control " id="birth" type="text" 
								name="birth" readonly="readonly" onclick="WdatePicker();" />
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/addmaster.js"></script>