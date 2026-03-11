<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>

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

    .home-container {
        background: #ffffff;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        text-align: center;
        width: 380px;
    }

    h2 {
        margin-bottom: 10px;
        color: #333;
    }

    p {
        color: #666;
        margin-bottom: 25px;
        font-size: 14px;
    }

    .btn-group {
        display: flex;
        gap: 12px;
        justify-content: center;
    }

    .btn {
        display: inline-block;
        padding: 10px 16px;
        border-radius: 4px;
        text-decoration: none;
        font-weight: 600;
        font-size: 14px;
        cursor: pointer;
    }

    .btn-primary {
        background: #4a90e2;
        color: #ffffff;
    }

    .btn-primary:hover {
        background: #357abd;
    }

    .btn-secondary {
        background: #f0f2f5;
        color: #333;
        border: 1px solid #ddd;
    }

    .btn-secondary:hover {
        background: #e4e7eb;
    }
</style>

</head>
<body>

<div class="home-container">
    <h2>Employee Management System</h2>
    <p>Manage employees easily – add, view, update and delete records.</p>

    <div class="btn-group">
        <a href="employee" class="btn btn-primary">Add Employee</a>
        <a href="viewemp" class="btn btn-secondary">View Employees</a>
        <a href="viewemp" class="btn btn-primary">Edit Employee</a>
    </div>
</div>

</body>
</html>