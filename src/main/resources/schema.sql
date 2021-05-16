
CREATE DATABASE  IF not EXISTS reactive;

USE reactive;

create table if not exists Product(
                           `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `Name` VARCHAR(255) ,
                           `Category` VARCHAR(255)  ,
                           `Price` VARCHAR(255)  ,
                           `Quantity` VARCHAR(255)

);


#INSERT INTO `reactive`.`product` (`ID`, `Name`, `Category`, `Price`, `Quantity`) VALUES ('1', 'Pizza', 'Food', '6', '2');
#INSERT INTO `reactive`.`product` (`ID`, `Name`, `Category`, `Price`, `Quantity`) VALUES ('2', 'Sushi', 'Food', '6', '2');
#INSERT INTO `reactive`.`product` (`ID`, `Name`, `Category`, `Price`, `Quantity`) VALUES ('3', 'Pizza', 'Food', '6', '2');
#INSERT INTO `reactive`.`product` (`ID`, `Name`, `Category`, `Price`, `Quantity`) VALUES ('4', 'Sushi', 'Food', '6', '2');
