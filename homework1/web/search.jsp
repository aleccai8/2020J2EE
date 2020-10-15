<%--
  Created by IntelliJ IDEA.
  User: zhengheng7913
  Date: 2020/10/8
  Time: 1:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container" style="padding-top: 100px">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <div class="card">
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/search" method="post">
                        <div class="form-row">
                            <div class="col-md-3 mb-3">
                                <label for="option">搜索</label>
                                <select class="custom-select" id="option" name="option" required>
                                    <option selected disabled value="">选择查询选项</option>
                                    <option value="name">姓名</option>
                                    <option value="id">学号/教工号</option>
                                    <option value="qq">QQ</option>
                                    <option value="email">邮箱</option>
                                    <option value="phone">电话号码</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="param">&nbsp</label>
                                <input type="text" class="form-control" name="param" id="param">
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="count">记录个数</label>
                                <input type="text" class="form-control" id="count" name="count" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary" style="float: right">查询</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
