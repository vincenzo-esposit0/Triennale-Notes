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
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prodotto` (
  `idprodotto` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(255) NOT NULL,
  `prezzo` int(11) DEFAULT '0',
  `piattaforma` varchar(45) DEFAULT 'General',
  `genere` varchar(45) DEFAULT 'General',
  `anno` varchar(5) DEFAULT '2000',
  PRIMARY KEY (`idprodotto`),
  UNIQUE KEY `idprodotto_UNIQUE` (`idprodotto`),
  UNIQUE KEY `titolo_UNIQUE` (`titolo`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'Halo 5: Guardians - Xbox One',20,'Xbox One','FPS','2015'),(3,'Battlefield 5 - Xbox One',15,'Xbox One','FPS','2018'),(4,'Doom - Xbox One',15,'Xbox One','FPS','2016'),(5,'Doom - PS4',15,'PS4','FPS','2016'),(6,'Doom - Switch',25,'Switch','FPS','2018'),(7,'Titanfall 2 - Xbox One',5,'Xbox One','FPS','2016'),(8,'Titanfall 2 - PS4',5,'PS4','FPS','2016'),(9,'Battlefield 1 - Xbox One',5,'Xbox One','FPS','2016'),(10,'Battlefield 1 - PS4',5,'PS4','FPS','2016'),(11,'Wolfestein: The New Order - Xbox One',15,'Xbox One','FPS','2015'),(12,'Wolfestein: The New Order - PS4',15,'PS4','FPS','2015'),(14,'Wolfestein: The New Colossus - PS4',25,'PS4','FPS','2018'),(15,'Bordelands 2 - Xbox 360',10,'Xbox 360','FPS','2012'),(16,'Bordelands 2 - PS3',10,'PS3','FPS','2012'),(17,'Destiny - Xbox One',5,'Xbox One','FPS','2013'),(18,'Destiny - PS4',5,'PS4','FPS','2013'),(19,'Rage - Xbox One',35,'Xbox One','FPS','2019'),(20,'Rage - PS4',35,'PS4','FPS','2019'),(21,'Prey - Xbox One',30,'Xbox One','FPS','2017'),(22,'Prey - PS4',30,'PS4','FPS','2017'),(23,'Destiny 2 - Xbox One',15,'Xbox One','FPS','2017'),(24,'Destiny 2 - PS4',15,'PS4','FPS','2017'),(25,'Titanfall - Xbox One',5,'Xbox One','FPS','2014'),(26,'Titanfall - PS4',5,'PS4','FPS','2014'),(27,'Halo 2 - Xbox',60,'Xbox','FPS','2004'),(28,'Far Cry 5 - Xbox One',25,'Xbox One','FPS','2018'),(29,'Far Cry 5 - PS4',25,'PS4','FPS','2018'),(30,'Call of Duty Black Ops - Xbox 360',15,'Xbox 360','FPS','2010'),(31,'Call of Duty Black Ops - PS3',15,'PS3','FPS','2010'),(32,'Call of Duty Black Ops 3 - Xbox One',30,'Xbox One','FPS','2015'),(33,'Call of Duty Black Ops 3 - PS4',30,'PS4','FPS','2015'),(34,'Call of Duty Modern Warfare 2 - Xbox 360',15,'Xbox 360','FPS','2009'),(35,'Call of Duty Modern Warfare 2 - PS3',15,'PS3','FPS','2009'),(36,'Call of Duty Modern Warfare 3 - Xbox 360',15,'Xbox 360','FPS','2011'),(37,'Call of Duty Modern Warfare 3 - PS',15,'PS3','FPS','2011'),(38,'Diablo 3 - Xbox 360',10,'Xbox 360','RPG','2014'),(39,'Diablo 3 - PS3',10,'PS3','RPG','2014'),(40,'Diablo 3 - Xbox One',25,'Xbox One','RPG','2015'),(41,'Diablo 3 - PS4',25,'PS4','RPG','2015'),(42,'Diablo 3 - Switch',45,'Switch','RPG','2018'),(43,'Final Fantasy XV - Xbox One',20,'Xbox One','JRPG','2016'),(44,'Final Fantasy XV - PS4',20,'PS4','JRPG','2016'),(45,'NieR Automata - PS4',40,'PS4','Action','2017'),(46,'Fallout: New Vegas - Xbox 360',20,'Xbox 360','FPS','2007'),(47,'Fallout: New Vegas - PS3',20,'PS3','FPS','2007'),(48,'Assassin\'s Creed: Origins - Xbox One',45,'Xbox One','Action','2017'),(49,'Assassin\'s Creed: Origins - PS4',45,'PS4','Action','2017'),(50,'Bloodborne - PS4',50,'PS4','RPG','2015'),(51,'Dark Souls Prepare to Die Again - Xbox 360',60,'Xbox 360','RPG','2011'),(52,'Dark Souls Prepare to Die Again - PS3',60,'PS3','RPG','2011'),(53,'Dark souls 2 GOTY - Xbox 360',15,'Xbox 360','RPG','2015'),(54,'Dark souls 2 GOTY - PS3',15,'PS3','RPG','2015'),(55,'Dark souls 2 GOTY - Xbox One',25,'Xbox One','RPG','2015'),(56,'Dark souls 2 GOTY - PS4',25,'PS4','RPG','2015'),(57,'Dark souls Remastered - Xbox One',40,'Xbox One','RPG','2018'),(58,'Dark souls Remastered - PS4',40,'PS4','RPG','2018'),(59,'Dark souls Remastered - Switch',40,'Switch','RPG','2018'),(60,'Anthem',10,'Xbox One','TPS','2019'),(61,'Anthem - PS4',10,'PS4','TPS','2019'),(62,'Final Fantasy XV Royal Edition - Xbox One',40,'Xbox One','JRPG','2018'),(63,'Final Fantasy XV Royal Edition - PS4',40,'PS4','JRPG','2018'),(64,'Mass Effect 3  - Xbox 360',10,'Xbox 360','TPS','2011'),(65,'Mass Effect 3 - PS3',10,'PS3','TPS','2011'),(66,'Mass Effect 2 - Xbox 360',5,'Xbox 360','TPS','2008'),(67,'Mass Effect 2 - PS3',5,'PS3','TPS','2008'),(68,'Mass Effect - Xbox 360',25,'Xbox 360','TPS','2007'),(69,'Fallout 4 - Xbox One',15,'Xbox One','FPS','2015'),(70,'Fallout 4 - PS4',15,'PS4','FPS','2015'),(71,'Horizon Zero Dawn - PS4',25,'PS4','TPS','2017'),(72,'Dragon Age: Inquisition - Xbox One',10,'Xbox One','RPG','2014'),(73,'Dragon Age: inquisition - PS4',10,'PS4','RPG','2014'),(74,'FIFA 19 - Xbox One',15,'Xbox One','Sport','2018'),(75,'FIFA 19 - PS4',15,'PS4','Sport','2018'),(76,'FIFA 19 - Switch',25,'Switch','Sport','2018'),(77,'FIFA 18 - Xbox One',5,'Xbox One','Sport','2017'),(78,'FIFA 18 - PS4',5,'PS4','Sport','2017'),(79,'FIFA 18 - Switch',10,'Switch','Sport','2017'),(80,'Forza Horizon 4 - Xbox One',25,'Xbox One','Corse','2018'),(81,'Forza Horizon 3 - Xbox One',20,'Xbox One','Corse','2016'),(82,'Forza Horizon 2 - Xbox One',15,'Xbox One','Corse','2014'),(83,'NBA 2K19 - Xbox One',35,'Xbox One','Sport','2018'),(84,'NBA 2K19 - PS4',35,'PS4','Sport','2018'),(85,'NBA 2K18 - Xbox One',25,'Xbox One','Sport','2017'),(86,'NBA 2K18 - PS4',25,'PS4','Sport','2017'),(87,'F1 2018 - Xbox One',35,'Xbox One','Corse','2017'),(88,'F1 2018 - PS4',35,'PS4','Corse','2017'),(89,'F1 2017 - Xbox One',20,'XBOX ONE','Corse','2016'),(90,'F1 2017 - PS4',20,'PS4','Corse','2016'),(91,'Assetto Corsa - Xbox One',25,'XBOX ONE','Corse','2017'),(92,'Assetto Corsa - PS4',25,'PS4','Corse','2017'),(93,'Tekken 7 - Xbox One',40,'Xbox One','Picchiaduro','2016'),(94,'Tekken 7 - PS4',40,'PS4','Picchiaduro','2016'),(95,'Tekken 6 - Xbox 360',15,'Xbox 360','Picchiaduro','2008'),(96,'Tekken 6 - PS3',15,'PS3','Picchiaduro','2008'),(97,'Until Dawn - PS4',20,'PS4','Horror','2015'),(98,'Gravity Rush 2 - PS4',20,'PS4','Action','2016'),(99,'Dragon Ball Xenoverse - Xbox One',10,'XBOX ONE','Picchiaduro','2014'),(100,'Dragon Ball Xenoverse - PS4',25,'PS4','Picchiaduro','2014'),(101,'Dragon Ball Xenoverse 2 - Xbox One',25,'XBOX ONE','Picchiaduro','2016'),(102,'Dragon Ball Xenoverse 2 - PS4',25,'PS4','Picchiaduro','2016'),(103,'Dragon Ball Xenoverse 2 - Switch',45,'Switch','Picchiaduro','2018'),(104,'Marvel vs. Capcom: Infinite - Xbox One',10,'XBOX ONE','Picchiaduro','2013'),(105,'Marvel vs. Capcom: Infinite - PS4',10,'PS4','Picchiaduro','2013'),(106,'Dead or Alive 5 Ultimate Edition  - Xbox One',15,'Xbox One','Picchiaduro','2013'),(107,'Dead or Alive 5 Ultimate Edition - PS4',15,'PS4','Picchiaduro','2013'),(108,'Dead or Alive 6 - Xbox One',50,'Xbox One','Picchiaduro','2019'),(109,'Dead or Alive 6 - PS4',50,'PS4','Picchiaduro','2019'),(110,'Soulcalibur VI - Xbox One',50,'Xbox One','Picchiaduro','2019'),(111,'Detroit: Become Human - PS4',30,'PS4','Action','2018'),(112,'Soulcalibur VI - PS4',50,'PS4','Picchiaduro','2019'),(113,'Persona 5 - PS4',50,'PS4','JRPG','2017'),(114,'Pokken Tournament - Switch',60,'Switch','Picchiaduro','2017'),(115,'The Legend of Zelda: Breath of the Wild - Switch',70,'Switch','RPG','2017'),(116,'Pokemon Let\'s go Pikachu - Switch',60,'Switch','RPG','2018'),(117,'Pokemon Let\'s go Evee - Switch',60,'Switch','RPG','2018'),(118,'Monster Hunter World - PS4',35,'PS4','Action','2018'),(119,'Monster Hunter Generation Ultimate - Switch',50,'Switch','Action','2018'),(120,'Super Mario Odyssey - Switch',50,'Switch','Action','2017'),(121,'Super Smash Bros Ultimate - Switch',60,'Switch','Picchiaduro','2018'),(122,'Gears of War  - Xbox 360',5,'Xbox 360','TPS','2006'),(123,'Gears of War 2  - Xbox 360',15,'Xbox 360','TPS','2008'),(124,'Gears of War 3 - Xbox 360',15,'Xbox 360','TPS','2012'),(125,'Gears of War 4 - Xbox One',10,'Xbox One','TPS','2014'),(126,'Gears of War Judgment  - Xbox 360',5,'Xbox One','TPS','2013'),(127,'Halo: The Master Chief Collection - Xbox One',20,'Xbox One','FPS','2014'),(128,'Halo 4  - Xbox 360',15,'Xbox 360','FPS','2012'),(129,'Halo Combat Evolved  - Xbox 360',100,'Xbox 360','FPS','2001'),(130,'God of War - PS4',50,'PS4','Action','2018'),(131,'Marvel\'s Spider-Man - PS4',40,'PS4','Action','2018'),(132,'Death Stranding - PS4',70,'PS4','????','2019'),(133,'Sekiro: Shadows Die Twice - PS4',60,'PS4','Action','2019'),(134,'Sekiro: Shadows Die Twice - Xbox One',60,'Xbox One','Action','2019'),(135,'Resident evil 7 - Xbox One',20,'Xbox One','Horror','2017'),(136,'Resident evil 7 - PS4',20,'PS4','Horror','2017'),(137,'Resident Evil 2 Remake - Xbox One',35,'Xbox One','Horror','2019'),(138,'Resident Evil 2 Remake - PS4',35,'PS4','Horror','2019'),(139,'Infamous: Second Son - PS4',15,'PS4','Action','2014'),(140,'Metal Gear Solid 4: Guns of the Patriots',20,'PS3','TPS','2008'),(141,'The Last of Us Part II - PS4',70,'PS4','TPS','2019'),(142,'Uncharted 4: Fine di un ladro - PS4',20,'PS4','TPS','2015'),(143,'Gran Turismo Sport - PS4',20,'PS4','Corse','2017'),(144,'Ratchet & Clank - PS4',20,'PS4','Action','2017'),(145,'Days Gone - PS4',45,'PS4','TPS','2019'),(146,'Knack - PS4',20,'PS4','Action','2014'),(147,'Driveclub - PS4',25,'PS4','Corse','2015'),(148,'The Last of Us Remastered - PS4',10,'PS4','TPS','2014'),(149,'God of War III Remastered - PS4',10,'PS4','Action','2017'),(150,'The Order: 1886 - PS4',10,'PS4','TPS','2015');
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
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
