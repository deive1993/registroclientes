-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2017 a las 02:14:55
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `satipo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cod_cli` int(3) NOT NULL,
  `nom_cli` varchar(30) NOT NULL,
  `ape_cli` varchar(30) NOT NULL,
  `ciu_cli` varchar(30) NOT NULL,
  `tel_cli` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cod_cli`, `nom_cli`, `ape_cli`, `ciu_cli`, `tel_cli`) VALUES
(1, 'deivis', 'guerra', 'floresta', '1128358758'),
(1, 'david', 'guerr', 'flores', '124578'),
(1, 'david', 'guerr', 'flores', '124578'),
(1, 'david', 'guerr', 'flores', '124578'),
(2, 'dei', 'nina', 'flores', '455214'),
(2, 'dei', 'nina', 'flores', '455214'),
(4, 'yenny', 'lijarza porto', 'caba', '11235878');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
