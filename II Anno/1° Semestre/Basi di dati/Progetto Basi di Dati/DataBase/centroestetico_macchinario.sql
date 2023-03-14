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
-- Table structure for table `macchinario`
--

DROP TABLE IF EXISTS `macchinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `macchinario` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Modello` varchar(45) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `Tipologia` varchar(15) NOT NULL,
  `Antinvecchiamento` varchar(2) DEFAULT NULL,
  `Dimagrimento` varchar(2) DEFAULT NULL,
  `CD_Estetista` varchar(16) NOT NULL,
  `ID_Sala` int(11) NOT NULL,
  `Ore_di_Utilizzo` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Codice Fiscale Estetista_idx` (`CD_Estetista`),
  KEY `ID Sala_idx` (`ID_Sala`),
  KEY `CD Estetista_idx` (`CD_Estetista`),
  KEY `CF_idx` (`CD_Estetista`),
  CONSTRAINT `CD Estetista_2` FOREIGN KEY (`CD_Estetista`) REFERENCES `estetista` (`codicefiscale`),
  CONSTRAINT `ID Sala_2` FOREIGN KEY (`ID_Sala`) REFERENCES `sala` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `macchinario`
--

LOCK TABLES `macchinario` WRITE;
/*!40000 ALTER TABLE `macchinario` DISABLE KEYS */;
INSERT INTO `macchinario` VALUES (1,'Diodo Laser','Quirumed','DL-500','Brilla','Viso',NULL,'Si','DBMDXC70C60B512B',1,1500),(2,'Ultrasuoni','I-Tech','U-452','Suona','Corpo','Si',NULL,'RDQMMM44C15A044B',2,1000),(3,'Vaccum','Quirumed','V-256','Fa il vuoto','Corpo','Si',NULL,'RDQMMM44C15A044B',3,1200),(4,'E-light','I-Tech','EL-1459','Non lo so','Viso',NULL,'No','DBMDXC70C60B512B',4,500),(5,'Cavitazione','Quirumed','C-458','é un elica ?','Corpo',NULL,'No','RDQMMM44C15A044B',5,700),(6,'PressoTerapia','I-Tech','PT-985','Speriamo che non schiaccia nessuno','Viso','Si',NULL,'DBMDXC70C60B512B',6,852);
/*!40000 ALTER TABLE `macchinario` ENABLE KEYS */;
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
