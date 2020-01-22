-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para supermercado
CREATE DATABASE IF NOT EXISTS `supermercado` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `supermercado`;

-- Volcando estructura para tabla supermercado.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  `imagen` varchar(200) NOT NULL DEFAULT 'https://img.icons8.com/nolan/64/update-tag.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.categoria: ~9 rows (aproximadamente)
DELETE FROM `categoria`;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`, `imagen`) VALUES
	(1, 'calzado', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(2, 'musica', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(3, 'electrodomesticos', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(4, 'higiene', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(5, 'Pescado', 'https://img.icons8.com/nolan/64/fish-scales-pattern.png'),
	(6, 'textiles', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(7, 'carniceria', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(8, 'fruteria', 'https://img.icons8.com/nolan/64/update-tag.png'),
	(9, 'juguetes', 'https://img.icons8.com/nolan/64/update-tag.png');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.historico
CREATE TABLE IF NOT EXISTS `historico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float NOT NULL DEFAULT 0,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_producto` (`id_producto`),
  CONSTRAINT `FK_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.historico: ~10 rows (aproximadamente)
DELETE FROM `historico`;
/*!40000 ALTER TABLE `historico` DISABLE KEYS */;
INSERT INTO `historico` (`id`, `precio`, `fecha`, `id_producto`) VALUES
	(1, 12, '2020-01-10 08:21:25', 8),
	(2, 12, '2020-01-10 08:21:34', 8),
	(3, 56, '2020-01-10 08:21:40', 8),
	(4, 100, '2020-01-10 08:21:52', 8),
	(5, 400, '2020-01-10 08:22:15', 8),
	(6, 400, '2020-01-10 08:22:23', 8),
	(7, 400, '2020-01-10 08:22:25', 8),
	(8, 400, '2020-01-10 08:24:02', 8),
	(9, 0, '2020-01-10 08:24:06', 8),
	(10, 1, '2020-01-10 08:24:12', 8);
/*!40000 ALTER TABLE `historico` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `precio` float NOT NULL DEFAULT 0,
  `descripcion` varchar(150) DEFAULT '',
  `descuento` int(11) NOT NULL DEFAULT 0 COMMENT 'porcentaje descuento de 0 a 100',
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_eliminacion` timestamp NULL DEFAULT NULL,
  `validado` tinyint(4) NOT NULL DEFAULT 0,
  `imagen` varchar(200) DEFAULT 'https://image.flaticon.com/icons/png/512/372/372627.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario` (`id_usuario`),
  KEY `FK_categoria` (`id_categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.producto: ~9 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `id_categoria`, `id_usuario`, `precio`, `descripcion`, `descuento`, `fecha_modificacion`, `fecha_creacion`, `fecha_eliminacion`, `validado`, `imagen`) VALUES
	(8, 'leche', 8, 1, 2, 'leche entera de asturias', 0, '2020-01-13 10:28:13', '2020-01-10 10:24:18', NULL, 1, 'https://supermercado.eroski.es/images/212878.jpg'),
	(12, 'cafe', 5, 1, 0, ' colombia 100%', 0, '2020-01-13 09:39:25', '2020-01-10 10:24:18', '2020-01-10 12:18:17', 1, 'https://supermercado.eroski.es/images/350595.jpg'),
	(21, 'turron blando', 3, 4, 0, ' almendra jijona', 0, '2020-01-13 09:39:18', '2020-01-10 10:24:18', '2020-01-10 13:42:06', 1, 'https://supermercado.eroski.es/images/17929787.jpg'),
	(22, 'gulas', 6, 1, 0, ' recien pescadas', 2, '2020-01-13 09:39:30', '2020-01-10 10:24:18', NULL, 1, 'https://supermercado.eroski.es/images/19780345.jpg'),
	(29, 'mermelada extra', 4, 1, 0, ' calidad extra', 0, '2020-01-13 09:39:22', '2020-01-10 10:24:18', NULL, 1, 'https://supermercado.eroski.es/images/330480.jpg'),
	(30, 'mermelada bebe', 7, 1, 0, 'formato familiar', 50, '2020-01-13 09:39:34', '2020-01-10 10:24:18', NULL, 0, 'https://supermercado.eroski.es/images/330480.jpg'),
	(31, 'helados magnum', 2, 1, 0, ' 4 helados chocolate', 100, '2020-01-13 09:39:15', '2020-01-10 10:24:18', NULL, 1, 'https://supermercado.eroski.es/images/20260006.jpg'),
	(36, 'huevos camperos', 1, 1, 0, ' 12 huevos de granja', 0, '2020-01-13 12:02:10', '2020-01-10 10:24:18', NULL, 0, 'https://supermercado.eroski.es/images/21176490.jpg'),
	(37, 'prueba', 9, 1, 23, 'zgdgfjhmhbj', 0, '2020-01-13 09:39:41', '2020-01-10 14:03:20', NULL, 0, 'https://image.flaticon.com/icons/png/512/372/372627.png');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '1: Usuario normal   2: Administrador',
  `nombre` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.rol: ~2 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(2, 'administrador'),
	(1, 'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `contrasenia` varchar(50) NOT NULL DEFAULT '0',
  `id_rol` int(11) DEFAULT 0,
  `imagen` varchar(200) NOT NULL DEFAULT 'http://emser.es/wp-content/uploads/2016/08/usuario-sin-foto.png',
  `email` varchar(50) DEFAULT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_modificacion` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `fecha_eliminacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_rol` (`id_rol`),
  CONSTRAINT `FK_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla supermercado.usuario: ~3 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `contrasenia`, `id_rol`, `imagen`, `email`, `fecha_creacion`, `fecha_modificacion`, `fecha_eliminacion`) VALUES
	(1, 'admin', 'admin', 2, 'https://img.icons8.com/nolan/64/data-configuration.png', NULL, '2020-01-10 10:56:21', '2020-01-10 13:01:14', NULL),
	(4, 'Dolores', 'dd', 1, 'https://img.icons8.com/nolan/64/user-female.png', 'prueba@prueba', '2020-01-10 10:56:21', '2020-01-10 13:43:35', NULL),
	(5, 'Default', 'dd', 1, 'http://emser.es/wp-content/uploads/2016/08/usuario-sin-foto.png', 'prueba@prueba.com', '2020-01-10 13:44:00', '2020-01-10 13:44:07', '2020-01-10 13:44:07');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para procedimiento supermercado.pa_categoria_delete
DELIMITER //
CREATE PROCEDURE `pa_categoria_delete`(
	IN `pId` INT
)
BEGIN

	DELETE FROM categoria WHERE id = pId;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_get_all
DELIMITER //
CREATE PROCEDURE `pa_categoria_get_all`()
BEGIN

   	-- nuestro primer PA
   	/*  tiene pinta que tambien comentarios de bloque */
    SELECT id, nombre, imagen FROM categoria ORDER BY nombre ASC LIMIT 500;
    
    -- desde java executeQuery
    -- retorna ResultSet

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_get_byid
DELIMITER //
CREATE PROCEDURE `pa_categoria_get_byid`(
	IN `pId` INT
)
BEGIN

	SELECT id, nombre, imagen FROM categoria WHERE id = pId;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_insert
DELIMITER //
CREATE PROCEDURE `pa_categoria_insert`(
	IN `p_nombre` VARCHAR(100),
	OUT `p_id` INT,
	IN `p_imagen` VARCHAR(200)
)
BEGIN

	-- crear nuevo registro
	INSERT INTO categoria ( nombre, imagen ) VALUES ( p_nombre, p_imagen );
	
	-- obtener el ID generado y SETearlo al parametro salida p_id
	SET p_id = LAST_INSERT_ID();
	

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_update
DELIMITER //
CREATE PROCEDURE `pa_categoria_update`(
	IN `p_id` INT,
	IN `p_nombre` VARCHAR(100),
	IN `p_imagen` VARCHAR(200)
)
BEGIN


	UPDATE categoria SET nombre = p_nombre, imagen = p_imagen WHERE id = p_id;
	
	-- desde java executeUpdate, retorna affectedRows int

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_productos_busqueda
DELIMITER //
CREATE PROCEDURE `pa_productos_busqueda`(
	IN `p_nombre_prod` VARCHAR(100),
	IN `p_id_cat` INT
)
BEGIN

	IF p_id_cat <> 0 THEN
		SELECT p.id AS 'id_producto', 
			p.nombre AS 'nombre_producto', 
			p.imagen AS 'imagen_producto',
			p.precio,
			p.descripcion, 
			p.descuento, 
			p.fecha_creacion AS 'fecha_creacion_producto',
			p.fecha_modificacion AS 'fecha_modificacion_producto',
			p.fecha_eliminacion AS 'fecha_eliminacion_producto', 
			c.id AS 'id_categoria', 
			c.nombre AS 'nombre_categoria', 
			u.id AS 'id_usuario',
			u.nombre AS 'nombre_usuario',
			u.contrasenia, 
			u.email AS 'email', 
			u.imagen AS 'imagen_usuario', 
			u.fecha_creacion AS 'fecha_creacion_usuario', 
			u.fecha_modificacion AS 'fecha_modificacion_usuario', 
			u.fecha_eliminacion AS 'fecha_eliminacion_usuario'
		FROM producto AS p, categoria AS c, usuario AS u
		WHERE p.id_categoria = c.id AND p.id_usuario = u.id AND  p.fecha_eliminacion IS NULL AND p.validado = '1' AND p.nombre LIKE CONCAT('%', p_nombre_prod, '%') AND c.id = p_id_cat;
		
	ELSE
		SELECT p.id AS 'id_producto', 
			p.nombre AS 'nombre_producto', 
			p.imagen AS 'imagen_producto',
			p.precio,
			p.descripcion, 
			p.descuento, 
			p.fecha_creacion AS 'fecha_creacion_producto',
			p.fecha_modificacion AS 'fecha_modificacion_producto',
			p.fecha_eliminacion AS 'fecha_eliminacion_producto', 
			c.id AS 'id_categoria', 
			c.nombre AS 'nombre_categoria', 
			u.id AS 'id_usuario',
			u.nombre AS 'nombre_usuario',
			u.contrasenia, 
			u.email AS 'email', 
			u.imagen AS 'imagen_usuario', 
			u.fecha_creacion AS 'fecha_creacion_usuario', 
			u.fecha_modificacion AS 'fecha_modificacion_usuario', 
			u.fecha_eliminacion AS 'fecha_eliminacion_usuario'
		FROM producto AS p, categoria AS c, usuario AS u
		WHERE p.id_categoria = c.id AND p.id_usuario = u.id AND  p.fecha_eliminacion IS NULL AND p.validado = '1' AND p.nombre LIKE CONCAT('%', p_nombre_prod, '%');
		
	END IF;
END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD
DELIMITER //
CREATE FUNCTION `HELLO_WORLD`() RETURNS varchar(100) CHARSET utf8
BEGIN

	RETURN "hola mundo";

END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD2
DELIMITER //
CREATE FUNCTION `HELLO_WORLD2`(`pNombre` VARCHAR(50)
) RETURNS varchar(100) CHARSET utf8
BEGIN

	DECLARE nombre VARCHAR(100) DEFAULT 'anonimo';

   IF( TRIM(pNombre) != '' ) THEN
   	SET nombre = TRIM(pNombre);
   END IF;

	--	RETURN "Hello" +  pNombre;
	RETURN CONCAT("hello"," ",nombre);

END//
DELIMITER ;

-- Volcando estructura para disparador supermercado.tau_producto_historico
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tau_producto_historico` AFTER UPDATE ON `producto` FOR EACH ROW BEGIN

	-- meter un registro en la tabla historico con el precio del producto cambiado
	
	-- comprobar que inserte solo si cambia el precio
	
	IF ( NEW.precio <> OLD.precio ) THEN
	
		INSERT INTO historico (precio, id_producto ) VALUES ( OLD.precio , OLD.id );
		
	END IF;
		

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador supermercado.tbi_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_producto` BEFORE INSERT ON `producto` FOR EACH ROW BEGIN

	/* 
		comprobar que el descuento sea entre 0 y 100 
		si descuento < 0 = 0
		si descuento > 100 = 100
	*/

	IF NEW.descuento < 0 THEN 
		SET NEW.descuento = 0; 
	END IF;
	
	IF NEW.descuento > 100 THEN 
		SET NEW.descuento = 100; 
	END IF;	

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador supermercado.tbu_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbu_producto` BEFORE UPDATE ON `producto` FOR EACH ROW BEGIN

	IF NEW.descuento < 0 THEN 
		SET NEW.descuento = 0; 
	END IF;
	

	IF NEW.descuento > 100 THEN 
		SET NEW.descuento = 100; 
	END IF;	

	-- INSERT INTO categoria (nombre) VALUE ( CONCAT(NEW.descuento, 'categoria'));

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
