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
-- Struttura della tabella `presiede`
--

CREATE TABLE `presiede` (  `Istruttore` char(16) NOT NULL,  `CodiceAttivita` int(11) NOT NULL,  UNIQUE KEY `Istruttore` (`Istruttore`,`CodiceAttivita`),  KEY `CodiceAttivita` (`CodiceAttivita`),  CONSTRAINT `presiede_ibfk_1` FOREIGN KEY (`Istruttore`) REFERENCES `istruttore` (`CodiceFiscale`) ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `presiede_ibfk_2` FOREIGN KEY (`CodiceAttivita`) REFERENCES `attivita` (`CodiceAttivita`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `presiede`
--

INSERT INTO `presiede` (`Istruttore`, `CodiceAttivita`) VALUES
('DLANTN98A13H703Y', 1),
('DLANTN98A13H703Y', 2),
('POPGPP89R25H587Y', 3),
('POPGPP89R25H587Y', 4),
('RTFPLI90C18H581U', 5),
('RTFPLI90C18H581U', 6),
('TFRLPR64C12H986u', 7),
('TFRLPR64C12H986u', 8),
('ZPPLNF00D23H945Y', 9),
('ZPPLNF00D23H945Y', 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
