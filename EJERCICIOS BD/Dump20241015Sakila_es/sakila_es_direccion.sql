CREATE DATABASE  IF NOT EXISTS `sakila_es` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sakila_es`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sakila_es
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `id_direccion` smallint unsigned NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  `direccion2` varchar(50) DEFAULT NULL,
  `distrito` varchar(20) NOT NULL,
  `id_ciudad` smallint unsigned NOT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `ultima_actualizacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_direccion`),
  KEY `idx_fk_id_ciudad` (`id_ciudad`),
  CONSTRAINT `fk_direccion_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,'47 MySakila Drive',NULL,'Alberta',300,'','','2014-09-26 01:30:27'),(2,'28 MySQL Boulevard',NULL,'QLD',576,'','','2014-09-26 01:30:09'),(3,'23 Workhaven Lane',NULL,'Alberta',300,'','14033335568','2014-09-26 01:30:27'),(4,'1411 Lillydale Drive',NULL,'QLD',576,'','6172235589','2014-09-26 01:30:09'),(5,'1913 Hanoi Way','','Nagasaki',463,'35200','28303384290','2014-09-26 01:31:53'),(6,'1121 Loja Avenue','','California',449,'17886','838635286649','2014-09-26 01:34:01'),(7,'692 Joliet Street','','Attika',38,'83579','448477190408','2014-09-26 01:31:07'),(8,'1566 Inegl Manor','','Mandalay',349,'53561','705814003527','2014-09-26 01:32:18'),(9,'53 Idfu Parkway','','Nantou',361,'42399','10655648674','2014-09-26 01:33:16'),(10,'1795 Santiago de Compostela Way','','Texas',295,'18743','860452626434','2014-09-26 01:33:55'),(11,'900 Santiago de Compostela Parkway','','Central Serbia',280,'93896','716571220373','2014-09-26 01:34:11'),(12,'478 Joliet Way','','Hamilton',200,'77948','657282285970','2014-09-26 01:32:22'),(13,'613 Korolev Drive','','Masqat',329,'45844','380657522649','2014-09-26 01:32:29'),(14,'1531 Sal Drive','','Esfahan',162,'53628','648856936185','2014-09-26 01:31:36'),(15,'1542 Tarlac Parkway','','Kanagawa',440,'1027','635297277345','2014-09-26 01:31:53'),(16,'808 Bhopal Manor','','Haryana',582,'10672','465887807014','2014-09-26 01:31:30'),(17,'270 Amroha Parkway','','Osmaniye',384,'29610','695479687538','2014-09-26 01:33:27'),(18,'770 Bydgoszcz Avenue','','California',120,'16266','517338314235','2014-09-26 01:33:47'),(19,'419 Iligan Lane','','Madhya Pradesh',76,'72878','990911107354','2014-09-26 01:31:13'),(20,'360 Toulouse Parkway','','England',495,'54308','949312333307','2014-09-26 01:33:40'),(21,'270 Toulon Boulevard','','Kalmykia',156,'81766','407752414682','2014-09-26 01:32:48'),(22,'320 Brest Avenue','','Kaduna',252,'43331','747791594069','2014-09-26 01:32:25'),(23,'1417 Lancaster Avenue','','Northern Cape',267,'72192','272572357893','2014-09-26 01:33:03'),(24,'1688 Okara Way','','Nothwest Border Prov',327,'21954','144453869132','2014-09-26 01:32:30'),(25,'262 A Corua (La Corua) Parkway','','Dhaka',525,'34418','892775750063','2014-09-26 01:30:12'),(26,'28 Charlotte Amalie Street','','Rabat-Sal-Zammour-Z',443,'37551','161968374323','2014-09-26 01:32:16'),(27,'1780 Hino Boulevard','','Liepaja',303,'7716','902731229323','2014-09-26 01:31:58'),(28,'96 Tafuna Way','','Crdoba',128,'99865','934730187245','2014-09-26 01:30:05'),(29,'934 San Felipe de Puerto Plata Street','','Sind',472,'99780','196495945706','2014-09-26 01:32:31'),(30,'18 Duisburg Boulevard','','',121,'58327','998009777982','2014-09-26 01:31:08'),(31,'217 Botshabelo Place','','Southern Mindanao',138,'49521','665356572025','2014-09-26 01:32:36'),(32,'1425 Shikarpur Manor','','Bihar',346,'65599','678220867005','2014-09-26 01:31:20'),(33,'786 Aurora Avenue','','Yamaguchi',474,'65750','18461860151','2014-09-26 01:31:53'),(34,'1668 Anpolis Street','','Taipei',316,'50199','525255540978','2014-09-26 01:33:15'),(35,'33 Gorontalo Way','','West Bengali',257,'30348','745994947458','2014-09-26 01:31:18'),(36,'176 Mandaluyong Place','','Uttar Pradesh',239,'65213','627705991774','2014-09-26 01:31:17'),(37,'127 Purnea (Purnia) Manor','','Piemonte',17,'79388','911872220378','2014-09-26 01:31:42'),(38,'61 Tama Street','','Okayama',284,'94065','708403338270','2014-09-26 01:31:49'),(39,'391 Callao Drive','','Midi-Pyrnes',544,'34021','440512153169','2014-09-26 01:31:01'),(40,'334 Munger (Monghyr) Lane','','Markazi',31,'38145','481183273622','2014-09-26 01:31:36'),(41,'1440 Fukuyama Loop','','Henan',362,'47929','912257250465','2014-09-26 01:30:40'),(42,'269 Cam Ranh Parkway','','Chisinau',115,'34689','489783829737','2014-09-26 01:32:15'),(43,'306 Antofagasta Place','','Esprito Santo',569,'3989','378318851631','2014-09-26 01:30:23'),(44,'Rúa Nova 16','','',459,'15706','981252525','2021-05-21 00:25:00'),(45,'Rúa Nova 20','','',459,'15706','981242424','2021-05-21 00:26:00'),(46,'C/ Javier Sanz','','',459,'04004','950155161','2021-05-21 00:26:00');
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-15 21:08:32
