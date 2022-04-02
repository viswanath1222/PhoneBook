<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form >

<c:choose>
<c:when test="${contactList ne null}">
<table border="1">
<tr>

<th>NAME</th>
<th>Email</th>
<th>phno</th>
<th>Action</th>

</tr>
<c:forEach items="${contactList}" var="contact">
<tr>


<td>
<c:out value="${contact.name}"></c:out>
</td>

<td>
<c:out value="${contact.email}"></c:out>
</td>

<td>
<c:out value="${contact.phno}"></c:out>
</td>

<td>
<a href="/edit?id=${contact.id}">Edit</a> &nbsp; <a href="/delete?id=${contact.id}">Delete</a>
</td>


</tr>
</c:forEach>

</table>

</c:when>
<c:otherwise>
<p>No contacts found</p>
</c:otherwise>
</c:choose>


</form:form>




<c:if test="${currPno > 1}">
<a href="viewAllContactsNew?pno=${currPno - 1}">Previous</a>
</c:if>
<c:forEach begin="1" end="${tp}" var="pageNo">

<c:choose>
<c:when test="${currPno==pageNo}">
${pageNo}
</c:when>
<c:otherwise>
<a href="viewAllContactsNew?pno=${pageNo}">${pageNo}</a>
</c:otherwise>
</c:choose>

</c:forEach>
<c:if test="${currPno < tp}">

<a href="viewAllContactsNew?pno=${currPno +1}">Next</a>
</c:if>
<br>
<a href="loadform">HOME</a>
</body>
</html>