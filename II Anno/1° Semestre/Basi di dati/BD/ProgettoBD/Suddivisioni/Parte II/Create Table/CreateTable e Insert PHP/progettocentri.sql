-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2019 alle 13:15
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

CREATE TABLE IF NOT EXISTS `attivita` (
  `CodiceAttivita` int(11) NOT NULL AUTO_INCREMENT,
  `Denominazione` varchar(25) NOT NULL,
  `Descrizione` varchar(50) NOT NULL,
  `Durata` float DEFAULT NULL,
  `Periodicita` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodiceAttivita`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `centro`
--

CREATE TABLE IF NOT EXISTS `centro` (
  `Denominazione` varchar(30) NOT NULL,
  `Citta` varchar(30) NOT NULL,
  `Via` varchar(30) NOT NULL,
  `NumeroCivico` varchar(10) NOT NULL,
  `Cap` char(5) NOT NULL,
  `RecapitoTelefonico` varchar(15) NOT NULL,
  `Fax` varchar(15) NOT NULL,
  PRIMARY KEY (`Denominazione`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `centro`
--

INSERT INTO `centro` (`Denominazione`, `Citta`, `Via`, `NumeroCivico`, `Cap`, `RecapitoTelefonico`, `Fax`) VALUES
('Box Club', 'Pagani', 'Bella', '7', '84014', '0812526347', '123456'),
('Canottieri Napoli', 'Napoli', 'Annunziata', '50', '80145', '0617548751', '123456'),
('Falco Sport', 'Striano', 'Roma', '4', '84122', '0814547861', '123456'),
('Nuego', 'Ottaviano', 'Passanti', '5', '08547', '0814568271', '123456'),
('Olimpia', 'Angri', 'Astronauti', '17', '84012', '0815165741', '123456');

-- --------------------------------------------------------

--
-- Struttura della tabella `dirige`
--

CREATE TABLE IF NOT EXISTS `dirige` (
  `Responsabile` char(16) DEFAULT NULL,
  `NomeCentro` varchar(30) DEFAULT NULL,
  UNIQUE KEY `Responsabile` (`Responsabile`,`NomeCentro`),
  KEY `NomeCentro` (`NomeCentro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `dirige`
--

INSERT INTO `dirige` (`Responsabile`, `NomeCentro`) VALUES
('DLANTN98A13H703Y', 'Box Club'),
('POPGPP89R25H587Y', 'Canottieri Napoli'),
('RTFPLI90C18H581U', 'Falco Sport'),
('TFRLPR64C12H986u', 'Nuego'),
('ZPPLNF00D23H945Y', 'Olimpia');

-- --------------------------------------------------------

--
-- Struttura della tabella `istruttore`
--

CREATE TABLE IF NOT EXISTS `istruttore` (
  `CodiceFiscale` char(16) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `RecapitoTelefonico` varchar(15) NOT NULL,
  `TipoContratto` varchar(20) NOT NULL,
  `AnniDiEsperienza` int(11) NOT NULL,
  `Tipologia` varchar(30) DEFAULT NULL,
  `Documento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CodiceFiscale`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `istruttore`
--

INSERT INTO `istruttore` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`, `AnniDiEsperienza`, `Tipologia`, `Documento`) VALUES
('DLANTN98A13H703Y', 'Antonio', 'Dalia', '330945569', 'Tempo Indeterminato', 8, 'Body Builder', 'attestatodaliaantonio.txt'),
('POPGPP89R25H587Y', 'Giuseppe', 'Garibaldi', '3314895684', 'Tempo Determinato', 3, NULL, NULL),
('RTFPLI90C18H581U', 'Ludovico', 'Maffei', '3358471259', 'In prova', 1, 'Nuoto', NULL),
('TFRLPR64C12H986u', 'Gabriele', 'D''Annunzio', '3258475269', 'Tempo Indeterminato', 15, 'Allenatore Calcio', NULL),
('ZPPLNF00D23H945Y', 'Alfonso', 'Zappia', '3271884294', 'Prova', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `prenotazione`
--

CREATE TABLE IF NOT EXISTS `prenotazione` (
  `CodicePrenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `DataP` date NOT NULL,
  `OraP` time NOT NULL,
  `Durata` float NOT NULL,
  `Descrizione` varchar(50) DEFAULT NULL,
  `Segretario` char(16) NOT NULL,
  `CodiceStruttura` int(11) NOT NULL,
  `CodiceAttivita` int(11) NOT NULL,
  PRIMARY KEY (`CodicePrenotazione`),
  UNIQUE KEY `DataP` (`DataP`,`OraP`,`CodiceStruttura`),
  KEY `CodiceStruttura` (`CodiceStruttura`),
  KEY `CodiceAttivita` (`CodiceAttivita`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dump dei dati per la tabella `prenotazione`
--

INSERT INTO `prenotazione` (`CodicePrenotazione`, `DataP`, `OraP`, `Durata`, `Descrizione`, `Segretario`, `CodiceStruttura`, `CodiceAttivita`) VALUES
(1, '2019-12-09', '15:00:00', 60, 'Prenotazione confermata', 'ANTBNC99C12C587S', 1, 1),
(2, '2019-12-18', '10:00:00', 50, 'Prenotazione confermata', 'DLANTB99A18C129S', 3, 3),
(3, '2019-12-11', '17:00:00', 20, 'Prenotazione confermata', 'DLANTN98A13H703Y', 5, 4),
(4, '2019-12-24', '14:00:00', 50, 'Prenotazione confermata', 'MRNDNT94C17H931U', 8, 7),
(5, '2019-12-28', '11:00:00', 90, 'Prenotazione confermata', 'SPSVCN00E04C129S', 9, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `presiede`
--

CREATE TABLE IF NOT EXISTS `presiede` (
  `Istruttore` char(16) NOT NULL,
  `CodiceAttivita` int(11) NOT NULL,
  UNIQUE KEY `Istruttore` (`Istruttore`,`CodiceAttivita`),
  KEY `CodiceAttivita` (`CodiceAttivita`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `responsabile`
--

CREATE TABLE IF NOT EXISTS `responsabile` (
  `CodiceFiscale` char(16) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `RecapitoTelefonico` varchar(15) NOT NULL,
  `TipoContratto` varchar(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `responsabile`
--

INSERT INTO `responsabile` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`) VALUES
('CPSVCN04E09C127B', 'Francesco', 'Esposito', '3394845217', 'Tempo Indeterminato'),
('FCNRSN54C26N584T', 'Francesca', 'Pepe', '3664578123', 'Tempo Indeterminato'),
('GNDFLB10E10R654S', 'Gerardo', 'Ferraioli', '3478859159', 'Tempo Determinato'),
('NNLDFC12E07D564D', 'Nicola', 'Annarumma', '3477898552', 'Tempo Determinato'),
('RRBNLS05S54C456S', 'Rossella', 'D''auria', '3928586371', 'Tempo Indeterminato');

-- --------------------------------------------------------

--
-- Struttura della tabella `riconosce`
--

CREATE TABLE IF NOT EXISTS `riconosce` (
  `NomeCentro` varchar(30) DEFAULT NULL,
  `CodiceAttivita` int(11) DEFAULT NULL,
  UNIQUE KEY `NomeCentro` (`NomeCentro`,`CodiceAttivita`),
  KEY `CodiceAttivita` (`CodiceAttivita`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `segretario`
--

CREATE TABLE IF NOT EXISTS `segretario` (
  `CodiceFiscale` char(16) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `RecapitoTelefonico` varchar(15) NOT NULL,
  `TipoContratto` varchar(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `segretario`
--

INSERT INTO `segretario` (`CodiceFiscale`, `Nome`, `Cognome`, `RecapitoTelefonico`, `TipoContratto`) VALUES
('ANTBNC99C12C587S', 'Antonella', 'Bonavita', '3314547893', 'Tempo Determinato'),
('DLANTB99A18C129S', 'Gerardo', 'Donnarumma', '3396864782', 'Occasionale'),
('DLANTN98A13H703Y', 'Antonio', 'Dalia', '330945569', 'Tempo Determinato'),
('MRNDNT94C17H931U', 'Donato', 'Miranda', '3319356835', 'Tempo Indeterminato'),
('SPSVCN00E04C129S', 'Vincenzo', 'Esposito', '3925653872', 'Tempo Indeterminato');

-- --------------------------------------------------------

--
-- Struttura della tabella `struttura`
--

CREATE TABLE IF NOT EXISTS `struttura` (
  `CodiceStruttura` int(11) NOT NULL AUTO_INCREMENT,
  `AreaOccupata` float NOT NULL,
  `Tipo` enum('sala','campo') NOT NULL,
  `PresenzaAttrezzatura` enum('si','no','NULL') DEFAULT NULL,
  `TipologiaCampo` enum('aperto','chiuso','NULL') DEFAULT NULL,
  `NomeCentro` varchar(30) NOT NULL,
  PRIMARY KEY (`CodiceStruttura`),
  UNIQUE KEY `CodiceStruttura` (`CodiceStruttura`,`NomeCentro`),
  KEY `NomeCentro` (`NomeCentro`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dump dei dati per la tabella `struttura`
--

INSERT INTO `struttura` (`CodiceStruttura`, `AreaOccupata`, `Tipo`, `PresenzaAttrezzatura`, `TipologiaCampo`, `NomeCentro`) VALUES
(1, 1000, 'sala', 'si', 'NULL', 'Olimpia'),
(2, 200, 'campo', 'NULL', 'aperto', 'Olimpia'),
(3, 700, 'sala', 'si', 'NULL', 'Nuego'),
(4, 120, 'campo', 'NULL', 'chiuso', 'Nuego'),
(5, 250, 'sala', 'si', 'NULL', 'Falco Sport'),
(6, 240, 'campo', 'NULL', 'aperto', 'Falco Sport'),
(7, 250, 'sala', 'si', 'NULL', 'Canottieri Napoli'),
(8, 100, 'sala', 'no', 'NULL', 'Canottieri Napoli'),
(9, 120, 'sala', 'no', 'NULL', 'Box Club'),
(10, 150, 'sala', 'no', 'NULL', 'Box Club');

-- --------------------------------------------------------

--
-- Struttura della tabella `svolgimento`
--

CREATE TABLE IF NOT EXISTS `svolgimento` (
  `CodiceSvolgimento` int(11) NOT NULL AUTO_INCREMENT,
  `DataS` date NOT NULL,
  `OraS` time NOT NULL,
  `Durata` float NOT NULL,
  `CodiceStruttura` int(11) NOT NULL,
  `CodiceAttivita` int(11) NOT NULL,
  PRIMARY KEY (`CodiceSvolgimento`),
  KEY `CodiceStruttura` (`CodiceStruttura`),
  KEY `CodiceAttivita` (`CodiceAttivita`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

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
