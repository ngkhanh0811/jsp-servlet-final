<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>Title</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<div class="content bg-gray-100">
    <div class="content-heading flex items-center justify-between p-[20px]">
        <div class="content-heading-title">
            <h3 class="font-medium text-xl">Product Management</h3>
        </div>
        <div class="content-heading-breadcrumb">
            <ul class="flex items-center text-xs gap-[4px]">
                <li><a href="#">Home </a></li>
                <li> > </li>
                <li><a href="#" class="active"> Product Management</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid flex">
        <div class="content-body bg-white m-[20px] w-[100%] mt-[0] mx-[30px]">
            <h1>${productByIdName}</h1>
        </div>
    </div>
</div>
</body>
</html>
