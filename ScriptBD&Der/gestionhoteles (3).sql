-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-10-2021 a las 23:41:23
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionhoteles`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `pEliminarEmpleado` (IN `id` INT)  BEGIN
	DELETE FROM templeado WHERE `idEmpleado` = id;
    DELETE FROM tusuario WHERE `usuario` = (SELECT usuario FROM templeado where idEmpleado = id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pInsertarCliente` (IN `nombre` VARCHAR(20), IN `apellidos` VARCHAR(30), IN `DNI` VARCHAR(15), IN `fechaNac` DATE, IN `imagen` VARCHAR(100), IN `usuario` VARCHAR(30), IN `contraseña` VARCHAR(30), IN `rol` VARCHAR(15))  BEGIN

			INSERT INTO `tusuario`(`usuario`, `contraseña`, `rol`) VALUES (usuario,contraseña,rol);
			INSERT INTO `tcliente`(`nombre`, `apellidos`, `DNI`, `fechaNac`, `imagen`,`usuario`) VALUES 
(nombre,apellidos,DNI,fechaNac,imagen,usuario);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pInsertarEmpleado` (IN `nombre` VARCHAR(20), IN `apellidos` VARCHAR(30), IN `DNI` VARCHAR(15), IN `fechaNac` DATE, IN `poblacion` VARCHAR(30), IN `idHotel` INT, IN `usuario` VARCHAR(30), IN `contraseña` VARCHAR(30), IN `rol` VARCHAR(15))  BEGIN
			INSERT INTO `tusuario`(`usuario`, `contraseña`, `rol`) VALUES (usuario,contraseña,rol);
			INSERT INTO `templeado`(`nombre`, `apellidos`, `DNI`, `fechaNac`, `poblacion`,`idHotel`,`usuario`) VALUES (nombre,apellidos,DNI,fechaNac,poblacion,idHotel,usuario);

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcliente`
--

CREATE TABLE `tcliente` (
  `IdCliente` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `fechaNac` date NOT NULL,
  `imagen` varchar(100) NOT NULL,
  `usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tcliente`
--

INSERT INTO `tcliente` (`IdCliente`, `nombre`, `apellidos`, `DNI`, `fechaNac`, `imagen`, `usuario`) VALUES
(1, 'Cristian', 'Atienza Gonzalez', '77172528F', '2021-09-19', 'URL:jejeje', 'cris94'),
(2, 'jose', 'morales Gonzalez', '66282752E', '1994-03-12', 'URL:jejeje', 'jose24'),
(3, 'Jose', 'Rodriguez', '66182424L', '1994-01-01', 'url:jejeje', 'Jose22'),
(4, 'JAvier', 'Lope', '882828282E', '2021-09-09', 'URL:jejeje', 'JAVI1234'),
(5, 'Arturo', 'CalleAlta', '88225599P', '2021-09-16', 'URL:jejeje', 'ARS12'),
(6, 'Jose Manuel', 'Lopera', '827282727P', '2021-09-02', 'URL:jejeje', 'jm24'),
(7, 'Ricardo', 'Tormo', '699827535F', '2021-09-12', 'URL:jejeje', 'rt24'),
(8, 'Manuel', 'Lopez Rojo', '728628592F', '2021-09-14', 'URL:jejeje', 'ml24'),
(9, 'Lolo', 'Martín', '6282826285F', '2021-09-15', 'URL:jejeje', 'lm24'),
(10, 'Pepe', 'Moral', '872857628F', '2021-09-16', 'URL:jejeje', 'pm24'),
(11, 'Rodrigo', 'Fuentes', '682752524P', '2021-09-10', 'URL:jejeje', 'rf24'),
(12, 'Rosa', 'Perez', '82628524P', '2021-09-15', 'URL:jejeje', 'rp24'),
(13, 'Lola', 'Martin', '802856385R', '2021-09-23', 'URL:jejeje', 'lm25'),
(14, 'Pepa', 'Martin', '82828282F', '2021-09-22', 'URL:jejeje', 'pm25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `templeado`
--

CREATE TABLE `templeado` (
  `idEmpleado` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `fechaNac` date NOT NULL,
  `poblacion` varchar(30) NOT NULL,
  `idHotel` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `templeado`
--

INSERT INTO `templeado` (`idEmpleado`, `nombre`, `apellidos`, `DNI`, `fechaNac`, `poblacion`, `idHotel`, `usuario`) VALUES
(1, 'Pepito', 'Grillo', '66207263E', '1994-02-02', 'Cádiz', 1, 'Pepito24'),
(5, 'Manuel', 'Obrador', '82929236P', '2021-09-16', 'Jaén', 2, 'mo24');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `thabitacion`
--

CREATE TABLE `thabitacion` (
  `idHotel` int(11) NOT NULL,
  `numHabitacion` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `precioNoche` double NOT NULL,
  `extras` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `thabitacion`
--

INSERT INTO `thabitacion` (`idHotel`, `numHabitacion`, `tipo`, `precioNoche`, `extras`) VALUES
(1, 1, 'Suite Luxury', 120, 'Terraza'),
(1, 2, 'Apartamento', 45, 'Balcón con vistas a la ciudad'),
(2, 3, 'Suite', 95, 'Terraza con vistas'),
(2, 4, 'Apartamento', 45, 'Balcón con vistas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `thotel`
--

CREATE TABLE `thotel` (
  `idHotel` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `descripcion` text NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `thotel`
--

INSERT INTO `thotel` (`idHotel`, `nombre`, `ciudad`, `descripcion`, `direccion`, `telefono`) VALUES
(1, 'Royal Paradise', 'Conil', 'Resort paradisíaco en primera línea de playa', 'Calle los olivos 7', '628272612'),
(2, 'Hotel Barceló', 'Cádiz', 'Lujoso hotel en el centro de la ciudad', 'Calle ancha 7', '611272612'),
(3, 'RoofTop', 'Sevilla', 'Rascacielos moderno', 'Calle Manuel Lopez', '622334455');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `treserva`
--

CREATE TABLE `treserva` (
  `idReserva` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `numHabitacion` int(11) NOT NULL,
  `idHotel` int(11) NOT NULL,
  `fechaIni` date NOT NULL,
  `fechaFin` date NOT NULL,
  `fechaReserva` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `treserva`
--

INSERT INTO `treserva` (`idReserva`, `IdCliente`, `numHabitacion`, `idHotel`, `fechaIni`, `fechaFin`, `fechaReserva`) VALUES
(14, 1, 1, 1, '2021-10-15', '2021-10-16', '2021-10-16 01:32:00'),
(17, 7, 2, 1, '2021-10-15', '2021-10-16', '2021-10-18 10:54:00'),
(21, 1, 3, 2, '2021-10-16', '2021-10-17', '2021-10-18 11:28:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tusuario`
--

CREATE TABLE `tusuario` (
  `usuario` varchar(30) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `rol` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tusuario`
--

INSERT INTO `tusuario` (`usuario`, `contraseña`, `rol`) VALUES
('admin', 'admin', 'admin'),
('ARS12', '1234', 'cliente'),
('cris94', '1234', 'cliente'),
('JAVI1234', '1234', 'cliente'),
('jm24', '1234', 'cliente'),
('Jose22', '1234', 'cliente'),
('jose24', '1234', 'cliente'),
('lm24', '1234', 'cliente'),
('lm25', '1234', 'cliente'),
('ml24', '1234', 'cliente'),
('mo24', '1234', 'empleado'),
('Pepito24', '1234', 'empleado'),
('pm24', '1234', 'cliente'),
('pm25', '1234', 'cliente'),
('rf24', '1234', 'cliente'),
('rp24', '1234', 'cliente'),
('rt24', '1234', 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tvaloracion`
--

CREATE TABLE `tvaloracion` (
  `idReserva` int(11) NOT NULL,
  `comentario` text NOT NULL,
  `valoracion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tvaloracion`
--

INSERT INTO `tvaloracion` (`idReserva`, `comentario`, `valoracion`) VALUES
(14, 'Muy bonito', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tcliente`
--
ALTER TABLE `tcliente`
  ADD PRIMARY KEY (`IdCliente`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `templeado`
--
ALTER TABLE `templeado`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD KEY `idHotel` (`idHotel`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `thabitacion`
--
ALTER TABLE `thabitacion`
  ADD PRIMARY KEY (`idHotel`,`numHabitacion`),
  ADD KEY `numHabitacion` (`numHabitacion`);

--
-- Indices de la tabla `thotel`
--
ALTER TABLE `thotel`
  ADD PRIMARY KEY (`idHotel`);

--
-- Indices de la tabla `treserva`
--
ALTER TABLE `treserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `numHabitacion` (`numHabitacion`),
  ADD KEY `idHotel` (`idHotel`),
  ADD KEY `idCliente` (`IdCliente`) USING BTREE;

--
-- Indices de la tabla `tusuario`
--
ALTER TABLE `tusuario`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `tvaloracion`
--
ALTER TABLE `tvaloracion`
  ADD KEY `idReserva` (`idReserva`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tcliente`
--
ALTER TABLE `tcliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `templeado`
--
ALTER TABLE `templeado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `thabitacion`
--
ALTER TABLE `thabitacion`
  MODIFY `numHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `thotel`
--
ALTER TABLE `thotel`
  MODIFY `idHotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `treserva`
--
ALTER TABLE `treserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tcliente`
--
ALTER TABLE `tcliente`
  ADD CONSTRAINT `tcliente_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `tusuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `templeado`
--
ALTER TABLE `templeado`
  ADD CONSTRAINT `templeado_ibfk_2` FOREIGN KEY (`usuario`) REFERENCES `tusuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `templeado_ibfk_3` FOREIGN KEY (`idHotel`) REFERENCES `thotel` (`idHotel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `treserva`
--
ALTER TABLE `treserva`
  ADD CONSTRAINT `treserva_ibfk_6` FOREIGN KEY (`IdCliente`) REFERENCES `tcliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `treserva_ibfk_7` FOREIGN KEY (`numHabitacion`) REFERENCES `thabitacion` (`numHabitacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `treserva_ibfk_8` FOREIGN KEY (`idHotel`) REFERENCES `thotel` (`idHotel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tvaloracion`
--
ALTER TABLE `tvaloracion`
  ADD CONSTRAINT `tvaloracion_ibfk_1` FOREIGN KEY (`idReserva`) REFERENCES `treserva` (`idReserva`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
