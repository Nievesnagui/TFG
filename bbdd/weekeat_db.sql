-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 19-02-2024 a las 17:56:31
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
(84, 16, 51),
(85, 16, 52),
(86, 18, 52),
(87, 39, 53),
(88, 26, 53),
(89, 30, 53),
(90, 37, 53),
(91, 45, 53),
(92, 51, 53),
(93, 33, 54),
(94, 30, 54),
(95, 28, 54),
(96, 38, 54),
(97, 34, 54),
(98, 30, 55),
(99, 34, 55),
(100, 39, 55),
(101, 53, 55),
(102, 33, 55),
(103, 35, 55),
(104, 49, 56),
(105, 33, 56),
(106, 34, 56),
(107, 53, 56),
(108, 29, 56),
(109, 54, 56),
(110, 26, 57),
(111, 39, 57),
(112, 30, 57),
(113, 28, 58),
(114, 33, 58),
(115, 32, 58),
(116, 31, 58),
(117, 30, 58),
(118, 34, 58),
(119, 29, 58),
(120, 30, 59),
(121, 27, 59),
(122, 32, 59),
(123, 55, 59),
(124, 25, 59),
(125, 29, 60),
(126, 45, 60),
(127, 28, 60),
(128, 31, 60),
(129, 52, 60),
(130, 51, 60),
(131, 49, 60),
(132, 53, 60),
(133, 55, 60),
(134, 37, 61),
(135, 55, 61),
(136, 30, 61),
(137, 27, 61),
(138, 47, 61),
(139, 42, 62),
(140, 35, 62),
(141, 43, 62),
(142, 25, 62),
(143, 39, 62),
(144, 40, 62),
(145, 44, 62),
(146, 30, 62),
(147, 28, 63),
(148, 27, 63),
(149, 29, 63),
(150, 50, 63),
(151, 26, 63),
(152, 47, 64),
(153, 51, 64),
(154, 46, 64),
(155, 37, 64),
(156, 36, 64),
(157, 49, 64),
(158, 25, 64),
(159, 27, 64),
(160, 33, 64);

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
(72, 1, 54),
(73, 1, 55),
(74, 1, 58),
(75, 1, 64),
(76, 1, 62),
(77, 1, 53),
(78, 1, 56),
(80, 1, 59);

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
(25, 12, 'Egg', 'http://localhost:8083/media/huevo.jpg'),
(26, 11, 'Chicken', 'http://localhost:8083/media/pollo.jpg'),
(27, 16, 'Rice', 'http://localhost:8083/media/arroz.jpg'),
(28, 15, 'Tomato', 'http://localhost:8083/media/tomate.jpg'),
(29, 15, 'Onion', 'http://localhost:8083/media/cebolla.jpg'),
(30, 15, 'Garlic', 'http://localhost:8083/media/ajo.jpg'),
(31, 15, 'Pepper', 'http://localhost:8083/media/pimiento.jpg'),
(32, 15, 'Spinach', 'http://localhost:8083/media/espinaca.jpg'),
(33, 10, 'Cheese', 'http://localhost:8083/media/queso.jpg'),
(34, 20, 'Pasta', 'http://localhost:8083/media/pasta.jpg'),
(35, 11, 'Mince', 'http://localhost:8083/media/carnepicada.jpeg'),
(36, 14, 'Avocado', 'http://localhost:8083/media/aguacate.jpg'),
(37, 14, 'Lemon', 'http://localhost:8083/media/limon.jpg'),
(38, 15, 'Parsley', 'http://localhost:8083/media/perejil.jpg'),
(39, 17, 'Olive oil', 'http://localhost:8083/media/aceite_oliva_g.jpg'),
(40, 17, 'Vinegar', 'http://localhost:8083/media/vinagre.jpg'),
(41, 21, 'Beans', 'http://localhost:8083/media/alubia.jpeg'),
(42, 15, 'Carrot', 'http://localhost:8083/media/ZANAHORIA.jpg'),
(43, 15, 'Celery', 'http://localhost:8083/media/apio.jpg'),
(44, 10, 'Coconut Milk', 'http://localhost:8083/media/leche-de-coco.jpg'),
(45, 15, 'Ginger', 'http://localhost:8083/media/jengibre.jpg'),
(46, 20, 'Flour', 'http://localhost:8083/media/Harina-de-Trigo.jpg'),
(47, 19, 'Sugar', 'http://localhost:8083/media/azucar.jpg'),
(48, 20, 'Yeast', 'http://localhost:8083/media/levadura.jpg'),
(49, 10, 'Butter', 'http://localhost:8083/media/mantequilla.jpg'),
(50, 15, 'Cucumber', 'http://localhost:8083/media/pepino.jpg'),
(51, 10, 'Yogurt', 'http://localhost:8083/media/yogur.jpg'),
(52, 22, 'Nuts', 'http://localhost:8083/media/frutossecos.jpg'),
(53, 15, 'Basil', 'http://localhost:8083/media/ingrediente-albahaca.jpg'),
(54, 15, 'Mushrooms', 'http://localhost:8083/media/setas.jpg'),
(55, 13, 'Salmon', 'http://localhost:8083/media/salmon.jpg');

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
(53, 1, 'Baked butter chicken', ' This Indian inspired whole baked chicken is an easy way to get dinner on the table, whilst curing those takeaway cravings. ', 'http://localhost:8083/media/baked-butter-chicken-30562-1.jpg', '\n\nPreheat oven to 220°C. Place the oil in a bowl with 1 tsp each garam masala and turmeric. Season.\n\nRub spice mix all over the chicken. Place a lemon half in the cavity, then tie the legs together using kitchen string.\n\n\nPlace garlic, ginger, chilli, tomato puree, yoghurt, stock, curry leaves and remaining 2 tsp garam masala and 1 tsp turmeric in a deep baking tray. \n\n\nSeason. Place the chicken on top and roast for 30 minutes, then reduce oven to 180°C and roast for a further 20 minutes or until the juices of the chicken run clear when the thickest part of a thigh is pierced.\n\n\nRemove from oven and rest for 15 minutes.\n\n\nSqueeze over the juice from remaining lemon, top with extra fried curry leaves and serve with papadums and raita '),
(54, 3, 'Pasta all\'amatriciana', ' A quick and easy pasta recipe that will satisfy both adults and kids. ', 'http://localhost:8083/media/pasta-allamatriciana-35264-3.jpg', 'Put the speck in a cold, deep frypan then place over medium heat. When the speck begins to sizzle, cook for 2-3 minutes, tossing, until the fat has rendered.\n\nAdd the onion and cook for 2-3 minutes until softened then add the garlic and chilli and cook for a further 1-2 minutes until fragrant. \n\nAdd the tomatoes, basil stalks and half the leaves and 1 cup (250ml) water, and cook for 6-8 minutes until reduced. \n\nMeanwhile, cook the pasta according to packet instructions. Drain, reserving 1/3 cup (80ml) cooking liquid. Discard the basil stalks then add the pasta to the sauce with the reserved water and toss to combine. \n\nServe topped with pecorino and remaining basil leaves. \n'),
(55, 6, 'Instant pork ragu', 'Lasagna sheets give this ragu a twist you\'ll love. ', 'http://localhost:8083/media/pork-ragu-35818-3.jpg', 'Bring a large saucepan of water to the boil. Cook lasagne sheets until al dente. Meanwhile, squeeze sausage meat from casings. Heat oil in a deep frypan over high heat. Add the sausage meat and cook for 3-4 minutes until golden. Add the garlic and cook for 1 minute or until fragrant.\n\nAdd tomato paste, wine, tomatoes, 1⁄2 cup (125ml) water and bay leaf. Stir to combine. Use a masher or spoon to break down the sausage meat into small pieces. Bring to a simmer and cook, stirring occasionally, for 10 minutes or until reduced and thickened. \n\nDrain lasagne sheets and serve topped with sauce, grated parmesan and parsley. '),
(56, 9, 'Mushroom lasagne', 'You\'re sure to find a new family favourite with this ultimate vegetarian pasta recipe ', 'http://localhost:8083/media/mushroom-lasagne-13495-1.jpg', ' Preheat the oven to 180°C and grease a 30cm baking dish.\n\nSoak the porcini in 1/2 cup (125ml) boiling water for 10 minutes.\n\nMeanwhile, heat oil in a large pan over medium heat. Cook onion, stirring, for 5-6 minutes or until softened. Add the garlic, Swiss browns, bay leaf and thyme, then cook, stirring, for 2-3 minutes until mushrooms start to wilt and caramelise. Add porcini and soaking liquid, then cook for a further 2 minutes until most liquid has evaporated. Stir in passata and 1 cup (250ml) water and season well. Set aside.\n\n Meanwhile, for bechamel, place milk, halved onion, bay leaf and thyme in a pan over medium-high heat and bring to just below boiling point. Remove from heat and stand for 15 minutes to allow flavours to infuse. Melt butter in a pan over medium-low heat. Add flour and stir for 2 minutes until smooth and combined. Strain milk through a sieve into a jug, then gradually whisk into butter mixture until smooth. Add nutmeg, season, then stir over low heat for 3-4 minutes until thickened.\n\nTo assemble lasagne, spoon half the mushroom sauce in the baking dish, spread with one-third of bechamel, then top with half the mozzarella. Cover with pasta sheets, then repeat with remaining mushroom mixture, half the remaining bechamel and the remaining mozzarella and pasta. Finish with a final layer of bechamel, scatter with parmesan, then cover with baking paper and foil. Bake for 45 minutes, then uncover and bake for 15 minutes more until golden and cooked. Rest for 10 minutes, then slice and serve with extra parmesan. '),
(57, 2, 'Chicken diavola with polenta and zucchini ', 'Perfect for weekend entertaining. ', 'http://localhost:8083/media/chicken-diavola-with-polenta-and-zucchini-flowers-36082-2.jpg', ' Preheat oven to 200°C. Place chicken, skin-side up, in a roasting pan and add wine, oil, rosemary, garlic and oregano.\n\nSeason with salt. Roast for 45-50 minutes until juices run clear when the thickest part of the thigh is pierced with a skewer.\n\nToss zucchini in roasting juices, season with pepper. Serve chicken, zucchini and roasting juices over polenta. '),
(58, 14, 'Trofie with nasturtium and macadamia pesto', 'Matt Preston throws nasturtium leaves on prosciutto pizza instead of rocket, tosses flowers or leaves into salads that need a peppery bite, and even adds them to green smoothies.', 'http://localhost:8083/media/trofie-with-nasturtium-and-macadamia-pesto-51134-2.jpg', ' Bring a large saucepan of water to the boil over high heat. Blanch leaves for 10 seconds, then remove with a slotted spoon, drain and immediately place in iced water. Drain, then place in a small food processor with garlic and macadamias, season, and whiz until leaves break down and nuts are finely chopped. Add cheese and pulse to combine. With the motor running, gradually add oil until smooth.\n\nBring the saucepan of water back to the boil and cook the pasta until al dente, adding the beans for the final 3 minutes. Drain the pasta and beans, reserving 1 cup (250ml) cooking liquid. Return pasta to saucepan and stir in the nasturtium pesto and reserved cooking water.\n\n\nDivide pasta among plates. Season with freshly ground black pepper and serve topped with extra parmesan and nasturtium leaves. '),
(59, 2, 'Hot-smoked salmon cakes', 'Quicker than fish pie and just as delicious.', 'http://localhost:8083/media/hot-smoked-salmon-cakes-31280-1.jpg', ' Place potato in a saucepan of cold salted water and place over medium heat, bring to the boil and simmer for 10 minutes or until tender. Drain and return to pan.\n\nHeat gently for 30 seconds to remove any excess water. Cool slightly, then roughly mash.\n\nPreheat the oven to 180°C. Toss bread, garlic, fennel and olive oil in a bowl. Spread over a baking paper-lined baking tray and bake for 10 minutes or until lightly toasted. Transfer to a food processor and whiz to a rough crumb. Set aside to cool.\n\nCombine parsley, dill, mashed potato, salmon, lemon zest and 1/2 cup crumb mixture in a bowl. Form mixture into 8 balls and flatten slightly to form patties. Coat in flour, then dip in egg and coat in remaining crumbs. Chill for 15 minutes to firm up. \n Heat 2cm sunflower oil in a frypan over medium heat. In batches, shallow-fry fishcakes for 2-3 minutes each side until crisp and golden. Drain on paper towel.\n\nToss cabbage, Brussel sprouts and lemon juice in a bowl. Season to taste. Serve fishcakes with cabbage salad, cornichons, dill and a drizzle of olive oil. '),
(60, 5, 'Thai fish and pumpkin soup', ' Jill Dupleix by Jill Dupleix Food writer Oct 02, 2015 Save to Cookbook  Look for pumpkin with a rich, dense orange flesh, and team it with a spicy/sour Thai fish curry light on coconut milk. ', 'http://localhost:8083/media/thai-fish-and-pumpkin-soup-13519-2.jpg', ' Heat oil in a saucepan over medium-high heat. Add curry paste and cook, stirring, for 2 minutes or until fragrant.\n\nAdd the coconut milk, stock, eschalot, chilli and kaffir lime leaves, if using, and stir to combine. Add pumpkin, capsicum, tamarind, fish sauce, sugar and a pinch of salt and cook for 20 minutes or until the pumpkin is tender. \n\n Add fish and simmer for 5 minutes or until the fish is opaque.\n\nPlace half the spinach in 4 warm bowls and top with the fish and veg. Scatter with remaining spinach, then ladle the sauce over the top and serve. '),
(61, 1, 'Oven-steamed soy salmon', 'Steaming the salmon locks in the moisture and infuses it with beautiful Asian flavour. ', 'http://localhost:8083/media/oven-steamed-soy-salmon-13859-1.jpg', 'reheat the oven to 180C. Combine 1 tablespoon soy sauce and 1 teaspoon sesame oil, and brush over salmon. Place salmon on one side of a wire rack set in a roasting pan.\n\nSprinkle half the spring onion, chilli and ginger over salmon. Place bok choy on the other side of rack. Pour 1cm boiling water into pan, then cover pan with foil. Bake for 15 minutes or until salmon is just cooked. \n\n Meanwhile, cook the noodles according to the packet instructions. Drain, refresh and set aside.\n\nCombine the lime juice, sugar, XO sauce, garlic and remaining 1 tbs soy sauce and 1 teaspoon sesame oil in a bowl.\n\nDivide noodles among bowls and top with salmon and bok choy. Drizzle with lime dressing, then top with remaining spring onion, chilli and ginger. Serve with extra lime wedges to squeeze over. '),
(62, 6, 'Stir-fried lamb fillet with crispy onions', ' Midweek meals are looking up thanks to this fast and fabulous recipes from Melbourne super-chef, Shannon Bennett. ', 'http://localhost:8083/media/stir-fried-lamb-fillet-with-crispy-onions-34941-4.jpg', ' Preheat oil in a wok or frypan over medium-high heat. Coat the onion rings in eggwhite then dust in flour.\n\nFry in batches for 2-3 minutes until crisp then drain on paper towel. Leave 1 tbs oil in the pan.\n\nCoat lamb in 1⁄4 cup (60ml) oyster sauce. Add to pan. Cook 3-4 minutes a side until medium. Rest, lightly covered in foil.\n\nAdd sesame oil and garlic to the pan and cook for 1 minute or until fragrant then add the rice and stir to coat. Add the remaining oyster sauce and cook, tossing for 2-3 minutes, then divide between bowls. \n\nTop with soya beans, sliced lamb and resting juices, crispy onions, radish, micro coriander and sesame seeds. '),
(63, 6, 'Burgers with buffalo mozzarella and cucumber salad', 'Keep summer cooking easy with these lively lamb burgers that are a twist on the traditional. ', 'http://localhost:8083/media/lamb-burgers-with-buffalo-mozzarella-and-cucumber-salad-15241-1.jpg', 'Preheat the oven to 180°C. Line a baking tray with foil. \n\nCombine mince, breadcrumbs, egg, mustard and dried mint in a bowl and season. Mix well, then shape into 6 patties. Cover and chill for 10 minutes. \n\nMeanwhile, place cucumber, fresh mint, lime juice, capers, sugar and 1 tablespoon oil in a bowl and toss to combine. Set aside. \n\nHeat remaining 2 tablespoons oil in a large frypan over medium-high heat. In batches, cook patties for 3-4 minutes each side until browned. Transfer to the tray and bake for 15-20 minutes until just cooked through. \n\nTo serve, spread aioli on the base of each roll. Top with a patty, mozzarella and cucumber salad. Season and replace tops. '),
(64, 6, 'Apple and cinnamon creme caramel cakes', 'Creme caramel these cakes are the perfect ending to a dinner party. ', 'http://localhost:8083/media/apple-and-cinnamon-creme-caramel-cakes-30628-1.jpg', 'Grease and line 8 holes of a 12-hole loose-bottomed mini cheesecake pan with baking paper. (Alternatively, grease and line 8 x 1 cup (250ml) ramekins with baking paper.) \n For the caramel, place sugar and 2 tbs water in a small saucepan and place over medium heat. Bring to a simmer and cook for 7 minutes or until golden, then quickly divide among 8 holes. Set aside until cool. For the caramel, place sugar and 2 tbs water in a small saucepan and place over medium heat. Bring to a simmer and cook for 7 minutes or until golden, then quickly divide among 8 holes. Set aside until cool.\n\nTo make the custard layer, place cream cheese in an electric mixer fitted with the paddle attachment and beat until smooth (alternatively, beat with electric beaters until smooth).\n\nGradually add condensed milk, egg yolks, vanilla and a pinch of salt. Divide among the 8 holes, then chill for 1 hour to firm slightly.\n\nMeanwhile, for apple sponge, melt 25g butter in a saucepan over medium heat. Add grated apple, cinnamon, 1/4 cup (55g) caster sugar and 1/4 cup (60ml) water. Cook, stirring occasionally, for 8-10 minutes until softened. Remove from heat and set aside to cool completely.\n\nPreheat oven to 160°C. Combine apple mixture, egg yolks, flour, remaining 150g butter and 1/2 cup (110g) caster sugar. Whisk eggwhites to stiff peaks, then fold into apple mixture.\n\nDivide among the 8 holes, making sure not to push apple mixture into the custard. Place pan in oven and bake for 35-40 minutes until sponge is cooked through.\n\nTo make candied apple slices, combine remaining 3/4 cup (165g) caster sugar and 2 tbs water in a frypan over medium-high heat.\n\nCook for 6-8 minutes until a golden caramel. Add apple slices and cook for 30 seconds each side or until slightly tender. Cool on a baking tray lined with baking paper. Reserve caramel in pan.\n\nCool cakes in pans for 5 minutes, then turn out onto a serving plate (some caramel will remain on the bottom of the pan or in the bottom of the ramekin).\n\nServe topped with a few slices of apple and drizzle with reserved caramel.\n');

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
(147, 7, 58, 'Dinner', 'Saturday'),
(148, 28, 58, 'Lunch', 'Sunday'),
(149, 7, 58, 'Dinner', 'Sunday'),
(162, 10, 61, 'Dinner', 'Tuesday'),
(163, 1, 61, 'Lunch', 'Monday'),
(164, 40, 61, 'Lunch', 'Thursday'),
(165, 47, 61, 'Lunch', 'Saturday'),
(166, 39, 61, 'Dinner', 'Friday'),
(172, 40, 65, 'Lunch', 'Monday'),
(173, 39, 66, 'Lunch', 'Thursday'),
(174, 40, 66, 'Lunch', 'Monday'),
(175, 47, 66, 'Dinner', 'Tuesday'),
(176, 55, 67, 'Dinner', 'Monday'),
(177, 54, 67, 'Lunch', 'Monday'),
(178, 58, 67, 'Dinner', 'Tuesday'),
(179, 55, 67, 'Lunch', 'Friday'),
(180, 62, 67, 'Dinner', 'Thursday'),
(181, 54, 67, 'Dinner', 'Friday'),
(182, 58, 67, 'Lunch', 'Saturday'),
(183, 53, 67, 'Lunch', 'Sunday'),
(184, 64, 67, 'Dinner', 'Sunday'),
(185, 56, 67, 'Dinner', 'Saturday'),
(186, 64, 67, 'Lunch', 'Wednesday'),
(187, 56, 67, 'Lunch', 'Thursday'),
(188, 62, 67, 'Lunch', 'Tuesday'),
(189, 53, 67, 'Dinner', 'Wednesday'),
(190, 58, 68, 'Lunch', 'Monday'),
(191, 55, 68, 'Lunch', 'Tuesday'),
(192, 55, 68, 'Dinner', 'Monday'),
(193, 56, 68, 'Dinner', 'Tuesday'),
(194, 62, 68, 'Dinner', 'Wednesday'),
(195, 58, 68, 'Lunch', 'Wednesday'),
(196, 56, 68, 'Dinner', 'Thursday'),
(197, 53, 68, 'Lunch', 'Thursday'),
(198, 54, 68, 'Lunch', 'Friday'),
(199, 58, 68, 'Dinner', 'Friday'),
(200, 53, 68, 'Dinner', 'Saturday'),
(201, 62, 68, 'Lunch', 'Sunday'),
(202, 54, 68, 'Dinner', 'Sunday'),
(203, 64, 68, 'Lunch', 'Saturday');

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
(1, 'administrador', 'Nieves', 'Navas', 'chachicorreo@mail.com', '658945123', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', 'http://localhost:8083/media/bollito.jpeg', 0),
(2, 'usuario', 'Usuario', 'Apellido', 'mail2@mail.com', '658945123', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 1),
(3, 'Estom0', 'Esther', 'Dominguez', 'EstDom0@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(4, 'Criim1', 'Cristina', 'Jimenez', 'CriJim1@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(5, 'Estom2', 'Esther', 'Dominguez', 'EstDom2@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(6, 'Aurom3', 'Aurora', 'Dominguez', 'AurDom3@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(7, 'Juaoz4', 'Juan', 'Lozano', 'JuaLoz4@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(8, 'Gabue5', 'Gabriel', 'Cuesta', 'GabCue5@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(9, 'prueba3', 'Pepeto', 'Prueba', 'correodeladmin@mail.com', '654987412', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 1),
(10, 'Crigu7', 'Cristina', 'Aguilar', 'CriAgu7@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(11, 'Gabue8', 'Gabriel', 'Cuesta', 'GabCue8@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(12, 'Criue9', 'Cristina', 'Cuesta', 'CriCue9@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(13, 'Gabgu10', 'Gabriel', 'Aguilar', 'GabAgu10@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(14, 'Crioz11', 'Cristina', 'Lozano', 'CriLoz11@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(15, 'Criom12', 'Cristina', 'Dominguez', 'CriDom12@ausiasmarch.net', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', NULL, 0),
(16, 'michuelo', 'michillo', 'mrmicho', 'michi@mail.micho', '654123654', 'c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261', 'C:\\fakepath\\micho.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `weekly`
--

CREATE TABLE `weekly` (
  `id` bigint(11) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  `init_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `weekly`
--

INSERT INTO `weekly` (`id`, `id_user`, `init_date`) VALUES
(67, 1, '2024-02-19'),
(68, 1, '2024-02-27');

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161;

--
-- AUTO_INCREMENT de la tabla `fav_recipe`
--
ALTER TABLE `fav_recipe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de la tabla `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `recipe`
--
ALTER TABLE `recipe`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT de la tabla `type`
--
ALTER TABLE `type`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `weekly`
--
ALTER TABLE `weekly`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
