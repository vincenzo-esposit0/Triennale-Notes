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
-- Table structure for table `estetista`
--

DROP TABLE IF EXISTS `estetista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estetista` (
  `CodiceFiscale` varchar(16) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) NOT NULL,
  `Età` int(11) NOT NULL,
  `Orario_inizio_turno` int(11) NOT NULL,
  `Orario_fine_turno` int(11) NOT NULL,
  `Stipendio` int(11) NOT NULL,
  `Tipo_Contratto` varchar(45) NOT NULL,
  `DataAssunzione` date NOT NULL,
  `OreStraordinarie` int(11) NOT NULL DEFAULT '0',
  `OreTotali` int(11) NOT NULL DEFAULT '0',
  `GiorniDiLavoro` int(11) NOT NULL DEFAULT '264',
  `Specializzazione` varchar(2) DEFAULT NULL,
  `Numero Macchinari` int(11) DEFAULT '0',
  `Ore_di_Utilizzo` int(11) DEFAULT '0',
  `Tipologia` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estetista`
--

LOCK TABLES `estetista` WRITE;
/*!40000 ALTER TABLE `estetista` DISABLE KEYS */;
INSERT INTO `estetista` VALUES ('DBMDXC70C60B512B','Elisa','Rescigno',24,12,20,1500,'Determinato','2008-06-20',0,0,264,'Si',0,2852,'Viso'),('FSNBDS51L68G784E','Maria','Bianchi',22,12,20,1100,'Determinato','2014-06-25',0,0,264,NULL,0,0,NULL),('JJYSLC44S57F254T','Adele','Abate',19,8,16,1000,'Determinato','2010-05-10',0,0,264,NULL,0,0,NULL),('RDQMMM44C15A044B','Laura','Autuori',21,8,16,1500,'Indeterminato','2005-04-01',0,0,264,'Si',0,2900,'Corpo'),('TFKQSM40E53C884Z','Mirella','Amarante',25,10,18,980,'Determinato','2012-01-04',0,0,264,NULL,0,0,NULL);
/*!40000 ALTER TABLE `estetista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-04 10:33:42
