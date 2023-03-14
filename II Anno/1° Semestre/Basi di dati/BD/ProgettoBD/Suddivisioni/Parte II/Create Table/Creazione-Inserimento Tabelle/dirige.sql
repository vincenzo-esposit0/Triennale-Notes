-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2019 alle 14:02
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
-- Struttura della tabella `dirige`
--

CREATE TABLE `dirige` (  `Responsabile` char(16) DEFAULT NULL,  `NomeCentro` varchar(30) DEFAULT NULL,  UNIQUE KEY `Responsabile` (`Responsabile`,`NomeCentro`),  KEY `NomeCentro` (`NomeCentro`),  CONSTRAINT `dirige_ibfk_1` FOREIGN KEY (`Responsabile`) REFERENCES `responsabile` (`CodiceFiscale`) ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `dirige_ibfk_2` FOREIGN KEY (`NomeCentro`) REFERENCES `centro` (`Denominazione`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `dirige`
--

INSERT INTO `dirige` (`Responsabile`, `NomeCentro`) VALUES
('CPSVCN04E09C127B', 'Box Club'),
('FCNRSN54C26N584T', 'Canottieri Napoli'),
('GNDFLB10E10R654S', 'Falco Sport'),
('NNLDFC12E07D564D', 'Nuego'),
('RRBNLS05S54C456S', 'Olimpia');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
