drop TABLE users;
drop TABLE products;
drop TABLE users_products;
drop TABLE customers;

CREATE EXTERNAL TABLE IF NOT EXISTS users (userId String,fullName String ,address1 String, zip String, state String ,phone String ,email String )
  ROW FORMAT DELIMITED FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' LOCATION '$path/data/users';
CREATE EXTERNAL TABLE IF NOT EXISTS products (productId String,product String)
  ROW FORMAT DELIMITED FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' LOCATION '$path/data/products';
CREATE EXTERNAL TABLE IF NOT EXISTS  users_products (userId String ,productId String,active String )
  ROW FORMAT DELIMITED FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' LOCATION '$path/data/userproduct';
CREATE EXTERNAL TABLE IF NOT EXISTS  customers (customerId String,userId String,fullName String ,address1 String, zip String, state String ,phone String ,email String )
  ROW FORMAT DELIMITED FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' LOCATION '$path/data/customers';

