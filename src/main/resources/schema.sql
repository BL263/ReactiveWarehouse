
CREATE DATABASE  IF not EXISTS reactive;

USE reactive;

create table if not exists Product(
                           `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `Name` VARCHAR(255) ,
                           `Category` VARCHAR(255)  ,
                           `Price` VARCHAR(255)  ,
                           `Quantity` VARCHAR(255) ,
                           PRIMARY KEY (`ID`)

);

