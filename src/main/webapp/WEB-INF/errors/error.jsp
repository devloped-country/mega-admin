<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:set var="name" value="Error" />
<p>Name: <c:out value="${name}" /></p>

</body>
</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>