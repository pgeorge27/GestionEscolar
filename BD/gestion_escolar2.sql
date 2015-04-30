-- phpMyAdmin SQL Dump
-- version 4.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-04-2015 a las 07:46:33
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

DROP TABLE IF EXISTS `bdv_role`;
CREATE TABLE IF NOT EXISTS `bdv_role` (
  `id_role` int(11) NOT NULL,
  `role_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `bdv_user_backend`;
CREATE TABLE IF NOT EXISTS `bdv_user_backend` (
  `id_user` int(11) NOT NULL,
  `userBackend` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_user_backend`
--

INSERT INTO `bdv_user_backend` (`id_user`, `userBackend`, `contrasenia`, `activo`) VALUES
(1, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user_roles`
--

DROP TABLE IF EXISTS `bdv_user_roles`;
CREATE TABLE IF NOT EXISTS `bdv_user_roles` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_autorizado`
--

DROP TABLE IF EXISTS `tbl_autorizado`;
CREATE TABLE IF NOT EXISTS `tbl_autorizado` (
  `id_autorizado` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellido` varchar(150) NOT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `id_parentesco` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cursos`
--

DROP TABLE IF EXISTS `tbl_cursos`;
CREATE TABLE IF NOT EXISTS `tbl_cursos` (
  `id_curso` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_cursos`
--

INSERT INTO `tbl_cursos` (`id_curso`, `nombre`, `precio`) VALUES
(1, 'KARATE', '1000'),
(3, 'DANZA', '1000'),
(4, 'PINTURA', '1200');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante`
--

DROP TABLE IF EXISTS `tbl_estudiante`;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante_cursos`
--

DROP TABLE IF EXISTS `tbl_estudiante_cursos`;
CREATE TABLE IF NOT EXISTS `tbl_estudiante_cursos` (
  `id_estudiante` int(11) NOT NULL,
  `id_cursos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_medicamentos`
--

DROP TABLE IF EXISTS `tbl_medicamentos`;
CREATE TABLE IF NOT EXISTS `tbl_medicamentos` (
  `id_medicamentos` int(11) NOT NULL,
  `medicar_fiebre` varchar(250) NOT NULL,
  `cant_suspencion_fiebre` int(2) NOT NULL,
  `cant_gota_fiebre` int(2) NOT NULL,
  `cant_jarabe_fiebre` int(2) NOT NULL,
  `cant_supositorio_fiebre` int(2) NOT NULL,
  `periodo_fiebre` int(2) NOT NULL,
  `observacion_fiebre` varchar(250) NOT NULL,
  `alergico_picadas` varchar(2) NOT NULL,
  `medicar_picadas` varchar(250) NOT NULL,
  `cant_suspencion_picadas` int(2) NOT NULL,
  `cant_gota_picadas` int(2) NOT NULL,
  `cant_jarabe_picadas` int(2) NOT NULL,
  `cant_supositorio_picadas` int(2) NOT NULL,
  `periodo_picadas` int(2) NOT NULL,
  `observacion_picadas` varchar(250) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_nivel`
--

DROP TABLE IF EXISTS `tbl_nivel`;
CREATE TABLE IF NOT EXISTS `tbl_nivel` (
  `id_nivel` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_nivel`
--

INSERT INTO `tbl_nivel` (`id_nivel`, `nombre`, `precio`) VALUES
(1, 'MATERNAL A', '900'),
(2, 'INICIAL B', '1200');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_representante`
--

DROP TABLE IF EXISTS `tbl_representante`;
CREATE TABLE IF NOT EXISTS `tbl_representante` (
  `id_representante` int(11) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `edad` int(2) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  `fech_nac` date NOT NULL,
  `dir_hab` varchar(250) NOT NULL,
  `profesion` varchar(100) NOT NULL,
  `lugar_trab` varchar(250) NOT NULL,
  `dir_trab` varchar(250) NOT NULL,
  `tlf_trab` varchar(20) NOT NULL,
  `tlf_hab` varchar(20) NOT NULL,
  `tlf_cel` varchar(20) NOT NULL,
  `foto` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tlb_parentesco`
--

DROP TABLE IF EXISTS `tlb_parentesco`;
CREATE TABLE IF NOT EXISTS `tlb_parentesco` (
  `id_parentesco` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tlb_parentesco`
--

INSERT INTO `tlb_parentesco` (`id_parentesco`, `nombre`) VALUES
(1, 'MADRE'),
(2, 'PADRE'),
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
  MODIFY `id_autorizado` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  MODIFY `id_estudiante` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tbl_medicamentos`
--
ALTER TABLE `tbl_medicamentos`
  MODIFY `id_medicamentos` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tbl_nivel`
--
ALTER TABLE `tbl_nivel`
  MODIFY `id_nivel` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tbl_representante`
--
ALTER TABLE `tbl_representante`
  MODIFY `id_representante` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
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
  ADD CONSTRAINT `tbl_estudiante_cursos_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `tbl_estudiante` (`id_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_estudiante_cursos_ibfk_2` FOREIGN KEY (`id_cursos`) REFERENCES `tbl_cursos` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
