-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.18 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para pokemon_db
DROP DATABASE IF EXISTS `pokemon_db`;
CREATE DATABASE IF NOT EXISTS `pokemon_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokemon_db`;

-- Volcando estructura para tabla pokemon_db.habilidades
DROP TABLE IF EXISTS `habilidades`;
CREATE TABLE IF NOT EXISTS `habilidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla pokemon_db.habilidades: ~7 rows (aproximadamente)
DELETE FROM `habilidades`;
/*!40000 ALTER TABLE `habilidades` DISABLE KEYS */;
INSERT INTO `habilidades` (`id`, `nombre`) VALUES
	(6, 'ascua'),
	(5, 'electricidad estatica'),
	(2, 'foco interno'),
	(7, 'hedor'),
	(1, 'impasible'),
	(3, 'justiciero'),
	(4, 'para rayos');
/*!40000 ALTER TABLE `habilidades` ENABLE KEYS */;

-- Volcando estructura para tabla pokemon_db.pokemons
DROP TABLE IF EXISTS `pokemons`;
CREATE TABLE IF NOT EXISTS `pokemons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla pokemon_db.pokemons: ~8 rows (aproximadamente)
DELETE FROM `pokemons`;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` (`id`, `nombre`) VALUES
	(20, 'Alejandro Pepito'),
	(4, 'bulbasaur'),
	(3, 'charmander'),
	(10, 'Erlantz Caballero'),
	(1, 'lucario'),
	(2, 'pikachu'),
	(21, 'Super Sayan Mortal');
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;

-- Volcando estructura para tabla pokemon_db.pokemons_habilidades
DROP TABLE IF EXISTS `pokemons_habilidades`;
CREATE TABLE IF NOT EXISTS `pokemons_habilidades` (
  `id_pokemon` int(11) NOT NULL DEFAULT '0',
  `id_habilidad` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_pokemon`,`id_habilidad`),
  KEY `fkHabilidad` (`id_habilidad`),
  CONSTRAINT `fkHabilidad` FOREIGN KEY (`id_habilidad`) REFERENCES `habilidades` (`id`),
  CONSTRAINT `fkPokemon` FOREIGN KEY (`id_pokemon`) REFERENCES `pokemons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla pokemon_db.pokemons_habilidades: ~21 rows (aproximadamente)
DELETE FROM `pokemons_habilidades`;
/*!40000 ALTER TABLE `pokemons_habilidades` DISABLE KEYS */;
INSERT INTO `pokemons_habilidades` (`id_pokemon`, `id_habilidad`) VALUES
	(1, 1),
	(3, 1),
	(4, 1),
	(21, 1),
	(1, 2),
	(21, 2),
	(1, 3),
	(3, 3),
	(20, 3),
	(21, 3),
	(2, 4),
	(20, 4),
	(21, 4),
	(2, 5),
	(21, 5),
	(3, 6),
	(20, 6),
	(21, 6),
	(4, 7),
	(21, 7);
/*!40000 ALTER TABLE `pokemons_habilidades` ENABLE KEYS */;

-- Volcando estructura para tabla pokemon_db.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT '',
  `password` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla pokemon_db.usuarios: ~0 rows (aproximadamente)
DELETE FROM `usuarios`;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `nombre`, `password`) VALUES
	(1, 'admin', 'admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
