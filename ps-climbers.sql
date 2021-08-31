-- MySQL dump 10.16  Distrib 10.1.48-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ps_climbers
-- ------------------------------------------------------
-- Server version	10.1.48-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `climber`
--

DROP TABLE IF EXISTS `climber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `climber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `year_of_birth` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `climber`
--

LOCK TABLES `climber` WRITE;
/*!40000 ALTER TABLE `climber` DISABLE KEYS */;
INSERT INTO `climber` VALUES (1,'First climber SWAGGER UI','First climber e',1991),(3,'c3 update please','Last name',2000),(5,'C3 update','Last name',2000),(10,'Angular up','First',1989),(11,'Test 1','Last 1',1990),(12,'Test 1','Last 1',1990),(13,'Test 1','Last 1',1990),(14,'test','test',1990);
/*!40000 ALTER TABLE `climber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competition`
--

DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `registration_open` datetime DEFAULT NULL,
  `registration_close` datetime DEFAULT NULL,
  `event_start_date` datetime DEFAULT NULL,
  `max_number_of_registrations` int(11) DEFAULT NULL,
  `competition_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition`
--

LOCK TABLES `competition` WRITE;
/*!40000 ALTER TABLE `competition` DISABLE KEYS */;
INSERT INTO `competition` VALUES (4,'nn',NULL,NULL,NULL,NULL,'nn aaa'),(5,'d2',NULL,NULL,NULL,NULL,'c2'),(6,'d3',NULL,NULL,NULL,NULL,'c3'),(7,'Samardzija',NULL,NULL,NULL,NULL,'Ivana'),(9,'test',NULL,NULL,NULL,NULL,'test'),(30,'asdf','2021-08-05 00:01:00','2021-08-14 23:59:00',NULL,NULL,'adsf'),(31,'asdf','2021-08-05 00:01:00','2021-08-14 23:59:00',NULL,NULL,'adsf'),(32,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(33,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(34,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(35,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(36,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'opa opa'),(37,'adsf 37 update swagger','1990-06-19 04:00:00','2021-08-05 06:01:00',NULL,NULL,'adsf 37 update swagger');
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `competition_id` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `start_number` int(11) DEFAULT NULL,
  `total_ord` int(11) DEFAULT NULL,
  `paid` tinyint(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `paid_date` datetime DEFAULT NULL,
  `fee_ord` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`climber_id`),
  KEY `climber_id` (`climber_id`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`),
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_fee`
--

DROP TABLE IF EXISTS `registration_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration_fee` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` decimal(15,2) unsigned DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `registration_fee_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_fee`
--

LOCK TABLES `registration_fee` WRITE;
/*!40000 ALTER TABLE `registration_fee` DISABLE KEYS */;
INSERT INTO `registration_fee` VALUES (30,1,'Early birds',100.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(30,2,'Regular',200.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(30,3,'Last minute',300.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,1,'Early birds',100.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,2,'Regular',200.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,3,'Last minute',300.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(32,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(32,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(32,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(37,1,'Early birds swagger',100.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),(37,2,'Regular swagger',200.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),(37,3,'adsf',30000.00,'2021-08-21 00:00:00','2021-08-29 00:00:00');
/*!40000 ALTER TABLE `registration_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_climbed`
--

DROP TABLE IF EXISTS `route_climbed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_climbed` (
  `competition_id` int(11) NOT NULL,
  `route_ord` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `from_attempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`route_ord`,`climber_id`),
  KEY `climber_id` (`climber_id`),
  CONSTRAINT `route_climbed_ibfk_1` FOREIGN KEY (`competition_id`, `route_ord`) REFERENCES `route` (`competition_id`, `ord`),
  CONSTRAINT `route_climbed_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_climbed`
--

LOCK TABLES `route_climbed` WRITE;
/*!40000 ALTER TABLE `route_climbed` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_climbed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'a1','a1','admin1','admin1'),(2,'a2','a2','admin2','admin2'),(3,'first','admin','admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-12 14:03:10
