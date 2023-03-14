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
-- Struttura della tabella `responsabile`
--

CREATE TABLE `responsabile` (  `CodiceFiscale` char(16) NOT NULL,  `Nome` varchar(25) NOT NULL,  `Cognome` varchar(25) NOT NULL,  `RecapitoTelefonico` varchar(15) NOT NULL,  `TipoContratto` varchar(20) NOT NULL,  PRIMARY KEY (`CodiceFiscale`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1
;

--
-- Dump dei dati per la tabella `responsabile`
--

INSERT INTO `responsabile` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`) VALUES
('CPSVCN04E09C127B', 'Francesco', 'Esposito', '3394845217', 'Tempo Indeterminato'),
('FCNRSN54C26N584T', 'Francesca', 'Pepe', '3664578123', 'Tempo Indeterminato'),
('GNDFLB10E10R654S', 'Gerardo', 'Ferraioli', '3478859159', 'Tempo Determinato'),
('NNLDFC12E07D564D', 'Nicola', 'Annarumma', '3477898552', 'Tempo Determinato'),
('RRBNLS05S54C456S', 'Rossella', 'D''auria', '3928586371', 'Tempo Indeterminato');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
