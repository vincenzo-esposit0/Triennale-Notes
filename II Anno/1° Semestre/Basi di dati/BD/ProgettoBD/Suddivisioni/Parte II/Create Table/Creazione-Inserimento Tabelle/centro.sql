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
-- Struttura della tabella `centro`
--

CREATE TABLE `centro` (  `Denominazione` varchar(30) NOT NULL,  `Citta` varchar(30) NOT NULL,  `Via` varchar(30) NOT NULL,  `NumeroCivico` varchar(10) NOT NULL,  `Cap` char(5) NOT NULL,  `RecapitoTelefonico` varchar(15) NOT NULL,  `Fax` varchar(15) NOT NULL,  PRIMARY KEY (`Denominazione`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `centro`
--

INSERT INTO `centro` (`Denominazione`, `Citta`, `Via`, `NumeroCivico`, `Cap`, `RecapitoTelefonico`, `Fax`) VALUES
('Box Club', 'Pagani', 'Bella', '7', '84014', '0812526347', '123456'),
('Canottieri Napoli', 'Napoli', 'Annunziata', '50', '80145', '0617548751', '123456'),
('Falco Sport', 'Striano', 'Roma', '4', '84122', '0814547861', '123456'),
('Nuego', 'Ottaviano', 'Passanti', '5', '08547', '0814568271', '123456'),
('Olimpia', 'Angri', 'Astronauti', '17', '84012', '0815165741', '123456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
