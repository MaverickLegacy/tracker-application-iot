CREATE DATABASE carTrac_dev;
CREATE DATABASE carTrac_prod;

#Create database service accounts
CREATE USER 'carTrac_dev_user'@'localhost' IDENTIFIED BY 'user';
CREATE USER 'carTrac_prod_user'@'localhost' IDENTIFIED BY 'user';
CREATE USER 'carTrac_dev_user'@'%' IDENTIFIED BY 'user';
CREATE USER 'carTrac_prod_user'@'%' IDENTIFIED BY 'user';

#Database grants
GRANT SELECT ON carTrac_dev.* to 'carTrac_dev_user'@'localhost';
GRANT INSERT ON carTrac_dev.* to 'carTrac_dev_user'@'localhost';
GRANT DELETE ON carTrac_dev.* to 'carTrac_dev_user'@'localhost';
GRANT UPDATE ON carTrac_dev.* to 'carTrac_dev_user'@'localhost';
GRANT SELECT ON carTrac_prod.* to 'carTrac_prod_user'@'localhost';
GRANT INSERT ON carTrac_prod.* to 'carTrac_prod_user'@'localhost';
GRANT DELETE ON carTrac_prod.* to 'carTrac_prod_user'@'localhost';
GRANT UPDATE ON carTrac_prod.* to 'carTrac_prod_user'@'localhost';
GRANT SELECT ON carTrac_dev.* to 'carTrac_dev_user'@'%';
GRANT INSERT ON carTrac_dev.* to 'carTrac_dev_user'@'%';
GRANT DELETE ON carTrac_dev.* to 'carTrac_dev_user'@'%';
GRANT UPDATE ON carTrac_dev.* to 'carTrac_dev_user'@'%';
GRANT SELECT ON carTrac_prod.* to 'carTrac_prod_user'@'%';
GRANT INSERT ON carTrac_prod.* to 'carTrac_prod_user'@'%';
GRANT DELETE ON carTrac_prod.* to 'carTrac_prod_user'@'%';
GRANT UPDATE ON carTrac_prod.* to 'carTrac_prod_user'@'%';
