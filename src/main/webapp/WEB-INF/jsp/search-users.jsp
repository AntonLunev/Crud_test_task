<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Search user page</title>
  <style>
    h4 {
      color: red;
    }
  </style>
</head>
<body>
<h1>Search</h1>
<p>Fill the form for search:</p>

<hr/>
<p><h4>${isSearch}</h4></p>
<form:form method="POST" commandName="searchUser" action="${pageContext.request.contextPath}/search-init.html">
  <table>
    <tbody>
    <tr>
      <td>ID:</td>
      <td><form:input path="userId" type="number" min="0" max="2147483647" /></td>
    </tr>
    <tr>
      <td>Name:</td>
      <td><form:input path="name" maxlength="25"/></td>
    </tr>
    <tr>
      <td>Age:</td>
      <td><form:input path="age" type="number" max="120" min="0"/></td>
    </tr>
    <tr>
      <td>IsAdmin:</td>
      <td><form:checkbox path="isAdmin" />
      </td>
    </tr>
    <tr>
      <td><input type="submit" value="Search" /></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>



<form method="GET" action="${pageContext.request.contextPath}/list.html">
  <input type="submit" value="Back"/>
</form>

</body>
</html>