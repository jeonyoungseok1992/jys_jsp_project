<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
    }

    #mypage-form table{
        margin: auto;
    }
    #mypage-form input{
        margin: 5px;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <% 
    String userId = loginUser.getUserId();
    String userName = loginUser.getUserName();
    String phone = loginUser.getPhone() == null ? "" : loginUser.getPhone();
    String email = loginUser.getEmail() == null ? "" : loginUser.getEmail();
    String address = loginUser.getAddress() == null ? "" : loginUser.getAddress();
    String interest = loginUser.getInterest() == null ? "" : loginUser.getInterest();
    %>

    <div class="outer">
        <br>
        <h2 align="center">마이페이지</h2>
		<!-- inclue해줬기 때문에 include안에서 선언한 contextPath를 사용 가능 -->
        <form action="/myPage.me" id="mypage-form" method="post">   
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" value="<%= userId %>" readonly></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" value="<%= userName %>" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력" value="<%= phone %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email" value="<%= email %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" value="<%= address %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" name="interest" id="sports" value="운동">
                        <label for="sports">운동</label>
    
                        <input type="checkbox" name="interest" id="climbing" value="등산">
                        <label for="climbing">등산</label>
    
                        <input type="checkbox" name="interest" id="fishing" value="낚시">
                        <label for="fishing">낚시</label>
                        <br>
                        <input type="checkbox" name="interest" id="cooking" value="요리">
                        <label for="cooking">요리</label>
    
                        <input type="checkbox" name="interest" id="game" value="게임">
                        <label for="game">게임</label>
    
                        <input type="checkbox" name="interest" id="movie" value="영화">
                        <label for="movie">영화</label>
                    </td>
                </tr>
            </table>
            
            <script>
            	const interest = "<%=interest%>";        <%-- 문자열로 가져오기때문에   --%>    
            	const inputArr = document.querySelectorAll("input[name=interest]");
            	console.log(typeof interest)
            	console.log(interest)
            	console.log(inputArr)
            	
            	for (let input of inputArr){		//가져온 checkbox요소들을 전부 반복한다
            		if (interest.includes(input.value)){	// interest에 input.value의 값이 포함되어 있다면 true
            			input.checked = true;	//해당 input의 checked는 true로 변경한다(체크처리)
            		}
            	}
            </script>
    
            <br><br>
    
            <div align = "center">
                <button type="submit">정보변경</button>
                <button type="button">비밀번호변경</button>
                <button type="button">회원탈퇴</button>
            </div>
    
            <br><br>
    
        </form>
    </div>
   

</body>
</html>