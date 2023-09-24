<%@ page contentType="text/html; charset=UTF-8"%>

<header class="HeaderWrapper">
    <button class="logo-btn">
        <img src="../../../images/logo.svg" alt="logo" class="logo"/>
    </button>
    <button type="submit" class="logout-btn">
        <a href="/"> <img src="../../../images/logout.svg" alt="logout" class="logout"/></a>
    </button>

</header>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var logoutButton = document.querySelector(".logout-btn");
        logoutButton.addEventListener("click", function () {
            // 세션 무효화 요청을 서버로 보내는 함수를 호출합니다.
            invalidateSession();
        });

        function invalidateSession() {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/", true); // 로그아웃을 처리하는 서버 엔드포인트
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    response.sendRedirect("/");
                }
            };
            xhr.send();
        }
    });
</script>