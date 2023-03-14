-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: centroestetico
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `appuntamento`
--

DROP TABLE IF EXISTS `appuntamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appuntamento` (
  `ID` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Ora` varchar(45) NOT NULL,
  `Durata` int(11) NOT NULL,
  `Tipo` varchar(25) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `CD_Estetista` varchar(16) NOT NULL,
  `ID_Cliente` int(11) NOT NULL,
  `ID_Sala` int(11) NOT NULL,
  `ID_Macchinario` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Codice Fiscale_idx` (`CD_Estetista`),
  KEY `ID Cliente_idx` (`ID_Cliente`),
  KEY `ID Sala_idx` (`ID_Sala`),
  KEY `ID_idx` (`ID_Macchinario`),
  CONSTRAINT `CD Estetista` FOREIGN KEY (`CD_Estetista`) REFERENCES `estetista` (`CodiceFiscale`),
  CONSTRAINT `ID Cliente` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID Macchinario` FOREIGN KEY (`ID_Macchinario`) REFERENCES `macchinario` (`ID`),
  CONSTRAINT `ID Sala` FOREIGN KEY (`ID_Sala`) REFERENCES `sala` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuntamento`
--

LOCK TABLES `appuntamento` WRITE;
/*!40000 ALTER TABLE `appuntamento` DISABLE KEYS */;
INSERT INTO `appuntamento` VALUES (1,'2019-01-10','8',2,'Macchinario Corpo','Si fanno cose con i macchinari','RDQMMM44C15A044B',2,2,2),(2,'2019-01-10','12',2,'Macchinario Viso','Si fanno cose con i macchinari','FSNBDS51L68G784E',1,1,1),(3,'2019-01-11','8',2,'Macchinario Corpo','Si fanno cose con i macchinari','RDQMMM44C15A044B',3,3,3),(4,'2019-01-11','12',2,'Macchinario Viso','Si fanno cose con i macchinari','FSNBDS51L68G784E',5,6,6),(5,'2019-01-11','10',2,'Macchinario Corpo','Si fanno cose con i macchinari','RDQMMM44C15A044B',4,3,3),(6,'2019-01-10','8',3,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',5,10,NULL),(7,'2019-01-10','10',3,'Standard','Si fanno cose senza macchinari','TFKQSM40E53C884Z',4,9,NULL),(8,'2019-01-10','12',3,'Standard','Si fanno cose senza macchinari','FSNBDS51L68G784E',8,7,NULL),(9,'2019-01-11','8',3,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',6,7,NULL),(10,'2019-01-11','10',3,'Standard','Si fanno cose senza macchinari','TFKQSM40E53C884Z',9,8,NULL),(11,'2019-01-10','11',1,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',6,10,NULL),(12,'2019-01-10','13',1,'Standard','Si fanno cose senza macchinari','TFKQSM40E53C884Z',3,9,NULL),(13,'2019-01-10','15',1,'Standard','Si fanno cose senza macchinari','FSNBDS51L68G784E',2,7,NULL),(14,'2019-01-11','12',1,'Standard','Si fanno cose senza macchinari','FSNBDS51L68G784E',1,9,NULL),(15,'2019-01-11','11',1,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',7,7,NULL),(16,'2019-01-10','12',2,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',1,10,NULL),(17,'2019-01-10','14',2,'Standard','Si fanno cose senza macchinari','TFKQSM40E53C884Z',7,9,NULL),(18,'2019-01-11','13',2,'Standard','Si fanno cose senza macchinari','TFKQSM40E53C884Z',10,8,NULL),(19,'2019-01-11','13',2,'Standard','Si fanno cose senza macchinari','FSNBDS51L68G784E',2,9,NULL),(20,'2019-01-11','12',2,'Standard','Si fanno cose senza macchinari','JJYSLC44S57F254T',8,7,NULL);
/*!40000 ALTER TABLE `appuntamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-04 10:33:43
