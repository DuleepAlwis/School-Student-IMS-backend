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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-14  8:56:38
