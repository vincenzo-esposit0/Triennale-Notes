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
-- Struttura della tabella `svolgimento`
--

CREATE TABLE `svolgimento` (  `CodiceSvolgimento` int(11) NOT NULL AUTO_INCREMENT,  `DataS` date NOT NULL,  `OraS` time NOT NULL,  `Durata` float NOT NULL,  `CodiceStruttura` int(11) NOT NULL,  `CodiceAttivita` int(11) NOT NULL,  PRIMARY KEY (`CodiceSvolgimento`),  KEY `CodiceStruttura` (`CodiceStruttura`),  KEY `CodiceAttivita` (`CodiceAttivita`),  CONSTRAINT `svolgimento_ibfk_1` FOREIGN KEY (`CodiceStruttura`) REFERENCES `struttura` (`CodiceStruttura`) ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `svolgimento_ibfk_2` FOREIGN KEY (`CodiceAttivita`) REFERENCES `attivita` (`CodiceAttivita`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `svolgimento`
--

INSERT INTO `svolgimento` (`CodiceSvolgimento`, `DataS`, `OraS`, `Durata`, `CodiceStruttura`, `CodiceAttivita`) VALUES
(1, '2019-12-09', '15:00:00', 60, 1, 1),
(2, '2019-12-18', '10:00:00', 50, 2, 3),
(3, '2019-12-11', '17:00:00', 20, 3, 4),
(4, '2019-12-24', '14:00:00', 50, 8, 7),
(5, '2019-12-28', '11:00:00', 90, 9, 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
