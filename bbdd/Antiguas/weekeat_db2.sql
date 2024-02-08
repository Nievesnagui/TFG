-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 25-01-2024 a las 16:44:35
-- Versión del servidor: 10.9.8-MariaDB-1:10.9.8+maria~ubu2204
-- Versión de PHP: 8.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `weekeat_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `content`
--

CREATE TABLE `content` (
  `id_content` bigint(20) NOT NULL,
  `id_ingredient` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `content`
--

INSERT INTO `content` (`id_content`, `id_ingredient`, `id_recipe`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fav_recipe`
--

CREATE TABLE `fav_recipe` (
  `id_fav` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fav_recipe`
--

INSERT INTO `fav_recipe` (`id_fav`, `id_user`, `id_recipe`) VALUES
(1, 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredient`
--

CREATE TABLE `ingredient` (
  `id_ingredient` bigint(11) NOT NULL,
  `id_type` bigint(20) NOT NULL,
  `name` varchar(55) NOT NULL,
  `ingredient_image` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `id_type`, `name`, `ingredient_image`) VALUES
(1, 1, 'yogurt prueba', NULL),
(2, 2, 'prueba', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recipe`
--

CREATE TABLE `recipe` (
  `id_recipe` bigint(11) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` longtext NOT NULL,
  `recipe_image` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recipe`
--

INSERT INTO `recipe` (`id_recipe`, `id_user`, `name`, `description`, `recipe_image`) VALUES
(1, 9, 'Macarroncios', 'cosas cosas cosas', NULL),
(3, 9, 'madalena', 'fsfdsfsf', NULL),
(4, 9, 'madalena', 'fsfdsfsf', NULL),
(5, 9, 'Para borrar', 'instrucciones', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `schedule`
--

CREATE TABLE `schedule` (
  `id_schedule` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL,
  `id_weekly` bigint(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `schedule`
--

INSERT INTO `schedule` (`id_schedule`, `id_recipe`, `id_weekly`, `type`, `day`) VALUES
(1, 1, 1, 'dinner', 'monday'),
(3, 1, 1, 'lunch', 'monday');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type`
--

CREATE TABLE `type` (
  `id_type` bigint(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `type`
--

INSERT INTO `type` (`id_type`, `name`) VALUES
(1, 'dairy'),
(2, 'fish');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile_picture` blob DEFAULT NULL,
  `role` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `surname`, `email`, `phone`, `password`, `profile_picture`, `role`) VALUES
(9, 'administrador', 'Admin', 'Apellido', 'mail1@mail.com', '658945123', '75358e7d1d70df676d847e711d0c2e2d052660a1fad21050c491ba77d67b65ef', NULL, 0),
(10, 'usuario', 'Admin', 'Apellido', 'mail2@mail.com', '658945123', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', NULL, 0),
(12, 'prueba3', 'Pepeto', 'Prueba', 'correo3@mail.com', '654987412', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 1),
(15, 'prueba6', 'Prueba', 'Prueba', 'correo6@mail.com', '654987412', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `weekly`
--

CREATE TABLE `weekly` (
  `id_weekly` bigint(11) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  `init_date` date NOT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `weekly`
--

INSERT INTO `weekly` (`id_weekly`, `id_user`, `init_date`, `end_date`) VALUES
(1, 9, '2024-01-15', NULL),
(3, 10, '2024-01-15', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `content`
--
ALTER TABLE `content`
  ADD PRIMARY KEY (`id_content`);

--
-- Indices de la tabla `fav_recipe`
--
ALTER TABLE `fav_recipe`
  ADD PRIMARY KEY (`id_fav`);

--
-- Indices de la tabla `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id_ingredient`);

--
-- Indices de la tabla `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`id_recipe`);

--
-- Indices de la tabla `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id_schedule`);

--
-- Indices de la tabla `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `weekly`
--
ALTER TABLE `weekly`
  ADD PRIMARY KEY (`id_weekly`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `content`
--
ALTER TABLE `content`
  MODIFY `id_content` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `fav_recipe`
--
ALTER TABLE `fav_recipe`
  MODIFY `id_fav` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id_ingredient` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `recipe`
--
ALTER TABLE `recipe`
  MODIFY `id_recipe` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id_schedule` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `type`
--
ALTER TABLE `type`
  MODIFY `id_type` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `weekly`
--
ALTER TABLE `weekly`
  MODIFY `id_weekly` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
