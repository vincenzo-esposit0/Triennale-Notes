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
  `numbiglietti` smallint(6) DEFAULT '0',
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
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
INSERT INTO `pacchetto` VALUES ('pacchetto1','pacchetto1','descrizione pacchetto 1',1260.00,2,'2014-01-01','2014-03-01',NULL,'2017-00-19','cliente1','00000000000','parcogen1'),('pacchetto1','pacchetto1','descrizione pacchetto 1',135.00,3,'2017-11-01','2017-12-31',NULL,'2017-01-20','cliente2','11111111111','parcoac2'),('pacchetto1','pacchetto1','descrizione pacchetto 1',120.00,4,'2017-06-20','2017-07-20',NULL,NULL,NULL,'22222222222','parcoav3'),('pacchetto1','pacchetto1','descrizione pacchetto 1',105.00,3,'2014-03-01','2014-03-01',NULL,NULL,NULL,'33333333333','parcotem4'),('pacchetto2','pacchetto2','descrizione pacchetto 2',150.00,0,'2017-02-28','2017-04-28',NULL,NULL,NULL,'00000000000','parcoac2'),('pacchetto2','pacchetto1','descrizione pacchetto 2',165.00,0,'2017-05-01','2017-06-01',NULL,NULL,NULL,'11111111111','parcoav3'),('pacchetto2','pacchetto2','descrizione pacchetto 2',110.00,0,'2015-01-01','2015-01-31',NULL,NULL,NULL,'22222222222','parcotem4'),('pacchetto2','pacchetto2','descrizione pacchetto 2',101.00,0,'2014-04-01','2014-05-01',NULL,NULL,NULL,'33333333333','parcogen1');
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

-- Dump completed on 2017-01-19 23:54:28
