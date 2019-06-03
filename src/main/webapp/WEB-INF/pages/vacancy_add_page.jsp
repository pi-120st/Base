<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../resources/css/add.css">
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/vacancy_add" method="post">
        <div class="form-group"><h3>New Product</h3></div>
        <div class="form-group"><input type="text" class="form-control" name="vacancy" placeholder="Vacancy"></div>
        <div class="form-group"><input type="text" class="form-control" name="salary" placeholder="Salary"></div>
        <div class="form-group"><input type="text" class="form-control" name="vacancyText" placeholder="Vacancy describe"></div>
        <div class="form-group"><input type="text" class="form-control" name="experience" placeholder="Experience"></div>
        <div class="form-group"><input type="text" class="form-control" name="signId" value="${signUp.signId}" readonly="readonly"></div>
        <div class="form-group"><input type="submit" class="btn btn-dark" value="Add"></div>
    </form>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>