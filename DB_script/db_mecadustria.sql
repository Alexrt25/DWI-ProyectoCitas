-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2022 a las 19:20:47
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_mecadustria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesor`
--

CREATE TABLE `asesor` (
  `IdAsesor` int(11) NOT NULL,
  `DocumentoIdentidad` int(8) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `IdUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asesor`
--

INSERT INTO `asesor` (`IdAsesor`, `DocumentoIdentidad`, `Telefono`, `IdUsuario`) VALUES
(1, 72206529, 999777001, 2),
(2, 43510378, 999777002, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `IdCita` int(11) NOT NULL,
  `FechaCreacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `IdCliente` int(11) NOT NULL,
  `IdAsesor` int(11) NOT NULL,
  `Inicio` timestamp NOT NULL DEFAULT current_timestamp(),
  `FinEsperado` timestamp NOT NULL DEFAULT current_timestamp(),
  `Fin` timestamp NULL DEFAULT NULL,
  `EnlaceMeet` varchar(255) NOT NULL,
  `IdEstadoCita` int(11) NOT NULL,
  `IdMotivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL,
  `DocumentoIdentidad` int(8) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `RazonSocial` varchar(128) NOT NULL,
  `RUC` varchar(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `DocumentoIdentidad`, `Telefono`, `RazonSocial`, `RUC`, `IdUsuario`) VALUES
(1, 47269995, 999888001, 'RAMOS YOVERA JOHN HENRY', '10472699950', 4),
(2, 41095847, 999888002, 'ZANELLI LOPEZ MARIA VICTORIA', '10435545144', 5),
(3, 41639627, 999888003, 'VISTA GOLD S.A.C.', '20554057862', 6),
(4, 42942586, 999888004, 'MAQUINARIAS AGRICOLAS PERUANAS S.A.C.', '20601605067', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cita`
--

CREATE TABLE `estado_cita` (
  `IdEstadoCita` int(11) NOT NULL,
  `EstadoCita` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario_asesor`
--

CREATE TABLE `horario_asesor` (
  `IdHorarioAsesor` int(11) NOT NULL,
  `IdAsesor` int(11) NOT NULL,
  `Inicio` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Fin` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motivo`
--

CREATE TABLE `motivo` (
  `IdMotivo` int(11) NOT NULL,
  `DescripcionMotivo` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_usuario`
--

CREATE TABLE `perfil_usuario` (
  `IdPerfil` int(11) NOT NULL,
  `NombrePerfil` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `perfil_usuario`
--

INSERT INTO `perfil_usuario` (`IdPerfil`, `NombrePerfil`) VALUES
(1, 'Administrador'),
(2, 'Asesor'),
(3, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(128) NOT NULL,
  `Correo` varchar(128) NOT NULL,
  `Contrasenia` varchar(128) NOT NULL,
  `EstadoUsuario` int(11) NOT NULL,
  `IdPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `Nombre`, `Correo`, `Contrasenia`, `EstadoUsuario`, `IdPerfil`) VALUES
(1, 'Administrador Mecadustria', 'citas@mecadustria.com', '123456', 1, 1),
(2, 'Abel Delgado', 'asesor1@mecadustria.com', '123456', 1, 2),
(3, 'Juan Carlos Avellaneda', 'asesor2@mecadustria.com', '123456', 1, 2),
(4, 'John Ramos', 'cliente1@test.com', '123456', 1, 3),
(5, 'Juan Silva', 'cliente2@test.com', '123456', 1, 3),
(6, 'Carlos Ramos Espino', 'cliente3@test.com', '123456', 1, 3),
(7, 'Raúl Alvarado', 'cliente4@test.com', '123456', 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asesor`
--
ALTER TABLE `asesor`
  ADD PRIMARY KEY (`IdAsesor`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`IdCita`),
  ADD KEY `IdCliente` (`IdCliente`,`IdAsesor`,`IdEstadoCita`),
  ADD KEY `IdAsesor` (`IdAsesor`),
  ADD KEY `IdMotivo` (`IdMotivo`),
  ADD KEY `IdEstadoCita` (`IdEstadoCita`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `estado_cita`
--
ALTER TABLE `estado_cita`
  ADD PRIMARY KEY (`IdEstadoCita`);

--
-- Indices de la tabla `horario_asesor`
--
ALTER TABLE `horario_asesor`
  ADD PRIMARY KEY (`IdHorarioAsesor`),
  ADD KEY `IdAsesor` (`IdAsesor`);

--
-- Indices de la tabla `motivo`
--
ALTER TABLE `motivo`
  ADD PRIMARY KEY (`IdMotivo`);

--
-- Indices de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  ADD PRIMARY KEY (`IdPerfil`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD KEY `IdPerfil` (`IdPerfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asesor`
--
ALTER TABLE `asesor`
  MODIFY `IdAsesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `IdCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `estado_cita`
--
ALTER TABLE `estado_cita`
  MODIFY `IdEstadoCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horario_asesor`
--
ALTER TABLE `horario_asesor`
  MODIFY `IdHorarioAsesor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `motivo`
--
ALTER TABLE `motivo`
  MODIFY `IdMotivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  MODIFY `IdPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesor`
--
ALTER TABLE `asesor`
  ADD CONSTRAINT `asesor_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`);

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`),
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`IdAsesor`) REFERENCES `asesor` (`IdAsesor`),
  ADD CONSTRAINT `cita_ibfk_4` FOREIGN KEY (`IdMotivo`) REFERENCES `motivo` (`IdMotivo`),
  ADD CONSTRAINT `cita_ibfk_5` FOREIGN KEY (`IdEstadoCita`) REFERENCES `estado_cita` (`IdEstadoCita`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`);

--
-- Filtros para la tabla `horario_asesor`
--
ALTER TABLE `horario_asesor`
  ADD CONSTRAINT `horario_asesor_ibfk_1` FOREIGN KEY (`IdAsesor`) REFERENCES `asesor` (`IdAsesor`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IdPerfil`) REFERENCES `perfil_usuario` (`IdPerfil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
