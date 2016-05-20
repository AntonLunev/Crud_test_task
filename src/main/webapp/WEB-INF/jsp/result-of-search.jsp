<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>User list</title>

  <link rel="stylesheet" href="/css/styleTabl.css" type="text/css">

</head>
<body>
<h1>Search result</h1>
<table  class="bordered">
  <thead>
  <tr>
    <th width="50px">ID</th><th width="100px">Name</th><th width="100px">Age</th><th width="50px">IsAdmiin</th><th width="200px">CreateDate</th><th width="100px">Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.userId}</td>
      <td>${user.name}</td>
      <td>${user.age}</td>
      <td>${user.isAdmin}</td>
      <td>${user.createDate}</td>
      <td><form method="GET" action="${pageContext.request.contextPath}/edit/${user.userId}.html">
        <input type="submit" value="Update"/>
      </form>
        <form method="GET" action="${pageContext.request.contextPath}/delete/${user.userId}.html">
          <input type="submit" value="Delete"/>
        </form>
      </td>

    </tr>
  </c:forEach>


  <form method="GET" action="${pageContext.request.contextPath}/search-init.html">
    <input type="submit" value="Search"/>

  </form>
  <br/>
  <br/>
  <br/>

  <b>Users found: ${sizeresult} </b>
  <br/>
  <br/>
  <br/>
  </tbody>
</table>


<br/>
<form method="GET" action="${pageContext.request.contextPath}/add.html">

  <input type="submit" value="Add user"/>
</form>
<br/>
<form method="GET" action="${pageContext.request.contextPath}/">

  <input type="submit" value="Back"/>
</form>



<br/>
<br/>
<div id="pagination">

  <c:url value="/result" var="prev" >
    <c:param name="page" value="${page-1}"/>
  </c:url>
  <c:if test="${page > 1}">
    <a href="<c:out value="${prev}" />" class="pn prev">СЮДА </a>
  </c:if>

  <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
    <c:choose>
      <c:when test="${page == i.index}">
        <span>${i.index}</span>
      </c:when>
      <c:otherwise>
        <c:url value="/result" var="url">
          <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href='<c:out value="${url}" />'>${i.index}</a>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  <c:url value="/result" var="next">
    <c:param name="page" value="${page + 1}"/>
  </c:url>
  <c:if test="${page + 1 <= maxPages}">
    <a href='<c:out value="${next}" />' class="pn next"> ТУДА</a>
  </c:if>
</div>

</body>
</html>