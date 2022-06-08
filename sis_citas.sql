CREATE DATABASE  IF NOT EXISTS `sis_citas` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sis_citas`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: sis_citas
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'sis_citas'
--
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerCitas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerCitas`(IdUsuario Int, IdUsuarioDoctor Int, FechaCita date)
BEGIN
	SELECT 
		c.idcita, u.usuario as dni, u.idusuario,
		CONCAT(u.apellido_paterno, ' ' , u.apellido_materno ,' ' , u.nombres) as usuario,
		da.idusuariodoctor,
		CONCAT(ud.apellido_paterno, ' ' , ud.apellido_materno ,' ' , ud.nombres) as doctor,
		da.horainicio,
		da.horafin,
		t.nombre as tipocita,
		e.nombre as estado,
		da.diaatencion as fechacita,
        da.iddiasatencion
	FROM sis_citas.citas c
		inner join sis_citas.usuarios u on u.idusuario = c.idusuario
		inner join sis_citas.diasatencion da on da.iddiasatencion = c.iddiasatencion
		inner join sis_citas.estadocita e on e.idestadocita = c.idestadocita
		inner join sis_citas.tipocita t on t.idtipocita = c.idtipocita
		inner join sis_citas.usuarios ud on da.idusuariodoctor = ud.idusuario and ud.isdoctor = 1
	WHERE c.isactivo = 1 AND u.isactivo = 1
	AND  u.idusuario = ( case when IdUsuario  = 0 then u.idusuario else IdUsuario end)
	AND  da.idusuariodoctor = ( case when IdUsuarioDoctor = 0 then da.idusuariodoctor else IdUsuarioDoctor end)
	AND  da.diaatencion >= ( case when IFNULL(FechaCita, '') = '' then da.diaatencion else FechaCita end)
    ORDER BY fechacita DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerHorariosPorIdDoctor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerHorariosPorIdDoctor`(IdUsuarioDoctor INT)
BEGIN
	SELECT
	da.iddiasatencion,
    da.idusuariodoctor,
    da.diaatencion,
	CONCAT(u.nombres,' ',u.apellido_paterno,' ',u.apellido_materno) AS doctor,
	da.horainicio,
	da.horafin
FROM sis_citas.diasatencion da
INNER JOIN sis_citas.usuarios u	ON u.idusuario = da.idusuariodoctor AND u.isdoctor = 1 
WHERE da.idusuariodoctor = IdUsuarioDoctor
AND u.isactivo = true
AND da.isactivo = true
AND u.isdoctoractivo = true;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-07 23:39:47
