<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>Mega - Curriculum</title>
</head>
<body>
<c:set var="name" value="test-커리큘럼" />
<p>Name: <c:out value="${name}" /></p>

</body>
</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>