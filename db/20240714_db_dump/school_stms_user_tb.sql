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

-- Dump completed on 2024-07-14  8:56:38
