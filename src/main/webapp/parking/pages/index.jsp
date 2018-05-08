<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--<link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">-->

    <!--Basic Styles-->
    <link href="../../parking/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../../parking/assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--<link href="assets/css/weather-icons.min.css" rel="stylesheet" />-->

    <!--Beyond styles-->
    <link href="../../parking/assets/css/beyond.min.css" rel="stylesheet" type="text/css" />

	<!--<link href="css/paging.css" rel="stylesheet" type="text/css" />-->
    <!--<link href="css/actInfo.css" rel="stylesheet" type="text/css" />-->
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

    <!-- Navbar -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="navbar-container">
                <!-- Navbar Barnd -->
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small class="copuon_indextit">
                        	停车管理平台
                        </small>
                    </a>
                </div>
                <!-- /Navbar Barnd -->

                <!-- Sidebar Collapse -->
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <!-- /Sidebar Collapse -->
                <!-- Account Area and Settings --->
                <div class="navbar-header pull-right">
                    <div class="navbar-account">
                        <ul class="account-area">
                            <li>
                                <a class="login-area dropdown-toggle">
                                    <div class="avatar" title="View your public profile">
                                        <img src="../img/person.png" />
                                    </div>
                                    <section>
                                        <h2><span class="profile"><span>向问天</span></span></h2>
                                    </section>
                                </a>
                            </li>
                            <li class="coupon_exit"><a href="login.html"><span class="glyphicon glyphicon-off" >退出</span></a></li>
                            <!-- /Account Area -->
                        </ul>
                       
                    </div>
                </div>
                <!-- /Account Area and Settings -->
            </div>
        </div>
    </div>
    <!-- /Navbar -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
            <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar">
                <!-- Sidebar Menu -->
                <ul class="nav sidebar-menu activemenu">
                    <li>
                        <a href="home.html" target= "iFrame">
                            <i class="menu-icon glyphicon glyphicon-home"></i>
                            <span class="menu-text"> 首页 </span>
                        </a>
                    </li>
                </ul>
                <ul class="nav sidebar-menu">
                	<li class="open">
                        <a href="#" class="menu-dropdown">
                            <i class="menu-icon fa fa-desktop"></i>
                            <span class="menu-text"> 信息管理 </span>
                            <i class="menu-expand"></i>
                        </a>
                        <ul class="submenu">
                            <li>
                                <a href="#" class="menu-dropdown">
                                    <span class="menu-text">
                                     	商户信息管理
                                    </span>
                                    <i class="menu-expand"></i>
                                </a>

                                <ul class="submenu activemenu">
                                    <li>
                                        <a href="${ctx}/parkingconfig/configquery" target= "iFrame">
                                            <i class="menu-icon fa fa-rocket"></i>
                                            <span class="menu-text">商户信息维护</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="menu-dropdown">
                                    <span class="menu-text">
                                     	停车场管理
                                    </span>
                                    <i class="menu-expand"></i>
                                </a>

                                <ul class="submenu activemenu">
                                    <li>
                                        <a href="parking_creact.html" target= "iFrame">
                                            <i class="menu-icon fa fa-rocket"></i>
                                            <span class="menu-text">输入停车场</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="parking_list.html" target= "iFrame">
                                            <i class="menu-icon fa fa-rocket"></i>
                                            <span class="menu-text">停车场列表</span>
                                        </a>
                                    </li>
                                    <!--<li>
                                        <a href="couponthrow_add.html" target= "iFrame">
                                            <i class="menu-icon glyphicon glyphicon-stats"></i>
                                            <span class="menu-text">优惠券投放</span>
                                        </a>
                                    </li>-->
                                </ul>
                            </li>
                            <!--<li>
                                <a href="#" class="menu-dropdown">
                                    <span class="menu-text">
                                     	订单管理
                                    </span>
                                    <i class="menu-expand"></i>
                                </a>
                                <ul class="submenu activemenu">
                                    <li>
                                        <a href="order_list.html" target= "iFrame">
                                            <i class="menu-icon fa fa-rocket"></i>
                                            <span class="menu-text">查询订单</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>-->
                            
                        </ul>
                    </li>
                </ul>
                <!-- /Sidebar Menu -->
            </div>
            <!-- /Page Sidebar -->
            <!-- Page Content -->
           	 
            <div class="page-content" id="iFrame" name="iFrame">
            	<iframe src="home.html" id="iFrame2" name="iFrame" width="100%" frameborder="0"></iframe>
            </div>
            	
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>


	
    
    <!--Basic Scripts-->
    <script src="../../parking/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../../parking/assets/js/bootstrap.min.js"></script>
    <!--Beyond Scripts-->
    <script src="../../parking/assets/js/beyond.min.js"></script>
    <script src="../../parking/assets/js/datetime/WdatePicker.js"></script>
	<script src="../../parking/assets/js/layer/layer.js"></script>

	<script type="text/javascript">
		$(function(){
			//iframe高度
			var iframe = $("#iFrame2");
			iframe.css("height",$(window).height()-49+"px");
			
			$(window).resize(function(){
				var iframe = $("#iFrame2");
				iframe.css("height",$(window).height()-49+"px");
			})
		
			//当前选中加class
			$(".activemenu li").on("click",function(){
				$(".activemenu li").removeClass("active");
				$(this).addClass("active");
			})
		})
		
	</script>



</script> 



 



</body>
<!--  /Body -->
</html>
