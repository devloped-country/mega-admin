<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>

    <title>Mega - Login</title>
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/footer.css">
    <link rel="stylesheet" type="text/css" href="style/login.css">
    <title>Login</title>
</head>


<body>
<div class="LoginWrapper1">
    <div class="LoginWrapper2">

        <img src="/images/logo.svg" width="68" height="68" class="logo">

        <h1 class="Mega">Mega</h1>


        <div class="Main">
            <form action="login.do" method="post" class="login-form">
                <%--        login_proc.jsp을 login.do로--%>
                <table class="loginTab">

                    <tr class="idBox1">
                        <td class="idBox2">
                            <input type="text" class="idBox3" name="account" placeholder="아이디"></td>
                    </tr>

                    <tr class="pwBox1">
                        <td class="pwBox2">
                            <input type="password" class="pwBox3" name="password" placeholder="비밀번호"/></td>
                    </tr>

                    <div class="alert-box">
                        <c:if test="${not empty requestScope.loginError}">
                            <span class="error-message">${requestScope.loginError}</span>
                        </c:if>
                    </div>

                    <tr class="loginBtn1">
                        <td class="loginBtn2" colspan="2" align="center">
                            <input class="loginBtn3" type="submit" value="로그인"/>
                        </td>
                    </tr>

                </table>
            </form>
        </div>
        <br>
    </div>
</div>

