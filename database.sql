CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    amount DOUBLE,
    category VARCHAR(50),
    date DATE
);
