<%--
  Created by IntelliJ IDEA.
  User: kimheera
  Date: 2022/12/02
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수업 추가</title>
</head>
<body>
<form action="addok" method="post">
    <table id="edit">
        <tr><td>수업이름</td><td><input type="text" name="titleName"/></td></tr>
        <tr><td>교수님</td><td><input type="text" name="professor"/></td></tr>
        <tr><td>분반</td><td><input type="text" name="section"/></td></tr>
        <tr><td>학점</td><td><input type="text" name="credits"/></td></tr>
        <tr><td>유형</td><td><input type="text" name="type"/></td></tr>
        <tr><td>수업시간</td><td><input type="text" name="classTime"/></td></tr>
        <tr><td>이수구분</td><td><input type="text" name="category"/></td></tr>
        <tr><td>영어비율</td><td><input type="text" name="english"/></td></tr>
    </table>
    <button type="button" onclick="location.href='posts'">목록보기</button>
    <button type="submit">등록하기</button>
</form>

</body>
</html>
