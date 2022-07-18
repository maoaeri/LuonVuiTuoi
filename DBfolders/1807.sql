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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) NOT NULL,
  `account_balance` bigint NOT NULL,
  `account_save_per_month` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `idnew_table_UNIQUE` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Tiền mặt',440000,'300000'),(2,'Ngân hàng 1',-15300000,'100000');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

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
  `category_type` int NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Thu',NULL,1),(2,'Chi',NULL,0),(3,'Lương',1,1),(4,'Thưởng',1,1),(5,'Được cho, tặng',1,1),(6,'Tiền lãi',1,1),(7,'Đi vay',1,1),(8,'Thu nợ',1,1),(9,'Khác',1,1),(10,'Sinh hoạt',2,0),(11,'Phát triển bản thân',2,0),(12,'Khác',2,0),(13,'Vay nợ',2,0),(14,'Ăn uống',10,0),(15,'Đồ dùng cá nhân',10,0),(16,'Vận chuyển',10,0),(17,'Nhà cửa',10,0),(18,'Hiếu hỉ, quà cáp',11,0),(19,'Trang phục',11,0),(20,'Sức khỏe',11,0),(21,'Công việc, học tập',11,0),(22,'Giải trí',11,0),(23,'Du lịch',11,0),(24,'Cho vay',13,0),(25,'Trả nợ',13,0);
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
  `fluctuation_amount` bigint NOT NULL,
  `fluctuation_note` varchar(45) NOT NULL,
  `fluctuation_date` datetime NOT NULL,
  `category_id` int NOT NULL,
  `fluctuation_is_fixed` tinyint NOT NULL,
  `account_id` int NOT NULL,
  `pre_amount` bigint NOT NULL,
  PRIMARY KEY (`fluctuation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fluctuation`
--

LOCK TABLES `fluctuation` WRITE;
/*!40000 ALTER TABLE `fluctuation` DISABLE KEYS */;
INSERT INTO `fluctuation` VALUES (1,20000,'Mua kẹo','2022-06-11 00:00:00',14,0,1,0),(14,2000000,'Đóng tiền nhà2','2022-08-01 00:00:00',17,0,0,2000000),(15,2000000,'Đóng tiền trọ','2022-07-02 00:00:00',17,1,2,0),(17,100000,'Tiền xăng','2022-07-17 00:00:00',10,1,1,0),(18,2000000,'Đóng tiền trọ','2022-07-02 00:00:00',12,1,2,0),(19,3000000,'Lương về','2022-07-15 00:00:00',3,1,-1,0),(20,2000000,'Lương về','2022-07-15 00:00:00',3,1,2,2000000),(21,2000000,'Lương về','2022-07-15 00:00:00',5,0,2,2000000),(22,10000000,'Bồ cho','2022-07-08 00:00:00',5,1,2,10000000),(23,20000000,'Bồ cho','2022-07-08 00:00:00',4,1,2,20000000),(24,200000,'Nộp quỹ','2022-07-18 00:00:00',11,0,2,0),(25,30000,'Đổ xăng','2022-07-19 00:00:00',10,1,1,30000),(26,300000,'Đồng phục','2022-06-05 00:00:00',19,1,1,0),(27,50000,'Vay của bạn','2022-06-22 00:00:00',7,1,1,50000),(31,30000,'Cho bạn vay','2022-07-28 00:00:00',24,1,1,0);
/*!40000 ALTER TABLE `fluctuation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuff`
--

DROP TABLE IF EXISTS `stuff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stuff` (
  `stuff_id` int NOT NULL AUTO_INCREMENT,
  `stuff_amount` double DEFAULT NULL,
  `category_id` int NOT NULL,
  `stuff_note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stuff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuff`
--

LOCK TABLES `stuff` WRITE;
/*!40000 ALTER TABLE `stuff` DISABLE KEYS */;
INSERT INTO `stuff` VALUES (7,300000,19,'Váy đi ăn cưới'),(8,500000,20,'Vitamin'),(9,20000000,21,'Laptop mới'),(10,300000,23,'Váy đi ăn cưới'),(11,300000,0,'Mua bàn'),(12,500000,18,'Quà cưới');
/*!40000 ALTER TABLE `stuff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-18 22:03:43
