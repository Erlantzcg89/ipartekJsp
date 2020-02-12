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


-- Volcando estructura de base de datos para ipartek
CREATE DATABASE IF NOT EXISTS `ipartek` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ipartek`;

-- Volcando estructura para tabla ipartek.asitencia
CREATE TABLE IF NOT EXISTS `asitencia` (
  `id_curso` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  UNIQUE KEY `id_curso_id_usuario` (`id_curso`,`id_usuario`),
  KEY `FK_asitencia_usuario` (`id_usuario`),
  CONSTRAINT `FK_asitencia_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `FK_asitencia_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ipartek.asitencia: ~6 rows (aproximadamente)
DELETE FROM `asitencia`;
/*!40000 ALTER TABLE `asitencia` DISABLE KEYS */;
INSERT INTO `asitencia` (`id_curso`, `id_usuario`) VALUES
	(2, 0),
	(2, 1),
	(2, 2),
	(2, 3),
	(3, 1),
	(3, 2);
/*!40000 ALTER TABLE `asitencia` ENABLE KEYS */;

-- Volcando estructura para tabla ipartek.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `finicio` varchar(100) NOT NULL DEFAULT '',
  `ffin` varchar(100) NOT NULL DEFAULT '',
  `horas` int(11) NOT NULL DEFAULT '0',
  `id_profesor` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `fkProfesor` (`id_profesor`),
  CONSTRAINT `fkProfesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ipartek.curso: ~3 rows (aproximadamente)
DELETE FROM `curso`;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`id`, `nombre`, `finicio`, `ffin`, `horas`, `id_profesor`) VALUES
	(1, 'Excel Avanzado', '2020-01-03', '2020-02-03', 20, 3),
	(2, 'Lenguaje JAVASCRIPT - Online', '2019-11-03', '2019-11-24', 50, 2),
	(3, 'Desarrollo Avanzado Web con JAVA - JEE - Hibernate', '2020-02-03', '2020-05-03', 250, 1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla ipartek.profesor
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`,`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ipartek.profesor: ~0 rows (aproximadamente)
DELETE FROM `profesor`;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`id`, `nombre`, `apellidos`) VALUES
	(1, 'Andres', 'Buruaga'),
	(3, 'Jalain', 'Molares'),
	(2, 'Javier', 'Letrado');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

-- Volcando estructura para tabla ipartek.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ipartek.usuario: ~0 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`) VALUES
	(3, 'Anastasia'),
	(2, 'Josefina'),
	(1, 'Manolito'),
	(0, 'Pepe');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla ipartek.valoraciones
CREATE TABLE IF NOT EXISTS `valoraciones` (
  `nota` int(11) DEFAULT NULL,
  `comentario` varchar(250) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fkUsuario` (`id_usuario`),
  KEY `fkCurso` (`id_curso`),
  CONSTRAINT `fkCurso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `fkUsuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla ipartek.valoraciones: ~0 rows (aproximadamente)
DELETE FROM `valoraciones`;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` (`nota`, `comentario`, `id_usuario`, `id_curso`, `id`) VALUES
	(3, 'Muy interesante y complementario con mi formacion', 1, 2, 1),
	(5, 'Me encanta', 3, 2, 2),
	(4, 'Buenisima formación, muy practico', 2, 3, 3),
	(4, 'Cuando lo empece necesitaba un trabajo urgentemente', 1, 2, 4);
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
