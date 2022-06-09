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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `idcita` int NOT NULL AUTO_INCREMENT,
  `idusuario` int NOT NULL,
  `iddiasatencion` int NOT NULL,
  `idestadocita` int NOT NULL,
  `idtipocita` int NOT NULL,
  `isactivo` bit(1) NOT NULL DEFAULT b'1',
  `fechareg` datetime DEFAULT NULL,
  `fechaupdate` datetime DEFAULT NULL,
  `usercreate` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `userupdate` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  UNIQUE KEY `idcita_UNIQUE` (`idcita`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (1,13,1,2,1,_binary '','2022-06-08 17:52:30','2022-06-08 23:27:04','04040404','00000000'),(2,13,5,1,1,_binary '','2022-06-08 18:08:44','2022-06-08 23:27:04','04040404','00000000'),(4,1,3,1,2,_binary '','2022-06-08 23:08:33','2022-06-08 23:27:04','00000000','00000000');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diasatencion`
--

DROP TABLE IF EXISTS `diasatencion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diasatencion` (
  `iddiasatencion` int NOT NULL AUTO_INCREMENT,
  `idusuariodoctor` int NOT NULL,
  `diaatencion` date NOT NULL,
  `nombredia` varchar(45) COLLATE utf8_bin NOT NULL,
  `horainicio` datetime NOT NULL,
  `horafin` datetime NOT NULL,
  `isactivo` bit(1) NOT NULL,
  `usercreate` varchar(45) COLLATE utf8_bin NOT NULL,
  `userupdate` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `fechareg` datetime NOT NULL,
  `fechaupdate` datetime DEFAULT NULL,
  PRIMARY KEY (`iddiasatencion`),
  UNIQUE KEY `iddiasatencion_UNIQUE` (`iddiasatencion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diasatencion`
--

LOCK TABLES `diasatencion` WRITE;
/*!40000 ALTER TABLE `diasatencion` DISABLE KEYS */;
INSERT INTO `diasatencion` VALUES (1,10,'2022-06-20','LUNES','2022-06-20 09:30:27','2022-06-20 10:00:27',_binary '\0','00000000','00000000','2022-06-08 17:51:25','2022-06-08 23:27:04'),(2,10,'2022-06-20','LUNES','2022-06-20 10:00:27','2022-06-20 10:30:27',_binary '','00000000','00000000','2022-06-08 17:51:25','2022-06-08 17:51:25'),(3,10,'2022-06-20','LUNES','2022-06-20 10:30:27','2022-06-20 11:00:27',_binary '\0','00000000','00000000','2022-06-08 17:51:25','2022-06-08 23:27:04'),(4,10,'2022-06-29','MIERCOLES','2022-06-29 15:00:00','2022-06-29 15:30:00',_binary '','00000000','00000000','2022-06-08 17:53:23','2022-06-08 17:53:23'),(5,10,'2022-06-29','MIERCOLES','2022-06-29 15:30:00','2022-06-29 16:00:00',_binary '\0','00000000','00000000','2022-06-08 17:53:23','2022-06-08 23:27:04'),(6,11,'2022-06-28','MARTES','2022-06-28 11:00:13','2022-06-28 11:30:13',_binary '','00000000','00000000','2022-06-08 23:16:33','2022-06-08 23:16:33'),(7,11,'2022-06-28','MARTES','2022-06-28 11:30:13','2022-06-28 12:00:13',_binary '','00000000','00000000','2022-06-08 23:16:33','2022-06-08 23:16:33'),(8,11,'2022-06-28','MARTES','2022-06-28 12:00:13','2022-06-28 12:30:13',_binary '','00000000','00000000','2022-06-08 23:16:33','2022-06-08 23:16:33'),(9,11,'2022-08-16','MARTES','2022-08-16 10:30:10','2022-08-16 11:00:10',_binary '','00000000','00000000','2022-06-08 23:25:41','2022-06-08 23:25:41'),(10,11,'2022-08-16','MARTES','2022-08-16 11:00:10','2022-08-16 11:30:10',_binary '','00000000','00000000','2022-06-08 23:25:41','2022-06-08 23:25:41'),(11,11,'2022-08-16','MARTES','2022-08-16 11:30:10','2022-08-16 12:00:10',_binary '','00000000','00000000','2022-06-08 23:25:41','2022-06-08 23:25:41');
/*!40000 ALTER TABLE `diasatencion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocita`
--

DROP TABLE IF EXISTS `estadocita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadocita` (
  `idestadocita` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `isactivo` bit(1) NOT NULL DEFAULT b'1',
  `usercreate` varchar(45) COLLATE utf8_bin NOT NULL,
  `userupdate` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `fechareg` varchar(45) COLLATE utf8_bin NOT NULL,
  `fechaupdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idestadocita`),
  UNIQUE KEY `idestadocita_UNIQUE` (`idestadocita`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocita`
--

LOCK TABLES `estadocita` WRITE;
/*!40000 ALTER TABLE `estadocita` DISABLE KEYS */;
INSERT INTO `estadocita` VALUES (1,'RESERVADO',_binary '','admin',NULL,'2022-05-11 00:00:00',NULL),(2,'PAGADO',_binary '','admin',NULL,'2022-05-11 00:00:00',NULL),(3,'CANCELADO',_binary '','admin',NULL,'2022-05-11 00:00:00',NULL);
/*!40000 ALTER TABLE `estadocita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocita`
--

DROP TABLE IF EXISTS `tipocita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocita` (
  `idtipocita` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `isactivo` bit(1) DEFAULT NULL,
  `regcreate` datetime DEFAULT NULL,
  `regupdate` datetime DEFAULT NULL,
  `usercreate` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `userupdate` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idtipocita`),
  UNIQUE KEY `idtipocita_UNIQUE` (`idtipocita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocita`
--

LOCK TABLES `tipocita` WRITE;
/*!40000 ALTER TABLE `tipocita` DISABLE KEYS */;
INSERT INTO `tipocita` VALUES (1,'CONSULTA',50.99,_binary '',NULL,NULL,'',NULL),(2,'TRATAMIENTO',350.00,_binary '',NULL,NULL,'',NULL);
/*!40000 ALTER TABLE `tipocita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) CHARACTER SET utf8 NOT NULL,
  `apellido_paterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellido_materno` varchar(45) COLLATE utf8_bin NOT NULL,
  `sexo` char(1) CHARACTER SET utf8 NOT NULL,
  `direccion` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `correo` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telefono` int NOT NULL,
  `usuario` varchar(45) CHARACTER SET utf8 NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `colegiatura` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nombrecompleto` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `isactivo` bit(1) NOT NULL DEFAULT b'1',
  `isdoctor` bit(1) NOT NULL DEFAULT b'0',
  `isdoctoractivo` bit(1) DEFAULT b'1',
  `isadmin` bit(1) NOT NULL DEFAULT b'0',
  `fecha_nacimiento` datetime NOT NULL,
  `usercreate` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userupdate` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fechareg` datetime NOT NULL,
  `fechaupdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ADMIN','ADMIN','ADMIN','M','calle admin admin','admin@gmail.com',934550250,'00000000','$2a$10$x7T1mmBd6whfsoZ3X4T/bOdDuXM6fyiB.TpEsgkcjUQBcCbXUpn4K',NULL,'ADMINISTRADOR DE SISTEMAS',_binary '',_binary '\0',_binary '\0',_binary '','1994-05-17 00:00:00','75532647','75532647','2022-05-13 11:03:06','2022-06-07 23:27:20'),(10,'GABRIEL AUGUSTO','COSTA','REYES','M','CALLE SANTO DOMINGO SIN NUMERO','gacosta@salud.com',999999999,'01010101','$2a$10$NcHG7jLuqMI3qwEJWFf9d.1VRt5ch1iw3jEqIzXhQfhN1t2sTTlC6','AB 1203','GABRIEL AUGUSTO COSTA REYES',_binary '',_binary '',_binary '',_binary '\0','2022-06-07 00:00:00','75532647','75532647','2022-06-08 17:00:15','2022-06-08 17:00:15'),(11,'JAZMIN','OLIVERA','TOLER','F','san miguel 9081','jazmino@gmail.com',999999999,'02020202','$2a$10$M3FjuI/JoQl.JvTCKyaN0ekpDNE8zXPUfSAl3TP2utB1Gcv76D/O6','MP 12020','JAZMIN OLIVERA TOLER',_binary '',_binary '',_binary '',_binary '\0','2022-06-27 00:00:00','00000000','00000000','2022-06-08 17:09:09','2022-06-08 17:09:09'),(12,'PEDRO ALDAIR','CALDERON','HUAMAN','M','lima metropolitana','pepe@gmail.com',568980651,'03030303','$2a$10$uQrwI7MiPwDZz3bxUBTER.agDwz.4Q03GJ8nGw4ahdYeIyuEgcWfi',NULL,'PEDRO ALDAIR CALDERON HUAMAN',_binary '',_binary '\0',_binary '\0',_binary '\0','2022-06-23 00:00:00','anonymousUser','anonymousUser','2022-06-08 17:18:42','2022-06-08 17:18:42'),(13,'JUAN ALFONSO','CACERES','MEDINA','M','san agustin 123','juan@gmail.com',150189871,'04040404','$2a$10$o.2XO2AY6mXnOzFeEIOuY.MAuYTGKAtUc82T41UjM7LShmwFX1yWy',NULL,'JUAN ALFONSO CACERES MEDINA',_binary '',_binary '\0',_binary '\0',_binary '\0','2022-03-22 00:00:00','anonymousUser','anonymousUser','2022-06-08 17:19:31','2022-06-08 17:19:31');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

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
        t.idtipocita,
		e.nombre as estado,
        e.idestadocita,
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerHorariosPorIdDoctor`(IdUsuarioDoctor INT, FechaCita Date)
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
WHERE  u.isactivo = true AND da.isactivo = true AND u.isdoctoractivo = true
AND  da.idusuariodoctor = ( case when IdUsuarioDoctor = 0 then da.idusuariodoctor else IdUsuarioDoctor end)
AND  da.diaatencion = ( case when IFNULL(FechaCita, '') = '' then da.diaatencion else FechaCita end);

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

-- Dump completed on 2022-06-08 23:30:10
