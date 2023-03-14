-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2019 alle 13:16
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
-- Struttura della tabella `istruttore`
--

CREATE TABLE `istruttore` (  `CodiceFiscale` char(16) NOT NULL,  `Nome` varchar(25) NOT NULL,  `Cognome` varchar(25) NOT NULL,  `RecapitoTelefonico` varchar(15) NOT NULL,  `TipoContratto` varchar(20) NOT NULL,  `AnniDiEsperienza` int(11) NOT NULL,  `Tipologia` varchar(30) DEFAULT NULL,  `Documento` varchar(30) DEFAULT NULL,  PRIMARY KEY (`CodiceFiscale`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1

--
-- Dump dei dati per la tabella `istruttore`
--

INSERT INTO `istruttore` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`, `AnniDiEsperienza`, `Tipologia`, `Documento`) VALUES
('DLANTN98A13H703Y', 'Antonio', 'Dalia', '330945569', 'Tempo Indeterminato', 8, 'Body Builder', 'attestatodaliaantonio.txt'),
('POPGPP89R25H587Y', 'Giuseppe', 'Garibaldi', '3314895684', 'Tempo Determinato', 3, NULL, NULL),
('RTFPLI90C18H581U', 'Ludovico', 'Maffei', '3358471259', 'In prova', 1, 'Nuoto', NULL),
('TFRLPR64C12H986u', 'Gabriele', 'D''Annunzio', '3258475269', 'Tempo Indeterminato', 15, 'Allenatore Calcio', NULL),
('ZPPLNF00D23H945Y', 'Alfonso', 'Zappia', '3271884294', 'Prova', 1, NULL, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
