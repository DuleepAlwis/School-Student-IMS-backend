-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema school_stms
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema school_stms
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `school_stms` ;
USE `school_stms` ;

-- -----------------------------------------------------
-- Table `school_stms`.`organization_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`organization_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgName` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `orgCode` VARCHAR(255) NULL,
  `isActive` CHAR(5) NULL,
  `createdOn` DATETIME NULL,
  `email` VARCHAR(45) NULL,
  `profile_pic` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `orgCode_UNIQUE` (`orgCode` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`permission_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`permission_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `permissionName` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  `createdOn` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`role_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`role_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  `createdOn` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`role_permission_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`role_permission_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roleId` INT NOT NULL,
  `permissionId` INT NOT NULL,
  PRIMARY KEY (`id`, `roleId`, `permissionId`),
  INDEX `fk_role_permission_tb_1_idx` (`roleId` ASC) VISIBLE,
  INDEX `fk_role_permission_tb_2_idx` (`permissionId` ASC) VISIBLE,
  CONSTRAINT `fk_role_permission_tb_1`
    FOREIGN KEY (`roleId`)
    REFERENCES `school_stms`.`role_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_tb_2`
    FOREIGN KEY (`permissionId`)
    REFERENCES `school_stms`.`permission_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`user_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`user_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  `country` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `createdOn` DATETIME NULL,
  `roleId` INT NULL,
  `orgId` INT NULL,
  `otp` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_user_tb_1_idx` (`orgId` ASC) VISIBLE,
  INDEX `fk_user_tb_2_idx` (`roleId` ASC) VISIBLE,
  CONSTRAINT `fk_user_tb_1`
    FOREIGN KEY (`orgId`)
    REFERENCES `school_stms`.`organization_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_tb_2`
    FOREIGN KEY (`roleId`)
    REFERENCES `school_stms`.`role_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`system_prop_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`system_prop_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `value` VARCHAR(255) NULL,
  `createdOn` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`org_prop_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`org_prop_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgId` INT NOT NULL,
  `system_prop_id` INT NOT NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`, `orgId`, `system_prop_id`),
  INDEX `fk_org_prop_tb_1_idx` (`orgId` ASC) VISIBLE,
  INDEX `fk_org_prop_tb_2_idx` (`system_prop_id` ASC) VISIBLE,
  CONSTRAINT `fk_org_prop_tb_1`
    FOREIGN KEY (`orgId`)
    REFERENCES `school_stms`.`organization_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_org_prop_tb_2`
    FOREIGN KEY (`system_prop_id`)
    REFERENCES `school_stms`.`system_prop_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`tutor_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`tutor_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `userId` INT NULL,
  `qualification_1` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `profile_pic` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `gender` CHAR(7) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`student_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`student_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `dob` DATE NULL,
  `gender` CHAR(7) NULL,
  `student_tbcol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`class_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`class_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `capacity` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`student_class_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`student_class_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `studentId` INT NOT NULL,
  `classId` INT NOT NULL,
  `year` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`, `studentId`, `classId`),
  INDEX `fk_student_class_tb_1_idx` (`classId` ASC) VISIBLE,
  INDEX `fk_student_class_tb_2_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_student_class_tb_1`
    FOREIGN KEY (`classId`)
    REFERENCES `school_stms`.`class_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_class_tb_2`
    FOREIGN KEY (`studentId`)
    REFERENCES `school_stms`.`student_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`class_incharge_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`class_incharge_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `classId` INT NOT NULL,
  `tutorId` INT NULL,
  `year` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`, `classId`),
  INDEX `fk_class_incharge_tb_1_idx` (`classId` ASC) VISIBLE,
  INDEX `fk_class_incharge_tb_2_idx` (`tutorId` ASC) VISIBLE,
  CONSTRAINT `fk_class_incharge_tb_1`
    FOREIGN KEY (`classId`)
    REFERENCES `school_stms`.`class_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_incharge_tb_2`
    FOREIGN KEY (`tutorId`)
    REFERENCES `school_stms`.`tutor_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`subject_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`subject_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `code` VARCHAR(45) NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`tutor_notes_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`tutor_notes_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `file_type` VARCHAR(45) NULL,
  `location` VARCHAR(255) NULL,
  `tutorId` INT NOT NULL,
  `subjectId` INT NOT NULL,
  PRIMARY KEY (`id`, `tutorId`, `subjectId`),
  INDEX `fk_tutor_notes_tb_1_idx` (`tutorId` ASC) VISIBLE,
  INDEX `fk_tutor_notes_tb_2_idx` (`subjectId` ASC) VISIBLE,
  CONSTRAINT `fk_tutor_notes_tb_1`
    FOREIGN KEY (`tutorId`)
    REFERENCES `school_stms`.`tutor_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tutor_notes_tb_2`
    FOREIGN KEY (`subjectId`)
    REFERENCES `school_stms`.`subject_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`tutor_subject_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`tutor_subject_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tutorId` INT NOT NULL,
  `subjectId` INT NOT NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`, `tutorId`, `subjectId`),
  INDEX `fk_tutor_subject_tb_1_idx` (`tutorId` ASC) VISIBLE,
  INDEX `fk_tutor_subject_tb_2_idx` (`subjectId` ASC) VISIBLE,
  CONSTRAINT `fk_tutor_subject_tb_1`
    FOREIGN KEY (`tutorId`)
    REFERENCES `school_stms`.`tutor_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tutor_subject_tb_2`
    FOREIGN KEY (`subjectId`)
    REFERENCES `school_stms`.`subject_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`subject_class_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`subject_class_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subjectId` INT NOT NULL,
  `classId` INT NOT NULL,
  `isActive` CHAR(5) NULL,
  PRIMARY KEY (`id`, `subjectId`, `classId`),
  INDEX `fk_subject_class_tb_1_idx` (`classId` ASC) VISIBLE,
  INDEX `fk_subject_class_tb_2_idx` (`subjectId` ASC) VISIBLE,
  CONSTRAINT `fk_subject_class_tb_1`
    FOREIGN KEY (`classId`)
    REFERENCES `school_stms`.`class_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_class_tb_2`
    FOREIGN KEY (`subjectId`)
    REFERENCES `school_stms`.`subject_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`result_exam_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`result_exam_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `studentId` INT NOT NULL,
  `year` VARCHAR(45) NULL,
  `semester` VARCHAR(45) NULL,
  `grade` VARCHAR(45) NULL,
  `comment` VARCHAR(45) NULL,
  `marks` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `studentId`),
  INDEX `fk_result_exam_tb_1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_result_exam_tb_1`
    FOREIGN KEY (`studentId`)
    REFERENCES `school_stms`.`student_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`payment_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`payment_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgId` INT NOT NULL,
  `date` DATE NULL,
  `amount` VARCHAR(45) NULL,
  `paid` CHAR(5) NULL,
  PRIMARY KEY (`id`, `orgId`),
  INDEX `fk_payment_tb_1_idx` (`orgId` ASC) VISIBLE,
  CONSTRAINT `fk_payment_tb_1`
    FOREIGN KEY (`orgId`)
    REFERENCES `school_stms`.`organization_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `school_stms`.`notifications_tb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_stms`.`notifications_tb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` LONGTEXT NULL,
  `userId` INT NOT NULL,
  `sendOn` DATETIME NULL,
  PRIMARY KEY (`id`, `userId`),
  INDEX `fk_notifications_tb_1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_notifications_tb_1`
    FOREIGN KEY (`userId`)
    REFERENCES `school_stms`.`user_tb` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

