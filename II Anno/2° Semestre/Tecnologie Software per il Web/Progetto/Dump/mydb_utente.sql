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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `idutente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `valuta` int(11) DEFAULT '0',
  `indirizzo` varchar(45) DEFAULT NULL,
  `admin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `idutente_UNIQUE` (`idutente`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Lorenzo Paolo','Cocchinone','laurus','12345678','lorenzo.cocchinone@gmail.com',1380,'via Trieste n°4 Recale',1),(2,'Mattia','Mascolo','Lightinin97','12345678','Mattia.mascolo@gmail.com',1540,'via Trieste n°4 Recale',0),(3,'Giuseppe','Arienzo','Tempesta58','12345678','Giuseppe.arienzo@gmail.com',1155,'via Trieste n°4 Recale',0),(4,'Enza','Veneziano','EnzaVen','12345678','Enza.veneziano@gmail.com',110,'via Trieste n°4 Recale',0),(5,'Leonardo','Dicaprio','LeoDica','12345678','Leo.Dicaprio@gmailcom',160,'via Trieste n°4 Recale',0),(6,'Marco','Abate','MarcAba','12345678','Marco.abvate@gmail.com',100,'via Trieste n°4 Recale',0),(7,'Nicola','Spada','NIcSpad','12345678','nic.spada@gmail.com',100,'via Trieste n°4 Recale',0),(8,'Rodolfo','nicoletti','Rodnica','12345678','rod.nic@gmail.com',290,'via Trieste n°4 Recale',0),(9,'Aldo','Moretti','AldoMor','12345678','Aldo.mor@gmail.com',300,'via Trieste n°4 Recale',0),(10,'Vittorio','Emanuele','VittEma','12345678','vittorio.manuele@gmail.com',125,'via Trieste n°4 Recale',0),(11,'Giuseppe','Polese','Peppino','12345678','Peppino@gmail.com',110,'via Peppino',0),(12,'Francesco','Rossi','FRossi','12345678','Francesco.rossi@gmail.com',100,'Via Manzoni n°51, Milano, MI, 81xxx',0),(13,'Mario','Rossi','MRossi','12345678','Mario.rossi@gmail.com',100,'Via Manzoni n°5, Milano, Mi, 20089',0),(15,'Test','Test','test','metin2server','test@gmail.com',15,'Via Manzoni n°15, Milano, Mi, 20099',0),(16,'Aldo','Abate','aldo','metin2server','Aba@gmail.com',60,'Via Manzoni n°15, Milano, Mi, 20099',0),(17,'Enza','Veneziano','riccio','password','enzaveneziano@gmail.com',125,'Via Manzoni n°15, Milano, Mi, 20099',0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-22  9:30:09
