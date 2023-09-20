<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
</head>
<body>
<c:set var="name" value="test" />
<p>Name: <c:out value="${name}" /></p>

<%--<img src="images" width="100" height="80">--%>

<h1>Mega</h1>

<hr>
<form action="login.do" method="post">
    <%--        login_proc.jsp을 login.do로--%>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td bgcolor="orange">아이디</td>
            <td><input type="text" name="account"/></td>
        </tr>
        <tr>
            <td bgcolor="orange">비밀번호</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="로그인"/>
            </td>
        </tr>
    </table>
</form>
<br>
<hr>