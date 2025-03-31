CREATE DATABASE IF NOT EXISTS LoanManagementSystem;
USE LoanManagementSystem;

-- Users Table with all enhancements
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role ENUM('user', 'admin') NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address VARCHAR(255),
    credit_score INT DEFAULT 600,
    salary DECIMAL(12, 2) DEFAULT NULL COMMENT 'Monthly salary in local currency',
    account_status ENUM('active', 'suspended', 'blocked') DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL
);

-- Banks Table (new)
CREATE TABLE Banks (
    bank_id INT AUTO_INCREMENT PRIMARY KEY,
    bank_name VARCHAR(100) NOT NULL UNIQUE,
    home_loan_rate DECIMAL(5, 2) NOT NULL,
    car_loan_rate DECIMAL(5, 2) NOT NULL,
    education_loan_rate DECIMAL(5, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Loans Table with all enhancements
CREATE TABLE Loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    bank_id INT,
    loan_type ENUM('home', 'car', 'education') NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL,
    tenure INT NOT NULL COMMENT 'Loan tenure in months',
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    emi DECIMAL(12, 2) COMMENT 'Calculated EMI amount',
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    processed_date TIMESTAMP NULL,
    processed_by INT NULL COMMENT 'Admin user ID who processed this loan',
    remarks VARCHAR(255) COMMENT 'Admin remarks for approval/rejection',
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (bank_id) REFERENCES Banks(bank_id),
    FOREIGN KEY (processed_by) REFERENCES Users(user_id)
);

-- Optional: Loan Payments Table (for future enhancement)
CREATE TABLE IF NOT EXISTS LoanPayments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    loan_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
    transaction_reference VARCHAR(100),
    FOREIGN KEY (loan_id) REFERENCES Loans(loan_id)
);

-- Insert sample admin user
INSERT INTO Users (username, password, role, first_name, last_name, email, account_status)
VALUES ('admin', 'admin123', 'admin', 'System', 'Administrator', 'admin@loansystem.com', 'active');

-- Insert sample banks
INSERT INTO Banks (bank_name, home_loan_rate, car_loan_rate, education_loan_rate)
VALUES 
    ('State Bank of India', 8.4, 9.2, 10.1),
    ('HDFC Bank', 8.6, 9.5, 10.3),
    ('ICICI Bank', 8.7, 9.6, 10.5);

-- Insert sample user
INSERT INTO Users (username, password, role, first_name, last_name, email, credit_score, salary)
VALUES ('john_doe', 'password123', 'user', 'John', 'Doe', 'john@example.com', 720, 75000.00);














>> give me file structure 

LoanSystem/
├── src/
│   ├── loansystem/
│   │   ├── Main.java
│   │   ├── controller/
│   │   │   ├── AdminController.java
│   │   │   ├── BankController.java
│   │   │   ├── LoanController.java
│   │   │   └── UserController.java
│   │   ├── dao/
│   │   │   ├── BankDAO.java
│   │   │   ├── DBConnection.java
│   │   │   ├── LoanDAO.java
│   │   │   ├── UserAdminDAO.java
│   │   │   └── UserDAO.java
│   │   └── model/
│   │       ├── Bank.java
│   │       ├── Loan.java
│   │       └── User.java
│   ├── loansystem.resources/
│   │   ├── icons/
│   │   ├── images/
│   │   └── videos/
│   └── loansystem.view/
│       ├── AdminDashboard.java
│       ├── AdminSignupForm.java
│       ├── BankManagementFrame.java
│       ├── EMLCalculatorFrame.java
│       ├── LandingPage.java
│       ├── LoanApplicationFrame.java
│       ├── LoginFrame.java
│       ├── ProfileDialog.java
│       ├── SignupFrame.java
│       ├── UserDashboard.java
│       ├── UserManagementFrame.java
│       └── UserSignupForm.java
