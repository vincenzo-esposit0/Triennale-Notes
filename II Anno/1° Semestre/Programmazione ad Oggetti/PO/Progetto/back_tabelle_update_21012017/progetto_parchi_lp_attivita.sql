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
-- Table structure for table `attivita`
--

DROP TABLE IF EXISTS `attivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attivita` (
  `codice` varchar(25) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `orario_inizio` time DEFAULT '00:00:00',
  `orario_fine` time DEFAULT '00:00:00',
  `costo` decimal(10,2) DEFAULT '0.00',
  `parco` varchar(25) NOT NULL,
  `dipendente` char(16) DEFAULT NULL,
  PRIMARY KEY (`codice`,`parco`),
  KEY `fk_aparco` (`parco`),
  KEY `fk_adipendente` (`dipendente`),
  CONSTRAINT `fk_adipendente` FOREIGN KEY (`dipendente`) REFERENCES `dipendente` (`cf`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_aparco` FOREIGN KEY (`parco`) REFERENCES `parco` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivita`
--

LOCK TABLES `attivita` WRITE;
/*!40000 ALTER TABLE `attivita` DISABLE KEYS */;
INSERT INTO `attivita` VALUES ('attivita1','attivita1','21:00:00','23:00:00',6.00,'parcoac2','dipendente2'),('attivita1','attivita1','21:00:00','23:00:00',2.20,'parcoav3','dipendente3'),('attivita1','attivita1','20:00:00','21:00:00',4.25,'parcogen1','dipendente1'),('attivita1','attivita1','21:00:00','23:00:00',5.00,'parcotem4','dipendente4'),('attivita2','attivita2','07:00:00','10:00:00',7.00,'parcoac2','dipendente2'),('attivita2','attivita2','03:00:00','10:00:00',2.00,'parcoav3','dipendente3'),('attivita2','attivita2','09:00:00','21:00:00',4.00,'parcogen1','dipendente1'),('attivita2','attivita2','11:00:00','13:00:00',4.00,'parcotem4','dipendente4'),('attivita3','attivita3','08:00:00','12:00:00',3.50,'parcoac2','dipendente2'),('attivita3','attivita3','08:00:00','12:00:00',3.50,'parcoav3','dipendente3'),('attivita3','attivita3','08:00:00','12:00:00',3.50,'parcogen1','dipendente1'),('attivita3','attivita3','08:00:00','12:00:00',3.50,'parcotem4','dipendente4');
/*!40000 ALTER TABLE `attivita` ENABLE KEYS */;
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
