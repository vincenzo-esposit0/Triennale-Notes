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
-- Struttura della tabella `segretario`
--

CREATE TABLE `segretario` (  `CodiceFiscale` char(16) NOT NULL,  `Nome` varchar(25) NOT NULL,  `Cognome` varchar(25) NOT NULL,  `RecapitoTelefonico` varchar(15) NOT NULL,  `TipoContratto` varchar(20) NOT NULL,  PRIMARY KEY (`CodiceFiscale`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1
;

--
-- Dump dei dati per la tabella `segretario`
--

INSERT INTO `segretario` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`) VALUES
('ANTBNC99C12C587S', 'Antonella', 'Bonavita', '3314547893', 'Tempo Determinato'),
('DLANTB99A18C129S', 'Gerardo', 'Donnarumma', '3396864782', 'Occasionale'),
('DLANTN98A13H703Y', 'Antonio', 'Dalia', '330945569', 'Tempo Determinato'),
('MRNDNT94C17H931U', 'Donato', 'Miranda', '3319356835', 'Tempo Indeterminato'),
('SPSVCN00E04C129S', 'Vincenzo', 'Esposito', '3925653872', 'Tempo Indeterminato');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
