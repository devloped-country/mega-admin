<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
asdf
<c:set var="name" value="test-홈" />
<p>Name: <c:out value="${name}" /></p>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>