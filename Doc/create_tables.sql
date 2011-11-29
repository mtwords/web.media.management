SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Datenbank: `mmangement`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category` text COLLATE utf8_bin,
  `mId` int(11) DEFAULT NULL,
  KEY `mId` (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `episode`
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
-- Tabellenstruktur f�r Tabelle `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `lang` text COLLATE utf8_bin,
  `mId` int(11) DEFAULT NULL,
  KEY `mId` (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `movie`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(256) COLLATE utf8_bin NOT NULL,
  `lastName` varchar(256) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `rId` int(11) NOT NULL AUTO_INCREMENT,
  `ratedBy` text COLLATE utf8_bin NOT NULL,
  `ratingText` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`rId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);

--
-- Constraints der Tabelle `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `episode_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);

--
-- Constraints der Tabelle `language`
--
ALTER TABLE `language`
  ADD CONSTRAINT `language_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`mId`);