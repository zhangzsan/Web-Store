SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2.web-shop` DEFAULT CHARACTER SET utf8 ;
USE `java2.web-shop` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------

CREATE TABLE `java2.web-shop`.`clientdb` (
  `ClientID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Mail` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ClientID`));

CREATE TABLE IF NOT EXISTS `OrderDB` (
  `OrderID` INT(11) NOT NULL AUTO_INCREMENT,
  `ProdpackID`INT(11) NOT NULL,
  `Ordmoment` DATE,
  `Payment` INT(11) NOT NULL,
   PRIMARY KEY (`OrderID`),
  FOREIGN KEY (`ClientID`) REFERENCES ClientDB (`ClientID`)
  );

CREATE TABLE `java2.web-shop`.`productdb` (
  `ProductID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Category` VARCHAR(45) NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`ProductID`));

CREATE TABLE `java2.web-shop`.`categorydb` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CategoryID`));

CREATE TABLE IF NOT EXISTS `ProductPackDB` (
  `ProdpackID` INT(11) NOT NULL AUTO_INCREMENT,
  `Quantity`INT(11) NOT NULL,
  `ProductID` INT(11) NOT NULL,
  `Price` INT(11) NOT NULL,
  PRIMARY KEY (`ProductpackID`),
  FOREIGN KEY (`ProductID`) REFERENCES ProductDB (`ProductID`)
  )

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;