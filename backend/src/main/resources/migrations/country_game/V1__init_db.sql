SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
    'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `country`
(
  `countryId`      INT         NOT NULL AUTO_INCREMENT,
  `countryName`    VARCHAR(45) NOT NULL,
  `countryDetails` VARCHAR(45) NULL,
  `countryCode`    VARCHAR(2)  NOT NULL,
  `currencyId`     INT         NOT NULL,
  PRIMARY KEY (`countryId`),
  CONSTRAINT `currencyId`
    FOREIGN KEY (`currencyId`)
      REFERENCES `currency` (`currencyId`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `currency`
(
  `currencyId`   INT         NOT NULL AUTO_INCREMENT,
  `currencyName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`currencyId`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `relations`
(
  `relationId`   INT NOT NULL AUTO_INCREMENT,
  `countryId1`   INT NOT NULL,
  `countryId2`   INT NOT NULL,
  `relationType` INT NOT NULL,
  PRIMARY KEY (`relationId`),
  INDEX `country1_UNIQUE` (`countryId1` ASC),
  INDEX `relationTypeId_idx` (`relationType` ASC),
  CONSTRAINT `countryId1`
    FOREIGN KEY (`countryId1`)
      REFERENCES `country` (`countryId`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `countryId2`
    FOREIGN KEY (`countryId2`)
      REFERENCES `country` (`countryId`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

USE `country_game`;

INSERT INTO `currency` (currencyName) VALUES ('Franken');
INSERT INTO `currency` (currencyName) VALUES ('Euro');
INSERT INTO `currency` (currencyName) VALUES ('Dollar');
INSERT INTO `currency` (currencyName) VALUES ('Yen');

INSERT INTO `country` (countryName, countryDetails, countryCode, currencyId) VALUES ('Switzerland', 'Cheese', 'CH', 1);
INSERT INTO `country` (countryName, countryDetails, countryCode, currencyId) VALUES ('Germany', 'Bratwurst', 'DE', 2);
INSERT INTO `country` (countryName, countryDetails, countryCode, currencyId) VALUES ('France', 'Baguette', 'FR', 2);
INSERT INTO `country` (countryName, countryDetails, countryCode, currencyId) VALUES ('USA', 'Guns', 'US', 3);
INSERT INTO `country` (countryName, countryDetails, countryCode, currencyId) VALUES ('Italy', 'Pizza', 'IT', 2);
