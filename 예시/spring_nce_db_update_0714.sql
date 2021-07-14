CREATE DATABASE  IF NOT EXISTS `spring_nce` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring_nce`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spring_nce
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `num` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` longtext NOT NULL,
  `writer` varchar(15) NOT NULL,
  `registered` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  `valid` varchar(1) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`num`),
  KEY `writer_idx` (`writer`),
  CONSTRAINT `writer` FOREIGN KEY (`writer`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'게시글','게시글2','qwer','2021-07-06 16:30:46',2,'I'),(2,'게시글1','게시글1','qwer','2021-07-06 16:30:47',1,'D'),(3,'7월7일(수정)','1234(수정)','qwer','2021-07-07 12:50:01',7,'I'),(4,'엉엉','ㅠㅠ','qwer','2021-07-07 16:08:17',3,'I'),(8,'아이디 없으면?','오류메세지 나옴','qwer','2021-07-07 16:10:51',0,'I'),(9,'7월9일','root에 컨트롤러 안지워서...','qwer','2021-07-09 09:32:09',3,'I'),(10,'345','2342\r\n\r\n55','qwer','2021-07-09 09:58:20',12,'I'),(11,'1234','12341414','qwer','2021-07-09 14:22:45',14,'I'),(12,'\"hi\"','hihi','qwer','2021-07-12 11:51:15',8,'I'),(13,'713','7123','abc123','2021-07-13 16:22:44',8,'I'),(14,'mysql에 아이디 추가하기','기존 데이터베이스랑 어떻게 연동하더라?','abc123','2021-07-14 12:55:40',5,'I'),(15,'123421','123414','qwer','2021-07-14 14:00:12',2,'I'),(16,'게시글번호 확인 용도','게시글번호 가져와서 나중에 파일업로드할때 씀','abc123','2021-07-14 16:32:32',18,'I'),(17,'첨부파일 테스트1','첨부','abc123','2021-07-14 17:06:38',1,'I'),(18,'첨부경로변경','\"E:\\\\JAVA_NCE\\\\project_nce\\\\uploadfiles\"로 변경함(보드서비스임플, 서블릿 두부분)\r\n\r\n고양이 사진','abc123','2021-07-14 17:25:28',0,'I');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `num` int NOT NULL AUTO_INCREMENT,
  `board` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` varchar(1) NOT NULL DEFAULT 'I',
  `ori_name` varchar(255) NOT NULL,
  PRIMARY KEY (`num`),
  KEY `board_idx` (`board`),
  CONSTRAINT `board` FOREIGN KEY (`board`) REFERENCES `board` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,17,'/2021/07/14/3822ba4c-3920-43b2-b7a6-253369e0c285_beach.jpg','I','beach.jpg'),(2,18,'/2021/07/14/b3e484f5-4ac5-4147-b959-d29d1b4a9412_고양이.jpg','I','고양이.jpg');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(15) NOT NULL,
  `pw` varchar(255) NOT NULL,
  `gender` varchar(1) NOT NULL DEFAULT 'M',
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL DEFAULT ' ',
  `authority` varchar(45) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('1234','$2a$10$SG/T3esKmY3o/l.xMq6lVuaj5Aaq1uO1xqEwUaTewWyUer5POYREi','M','','1234','USER'),('12345','$2a$10$BhVDVal93JvhfvNawbTFzOa7lYC/ByaXM9sjDhF0Xu5rUI2yaiV4O','M','12345','12345','USER'),('abc123','$2a$10$Rrle6kSdG/DTu/IGsgVaiOtntzWjRlxijpqOsY89usYC/ELQHDipG','F','123@abc123','홍길동','USER'),('qwer','$2a$10$4NZOxktCsvCtqJHd8kTwBueYwVn4I7Jcu8YvdPYbM.vGX3js9sJ.K','F','1234@qwer','qwer','USER');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-14 17:42:22
