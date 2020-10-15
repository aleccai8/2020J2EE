<%@ page import="com.j2ee.homework1.servlet.data.PeopleExcelDataVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: zhengheng7913
  Date: 2020/10/8
  Time: 1:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10" style="padding-top: 10px">
            <div class="card">
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">学号/教工号</th>
                            <th scope="col">姓名</th>
                            <th scope="col">电话号码</th>
                            <th scope="col">QQ</th>
                            <th scope="col">邮箱</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<PeopleExcelDataVO> table = (List<PeopleExcelDataVO>)request.getAttribute("table");
                            for (PeopleExcelDataVO item : table) {
                        %>
                        <tr>
                            <td><%=item.getId()%></td>
                            <td><%=item.getName()%></td>
                            <td><%=item.getPhone()%></td>
                            <td><%=item.getQq()%></td>
                            <td><%=item.getEmail()%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <a href="${pageContext.request.contextPath}/search" class="card-link">继续查询</a>
                </div>
            </div>
        </div>
        <div class="col-1"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
