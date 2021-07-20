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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'게시글','게시글2','qwer','2021-07-06 16:30:46',2,'I'),(2,'게시글1','게시글1','qwer','2021-07-06 16:30:47',1,'D'),(3,'7월7일(수정)','1234(수정)','qwer','2021-07-07 12:50:01',7,'I'),(4,'엉엉','ㅠㅠ','qwer','2021-07-07 16:08:17',3,'I'),(8,'아이디 없으면?','오류메세지 나옴','qwer','2021-07-07 16:10:51',0,'I'),(9,'7월9일','root에 컨트롤러 안지워서...','qwer','2021-07-09 09:32:09',3,'I'),(10,'345','2342\r\n\r\n55','qwer','2021-07-09 09:58:20',12,'I'),(11,'1234','12341414','qwer','2021-07-09 14:22:45',14,'I'),(12,'\"hi\"','hihi','qwer','2021-07-12 11:51:15',8,'I'),(13,'713','7123','abc123','2021-07-13 16:22:44',8,'I'),(14,'mysql에 아이디 추가하기','기존 데이터베이스랑 어떻게 연동하더라?','abc123','2021-07-14 12:55:40',5,'I'),(15,'123421','123414','qwer','2021-07-14 14:00:12',8,'I'),(16,'게시글번호 확인 용도','게시글번호 가져와서 나중에 파일업로드할때 씀','abc123','2021-07-14 16:32:32',21,'I'),(17,'첨부파일 테스트1','첨부','abc123','2021-07-14 17:06:38',1,'I'),(18,'첨부경로변경','\"E:\\\\JAVA_NCE\\\\project_nce\\\\uploadfiles\"로 변경함(보드서비스임플, 서블릿 두부분)\r\n\r\n고양이 사진','abc123','2021-07-14 17:25:28',14,'I'),(20,'첨부파일 수정 연습','(디비랑 폴더 강제로 삭제함 오류나서)\r\n\r\n폴더와 디비 둘다 확인하기 -> 파일 올렸다가 수정하고, 수정해본담엔 지워보기! \r\n\r\n1차: 수정 누른 뒤 파일첨부함  => 잘됨\r\n2차: 수정->첨부파일삭제-> 다른 파일 첨부 \r\n 2-1차: 에러남 (\" 맵퍼 오타\": 내용 수정X/첨부파일 폴더:바뀜/디비:둘다 I) \r\n     => 디비에서 임의로 이전파일 D로 수정하니 열렸으나 다시 첨부하니 에러나서 그냥 싹 지움\r\n  2-2차 : 수정->첨부파일 삭제->다른파일 첨부 \r\n디비 수정 다시하고 다시 삭제랑 삭제후 첨부 해보니까 됨\r\n\r\n\r\n','abc123','2021-07-15 13:21:15',22,'I'),(21,'7월 15일','첨부파일','abc123','2021-07-15 14:21:44',2,'D'),(22,'7월15일','1. 내용만 수정','abc123','2021-07-15 14:26:14',23,'I'),(23,'다중첨부파일','123','abc123','2021-07-15 16:48:57',65,'I'),(24,'1234','1234','abc123','2021-07-16 09:43:37',1,'D'),(25,'1234','1234','abc123','2021-07-16 09:48:53',1,'D'),(26,'123rr','123rr','abc123','2021-07-16 09:49:36',1,'D'),(27,'1111','1111','abc123','2021-07-16 10:55:04',31,'D'),(28,'asdf','asdf','abc123','2021-07-16 15:31:49',3,'D'),(29,'첨부파일 삭제함','1qa','abc123','2021-07-16 15:52:40',35,'I'),(30,'첨부파일 예시','123','abc123','2021-07-19 11:06:23',1,'D'),(31,'서머노트 테스트','<p><font color=\"#ff9c00\">부트스트랩4 링크 밑에거 두개로 적용하기</font></p><p><font color=\"#ff9c00\"><br></font></p><p><font color=\"#ff9c00\">창크기 늘리기</font></p><p><font color=\"#ff9c00\">수정. 디테일, 작성 모두 바꿔주기</font></p>','abc123','2021-07-19 16:20:20',57,'I');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,17,'/2021/07/14/3822ba4c-3920-43b2-b7a6-253369e0c285_beach.jpg','I','beach.jpg'),(2,18,'/2021/07/14/b3e484f5-4ac5-4147-b959-d29d1b4a9412_고양이.jpg','I','고양이.jpg'),(6,20,'/2021/07/15/0a3ae5a6-c247-4eb8-a519-56593b635322_콜라수염.jpg','D','콜라수염.jpg'),(7,20,'/2021/07/15/ee4406f6-f07f-4458-a734-f7435c786a7b_콜랑.jpg','D','콜랑.jpg'),(8,20,'/2021/07/15/63101eb1-f90e-432d-aa47-4d58a54d9111_콜라수염.jpg','D','콜라수염.jpg'),(9,20,'/2021/07/15/c6098fb1-8c11-4190-9cd0-aa23e0df51f1_콜랑.jpg','D','콜랑.jpg'),(10,21,'/2021/07/15/610cbd08-8ede-42a1-a0ba-09ededa62fa6_콜랑.jpg','I','콜랑.jpg'),(11,22,'/2021/07/15/c74b7f2b-648c-419e-b200-9b8fcc521778_콜랑.jpg','I','콜랑.jpg'),(12,23,'/2021/07/15/3c02ec19-8135-4483-9db7-aa6bb8a63fff_콜랑.jpg','I','콜랑.jpg'),(13,23,'/2021/07/15/bb19576e-1939-4df4-96d5-bf305db38074_콜라수염.jpg','I','콜라수염.jpg'),(14,24,'/2021/07/16/9d49ecce-f665-4c79-8ce9-63ca0916bd61_고양이.jpg','D','고양이.jpg'),(15,24,'/2021/07/16/b70a3d67-553d-4907-98bd-1ca4e4a00aa2_펭귄.png','D','펭귄.png'),(16,27,'/2021/07/16/319f18f1-cf81-4fb6-bdff-94629239491b_펭귄.png','D','펭귄.png'),(17,27,'/2021/07/16/9a71d58d-e29d-463e-a2d9-25c51e749bee_고양이.jpg','D','고양이.jpg'),(19,29,'/2021/07/16/e08c2bae-3dcb-44df-a42f-4c3bd8722cce_펭귄.png','D','펭귄.png'),(20,29,'/2021/07/16/030f8629-b312-4dd0-ad0f-9d7a03aa9be0_고양이.jpg','D','고양이.jpg'),(21,30,'/2021/07/19/8ec71bca-d5d9-4023-9bca-b1bf3001fad3_court.ico','D','court.ico'),(22,30,'/2021/07/19/52124aa3-c74c-4376-817b-335cdf0ac0d6_court.png','D','court.png');
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
INSERT INTO `member` VALUES ('1','$2a$10$hn3nlj.x4YfLcBKb6dLnRO5GgtPYHApak8HHVe6vYhskbG.teTmeK','M','','','USER'),('1234','$2a$10$SG/T3esKmY3o/l.xMq6lVuaj5Aaq1uO1xqEwUaTewWyUer5POYREi','M','','1234','USER'),('12345','$2a$10$BhVDVal93JvhfvNawbTFzOa7lYC/ByaXM9sjDhF0Xu5rUI2yaiV4O','M','12345','12345','USER'),('abc123','$2a$10$Rrle6kSdG/DTu/IGsgVaiOtntzWjRlxijpqOsY89usYC/ELQHDipG','F','123@abc123','홍길동','USER'),('qwer','$2a$10$4NZOxktCsvCtqJHd8kTwBueYwVn4I7Jcu8YvdPYbM.vGX3js9sJ.K','F','1234@qwer','qwer','USER');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend` (
  `num` int NOT NULL AUTO_INCREMENT,
  `board` int NOT NULL,
  `id` varchar(15) NOT NULL,
  `state` int NOT NULL,
  PRIMARY KEY (`num`),
  KEY `board2` (`board`),
  KEY `id2` (`id`),
  CONSTRAINT `board2` FOREIGN KEY (`board`) REFERENCES `board` (`num`),
  CONSTRAINT `id2` FOREIGN KEY (`id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (1,31,'abc123',1);
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rp_num` int NOT NULL AUTO_INCREMENT,
  `rp_bd_num` int NOT NULL,
  `rp_me_id` varchar(15) NOT NULL,
  `rp_content` longtext NOT NULL,
  `rp_valid` varchar(1) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`rp_num`),
  KEY `rp_me_id_idx` (`rp_me_id`),
  KEY `rp_bd_num_idx` (`rp_bd_num`),
  CONSTRAINT `rp_bd_num` FOREIGN KEY (`rp_bd_num`) REFERENCES `board` (`num`),
  CONSTRAINT `rp_me_id` FOREIGN KEY (`rp_me_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 17:30:31
