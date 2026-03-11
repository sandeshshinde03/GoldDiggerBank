<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 30px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .actions {
        max-width: 900px;
        margin: 0 auto 15px auto;
        text-align: right;
    }

    .add-btn {
        display: inline-block;
        padding: 8px 14px;
        background: #2ecc71;
        color: #fff;
        text-decoration: none;
        border-radius: 4px;
        font-weight: 600;
        font-size: 14px;
    }

    .add-btn:hover {
        background: #27ae60;
    }

    .table-container {
        max-width: 900px;
        margin: 0 auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 12px 10px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background: #4a90e2;
        color: #ffffff;
        font-weight: 600;
        text-transform: uppercase;
        font-size: 13px;
        letter-spacing: 0.5px;
    }

    tr:nth-child(even) {
        background: #f9fafc;
    }

    tr:hover {
        background: #eef4ff;
    }

    a.edit-btn {
        color: #3498db;
        text-decoration: none;
        font-weight: 600;
    }

    a.edit-btn:hover {
        text-decoration: underline;
    }

    a.delete-btn {
        color: #e74c3c;
        text-decoration: none;
        font-weight: 600;
    }

    a.delete-btn:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<h2>Employee List</h2>

<!-- Add Employee Button -->
<div class="actions">
    <a class="add-btn" href="${pageContext.request.contextPath}/employee">
        + Add Employee
    </a>
</div>

<div class="table-container">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Gender</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="e" items="${list}">
            <tr>
                <td>${e.eid}</td>
                <td>${e.ename}</td>
                <td>${e.esalary}</td>
                <td>${e.gender}</td>
                <td>
                    <a class="edit-btn" 
                       href="${pageContext.request.contextPath}/edit/${e.eid}">
                        Edit
                    </a>
                </td>
                <td>
                    <a class="delete-btn" 
                       href="${pageContext.request.contextPath}/delete/${e.eid}">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>