-- Volcando estructura de base de datos para supermercado
-- chekear noooooommmbreeee!!!!!!!!!!!!!!!!!!
DROP DATABASE IF EXISTS `eroski`;
CREATE DATABASE IF NOT EXISTS `eroski` DEFAULT CHARACTER SET utf8;
USE `eroski`;

-- Volcando estructura para tabla supermercado.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `contrasenia` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
INSERT INTO `usuario` (`id`, `nombre`, `contrasenia`) VALUES
	(1, 'admin', '123456'),
	(4, 'Dolores', '56789');

-- Volcando estructura para tabla supermercado.producto
DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario` (`id_usuario`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.producto: ~5 rows (aproximadamente)
DELETE FROM `producto`;
INSERT INTO `producto` (`id`, `nombre`, `id_usuario`) VALUES
	(8, 'donetes', 1),
	(10, 'galletas3', 1),
	(12, 'donetes2', 1),
	(17, 'donetes rallados', 4);



