
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        #edit {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
        }
        #edit td, #edit th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #edit tr:nth-child(even){background-color: #f2f2f2;}
        #edit tr:hover {background-color: #ddd;}
        #edit th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <title>수업 정보 수정</title>
</head>
<body>
<h1>수업 정보 수정</h1>
<form:form modelAttribute="boardVO" method = "POST" action= "../editok">
    <form:hidden path="seq"/>
    <table id="edit">
        <tr>
            <td>Course Title</td>
            <td><form:input path = "titleName" /></td>
        </tr>
        <tr>
            <td>Professor</td>
            <td><form:input path = "professor" /></td>
        </tr>
        <tr>
            <td>Section</td>
            <td><form:input path = "section" /></td>
        </tr>
        <tr>
            <td>Credits</td>
            <td><form:input path = "credits" /></td>
        </tr>
        <tr>
            <td>Type</td>
            <td><form:input path = "type" /></td>
        </tr>
        <tr>
            <td>ClassTime</td>
            <td><form:input path = "classTime" /></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><form:input path = "category" /></td>
        </tr>
        <tr>
            <td>Eng. Rate</td>
            <td><form:input path = "english" /></td>
        </tr>
    </table>
    <input type="submit" value="수정" />
    <input type="button" value="취소" onclick="history.back()"/>
</form:form>
</body>
</html>