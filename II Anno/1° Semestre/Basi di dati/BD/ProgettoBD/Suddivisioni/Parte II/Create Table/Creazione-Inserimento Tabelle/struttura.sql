-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2019 alle 13:17
-- Versione del server: 5.6.15-log
-- PHP Version: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `progettocentri`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `struttura`
--

CREATE TABLE `struttura` (  `CodiceStruttura` int(11) NOT NULL AUTO_INCREMENT,
  `AreaOccupata` float NOT NULL,  `Tipo` enum('sala','campo') NOT NULL,  `PresenzaAttrezzatura` enum('si','no','NULL') DEFAULT NULL,  `TipologiaCampo` enum('aperto','chiuso','NULL') DEFAULT NULL,  `NomeCentro` varchar(30) NOT NULL,  PRIMARY KEY (`CodiceStruttura`),  UNIQUE KEY `CodiceStruttura` (`CodiceStruttura`,`NomeCentro`),  KEY `NomeCentro` (`NomeCentro`),  CONSTRAINT `struttura_ibfk_1` FOREIGN KEY (`NomeCentro`) REFERENCES `centro` (`Denominazione`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `struttura`
--

INSERT INTO `struttura` (`CodiceStruttura`, `AreaOccupata`, `Tipo`, `PresenzaAttrezzatura`, `TipologiaCampo`, `NomeCentro`) VALUES
(1, 1000, 'sala', 'si', 'NULL', 'Olimpia'),
(2, 200, 'campo', 'NULL', 'aperto', 'Olimpia'),
(3, 700, 'sala', 'si', 'NULL', 'Nuego'),
(4, 120, 'campo', 'NULL', 'chiuso', 'Nuego'),
(5, 250, 'sala', 'si', 'NULL', 'Falco Sport'),
(6, 240, 'campo', 'NULL', 'aperto', 'Falco Sport'),
(7, 250, 'sala', 'si', 'NULL', 'Canottieri Napoli'),
(8, 100, 'sala', 'no', 'NULL', 'Canottieri Napoli'),
(9, 120, 'sala', 'no', 'NULL', 'Box Club'),
(10, 150, 'sala', 'no', 'NULL', 'Box Club');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
