-- --------------------------------------------------------
-- Host:                         192.168.0.1
-- Versión del servidor:         10.4.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para procedimiento supermercado.pa_categoria_delete
DROP PROCEDURE IF EXISTS `pa_categoria_delete`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_delete`(
	IN `pId` INT
)
BEGIN

	DELETE FROM categoria WHERE id = pId;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_get_all
DROP PROCEDURE IF EXISTS `pa_categoria_get_all`;
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
DROP PROCEDURE IF EXISTS `pa_categoria_get_byid`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_get_byid`(
	IN `pId` INT
)
BEGIN

	SELECT id, nombre, imagen FROM categoria WHERE id = pId;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_insert
DROP PROCEDURE IF EXISTS `pa_categoria_insert`;
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
DROP PROCEDURE IF EXISTS `pa_categoria_update`;
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
DROP PROCEDURE IF EXISTS `pa_productos_busqueda`;
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

-- Volcando estructura para procedimiento supermercado.pa_producto_get_all
DROP PROCEDURE IF EXISTS `pa_producto_get_all`;
DELIMITER //
CREATE PROCEDURE `pa_producto_get_all`()
BEGIN

	SELECT 
		p.id AS 'id_producto',
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
		FROM producto p, categoria c, usuario u 
		WHERE p.fecha_eliminacion IS NULL AND p.id_usuario = u.id AND c.id = p.id_categoria AND p.validado = '1'
		ORDER BY p.id DESC LIMIT 500;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_producto_get_all_by_user
DROP PROCEDURE IF EXISTS `pa_producto_get_all_by_user`;
DELIMITER //
CREATE PROCEDURE `pa_producto_get_all_by_user`(
	IN `p_id_user` INT
)
BEGIN

	SELECT 
		p.id AS 'id_producto', 
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
	FROM producto p, categoria c, usuario u 
	WHERE p.fecha_eliminacion IS NULL AND p.id_usuario = u.id AND c.id = p.id_categoria AND p.id_usuario = p_id_user
	ORDER BY p.id DESC LIMIT 500;

END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_producto_get_all_inactive
DROP PROCEDURE IF EXISTS `pa_producto_get_all_inactive`;
DELIMITER //
CREATE PROCEDURE `pa_producto_get_all_inactive`()
BEGIN

SELECT 
	p.id AS 'id_producto', 
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
FROM producto p, categoria c, usuario u 
WHERE p.fecha_eliminacion IS NOT NULL AND p.id_usuario = u.id AND c.id = p.id_categoria
ORDER BY p.id DESC LIMIT 500;

END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
