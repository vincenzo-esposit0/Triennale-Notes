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
-- Struttura della tabella `riconosce`
--

CREATE TABLE `riconosce` (  `NomeCentro` varchar(30) DEFAULT NULL,  `CodiceAttivita` int(11) DEFAULT NULL,  UNIQUE KEY `NomeCentro` (`NomeCentro`,`CodiceAttivita`),  KEY `CodiceAttivita` (`CodiceAttivita`),  CONSTRAINT `riconosce_ibfk_1` FOREIGN KEY (`NomeCentro`) REFERENCES `centro` (`Denominazione`) ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `riconosce_ibfk_2` FOREIGN KEY (`CodiceAttivita`) REFERENCES `attivita` (`CodiceAttivita`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `riconosce`
--

INSERT INTO `riconosce` (`NomeCentro`, `CodiceAttivita`) VALUES
('Box Club', 9),
('Box Club', 10),
('Canottieri Napoli', 5),
('Canottieri Napoli', 7),
('Falco Sport', 4),
('Falco Sport', 8),
('Nuego', 3),
('Nuego', 6),
('Olimpia', 1),
('Olimpia', 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
