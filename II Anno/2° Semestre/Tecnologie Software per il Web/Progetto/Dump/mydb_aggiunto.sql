-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aggiunto`
--

DROP TABLE IF EXISTS `aggiunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aggiunto` (
  `prodotto` int(11) NOT NULL,
  `utente` int(11) NOT NULL,
  `quantità` int(11) NOT NULL DEFAULT '0',
  `idaggiunto` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idaggiunto`),
  KEY `idprodotto_idx` (`prodotto`),
  KEY `idutente_idx` (`utente`),
  CONSTRAINT `prodotto` FOREIGN KEY (`prodotto`) REFERENCES `prodotto` (`idprodotto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente` FOREIGN KEY (`utente`) REFERENCES `utente` (`idutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggiunto`
--

LOCK TABLES `aggiunto` WRITE;
/*!40000 ALTER TABLE `aggiunto` DISABLE KEYS */;
INSERT INTO `aggiunto` VALUES (3,2,1,1),(4,2,1,2),(5,2,4,3),(6,2,2,4),(7,2,5,5),(8,2,1,6),(11,3,2,9),(15,3,1,12),(17,4,2,14),(18,4,3,15),(19,4,2,16),(20,4,1,17),(21,4,4,18),(23,4,3,19),(24,5,1,20),(25,5,4,21),(26,5,3,22),(27,5,2,23),(28,5,1,24),(29,5,4,25),(30,5,3,26),(33,6,4,29),(34,6,3,30),(35,6,2,31),(36,6,1,32),(37,6,4,33),(38,6,3,34),(39,6,2,35),(40,6,1,36),(41,7,4,37),(42,7,3,38),(43,7,2,39),(44,7,1,40),(45,7,4,41),(46,7,3,42),(47,7,2,43),(48,7,1,44),(49,8,2,45),(50,8,1,46),(51,8,2,47),(52,8,1,48),(53,8,4,49),(54,8,3,50),(55,8,2,51),(56,8,1,52),(57,9,4,53),(58,9,3,54),(59,9,2,55),(60,9,1,56),(63,9,1,59),(64,9,1,60),(65,10,4,61),(66,10,3,62),(67,10,2,63),(68,10,1,64),(69,10,4,65),(70,10,2,66),(71,10,2,67),(73,11,3,69),(74,11,3,70),(75,11,2,71),(7,3,1,79),(36,3,1,81),(60,3,2,83);
/*!40000 ALTER TABLE `aggiunto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-22  9:30:08
