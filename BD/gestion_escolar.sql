-- phpMyAdmin SQL Dump
-- version 4.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-05-2015 a las 20:12:13
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.5.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestion_escolar`
--
CREATE DATABASE IF NOT EXISTS `gestion_escolar` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestion_escolar`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_role`
--

CREATE TABLE IF NOT EXISTS `bdv_role` (
  `id_role` int(11) NOT NULL,
  `role_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `bdv_role`
--

TRUNCATE TABLE `bdv_role`;
--
-- Volcado de datos para la tabla `bdv_role`
--

INSERT INTO `bdv_role` (`id_role`, `role_nombre`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'EDITOR'),
(3, 'CONSULTOR'),
(4, 'USUARIO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user_backend`
--

CREATE TABLE IF NOT EXISTS `bdv_user_backend` (
  `id_user` int(11) NOT NULL,
  `userBackend` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `bdv_user_backend`
--

TRUNCATE TABLE `bdv_user_backend`;
--
-- Volcado de datos para la tabla `bdv_user_backend`
--

INSERT INTO `bdv_user_backend` (`id_user`, `userBackend`, `contrasenia`, `activo`) VALUES
(1, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user_roles`
--

CREATE TABLE IF NOT EXISTS `bdv_user_roles` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `bdv_user_roles`
--

TRUNCATE TABLE `bdv_user_roles`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_autorizado`
--

CREATE TABLE IF NOT EXISTS `tbl_autorizado` (
  `id_autorizado` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `apellido` varchar(150) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `id_parentesco` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_autorizado`
--

TRUNCATE TABLE `tbl_autorizado`;
--
-- Volcado de datos para la tabla `tbl_autorizado`
--

INSERT INTO `tbl_autorizado` (`id_autorizado`, `nombre`, `apellido`, `foto`, `id_parentesco`) VALUES
(11, 'MARIA', 'LOPEZ', '1_OsaPanda2.jpg', 5),
(12, 'J', 'J', 'none.jpg', 5),
(13, 'G', 'G', '1_cedula sarah0001.jpg', 6),
(14, '', '', 'none.jpg', NULL),
(15, '', '', 'none.jpg', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cursos`
--

CREATE TABLE IF NOT EXISTS `tbl_cursos` (
  `id_curso` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_cursos`
--

TRUNCATE TABLE `tbl_cursos`;
--
-- Volcado de datos para la tabla `tbl_cursos`
--

INSERT INTO `tbl_cursos` (`id_curso`, `nombre`, `precio`) VALUES
(1, 'BALETT', '1000'),
(3, 'COMPUTACION', '1000'),
(4, 'KARATE', '1200'),
(5, 'LECTOESCRITURA', '1000'),
(6, 'MANUALIDADES', '1500'),
(7, 'PSICOMOTROCIDAD', '1300');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante`
--

CREATE TABLE IF NOT EXISTS `tbl_estudiante` (
  `id_estudiante` int(11) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `lugar_nac` varchar(100) NOT NULL,
  `fech_nac` date NOT NULL,
  `edad` int(2) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `vacunas` varchar(100) NOT NULL,
  `peso` int(2) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `id_representante_m` int(11) NOT NULL,
  `id_representante_p` int(11) NOT NULL,
  `id_autorizado` int(11) NOT NULL,
  `id_medicamentos` int(11) NOT NULL,
  `id_nivel` int(11) NOT NULL,
  `fech_registro` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_estudiante`
--

TRUNCATE TABLE `tbl_estudiante`;
--
-- Volcado de datos para la tabla `tbl_estudiante`
--

INSERT INTO `tbl_estudiante` (`id_estudiante`, `foto`, `apellidos`, `nombres`, `lugar_nac`, `fech_nac`, `edad`, `sexo`, `vacunas`, `peso`, `status`, `id_representante_m`, `id_representante_p`, `id_autorizado`, `id_medicamentos`, `id_nivel`, `fech_registro`) VALUES
(1, '3_Osa.jpg', 'PEREZ', 'GEORGE', 'LA GUAIRA', '1988-12-27', 26, 'MASCULINO', 'NINGUNA', 10, 0, 24, 23, 12, 12, 2, '2015-04-30 04:36:46'),
(2, '0_cedulaGeorge.JPG', 'RAMIREZ', 'PEDRO', 'LA GUAIRA', '2000-12-12', 14, 'MASCULINO', 'NINGUNA', 10, 1, 26, 25, 13, 13, 2, '2015-05-01 16:05:22'),
(3, 'none.jpg', '2', '2', '2', '1988-12-12', 1, 'MASCULINO', 'NINGUNA', 10, 0, 28, 27, 14, 14, 2, '2015-05-02 15:02:15'),
(4, 'none.jpg', '3', '3', '3', '1988-12-12', 12, 'FEMENINO', 'NINGUNA', 10, 1, 30, 29, 15, 15, 2, '2015-05-02 15:04:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante_cursos`
--

CREATE TABLE IF NOT EXISTS `tbl_estudiante_cursos` (
  `id_estudiante` int(11) NOT NULL,
  `id_cursos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_estudiante_cursos`
--

TRUNCATE TABLE `tbl_estudiante_cursos`;
--
-- Volcado de datos para la tabla `tbl_estudiante_cursos`
--

INSERT INTO `tbl_estudiante_cursos` (`id_estudiante`, `id_cursos`) VALUES
(1, 1),
(1, 3),
(1, 4),
(2, 1),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_medicamentos`
--

CREATE TABLE IF NOT EXISTS `tbl_medicamentos` (
  `id_medicamentos` int(11) NOT NULL,
  `medicar_fiebre` varchar(250) NOT NULL,
  `cant_suspencion_fiebre` int(2) DEFAULT NULL,
  `cant_gota_fiebre` int(2) DEFAULT NULL,
  `cant_jarabe_fiebre` int(2) DEFAULT NULL,
  `cant_supositorio_fiebre` int(2) DEFAULT NULL,
  `periodo_fiebre` int(2) DEFAULT NULL,
  `observacion_fiebre` varchar(250) DEFAULT NULL,
  `alergico_picadas` varchar(2) NOT NULL,
  `medicar_picadas` varchar(250) DEFAULT NULL,
  `cant_suspencion_picadas` int(2) DEFAULT NULL,
  `cant_gota_picadas` int(2) DEFAULT NULL,
  `cant_jarabe_picadas` int(2) DEFAULT NULL,
  `cant_supositorio_picadas` int(2) DEFAULT NULL,
  `periodo_picadas` int(2) DEFAULT NULL,
  `observacion_picadas` varchar(250) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_medicamentos`
--

TRUNCATE TABLE `tbl_medicamentos`;
--
-- Volcado de datos para la tabla `tbl_medicamentos`
--

INSERT INTO `tbl_medicamentos` (`id_medicamentos`, `medicar_fiebre`, `cant_suspencion_fiebre`, `cant_gota_fiebre`, `cant_jarabe_fiebre`, `cant_supositorio_fiebre`, `periodo_fiebre`, `observacion_fiebre`, `alergico_picadas`, `medicar_picadas`, `cant_suspencion_picadas`, `cant_gota_picadas`, `cant_jarabe_picadas`, `cant_supositorio_picadas`, `periodo_picadas`, `observacion_picadas`) VALUES
(11, '2', 0, 0, 0, 0, 0, '2', '2', '2', 0, 0, 0, 0, 0, '2'),
(12, '2', 0, 0, 0, 0, 0, '2', '2', '2', 0, 0, 0, 0, 0, '2'),
(13, '2', 0, 0, 0, 0, 0, '3', '3', '3', 0, 0, 0, 0, 0, '3'),
(14, '2', 0, 0, 0, 0, 0, '', 'NO', '', 0, 0, 0, 0, 0, ''),
(15, '2', 0, 0, 0, 0, 0, '', 'SI', '', 0, 0, 0, 0, 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_nivel`
--

CREATE TABLE IF NOT EXISTS `tbl_nivel` (
  `id_nivel` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_nivel`
--

TRUNCATE TABLE `tbl_nivel`;
--
-- Volcado de datos para la tabla `tbl_nivel`
--

INSERT INTO `tbl_nivel` (`id_nivel`, `nombre`, `precio`) VALUES
(1, 'MATERNAL A', '900'),
(2, 'MATERNAL B', '1200'),
(3, 'PRIMERO A', '1000'),
(4, 'PRIMERO B', '1000'),
(5, 'SEGUNDO A', '1000'),
(6, 'SEGUNDO B', '1000'),
(7, 'TERCERO A', '1000'),
(8, 'TERCERO B', '1000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_representante`
--

CREATE TABLE IF NOT EXISTS `tbl_representante` (
  `id_representante` int(11) NOT NULL,
  `apellidos` varchar(150) DEFAULT NULL,
  `nombres` varchar(150) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `estado_civil` varchar(20) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `fech_nac` date DEFAULT NULL,
  `dir_hab` varchar(250) DEFAULT NULL,
  `profesion` varchar(100) DEFAULT NULL,
  `lugar_trab` varchar(250) DEFAULT NULL,
  `dir_trab` varchar(250) DEFAULT NULL,
  `tlf_trab` varchar(20) DEFAULT NULL,
  `tlf_hab` varchar(20) DEFAULT NULL,
  `tlf_cel` varchar(20) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tbl_representante`
--

TRUNCATE TABLE `tbl_representante`;
--
-- Volcado de datos para la tabla `tbl_representante`
--

INSERT INTO `tbl_representante` (`id_representante`, `apellidos`, `nombres`, `edad`, `estado_civil`, `cedula`, `nacionalidad`, `fech_nac`, `dir_hab`, `profesion`, `lugar_trab`, `dir_trab`, `tlf_trab`, `tlf_hab`, `tlf_cel`, `foto`) VALUES
(21, 'MEZA', 'ANA', 52, '2', '2', '2', '1966-04-17', 'L', 'L', 'L', 'L', '(1652) 367-1523', '(1625) 367-1523', '(6725) 361-7253', '2_Osa.jpg'),
(22, '2', '2', 2, '2', '2', '2', '2015-04-01', '2', '2', '2', '2', '(2726) 876-3718', '(7162) 387-1623', '(7162) 378-1623', '0_OsaPanda2.jpg'),
(23, '5', '5', 5, '5', '5', '5', '2015-04-01', '2', '2', '2', '2', '(2189) 273-1837', '(7627) 316-7938', '(2657) 386-2736', '2_OsaPanda2.jpg'),
(24, '2', '2', 2, '2', '2', '2', '2015-04-01', '2', '2', '2', '2', '(2178) 361-7361', '(6536) 275-3876', '(6523) 652-8673', '3_OsaPanda2.jpg'),
(25, '3', '3', 3, '3', '3', '3', '1989-12-12', '22', '2', '2', '2', '(2656) 357-6576', '(6253) 672-5367', '(7563) 562-7536', '0_cedula sarah0001.jpg'),
(26, '2', '2', 2, '2', '2', '2', '1989-12-22', '2', '2', '2', '2', '(1625) 361-7523', '(6521) 876-3512', '(6253) 167-3561', 'none.jpg'),
(27, '', '', 0, NULL, '', '', NULL, '', '', '', '', '', '', '', 'none.jpg'),
(28, '', '', 0, NULL, '', '', NULL, '', '', '', '', '', '', '', 'none.jpg'),
(29, '', '', 0, '', '', '', NULL, '', '', '', '', '', '', '', 'none.jpg'),
(30, '', '', 0, '', '', '', NULL, '', '', '', '', '', '', '', 'none.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tlb_parentesco`
--

CREATE TABLE IF NOT EXISTS `tlb_parentesco` (
  `id_parentesco` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `tlb_parentesco`
--

TRUNCATE TABLE `tlb_parentesco`;
--
-- Volcado de datos para la tabla `tlb_parentesco`
--

INSERT INTO `tlb_parentesco` (`id_parentesco`, `nombre`) VALUES
(3, 'ABUELA'),
(4, 'ABUELO'),
(5, 'TIA'),
(6, 'TIO'),
(7, 'HERMANA'),
(8, 'HERMANO'),
(9, 'CUNADA'),
(10, 'CUNADO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bdv_role`
--
ALTER TABLE `bdv_role`
  ADD PRIMARY KEY (`id_role`),
  ADD UNIQUE KEY `id_role_3` (`id_role`),
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_role_2` (`id_role`);

--
-- Indices de la tabla `bdv_user_backend`
--
ALTER TABLE `bdv_user_backend`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `user` (`userBackend`,`contrasenia`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `bdv_user_roles`
--
ALTER TABLE `bdv_user_roles`
  ADD PRIMARY KEY (`id_user`,`id_role`),
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_role_2` (`id_role`),
  ADD KEY `id_user` (`id_user`,`id_role`);

--
-- Indices de la tabla `tbl_autorizado`
--
ALTER TABLE `tbl_autorizado`
  ADD PRIMARY KEY (`id_autorizado`),
  ADD KEY `id_parentesco` (`id_parentesco`);

--
-- Indices de la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indices de la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  ADD PRIMARY KEY (`id_estudiante`),
  ADD UNIQUE KEY `id_estudiante_2` (`id_estudiante`),
  ADD KEY `id_nivel` (`id_nivel`),
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `id_estudiante_3` (`id_estudiante`),
  ADD KEY `id_representante` (`id_representante_m`),
  ADD KEY `id_representante_p` (`id_representante_p`,`id_autorizado`,`id_medicamentos`,`id_nivel`),
  ADD KEY `id_autorizado` (`id_autorizado`),
  ADD KEY `id_medicamentos` (`id_medicamentos`);

--
-- Indices de la tabla `tbl_estudiante_cursos`
--
ALTER TABLE `tbl_estudiante_cursos`
  ADD PRIMARY KEY (`id_estudiante`,`id_cursos`),
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `id_cursos` (`id_cursos`),
  ADD KEY `id_estudiante_2` (`id_estudiante`,`id_cursos`);

--
-- Indices de la tabla `tbl_medicamentos`
--
ALTER TABLE `tbl_medicamentos`
  ADD PRIMARY KEY (`id_medicamentos`);

--
-- Indices de la tabla `tbl_nivel`
--
ALTER TABLE `tbl_nivel`
  ADD PRIMARY KEY (`id_nivel`);

--
-- Indices de la tabla `tbl_representante`
--
ALTER TABLE `tbl_representante`
  ADD PRIMARY KEY (`id_representante`);

--
-- Indices de la tabla `tlb_parentesco`
--
ALTER TABLE `tlb_parentesco`
  ADD PRIMARY KEY (`id_parentesco`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bdv_role`
--
ALTER TABLE `bdv_role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `bdv_user_backend`
--
ALTER TABLE `bdv_user_backend`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `tbl_autorizado`
--
ALTER TABLE `tbl_autorizado`
  MODIFY `id_autorizado` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  MODIFY `id_estudiante` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tbl_medicamentos`
--
ALTER TABLE `tbl_medicamentos`
  MODIFY `id_medicamentos` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `tbl_nivel`
--
ALTER TABLE `tbl_nivel`
  MODIFY `id_nivel` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `tbl_representante`
--
ALTER TABLE `tbl_representante`
  MODIFY `id_representante` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `tlb_parentesco`
--
ALTER TABLE `tlb_parentesco`
  MODIFY `id_parentesco` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bdv_user_roles`
--
ALTER TABLE `bdv_user_roles`
  ADD CONSTRAINT `bdv_user_roles_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `bdv_role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bdv_user_roles_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `bdv_user_backend` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_autorizado`
--
ALTER TABLE `tbl_autorizado`
  ADD CONSTRAINT `tbl_autorizado_ibfk_1` FOREIGN KEY (`id_parentesco`) REFERENCES `tlb_parentesco` (`id_parentesco`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  ADD CONSTRAINT `tbl_estudiante_ibfk_1` FOREIGN KEY (`id_representante_m`) REFERENCES `tbl_representante` (`id_representante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_ibfk_2` FOREIGN KEY (`id_representante_p`) REFERENCES `tbl_representante` (`id_representante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_ibfk_3` FOREIGN KEY (`id_autorizado`) REFERENCES `tbl_autorizado` (`id_autorizado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_ibfk_4` FOREIGN KEY (`id_medicamentos`) REFERENCES `tbl_medicamentos` (`id_medicamentos`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_ibfk_5` FOREIGN KEY (`id_nivel`) REFERENCES `tbl_nivel` (`id_nivel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_estudiante_cursos`
--
ALTER TABLE `tbl_estudiante_cursos`
  ADD CONSTRAINT `tbl_estudiante_cursos_ibfk_2` FOREIGN KEY (`id_cursos`) REFERENCES `tbl_cursos` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_cursos_ibfk_3` FOREIGN KEY (`id_estudiante`) REFERENCES `tbl_estudiante` (`id_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
