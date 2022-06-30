-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: main
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(45) NOT NULL,
  `category_parent_id` int DEFAULT NULL,
  `category_type` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Thu',NULL,'Thu'),(2,'Chi',NULL,'Chi'),(3,'Luong',1,'Thu'),(4,'Thuong',1,'Thu'),(5,'Duoc cho, tang',1,'Thu'),(6,'Tien lai',1,'Thu'),(7,'Di vay',1,'Thu'),(8,'Thu no',1,'Thu'),(9,'Khac',1,'Thu'),(10,'Sinh hoat',2,'Chi'),(11,'Phat trien ban than',2,'Chi'),(12,'Khac',2,'Chi'),(13,'Vay no',2,'Chi'),(14,'An uong',10,'Chi'),(15,'Do dung ca nhan',10,'Chi'),(16,'Van chuyen',10,'Chi'),(17,'Nha cua',10,'Chi'),(18,'Hieu hi, qua cap',11,'Chi'),(19,'Trang phuc',11,'Chi'),(20,'Suc khoe',11,'Chi'),(21,'Cong viec, hoc tap',11,'Chi'),(22,'Giai tri',11,'Chi'),(23,'Du lich',11,'Chi'),(24,'Cho vay',13,'Chi'),(25,'Tra no',13,'Chi');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fluctuation`
--

DROP TABLE IF EXISTS `fluctuation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fluctuation` (
  `fluctuation_id` int NOT NULL AUTO_INCREMENT,
  `fluctuation_amount` double NOT NULL,
  `fluctuation_note` varchar(45) NOT NULL,
  `fluctuation_date` datetime NOT NULL,
  `category_id` int NOT NULL,
  `fluctuation_is_fixed` tinyint NOT NULL,
  PRIMARY KEY (`fluctuation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fluctuation`
--

LOCK TABLES `fluctuation` WRITE;
/*!40000 ALTER TABLE `fluctuation` DISABLE KEYS */;
INSERT INTO `fluctuation` VALUES (1,23,'wd','2002-03-21 00:00:00',2,0),(2,1,'đ','2002-04-21 00:00:00',2,0),(3,11,'đ','2002-04-21 00:00:00',2,0),(4,111,'đ','2002-04-21 00:00:00',2,0),(5,111,'đ','2002-04-21 00:00:00',16,0);
/*!40000 ALTER TABLE `fluctuation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-30  8:14:10
