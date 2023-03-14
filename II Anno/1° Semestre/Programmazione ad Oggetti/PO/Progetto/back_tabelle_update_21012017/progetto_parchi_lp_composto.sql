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
-- Table structure for table `composto`
--

DROP TABLE IF EXISTS `composto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `composto` (
  `parco_biglietto` varchar(25) NOT NULL,
  `biglietto` varchar(25) NOT NULL,
  `parco_attivita` varchar(25) NOT NULL,
  `attivita` varchar(25) NOT NULL,
  PRIMARY KEY (`biglietto`,`attivita`,`parco_biglietto`,`parco_attivita`),
  KEY `fk_battivita` (`attivita`,`parco_attivita`),
  KEY `fk_cbiglietto` (`biglietto`,`parco_biglietto`),
  CONSTRAINT `fk_battivita` FOREIGN KEY (`attivita`, `parco_attivita`) REFERENCES `attivita` (`codice`, `parco`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cbiglietto` FOREIGN KEY (`biglietto`, `parco_biglietto`) REFERENCES `biglietto` (`codice`, `parco`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composto`
--

LOCK TABLES `composto` WRITE;
/*!40000 ALTER TABLE `composto` DISABLE KEYS */;
INSERT INTO `composto` VALUES ('parcoac2','biglietto1','parcoac2','attivita1'),('parcoav3','biglietto1','parcoav3','attivita1'),('parcogen1','biglietto1','parcogen1','attivita1'),('parcoac2','biglietto1','parcoac2','attivita2'),('parcoav3','biglietto1','parcoav3','attivita2'),('parcogen1','biglietto1','parcogen1','attivita2'),('parcoac2','biglietto1','parcoac2','attivita3'),('parcoav3','biglietto1','parcoav3','attivita3'),('parcogen1','biglietto1','parcogen1','attivita3');
/*!40000 ALTER TABLE `composto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-21 13:10:44
