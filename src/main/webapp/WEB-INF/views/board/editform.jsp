<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kimheera
  Date: 2022/12/02
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>수정</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="POST" action="../editok">
    <form:hidden path="seq"/>
    <table id="edit">
        <tr>
            <td>수업이름</td>
            <td><form:input path="titleName"/></td>
        </tr>
        <tr>
            <td>교수님</td>
            <td><form:input path="professor"/></td>
        </tr>
        <tr>
            <td>분반</td>
            <td><form:input path="section"/></td>
        </tr>
        <tr>
            <td>학점</td>
            <td><form:input path="credits"/></td>
        </tr>
        <tr>
            <td>유형</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>수업시간</td>
            <td><form:input path="classTime"/></td>
        </tr>
        <tr>
            <td>이수구분</td>
            <td><form:input path="category"/></td>
        </tr>
        <tr>
            <td>영어비율</td>
            <td><form:input path="english"/></td>
        </tr>
    </table>
    <input type="submit" value="수정하기"/>
    <input type="button" value="취소하기" onclick="history.back()"/>
</form:form>
</body>
</html>
