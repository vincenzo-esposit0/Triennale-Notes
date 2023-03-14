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
-- Table structure for table `bpromozionale`
--

DROP TABLE IF EXISTS `bpromozionale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bpromozionale` (
  `biglietto` varchar(25) NOT NULL,
  `parco_biglietto` varchar(25) NOT NULL,
  `prezzo_scontato` decimal(10,2) NOT NULL,
  `parco_promozione` varchar(25) NOT NULL,
  `promozione` varchar(25) NOT NULL,
  PRIMARY KEY (`biglietto`,`parco_biglietto`),
  KEY `fk_bpromopromozione_idx` (`parco_promozione`,`promozione`),
  CONSTRAINT `fk_bpromopromozione` FOREIGN KEY (`parco_promozione`, `promozione`) REFERENCES `promozione` (`parco`, `codice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_brpomobiglietto` FOREIGN KEY (`biglietto`, `parco_biglietto`) REFERENCES `biglietto` (`codice`, `parco`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bpromozionale`
--

LOCK TABLES `bpromozionale` WRITE;
/*!40000 ALTER TABLE `bpromozionale` DISABLE KEYS */;
/*!40000 ALTER TABLE `bpromozionale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-24 14:18:37
