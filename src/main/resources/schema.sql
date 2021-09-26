
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

-- DROP TABLE IF EXISTS `climber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `climber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `year_of_birth` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `competition`
--

-- DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `registration_open` datetime DEFAULT NULL,
  `registration_close` datetime DEFAULT NULL,
  `event_start_date` datetime DEFAULT NULL,
  `max_number_of_registrations` int(11) DEFAULT NULL,
  `competition_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registration`
--

-- DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `registration` (
  `competition_id` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `start_number` int(11) DEFAULT NULL,
  `total_ord` int(11) DEFAULT NULL,
  `paid` tinyint(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `paid_date` datetime DEFAULT NULL,
  `fee_ord` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`climber_id`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`),
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registration_fee`
--

-- DROP TABLE IF EXISTS `registration_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `registration_fee` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` decimal(15,2) unsigned DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `registration_fee_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `route`
--

-- DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `route` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `route_climbed`
--

-- DROP TABLE IF EXISTS `route_climbed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `route_climbed` (
  `competition_id` int(11) NOT NULL,
  `route_ord` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `from_attempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`route_ord`,`climber_id`),
  CONSTRAINT `route_climbed_ibfk_1` FOREIGN KEY (`competition_id`, `route_ord`) REFERENCES `route` (`competition_id`, `ord`),
  CONSTRAINT `route_climbed_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `admin`
--

-- DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-12 14:03:10
