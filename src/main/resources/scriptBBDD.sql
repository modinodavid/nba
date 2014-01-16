USE nbaTest;

-- DELETE hibernate_sequence REGISTER
DELETE FROM `hibernate_sequence`
WHERE `SEQ_NAME`= 'SEQ_NAME'
AND `NEXT_VAL` = '0'; 

-- DROP hibernate_sequence TABLE
DROP TABLE IF EXISTS `hibernate_sequence`;

-- DROP postPoll TABLE
DROP TABLE IF EXISTS `postPoll`;

-- DROP postPoll TABLE
DROP TABLE IF EXISTS `Poll`;

-- DROP TABLE IF EXISTS `postForum`
DROP TABLE IF EXISTS `postForum`;

-- DROP FORUM TABLE
DROP TABLE IF EXISTS `forum`;

-- DROP SCORING TABLE 
DROP TABLE IF EXISTS `scoring`;

-- DROP MATCH TABLE
DROP TABLE IF EXISTS `match`;

-- DROP PLAYER TABLE
DROP TABLE IF EXISTS `player`;

-- DROP NBAPLAYER TABLE
DROP TABLE IF EXISTS `nbaPlayer`;

-- DROP NBATEAM TABLE
DROP TABLE IF EXISTS `nbaTeam`;

-- DROP TEAM TABLE
DROP TABLE IF EXISTS `team`;

-- DROP LEAGUE LEAGUE
DROP TABLE IF EXISTS `league`;  

-- DROP USER TABLE
DROP TABLE IF EXISTS `user`;

-- DROP COUNTRY TABLE
DROP TABLE IF EXISTS `country`;

-- DROP PREFERREDLANGUAGE TABLE
DROP TABLE IF EXISTS `preferredLanguage`;

-- CREATE PREFERREDLANGUAGE TABLE
CREATE  TABLE `nbaTest`.`preferredLanguage` (
  `idPrefLanguage` INT(11) NOT NULL ,
  `code` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idPrefLanguage`) 
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- CREATE COUNTRY TABLE
CREATE  TABLE `nbaTest`.`country` (
  `idCountry` INT(11) NOT NULL ,
  `code` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCountry`) 
);
  
-- CREATE USER TABLE
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `type` int(1) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `prefLanguageId` int(11) NOT NULL,
  PRIMARY KEY (`idUser`),
  KEY `countryId_idx` (`countryId`),
  KEY `idPrefLanguage_idx` (`prefLanguageId`),
  CONSTRAINT `idCountry` FOREIGN KEY (`countryId`) REFERENCES `country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPrefLanguage` FOREIGN KEY (`prefLanguageId`) REFERENCES `preferredLanguage` (`idPrefLanguage`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
  
-- CREATE LEAGUE TABLE
CREATE TABLE `league` (
  `idLeague` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `logo` longblob,
  `password` varchar(45) NOT NULL,
  `maxTeams` int(11) DEFAULT NULL,
  `salaryPerTeam` double NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idLeague`),
  KEY `idUser_idx` (`idUser`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE TEAM TABLE
  CREATE TABLE `team` (
  `idTeam` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `salary` double NOT NULL,
  `maxPlayers` int(11) NOT NULL,
  `teamScoring` float DEFAULT NULL,
  `idLeague` int(11) NOT NULL,
  PRIMARY KEY (`idTeam`),
  KEY `idLeague_idx` (`idLeague`),
  CONSTRAINT `idLeague` FOREIGN KEY (`idLeague`) REFERENCES `league` (`idLeague`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE NBATEAM TABLE
CREATE TABLE `nbaTeam` (
  `idNbaTeam` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `logo` longblob NOT NULL,
  `division` varchar(45) NOT NULL,
  `conference` varchar(45) NOT NULL,
  PRIMARY KEY (`idNbaTeam`)
);

-- CREATE NBAPLAYER TABLE
CREATE TABLE `nbaPlayer` (
  `idNbaPlayer` int(11) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `position` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `photo` longblob,
  `idNbaTeam` int(11) NOT NULL,
  PRIMARY KEY (`idNbaPlayer`),
  KEY `idNbaTeam_idx` (`idNbaTeam`),
  CONSTRAINT `idNbaTeam` FOREIGN KEY (`idNbaTeam`) REFERENCES `nbaTeam` (`idNbaTeam`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE PLAYER TABLE
CREATE TABLE `player` (
  `idPlayer` int(11) NOT NULL,
  `scoring` float NOT NULL,
  `averageScoring` float DEFAULT NULL,
  `idTeam` int(11) NOT NULL,
  `idNbaPlayer` int(11) NOT NULL,
  PRIMARY KEY (`idPlayer`),
  KEY `idTeam_idx` (`idTeam`),
  KEY `idNbaPlayer_idx` (`idNbaPlayer`),
  CONSTRAINT `idNbaPlayer` FOREIGN KEY (`idNbaPlayer`) REFERENCES `nbaPlayer` (`idNbaPlayer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idTeam` FOREIGN KEY (`idTeam`) REFERENCES `team` (`idTeam`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE MATCH TABLE
CREATE TABLE `match` (
  `idMatch` int(11) NOT NULL,
  `place` varchar(45) DEFAULT NULL,
  `homeTeam` varchar(45) DEFAULT NULL,
  `visitingTeam` varchar(45) DEFAULT NULL,
  `dateHourMatch` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMatch`)
);
	
-- CREATE SCORING TABLE 
CREATE TABLE `scoring` (
  `idMatch` int(11) NOT NULL,
  `idPlayer` int(11) NOT NULL,
  `type` int(1) NOT NULL,
  `assists` int(2) DEFAULT NULL,
  `offRebounds` int(2) DEFAULT NULL,
  `defRebounds` int(2) DEFAULT NULL,
  `blocks` int(2) DEFAULT NULL,
  `steals` int(2) DEFAULT NULL,
  `freeThrows` int(2) DEFAULT NULL,
  `freeThrowMakes` int(2) DEFAULT NULL,
  `twoPointShots` int(2) DEFAULT NULL,
  `twoPointMakes` int(2) DEFAULT NULL,
  `threePointShots` int(2) DEFAULT NULL,
  `threePointMakes` int(2) DEFAULT NULL,
  `turnovers` int(2) DEFAULT NULL,
  `personalFoul` int(2) DEFAULT NULL,
  `technicalFoul` int(2) DEFAULT NULL,
  `teamWin` int(2) DEFAULT NULL,
  `teamLose` int(2) DEFAULT NULL,
  PRIMARY KEY (`idMatch`,`idPlayer`),
  KEY `matchId_idx` (`idMatch`),
  KEY `playerId_idx` (`idPlayer`),
  CONSTRAINT `matchId` FOREIGN KEY (`idMatch`) REFERENCES `match` (`idMatch`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `playerId` FOREIGN KEY (`idPlayer`) REFERENCES `player` (`idPlayer`) ON DELETE CASCADE ON UPDATE CASCADE
);  

-- CREATE FORUM TABLE
CREATE TABLE `forum` (
  `idForum` int(11) NOT NULL,
  `topic` varchar(45) NOT NULL,
  `posts` int(11) DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  `lastPost` datetime DEFAULT NULL,
  `forumcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idForum`)
);


-- CREATE postForum TABLE
CREATE TABLE `postForum` (
  `idUser` int(11) NOT NULL,
  `idForum` int(11) NOT NULL,
  `creationDate` date NOT NULL,
  PRIMARY KEY (`idUser`,`idForum`),
  KEY `idUser_idx` (`idUser`),
  KEY `forumId_idx` (`idForum`),
  CONSTRAINT `userId` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `forumId` FOREIGN KEY (`idForum`) REFERENCES `forum` (`idforum`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE POLL TABLE
CREATE TABLE `Poll` (
  `idPoll` int(11) NOT NULL,
  `numOption` int(11) NOT NULL,
  `descOption` varchar(45) NOT NULL,
  `posts` int(11) DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  `lastPost` datetime NOT NULL,
  PRIMARY KEY (`idPoll`)
);

-- CREATE postPoll TABLE
CREATE TABLE `postPoll` (
  `idUser` int(11) NOT NULL,
  `idPoll` int(11) NOT NULL,
  `creationDate` date NOT NULL,
  PRIMARY KEY (`idUser`,`idPoll`),
  KEY `idUser_idx` (`idUser`),
  KEY `pollId_idx` (`idPoll`),
  CONSTRAINT `userId2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pollId` FOREIGN KEY (`idPoll`) REFERENCES `Poll` (`idPoll`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE hibernate_sequence TABLE 
 CREATE  TABLE `hibernate_sequence` (
  `SEQ_NAME` VARCHAR(50) NOT NULL ,
  `NEXT_VAL` DECIMAL(38,0) NULL ,
  PRIMARY KEY (`SEQ_NAME`) );

INSERT INTO `hibernate_sequence` (`SEQ_NAME`, `NEXT_VAL`) VALUES ('SEQ_NAME', '0');