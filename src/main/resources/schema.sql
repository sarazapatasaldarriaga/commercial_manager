CREATE TABLE supplier (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(10) NOT NULL,
  address VARCHAR(255) NOT NULL,
  date DATE
);

CREATE TABLE product (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL,
  stock INT NOT NULL,
  supplier_id BIGINT,
  CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);

CREATE TABLE client (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(15) NOT NULL
);
