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
  `type` varchar(45) NOT NULL DEFAULT 'NORMAL',
  `oriNo` int NOT NULL,
  `groupOrd` int NOT NULL DEFAULT '0',
  `pw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`num`),
  KEY `writer_idx` (`writer`),
  CONSTRAINT `writer` FOREIGN KEY (`writer`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'게시글','게시글2','qwer','2021-07-06 16:30:46',2,'I','NORMAL',1,0,NULL),(2,'게시글1','게시글1','qwer','2021-07-06 16:30:47',1,'D','NORMAL',2,0,NULL),(3,'7월7일(수정)','1234(수정)','qwer','2021-07-07 12:50:01',7,'I','NORMAL',3,0,NULL),(4,'엉엉','ㅠㅠ','qwer','2021-07-07 16:08:17',3,'I','NORMAL',4,0,NULL),(8,'아이디 없으면?','오류메세지 나옴','qwer','2021-07-07 16:10:51',0,'I','NORMAL',5,0,NULL),(9,'7월9일','root에 컨트롤러 안지워서...','qwer','2021-07-09 09:32:09',3,'I','NORMAL',6,0,NULL),(10,'345','2342\r\n\r\n55','qwer','2021-07-09 09:58:20',12,'I','NORMAL',7,0,NULL),(11,'1234','12341414','qwer','2021-07-09 14:22:45',14,'I','NORMAL',8,0,NULL),(12,'\"hi\"','hihi','qwer','2021-07-12 11:51:15',8,'I','NORMAL',9,0,NULL),(13,'713','7123','abc123','2021-07-13 16:22:44',8,'I','NORMAL',10,0,NULL),(14,'mysql에 아이디 추가하기','기존 데이터베이스랑 어떻게 연동하더라?','abc123','2021-07-14 12:55:40',5,'I','NORMAL',11,0,NULL),(15,'123421','123414','qwer','2021-07-14 14:00:12',8,'I','NORMAL',12,0,NULL),(16,'게시글번호 확인 용도','게시글번호 가져와서 나중에 파일업로드할때 씀','abc123','2021-07-14 16:32:32',21,'I','NORMAL',13,0,NULL),(17,'첨부파일 테스트1','첨부','abc123','2021-07-14 17:06:38',1,'I','NORMAL',14,0,NULL),(18,'첨부경로변경','\"E:\\\\JAVA_NCE\\\\project_nce\\\\uploadfiles\"로 변경함(보드서비스임플, 서블릿 두부분)\r\n\r\n고양이 사진','abc123','2021-07-14 17:25:28',14,'I','NORMAL',15,0,NULL),(20,'첨부파일 수정 연습','(디비랑 폴더 강제로 삭제함 오류나서)\r\n\r\n폴더와 디비 둘다 확인하기 -> 파일 올렸다가 수정하고, 수정해본담엔 지워보기! \r\n\r\n1차: 수정 누른 뒤 파일첨부함  => 잘됨\r\n2차: 수정->첨부파일삭제-> 다른 파일 첨부 \r\n 2-1차: 에러남 (\" 맵퍼 오타\": 내용 수정X/첨부파일 폴더:바뀜/디비:둘다 I) \r\n     => 디비에서 임의로 이전파일 D로 수정하니 열렸으나 다시 첨부하니 에러나서 그냥 싹 지움\r\n  2-2차 : 수정->첨부파일 삭제->다른파일 첨부 \r\n디비 수정 다시하고 다시 삭제랑 삭제후 첨부 해보니까 됨\r\n\r\n\r\n','abc123','2021-07-15 13:21:15',22,'I','NORMAL',16,0,NULL),(21,'7월 15일','첨부파일','abc123','2021-07-15 14:21:44',2,'D','NORMAL',17,0,NULL),(22,'7월15일','1. 내용만 수정','abc123','2021-07-15 14:26:14',23,'I','NORMAL',18,0,NULL),(23,'다중첨부파일','123','abc123','2021-07-15 16:48:57',68,'I','NORMAL',19,0,NULL),(24,'1234','1234','abc123','2021-07-16 09:43:37',1,'D','NORMAL',20,0,NULL),(25,'1234','1234','abc123','2021-07-16 09:48:53',1,'D','NORMAL',21,0,NULL),(26,'123rr','123rr','abc123','2021-07-16 09:49:36',1,'D','NORMAL',22,0,NULL),(27,'1111','1111','abc123','2021-07-16 10:55:04',31,'D','NORMAL',23,0,NULL),(28,'asdf','asdf','abc123','2021-07-16 15:31:49',3,'D','NORMAL',24,0,NULL),(29,'첨부파일 삭제함','1qa','abc123','2021-07-16 15:52:40',37,'I','NORMAL',25,0,NULL),(30,'첨부파일 예시','123','abc123','2021-07-19 11:06:23',1,'D','NORMAL',26,0,NULL),(31,'서머노트 테스트','<p><font color=\"#ff9c00\">부트스트랩4 링크 밑에거 두개로 적용하기</font></p><p><font color=\"#ff9c00\"><br></font></p><p><font color=\"#ff9c00\">창크기 늘리기</font></p><p><font color=\"#ff9c00\">수정. 디테일, 작성 모두 바꿔주기</font></p>','abc123','2021-07-19 16:20:20',150,'I','NORMAL',27,0,NULL),(32,'스프링테스트:써머노트적용','<h3><b><font color=\"#ff9c00\">등록창 : 뜸!</font></b></h3><h3><b><font color=\"#ff9c00\"><br></font></b></h3><h3><b><font color=\"#ff9c00\"><br></font></b></h3><h3><b><font color=\"#ff9c00\"><br></font></b></h3><h3><b><font color=\"#ff9c00\"><br></font></b></h3><h3><b><font color=\"#ff9c00\">수정창은? 됨!</font></b></h3>','abc123','2021-07-22 11:15:40',324,'I','NORMAL',28,0,NULL),(33,'문의','문의합니다.','abc123','2021-07-29 10:06:23',1,'I','NORMAL',29,0,NULL),(34,'문의 답변','문의답변입니다.','abc123','2021-07-29 10:10:23',1,'I','NORMAL',29,1,NULL),(35,'새로운 문의 답변','문의답변입니다.','abc123','2021-07-29 10:10:23',1,'I','NORMAL',29,2,NULL),(36,'문의합니다.','문의요.','abc123','2021-07-30 13:02:02',0,'I','NORMAL',36,0,NULL),(37,'문의','답변','abc123','2021-07-30 13:02:23',0,'I','NORMAL',36,1,NULL),(38,'1','답변','abc123','2021-07-30 13:03:29',0,'I','NORMAL',36,2,NULL),(39,'문의','123','abc123','2021-07-30 13:03:42',0,'I','NORMAL',39,0,NULL),(40,'답변','123','abc123','2021-07-30 13:03:52',0,'I','NORMAL',39,1,NULL),(41,'첨부확인','첨부확인하기23','abc123','2021-07-31 10:45:05',9,'D','NORMAL',41,0,NULL),(42,'공지사항1','공지사항입니다.','abc123','2021-08-02 17:52:11',0,'I','NOTICE',42,0,NULL),(43,'공지사항2','공지사항입니다.','abc123','2021-08-02 17:52:58',14,'I','NOTICE',43,0,NULL),(44,'임시','임시2','1234','2021-08-02 18:43:43',5,'D','NORMAL',44,0,NULL),(47,'공지사항3','3','abc123','2021-08-03 22:44:37',2,'I','NOTICE',45,0,NULL),(48,'일반글','글','abc123','2021-08-03 22:44:54',17,'I','NORMAL',48,0,NULL),(49,'123','<p>123</p>','abc123','2021-08-03 23:52:01',2,'D','IMAGE',49,0,'$2a$10$Ux0pBmd/LqotbxLSe/ZTqeKlAduk9Ei6XcAC7qWt9Y7fbYlGTKG.q'),(50,'1111','<p>1111</p>','abc123','2021-08-03 23:54:39',5,'I','IMAGE',50,0,'$2a$10$osl.O7ZyieafjAcThbSOUO4ksXARfZ9HpR2MBr3.UZkfQvGt0LJ8a');
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
  `thumbnail` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`num`),
  KEY `board_idx` (`board`),
  CONSTRAINT `board` FOREIGN KEY (`board`) REFERENCES `board` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,17,'/2021/07/14/3822ba4c-3920-43b2-b7a6-253369e0c285_beach.jpg','I','beach.jpg','N'),(2,18,'/2021/07/14/b3e484f5-4ac5-4147-b959-d29d1b4a9412_고양이.jpg','I','고양이.jpg','N'),(6,20,'/2021/07/15/0a3ae5a6-c247-4eb8-a519-56593b635322_콜라수염.jpg','D','콜라수염.jpg','N'),(7,20,'/2021/07/15/ee4406f6-f07f-4458-a734-f7435c786a7b_콜랑.jpg','D','콜랑.jpg','N'),(8,20,'/2021/07/15/63101eb1-f90e-432d-aa47-4d58a54d9111_콜라수염.jpg','D','콜라수염.jpg','N'),(9,20,'/2021/07/15/c6098fb1-8c11-4190-9cd0-aa23e0df51f1_콜랑.jpg','D','콜랑.jpg','N'),(10,21,'/2021/07/15/610cbd08-8ede-42a1-a0ba-09ededa62fa6_콜랑.jpg','I','콜랑.jpg','N'),(11,22,'/2021/07/15/c74b7f2b-648c-419e-b200-9b8fcc521778_콜랑.jpg','I','콜랑.jpg','N'),(12,23,'/2021/07/15/3c02ec19-8135-4483-9db7-aa6bb8a63fff_콜랑.jpg','I','콜랑.jpg','N'),(13,23,'/2021/07/15/bb19576e-1939-4df4-96d5-bf305db38074_콜라수염.jpg','I','콜라수염.jpg','N'),(14,24,'/2021/07/16/9d49ecce-f665-4c79-8ce9-63ca0916bd61_고양이.jpg','D','고양이.jpg','N'),(15,24,'/2021/07/16/b70a3d67-553d-4907-98bd-1ca4e4a00aa2_펭귄.png','D','펭귄.png','N'),(16,27,'/2021/07/16/319f18f1-cf81-4fb6-bdff-94629239491b_펭귄.png','D','펭귄.png','N'),(17,27,'/2021/07/16/9a71d58d-e29d-463e-a2d9-25c51e749bee_고양이.jpg','D','고양이.jpg','N'),(19,29,'/2021/07/16/e08c2bae-3dcb-44df-a42f-4c3bd8722cce_펭귄.png','D','펭귄.png','N'),(20,29,'/2021/07/16/030f8629-b312-4dd0-ad0f-9d7a03aa9be0_고양이.jpg','D','고양이.jpg','N'),(21,30,'/2021/07/19/8ec71bca-d5d9-4023-9bca-b1bf3001fad3_court.ico','D','court.ico','N'),(22,30,'/2021/07/19/52124aa3-c74c-4376-817b-335cdf0ac0d6_court.png','D','court.png','N'),(23,43,'/2021/08/02/e6575a72-aa89-4523-9a8b-f546bb204e53_콜랑.jpg','D','콜랑.jpg','N'),(24,43,'/2021/08/02/18e38ed2-cd23-4ce6-9719-db1007ae0a8e_콜라수염.jpg','D','콜라수염.jpg','N'),(25,44,'/2021/08/02/b5e33a13-6fac-4120-adfc-7d0c046bc3be_콜랑.jpg','D','콜랑.jpg','N'),(26,44,'/2021/08/02/d29ef53f-e411-40be-aaae-5fdcd45b8515_콜랑.jpg','D','콜랑.jpg','N'),(27,41,'/2021/08/02/adf9e736-ac74-46aa-b8c6-49cdcaff7589_콜랑.jpg','D','콜랑.jpg','N'),(28,43,'/2021/08/02/c4896171-dc30-4dd9-a225-bc3e4e5fe04e_콜랑.jpg','D','콜랑.jpg','N'),(29,49,'/2021/08/03/5d9bb2b9-b3a8-4b73-8fac-02876af6b338_콜랑.jpg','D','콜랑.jpg','Y'),(30,49,'/2021/08/03/9982e88a-b96b-4e74-8f88-5752ff1b3385_콜랑.jpg','D','콜랑.jpg','Y'),(31,50,'/2021/08/03/a6d3f100-2471-44c3-a25a-9e3a729b28a4_콜랑.jpg','D','콜랑.jpg','N'),(32,50,'/2021/08/03/3ffafed2-d68e-4704-9a1b-0b347383ccda_콜랑.jpg','I','콜랑.jpg','Y');
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
  `session_id` varchar(255) DEFAULT NULL,
  `session_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('1','$2a$10$hn3nlj.x4YfLcBKb6dLnRO5GgtPYHApak8HHVe6vYhskbG.teTmeK','M','','','USER',NULL,NULL),('1234','$2a$10$SG/T3esKmY3o/l.xMq6lVuaj5Aaq1uO1xqEwUaTewWyUer5POYREi','M','','1234','USER',NULL,NULL),('12345','$2a$10$BhVDVal93JvhfvNawbTFzOa7lYC/ByaXM9sjDhF0Xu5rUI2yaiV4O','M','12345','12345','USER',NULL,NULL),('abc123','$2a$10$Tcp7XCuc4VOVaidGRlA8w.xvP1E21.GXDm2xNoMVF0o6SlXURJgKu','F','abc@daum.net','홍길동','SUPER ADMIN','D59119772EFB92F97728D108330AE0EF','2021-08-09 18:47:18'),('asdf','$2a$10$SqZAjDb2uysWAtO/z2TFSOeCRVWzfIHOXmuqJiD5myyA4bDntJTFO','M','asdf','asdf','ADMIN',NULL,NULL),('qwer','$2a$10$4NZOxktCsvCtqJHd8kTwBueYwVn4I7Jcu8YvdPYbM.vGX3js9sJ.K','F','1234@qwer','qwer','ADMIN',NULL,NULL),('qwertyui','$2a$10$SXzipo1YJSU3C0mTpipH3u8jENGqbdIEJi0Ple.NBnwYUxF7kWQPO','M','qwertyui@na.veo.co','dfs','USER',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (1,31,'abc123',1),(2,32,'abc123',1);
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
  `rp_regDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rp_upDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rp_num`),
  KEY `rp_me_id_idx` (`rp_me_id`),
  KEY `rp_bd_num_idx` (`rp_bd_num`),
  CONSTRAINT `rp_bd_num` FOREIGN KEY (`rp_bd_num`) REFERENCES `board` (`num`),
  CONSTRAINT `rp_me_id` FOREIGN KEY (`rp_me_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,31,'abc123','123','D','2021-07-21 10:48:53','2021-07-21 17:33:23'),(2,31,'abc123','댓글2','I','2021-07-21 11:27:25','2021-07-21 11:27:25'),(3,31,'1234','댓글3','I','2021-07-21 11:44:27','2021-07-21 11:44:27'),(4,29,'abc123','123','I','2021-07-21 12:22:04','2021-07-21 12:22:04'),(5,31,'abc123','댓글4-수정','I','2021-07-21 12:44:17','2021-07-22 10:13:54'),(6,31,'abc123','댓글5','D','2021-07-21 12:44:22','2021-07-21 17:22:59'),(7,31,'abc123','댓글6','I','2021-07-21 12:44:33','2021-07-21 12:44:33'),(8,31,'abc123','댓글7','D','2021-07-21 17:31:57','2021-07-21 17:32:31'),(9,31,'abc123','댓글8','I','2021-07-21 17:32:23','2021-07-21 17:32:23'),(10,32,'abc123','댓글을 수정하였습니다.2','I','2021-07-23 10:35:40','2021-07-23 10:35:40'),(11,32,'abc123','로그인하세요.','I','2021-07-23 10:49:16','2021-07-23 10:49:16'),(12,32,'abc123','입력후 댓글내용 지우기~','I','2021-07-23 10:50:17','2021-07-23 10:50:17'),(13,32,'abc123','댓글 지워지나~26일 수정 페이지머무르기 수정','I','2021-07-23 10:50:41','2021-07-23 10:50:41'),(14,32,'abc123','js파일 만들었음!','I','2021-07-23 11:06:36','2021-07-23 11:06:36'),(15,32,'abc123','입력','D','2021-07-23 17:09:27','2021-07-23 17:09:27'),(16,32,'abc123','댓글삭제기능1','D','2021-07-26 12:57:23','2021-07-26 12:57:23'),(17,48,'abc123','1','I','2021-08-03 23:45:44','2021-08-03 23:45:44'),(18,48,'abc123','2','I','2021-08-03 23:46:46','2021-08-03 23:46:46'),(19,47,'abc123','댓1','I','2021-08-03 23:47:21','2021-08-03 23:47:21'),(20,48,'abc123','3','I','2021-08-03 23:47:39','2021-08-03 23:47:39'),(21,48,'abc123','4','D','2021-08-04 23:29:54','2021-08-04 23:29:54'),(22,47,'abc123','댓2','D','2021-08-04 23:30:08','2021-08-04 23:30:08');
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

-- Dump completed on 2021-08-14 22:46:29
