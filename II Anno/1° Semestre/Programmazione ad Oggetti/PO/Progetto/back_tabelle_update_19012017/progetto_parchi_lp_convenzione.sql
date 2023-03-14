-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: progetto_parchi_lp
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `convenzione`
--

DROP TABLE IF EXISTS `convenzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenzione` (
  `agenzia` char(11) NOT NULL,
  `parco` varchar(25) NOT NULL,
  PRIMARY KEY (`agenzia`,`parco`),
  KEY `fk_cparco` (`parco`),
  CONSTRAINT `fk_cagenzia` FOREIGN KEY (`agenzia`) REFERENCES `agenzia` (`piva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cparco` FOREIGN KEY (`parco`) REFERENCES `parco` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenzione`
--

LOCK TABLES `convenzione` WRITE;
/*!40000 ALTER TABLE `convenzione` DISABLE KEYS */;
INSERT INTO `convenzione` VALUES ('00000000000','parcoac2'),('11111111111','parcoac2'),('11111111111','parcoav3'),('22222222222','parcoav3'),('00000000000','parcogen1'),('33333333333','parcogen1'),('22222222222','parcotem4'),('33333333333','parcotem4'),('44444444444','parcotem4');
/*!40000 ALTER TABLE `convenzione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 23:54:29
