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
-- Table structure for table `promozione`
--

DROP TABLE IF EXISTS `promozione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promozione` (
  `codice` varchar(25) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `descrizione` text NOT NULL,
  `sconto` smallint(6) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `parco` varchar(25) NOT NULL,
  PRIMARY KEY (`codice`,`parco`),
  KEY `fk_promoparco` (`parco`),
  CONSTRAINT `fk_promoparco` FOREIGN KEY (`parco`) REFERENCES `parco` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promozione`
--

LOCK TABLES `promozione` WRITE;
/*!40000 ALTER TABLE `promozione` DISABLE KEYS */;
INSERT INTO `promozione` VALUES ('promo1','promo1','descrizione promo1 promo1 promo 1 promo 1 promo 1 promo 1',25,'2016-02-02','2016-04-02','parcoac2'),('promo1','promo1','descrizione promo1',40,'2016-03-05','2016-08-05','parcoav3'),('promo1','promo1','descrizione promo1',30,'2015-01-10','2017-11-30','parcogen1'),('promo1','promo1','descrizione promo1',40,'2016-03-05','2016-08-05','parcotem4'),('promo2','promo2','descrizione promo2',10,'2016-01-01','2016-07-03','parcoac2'),('promo2','promo2','descrizione promo2',45,'2011-01-01','2011-01-01','parcoav3'),('promo2','promo2','descrizione promo2',25,'2016-01-05','2016-01-25','parcogen1'),('promo2','promo2','descrizione promo2',45,'2008-01-01','2009-01-01','parcotem4');
/*!40000 ALTER TABLE `promozione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-21 13:10:42
