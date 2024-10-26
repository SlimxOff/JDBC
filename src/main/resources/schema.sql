CREATE TABLE CUSTOMERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    age INT,
    phone_number VARCHAR(20)
);

CREATE TABLE ORDERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    customer_id INT,
    product_name VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);

INSERT INTO CUSTOMERS (name, surname, age, phone_number) VALUES ('alexey', 'Ivanov', 30, '1234567890');
INSERT INTO ORDERS (date, customer_id, product_name, amount) VALUES ('2023-10-01', 1, 'Product A', 100.00);