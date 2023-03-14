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
-- Table structure for table `pacchetto`
--

DROP TABLE IF EXISTS `pacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacchetto` (
  `codice` varchar(25) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `descrizione` text NOT NULL,
  `prezzo` decimal(10,2) DEFAULT '0.00',
  `data_acquisto` date DEFAULT NULL,
  `data_prenotazione` date DEFAULT NULL,
  `cliente` char(16) DEFAULT NULL,
  `agenzia` char(11) NOT NULL,
  `parco` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`codice`,`agenzia`),
  KEY `fk_pacchettocliente` (`cliente`),
  KEY `fk_pacchettoagenzia` (`agenzia`),
  KEY `fk_pacchettoparco` (`parco`),
  CONSTRAINT `fk_pacchettoagenzia` FOREIGN KEY (`agenzia`) REFERENCES `agenzia` (`piva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pacchettocliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`cf`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_pacchettoparco` FOREIGN KEY (`parco`) REFERENCES `parco` (`codice`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacchetto`
--

LOCK TABLES `pacchetto` WRITE;
/*!40000 ALTER TABLE `pacchetto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacchetto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-17 12:41:04
