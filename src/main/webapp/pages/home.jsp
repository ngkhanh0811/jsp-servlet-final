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
            <table class="m-[20px] mt-[0] w-[97%]">
                <tr class="text-left pl-[20px] h-[52px]">
                    <th class="w-[40px] font-normal">ID</th>
                    <th class="text-left w-[300px] font-normal">Product name</th>
                    <th class="w-[200px] font-normal">Import date</th>
                    <th class="w-[200px] font-normal">Quantity</th>
                    <th class="w-[300px] font-normal">Action</th>
                </tr>
                <c:forEach var="item" items="${product}">
                    <tr>
                        <td name="id">${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.impDate}</td>
                        <td>${item.quantity}</td>
                        <td>
                            <ul class="flex gap-[20px] items-center">
                                <li><button><a href="/jpa_sem4_war_exploded/product?id=${item.id}">Details</a></button></li>
                                <li><button><a href="#">Edit</a></button></li>
                                <li><button><a href="#">Delete</a></button></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
