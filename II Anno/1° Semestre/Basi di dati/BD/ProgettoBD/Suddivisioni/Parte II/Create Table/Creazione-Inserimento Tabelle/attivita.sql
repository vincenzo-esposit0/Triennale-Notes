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
-- Struttura della tabella `attivita`
--

CREATE TABLE `attivita` (  `CodiceAttivita` int(11) NOT NULL AUTO_INCREMENT,  `Denominazione` varchar(25) NOT NULL,  `Descrizione` varchar(50) NOT NULL,  `Durata` float DEFAULT NULL,  `Periodicita` int(11) DEFAULT NULL,  PRIMARY KEY (`CodiceAttivita`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1
;

--
-- Dump dei dati per la tabella `attivita`
--

INSERT INTO `attivita` (`CodiceAttivita`, `Denominazione`, `Descrizione`, `Durata`, `Periodicita`) VALUES
(1, 'Crossfit', 'Allenamento a corpo libero', 60, NULL),
(2, 'Allenamento Pulcini', 'Partita di calcio bambini', 90, NULL),
(3, 'Allenamento a corpo liber', 'Senza pesi', 50, NULL),
(4, 'Corsa', 'Corsa al chiuso', 20, NULL),
(5, 'Flessioni', '20 flessioni', 10, NULL),
(6, 'Partita ', 'Partita interna', 90, NULL),
(7, 'Crossfit2', 'Allenamento con pesi', 50, NULL),
(8, 'Allenamento Ragazzi', 'Allenamento con birilli', 60, NULL),
(9, 'Allenamento di box', 'Sfida tra ragazzi', 150, NULL),
(10, 'Allenamento di box 2', 'Adulti', 90, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
