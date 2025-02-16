DROP DATABASE IF EXISTS `finance`;
CREATE DATABASE `finance`;
USE `finance`;
DROP TABLE IF EXISTS `expense`;
CREATE TABLE expense
 ( expenseID integer PRIMARY KEY AUTO_INCREMENT, 
	title text NOT NULL, 
	category text NOT NULL, 
	amount double NOT NULL, 
	dateincurred DATE NOT NULL );

DROP TABLE IF EXISTS `income`
create table income 
( incomeID integer PRIMARY KEY AUTO_INCREMENT, 
	title text NOT NULL, 
	amount double NOT NULL, 
	dateEarned DATE NOT NULL );

INSERT INTO expense VALUES (null, "Bicycle", "Health", 160.50, CURRENT_DATE)