<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
</head>

<body><div class="container">
    <input type="hidden" id="path" value="${path}">
	<table class="table table-striped .table-bordered">
    <caption>员工工资管理系统------单击员工编号可查看工资条</caption>
    <thead>
        <tr>
            <th></th>
            <th>序号</th>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>性别</th>
            <th>职称</th>
            <th>入职时间</th>
            <th>联系电话</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${elt}" var="e" varStatus="en">
        <tr>
            <td><input type="checkbox" name="cks" value="${e.emnumber}"></td>
            <td>${en.count}</td>
            <td><a href="${path}/user/lookSalaryview?esid=${e.id}">${e.emnumber}</a></td>
            <td>${e.name}</td>
            <td>${e.gender}</td>
            <td>${e.zhicheng}</td>
            <td><fmt:formatDate value="${e.worktime}" pattern="YYYY-MM-dd"></fmt:formatDate></td>
            <td>${e.phone}</td>
            <td><a href="${path}/user/updateEm?eid=${e.id}">修改信息</a></td>
        </tr>
      </c:forEach>  
        <tr>
            <td colspan="9" style="text-align: center;">
            <button type="button" onclick="deleteEm()">删除</button>
            <a href="${path}/user/addNewEmView">添加新员工</a>
            <a href="javascript:toAddSaloryView()">添加工资条目</a>
            </td>
        </tr>
    </tbody>
</table>
</div>
	<script src="${path}/dist/js/jquery.min.js"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/MyJs.js"></script>
</body>

</html>
