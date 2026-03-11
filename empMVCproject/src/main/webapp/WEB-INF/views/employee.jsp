<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .form-container {
        background: #ffffff;
        padding: 25px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        width: 350px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .error-msg {
        color: #d9534f;
        background: #fbeaea;
        border: 1px solid #f5c6cb;
        padding: 8px;
        margin-bottom: 15px;
        border-radius: 4px;
        text-align: center;
        font-weight: 600;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: 600;
        margin-bottom: 5px;
        color: #555;
    }

    input[type="text"],
    input[type="number"] {
        width: 100%;
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }

    input[type="text"]:focus,
    input[type="number"]:focus {
        outline: none;
        border-color: #4a90e2;
    }

    .btn-submit {
        width: 100%;
        padding: 10px;
        background: #4a90e2;
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 15px;
        font-weight: 600;
        cursor: pointer;
    }

    .btn-submit:hover {
        background: #357abd;
    }
</style>

</head>
<body>

<div class="form-container">
    <h2>Add Emp Details</h2>

    <!-- Error message -->
    <c:if test="${not empty error}">
        <div class="error-msg">
            ${error}
        </div>
    </c:if>

    <form action="save" method="post">

        <div class="form-group">
            <label>ID</label>
            <input type="number" name="eid" required>
        </div>

        <div class="form-group">
            <label>Name</label>
            <input type="text" name="ename" required>
        </div>

        <div class="form-group">
            <label>Salary</label>
            <input type="number" name="esalary" required>
        </div>

        <div class="form-group">
            <label>Gender</label>
            <input type="text" name="gender" required>
        </div>

        <input type="submit" value="Save" class="btn-submit">

    </form>
</div>

</body>
</html>