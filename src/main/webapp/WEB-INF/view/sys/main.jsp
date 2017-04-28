<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>锁管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="author" content="SuggeElson" />
<meta name="description" content="应用授权管理系统" />
<meta name="keywords" content="应用授权管理系统" />
<meta name="application-name" content="应用授权管理系统" />
<meta name="msapplication-TileColor" content="#3399cc" />
<link rel='stylesheet' type='text/css' href="http://fonts.googleapis.com/css?family=Open+Sans:400,700|Droid+Sans:400,700" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/icons.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/plugins.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/main.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/custom.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/css/list-style.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/public/css/app.css" rel="stylesheet" />
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/res/sprflatV14/assets/img/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/res/sprflatV14/assets/img/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/res/sprflatV14/assets/img/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/res/sprflatV14/assets/img/ico/apple-touch-icon-57-precomposed.png">
<link href="${pageContext.request.contextPath}/res/sprflatV14/assets/plugins/toastr/2.1.3/toastr.min.css" rel="stylesheet">

<link rel="icon" href="${pageContext.request.contextPath}/res/sprflatV14/assets/img/ico/favicon.ico" type="image/png">

<script type="text/javascript">
	 <!-- 配置请求的基础Ajax路径 -->
	 var httpConfig = {
    		 basePath : "/lock/",
    		 baseUrl : "/lock/",
    		 uploadUrl : "/lock",
    		 downloadUrl : "/lock"
         };
</script>

</head>
<body ng-app="myApp">
	<div id="header">
		<div class="container-fluid">
			<div class="navbar">
				<div class="navbar-header">
					<a class="navbar-brand" href="#" tppabs="index.html"> <i class="im-windows8 text-logo-element animated bounceIn"></i><span class="text-logo">海事</span><span class="text-slogan">大学</span>
					</a>
				</div>
				<nav class="top-nav" role="navigation">
					<ul class="nav navbar-nav pull-left">
						<li id="toggle-sidebar-li"><a href="#" id="toggle-sidebar"><i class="en-arrow-left2"></i></a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<%--  <li class="dropdown">
                               <a href="#" data-toggle="dropdown"><img class="user-avatar" src="http://ecard.dlmu.edu.cn/ecard/photo/${currUser.userName}.jpg" tppabs="assets/img/avatars/48.jpg" alt="SuggeElson"></a>
                           </li> --%>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<div id="sidebar">
		<div class="sidebar-inner">
			<%@ include file="leftMenu.jsp"%>
		</div>
	</div>
	<div id="content">
		<!-- Start .content-wrapper -->
		<div class="content-wrapper" ng-view></div>
		<div class="clearfix"></div>
	</div>

	<!-- End #content -->
	<!-- Javascripts -->
	<!-- Load pace first -->
	<script src="${pageContext.request.contextPath}/res/jquery/jquery-2.1.1.min.js" charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/res/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/res/sprflatV14/assets/js/jquery.sprFlat.js"></script>
	<script src="${pageContext.request.contextPath}/res/sprflatV14/assets/js/libs/jquery-ui-1.10.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/sprflatV14/assets/plugins/toastr/2.1.3/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/angular/1.4.9/angular.js"></script>
	<script src="${pageContext.request.contextPath}/res/angular/1.4.9/angular-route.js"></script>
	<script src="${pageContext.request.contextPath}/res/angular_expand/angular-ui/2.5.0/ui-bootstrap-tpls.js"></script>
	<script src="${pageContext.request.contextPath}/res/angular_expand/angular-w5c-validator/2.4.25/w5cValidator.min.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/config.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/app.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/app.routers.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/app.services.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/app.directives.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/application/ApplicationController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/resource/ResourceController.js"></script>

	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/EventController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/LockController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/DeviceController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/TypeController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/CmdController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/WaterController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/LockUserController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/LockLockController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/SystemController.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/app/modules/lock/LogController.js"></script>
</body>
</html>