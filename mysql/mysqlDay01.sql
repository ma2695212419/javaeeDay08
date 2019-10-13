-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: mysqlDay01
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  PRIMARY KEY (`id`),
  KEY `fk_emp_dept` (`deptId`),
  CONSTRAINT `fk_emp_dept` FOREIGN KEY (`deptId`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_dept`
--

DROP TABLE IF EXISTS `emp_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_dept` (
  `empId` int(11) NOT NULL COMMENT '员工编号',
  `deptId` int(11) NOT NULL COMMENT '部门编号',
  PRIMARY KEY (`empId`,`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_dept`
--

LOCK TABLES `emp_dept` WRITE;
/*!40000 ALTER TABLE `emp_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp01`
--

DROP TABLE IF EXISTS `tb_emp01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp01` (
  `id` int(11) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(50) DEFAULT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT NULL COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp01`
--

LOCK TABLES `tb_emp01` WRITE;
/*!40000 ALTER TABLE `tb_emp01` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp02`
--

DROP TABLE IF EXISTS `tb_emp02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp02` (
  `id` int(11) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(50) DEFAULT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp02`
--

LOCK TABLES `tb_emp02` WRITE;
/*!40000 ALTER TABLE `tb_emp02` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp04`
--

DROP TABLE IF EXISTS `tb_emp04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp04` (
  `id` int(11) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp04`
--

LOCK TABLES `tb_emp04` WRITE;
/*!40000 ALTER TABLE `tb_emp04` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp05`
--

DROP TABLE IF EXISTS `tb_emp05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp05` (
  `id` int(11) NOT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp05`
--

LOCK TABLES `tb_emp05` WRITE;
/*!40000 ALTER TABLE `tb_emp05` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp06`
--

DROP TABLE IF EXISTS `tb_emp06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp06` (
  `id` int(11) NOT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp06`
--

LOCK TABLES `tb_emp06` WRITE;
/*!40000 ALTER TABLE `tb_emp06` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp07`
--

DROP TABLE IF EXISTS `tb_emp07`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp07` (
  `id` int(11) NOT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp07`
--

LOCK TABLES `tb_emp07` WRITE;
/*!40000 ALTER TABLE `tb_emp07` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp07` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp08`
--

DROP TABLE IF EXISTS `tb_emp08`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp08` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp08`
--

LOCK TABLES `tb_emp08` WRITE;
/*!40000 ALTER TABLE `tb_emp08` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp08` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp11`
--

DROP TABLE IF EXISTS `tb_emp11`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp11` (
  `id` int(11) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(50) DEFAULT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT NULL COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp11`
--

LOCK TABLES `tb_emp11` WRITE;
/*!40000 ALTER TABLE `tb_emp11` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp11` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp12`
--

DROP TABLE IF EXISTS `tb_emp12`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emp12` (
  `id` int(11) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(50) DEFAULT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT NULL COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资'
) ENGINE=MyISAM DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp12`
--

LOCK TABLES `tb_emp12` WRITE;
/*!40000 ALTER TABLE `tb_emp12` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp12` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03 11:38:15
