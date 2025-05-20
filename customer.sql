use customerinsightpro;
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT NOT NULL
);

CREATE TABLE purchases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    product VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    purchase_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE DATABASE customer_db;

SHOW DATABASES;
ALTER TABLE customers ADD COLUMN location VARCHAR(255) NOT NULL;
select * from customers;
INSERT INTO customers (name, email, location, age) VALUES
('Alice Johnson', 'alice@example.com', 'Los Angeles', 25),
('Bob Smith', 'bob@example.com', 'Chicago', 35),
('Charlie Brown', 'charlie@example.com', 'San Francisco', 40);
