-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2023 a las 02:54:08
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdmundosalud`
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
(2, 43510378, 999777002, 3),
(3, 22504612, 937500061, 12),
(4, 42915457, 937500061, 13),
(5, 41125784, 994545453, 14),
(6, 10253215, 937500061, 15),
(7, 46523012, 963523120, 23),
(8, 45201201, 965652388, 25),
(9, 45445897, 987876500, 28),
(10, 45654345, 45434567, 29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `IdCita` int(11) NOT NULL,
  `FechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `IdCliente` int(11) NOT NULL,
  `IdAsesor` int(11) NOT NULL,
  `Inicio` date NOT NULL,
  `EnlaceMeet` varchar(255) NOT NULL,
  `IdEstadoCita` int(11) NOT NULL,
  `IdMotivo` int(11) NOT NULL,
  `IdRango` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`IdCita`, `FechaCreacion`, `IdCliente`, `IdAsesor`, `Inicio`, `EnlaceMeet`, `IdEstadoCita`, `IdMotivo`, `IdRango`) VALUES
(7, '2023-06-26 23:56:57', 1, 10, '2022-12-16', '', 1, 2, 3),
(8, '2023-06-27 00:37:52', 1, 1, '2022-12-17', '', 3, 2, 5),
(9, '2022-12-15 12:20:32', 1, 2, '2022-12-16', ' ', 1, 2, 3),
(10, '2022-12-15 22:41:18', 1, 1, '2022-12-21', ' ', 1, 2, 3),
(11, '2022-12-15 20:45:14', 1, 2, '2022-12-16', ' ', 1, 2, 4),
(12, '2022-12-15 22:33:53', 1, 2, '2022-12-16', ' ', 1, 2, 3),
(13, '2022-12-15 22:34:35', 2, 2, '2022-12-16', ' ', 1, 2, 2),
(14, '2023-06-26 23:45:41', 19, 10, '2023-06-19', '', 1, 1, 1);

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
(4, 42942586, 999888004, 'MAQUINARIAS AGRICOLAS PERUANAS S.A.C.', '20601605067', 7),
(5, 10452512, 987987123, 'INVERCE S.A.C.', '20521016893', 8),
(6, 42952522, 974747123, 'ACEROS Y PERFILES PERUANOS S.A.C.', '20604735042', 9),
(7, 15224848, 999576255, 'FERRETERIA EL SOL S.R.LTDA', '20298481902', 11),
(8, 42338164, 959522789, 'CORPORACION LA SIRENA SAC', '20100157315', 16),
(10, 42914454, 937500061, 'M. ELECTRO S.A.', '20100054001', 19),
(11, 47736164, 987580266, 'RUMI IMPORT S.A.', '20170717261', 20),
(12, 47844770, 956253254, 'EMP ABCD', '20124541012', 21),
(13, 47985003, 965102145, 'EMPRESA UNO MIL', '20125478451', 22),
(14, 47854541, 965230145, 'mflores@gmail.com', '201454120', 24),
(15, 46576765, 987876567, 'EMP DORADO', '20988765654', 26),
(16, 45456765, 987876565, 'EMP AZULES AB', '23454345678', 27),
(17, 45689856, 956587451, 'TRANSP ROJO SAC', '20214587454', 30),
(18, 45487845, 958745451, 'AV LAS PALMERAS', '2021454101', 31),
(19, 72545811, 945112505, 'UTP', '2021454108', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cita`
--

CREATE TABLE `estado_cita` (
  `IdEstadoCita` int(11) NOT NULL,
  `EstadoCita` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado_cita`
--

INSERT INTO `estado_cita` (`IdEstadoCita`, `EstadoCita`) VALUES
(1, 'PENDIENTE'),
(2, 'APROBADO'),
(3, 'RECHAZADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario_asesor`
--

CREATE TABLE `horario_asesor` (
  `IdHorarioAsesor` int(11) NOT NULL,
  `IdAsesor` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `idRangoH` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motivo`
--

CREATE TABLE `motivo` (
  `IdMotivo` int(11) NOT NULL,
  `DescripcionMotivo` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `motivo`
--

INSERT INTO `motivo` (`IdMotivo`, `DescripcionMotivo`) VALUES
(1, 'CONSULTA MEDICA'),
(2, 'ATENCION HOSPITALARIA'),
(3, 'MATERNIDAD'),
(4, 'EMERGENCIA');

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
-- Estructura de tabla para la tabla `rango_horario`
--

CREATE TABLE `rango_horario` (
  `idRango` int(11) NOT NULL,
  `HoraRango` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `rango_horario`
--

INSERT INTO `rango_horario` (`idRango`, `HoraRango`) VALUES
(1, '9 AM - 10 AM'),
(2, '10 AM - 11 AM'),
(3, '11 AM - 12 AM'),
(4, '12 AM - 1 PM'),
(5, '2 PM - 3 PM'),
(6, '3 PM - 4 PM'),
(7, '4 PM - 5 PM');

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
(1, 'Administrador MundoSalud', 'citas@mundosalud.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),
(2, 'Abel Delgado Meza', 'medico1@mundosalud.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 2),
(3, 'Juan Carlos Avellaneda', 'medico2@mundosalud.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 2),
(4, 'John Ramos', 'cliente1@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(5, 'Juan Silva', 'cliente2@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(6, 'Carlos Ramos Espino', 'cliente3@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(7, 'RaÃºl Alvarado', 'cliente4@test.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 3),
(8, 'Mirtha Vasquez', 'cliente5@test.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 3),
(9, 'Carlos Vargas', 'cliente6@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(10, 'Luis Orihuela', 'cliente7@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(11, 'Toribio Cardenas', 'cliente8@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(12, 'Juan Castillo', 'cliente9@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(13, 'Rody Fernandez', 'medico3@mundosalud.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 2),
(14, 'Magaly Puicon', 'cliente10@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(15, 'Jorge Yarango', 'medico4@mundosalud.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 2),
(16, 'Andres Diaz', 'cliente11@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(19, 'Claudia Canales', 'cliente12@test.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(20, 'Luis Silva', 'cliente13@test.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 3),
(21, 'Maria Santos', 'msantos@empresaabc.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(22, 'Alfredo Torres', 'atorres@empresauno.com', '3f516704ce6761cca2fd597618a0ae94', 1, 3),
(23, 'Raul Rios', 'rrios@empresaups.com', '828fe77118e58ff9db0613907f5eff1f', 0, 2),
(24, 'Mariana Flores', 'mflores@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(25, 'Karla Torres Vega', 'ktorres@mundosalud.com', '031aefee2c1971c8b163b34332ddefe5', 0, 2),
(26, 'Ana Fuentes', 'afuentes@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(27, 'Mario Torres', 'mtorres@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 3),
(28, 'Fernanda Flores', 'fflores@gmail.com', '0f98ed1b5afcf337381d8f6c51496075', 0, 2),
(29, 'Maria Vega', 'mvega@gmail.com', '6097182a841274e944cf61b9e81b2545', 0, 2),
(30, 'Jose Marquez', 'jmarquez@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),
(31, 'Pilar Torres', 'limerino@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3),
(32, 'Javier Perez', 'javier@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 3);

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
  ADD KEY `IdEstadoCita` (`IdEstadoCita`),
  ADD KEY `idRango` (`IdRango`);

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
-- Indices de la tabla `rango_horario`
--
ALTER TABLE `rango_horario`
  ADD PRIMARY KEY (`idRango`);

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
  MODIFY `IdAsesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `IdCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `estado_cita`
--
ALTER TABLE `estado_cita`
  MODIFY `IdEstadoCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `horario_asesor`
--
ALTER TABLE `horario_asesor`
  MODIFY `IdHorarioAsesor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `motivo`
--
ALTER TABLE `motivo`
  MODIFY `IdMotivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  MODIFY `IdPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rango_horario`
--
ALTER TABLE `rango_horario`
  MODIFY `idRango` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

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
  ADD CONSTRAINT `cita_ibfk_5` FOREIGN KEY (`IdEstadoCita`) REFERENCES `estado_cita` (`IdEstadoCita`),
  ADD CONSTRAINT `cita_ibfk_6` FOREIGN KEY (`IdRango`) REFERENCES `rango_horario` (`idRango`);

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
