<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>


<html>

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>커리큘럼</title>
    <link />
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/curriculum/createNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
  </head>

  <body>
    <div class="CreateNoticeWrapper">
      <div class="nav">
        <h1 class="title">커리큘럼😜</h1>
      </div>
      <form action="createCurriculum.do" method="post" class="create-form">
        <div class="content">
          <h2>과목 추가</h2>
          <h3>과목 정보를 입력해 주세요</h3>
          <div class="content-header">
            <div class="content-header-right">
              <label>교과목명 <input type="text" class="notice-title" name="subject" placeholder="과목을 입력해주세요." maxlength="50" autofocus /></label>
            </div>
          </div>

          <div class="content-header">
            <div class="content-header-right">
              <label>시간 <input type="text" class="notice-title" name="time" placeholder="시간을 입력해주세요." maxlength="50" autofocus /></label>
            </div>
            <div class="content-header-right">
              <label>기간 <input type="date" max="2023-12-31" min="2023-05-25" name="startDate" /></label>
            </div>
            <div class="content-header-right">
              <label> ~ <input type="date" max="2023-12-31" min="2023-05-25" name="endDate" /></label>
            </div>
          </div>

          상세 교과 내용🚩
          <div class="content-header">
            <div class="content-header-right">
              <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50" autofocus />
              <input type="button" value="제거" onclick="remove_inputbox(this.closest('.content-header'))">
            </div>
          </div>

          <div class="content-header">
            <div class="content-header-right">
              <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50" autofocus />
              <input type="button" value="제거" onclick="remove_inputbox(this.closest('.content-header'))">
            </div>
          </div>
          <div class="content-header">
            <div class="content-header-right">
              <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50" autofocus />
              <input type="button" value="제거" onclick="remove_inputbox(this.closest('.content-header'))">
            </div>
          </div>

          <!-- 새로운 input 추가 -->
          <div id="additionalInputContainer">
          </div>

          <div class="content-footer">
            <div>
              <button type="button" class="content-add-btn" onclick="add_inputbox()">
                상세 교과 내용 추가
              </button>
            </div>
          </div>

          <div class="content-footer">
            <button type="button" class="content-btn">
              취소
            </button>
            <button type="submit" class="content-btn">추가</button>
          </div>
        </div>

        <div class="CreateNoticeModal">
          <div class="backdrop">
              <div class="modal-wrapper">
                  <div class="modal-desc-wrapper">
                      <h2 class="modal-title">취소</h2>
                      <p class="modal-desc">취소하시겠습니까?</p>
                  </div>
                  <div class="modal-btn-wrapper">
                      <button class="modal-btn modal-btn-cancel" type="button">취소</button>
                      <button class="modal-btn modal-btn-confirm" type="button">확인</button>
                  </div>
              </div>
          </div>
      </div>
      </form>
    </div>


    <script>

      document.querySelector('.content-footer .content-btn').addEventListener("click", () => {
        document.querySelector(".CreateNoticeModal .backdrop").classList.add("active");
      });

      document.querySelector(
        '.backdrop .modal-wrapper .modal-btn-wrapper .modal-btn.modal-btn-cancel').addEventListener(
          "click", () => {
            document.querySelector(".backdrop").classList.remove("active");

          });

      document.querySelector(
        '.backdrop .modal-wrapper .modal-btn-wrapper .modal-btn.modal-btn-confirm').addEventListener("click", () => {
        document.querySelector(".backdrop").classList.remove("active");

        window.location.href = "/curriculum/getCurriculumList.do";
      });


      function add_inputbox() {
        // 새로운 div 요소를 생성 (포장용)
        const newDiv = document.createElement("div");
        newDiv.className = "content-header";

        // 새로운 div 요소 내에 레이블과 input을 추가
        const newLabel = document.createElement("div");
        newLabel.className = "content-header-right";

        const newInput = document.createElement("input");
        newInput.type = "text";
        newInput.className = "notice-title";
        newInput.name = "detail";
        newInput.placeholder = "상세교과내용을 입력해주세요.";
        newInput.maxLength = "50";

        // "제거" 버튼을 생성
        const newButton = document.createElement("input");
        newButton.type = "button";
        newButton.value = "제거";
        newButton.onclick = function () { remove_inputbox(newDiv); };

        // 레이블과 input, 버튼을 새로운 div에 추가
        newLabel.appendChild(newInput);
        newLabel.appendChild(newButton);
        newDiv.appendChild(newLabel);

        // 추가할 컨테이너 선택
        const container = document.getElementById("additionalInputContainer");

        // 컨테이너에 새로운 div 요소 추가
        container.appendChild(newDiv);
      }

      function remove_inputbox(divElement) {
        divElement.remove();
      }

    </script>


  </body>

</html>


<%@ include file="/WEB-INF/layout/footer.jsp" %>