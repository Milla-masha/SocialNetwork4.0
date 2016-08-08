-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: social_network
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
-- Table structure for table `blacklist`
--

DROP TABLE IF EXISTS `blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blacklist` (
  `fk_iduser` int(11) NOT NULL,
  `fk_idblackuser` int(11) DEFAULT NULL,
  PRIMARY KEY (`fk_iduser`),
  KEY `fk_user_blackuser_idx` (`fk_idblackuser`),
  CONSTRAINT `fk_user_blackuser` FOREIGN KEY (`fk_idblackuser`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_owner` FOREIGN KEY (`fk_iduser`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklist`
--

LOCK TABLES `blacklist` WRITE;
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
INSERT INTO `blacklist` VALUES (1,2);
/*!40000 ALTER TABLE `blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `fk_user1` int(11) NOT NULL,
  `fk_user2` int(11) DEFAULT NULL,
  KEY `friends_user_id__fk` (`fk_user1`),
  KEY `friends_user_id__fk2` (`fk_user2`),
  CONSTRAINT `friends_user_id__fk` FOREIGN KEY (`fk_user1`) REFERENCES `users` (`id`),
  CONSTRAINT `friends_user_id__fk2` FOREIGN KEY (`fk_user2`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (2,1),(1,2),(1,2);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_user`
--

DROP TABLE IF EXISTS `group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_user` (
  `fk_group` int(11) NOT NULL,
  `fk_user` int(11) NOT NULL,
  PRIMARY KEY (`fk_group`),
  KEY `fk_gu_user_idx` (`fk_user`),
  CONSTRAINT `fk_gu_group` FOREIGN KEY (`fk_group`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gu_user` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_user`
--

LOCK TABLES `group_user` WRITE;
/*!40000 ALTER TABLE `group_user` DISABLE KEYS */;
INSERT INTO `group_user` VALUES (1,1);
/*!40000 ALTER TABLE `group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `fk_media` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fk_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_user_kf_idx` (`fk_user`),
  KEY `fk_group_media_idx` (`fk_media`),
  CONSTRAINT `fk_group_media` FOREIGN KEY (`fk_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_user_fk` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'name',6,'slfjwfwenfg',1);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_like` int(1) DEFAULT '1',
  `fk_user` int(11) DEFAULT NULL,
  `fk_post` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_like_user_idx` (`fk_user`),
  KEY `fk_like_post_idx` (`fk_post`),
  CONSTRAINT `fk_like_post` FOREIGN KEY (`fk_post`) REFERENCES `posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_user` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `discriminator` varchar(5) DEFAULT NULL,
  `preview` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'rgh','http/','MUSIC',''),(2,'setja','http/','MUSIC',NULL),(3,NULL,'http://i2.wp.com/jewelryvirtualfair.com/wp-content/themes/kleo-child/images-themes/avatar-profile.jpg','IMAGE',NULL),(4,NULL,'http://i2.wp.com/jewelryvirtualfair.com/wp-content/themes/kleo-child/images-themes/avatar-profile.jpg','IMAGE',NULL),(5,NULL,'https://www.dropbox.com/s/bw5whye773f3x90/WavLibraryNet_Sound16357.mp3?dl=0','MUSIC',NULL),(6,NULL,'http://madcar.ru/images/cars/Chrysler_300C_2006_15.jpg','IMAGE',NULL),(7,NULL,'https://www.dropbox.com/s/bw5whye773f3x90/WavLibraryNet_Sound16357.mp3?dl=0','MUSIC',NULL),(8,NULL,'https://www.dropbox.com/s/0ax25avi8ehj6q9/avatar.jpg?dl=0','IMAGE',NULL),(9,NULL,'https://www.dropbox.com/s/0ax25avi8ehj6q9/avatar.jpg?dl=0','IMAGE',NULL),(10,NULL,'https://www.dropbox.com/s/0ax25avi8ehj6q9/avatar.jpg?dl=0','IMAGE',NULL),(11,NULL,'https://www.dropbox.com/s/0ax25avi8ehj6q9/avatar.jpg?dl=0','IMAGE',NULL);
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_groups`
--

DROP TABLE IF EXISTS `media_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_groups` (
  `fk_media` int(11) NOT NULL,
  `fk_groups` int(11) NOT NULL,
  PRIMARY KEY (`fk_media`),
  KEY `fk_mg_groups_idx` (`fk_groups`),
  CONSTRAINT `fk_mg_groups` FOREIGN KEY (`fk_groups`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mg_media` FOREIGN KEY (`fk_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_groups`
--

LOCK TABLES `media_groups` WRITE;
/*!40000 ALTER TABLE `media_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `media_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_users`
--

DROP TABLE IF EXISTS `media_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_users` (
  `fk_media` int(11) NOT NULL,
  `fk_users` int(11) NOT NULL,
  PRIMARY KEY (`fk_media`),
  KEY `fk_mu_users_idx` (`fk_users`),
  CONSTRAINT `fk_mu_media` FOREIGN KEY (`fk_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mu_users` FOREIGN KEY (`fk_users`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_users`
--

LOCK TABLES `media_users` WRITE;
/*!40000 ALTER TABLE `media_users` DISABLE KEYS */;
INSERT INTO `media_users` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `media_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `discriminator` varchar(5) NOT NULL,
  `fk_media` int(11) DEFAULT NULL,
  `fk_group` int(11) DEFAULT NULL,
  `fk_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_post_user_idx` (`fk_user`),
  KEY `fk_post_group` (`fk_group`),
  KEY `fk_post_media_idx` (`fk_media`),
  CONSTRAINT `fk_post_group` FOREIGN KEY (`fk_group`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_media` FOREIGN KEY (`fk_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_user` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'da\'lkvna','GROUP',6,1,NULL),(2,'srthrstjrs','USER',6,NULL,1),(3,'rerherga','USER',6,NULL,2),(5,'Post post postpost','USER',6,NULL,1),(6,'Post post postpost','USER',6,NULL,1),(7,'Post post postpost','USER',6,NULL,1);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user` int(11) NOT NULL,
  `authorities` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roles_user_id_fk` (`fk_user`),
  CONSTRAINT `fk_roles_user` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='user roles';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'ROLE_CLIENT'),(2,19,'ROLE_CLIENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(11) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `lastname` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `skype` varchar(25) DEFAULT NULL,
  `mobile` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `fk_media` int(11) DEFAULT '1',
  `city` varchar(255) DEFAULT NULL,
  `about` text,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_uindex` (`login`),
  KEY `fk_users_media_idx` (`fk_media`),
  CONSTRAINT `fk_users_media` FOREIGN KEY (`fk_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user','user','Masha','Tsilul','Milla-Masha@mail.ru','Milla-masha',2147483647,'2015-01-01','1',6,'Grodno','Moeiug',1),(2,'user2','user2','Masha2','Tsilul2','Milla-Masha@mail.ru','Milla-masha',2147483647,'2016-02-03','1',4,'Grodno','Moeiug',1),(19,'tomVers','tommy','tommy','versetty','tommy@versetty.com',NULL,0,'2016-08-07','Male',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'social_network'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-08 16:27:58
