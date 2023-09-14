<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
</head>
<body>
<c:set var="name" value="test-커리큘럼리스트" />
<p>Name: <c:out value="${name}" /></p>

<c:forEach var="curriculum" items="${curriculumList}">
<tr>
	<td>${curriculum.id}</td>
	<td>${curriculum.subject}</td>
	<td>${curriculum.time}</td>
	<td>${curriculum.startDate}</td>
	<td>${curriculum.endDate}</td>
</tr>
</c:forEach>
</body>
</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>