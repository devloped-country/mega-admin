<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Mega - QR</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
    <link rel="stylesheet" href="../../../style/qr.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<main class="QRWrapper">
    <nav class="nav">
        <h2 class="title">QR 코드</h2>
        <button class="qr-btn" type="button" onclick="location.href='/qr/code.do'">QR 생성</button>
    </nav>
    <section class="content">
        <img src="/qr/qrImg" alt="qr" class="qr"/>
    </section>
</main>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>