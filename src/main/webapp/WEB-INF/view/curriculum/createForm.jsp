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

<center>
<h1>교과목명</h1>
<hr>
<form action="createCurriculum.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td width="90">과목추가</td>
	<td><input type="text" name="subject" size="20"/></td>
</tr>
<tr>
	<td>시간</td>
	<td><input type="text" name="time" size="30"/></td>
</tr>
<tr>
	<td>기간</td>
    <td><input type="date" max="2023-12-31" min="2023-05-25" name="startDate"/></td>
    ~왜 여기로 들어가???
    <td><input type="date" max="2023-12-31" min="2023-05-25" name="endDate"/></td>
</tr>
<tr>
	<td>상세 교과 내용</td>
</tr>
<tr>
    <td><input type="text" name="dto1" size="30"/></td>
</tr>
<tr>
    <td><input type="text" name="dto2" size="30"/></td>
</tr>
<tr>
    <td><input type="text" name="dto3" size="30"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="추가"/>
	</td>
</tr>
</table>
</form>
</center>

</body>
</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>