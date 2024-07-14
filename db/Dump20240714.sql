-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: school_stms
-- ------------------------------------------------------
-- Server version	8.0.37-0ubuntu0.22.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class_incharge_tb`
--

DROP TABLE IF EXISTS `class_incharge_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_incharge_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classId` int NOT NULL,
  `tutorId` int DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`classId`),
  KEY `fk_class_incharge_tb_1_idx` (`classId`),
  KEY `fk_class_incharge_tb_2_idx` (`tutorId`),
  CONSTRAINT `fk_class_incharge_tb_1` FOREIGN KEY (`classId`) REFERENCES `class_tb` (`id`),
  CONSTRAINT `fk_class_incharge_tb_2` FOREIGN KEY (`tutorId`) REFERENCES `tutor_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_incharge_tb`
--

LOCK TABLES `class_incharge_tb` WRITE;
/*!40000 ALTER TABLE `class_incharge_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_incharge_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_tb`
--

DROP TABLE IF EXISTS `class_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `capacity` varchar(45) DEFAULT NULL,
  `org_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_class_tb_1_idx` (`org_id`),
  CONSTRAINT `fk_class_tb_1` FOREIGN KEY (`org_id`) REFERENCES `organization_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_tb`
--

LOCK TABLES `class_tb` WRITE;
/*!40000 ALTER TABLE `class_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications_tb`
--

DROP TABLE IF EXISTS `notifications_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` longtext,
  `userId` int NOT NULL,
  `sendOn` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`userId`),
  KEY `fk_notifications_tb_1_idx` (`userId`),
  CONSTRAINT `fk_notifications_tb_1` FOREIGN KEY (`userId`) REFERENCES `user_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications_tb`
--

LOCK TABLES `notifications_tb` WRITE;
/*!40000 ALTER TABLE `notifications_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_prop_tb`
--

DROP TABLE IF EXISTS `org_prop_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `org_prop_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orgId` int NOT NULL,
  `system_prop_id` int NOT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`orgId`,`system_prop_id`),
  KEY `fk_org_prop_tb_1_idx` (`orgId`),
  KEY `fk_org_prop_tb_2_idx` (`system_prop_id`),
  CONSTRAINT `fk_org_prop_tb_1` FOREIGN KEY (`orgId`) REFERENCES `organization_tb` (`id`),
  CONSTRAINT `fk_org_prop_tb_2` FOREIGN KEY (`system_prop_id`) REFERENCES `system_prop_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_prop_tb`
--

LOCK TABLES `org_prop_tb` WRITE;
/*!40000 ALTER TABLE `org_prop_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `org_prop_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_tb`
--

DROP TABLE IF EXISTS `organization_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orgName` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `orgCode` varchar(255) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `profile_pic` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `orgCode_UNIQUE` (`orgCode`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_tb`
--

LOCK TABLES `organization_tb` WRITE;
/*!40000 ALTER TABLE `organization_tb` DISABLE KEYS */;
INSERT INTO `organization_tb` VALUES (4,'Org1',NULL,NULL,NULL,'Org1_2024-07-07 10:37:06.864jOrOzQ',NULL,'2024-07-07 10:37:07','duleepalwis@gmail.com',NULL,NULL),(5,'aaaaaaaaa','aaaaaaaaaaaa','aaaaaaaaaaaa','aaaaaaaaaaaa','aaaaaaaaa_2024-07-13 23:26:22.866dKaZfZ','Y','2024-07-13 23:26:23','aaaaaa@g.com',NULL,NULL),(6,'org1','Wellawatha','11A','Colombo','org1_2024-07-13 23:56:28.319dLfNnG','Y','2024-07-13 23:56:28','edu.a@gmail.com',NULL,NULL),(7,'org1','Wellawatha','11A','Colombo','org1_2024-07-13 23:59:39.357hFoKiJ','Y','2024-07-13 23:59:39','edu.a1@gmail.com',NULL,NULL),(8,'Org2','Wellawatha','11A','Colombo','Org2_2024-07-14 00:03:54.329nPiNhM','Y','2024-07-14 00:03:54','a23@g.com',NULL,NULL),(9,'Org2','Wellawatha','11A','Colombo','Org2_2024-07-14 00:22:32.896eQjDrY','Y','2024-07-14 00:22:33','aaa@g.com',NULL,NULL),(10,'','','','','_2024-07-14 00:24:10.328zRyFbB','Y','2024-07-14 00:24:10','aa1a@g.com',NULL,NULL),(11,'Org3','Wellawatha','11A','Colombo','Org3_2024-07-14 00:26:33.297cZzIcQ','Y','2024-07-14 00:26:33','j23@g.com',NULL,NULL),(12,'Org4','Wellawatha','1A','Colombo','Org4_2024-07-14 00:31:37.996nPrToY','Y','2024-07-14 00:31:38','org4@g.com',NULL,NULL),(15,'Org5','Wellwatha','11A','Colombo','Org5_2024-07-14 00:46:25.361rBmJmB','Y','2024-07-14 00:46:25','org5@gmail.com',NULL,NULL),(16,'Org6','','','','Org6_2024-07-14 00:50:14.171zQfQoZ','Y','2024-07-14 00:50:14','org6@gmail.com',NULL,NULL);
/*!40000 ALTER TABLE `organization_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_tb`
--

DROP TABLE IF EXISTS `payment_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orgId` int NOT NULL,
  `date` date DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `paid` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`orgId`),
  KEY `fk_payment_tb_1_idx` (`orgId`),
  CONSTRAINT `fk_payment_tb_1` FOREIGN KEY (`orgId`) REFERENCES `organization_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_tb`
--

LOCK TABLES `payment_tb` WRITE;
/*!40000 ALTER TABLE `payment_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_tb`
--

DROP TABLE IF EXISTS `permission_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_tb`
--

LOCK TABLES `permission_tb` WRITE;
/*!40000 ALTER TABLE `permission_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result_exam_tb`
--

DROP TABLE IF EXISTS `result_exam_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result_exam_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentId` int NOT NULL,
  `year` varchar(45) DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `marks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`studentId`),
  KEY `fk_result_exam_tb_1_idx` (`studentId`),
  CONSTRAINT `fk_result_exam_tb_1` FOREIGN KEY (`studentId`) REFERENCES `student_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_exam_tb`
--

LOCK TABLES `result_exam_tb` WRITE;
/*!40000 ALTER TABLE `result_exam_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `result_exam_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission_tb`
--

DROP TABLE IF EXISTS `role_permission_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleId` int NOT NULL,
  `permissionId` int NOT NULL,
  PRIMARY KEY (`id`,`roleId`,`permissionId`),
  KEY `fk_role_permission_tb_1_idx` (`roleId`),
  KEY `fk_role_permission_tb_2_idx` (`permissionId`),
  CONSTRAINT `fk_role_permission_tb_1` FOREIGN KEY (`roleId`) REFERENCES `role_tb` (`id`),
  CONSTRAINT `fk_role_permission_tb_2` FOREIGN KEY (`permissionId`) REFERENCES `permission_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission_tb`
--

LOCK TABLES `role_permission_tb` WRITE;
/*!40000 ALTER TABLE `role_permission_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_tb`
--

DROP TABLE IF EXISTS `role_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  `createdOn` datetime DEFAULT '2024-01-01 08:59:59',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_tb`
--

LOCK TABLES `role_tb` WRITE;
/*!40000 ALTER TABLE `role_tb` DISABLE KEYS */;
INSERT INTO `role_tb` VALUES (1,'ORG_ADMIN','Y','2024-01-01 08:59:59'),(2,'ORG_MANAGER','Y','2024-01-01 08:59:59'),(3,'SYSTEM_ADMIN','Y','2024-01-01 08:59:59'),(4,'SYSTEM_MANAGER','Y','2024-01-01 08:59:59');
/*!40000 ALTER TABLE `role_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class_tb`
--

DROP TABLE IF EXISTS `student_class_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_class_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentId` int NOT NULL,
  `classId` int NOT NULL,
  `year` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`studentId`,`classId`),
  KEY `fk_student_class_tb_1_idx` (`classId`),
  KEY `fk_student_class_tb_2_idx` (`studentId`),
  CONSTRAINT `fk_student_class_tb_1` FOREIGN KEY (`classId`) REFERENCES `class_tb` (`id`),
  CONSTRAINT `fk_student_class_tb_2` FOREIGN KEY (`studentId`) REFERENCES `student_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class_tb`
--

LOCK TABLES `student_class_tb` WRITE;
/*!40000 ALTER TABLE `student_class_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_class_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_tb`
--

DROP TABLE IF EXISTS `student_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` char(7) DEFAULT NULL,
  `student_tbcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_tb`
--

LOCK TABLES `student_tb` WRITE;
/*!40000 ALTER TABLE `student_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_class_tb`
--

DROP TABLE IF EXISTS `subject_class_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_class_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subjectId` int NOT NULL,
  `classId` int NOT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`subjectId`,`classId`),
  KEY `fk_subject_class_tb_1_idx` (`classId`),
  KEY `fk_subject_class_tb_2_idx` (`subjectId`),
  CONSTRAINT `fk_subject_class_tb_1` FOREIGN KEY (`classId`) REFERENCES `class_tb` (`id`),
  CONSTRAINT `fk_subject_class_tb_2` FOREIGN KEY (`subjectId`) REFERENCES `subject_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_class_tb`
--

LOCK TABLES `subject_class_tb` WRITE;
/*!40000 ALTER TABLE `subject_class_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_class_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_tb`
--

DROP TABLE IF EXISTS `subject_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_tb`
--

LOCK TABLES `subject_tb` WRITE;
/*!40000 ALTER TABLE `subject_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_prop_tb`
--

DROP TABLE IF EXISTS `system_prop_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_prop_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT '2024-01-01 08:59:59',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_prop_tb`
--

LOCK TABLES `system_prop_tb` WRITE;
/*!40000 ALTER TABLE `system_prop_tb` DISABLE KEYS */;
INSERT INTO `system_prop_tb` VALUES (1,'GMAIL_USERNAME','dharshanaalwis96@gmail.com','2024-01-01 08:59:59'),(2,'GMAIL_PASSWORD','szui cqkt hbji xtlu','2024-01-01 08:59:59');
/*!40000 ALTER TABLE `system_prop_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_notes_tb`
--

DROP TABLE IF EXISTS `tutor_notes_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_notes_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `tutorId` int NOT NULL,
  `subjectId` int NOT NULL,
  PRIMARY KEY (`id`,`tutorId`,`subjectId`),
  KEY `fk_tutor_notes_tb_1_idx` (`tutorId`),
  KEY `fk_tutor_notes_tb_2_idx` (`subjectId`),
  CONSTRAINT `fk_tutor_notes_tb_1` FOREIGN KEY (`tutorId`) REFERENCES `tutor_tb` (`id`),
  CONSTRAINT `fk_tutor_notes_tb_2` FOREIGN KEY (`subjectId`) REFERENCES `subject_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_notes_tb`
--

LOCK TABLES `tutor_notes_tb` WRITE;
/*!40000 ALTER TABLE `tutor_notes_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutor_notes_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_subject_tb`
--

DROP TABLE IF EXISTS `tutor_subject_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_subject_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tutorId` int NOT NULL,
  `subjectId` int NOT NULL,
  `isActive` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`,`tutorId`,`subjectId`),
  KEY `fk_tutor_subject_tb_1_idx` (`tutorId`),
  KEY `fk_tutor_subject_tb_2_idx` (`subjectId`),
  CONSTRAINT `fk_tutor_subject_tb_1` FOREIGN KEY (`tutorId`) REFERENCES `tutor_tb` (`id`),
  CONSTRAINT `fk_tutor_subject_tb_2` FOREIGN KEY (`subjectId`) REFERENCES `subject_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_subject_tb`
--

LOCK TABLES `tutor_subject_tb` WRITE;
/*!40000 ALTER TABLE `tutor_subject_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutor_subject_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_tb`
--

DROP TABLE IF EXISTS `tutor_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `qualification_1` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `profile_pic` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` char(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_tb`
--

LOCK TABLES `tutor_tb` WRITE;
/*!40000 ALTER TABLE `tutor_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutor_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb`
--

DROP TABLE IF EXISTS `user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `isActive` char(5) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT '2024-01-01 08:59:59',
  `roleId` int DEFAULT NULL,
  `orgId` int DEFAULT NULL,
  `otp` varchar(45) DEFAULT NULL,
  `profile_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_tb_1_idx` (`orgId`),
  KEY `fk_user_tb_2_idx` (`roleId`),
  CONSTRAINT `fk_user_tb_1` FOREIGN KEY (`orgId`) REFERENCES `organization_tb` (`id`),
  CONSTRAINT `fk_user_tb_2` FOREIGN KEY (`roleId`) REFERENCES `role_tb` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'aaa@gmail.com',NULL,'Y',NULL,'1234567890','2024-07-06 00:00:00',NULL,NULL,NULL,NULL),(3,'aaa1@gmail.com',NULL,NULL,NULL,'1234567890','2024-01-01 08:59:59',NULL,NULL,NULL,NULL),(4,'aaa2@gmail.com',NULL,'Y',NULL,'1234567890','2024-01-01 08:59:59',NULL,NULL,NULL,NULL),(7,'aaa3@gmail.com','122334567789','Y','LK','$2a$10$IsPuP0f.evoW5bqYerKHPuY9QemZGZnYtajU7kUcCCIuvDCSLAl1K','2024-07-06 18:15:11',NULL,NULL,NULL,NULL),(10,'duleepalwis@gmail.com',NULL,'Y',NULL,'$2a$10$YfoElNZPY2x8pz2XhsKAE.BbOA0Vkv2LVQ2qSBEQbUN2lOm24Ivf2','2024-07-07 10:37:07',1,NULL,NULL,NULL),(11,'aaaaaa@g.com',NULL,'Y',NULL,'$2a$10$8lGweUvKUW1rzhHl9zsaYupgUkSp/.BMV86iEjA5HJ/IGPLvUC/RG','2024-07-13 23:26:27',1,NULL,NULL,NULL),(12,'edu.a@gmail.com',NULL,'Y',NULL,'$2a$10$Jd61e4Q6fDZZIKauqIDJd.6k2e1H5iWW6zNz2ByqDAlLymdJny5sW','2024-07-13 23:56:29',1,NULL,NULL,NULL),(13,'edu.a1@gmail.com',NULL,'Y',NULL,'$2a$10$9A1gprzc/aciMbxOsL.fH.5KM5LsTXUcg0AANzmodIDXSOWUUVCRS','2024-07-13 23:59:40',1,NULL,NULL,NULL),(14,'a23@g.com',NULL,'Y',NULL,'$2a$10$3UFhzz.7HsjgR7jjwHrUU.fhLiLIcwTdMBeoEKqKHnjM301/Xg0O6','2024-07-14 00:03:55',1,NULL,NULL,NULL),(15,'aaa@g.com',NULL,'Y',NULL,'$2a$10$D3h5hiH1zH2d9qAmeW3wN.K7elNac746jIad1x4Z7U2Tk3qSlVJym','2024-07-14 00:22:35',1,NULL,NULL,NULL),(16,'aa1a@g.com',NULL,'Y',NULL,'$2a$10$ieAew2Y8PmNKtY.KYxC.8.reFgDkRrvHTKv1167ZLED8Sq0VnXQYi','2024-07-14 00:24:11',1,NULL,NULL,NULL),(17,'j23@g.com',NULL,'Y',NULL,'$2a$10$XH7FcKntJzK6VABXwFfepuhqFPVf03c5irxcKYMpwjw1mDMnygV.u','2024-07-14 00:26:34',1,NULL,NULL,NULL),(18,'org4@g.com',NULL,'Y',NULL,'$2a$10$TnzS7fid6YvLFTjeYWRDXOjfOEPKzwqOBOxjeoGnz6uGkTuUsli8y','2024-07-14 00:31:39',1,NULL,NULL,NULL),(21,'org5@gmail.com',NULL,'Y',NULL,'$2a$10$2X1VNUXVaGaMzxeJ1.88EuOL3jgf8fsqNXTBapP8TrNlMInQ6TF6.','2024-07-14 00:46:26',1,NULL,NULL,NULL),(22,'org6@gmail.com',NULL,'Y',NULL,'$2a$10$u5xh.i8HolQg28TU0fTndeer.xNDwQFQcfrInOC..4ZutetgB8NTq','2024-07-14 00:50:14',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-14  8:58:32
