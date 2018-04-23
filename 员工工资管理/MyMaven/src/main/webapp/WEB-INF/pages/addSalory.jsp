<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link type="text/css" rel="stylesheet" href="${path}/dist/css/bootstrap.min.css">
</head>

<body><div class="container">
    <input type="hidden" id="path" value="${path}">
    <form action="">
	<table class="table table-striped .table-bordered">
    <thead>添加员工工资</thead>
    <tbody>
        <tr>
            <td>员工编号：</td>
            <td><input id="oneNum" type="text" value="${nemn}" readonly></td>
        </tr>
         <tr>
            <td>工资日期：</td>
            <td>
                <input id="satime" class="Wdate" onclick="WdatePicker()" />
            </td>
        </tr>
        <tr>
            <td>基本工资：</td>
            <td><input type="text" value="3000" readonly></td>
        </tr>
        <tr>
            <td>单月销售量：</td>
            <td><input id="saall" type="text" value="" ></td>
        </tr>
        <tr>
           <td colspan="2" style="text-align: center;">
            <button id="butd" type="button" onclick="addNewSalory()">确认添加</button>
            <button type="reset" >重置</button>
            <a href="${path }">返回</a>
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
