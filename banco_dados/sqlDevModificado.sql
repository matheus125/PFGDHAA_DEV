CREATE DATABASE  IF NOT EXISTS `pfgdhaabd1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pfgdhaabd1`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pfgdhaabd1
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `id_clientes` int NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(100) NOT NULL,
  `cpf_cliente` varchar(15) DEFAULT NULL,
  `rg_cliente` varchar(10) DEFAULT NULL,
  `idade_cliente` int DEFAULT NULL,
  `genero` varchar(10) NOT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_clientes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES (1,'teste','231.231.231-31','       - ',19,'Masculino','2023-05-16 15:11:12',NULL),(2,'AAAAA','213.254.453-54','       - ',24,'Masculino','2023-05-16 17:35:51',NULL);
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_dependentes`
--

DROP TABLE IF EXISTS `tb_dependentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_dependentes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_titular` int DEFAULT NULL,
  `nome_dependente` varchar(100) DEFAULT NULL,
  `rg` varchar(10) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `Idade` int DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  `dependencia_cliente` varchar(50) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_titular`),
  CONSTRAINT `tb_dependentes_ibfk_1` FOREIGN KEY (`id_titular`) REFERENCES `tb_titular` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_dependentes`
--

LOCK TABLES `tb_dependentes` WRITE;
/*!40000 ALTER TABLE `tb_dependentes` DISABLE KEYS */;
INSERT INTO `tb_dependentes` VALUES (5,37,'Jhonatãn','','',6,'Masculino','FILHO/ENTEADO','2023-04-21 01:59:52','2023-05-08 20:07:37'),(6,32,'uiui','       - ','   .   .   -  ',6,'Masculino','FILHO/ENTEADO','2023-04-21 19:19:49',NULL),(7,33,'ASDASDASD','       - ','   .   .   -  ',14,'Masculino','CÔNJUGE','2023-04-27 17:09:02',NULL),(8,31,'qweqwe','       - ','   .   .   -  ',12,'Masculino','CÔNJUGE','2023-04-27 17:19:16',NULL),(9,31,'trhrh','       - ','   .   .   -  ',12,'Masculino','CÔNJUGE','2023-04-27 17:19:23',NULL),(10,31,'sadsdsdasd','       - ','   .   .   -  ',12,'Masculino','CÔNJUGE','2023-04-27 17:19:31',NULL),(11,31,'thsdsdfhdg','       - ','   .   .   -  ',11,'Masculino','CÔNJUGE','2023-04-27 17:19:42',NULL),(12,31,'adasd','       - ','   .   .   -  ',13,'Masculino','CÔNJUGE','2023-04-28 19:30:34',NULL),(13,38,'rgergre','       - ','   .   .   -  ',6,'Masculino','FILHO/ENTEADO','2023-05-05 13:40:31',NULL);
/*!40000 ALTER TABLE `tb_dependentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `referencia` varchar(100) DEFAULT NULL,
  `nacionalidade` varchar(50) DEFAULT NULL,
  `naturalidade` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `tempoDeMoradia_cliente` varchar(30) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
INSERT INTO `tb_endereco` VALUES (31,'69047-760','sasdasd','asdsadasd','','','Argentina','','asdasdasd','','2023-04-21 01:04:22','2023-05-04 15:17:24'),(32,'     -   ','asdasdsad','ASDASD','','','Argentina','','ASDASD','','2023-04-21 01:05:22','2023-05-11 17:51:59'),(33,'     -   ','asdasdasd','ASDASDASDASD','','','Argentina','','ASDASDADS','','2023-04-21 01:06:15','2023-04-27 17:09:28'),(34,'     -   ','asdassad','','','','Argentina','','','','2023-04-21 01:07:30',NULL),(35,'     -   ','asdsdads','asdasdasd','','','Argentina','','asdadsd','','2023-04-21 01:20:17',NULL),(36,'69047-760','qweqweqwe','qweqweqwe','','','Argentina','','qwqweqweqwe','','2023-04-21 01:22:27','2023-05-10 19:15:57'),(37,'     -   ','asdasd','asdasd','','','Brasil','','asdsd','','2023-05-04 15:22:08',NULL),(38,'     -   ','asdasd','asdsad','','','Brasil','','sdasd','','2023-05-04 15:25:32',NULL),(39,'     -   ','assdsd','asdas','','','Brasil','','asdas','','2023-05-04 17:46:49',NULL),(40,'     -   ','asdasdsda','asdasd','','','Brasil','','asdasdasd','','2023-05-05 13:52:40',NULL),(41,'     -   ','asdas','asdasd','','','Brasil','','asdasd','','2023-05-08 19:32:54',NULL),(42,'     -   ','ggegd','gggg','','','Brasil','','ggg','','2023-05-10 18:19:33',NULL),(43,'     -   ','reretert','erter','','','Brasil','','dassda','','2023-05-10 18:21:10',NULL),(44,'     -   ','asdsad','assadasd','','','Brasil','','sdadasd','','2023-05-10 19:31:38',NULL),(45,'     -   ','adsadsa','123123','','','Brasil','','12123','','2023-05-10 20:18:25',NULL),(46,'     -   ','asdadads','asdasd','','','Brasil','','asdasdsadasd','','2023-05-16 15:11:12',NULL),(47,'     -   ','QWEQWE','asdd','','','Brasil','','asdsad','','2023-05-16 17:35:51',NULL);
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_funcionario`
--

DROP TABLE IF EXISTS `tb_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `funcao` varchar(50) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funcionario`
--

LOCK TABLES `tb_funcionario` WRITE;
/*!40000 ALTER TABLE `tb_funcionario` DISABLE KEYS */;
INSERT INTO `tb_funcionario` VALUES (15,'Matheus Mota da Silva','Gerente','(99) 98841-1132','2023-04-20 18:36:34','2023-05-04 18:07:34'),(24,'silva','Gerente','(45) 34534-5345','2023-05-08 15:09:09',NULL),(25,'mota santos','Gerente','(12) 83129-7321','2023-05-08 15:11:59',NULL);
/*!40000 ALTER TABLE `tb_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_refeicoes_vendidas`
--

DROP TABLE IF EXISTS `tb_refeicoes_vendidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_refeicoes_vendidas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_servido` int NOT NULL,
  `data` varchar(20) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_refeicoes_vendidas`
--

LOCK TABLES `tb_refeicoes_vendidas` WRITE;
/*!40000 ALTER TABLE `tb_refeicoes_vendidas` DISABLE KEYS */;
INSERT INTO `tb_refeicoes_vendidas` VALUES (1,10,'11/05/2023','2023-05-11 18:49:06',NULL),(2,1,'11/05/2023','2023-05-11 18:55:24',NULL),(3,10,'16/05/2023','2023-05-16 14:25:33',NULL),(4,10,'16/05/2023','2023-05-16 14:56:07',NULL),(5,2,'16/05/2023','2023-05-16 15:15:33',NULL),(6,2,'16/05/2023','2023-05-16 15:21:41',NULL),(7,2,'16/05/2023','2023-05-16 15:23:11',NULL),(8,2,'16/05/2023','2023-05-16 15:25:07',NULL),(9,2,'16/05/2023','2023-05-16 15:27:36',NULL),(10,2,'16/05/2023','2023-05-16 15:33:07',NULL),(11,2,'16/05/2023','2023-05-16 15:38:02',NULL),(12,2,'16/05/2023','2023-05-16 15:57:22',NULL),(13,2,'16/05/2023','2023-05-16 16:02:40',NULL),(14,2,'16/05/2023','2023-05-16 16:04:16',NULL),(15,2,'16/05/2023','2023-05-16 16:05:47',NULL),(16,2,'16/05/2023','2023-05-16 16:07:41',NULL),(17,2,'16/05/2023','2023-05-16 16:14:32',NULL),(18,2,'16/05/2023','2023-05-16 16:15:49',NULL),(19,2,'16/05/2023','2023-05-16 16:20:41',NULL),(20,2,'16/05/2023','2023-05-16 16:23:59',NULL),(21,2,'16/05/2023','2023-05-16 16:40:54',NULL),(22,2,'16/05/2023','2023-05-16 16:41:45',NULL),(23,2,'16/05/2023','2023-05-16 16:57:08',NULL),(24,2,'16/05/2023','2023-05-16 17:00:51',NULL),(25,2,'16/05/2023','2023-05-16 17:03:18',NULL),(26,2,'16/05/2023','2023-05-16 17:06:41',NULL),(27,2,'16/05/2023','2023-05-16 17:12:01',NULL),(28,2,'16/05/2023','2023-05-16 17:15:27',NULL),(29,2,'16/05/2023','2023-05-16 17:28:19',NULL),(30,2,'16/05/2023','2023-05-16 17:32:53',NULL),(31,2,'16/05/2023','2023-05-16 17:34:40',NULL),(32,4,'16/05/2023','2023-05-16 17:36:14',NULL),(33,4,'16/05/2023','2023-05-16 17:47:16',NULL),(34,4,'16/05/2023','2023-05-16 17:48:13',NULL),(35,3,'16/05/2023','2023-05-16 17:48:37',NULL),(36,3,'17/05/2023','2023-05-17 16:11:33',NULL),(37,3,'17/05/2023','2023-05-17 16:12:21',NULL),(38,3,'17/05/2023','2023-05-17 16:13:57',NULL),(39,3,'17/05/2023','2023-05-17 16:14:13',NULL),(40,3,'17/05/2023','2023-05-17 16:16:14',NULL),(41,3,'17/05/2023','2023-05-17 16:17:02',NULL),(42,3,'17/05/2023','2023-05-17 16:20:46',NULL),(43,3,'17/05/2023','2023-05-17 16:21:16',NULL),(44,3,'17/05/2023','2023-05-17 16:24:24',NULL),(45,3,'17/05/2023','2023-05-17 16:25:21',NULL),(46,3,'17/05/2023','2023-05-17 16:27:47',NULL);
/*!40000 ALTER TABLE `tb_refeicoes_vendidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_relatorios`
--

DROP TABLE IF EXISTS `tb_relatorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_relatorios` (
  `Idade_0a16Masculino` int DEFAULT NULL,
  `Idade_0a16Feminino` int DEFAULT NULL,
  `Idade_16a60Masculino` int DEFAULT NULL,
  `Idade_16a60Feminino` int DEFAULT NULL,
  `Idade_60Masculino` int DEFAULT NULL,
  `Idade_60Feminino` int DEFAULT NULL,
  `senhas_genericas` int DEFAULT NULL,
  `Total_pessoas_atendidas` int DEFAULT NULL,
  `data` varchar(20) NOT NULL,
  PRIMARY KEY (`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_relatorios`
--

LOCK TABLES `tb_relatorios` WRITE;
/*!40000 ALTER TABLE `tb_relatorios` DISABLE KEYS */;
INSERT INTO `tb_relatorios` VALUES (0,0,2,0,0,0,1,3,'17/05/2023');
/*!40000 ALTER TABLE `tb_relatorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_senhas`
--

DROP TABLE IF EXISTS `tb_senhas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_senhas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente` varchar(100) DEFAULT NULL,
  `Idade` varchar(20) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `tipoSenha` varchar(10) DEFAULT NULL,
  `data_refeicao` varchar(10) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_senhas`
--

LOCK TABLES `tb_senhas` WRITE;
/*!40000 ALTER TABLE `tb_senhas` DISABLE KEYS */;
INSERT INTO `tb_senhas` VALUES (1,'teste','19','Masculino','NORMAL','16/05/2023','2023-05-16 15:11:29',NULL),(2,NULL,'1','1','GENÉRICO','16/05/2023','2023-05-16 15:15:16',NULL),(4,'AAAAA','24','Masculino','NORMAL','16/05/2023','2023-05-16 17:35:58',NULL);
/*!40000 ALTER TABLE `tb_senhas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_socio_economico`
--

DROP TABLE IF EXISTS `tb_socio_economico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_socio_economico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_titular` int DEFAULT NULL,
  `escolariedade` varchar(50) DEFAULT NULL,
  `renda_mensal_familia` varchar(50) DEFAULT NULL,
  `programas_sociais` varchar(50) DEFAULT NULL,
  `composicao_familiar` varchar(50) DEFAULT NULL,
  `moradia` varchar(50) DEFAULT NULL,
  `estrutura_Moradia` varchar(50) DEFAULT NULL,
  `qtdPessoas_Trabalhando` int DEFAULT NULL,
  `emprego` varchar(50) DEFAULT NULL,
  `profissao_Responsavel` varchar(50) DEFAULT NULL,
  `AB_Agua` varchar(3) DEFAULT NULL,
  `SN_basico` varchar(3) DEFAULT NULL,
  `Energia_eletrica` varchar(3) DEFAULT NULL,
  `Lixo_Domiciliar` varchar(15) DEFAULT NULL,
  `frequenta_Centro` varchar(5) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_titular`),
  CONSTRAINT `tb_socio_economico_ibfk_1` FOREIGN KEY (`id_titular`) REFERENCES `tb_titular` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_socio_economico`
--

LOCK TABLES `tb_socio_economico` WRITE;
/*!40000 ALTER TABLE `tb_socio_economico` DISABLE KEYS */;
INSERT INTO `tb_socio_economico` VALUES (1,36,'ANALFABETO','0 A 89,00','BOLSA FÁMILIA','MORA SOZINHO','PRÓPRIA','ALVENARIA',23,'CLT','','SIM','SIM','SIM','SIM','SIM','2023-04-21 02:01:29',NULL),(2,32,'ANALFABETO','0 A 89,00','BOLSA FÁMILIA','MORA SOZINHO','PRÓPRIA','ALVENARIA',2,'CLT','','SIM','SIM','SIM','SIM','SIM','2023-04-21 19:28:03',NULL),(3,36,'ANALFABETO','0 A 89,00','BOLSA FÁMILIA','MORA SOZINHO','PRÓPRIA','ALVENARIA',1,'CLT','','SIM','SIM','SIM','SIM','SIM','2023-04-21 19:28:44',NULL),(4,34,'ANALFABETO','0 A 89,00','BOLSA FÁMILIA','MORA SOZINHO','PRÓPRIA','ALVENARIA',2,'CLT','','SIM','SIM','SIM','SIM','SIM','2023-04-21 19:29:31',NULL);
/*!40000 ALTER TABLE `tb_socio_economico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_socio_economico_saude`
--

DROP TABLE IF EXISTS `tb_socio_economico_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_socio_economico_saude` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_titular` int DEFAULT NULL,
  `doenca` varchar(100) DEFAULT NULL,
  `outras_Doencas` varchar(100) DEFAULT NULL,
  `deficiencia` varchar(3) DEFAULT NULL,
  `justificativa_Deficiencia` varchar(100) DEFAULT NULL,
  `laudo` varchar(100) DEFAULT NULL,
  `observacao` varchar(100) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_titular`),
  CONSTRAINT `tb_socio_economico_saude_ibfk_1` FOREIGN KEY (`id_titular`) REFERENCES `tb_titular` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_socio_economico_saude`
--

LOCK TABLES `tb_socio_economico_saude` WRITE;
/*!40000 ALTER TABLE `tb_socio_economico_saude` DISABLE KEYS */;
INSERT INTO `tb_socio_economico_saude` VALUES (1,31,'SIM','','SIM','','SIM','','2023-04-21 19:30:38',NULL),(2,31,'SIM','','SIM','','SIM','','2023-04-21 19:35:19',NULL),(6,38,'NÃO','','NÃO','','NÃO','','2023-05-08 20:31:18',NULL),(11,38,'NÃO','','NÃO','','NÃO','','2023-05-08 20:36:54',NULL),(13,31,'NÃO','','NÃO','','NÃO','','2023-05-09 00:19:20',NULL);
/*!40000 ALTER TABLE `tb_socio_economico_saude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_titular`
--

DROP TABLE IF EXISTS `tb_titular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_titular` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_endereco` int DEFAULT NULL,
  `nome_Completo` varchar(100) DEFAULT NULL,
  `nome_Social` varchar(100) DEFAULT NULL,
  `cor_cliente` varchar(100) DEFAULT NULL,
  `nome_Mae` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `data_Nascimento` varchar(20) DEFAULT NULL,
  `idade_cliente` int DEFAULT NULL,
  `genero_cliente` varchar(30) DEFAULT NULL,
  `estado_Civil` varchar(50) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `status_Cliente` varchar(8) NOT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_endereco` (`id_endereco`),
  CONSTRAINT `tb_titular_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `tb_endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_titular`
--

LOCK TABLES `tb_titular` WRITE;
/*!40000 ALTER TABLE `tb_titular` DISABLE KEYS */;
INSERT INTO `tb_titular` VALUES (31,31,'matheus silva','','Branco','','(23) 12312-3123','13/03/1994',29,'Masculino','Casado (a)','1112312-3','123.123.123-12','ATIVO','2023-04-21 01:04:22','2023-05-04 15:17:24'),(32,32,'asdadasdsa','asdadsd','Branco','','(12) 31231-2312','13/03/1996',19,'Feminino','Casado (a)','1231231-3','213.123.123-12','ATIVO','2023-04-21 01:05:22','2023-05-11 17:51:59'),(33,33,'efefefef','','Branco','','(11) 11111-1111','13/03/1996',19,'Feminino','Casado (a)','       - ','125.123.123-12','ATIVO','2023-04-21 01:06:15','2023-04-27 17:09:28'),(34,34,'rgegergerg','','Branco','','(21) 31231-2312','13/12/3123',123,'Masculino','Casado (a)','       - ','553.123.123-12','ATIVO','2023-04-21 01:07:30',NULL),(35,35,'wfewfwef','','Branco','','(12) 31231-2312','13/13/1231',18,'Masculino','Casado (a)','       - ','555.555.333-32','ATIVO','2023-04-21 01:20:17',NULL),(36,36,'asasdsd','asdasd','Branco','adasdasd','(12) 31231-2312','12/31/2312',18,'Masculino','Casado (a)','1112312-3','767.688.123-12','ATIVO','2023-04-21 01:22:27','2023-05-10 19:15:57'),(37,37,'jojo','','Branco','','(12) 25543-3434','56/54/5645',34,'Masculino','Casado (a)','       - ','890.000.889-99','ATIVO','2023-05-04 15:22:08',NULL),(38,38,'biel','','Branco','','(12) 12311-2312','12/31/2312',19,'Masculino','Casado (a)','       - ','234.123.123-12','ATIVO','2023-05-04 15:25:32',NULL),(39,39,'ertert','','Branco','','(23) 23423-4234','12/12/1212',19,'Masculino','Casado (a)','       - ','234.366.565-63','ATIVO','2023-05-04 17:46:49',NULL),(40,40,'joão','','Branco','','(12) 31231-2312','13/13/1313',19,'Masculino','Casado (a)','       - ','414.141.414-14','ATIVO','2023-05-05 13:52:40',NULL),(41,41,'everaldo','','Branco','','(33) 32212-2223','13/23/2312',19,'Masculino','Casado (a)','       - ','235.435.545-45','ATIVO','2023-05-08 19:32:54',NULL),(42,42,'matias pinto','','Branco','','(21) 33321-5532','13/03/0991',18,'Masculino','Casado (a)','       - ','234.512.112-12','ATIVO','2023-05-10 18:19:33',NULL),(43,43,'vinicius mamadinha','','Branco','','(12) 31232-3242','45/64/5656',46,'Masculino','Casado (a)','       - ','645.645.646-45','ATIVO','2023-05-10 18:21:10',NULL),(44,44,'zian','','Branco','','(31) 23123-1231','12/32/3212',19,'Masculino','Casado (a)','       - ','112.435.345-34','ATIVO','2023-05-10 19:31:38',NULL),(45,45,'rhrh','','Branco','','(23) 32323-2323','23/12/3123',135,'Masculino','Casado (a)','       - ','263.434.311-21','ATIVO','2023-05-10 20:18:25',NULL),(46,46,'teste','','Branco','','(12) 31231-2123','13/12/3123',19,'Masculino','Casado (a)','       - ','231.231.231-31','ATIVO','2023-05-16 15:11:12',NULL),(47,47,'AAAAA','','Branco','','(12) 31232-1312','23/42/3423',24,'Masculino','Casado (a)','       - ','213.254.453-54','ATIVO','2023-05-16 17:35:51',NULL);
/*!40000 ALTER TABLE `tb_titular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_funcionario` int DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(100) NOT NULL,
  `perfil` varchar(50) NOT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `tb_funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (15,15,'000.000.000-00','123','Administrador','2023-04-20 18:36:34','2023-05-04 18:07:34'),(24,24,'435.345.345-34','345345','Simples','2023-05-08 15:09:09',NULL),(25,25,'002.928.884-83','12831923','Administrador','2023-05-08 15:11:59',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_userlogs`
--

DROP TABLE IF EXISTS `tb_userlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_userlogs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `tb_userlogs_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_userlogs`
--

LOCK TABLES `tb_userlogs` WRITE;
/*!40000 ALTER TABLE `tb_userlogs` DISABLE KEYS */;
INSERT INTO `tb_userlogs` VALUES (1,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 18:38:43','2023-05-03 18:38:55'),(2,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 18:45:55','2023-05-03 18:46:07'),(3,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 18:46:57','2023-05-03 18:47:31'),(4,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 18:47:45','2023-05-03 18:47:48'),(5,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 19:41:53','2023-05-03 19:42:16'),(6,15,'000.000.000-00','Matheus Mota da Silva','2023-05-03 19:55:38','2023-05-03 19:55:53'),(7,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:17:16','2023-05-04 15:17:29'),(8,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:21:25','2023-05-04 15:22:16'),(9,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:24:51','2023-05-04 15:25:49'),(10,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:44:06','2023-05-04 15:45:04'),(11,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:45:34','2023-05-04 15:46:10'),(12,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:47:22','2023-05-04 15:47:42'),(13,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:50:25','2023-05-04 15:50:45'),(14,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 15:52:19','2023-05-04 15:52:55'),(15,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 17:44:25',NULL),(16,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 17:46:18','2023-05-04 17:47:36'),(17,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 17:51:22','2023-05-04 17:51:35'),(18,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 17:57:59','2023-05-04 17:58:12'),(19,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:02:46','2023-05-04 18:05:13'),(20,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:07:27','2023-05-04 18:07:38'),(21,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:07:41','2023-05-04 18:07:56'),(22,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:17:34','2023-05-04 18:18:28'),(23,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:18:31','2023-05-04 18:19:34'),(24,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:26:55','2023-05-04 18:32:47'),(25,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:36:11','2023-05-04 18:36:37'),(26,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:37:21','2023-05-04 18:37:31'),(27,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:42:06','2023-05-04 18:42:18'),(28,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:52:13','2023-05-04 18:52:23'),(29,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 18:59:32','2023-05-04 19:00:10'),(30,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:00:24','2023-05-04 19:00:33'),(31,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:02:07','2023-05-04 19:02:19'),(32,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:03:48','2023-05-04 19:04:34'),(33,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:04:48','2023-05-04 19:04:56'),(34,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:09:07','2023-05-04 19:10:41'),(35,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:12:14','2023-05-04 19:13:19'),(36,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:13:24','2023-05-04 19:14:52'),(37,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:41:07','2023-05-04 19:41:24'),(38,15,'000.000.000-00','Matheus Mota da Silva','2023-05-04 19:42:15','2023-05-04 19:42:31'),(39,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:32:36','2023-05-05 12:32:49'),(40,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:39:58','2023-05-05 12:40:12'),(41,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:43:36','2023-05-05 12:44:19'),(42,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:44:32','2023-05-05 12:44:40'),(43,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:45:04','2023-05-05 12:45:13'),(44,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:46:19','2023-05-05 12:46:38'),(45,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:48:23','2023-05-05 12:48:35'),(46,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:52:08','2023-05-05 12:52:17'),(47,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:55:32','2023-05-05 12:56:28'),(48,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:58:15','2023-05-05 12:58:24'),(49,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 12:59:43','2023-05-05 12:59:59'),(50,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:00:26','2023-05-05 13:00:54'),(51,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:01:23','2023-05-05 13:01:39'),(52,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:02:29','2023-05-05 13:02:52'),(53,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:07:14','2023-05-05 13:07:26'),(54,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:07:56','2023-05-05 13:08:16'),(55,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:11:11','2023-05-05 13:12:26'),(56,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:23:38','2023-05-05 13:23:50'),(57,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:25:56','2023-05-05 13:26:27'),(58,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:40:02','2023-05-05 13:42:09'),(59,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:44:56','2023-05-05 13:45:42'),(60,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:46:41','2023-05-05 13:47:12'),(61,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:49:04','2023-05-05 13:49:16'),(62,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:49:56','2023-05-05 13:50:12'),(63,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:50:58','2023-05-05 13:51:41'),(64,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 13:52:01','2023-05-05 13:52:53'),(65,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 14:40:54',NULL),(66,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 14:43:01','2023-05-05 14:43:39'),(67,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 14:52:04','2023-05-05 14:52:26'),(68,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:36:43','2023-05-05 17:37:20'),(69,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:37:57','2023-05-05 17:38:12'),(70,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:39:54',NULL),(71,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:42:43','2023-05-05 17:44:26'),(72,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:44:48',NULL),(73,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 17:48:49','2023-05-05 17:49:41'),(74,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:04:38','2023-05-05 18:04:51'),(75,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:05:55','2023-05-05 18:06:12'),(76,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:09:00','2023-05-05 18:09:11'),(77,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:22:30','2023-05-05 18:23:01'),(78,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:25:01','2023-05-05 18:27:09'),(79,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:32:09','2023-05-05 18:33:18'),(80,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:33:27','2023-05-05 18:33:45'),(81,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:35:20','2023-05-05 18:35:53'),(82,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:36:53','2023-05-05 18:38:14'),(83,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 18:58:15','2023-05-05 18:58:28'),(84,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:18:05','2023-05-05 19:18:20'),(85,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:28:00','2023-05-05 19:28:34'),(86,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:28:57','2023-05-05 19:30:26'),(87,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:30:52','2023-05-05 19:31:09'),(88,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:32:05','2023-05-05 19:32:56'),(89,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:35:06','2023-05-05 19:35:18'),(90,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:36:00','2023-05-05 19:36:23'),(91,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:40:17','2023-05-05 19:40:39'),(92,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:41:24','2023-05-05 19:41:43'),(93,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:43:23','2023-05-05 19:46:12'),(94,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:46:24','2023-05-05 19:46:43'),(95,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:47:32','2023-05-05 19:47:44'),(96,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:48:17','2023-05-05 19:48:26'),(97,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:49:33','2023-05-05 19:49:43'),(98,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:50:46','2023-05-05 19:50:56'),(99,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:52:00','2023-05-05 19:52:09'),(100,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:52:49','2023-05-05 19:52:56'),(101,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:53:30','2023-05-05 19:53:36'),(102,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 19:55:15','2023-05-05 19:55:22'),(103,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:09:56','2023-05-05 20:10:05'),(104,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:11:38','2023-05-05 20:11:47'),(105,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:12:06','2023-05-05 20:12:18'),(106,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:13:49','2023-05-05 20:14:11'),(107,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:16:47','2023-05-05 20:17:08'),(108,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:17:47','2023-05-05 20:18:00'),(109,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:20:09','2023-05-05 20:20:17'),(110,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:20:33','2023-05-05 20:20:42'),(111,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:21:04','2023-05-05 20:21:11'),(112,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:21:22','2023-05-05 20:21:42'),(113,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:21:54','2023-05-05 20:22:08'),(114,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:22:54','2023-05-05 20:23:07'),(115,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:24:06','2023-05-05 20:24:17'),(116,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 20:25:08','2023-05-05 20:25:19'),(117,15,'000.000.000-00','Matheus Mota da Silva','2023-05-05 22:25:42','2023-05-05 22:28:07'),(118,15,'000.000.000-00','Matheus Mota da Silva','2023-05-06 00:03:47','2023-05-06 00:04:11'),(119,15,'000.000.000-00','Matheus Mota da Silva','2023-05-06 00:04:38','2023-05-06 00:04:58'),(120,15,'000.000.000-00','Matheus Mota da Silva','2023-05-06 00:05:48','2023-05-06 00:06:10'),(121,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 01:00:32','2023-05-08 01:00:52'),(122,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 13:29:34','2023-05-08 13:29:40'),(123,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 13:45:42','2023-05-08 13:45:49'),(124,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:18:56','2023-05-08 14:22:16'),(125,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:25:47','2023-05-08 14:29:01'),(126,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:30:04','2023-05-08 14:30:13'),(127,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:31:02','2023-05-08 14:31:26'),(128,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:32:41','2023-05-08 14:32:57'),(129,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:33:23','2023-05-08 14:33:46'),(130,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:34:53','2023-05-08 14:36:56'),(131,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:37:58','2023-05-08 14:38:45'),(132,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:39:32','2023-05-08 14:39:44'),(133,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:40:07','2023-05-08 14:40:21'),(134,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:41:58','2023-05-08 14:42:11'),(135,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:42:34','2023-05-08 14:42:50'),(136,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:43:14','2023-05-08 14:43:30'),(137,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:44:19','2023-05-08 14:44:28'),(138,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:45:07','2023-05-08 14:45:23'),(139,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:45:47','2023-05-08 14:46:05'),(140,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:48:17','2023-05-08 14:48:32'),(141,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:48:58','2023-05-08 14:49:11'),(142,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:49:44','2023-05-08 14:50:08'),(143,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:51:00','2023-05-08 14:51:46'),(144,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:52:14','2023-05-08 14:52:23'),(145,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:52:47','2023-05-08 14:53:47'),(146,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:54:02','2023-05-08 14:54:13'),(147,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 14:54:31','2023-05-08 14:57:59'),(148,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:00:47','2023-05-08 15:00:56'),(149,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:01:55','2023-05-08 15:01:59'),(150,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:02:16',NULL),(151,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:02:18',NULL),(152,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:03:52','2023-05-08 15:04:08'),(153,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:04:26','2023-05-08 15:04:34'),(154,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:04:55','2023-05-08 15:05:01'),(155,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:05:12','2023-05-08 15:05:20'),(156,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:05:34','2023-05-08 15:05:49'),(157,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:08:13','2023-05-08 15:08:21'),(158,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:08:44','2023-05-08 15:09:53'),(159,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:10:07','2023-05-08 15:12:20'),(160,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:23:03','2023-05-08 15:23:36'),(161,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:25:55','2023-05-08 15:26:45'),(162,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:27:34','2023-05-08 15:27:40'),(163,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:28:46','2023-05-08 15:29:21'),(164,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:29:54','2023-05-08 15:31:42'),(165,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 15:31:59','2023-05-08 15:32:16'),(166,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:09:02',NULL),(167,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:10:08',NULL),(168,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:12:43',NULL),(169,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:13:36','2023-05-08 16:13:42'),(170,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:15:05','2023-05-08 16:15:17'),(171,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 16:16:33','2023-05-08 16:16:40'),(172,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 17:47:58','2023-05-08 17:48:34'),(173,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 17:49:51','2023-05-08 17:50:31'),(174,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 17:50:37','2023-05-08 17:50:49'),(175,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 17:53:24','2023-05-08 17:53:39'),(176,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:07:23','2023-05-08 18:08:20'),(177,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:12:43','2023-05-08 18:13:20'),(178,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:13:40','2023-05-08 18:14:16'),(179,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:16:37','2023-05-08 18:17:08'),(180,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:47:33',NULL),(181,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 18:48:42',NULL),(182,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:00:42','2023-05-08 19:01:35'),(183,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:07:50','2023-05-08 19:08:50'),(184,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:14:12','2023-05-08 19:15:34'),(185,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:17:19','2023-05-08 19:17:47'),(186,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:19:33','2023-05-08 19:19:53'),(187,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:24:57','2023-05-08 19:25:29'),(188,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:26:48','2023-05-08 19:27:01'),(189,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:28:36','2023-05-08 19:28:54'),(190,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:31:57','2023-05-08 19:33:30'),(191,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:36:41','2023-05-08 19:37:02'),(192,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:37:22','2023-05-08 19:37:35'),(193,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:37:59','2023-05-08 19:38:18'),(194,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:39:18','2023-05-08 19:39:36'),(195,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 19:39:57','2023-05-08 19:43:09'),(196,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 20:08:42','2023-05-08 20:08:55'),(197,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 20:30:52','2023-05-08 20:31:30'),(198,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 20:33:02','2023-05-08 20:33:39'),(199,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 20:35:59','2023-05-08 20:37:02'),(200,15,'000.000.000-00','Matheus Mota da Silva','2023-05-08 23:47:02','2023-05-08 23:47:12'),(201,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:05:09','2023-05-09 00:06:29'),(202,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:09:09',NULL),(203,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:15:00','2023-05-09 00:15:59'),(204,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:17:16',NULL),(205,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:19:06','2023-05-09 00:19:35'),(206,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:20:59','2023-05-09 00:21:15'),(207,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:22:00','2023-05-09 00:22:24'),(208,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:23:30','2023-05-09 00:24:08'),(209,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:28:27','2023-05-09 00:29:08'),(210,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 00:31:07','2023-05-09 00:31:40'),(211,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 14:11:57','2023-05-09 14:12:40'),(212,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 15:00:44','2023-05-09 15:00:56'),(213,15,'000.000.000-00','Matheus Mota da Silva','2023-05-09 15:20:20','2023-05-09 15:20:51'),(214,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:30:58',NULL),(215,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:31:35','2023-05-10 14:31:54'),(216,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:32:43','2023-05-10 14:32:55'),(217,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:33:22','2023-05-10 14:33:32'),(218,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:33:45','2023-05-10 14:34:09'),(219,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:34:40','2023-05-10 14:34:49'),(220,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:35:00','2023-05-10 14:35:06'),(221,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:35:20','2023-05-10 14:35:27'),(222,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:35:42','2023-05-10 14:35:48'),(223,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:36:02','2023-05-10 14:36:08'),(224,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:36:24','2023-05-10 14:36:27'),(225,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:36:41','2023-05-10 14:36:46'),(226,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:36:59','2023-05-10 14:37:04'),(227,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:37:18','2023-05-10 14:37:33'),(228,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:38:13','2023-05-10 14:38:21'),(229,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:42:05','2023-05-10 14:42:29'),(230,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:43:31','2023-05-10 14:43:37'),(231,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:44:31','2023-05-10 14:44:41'),(232,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:45:54','2023-05-10 14:46:42'),(233,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:46:49','2023-05-10 14:47:40'),(234,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:50:08','2023-05-10 14:50:54'),(235,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:51:09','2023-05-10 14:52:52'),(236,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:53:02','2023-05-10 14:53:10'),(237,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:53:31','2023-05-10 14:53:41'),(238,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:55:21','2023-05-10 14:56:56'),(239,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:57:40','2023-05-10 14:57:49'),(240,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 14:58:41','2023-05-10 15:00:29'),(241,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 15:00:50','2023-05-10 15:02:35'),(242,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 15:02:41','2023-05-10 15:03:27'),(243,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 15:03:42','2023-05-10 15:03:54'),(244,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 15:04:44','2023-05-10 15:04:51'),(245,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:17:17','2023-05-10 16:17:30'),(246,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:20:06','2023-05-10 16:20:13'),(247,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:20:37','2023-05-10 16:21:04'),(248,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:21:17','2023-05-10 16:21:23'),(249,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:23:49','2023-05-10 16:23:57'),(250,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:24:36','2023-05-10 16:24:44'),(251,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:26:40','2023-05-10 16:26:47'),(252,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:30:38','2023-05-10 16:30:44'),(253,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:30:52','2023-05-10 16:31:11'),(254,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:32:30','2023-05-10 16:32:39'),(255,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 16:33:05','2023-05-10 16:33:12'),(256,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:17:45','2023-05-10 18:23:01'),(257,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:52:06',NULL),(258,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:54:34','2023-05-10 18:54:50'),(259,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:55:33','2023-05-10 18:55:55'),(260,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:56:22','2023-05-10 18:56:52'),(261,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:57:15','2023-05-10 18:57:28'),(262,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:57:42','2023-05-10 18:57:51'),(263,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 18:59:49','2023-05-10 19:00:01'),(264,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:00:42','2023-05-10 19:00:53'),(265,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:01:18','2023-05-10 19:01:48'),(266,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:02:21','2023-05-10 19:02:33'),(267,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:03:03','2023-05-10 19:03:15'),(268,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:03:49','2023-05-10 19:03:56'),(269,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:04:48','2023-05-10 19:05:02'),(270,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:06:56','2023-05-10 19:07:35'),(271,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:08:00','2023-05-10 19:08:10'),(272,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:09:31','2023-05-10 19:09:38'),(273,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:11:55','2023-05-10 19:12:07'),(274,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:13:19','2023-05-10 19:13:26'),(275,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:13:43','2023-05-10 19:13:52'),(276,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:14:11','2023-05-10 19:14:19'),(277,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:14:40','2023-05-10 19:14:46'),(278,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:15:36','2023-05-10 19:16:09'),(279,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:19:54','2023-05-10 19:20:02'),(280,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:21:28','2023-05-10 19:25:26'),(281,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:27:56','2023-05-10 19:29:00'),(282,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:30:30','2023-05-10 19:32:03'),(283,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:32:46','2023-05-10 19:33:00'),(284,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:33:52','2023-05-10 19:34:19'),(285,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:37:28','2023-05-10 19:37:53'),(286,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:38:16','2023-05-10 19:38:22'),(287,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:39:04','2023-05-10 19:39:34'),(288,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:40:13','2023-05-10 19:41:31'),(289,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:44:11','2023-05-10 19:44:35'),(290,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:45:10','2023-05-10 19:45:27'),(291,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:47:48','2023-05-10 19:48:28'),(292,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:49:08','2023-05-10 19:50:14'),(293,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 19:51:54','2023-05-10 19:52:48'),(294,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:15:21','2023-05-10 20:16:10'),(295,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:16:22','2023-05-10 20:16:47'),(296,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:17:30','2023-05-10 20:19:36'),(297,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:21:15','2023-05-10 20:22:17'),(298,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:22:43','2023-05-10 20:23:01'),(299,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:23:32','2023-05-10 20:24:10'),(300,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:26:24','2023-05-10 20:26:29'),(301,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:27:26','2023-05-10 20:28:05'),(302,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:29:01','2023-05-10 20:29:28'),(303,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:31:25','2023-05-10 20:32:15'),(304,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:37:32','2023-05-10 20:37:43'),(305,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:38:05','2023-05-10 20:38:55'),(306,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:39:21','2023-05-10 20:39:31'),(307,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:41:08','2023-05-10 20:41:25'),(308,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:42:18','2023-05-10 20:42:25'),(309,15,'000.000.000-00','Matheus Mota da Silva','2023-05-10 20:42:51','2023-05-10 20:43:40'),(310,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 12:59:53','2023-05-11 13:00:02'),(311,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:00:45','2023-05-11 13:00:53'),(312,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:01:28','2023-05-11 13:03:13'),(313,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:38:54','2023-05-11 13:39:06'),(314,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:41:39','2023-05-11 13:41:57'),(315,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:44:40','2023-05-11 13:45:21'),(316,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 13:55:53','2023-05-11 13:56:53'),(317,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:01:19','2023-05-11 14:01:29'),(318,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:04:07','2023-05-11 14:04:19'),(319,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:06:00','2023-05-11 14:08:55'),(320,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:09:06','2023-05-11 14:09:16'),(321,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:09:28','2023-05-11 14:09:43'),(322,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:11:00','2023-05-11 14:11:08'),(323,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:12:42','2023-05-11 14:13:23'),(324,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:14:16','2023-05-11 14:14:42'),(325,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:15:16','2023-05-11 14:15:22'),(326,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:25:56','2023-05-11 14:26:13'),(327,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:27:00','2023-05-11 14:27:07'),(328,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:27:23','2023-05-11 14:27:29'),(329,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:27:42','2023-05-11 14:27:49'),(330,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:28:26','2023-05-11 14:28:34'),(331,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:28:53','2023-05-11 14:29:05'),(332,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 14:56:14','2023-05-11 14:56:28'),(333,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:10:40','2023-05-11 15:11:05'),(334,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:11:41','2023-05-11 15:12:17'),(335,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:32:07','2023-05-11 15:34:45'),(336,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:34:57','2023-05-11 15:37:30'),(337,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:37:33','2023-05-11 15:38:05'),(338,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 15:42:25','2023-05-11 15:42:36'),(339,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 16:16:19','2023-05-11 16:16:40'),(340,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 16:25:36','2023-05-11 16:25:52'),(341,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 17:51:40','2023-05-11 17:58:53'),(342,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 18:44:45','2023-05-11 18:45:42'),(343,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 18:45:59','2023-05-11 18:46:10'),(344,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 18:48:57','2023-05-11 18:51:53'),(345,15,'000.000.000-00','Matheus Mota da Silva','2023-05-11 18:54:15','2023-05-11 18:55:27'),(346,15,'000.000.000-00','Matheus Mota da Silva','2023-05-15 15:42:51','2023-05-15 15:42:54'),(347,15,'000.000.000-00','Matheus Mota da Silva','2023-05-15 15:43:12','2023-05-15 15:43:50'),(348,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 14:25:11','2023-05-16 14:26:47'),(349,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 14:55:53','2023-05-16 14:57:01'),(350,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:07:36','2023-05-16 15:11:46'),(351,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:12:42','2023-05-16 15:14:38'),(352,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:15:10','2023-05-16 15:16:07'),(353,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:21:33','2023-05-16 15:22:51'),(354,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:23:03',NULL),(355,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:25:02','2023-05-16 15:27:17'),(356,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:27:28','2023-05-16 15:29:53'),(357,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:32:53','2023-05-16 15:33:21'),(358,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:37:57','2023-05-16 15:38:36'),(359,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 15:57:15','2023-05-16 16:00:42'),(360,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:00:49','2023-05-16 16:00:54'),(361,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:02:23','2023-05-16 16:03:57'),(362,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:04:03','2023-05-16 16:04:19'),(363,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:05:36','2023-05-16 16:07:18'),(364,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:07:31','2023-05-16 16:10:28'),(365,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:14:24','2023-05-16 16:14:56'),(366,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:15:43','2023-05-16 16:16:01'),(367,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:20:31',NULL),(368,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:23:50',NULL),(369,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:40:49','2023-05-16 16:41:31'),(370,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:41:40','2023-05-16 16:42:42'),(371,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 16:57:03','2023-05-16 16:57:50'),(372,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:00:45','2023-05-16 17:01:06'),(373,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:03:10','2023-05-16 17:03:39'),(374,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:06:36','2023-05-16 17:07:26'),(375,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:11:46','2023-05-16 17:13:41'),(376,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:15:21','2023-05-16 17:16:00'),(377,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:28:12','2023-05-16 17:28:34'),(378,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:32:43',NULL),(379,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:34:27',NULL),(380,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:47:03',NULL),(381,15,'000.000.000-00','Matheus Mota da Silva','2023-05-16 17:48:03',NULL),(382,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:11:24','2023-05-17 16:11:49'),(383,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:12:08','2023-05-17 16:14:23'),(384,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:14:35','2023-05-17 16:15:34'),(385,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:16:10','2023-05-17 16:16:47'),(386,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:16:58','2023-05-17 16:17:05'),(387,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:20:41','2023-05-17 16:21:35'),(388,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:24:17','2023-05-17 16:24:29'),(389,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:25:16','2023-05-17 16:25:23'),(390,15,'000.000.000-00','Matheus Mota da Silva','2023-05-17 16:27:43','2023-05-17 16:28:09');
/*!40000 ALTER TABLE `tb_userlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pfgdhaabd1'
--

--
-- Dumping routines for database 'pfgdhaabd1'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_delete_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_funcionario`(
IN pid_funcionario int
)
BEGIN
	DECLARE vid_funcionario INT;
		 
		 SET FOREIGN_KEY_CHECKS = 0;
		 
		 SELECT id INTO vid_funcionario FROM tb_funcionario WHERE id = pid_funcionario;
		 
		 DELETE FROM tb_funcionario WHERE id = pid_funcionario;
		 DELETE FROM tb_user WHERE id_funcionario = pid_funcionario;
		 
		 SET FOREIGN_KEY_CHECKS = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_dependentes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_dependentes`(
)
BEGIN
	SELECT d.id, d.nome_dependente, d.rg, d.cpf, d.Idade, d.genero, d.dependencia_cliente FROM tb_titular t INNER JOIN tb_dependentes d on d.id_titular = t.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pesquisarTitular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pesquisarTitular`(
p_nome varchar (100)
)
BEGIN
select * from tb_titular t INNER JOIN tb_endereco e on e.id = t.id_endereco WHERE nome_Completo like p_nome or cpf like p_nome;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pesquisar_funcionarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pesquisar_funcionarios`(
p_nome varchar (100)
)
BEGIN
SELECT * FROM tb_user u INNER JOIN tb_funcionario f on u.id_funcionario = f.id WHERE nome like p_nome ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_dependentes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_dependentes`(
pidtitular int,
pnome_dependente varchar (100),
prg varchar (10),
pcpf varchar (15),
pIdade int,
pgenero varchar (10),
pdependencia_cliente varchar (50)
)
BEGIN
	INSERT INTO tb_dependentes (id_titular, nome_dependente, rg, cpf, Idade, genero, dependencia_cliente) 
    VALUES (pidtitular, pnome_dependente, prg, pcpf, pIdade, pgenero, pdependencia_cliente);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_funcionarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_funcionarios`(
pnome varchar (100),
pfuncao varchar (100),
ptelefone varchar (15),
plogin varchar (100),
ppassword varchar (250),
pperfil varchar (50)
)
BEGIN
	DECLARE vidfuncionario INT;
    
    INSERT INTO tb_funcionario (nome, funcao, telefone) VALUES (pnome, pfuncao, ptelefone);
	
    SET vidfuncionario = last_insert_id();
    
    INSERT INTO tb_user (id_funcionario, login, password, perfil) 
    VALUES (vidfuncionario, plogin, ppassword, pperfil);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_refeicoes_vendidas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_refeicoes_vendidas`(
ptotal_servido int,
pdata varchar (20)
)
BEGIN
	INSERT INTO tb_refeicoes_vendidas (total_servido, data) VALUES (ptotal_servido, pdata);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_senhas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_senhas`(
pCliente varchar (100),
pGenero varchar (45),
pIdade varchar (45),
pdata_refeicao varchar (10)
)
BEGIN
	INSERT INTO tb_senhas (cliente, Genero, Idade, tipoSenha, data_refeicao) 
    VALUES (pCliente, pGenero, pIdade, "NORMAL", pdata_refeicao);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_senhas_genericas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_senhas_genericas`(
pdata_refeicao varchar (10)
)
BEGIN
	INSERT INTO tb_senhas (tipoSenha, data_refeicao) 
    VALUES ("GENÉRICO", pdata_refeicao);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_socio_economico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_socio_economico`(
pidtitular int,
pescolariedade varchar(50), 
prenda_mensal_familia varchar(50), 
pprogramas_sociais varchar(50),
pcomposicao_familiar varchar(50),
pmoradia varchar(50),
pestrutura_Moradia varchar(50), 
pqtdPessoas_Trabalhando int,
pemprego varchar(50),
pprofissao_Responsavel varchar(50), 
pAB_Agua varchar(3),
pSN_basico varchar(3), 
pEnergia_eletrica varchar(3), 
pLixo_Domiciliar varchar(15),
pfrequenta_Centro varchar(5)
)
BEGIN
	INSERT INTO tb_socio_economico (id_titular, escolariedade, renda_mensal_familia, programas_sociais,
    composicao_familiar, moradia, estrutura_Moradia, qtdPessoas_Trabalhando, emprego, profissao_Responsavel,
    AB_Agua, SN_basico, Energia_eletrica, Lixo_Domiciliar, frequenta_Centro) 
    VALUES (pidtitular, pescolariedade, prenda_mensal_familia, pprogramas_sociais, pcomposicao_familiar,
    pmoradia, pestrutura_Moradia, pqtdPessoas_Trabalhando, pemprego, pprofissao_Responsavel, pAB_Agua,
    pSN_basico, pEnergia_eletrica, pLixo_Domiciliar, pfrequenta_Centro);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_socio_economico_saude` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_socio_economico_saude`(
pidtitular int,
pdoenca varchar(100), 
poutras_Doencas varchar(100), 
pdeficiencia varchar(3), 
pjustificativa_Deficiencia varchar(100), 
plaudo varchar(100), 
pobservacao varchar(100)
)
BEGIN
	INSERT INTO tb_socio_economico_saude (id_titular, doenca, outras_Doencas, deficiencia,
    justificativa_Deficiencia, laudo, observacao) 
    VALUES (pidtitular, pdoenca, poutras_Doencas, pdeficiencia, pjustificativa_Deficiencia,
    plaudo, pobservacao);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_salvar_titular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_salvar_titular`(
pnome_Completo varchar(100), 
pnome_Social varchar(100), 
pcor_cliente varchar(100), 
pnome_Mae varchar(100), 
ptelefone varchar(20), 
pdata_Nascimento varchar(20), 
pidade_cliente int (12), 
pgenero_cliente varchar(30), 
pestado_Civil varchar(50), 
prg varchar(20), 
pcpf varchar(20), 
pstatus_Cliente varchar(8),
pcep varchar(20),
pbairro varchar(50), 
prua varchar(100), 
pnumero varchar(20), 
preferencia varchar(100), 
pnacionalidade varchar(50), 
pnaturalidade varchar(50),
pcidade varchar(50),
ptempoDeMoradia_cliente varchar(30)
)
BEGIN
	
    DECLARE videndereco, vidtitular int;
    
    INSERT INTO tb_endereco (cep, bairro, rua, numero, referencia, nacionalidade, naturalidade, cidade, tempoDeMoradia_cliente) 
    VALUES (pcep, pbairro, prua, pnumero, preferencia, pnacionalidade, pnaturalidade, pcidade, ptempoDeMoradia_cliente);
    SET videndereco = last_insert_id();
    
    INSERT INTO tb_titular (id_endereco, nome_Completo, nome_Social, cor_cliente, nome_Mae, telefone, data_Nascimento, 
    idade_cliente, genero_cliente, estado_Civil, rg, cpf, status_Cliente) 
    VALUES (videndereco, pnome_Completo, pnome_Social, pcor_cliente, pnome_Mae, ptelefone, pdata_Nascimento, 
    pidade_cliente, pgenero_cliente, pestado_Civil, prg, pcpf, pstatus_Cliente);
    
    INSERT INTO tb_clientes (nome_cliente, cpf_cliente, rg_cliente, idade_cliente, genero) VALUE (pnome_Completo, pcpf, prg, pidade_cliente, pgenero_cliente);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_cliente`(
IN pid int,
IN pnome_Completo varchar(100), 
IN pnome_Social varchar(100), 
IN pcor_cliente varchar(100), 
IN pnome_Mae varchar(100), 
IN ptelefone varchar(20), 
IN pdata_Nascimento varchar(20), 
IN pidade_cliente int(12), 
IN pgenero_cliente varchar(30), 
IN pestado_Civil varchar(50), 
IN prg varchar(20), 
IN pcpf varchar(20), 
IN pstatus_Cliente varchar(8),
IN pcep varchar(20),
IN pbairro varchar(50), 
IN prua varchar(100), 
IN pnumero varchar(20), 
IN preferencia varchar(100), 
IN pnacionalidade varchar(50), 
IN pnaturalidade varchar(50),
IN pcidade varchar(50),
IN ptempoDeMoradia_cliente varchar(30)
)
BEGIN
	UPDATE tb_endereco set cep = pcep, bairro = pbairro, rua = prua, numero = pnumero, 
    referencia = preferencia, nacionalidade = pnacionalidade, naturalidade = pnaturalidade, cidade = pcidade,
    tempoDeMoradia_cliente = ptempoDeMoradia_cliente, registration_date_update = CURRENT_TIMESTAMP
    WHERE id = pid;

	UPDATE tb_clientes set id_endereco = pid, nome_Completo = pnome_Completo, nome_Social = pnome_Social,
    cor_cliente = pcor_cliente, nome_Mae = pnome_Mae, telefone = ptelefone, data_Nascimento = pdata_Nascimento,
    idade_cliente = pidade_cliente, genero_cliente = pgenero_cliente, estado_Civil = pestado_Civil,
    rg = prg, cpf = pcpf, status_Cliente = pstatus_Cliente, registration_date_update = CURRENT_TIMESTAMP
    WHERE id = pid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_dependente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_dependente`(
IN pid int,
IN pid_titular int, 
IN pnome_dependente varchar(100), 
IN prg varchar(10), 
IN pcpf varchar(15), 
IN pIdade int, 
IN pgenero varchar(10), 
IN pdependencia_cliente varchar(50)
)
BEGIN
	UPDATE tb_dependentes set id_titular = pid_titular, nome_dependente = pnome_dependente, rg = prg, cpf = pcpf, 
    Idade = pIdade, genero = pgenero, dependencia_cliente = pdependencia_cliente, registration_date_update = CURRENT_TIMESTAMP
    WHERE id = pid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_funcionarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_funcionarios`(
IN pid int,
IN pnome varchar (100),
IN pfuncao varchar (100),
IN ptelefone varchar (15),
IN plogin varchar (100),
IN ppassword varchar (250),
IN pperfil varchar (50)
)
BEGIN
	UPDATE tb_funcionario set nome = pnome, funcao = pfuncao, telefone = ptelefone, registration_date_update = CURRENT_TIMESTAMP WHERE id = pid;
    UPDATE tb_user set id_funcionario = pid, login = plogin , password = ppassword, perfil = pperfil, registration_date_update = CURRENT_TIMESTAMP  WHERE id = pid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_titular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_titular`(
IN pid int,
IN pnome_Completo varchar(100), 
IN pnome_Social varchar(100), 
IN pcor_cliente varchar(100), 
IN pnome_Mae varchar(100), 
IN ptelefone varchar(20), 
IN pdata_Nascimento varchar(20), 
IN pidade_cliente int(12), 
IN pgenero_cliente varchar(30), 
IN pestado_Civil varchar(50), 
IN prg varchar(20), 
IN pcpf varchar(20), 
IN pstatus_Cliente varchar(8),
IN pcep varchar(20),
IN pbairro varchar(50), 
IN prua varchar(100), 
IN pnumero varchar(20), 
IN preferencia varchar(100), 
IN pnacionalidade varchar(50), 
IN pnaturalidade varchar(50),
IN pcidade varchar(50),
IN ptempoDeMoradia_cliente varchar(30)
)
BEGIN
	UPDATE tb_endereco set cep = pcep, bairro = pbairro, rua = prua, numero = pnumero, 
    referencia = preferencia, nacionalidade = pnacionalidade, naturalidade = pnaturalidade, cidade = pcidade,
    tempoDeMoradia_cliente = ptempoDeMoradia_cliente, registration_date_update = CURRENT_TIMESTAMP
    WHERE id = pid;

	UPDATE tb_titular set id_endereco = pid, nome_Completo = pnome_Completo, nome_Social = pnome_Social,
    cor_cliente = pcor_cliente, nome_Mae = pnome_Mae, telefone = ptelefone, data_Nascimento = pdata_Nascimento,
    idade_cliente = pidade_cliente, genero_cliente = pgenero_cliente, estado_Civil = pestado_Civil,
    rg = prg, cpf = pcpf, status_Cliente = pstatus_Cliente, registration_date_update = CURRENT_TIMESTAMP
    WHERE id = pid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `teste` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `teste`(
pid int
)
BEGIN
select t.id, t.nome_Completo, t.genero_cliente, d.id, d.nome_dependente, d.Idade, d.dependencia_cliente from tb_titular t inner join tb_dependentes d on d.id_titular = t.id where d.id_titular = pid;
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

-- Dump completed on 2023-05-17 12:29:46
