-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Student Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student Table` (
  `Student Id` INT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NULL,
  `Last_Name` VARCHAR(45) NULL,
  `Age` INT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`Student Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course Table` (
  `Course_ID` INT NULL AUTO_INCREMENT,
  `Course_Name` VARCHAR(45) NULL,
  `Course_Description` VARCHAR(45) NULL,
  `Credits` VARCHAR(45) NULL,
  PRIMARY KEY (`Course_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Enrollment Table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Enrollment Table` (
  `Enrollment ID` INT NULL AUTO_INCREMENT,
  `Student Table_Student Id` INT NULL,
  `Course Table_Course_ID` INT NULL,
  `Enrollment_Date` DATE NULL,
  PRIMARY KEY (`Enrollment ID`),
  CONSTRAINT `fk_Enrollment Table_Student Table`
    FOREIGN KEY (`Student Table_Student Id`)
    REFERENCES `mydb`.`Student Table` (`Student Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Enrollment Table_Course Table1`
    FOREIGN KEY (`Course Table_Course_ID`)
    REFERENCES `mydb`.`Course Table` (`Course_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
