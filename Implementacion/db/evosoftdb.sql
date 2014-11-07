-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2014 at 03:38 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `evosoftdb`
--
CREATE DATABASE IF NOT EXISTS `evosoftdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `evosoftdb`;

-- --------------------------------------------------------

--
-- Table structure for table `chofer`
--

CREATE TABLE IF NOT EXISTS `chofer` (
  `idchofer` int(11) NOT NULL AUTO_INCREMENT,
  `idlicencia` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`idchofer`),
  KEY `fk_chofer_licencia_idx` (`idlicencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `licencia`
--

CREATE TABLE IF NOT EXISTS `licencia` (
  `idlicencia` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `categoria` varchar(8) DEFAULT NULL,
  `fechavencimiento` date DEFAULT NULL,
  PRIMARY KEY (`idlicencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehiculo`
--

CREATE TABLE IF NOT EXISTS `vehiculo` (
  `idvehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `idchofer` int(11) NOT NULL,
  `placa` varchar(6) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `cantidadEjes` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idvehiculo`),
  KEY `fk_vehiculo_chofer1_idx` (`idchofer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chofer`
--
ALTER TABLE `chofer`
  ADD CONSTRAINT `fk_chofer_licencia` FOREIGN KEY (`idlicencia`) REFERENCES `licencia` (`idlicencia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_vehiculo_chofer1` FOREIGN KEY (`idchofer`) REFERENCES `chofer` (`idchofer`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
