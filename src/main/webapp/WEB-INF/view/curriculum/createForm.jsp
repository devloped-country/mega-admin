<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Mega - Curriculum</title>
  <link />
  <link rel="stylesheet" href="../../../style/reset.css">
  <link rel="stylesheet" href="../../../style/curriculum/createNotice.css" type="text/css">
  <link rel="stylesheet" href="../../../style/header.css">
  <link rel="stylesheet" href="../../../style/footer.css">
</head>

<body>
  <%@ include file="/WEB-INF/layout/header.jsp" %>
  <div class="CreateNoticeWrapper">
    <div class="nav">
      <h1 class="title">커리큘럼</h1>
    </div>
    <form id="createForm" action="createCurriculum.do" method="post" class="create-form">
      <div class="content">
        <h2 class="add-text">과목 추가</h2>
        <h6 class="add-text-info">과목 정보를 입력해 주세요</h6>
        <div class="content-header">
          <div class="content-header-right">
            <label class="content-header-label">교과목명 <input type="text" class="notice-title" name="subject" placeholder="과목을 입력해주세요." maxlength="50"
                autofocus />
             </label>

          </div>

          <div class="content-header-right">
            <label class="content-header-label">
              시간
              <input type="text" class="notice-title" name="time" placeholder="시간을 입력해주세요." maxlength="50"
                oninput="validateNumber(this)" />
              <span id="timeError"></span>
            </label>

          </div>

          <div class="content-header-date">
            기간
          <div class="content-date">
          <div class="content-header-right">
            <label class="content-header-label"><input id="startDate" type="date" class="notice-title" max="2023-12-31" min="2023-05-25"
                name="startDate" onchange="validateDate()" /></label>
          </div>

          <p class="center">~</p>

          <div class="content-header-right">
            <label class="content-header-label"><input id="endDate" type="date" class="notice-title" max="2023-12-31" min="2023-05-25"
                name="endDate" onchange="validateDate()" /></label>

          </div>
            </div><span id="dateError"></span>
        </div>
      </div>


      <div class="content-detail">
        <div class="detail-subject-title">
        상세 교과 내용
        </div>
        <div class="content-header content-header-custom content-detail-item">
          <div class="content-header-right">
            <input type="text" class="notice-title notice-title-custom" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50"
              autofocus />
              <img src="../../../images/minus-Vector.svg" alt="제거 버튼" class="remove-button" onclick="remove_inputbox(this.closest('.content-header'))">
          </div>
        </div>

        <!-- 새로운 input 추가 -->
        <div id="additionalInputContainer">
        </div>

        <div class="content-footer2">
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
      </div>
      <div class="CreateNoticeModal">
        <div class="backdrop">
          <div class="modal-wrapper">
            <div class="modal-desc-wrapper">
              <h2 class="modal-title">취소</h2>
              <p class="modal-desc">목록으로 돌아가시겠습니까?</p>
            </div>
            <div class="modal-btn-wrapper">
              <button class="modal-btn modal-btn-cancel" type="button">취소</button>
              <button class="modal-btn modal-btn-confirm" type="button">확인</button>
            </div>
          </div>
        </div>
      </div>

      <div class="ValidationModal">
        <div class="backdrop">
          <div class="modal-wrapper">
            <div class="modal-desc-wrapper">
              <h2 class="modal-title">입력 값 오류</h2>
              <p class="modal-desc">필수값이 입력되지 않았거나 잘못 입력되었습니다.</p>
            </div>
            <div class="modal-btn-wrapper">
              <button class="modal-btn modal-btn-confirm" type="button">확인</button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
  <%@ include file="/WEB-INF/layout/footer.jsp" %>
  <script>
    document.addEventListener('DOMContentLoaded', function () {
      const form = document.getElementById('createForm');

      form.addEventListener('submit', function (event) {
        const subject = form['subject'].value;
        const time = form['time'].value;
        const startDate = form['startDate'].value;
        const endDate = form['endDate'].value;

        let invalidInput = false;

        // 기존의 빈 값 체크
        if (!subject || !time || !startDate || !endDate) {
          invalidInput = true;
        }

        // 숫자인지 체크
        if (isNaN(time)) {
          invalidInput = true;
        }

        if (invalidInput) {
          event.preventDefault(); // form의 submit을 막습니다.
          // ValidationModal을 띄웁니다.
          document.querySelector(".ValidationModal .backdrop").classList.add("active");
        }
      });

      // 모달의 "확인" 버튼에 이벤트 리스너를 추가
      document.querySelector('.ValidationModal .modal-btn-wrapper .modal-btn.modal-btn-confirm').addEventListener("click", () => {
        // 모달을 닫습니다.
        document.querySelector(".ValidationModal .backdrop").classList.remove("active");
      });
    });



    function validateDate() {
      const startDate = document.getElementById("startDate").value;
      const endDate = document.getElementById("endDate").value;
      const errorElement = document.getElementById("dateError");

      if (startDate && endDate && new Date(startDate) > new Date(endDate)) {
        errorElement.textContent = "시작 기간은 종료 기간보다 빨라야 합니다";
      } else {
        errorElement.textContent = "";
      }
    }


    function validateNumber(inputElement) {
      const value = inputElement.value;
      const errorElement = document.getElementById("timeError");

      if (isNaN(value)) {
        errorElement.textContent = "숫자를 입력하시오";
      } else {
        errorElement.textContent = "";
      }
    }


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
    newDiv.className = "content-header content-header-custom content-detail-item";

    // 새로운 div 요소 내에 레이블과 input을 추가
    const newLabel = document.createElement("div");
    newLabel.className = "content-header-right";

    const newInput = document.createElement("input");
    newInput.type = "text";
    newInput.className = "notice-title notice-title-custom";
    newInput.name = "detail";
    newInput.placeholder = "상세교과내용을 입력해주세요.";
    newInput.maxLength = "50";

    // "제거" 이미지 버튼을 생성
    const newImageButton = document.createElement("img");
    newImageButton.src = "../../../images/minus-Vector.svg";
    newImageButton.alt = "제거 버튼";
    newImageButton.className = "remove-button";
    newImageButton.onclick = function () { remove_inputbox(newDiv); };

    // 레이블과 input, 이미지 버튼을 새로운 div에 추가
    newLabel.appendChild(newInput);
    newLabel.appendChild(newImageButton);
    newDiv.appendChild(newLabel);

    // 추가할 컨테이너 선택
    const container = document.getElementById("additionalInputContainer");

    // 컨테이너에 새로운 div 요소 추가
    container.appendChild(newDiv);
    }

    function remove_inputbox(divElement) {
      if(document.querySelectorAll(".content-detail-item").length <= 1) {
        return;
      }

      divElement.remove();
    }
  </script>
</body>
</html>