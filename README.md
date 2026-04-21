# 🏦 GoldDiggerBank – Banking Web Application

## 📌 Project Overview
GoldDiggerBank is a full-stack Banking Web Application developed using **Spring Boot, Thymeleaf, and MySQL**.  
It allows users and administrators to perform essential banking operations such as account management, transactions, and loan processing.

This project demonstrates real-world banking functionalities with a structured backend and responsive UI.

---

## 🚀 Features

### 👤 Customer Features
- Create and manage bank accounts  
- Deposit and withdraw money  
- View transaction history  
- Apply for loans  

### 🛠️ Admin Features
- Manage customers and accounts  
- Approve or reject loan requests  
- Monitor all transactions  
- Access admin dashboard  

---

## 🧑‍💻 Technologies Used

- **Backend:** Java, Spring Boot, Spring MVC  
- **Database:** MySQL  
- **ORM:** Hibernate (JPA)  
- **Frontend:** Thymeleaf, Bootstrap 5  
- **Build Tool:** Maven  

---

## 🏗️ Architecture

The project follows **MVC (Model-View-Controller) Architecture**:

- **Controller Layer** → Handles HTTP requests  
- **Service Layer** → Business logic  
- **Repository Layer** → Database interaction  
- **Entity Layer** → Database models  

---

## 📁 Project Structure

```
BankingWebApplication/
│── src/main/java/com/BWA/
│ ├── Controller/
│ ├── Service/
│ ├── Repository/
│ ├── Entity/
│ ├── Configuration/
│ └── BankingWebApplication.java
│
│── src/main/resources/
│ ├── templates/
│ │ ├── adminpanel.html
│ │ ├── ShowAllAccounts.html
│ │ ├── ShowAllCustomers.html
│ │ ├── Transaction.html
│ │ ├── loanForm.html
│ │ └── ...
│ ├── static/
│ └── application.properties
│
│── pom.xml
```
