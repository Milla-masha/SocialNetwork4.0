-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: socialnetwork
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `id` int(10) NOT NULL,
  `idU` int(10) DEFAULT NULL,
  `authorities` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_u_idx` (`idU`),
  CONSTRAINT `fk_ua` FOREIGN KEY (`idU`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,1,'ROLE_CLIENT'),(2,2,'ROLE_CLIENT');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_user`
--

DROP TABLE IF EXISTS `contact_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_user` (
  `id` int(11) NOT NULL,
  `mobile` varchar(13) DEFAULT NULL,
  `skype` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `fk_registeruser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_info_idx` (`fk_registeruser`),
  CONSTRAINT `fk_contact_register` FOREIGN KEY (`fk_registeruser`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_user`
--

LOCK TABLES `contact_user` WRITE;
/*!40000 ALTER TABLE `contact_user` DISABLE KEYS */;
INSERT INTO `contact_user` VALUES (1,'375292857510','Milla-masha','Milla-masha@mail.ru',1);
/*!40000 ALTER TABLE `contact_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL,
  `fk_user1` int(11) NOT NULL,
  `fk_user2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_friends1_idx` (`fk_user1`),
  KEY `fk_friends2_idx` (`fk_user2`),
  CONSTRAINT `fk_friends1` FOREIGN KEY (`fk_user1`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends2` FOREIGN KEY (`fk_user2`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (1,1,2),(2,2,1);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_user`
--

DROP TABLE IF EXISTS `group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_user` (
  `id` int(11) NOT NULL,
  `fk_user` int(11) NOT NULL,
  `fk_group` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`fk_user`),
  KEY `fk_group_idx` (`fk_group`),
  CONSTRAINT `fk_user` FOREIGN KEY (`fk_user`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_group` FOREIGN KEY (`fk_group`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_user`
--

LOCK TABLES `group_user` WRITE;
/*!40000 ALTER TABLE `group_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_user`
--

DROP TABLE IF EXISTS `info_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info_user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birthday` date DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `about` varchar(1000) DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `fk_registeruser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_regus_idx` (`fk_registeruser`),
  CONSTRAINT `fk_regus` FOREIGN KEY (`fk_registeruser`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_user`
--

LOCK TABLES `info_user` WRITE;
/*!40000 ALTER TABLE `info_user` DISABLE KEYS */;
INSERT INTO `info_user` VALUES (1,'Masha','Tsilulko','2001-01-20','http://i2.wp.com/jewelryvirtualfair.com/wp-content/themes/kleo-child/images-themes/avatar-profile.jpg','Grodno','I like to do something. When I have free time I do something.','Female',1);
/*!40000 ALTER TABLE `info_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music` (
  `id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `name` varchar(45) NOT NULL,
  `time` time DEFAULT NULL,
  `fk_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_music_user_idx` (`fk_user`),
  CONSTRAINT `fk_music_user` FOREIGN KEY (`fk_user`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','1Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(2,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','2Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(3,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','3Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(4,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','4Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(5,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','5Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(6,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','6Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(7,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','7Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(8,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','8Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(9,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','9Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(10,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','10Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(11,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','11Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(12,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','12Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(13,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','13Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(14,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','14Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1),(15,'https://psv4.vk.me/c536111/u68934930/audios/859676a20c91.mp3','15Subsonik–Inside Your Mind (feat. Essence)','00:06:22',1);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `fk_user` int(11) DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_group`
--

DROP TABLE IF EXISTS `post_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_group` (
  `id` int(11) NOT NULL,
  `fk_post` int(11) NOT NULL,
  `fk_group` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_postgr_idx` (`fk_post`),
  KEY `fk_grouppo_idx` (`fk_group`),
  CONSTRAINT `fk_postgr` FOREIGN KEY (`fk_post`) REFERENCES `post` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grouppo` FOREIGN KEY (`fk_group`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_group`
--

LOCK TABLES `post_group` WRITE;
/*!40000 ALTER TABLE `post_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_user`
--

DROP TABLE IF EXISTS `post_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_user` (
  `id` int(11) NOT NULL,
  `fk_post` int(11) NOT NULL,
  `fk_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_post_idx` (`fk_post`),
  KEY `fk_user_idx` (`fk_user`),
  CONSTRAINT `fk_postus` FOREIGN KEY (`fk_post`) REFERENCES `post` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userpo` FOREIGN KEY (`fk_user`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_user`
--

LOCK TABLES `post_user` WRITE;
/*!40000 ALTER TABLE `post_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeruser`
--

DROP TABLE IF EXISTS `registeruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registeruser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `enabled` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeruser`
--

LOCK TABLES `registeruser` WRITE;
/*!40000 ALTER TABLE `registeruser` DISABLE KEYS */;
INSERT INTO `registeruser` VALUES (1,'user','user',1),(2,'user1','user1',1);
/*!40000 ALTER TABLE `registeruser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `preview` varchar(255) DEFAULT NULL,
  `fk_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_video_user_idx` (`fk_user`),
  CONSTRAINT `fk_video_user` FOREIGN KEY (`fk_user`) REFERENCES `registeruser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',1),(2,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',1),(3,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',2),(4,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',1),(5,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',2),(6,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',1),(7,'Master of movie','https://cs510415.vk.me/u936877/videos/eb468554e0.480.mp4','https://gruhnb.files.wordpress.com/2014/11/master-of-the-house.jpg',1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'socialnetwork'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-25 17:39:17
