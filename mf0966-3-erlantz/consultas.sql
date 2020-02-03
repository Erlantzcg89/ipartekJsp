-- listar los ultimos 5 cursos

SELECT id ,nombre, finicio 'inicio', ffin 'fin' FROM curso ORDER BY finicio DESC LIMIT 5;

-- listar 5 últimos cursos creados

SELECT id ,nombre, finicio 'inicio', ffin 'fin' FROM curso ORDER BY id DESC LIMIT 5;

-- detalle del curso más número de reseñas

SELECT c.id , c.nombre, c.finicio 'inicio', c.ffin 'fin', c.horas 'horas', c.id_profesor 'profe', COUNT(nombre) AS 'cantidad de reseñas' FROM curso c, valoraciones v WHERE v.id_curso=c.id GROUP BY c.id;

-- listado de usuarios ordenado por número de reseñas

SELECT u.nombre 'nombre_usuario', COUNT(nombre) 'valoraciones realizadas' FROM usuario u, valoraciones v WHERE v.id_usuario=u.id GROUP BY u.id;

-- resumen de numero de cursos cada año

SELECT COUNT(nombre) 'cursos', year(finicio) 'año' FROM curso GROUP BY YEAR(finicio);