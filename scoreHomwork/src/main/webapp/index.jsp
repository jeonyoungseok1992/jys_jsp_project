<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>학생 성적</h1>
    <form action="/scoreHomwork/ScoreCT" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="student_id">학번:</label>
        <input type="text" id="student_id" name="student_id" required><br><br>

        <label for="korean">국어 점수:</label>
        <input type="number" id="korean" name="korean" required><br><br>

        <label for="math">수학 점수:</label>
        <input type="number" id="math" name="math" required><br><br>

        <label for="english">영어 점수:</label>
        <input type="number" id="english" name="english" required><br><br>

        <label for="science">과학 점수:</label>
        <input type="number" id="science" name="science" required><br><br>

        <input type="submit" value="제출">
    </form>

</body>
</html>