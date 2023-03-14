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
-- Table structure for table `compostohotel`
--

DROP TABLE IF EXISTS `compostohotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compostohotel` (
  `agenzia_pacchetto` char(11) NOT NULL,
  `pacchetto` varchar(25) NOT NULL,
  `hotel` varchar(25) NOT NULL,
  PRIMARY KEY (`pacchetto`,`hotel`,`agenzia_pacchetto`),
  KEY `fk_cpacchetto` (`pacchetto`,`agenzia_pacchetto`),
  KEY `fk_chotel` (`hotel`),
  CONSTRAINT `fk_chotel` FOREIGN KEY (`hotel`) REFERENCES `hotel` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpacchetto` FOREIGN KEY (`pacchetto`, `agenzia_pacchetto`) REFERENCES `pacchetto` (`codice`, `agenzia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compostohotel`
--

LOCK TABLES `compostohotel` WRITE;
/*!40000 ALTER TABLE `compostohotel` DISABLE KEYS */;
INSERT INTO `compostohotel` VALUES ('00000000000','pacchetto1','hotel1'),('11111111111','pacchetto1','hotel2'),('22222222222','pacchetto1','hotel3'),('33333333333','pacchetto1','hotel4');
/*!40000 ALTER TABLE `compostohotel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-21 13:10:43
