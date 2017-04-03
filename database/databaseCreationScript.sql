SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `ClientDB` (
  `ClientID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  `Mail` CHAR(32) NOT NULL,
  `Password` CHAR(32) NOT NULL,
  PRIMARY KEY (`ClientID`)
)
CREATE TABLE IF NOT EXISTS `OrderDB` (
  `OrderID` INT(11) NOT NULL AUTO_INCREMENT,
  `ProdpackID`INT(11) NOT NULL,
  `Ordmoment` DATE,
  `Payment` INT(11) NOT NULL,
   PRIMARY KEY (`OrderID`)
  FOREIGN KEY (`ClientID`) REFERENCES Client DB (`ClientID`);
  )

  CREATE TABLE IF NOT EXISTS `ProductDB` (
  `ProductID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` CHAR(32) NOT NULL,
  `Category` CHAR(32) NOT NULL,
  `Price` INT(11) NOT NULL,
  PRIMARY KEY (`ProductID`)
)

CREATE TABLE IF NOT EXISTS `ProductPackDB` (
  `ProductpackID` INT(11) NOT NULL AUTO_INCREMENT,
  `Quantity`INT(11) NOT NULL,
  `ProductID` INT(11) NOT NULL,
  `Price` INT(11) NOT NULL,
  PRIMARY KEY (`ProductpackID`)
  FOREIGN KEY (`ProductID`) REFERENCES ProductDB (`ProductID`);
  )

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;