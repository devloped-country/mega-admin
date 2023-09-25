<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/notice/detailNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<form action="/notice/deleteNotice.do" method="post">
<div class="DetailNoticeWrapper">
    <div class="nav">
        <h1 class="title">공지사항</h1>
        <ul class="menu-list">
            <li class="menu-item">
                <button class="menu-btn notice-list-btn" onclick="history.back()">목록
                </button>
            </li>
        </ul>
    </div>
    <div class="content">
        <div class="content-header">
            <div class="content-header-top">
                <h3 class="content-tag">
                   <c:choose>
                       <c:when test="${notice.tagId == 1}">
                           훈련비
                       </c:when>
                       <c:when test="${notice.tagId == 2}">
                           시험
                       </c:when>
                        <c:when test="${notice.tagId == 3}">
                            BIPA행사관련
                        </c:when>
                       <c:when test="${notice.tagId == 4}">
                           BIPA전달사항
                       </c:when>
                       <c:when test="${notice.tagId == 5}">
                           BIPA채용공지
                       </c:when>
                       <c:when test="${notice.tagId == 6}">
                           세미나
                       </c:when>
                       <c:when test="${notice.tagId == 7}">
                           긴급
                       </c:when>
                       <c:when test="${notice.tagId == 8}">
                           기타
                       </c:when>
                   </c:choose>
                </h3>
                <span class="bar"></span>
                <h2 class="content-title">${ notice.title }</h2>
            </div>
            <div class="content-header-bottom">
                <div class="content-header-bottom-left">
                    <strong class="author">${ notice.author } 매니저님</strong>
                    <p class="create-date">
                        <c:if test="${not empty notice.createdDate}">
                            <fmt:formatDate value="${notice.createdDate}" pattern="yyyy-MM-dd HH:mm" />
                        </c:if>
                    </p>
                </div>
                <div class="content-header-bottom-right">
                    <img src="../../images/edit-btn.svg" alt="수정, 삭제 버튼" class="edit-btn"/>
                    <ul class="edit-list">
                        <li class="edit-item">
                            <button id="updateButton" class="menu-btn update-btn" type="button"
                                    onclick="location.href='/notice/updateNoticeForm.do?id=${notice.id}'">
                                수정
                            </button>
                        </li>
                        <li class="edit-item">
                                <input type="radio" name="id"
                                       value=${notice.id} class="edit-radio"
                                       checked/>
                                <button class="menu-btn delete-btn" type="button">삭제</button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="content-body">
            ${notice.getContent() }
        </div>
    </div>
</div>

<div class="DetailNoticeModal">
    <div class="backdrop">
        <div class="modal-wrapper">
            <div class="modal-desc-wrapper">
                <h2 class="modal-title">공지사항 삭제</h2>
                <p class="modal-desc">공지사항을 삭제하시겠어요?</p>
            </div>
            <div class="modal-btn-wrapper">
                <form action="/notice/deleteNotice.do" method="post">
                    <input type="hidden" name="id" value="${notice.id}">
                    <button class="modal-btn modal-btn-confirm" type="submit">확인</button>
                </form>
                <button class="modal-btn modal-btn-cancel" type="button">취소</button>
            </div>
        </div>
    </div>
</div>
</form>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
<script>

     // 모달 창을 보여주는 함수
        function showDeleteModal() {
            document.getElementById('deleteModal').classList.add('active');
        }

        // 모달 창을 숨기는 함수
        function hideDeleteModal() {
            document.getElementById('deleteModal').classList.remove('active');
        }

  document.addEventListener('DOMContentLoaded', () => {
    document.addEventListener("click", ({target}) => {
      if(target.className !== 'edit-btn') {
        document.querySelector('.edit-list').classList.remove('active');
      }
    });

    document.querySelector('.edit-btn').addEventListener('click', () => {
      document.querySelector('.edit-list').classList.toggle('active');
    });
  });

  document.querySelector('.content-header-bottom .edit-list .edit-item .menu-btn.delete-btn').addEventListener("click", () => {
    document.querySelector(".backdrop").classList.add("active");
  })

  document.querySelector(
      '.backdrop .modal-wrapper .modal-btn-wrapper .modal-btn.modal-btn-cancel').addEventListener(
      "click", () => {
        document.querySelector(".backdrop").classList.remove("active");
      });
</script>

</body>
</html>