-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 06-02-2024 a las 17:14:32
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
  `id` bigint(20) NOT NULL,
  `id_ingredient` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `content`
--

INSERT INTO `content` (`id`, `id_ingredient`, `id_recipe`) VALUES
(1, 1, 1),
(3, 7, 7),
(5, 1, 1),
(6, 1, 1),
(7, 1, 1),
(8, 7, 1),
(12, 10, 13),
(13, 10, 13),
(14, 1, 13),
(15, 10, 13),
(17, 18, 13),
(18, 15, 13),
(23, 16, 9),
(24, 7, 19),
(25, 10, 19),
(26, 10, 33),
(35, 15, 28),
(36, 10, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fav_recipe`
--

CREATE TABLE `fav_recipe` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fav_recipe`
--

INSERT INTO `fav_recipe` (`id`, `id_user`, `id_recipe`) VALUES
(1, 9, 1),
(3, 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredient`
--

CREATE TABLE `ingredient` (
  `id` bigint(11) NOT NULL,
  `id_type` bigint(20) NOT NULL,
  `name` varchar(55) NOT NULL,
  `ingredient_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredient`
--

INSERT INTO `ingredient` (`id`, `id_type`, `name`, `ingredient_image`) VALUES
(1, 10, 'yogurt prueba', 'http://localhost:8083/media/madalena.jpg'),
(7, 11, '123459', NULL),
(10, 14, 'Pruebaa', NULL),
(15, 15, 'nuevo', NULL),
(16, 11, 'vhjhjbh', NULL),
(18, 18, 'ewdf', 'http://localhost:8083/media/micho.jpg'),
(19, 21, 'edefef', NULL),
(20, 22, 'vhjhjbh', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recipe`
--

CREATE TABLE `recipe` (
  `id` bigint(11) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` longtext NOT NULL,
  `recipe_image` varchar(255) DEFAULT NULL,
  `process` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recipe`
--

INSERT INTO `recipe` (`id`, `id_user`, `name`, `description`, `recipe_image`, `process`) VALUES
(1, 1, 'Macarroncillos', 'cosas cosas cosas', NULL, '\r\n\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fringilla gravida eros, sed maximus dolor hendrerit gravida. Quisque sit amet tincidunt lectus, dapibus tincidunt dolor. Pellentesque rhoncus nisl quis diam feugiat varius. Etiam lectus odio, luctus malesuada sodales non, malesuada at augue. Nullam et erat leo. Praesent bibendum massa nunc, in placerat tortor luctus eget. Cras vel augue ac libero bibendum scelerisque. Cras ac odio lobortis, vulputate augue sit amet, vulputate libero. Quisque interdum tempor dolor, sed auctor lectus fermentum non. Curabitur vitae lacus ut felis commodo volutpat.\r\n\r\nNam est libero, luctus vitae dignissim at, vestibulum id orci. Fusce eget vehicula augue. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ex diam, posuere porttitor turpis ac, tincidunt vulputate eros. In nec eleifend ligula. Duis non facilisis elit, quis convallis erat. In non nibh auctor, accumsan urna a, volutpat arcu. In laoreet, ante quis consequat condimentum, orci libero elementum justo, vitae egestas erat massa ut orci. Suspendisse lacinia facilisis eleifend. Duis vel arcu ipsum.\r\n\r\nVestibulum iaculis mi arcu, vel porta magna condimentum vitae. Mauris a ipsum eget justo dictum tempus sit amet eu tellus. Vestibulum ac finibus augue, ac molestie diam. Praesent quam nisi, consectetur quis dictum nec, porttitor nec urna. Integer sollicitudin nunc at libero malesuada, sed elementum orci egestas. Aenean nec risus consequat ex commodo malesuada. Nunc ut ipsum felis.\r\n\r\nVivamus consequat imperdiet neque eu pretium. Aenean quam sapien, sodales ac rutrum sed, finibus sit amet metus. Nunc interdum mauris erat, non convallis elit aliquam sed. Donec ornare felis quis tortor condimentum laoreet. Aliquam erat volutpat. Ut dolor arcu, hendrerit quis vestibulum vitae, cursus at nulla. Donec sed felis lacus. Fusce tristique enim quis ornare egestas. Quisque vulputate orci mi, id posuere felis hendrerit eget. Duis laoreet, dolor sed pulvinar rhoncus, velit nisl pretium turpis, at egestas eros turpis eu velit. Donec risus neque, pulvinar in massa eget, mattis sodales risus.\r\n\r\nNam mollis pretium turpis volutpat tincidunt. Curabitur sem felis, viverra in mollis sed, faucibus quis lacus. Quisque eleifend ullamcorper nisl accumsan blandit. Nulla ac nulla et justo auctor ultricies a in est. Phasellus sit amet ipsum lectus. Donec vitae ante et orci porta tincidunt. Nam efficitur ipsum ipsum, vitae porttitor massa gravida ut. Quisque condimentum, tortor in iaculis imperdiet, risus enim scelerisque metus, nec tincidunt diam neque in libero. Duis euismod tellus sed ornare placerat. Vivamus sed mauris nisi. Sed placerat mollis sem, in dictum libero viverra quis. Quisque id gravida elit. Vestibulum ac vulputate est. '),
(3, 1, 'madalena', 'fsfdsfsf', NULL, NULL),
(7, 2, 'Para borrar', 'prueba', NULL, NULL),
(9, 10, 'Madalenas', 'Blablablabalbla', NULL, NULL),
(10, 12, 'Papas', 'Con sal', NULL, NULL),
(13, 9, 'Para borrar', 'prueba', NULL, NULL),
(17, 9, 'cosas', 'cosas', NULL, NULL),
(19, 9, 'Papas', 'sdsdscon cosas', NULL, NULL),
(28, 9, 'fcvgh', 'stdfg', NULL, NULL),
(29, 9, 'dfg', 'fdg', NULL, NULL),
(30, 9, 'vgbjhnj', 'fgvbhj', NULL, NULL),
(31, 9, 'asas', 'sas', NULL, NULL),
(32, 9, 'sas', 'sas', NULL, NULL),
(33, 9, 'sas', 'asas', NULL, NULL),
(35, 9, 'Para borrar', 'prueba', NULL, 'sdfghjkljhgfhbjnk'),
(36, 15, 'Prueba process', 'Prueba processPrueba process', NULL, 'Prueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba processPrueba process');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `schedule`
--

CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL,
  `id_weekly` bigint(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `schedule`
--

INSERT INTO `schedule` (`id`, `id_recipe`, `id_weekly`, `type`, `day`) VALUES
(1, 1, 1, 'dinner', 'monday'),
(3, 1, 1, 'lunch', 'monday'),
(4, 1, 1, 'lunch', 'monday');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type`
--

CREATE TABLE `type` (
  `id` bigint(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `type`
--

INSERT INTO `type` (`id`, `name`) VALUES
(10, 'Dairy'),
(11, 'Meat'),
(12, 'Meat Product'),
(13, 'Fish'),
(14, 'Fruit'),
(15, 'Vegetable'),
(16, 'Grain'),
(17, 'Oil'),
(18, 'Fat'),
(19, 'Sweets'),
(20, 'Grain Product'),
(21, 'Legume'),
(22, 'Nut');

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
  `profile_picture` varchar(255) DEFAULT NULL,
  `role` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `surname`, `email`, `phone`, `password`, `profile_picture`, `role`) VALUES
(1, 'administrador', 'Admin', 'Apellido', 'mail1@mail.com', '658945123', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', 'http://localhost:8083/media/micho.jpg', 0),
(2, 'usuario', 'Admin', 'Apellido', 'mail2@mail.com', '658945123', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(3, 'Estom0', 'Esther', 'Dominguez', 'EstDom0@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765430', NULL, 0),
(4, 'Criim1', 'Cristina', 'Jimenez', 'CriJim1@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765431', NULL, 0),
(5, 'Estom2', 'Esther', 'Dominguez', 'EstDom2@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765432', NULL, 0),
(6, 'Aurom3', 'Aurora', 'Dominguez', 'AurDom3@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765433', NULL, 0),
(7, 'Juaoz4', 'Juan', 'Lozano', 'JuaLoz4@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765434', NULL, 0),
(8, 'Gabue5', 'Gabriel', 'Cuesta', 'GabCue5@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765435', NULL, 0),
(9, 'Aural6', 'Aurora', 'Palomero', 'AurPal6@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765436', NULL, 0),
(10, 'Crigu7', 'Cristina', 'Aguilar', 'CriAgu7@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765437', NULL, 0),
(11, 'Gabue8', 'Gabriel', 'Cuesta', 'GabCue8@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765438', NULL, 0),
(12, 'Criue9', 'Cristina', 'Cuesta', 'CriCue9@ausiasmarch.net', '654123654', 'unapasswordsegura123455677899765439', NULL, 0),
(13, 'Gabgu10', 'Gabriel', 'Aguilar', 'GabAgu10@ausiasmarch.net', '654123654', 'unapasswordsegura1234556778997654310', NULL, 0),
(14, 'Crioz11', 'Cristina', 'Lozano', 'CriLoz11@ausiasmarch.net', '654123654', 'unapasswordsegura1234556778997654311', NULL, 0),
(15, 'Criom12', 'Cristina', 'Dominguez', 'CriDom12@ausiasmarch.net', '654123654', 'unapasswordsegura1234556778997654312', NULL, 0),
(16, 'michuelo', 'michillo', 'mrmicho', 'michi@mail.micho', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', 'C:\\fakepath\\micho.jpg', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `weekly`
--

CREATE TABLE `weekly` (
  `id` bigint(11) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  `init_date` date NOT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `weekly`
--

INSERT INTO `weekly` (`id`, `id_user`, `init_date`, `end_date`) VALUES
(1, 9, '2024-01-15', NULL),
(3, 10, '2024-01-15', NULL),
(4, 10, '2024-01-15', NULL),
(5, 1, '2024-02-13', '2024-02-19'),
(6, 1, '2024-02-06', '2024-02-13');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `content`
--
ALTER TABLE `content`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fav_recipe`
--
ALTER TABLE `fav_recipe`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `weekly`
--
ALTER TABLE `weekly`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `content`
--
ALTER TABLE `content`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `fav_recipe`
--
ALTER TABLE `fav_recipe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `recipe`
--
ALTER TABLE `recipe`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `type`
--
ALTER TABLE `type`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `weekly`
--
ALTER TABLE `weekly`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
