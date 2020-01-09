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


-- Volcando estructura de base de datos para supermercado
CREATE DATABASE IF NOT EXISTS `supermercado` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `supermercado`;

-- Volcando estructura para tabla supermercado.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla supermercado.categoria: ~13 rows (aproximadamente)
DELETE FROM `categoria`;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(3, 'electrodomesticos'),
	(4, 'juguetes'),
	(6, 'mock1578485059961'),
	(7, 'mock1578485211565'),
	(8, 'mock1578485289373'),
	(9, 'mock1578485292373'),
	(10, 'mock1578485338977'),
	(11, 'mock1578485356862'),
	(12, 'mock1578485380652'),
	(13, 'mock1578485407497'),
	(1, 'mock1578560834801'),
	(2, 'musica'),
	(5, 'ropa');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.historico_producto
CREATE TABLE IF NOT EXISTS `historico_producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL DEFAULT '0',
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `precio` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_produto` (`id_producto`),
  CONSTRAINT `fk_produto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla supermercado.historico_producto: ~0 rows (aproximadamente)
DELETE FROM `historico_producto`;
/*!40000 ALTER TABLE `historico_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_producto` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `id_categoria` int(11) NOT NULL DEFAULT '0',
  `precio` float NOT NULL DEFAULT '0',
  `imagen` varchar(150) DEFAULT '',
  `descripcion` varchar(150) NOT NULL DEFAULT '',
  `descuento` int(11) NOT NULL DEFAULT '0',
  `id_usuario` int(11) NOT NULL DEFAULT '0',
  `fecha_modificado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario` (`id_usuario`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.producto: ~45 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `id_categoria`, `precio`, `imagen`, `descripcion`, `descuento`, `id_usuario`, `fecha_modificado`, `fecha_alta`, `fecha_baja`) VALUES
	(1, 'Leche semidesnatada mejorada', 1, 2, 'https://supermercado.eroski.es/images/212878.jpg', 'Leche semidesnatada KAIKU, brik 1 litro', 50, 2, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(2, 'Cafe', 2, 2.5, 'https://supermercado.eroski.es/images/350595.jpg', 'Cafe molido natural FORTALEZA, paquete 250 g', 10, 4, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(4, 'Turron blando', 3, 2.3, 'https://supermercado.eroski.es/images/17929787.jpg', 'Turron blando EROSKI, caja 250 g', 20, 9, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(5, 'Gulas', 3, 5, 'https://supermercado.eroski.es/images/19780345.jpg', 'Gulas del norte congeladas LA GULA DEL NORTE, bandeja 200 g', 10, 4, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(8, 'Leche', 3, 0.7, 'https://supermercado.eroski.es/images/18672311.jpg', 'Leche semidesnatada del PaÍs Vasco EROSKI, brik 1 litro', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(9, 'Mermelada melocotón', 2, 1.9, 'https://supermercado.eroski.es/images/330480.jpg', 'Mermelada de melocotón BEBÉ, frasco 340 g', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(10, 'Helado', 2, 5, 'https://supermercado.eroski.es/images/20260006.jpg', 'Bombón mini clásico-almendrado-blanco MAGNUN, caja 266 g', 30, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(11, 'Queso', 2, 11.4, 'https://supermercado.eroski.es/images/15962624.jpg', 'Queso natural D.O. Idiazabal BAGA, cuña 550 g', 25, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(12, 'Huevos', 1, 2.4, 'https://supermercado.eroski.es/images/21176490.jpg', 'Huevo suelo M/L Pais Vasco EROSKI, cartón 18 uds.', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(13, 'Tomates', 1, 2.5, 'https://supermercado.eroski.es/images/7039522.jpg', 'Tomate EUSKO LABEL, al peso, compra minima 500 g', 15, 8, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(14, 'lechuga', 1, 1, 'https://supermercado.eroski.es/images/16491052.jpg', 'Lechuga Batavia del PaÃ­s Vasco, unidad', 0, 8, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(15, 'Turron de almendras', 2, 1.6, 'https://supermercado.eroski.es/images/17930009.jpg', 'Turron crujiente con almendras', 5, 9, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(16, 'Gulas con gambas', 1, 5, 'https://supermercado.eroski.es/images/9202854.jpg', 'Gulas con gambas congeladas LA GULA DEL NORTE, bandeja 250 g', 15, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(17, 'Turron de chocolate', 2, 2.5, 'https://supermercado.eroski.es/images/22615017.jpg', 'Turron crujiente de chocolate negro EL ALMENDRO, tableta 280 g', 20, 9, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(18, 'Zumo de naranja', 1, 2.8, 'https://supermercado.eroski.es/images/13899539.jpg', 'Zumo de naranja exprimido sin pulpa ZÜ PREMIUM, brik 2 litros', 15, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(19, 'Yogur', 1, 1.1, 'https://supermercado.eroski.es/images/204420.jpg', 'Yogur sabor a fresa DANONE, pack 4x125 g', 5, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(20, 'Mermelada albaricoque', 1, 1.9, 'https://supermercado.eroski.es/images/330456.jpg', 'Mermelada de albaricoque BEBÉ, frasco 340 g', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(21, 'Tarta', 1, 12, 'https://supermercado.eroski.es/images/13625074.jpg', 'Tarta Sacher Eroski SELEQTIA, 960 g', 15, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(22, 'Mayonesa', 1, 3, 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201909/05/00118014301578____3__600x600.jpg', 'HELLMANNS vegana frasco 578 g', 10, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(23, 'Manzanas', 1, 1.6, 'https://supermercado.eroski.es/images/11155.jpg', 'Manzana Golden, al peso, compra mÃ­nima 1 kg', 15, 8, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(24, 'Tomate frito', 1, 1.3, 'https://supermercado.eroski.es/images/11191715.jpg', 'Tomate frito ORLANDO, pack 3x212 g', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(27, 'Roscon de reyes', 1, 6, 'https://supermercado.eroski.es/images/10470862.jpg', 'Roscon vacio EROSKI, 430 g', 15, 9, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(28, 'Zumo de piña', 1, 0.7, 'https://supermercado.eroski.es/images/19539220.jpg', 'Bebida de piña-manzana-uva EROSKI, brik 1 litro', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(30, 'Mermelada de fresa', 1, 1.9, 'https://supermercado.eroski.es/images/330472.jpg', 'Mermelada de fresa BEBÉ, frasco 340 g', 15, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(35, 'Tortilla de patata', 1, 3.8, 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201706/14/00118851000663____1__600x600.jpg', 'PALACIOS tortilla de patata casera con cebolla sin gluten sin lactosa envase 650 g', 35, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(36, 'Cafe con leche', 1, 4.3, 'https://supermercado.eroski.es/images/13915053.jpg', 'Café con leche NESCAFÉ Dolce Gusto, caja 16 monodosis', 20, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(37, 'Patatas', 1, 1.7, 'https://supermercado.eroski.es/images/12043717.jpg', 'Patata SelecciÃ³n, al peso, compra mÃ­nima 1 kg', 30, 8, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(38, 'Donetes', 1, 1.8, 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201905/03/00120671600839____1__600x600.jpg', 'DONETTES clásicos de chocolate estuche 7 unidades + 1 gratis', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(40, 'Te', 1, 3.3, 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201701/24/00120648300083____3__600x600.jpg', 'TWININGS té English Breakfast estuche 25 bolsitas', 20, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(41, 'Azucar', 1, 0.7, 'https://supermercado.eroski.es/images/2453884.jpg', 'Azúcar blanco, paquete 1 kg', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(43, 'mock', 1, 10, 'https://image.flaticon.com/icons/png/512/372/372627.png', 'lorem', 100, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(44, 'Sal', 2, 1, 'https://supermercado.eroski.es/images/917372.jpg', 'Sal marina fina, paquete 1 kg', 25, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(45, 'Donetes rayados', 2, 1.8, 'https://supermercado.eroski.es/images/1372721.jpg', 'Donettes rayados DONETTES, 7 uds., paquete 151 g', 15, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(46, 'Aceite', 3, 2.7, 'https://supermercado.eroski.es/images/355909.jpg', 'Aceite de oliva 0,4Âº OLILAN, botella 1 litro', 20, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(47, 'Harina', 3, 1.1, 'https://supermercado.eroski.es/images/383810.jpg', 'Harina de reposterÃ­a GALLO, paquete 1 kg', 40, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(48, 'Pan', 2, 0.8, 'https://supermercado.eroski.es/images/1106434.jpg', 'Barra grande, 330 g', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(51, 'Nueces', 2, 5.2, 'https://supermercado.eroski.es/images/17520610.jpg', 'Nuez del País Vasco, al peso, compra mínima 500 g', 30, 2, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(54, 'Empanadillas', 3, 0.8, 'https://supermercado.eroski.es/images/227272.jpg', 'Empanadillas de atÃºn EROSKI basic, bandeja 250 g', 15, 2, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(55, 'Croissant ', 3, 2.4, 'https://supermercado.eroski.es/images/13198098.jpg', 'Croissant curvo, 4+1 uds. GRATIS, bandeja 330 g', 15, 2, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(57, 'Colacao', 3, 7, 'https://supermercado.eroski.es/images/8473902.jpg', 'Cacao soluble COLA CAO, ecobolsa 1,2 kg', 15, 4, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(58, 'Uvas', 3, 3.3, 'https://supermercado.eroski.es/images/17778762.jpg', 'Uva blanca sin semilla, cubeta 500 g', 15, 4, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(60, 'Mazapan', 1, 7, 'https://supermercado.eroski.es/images/21417050.jpg', 'Mazapan de caramelo-arandanos CASA ECEIZA, bandeja 250 g', 20, 9, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(61, 'Lentejas', 1, 3, 'https://supermercado.eroski.es/images/5215.jpg', 'Lenteja pardina extra LUENGO, paquete 1 kg', 30, 8, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(62, 'Producto de prueba 1', 1, 10, 'https://image.flaticon.com/icons/png/512/372/372627.png', 'Producto de prueba 1', 10, 4, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41'),
	(63, 'morcilla', 1, 7.77, '', '', 0, 1, '0000-00-00 00:00:00', '2020-01-09 13:10:41', '2020-01-09 13:10:41');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '1: Usuario normal  2: Administrador',
  `nombre` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `id_rol` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_rol` (`id_rol`),
  CONSTRAINT `FK_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.usuario: ~8 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `contrasenia`, `id_rol`) VALUES
	(1, 'admin', '123456', 2),
	(2, 'Dolores', '56789', 1),
	(4, 'Pepe', 'Pepe', 1),
	(5, 'administrador', 'administrador', 2),
	(8, 'huerta', 'huerta', 1),
	(9, 'navidad', 'navidad', 1),
	(18, 'nuevo', 'nuevo', 1),
	(19, 'nuevoNuevo', 'nuevoNuevo', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para procedimiento supermercado.pa_categoria_delete
DELIMITER //
CREATE PROCEDURE `pa_categoria_delete`(
	IN `p_id` INT
)
BEGIN

	DELETE FROM categoria WHERE id = p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getall
DELIMITER //
CREATE PROCEDURE `pa_categoria_getall`()
BEGIN

	-- nuestro primer pa
	SELECT id, nombre FROM categoria ORDER BY nombre asc LIMIT 500;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getbyid
DELIMITER //
CREATE PROCEDURE `pa_categoria_getbyid`(
	IN `p_id` INT
)
BEGIN

	SELECT id, nombre FROM categoria WHERE id = p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_insert
DELIMITER //
CREATE PROCEDURE `pa_categoria_insert`(
	IN `p_nombre` VARCHAR(100),
	OUT `p_id` INT
)
BEGIN

	-- crear nuevo registro
	INSERT INTO categoria (nombre) VALUES (p_nombre);
	
	-- retornar el id y setearlo al parametro salida p_id
	SET p_id = LAST_INSERT_ID();

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_update
DELIMITER //
CREATE PROCEDURE `pa_categoria_update`(
	IN `p_id` INT,
	IN `p_nombre` VARCHAR(100)
)
BEGIN

	UPDATE categoria SET nombre = p_nombre WHERE id = p_id;

END//
DELIMITER ;

-- Volcando estructura para función supermercado.Fechas
DELIMITER //
CREATE FUNCTION `Fechas`() RETURNS int(11)
    NO SQL
BEGIN

	

	-- SELECT @@lc_time_name
	RETURN 3;

END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD
DELIMITER //
CREATE FUNCTION `HELLO_WORLD`(
	`pNombre` VARCHAR(100)
) RETURNS varchar(100) CHARSET utf8
    NO SQL
    DETERMINISTIC
BEGIN

	declare nombre VARCHAR(100) DEFAULT 'anonimo';
	
	if(trim(pNombre) != '') then
		SET nombre = TRIM(pNombre);
	END if;
	
	RETURN CONCAT("Hola ", nombre);

END//
DELIMITER ;

-- Volcando estructura para función supermercado.MES
DELIMITER //
CREATE FUNCTION `MES`(
	`pFecha` DATE
) RETURNS varchar(25) CHARSET utf8
    NO SQL
    DETERMINISTIC
BEGIN

-- devuelve el mes en castellano. recibe la pFecha tipo date

	CASE MONTH(pfecha)
		WHEN 1 THEN RETURN "Enero";
		WHEN 2 THEN RETURN "Febrero";
		WHEN 3 THEN RETURN "Marzo";
		WHEN 4 THEN RETURN "Abril";
		WHEN 5 THEN RETURN "Mayo";
		WHEN 6 THEN RETURN "Junio";
		WHEN 7 THEN RETURN "Julio";
		WHEN 8 THEN RETURN "Agosto";
		WHEN 9 THEN RETURN "Septiembre";
		WHEN 10 THEN RETURN "Octubre";
		WHEN 11 THEN RETURN "Noviembre";
		ELSE RETURN "Diciembre";
	END CASE;

END//
DELIMITER ;

-- Volcando estructura para disparador supermercado.tbi_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_producto` BEFORE INSERT ON `producto` FOR EACH ROW BEGIN

	/*
		comprobar que el descuento sea entre 0 y 100
	*/

	if NEW.descuento < 0 then
		set NEW.descuento = 0;
	END if;
	
	if NEW.descuento >100 then
		set NEW.descuento = 100;
	END if;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador supermercado.tbu_producto
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbu_producto` BEFORE UPDATE ON `producto` FOR EACH ROW BEGIN

	/*
		comprobar que el descuento sea entre 0 y 100
	*/

	if NEW.descuento < 0 then
		set NEW.descuento = 0;
	END if;
	
	if NEW.descuento >100 then
		set NEW.descuento = 100;
	END if;
	
	if NEW.precio <> OLD.precio then
		insert into historico (id_producto, fecha, precio) values (new.id, NOW(), NEW.precio);
	END if;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
