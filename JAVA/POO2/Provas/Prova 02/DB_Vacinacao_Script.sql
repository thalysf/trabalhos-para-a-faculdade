-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vacinacao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vacinacao` ;

-- -----------------------------------------------------
-- Schema vacinacao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vacinacao` DEFAULT CHARACTER SET utf8 ;
USE `vacinacao` ;

-- -----------------------------------------------------
-- Table `vacinacao`.`TipoVacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinacao`.`TipoVacina` ;

CREATE TABLE IF NOT EXISTS `vacinacao`.`TipoVacina` (
  `idTipoVacina` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idTipoVacina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacinacao`.`Vacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinacao`.`Vacina` ;

CREATE TABLE IF NOT EXISTS `vacinacao`.`Vacina` (
  `idVacina` INT NOT NULL AUTO_INCREMENT,
  `nomeVacina` VARCHAR(255) NULL,
  `qtdeDoses` INT NULL,
  `idTipoVacina` INT NOT NULL,
  PRIMARY KEY (`idVacina`),
  INDEX `fk_Vacina_TipoVacina_idx` (`idTipoVacina` ASC),
  CONSTRAINT `fk_Vacina_TipoVacina`
    FOREIGN KEY (`idTipoVacina`)
    REFERENCES `vacinacao`.`TipoVacina` (`idTipoVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacinacao`.`Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinacao`.`Paciente` ;

CREATE TABLE IF NOT EXISTS `vacinacao`.`Paciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `nomePaciente` VARCHAR(255) NULL,
  `cpf` VARCHAR(14) NULL,
  `dtDose1` DATE NULL,
  `dtDose2` DATE NULL,
  `precisaDose2` INT NULL,
  `idVacina` INT NOT NULL,
  PRIMARY KEY (`idPaciente`),
  INDEX `fk_Paciente_Vacina1_idx` (`idVacina` ASC),
  CONSTRAINT `fk_Paciente_Vacina1`
    FOREIGN KEY (`idVacina`)
    REFERENCES `vacinacao`.`Vacina` (`idVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `vacinacao`.`TipoVacina`
-- -----------------------------------------------------
START TRANSACTION;
USE `vacinacao`;
INSERT INTO `vacinacao`.`TipoVacina` (`idTipoVacina`, `descricao`) VALUES (1, 'COVID');
INSERT INTO `vacinacao`.`TipoVacina` (`idTipoVacina`, `descricao`) VALUES (2, 'Outras');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vacinacao`.`Vacina`
-- -----------------------------------------------------
START TRANSACTION;
USE `vacinacao`;
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (1, 'CoronaVac', 2, 1);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (2, 'AstraZeneca', 2, 1);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (3, 'Pfizer', 2, 1);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (4, 'BCG', 1, 2);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (5, 'Gripe', 1, 2);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (6, 'Polio', 1, 2);
INSERT INTO `vacinacao`.`Vacina` (`idVacina`, `nomeVacina`, `qtdeDoses`, `idTipoVacina`) VALUES (7, 'Sarampo', 1, 2);

COMMIT;

