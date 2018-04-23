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
	<table class="table table-striped .table-bordered">
    <thead>修改员工信息页面</thead>
    <tbody>
        <tr>
            <td>员工编号：</td>
            <input type="hidden" id="enumber" value="${updateEm.id}">
            <td><input id="enumbe" type="text" value="${updateEm.emnumber}" readonly></td>
            <td>员工姓名：</td>
            <td><input id="ename" type="text" value="${updateEm.name}"></td>
        </tr>
         <tr>
            <td>员工性别：</td>
            <td>
            <c:if test="${updateEm.gender=='男'}">
                <input type="radio" name="cg" checked value="男">男</input>
                <input type="radio" name="cg" value="女">女</input>
            </c:if>
            <c:if test="${updateEm.gender=='女'}">
                <input type="radio" name="cg" value="男">男</input>
                <input type="radio" name="cg" checked value="女">女</input>
            </c:if>
            </td>
            <td>员工职称：</td>
            <td>
                <select id="sezhic" >
                <c:if test="${updateEm.zhicheng=='初级销售员'}">
                    <option value="初级销售员" selected>初级销售员</option>
                </c:if>
                <c:if test="${updateEm.zhicheng!='初级销售员'}">
                    <option value="初级销售员" >初级销售员</option>
                </c:if>
                
                <c:if test="${updateEm.zhicheng=='中级销售员'}">
                    <option value="中级销售员" selected>中级销售员</option>
                </c:if>
                <c:if test="${updateEm.zhicheng!='中级销售员'}">
                    <option value="中级销售员" >中级销售员</option>
                </c:if>
                
                <c:if test="${updateEm.zhicheng=='高级销售员'}">
                    <option value="高级销售员" selected>高级销售员</option>
                </c:if>
                <c:if test="${updateEm.zhicheng!='高级销售员'}">
                    <option value="高级销售员" >高级销售员</option>
                </c:if>
                
                <c:if test="${updateEm.zhicheng=='部门经理'}">
                    <option value="部门经理" selected>部门经理</option>
                </c:if>
                <c:if test="${updateEm.zhicheng!='部门经理'}">
                    <option value="部门经理" >部门经理</option>
                </c:if>
                </select>
            </td>
        </tr>
         <tr>
            <td>入职时间：</td>
            <td>
                <input id="rtime" value="<fmt:formatDate value="${updateEm.worktime}" pattern="YYYY-MM-dd"></fmt:formatDate>" class="Wdate" onclick="WdatePicker()" />
            </td>
            <td>联系电话：</td>
            <td><input id="ephong" type="text" value="${updateEm.phone}"></td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center;">
            <button type="button" onclick="updateEm()">确认修改</button>
            <a href="${path }">返回</a>
            </td>
        </tr>
    </tbody>
</table>
</div>
    <script src="${path}/My97DatePicker/WdatePicker.js"></script>
	<script src="${path}/dist/js/jquery.min.js"></script>
	<script src="${path}/dist/js/bootstrap.min.js"></script>
	<script src="${path}/js/MyJs.js"></script>
</body>

</html>
