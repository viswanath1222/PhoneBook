<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="save?id=${contact.id}" method="post" modelAttribute="contact">
<table>
<tr>
<f:hidden path="id"/>
</tr>
<tr>
<td>NAME:</td>
<td><f:input path="name"/></td>

</tr>
<tr>
<td>EMAIL:</td>
<td><f:input path="email"/></td>
</tr>

<tr>
<td>PHNO</td>
<td><f:input path="phno"/></td>

</tr>

<tr>
<td><input type="submit" value="SUBMIT"></td>
</tr>

<tr>
<td><a href="viewAllContactsNew">VIEW ALL CONTACTS</a></td>
</tr>

</table>

</f:form>
  
  ${msg}
</body>
</html>