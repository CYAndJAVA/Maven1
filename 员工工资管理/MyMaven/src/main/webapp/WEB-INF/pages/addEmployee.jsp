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
    <thead>添加员工信息页面</thead>
    <tbody>
        <tr>
            <td>员工编号：</td>
            <td><input id="enumbe1" type="text" onblur="checkEm(this.value)" value=""></td>
            <td>员工姓名：</td>
            <td><input id="ename1" type="text" ></td>
        </tr>
         <tr>
            <td>员工性别：</td>
            <td>
                <input type="radio" name="cg1" checked value="男">男</input>
                <input type="radio" name="cg1" value="女">女</input>
            </td>
            <td>员工职称：</td>
            <td>
                <select id="sezhic1" >
                    <option value="初级销售员" selected>初级销售员</option>
                    <option value="中级销售员" >中级销售员</option>
                    <option value="高级销售员" >高级销售员</option>
                    <option value="部门经理" >部门经理</option>
                </select>
            </td>
        </tr>
         <tr>
            <td>入职时间：</td>
            <td>
                <input id="rtime1" class="Wdate" onclick="WdatePicker()" />
            </td>
            <td>联系电话：</td>
            <td><input id="ephong1" type="text" ></td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center;">
            <button id="sub" disabled type="button" onclick="addNewEmploy()">确认修改</button>
            <button type="reset" >重置</button>
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
