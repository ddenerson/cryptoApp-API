

CREATE TABLE coin
(
  id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(100) NOT NULL,
  datetime TIMESTAMP,
  price  NUMERIC(20,2) NOT NULL,
  quantity NUMERIC(20,10) NOT NULL
);