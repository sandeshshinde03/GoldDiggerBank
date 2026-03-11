<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>

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

    input[readonly] {
        background: #f1f1f1;
        cursor: not-allowed;
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
    <h2>Update Emp Details</h2>

    <form action="/empMVCproject/update" method="post">

        <!-- Hidden actual ID -->
        <input type="hidden" name="eid" value="${emp.eid}">

        <div class="form-group">
            <label>ID</label>
            <input type="number" value="${emp.eid}" readonly>
        </div>

        <div class="form-group">
            <label>Name</label>
            <input type="text" name="ename" value="${emp.ename}" required>
        </div>

        <div class="form-group">
            <label>Salary</label>
            <input type="number" name="esalary" value="${emp.esalary}" required>
        </div>

        <div class="form-group">
            <label>Gender</label>
            <input type="text" name="gender" value="${emp.gender}" required>
        </div>

        <input type="submit" value="Update" class="btn-submit">

    </form>
</div>

</body>
</html>