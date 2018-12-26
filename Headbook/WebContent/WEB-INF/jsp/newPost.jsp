<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>POST - Headbook</title>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/img/headbook-logo.jpg">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/loaderAnimation.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/angular-1.7.5/docs/components/bootstrap-3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/colors.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/commons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/post.css">
</head>

<body ng-app="post">

	<!-- HEADER -->
	<%@include file="/resources/views/commons/header.html"%>
	<!-- FIN HEADER -->
	
	<%@include file="/resources/views/includes/loading.html"%>
	
	<%@include file="/resources/views/post/newPost.html"%>
			
	<!-- FOOTER -->
	<%@include file="/resources/views/commons/footer.html"%>
	<!-- FIN FOOTER -->



	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular-1.7.5/docs/components/jquery-3.2.1/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular-1.7.5/angular.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular-1.7.5/ui-bootstrap-tpls-2.4.0.min.js"></script>
	
<!-- 	APPS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common_apps/app-ajax-functions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common_apps/app-error.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/post/app-post.js"></script>
	
<!-- 	CONTROLLERS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/post/post-controller.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common_controllers/controller-error-modal.js"></script>
	
</body>
</html>
