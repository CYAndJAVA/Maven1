<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chankan</title>
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
</head>

<body><div class="container">
    <input type="hidden" id="path" value="${path}">
    <form action="">
	<table class="table table-striped .table-bordered">
    <thead>员工工资条</thead>
    <tbody>
        <tr>
            <td>序号</td>
            <td>工资日期</td>
            <td>基本工资￥</td>
            <td>单月销售量￥</td>
            <td>合计</td>
            <td></td>
        </tr>
        <c:forEach items="${safg}" var="vc" varStatus="vn">
         <tr>
            <td><input type="text" value="${vn.count}" readonly></td>
            <td>
                <input readonly value='<fmt:formatDate value="${vc.salarytime}" pattern="YYYY-MM-dd"></fmt:formatDate>' />
            </td>
            <td><input type="text" value="3000" readonly></td>
            <td><input value="${vc.sells }" readonly type="text" ></td>
            <td><input value="${vc.taotal }" readonly type="text" ></td>
            <td><a href="${path}/user/deleteSalary?sid=${vc.sid}">删除</a></td>
        </tr>
        </c:forEach>
        <tr>
           <td colspan="6" style="text-align: center;">
           <a href="${path }">返回</a>
           </td>
        </tr>
    </tbody>
</table>
</form>
</div>
    <script src="${path}/My97DatePicker/WdatePicker.js"></script>
	<script src="${path}/dist/js/jquery.min.js"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/MyJs.js"></script>
</body>

</html>
