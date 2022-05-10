-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2022 a las 07:35:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `timesheet_dev`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id_asistencia` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_tipo_trabajo` int(11) NOT NULL,
  `id_ubicacion` int(11) NOT NULL,
  `id_dispositivo` int(11) NOT NULL,
  `hora_entrada` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_salida` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_long` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_lat` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_dia_festivo` tinyint(1) DEFAULT 0,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargos`
--

CREATE TABLE `cargos` (
  `id_cargo` int(11) NOT NULL,
  `nombre_cargo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_cargo` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `cargos`
--

INSERT INTO `cargos` (`id_cargo`, `nombre_cargo`, `codigo_cargo`, `flg_activo`, `creado_por`, `creado_fec`, `modificado_por`, `modificado_fec`) VALUES
(1, 'programador 2', '001', 1, 'admin', '2021-12-23 22:24:00', 'admin', '2021-12-23 22:38:50'),
(2, 'Diseñador', '002', 1, 'admin', '2021-12-23 22:39:18', 'admin', '2021-12-23 23:40:39'),
(3, 'Repartidor1', '002', 0, 'admin', '2021-12-23 23:23:04', 'admin', '2021-12-23 23:35:32'),
(4, 'sdfsfsfs', '003', 1, 'admin', '2021-12-23 23:39:38', 'admin', '2021-12-23 23:39:38'),
(5, 'Actualizado', '004', 1, 'admin', '2021-12-23 23:39:43', 'admin', '2022-01-02 20:33:26'),
(6, 'assdfsdf', '005', 1, 'admin', '2021-12-23 23:39:49', 'admin', '2021-12-23 23:39:49'),
(7, 'asdadasd', '006', 1, 'admin', '2021-12-23 23:39:55', 'admin', '2021-12-23 23:39:55'),
(8, 'asdafdasf', '007', 1, 'admin', '2021-12-23 23:40:01', 'admin', '2021-12-23 23:40:01'),
(9, 'sdafsfsf', '008', 1, 'admin', '2021-12-23 23:40:10', 'admin', '2021-12-23 23:40:45'),
(10, 'asdsadasfdAAA10', '009', 1, 'admin', '2021-12-23 23:40:16', 'admin', '2022-01-05 20:34:33'),
(11, 'asfadsfsdf', '010', 1, 'admin', '2021-12-23 23:40:22', 'admin', '2021-12-23 23:40:22'),
(12, 'asfsdfsdf', '011', 1, 'admin', '2021-12-23 23:40:28', 'admin', '2021-12-23 23:40:28'),
(13, 'Secretaria', '002', 1, 'admin', '2021-12-26 22:33:41', 'admin', '2021-12-26 22:33:41'),
(14, 'Gerente', '003', 1, 'admin', '2021-12-26 22:34:28', 'admin', '2021-12-26 22:34:28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias_festivos`
--

CREATE TABLE `dias_festivos` (
  `id_dia_festivo` int(11) NOT NULL,
  `nombre_dia_festivo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_dia_festivo` date DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivos`
--

CREATE TABLE `dispositivos` (
  `id_dispositivo` int(11) NOT NULL,
  `nombre_dispotivo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_dispositivo` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `serie` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  `codigo_empleado` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `foto` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id_horario` int(11) NOT NULL,
  `hora_inicio` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `hora_fin` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id_persona` int(11) NOT NULL,
  `tipo_documento` int(11) DEFAULT NULL,
  `numero_documento` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombres` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido_paterno` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido_materno` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `sexo` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_completo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre_rol`, `estado`) VALUES
(1, 'ADMIN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_trabajo`
--

CREATE TABLE `tipo_trabajo` (
  `id_tipo_trabajo` int(11) NOT NULL,
  `nombre_tipo_trabajo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `abreviatura` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `tipo_trabajo`
--

INSERT INTO `tipo_trabajo` (`id_tipo_trabajo`, `nombre_tipo_trabajo`, `abreviatura`, `flg_activo`, `creado_por`, `creado_fec`, `modificado_por`, `modificado_fec`) VALUES
(1, 'Remoto', 'RM', 1, 'admin', '2021-12-26 23:10:36', 'admin', '2021-12-26 23:10:36'),
(2, 'Presencial', 'PR', 1, 'admin', '2021-12-26 23:11:52', 'admin', '2021-12-26 23:11:52'),
(3, 'MIXTO', 'MX', 0, 'admin', '2022-01-05 20:33:56', 'admin', '2022-01-05 20:36:22'),
(4, 'Mixto', 'MX', 1, 'admin', '2022-01-05 20:34:06', 'admin', '2022-01-05 20:45:21'),
(5, 'MixtoS', 'MX', 0, 'admin', '2022-01-05 20:34:15', 'admin', '2022-01-05 20:36:20'),
(6, 'Presenciale', 'PR', 0, 'admin', '2022-01-05 20:36:12', 'admin', '2022-01-05 20:36:17'),
(7, 'Mixto', 'MX', 0, 'admin', '2022-01-05 20:44:59', 'admin', '2022-01-05 20:45:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `id_ubicacion` int(11) NOT NULL,
  `nombre_sede` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_long` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_lat` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT 1,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `area` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  `creado_por` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usuario`, `password`, `area`, `nombre`, `correo`, `estado`, `creado_por`, `creado_fec`, `modificado_por`, `modificado_fec`) VALUES
(1, 'admin', '$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK', 'rr.hh', 'Franklin Ruiz Asto Leon', 'franklin.asto.leon@gmail.com', 1, '1', '2021-10-17 18:14:02', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `id_usuario_rol` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `usuario_roles`
--

INSERT INTO `usuario_roles` (`id_usuario_rol`, `id_usuario`, `id_rol`, `estado`) VALUES
(1, 1, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_asistencia`) USING BTREE;

--
-- Indices de la tabla `cargos`
--
ALTER TABLE `cargos`
  ADD PRIMARY KEY (`id_cargo`) USING BTREE;

--
-- Indices de la tabla `dias_festivos`
--
ALTER TABLE `dias_festivos`
  ADD PRIMARY KEY (`id_dia_festivo`) USING BTREE;

--
-- Indices de la tabla `dispositivos`
--
ALTER TABLE `dispositivos`
  ADD PRIMARY KEY (`id_dispositivo`) USING BTREE;

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`) USING BTREE;

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id_horario`) USING BTREE;

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id_persona`) USING BTREE;

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`) USING BTREE;

--
-- Indices de la tabla `tipo_trabajo`
--
ALTER TABLE `tipo_trabajo`
  ADD PRIMARY KEY (`id_tipo_trabajo`) USING BTREE;

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`id_ubicacion`) USING BTREE;

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`) USING BTREE;

--
-- Indices de la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD PRIMARY KEY (`id_usuario_rol`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id_asistencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargos`
--
ALTER TABLE `cargos`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `dias_festivos`
--
ALTER TABLE `dias_festivos`
  MODIFY `id_dia_festivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dispositivos`
--
ALTER TABLE `dispositivos`
  MODIFY `id_dispositivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_trabajo`
--
ALTER TABLE `tipo_trabajo`
  MODIFY `id_tipo_trabajo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  MODIFY `id_ubicacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  MODIFY `id_usuario_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
