-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2019 alle 14:11
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
-- Struttura della tabella `prenotazione`
--

CREATE TABLE `prenotazione` (
  `CodicePrenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `DataP` date NOT NULL,
  `OraP` time NOT NULL,
  `Durata` float NOT NULL,
  `Descrizione` varchar(50) DEFAULT NULL,
  `Segretario` char(16) NOT NULL,
  `CodiceStruttura` int(11) NOT NULL,
  `NomeCentro` varchar(30) NOT NULL,
  `CodiceAttivita` int(11) NOT NULL,
  PRIMARY KEY (`CodicePrenotazione`),
  UNIQUE KEY `DataP` (`DataP`,`OraP`,`CodiceStruttura`,`NomeCentro`),
  KEY `CodiceStruttura` (`CodiceStruttura`,`NomeCentro`),
  KEY `CodiceAttivita` (`CodiceAttivita`),
  CONSTRAINT `prenotazione_ibfk_1` FOREIGN KEY (`CodiceStruttura`, `NomeCentro`) REFERENCES `struttura` (`CodiceStruttura`, `NomeCentro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prenotazione_ibfk_2` FOREIGN KEY (`CodiceAttivita`) REFERENCES `attivita` (`CodiceAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prenotazione`
--

INSERT INTO `prenotazione` (`CodicePrenotazione`, `DataP`, `OraP`, `Durata`, `Descrizione`, `Segretario`, `CodiceStruttura`, `NomeCentro`, `CodiceAttivita`) VALUES
(1, '2019-12-09', '00:00:00', 60, 'Prenotazione confermata', 'ANTBNC99C12C587S', 1, 'Olimpia', 1),
(2, '2019-12-18', '00:00:00', 50, 'Prenotazione confermata', 'DLANTB99A18C129S', 3, 'Nuego', 3),
(3, '2019-12-11', '00:00:00', 20, 'Prenotazione confermata', 'DLANTN98A13H703Y', 5, 'Falco Sport', 4),
(4, '2019-12-24', '00:00:00', 50, 'Prenotazione confermata', 'MRNDNT94C17H931U', 8, 'Canottieri Napoli', 7),
(5, '2019-12-28', '00:00:00', 90, 'Prenotazione confermata', 'SPSVCN00E04C129S', 9, 'Box Club', 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
