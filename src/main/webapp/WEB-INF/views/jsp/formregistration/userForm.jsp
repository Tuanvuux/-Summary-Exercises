<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<head>

<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/main.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>User Registration Form</title>
<style>
<%@include file="/resources/css/main.css" %>
<%@include file="/resources/js/main.js" %>
</style>
<jsp:include page="header.jsp" />
</head>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring MVC Form Handling</title>
  <title>Document</title>
</head>
<body>





  <h2>User Registration</h2>
  <mvc:form class="mb-3" modelAttribute="user" action="result">
    <table>
      <tr>
        <td>First Name (*)</td>
        <td><mvc:input class="form-control" path="name" required="true" placeholder="First Name" /></td>
      </tr>
      <tr>
        <td>Last Name (*)</td>
        <td><mvc:input class="form-control" path="lastname" required="true" placeholder="Last Name" /></td>
      </tr>
      <tr>
        <td> Password (*)</td>
        <td><mvc:input class="form-control" path="password" required="true" placeholder="Password" /></td>
      </tr>
      <tr>
        <td> Detail</td>
        <td><mvc:textarea path="detail" placeholder="Detail information" /></td>
      </tr>
      <tr>
        <td> Birth Date</td>
        <td><mvc:input class="form-control" path="birthDate" type="Date" placeholder="" /></td>
      </tr>
        <td> Gender</td>
        <td><mvc:radiobuttons path="gender" items="${genders}" /></td>
      </tr>
    </tr>
      <td> Country</td>
      <td><mvc:select path="country" items="${country}" /></td>

    </tr>

  </tr>
  <td> Non Smoking</td>
  <td><mvc:checkbox path="nonSmoking" checked="true" /></td>
</tr>
<tr>
  <td colspan="2">
    <input class="btn btn-primary" type="submit" name=""  onclick="welcome()" value="Submit">
  </td>
</tr>
    </table>
  </mvc:form>
</body>


</html>