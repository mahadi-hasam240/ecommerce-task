CREATE TABLE CUSTOMERS(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) not null ,
    email VARCHAR(100) not null UNIQUE,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    approved_by VARCHAR(100),
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    approved_date TIMESTAMP,
    version BIGINT,
    ddl_version INT
);

CREATE TABLE ITEMS(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    approved_by VARCHAR(100) ,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    approved_date TIMESTAMP,
    version BIGINT,
    ddl_version INT
);

CREATE TABLE SALES(
    id SERIAL PRIMARY KEY,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    sale_date DATE NOT NULL,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    approved_by VARCHAR(100),
    created_date TIMESTAMP ,
    updated_date TIMESTAMP,
    approved_date TIMESTAMP,
    version BIGINT ,
    ddl_version INT,
    FOREIGN KEY (item_id) REFERENCES items(id)
);

CREATE TABLE WISHLISTS(
    id SERIAL PRIMARY KEY,
    item_id INT NOT NULL,
    customer_id INT NOT NULL,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    approved_by VARCHAR(100),
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    approved_date TIMESTAMP,
    version BIGINT,
    ddl_version INT,
    FOREIGN KEY (item_id) REFERENCES ITEMS(id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
)