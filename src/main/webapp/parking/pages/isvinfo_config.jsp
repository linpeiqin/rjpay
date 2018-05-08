<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>商户信息维护</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--<link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">-->

    <!--Basic Styles-->
    <link href="../../parking/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../../parking/assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="../../parking/assets/css/weather-icons.min.css" rel="stylesheet" />

    <!--Beyond styles-->
    <link href="../../parking/assets/css/beyond.min.css" rel="stylesheet" type="text/css" />

    <!--<link href="css/paging.css" rel="stylesheet" type="text/css" />
    <link href="../../parking/css/actInfo.css" rel="stylesheet" type="text/css" />-->
    <link href="../../parking/css/coupon_system.css" rel="stylesheet" type="text/css" />
	
	
    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="../../parking/assets/js/skins.min.js"></script>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<!-- /Head -->
<!-- Body -->
<body>
    <!-- Page Body -->
    <div class="page-body">
        <div class="row">
            <div class="col-xs-12 col-md-12 col-lg-12">
				<div class="well with-footer">
                    <form:form modelAttribute="aliResponse" method="post" class="form-horizontal" role="form" action="${ctx}/parkingconfig/configset">
                        <div class="col-xs-12 bordered-bottom bordered-blue coupon_diaTitle"><span class="fa fa-circle"></span>商户信息</div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right">
                                <span class="red">*</span>商户名称：
                            </label>
                            <div class="col-sm-3">
                                <form:input path="merchantName" name="merchantName" id="merchantName" placeholder="请输入商户名称" class="form-control"/>
                            </div>
                            <div class="col-sm-3">

                            </div>
                        </div>
                        <div class="form-group ">
                            <label class="col-sm-2 control-label no-padding-right">
                                <span class="red">*</span>客服电话：
                            </label>
                            <div class="col-sm-3">
                                <form:input path="merchantServicePhone" name="merchantServicePhone" id="merchantServicePhone" placeholder="请输入客服电话" class="form-control"/>
                            </div>
                            <div class="col-sm-3">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right">
                                <span class="red">*</span>支付宝账号：
                            </label>
                            <div class="col-sm-3">
                                <form:input path="accountNo" name="accountNo" id="accountNo" placeholder="请输入支付宝账号" class="form-control"/>
                            </div>
                            <div class="col-sm-3">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right">
                                <span class="red">*</span>缴费链接：
                            </label>
                            <div class="col-sm-3">
                                <form:input path="interfaceInfoList.interfaceUrl" name="interfaceUrl" id="interfaceUrl" placeholder="请输入缴费链接" class="form-control"/>
                            </div>
                            <div class="col-sm-3">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right">
                                <!--<span class="red">*</span>-->商户LOGO：
                            </label>
                            <div class="col-sm-3">
                                <form:input path="merchantLogo" name="merchantLogo" id="merchantLogo" placeholder="" class="form-control"/>
                            </div>
                            <div class="col-sm-3">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-2">
                                <input type="submit" value="提交" class="btn btn-blue btn-block btn_submit btn_xwt"/>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-blue btn-block btn_submit btn_xwt">取消</button>
                            </div>
                        </div>
                    </form:form>
				</div>
			</div>
		</div>
    </div>
    <!-- /Page Body -->
    
    <!--Basic Scripts-->
    <script src="../../parking/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../../parking/assets/js/bootstrap.min.js"></script>
    <!--Beyond Scripts-->
    <script src="../../parking/assets/js/beyond.min.js"></script>
    <script src="../../parking/assets/js/datetime/WdatePicker.js"></script>
	<script src="../../parking/assets/js/layer/layer.js"></script>
	
	<!--<script src="js/shopcoupon_add.js"></script>-->
    


</body>
<!--  /Body -->
</html>
