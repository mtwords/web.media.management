-- script für das erstellen der tabellen mit allen beziehungen

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `mmanagement`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `actsin`
--

CREATE TABLE IF NOT EXISTS `actsin` (
  `mId` int(11) NOT NULL DEFAULT '0',
  `pId` int(11) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  KEY `pId` (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category` text COLLATE utf8_bin,
  `mId` int(11) DEFAULT NULL,
  KEY `mId` (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `directs`
--

CREATE TABLE IF NOT EXISTS `directs` (
  `mId` int(11) NOT NULL DEFAULT '0',
  `pId` int(11) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  KEY `pId` (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `episode`
--

CREATE TABLE IF NOT EXISTS `episode` (
  `eId` int(11) NOT NULL DEFAULT '0',
  `episodeTitle` text COLLATE utf8_bin,
  `description` text COLLATE utf8_bin,
  `year` int(11) DEFAULT NULL,
  `saveLocation` text COLLATE utf8_bin,
  `saveDate` int(11) DEFAULT NULL,
  `mId` int(11) DEFAULT NULL,
  PRIMARY KEY (`eId`),
  KEY `mId` (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `has`
--

CREATE TABLE IF NOT EXISTS `has` (
  `eId` int(11) NOT NULL DEFAULT '0',
  `rId` int(11) DEFAULT NULL,
  PRIMARY KEY (`eId`),
  KEY `rId` (`rId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `lang` text COLLATE utf8_bin,
  `mId` int(11) DEFAULT NULL,
  KEY `mId` (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `mId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) COLLATE utf8_bin NOT NULL,
  `originalTitle` varchar(256) COLLATE utf8_bin NOT NULL,
  `duration` bigint(20) NOT NULL,
  `icon` mediumblob NOT NULL,
  `type` smallint(6) NOT NULL,
  `keywords` varchar(1024) COLLATE utf8_bin NOT NULL,
  `description` mediumblob NOT NULL,
  PRIMARY KEY (`mId`),
  KEY `fk_mId` (`mId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;


-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(256) COLLATE utf8_bin NOT NULL,
  `lastName` varchar(256) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `rId` int(11) NOT NULL AUTO_INCREMENT,
  `ratedBy` text COLLATE utf8_bin NOT NULL,
  `ratingText` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`rId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `wrotescreenplay`
--

CREATE TABLE IF NOT EXISTS `wrotescreenplay` (
  `mId` int(11) NOT NULL DEFAULT '0',
  `pId` int(11) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  KEY `pId` (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `actsin`
--
ALTER TABLE `actsin`
  ADD CONSTRAINT `actsin_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`),
  ADD CONSTRAINT `actsin_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `person` (`pId`);

--
-- Constraints der Tabelle `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);

--
-- Constraints der Tabelle `directs`
--
ALTER TABLE `directs`
  ADD CONSTRAINT `directs_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`),
  ADD CONSTRAINT `directs_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `person` (`pId`);

--
-- Constraints der Tabelle `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `episode_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);

--
-- Constraints der Tabelle `has`
--
ALTER TABLE `has`
  ADD CONSTRAINT `has_ibfk_2` FOREIGN KEY (`rId`) REFERENCES `rating` (`rId`),
  ADD CONSTRAINT `has_ibfk_1` FOREIGN KEY (`eId`) REFERENCES `episode` (`eId`);

--
-- Constraints der Tabelle `language`
--
ALTER TABLE `language`
  ADD CONSTRAINT `language_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);

--
-- Constraints der Tabelle `wrotescreenplay`
--
ALTER TABLE `wrotescreenplay`
  ADD CONSTRAINT `wroteScreenplay_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`),
  ADD CONSTRAINT `wroteScreenplay_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `person` (`pId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
