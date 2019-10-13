-- MySQL dump 10.13  Distrib 5.7.27, for Win64 (x86_64)
--
-- Host: localhost    Database: javaeeDay02
-- ------------------------------------------------------
-- Server version	5.7.27

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
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `uuid` varchar(255) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '123456',
  `nickname` varchar(255) NOT NULL DEFAULT '',
  `gender` int(1) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE,
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES ('1076f6aec30803e35de4ab0bacc09da7d54f861402c088','admin','123456','李昊哲',1,'1983-11-22 20:30:00'),('1076f6aec30803e35de4ab0bacc09da7d54f861402c089','xujianfei','123456','徐渐飞',1,'2019-09-16 15:23:44'),('11186500089230f0b864777990b9d0fc6c0bbba4dca30e','chenghong','123456','程洪',1,'1999-07-08 00:00:08'),('1c567ad183fac4e04a545aa802fe1fd8cade971adbd63','SunJingxuan','666666','孙敬轩',1,'1999-03-03 20:20:20'),('20f504f3d20b722555a4ff2ae4d23b4d5ebc4fb506b044','sunhongyu','123456','孙洪玉',1,'1998-03-30 16:10:00'),('20f504f3d20b722555a4ff2ae4d24b3d5ebc4fb506b035','wuchengzhuo','123456','吴成卓',1,'1992-09-27 15:20:21'),('28d8f257704a11c88d24ec1aad2fa78a900ea364f81677','zhangshuaishuai','123456','张帅帅',1,'1998-08-24 15:21:03'),('2ad8dbb44c1c61ce51245f8a9a2b1aeec4355384db41b3','zhangyuanhao','123456','张圆豪',1,'2019-09-16 15:29:03'),('30a33911b24416fed8a4aeaacddd307d02ea763252c57f','wangyu','123456','王雨',1,'1997-02-18 15:21:53'),('30b2e34a42b955596084f2dbc3417b115c84c3e59ca147','zhangxianxianli','123456','张仙利',2,'1992-02-04 22:22:22'),('336be4e23dc25000b3f4911b7ff05d8e2d3d546b3e4ec','mazepeng','123456','马泽朋',1,'1999-01-15 03:22:41'),('388388f488ca37c80dc4efe8e389cec4fc0c5cd1d02339','zailinglei','123456','宰令磊',1,'1996-05-04 15:33:23'),('392300d5c265e92aead4b10a09ebd0fd8385ead1b68ad6','xiongshengtao','123456','熊盛涛',1,'1997-05-07 20:00:00'),('397fb797df26dea730a46a48ea3639e07ec5d9035875f2','wanglei','123456','王磊',1,'1998-06-10 15:17:50'),('430ba6b8bf459868c7146a99273b4e66591b38b5466f72','songxiangyang','123456','宋向阳',1,'1996-01-01 12:00:00'),('465493512a23375b0d0496389661bbe0f1a96d21d46e76','lvpengshuai','123456','吕鹏帅',1,'2019-09-16 15:34:01'),('4a50407c8e2b58504464e109829df0817f8bfbb420ee3a','wuzhichao','123456','吴智超',1,'1997-01-13 15:25:47'),('4b3edd04a8a29b3e1d24142b96e452fc582d5fd280e582','dijianze','123456','狄建泽',1,'1998-09-07 15:19:06'),('4b56c9530ed7456f33a4cafac72b3ad14609b311782924','qinboyue','123456','秦博越',1,'1995-07-02 15:21:17'),('4c7984d9997e586df4b46d4b55fe0e0c856aaf4e29981','lixijun','123456','李茜骏',1,'1998-11-16 15:25:50'),('4dddd2ce8ef6aceeeae4731a621dda99d218fb94dfd532','xuzhiwen','123456','徐志文',1,'1995-10-02 15:30:17'),('4e7a37fca6a4acf46fc475988e51ea70dbba9d14acb647','nlqiong','123456','牛力琼',1,'1963-06-19 15:27:01'),('4e7a37fca6a4acf46fc475988e51ea70dbba9d14acb803','zhanghaoxiang','123456','张好祥',1,'1997-03-01 00:00:00'),('53ecff5326ac300d70a489394794441e05eefdc1037d8d','wangjiajun','123456','王佳俊',1,'1995-04-28 04:26:13'),('55b07886ace5f957e7546ab9f8c0d6604db8743399aa89','shanchuanxing','123456','单传兴',1,'1995-12-22 15:39:08'),('55b07886ace5f957e7546ab9f8c0d6604db8743399bb3b','hanshuailong','123456','韩帅龙',1,'1998-08-24 15:21:03'),('586173e4a9578bb927a4689a547ee4473b34a5915e4b52','hutingting','123456','胡婷婷',0,'1995-01-01 15:25:19'),('58bac1e77692599b97d41c9b1b0851a9a5b3a49470a459','lichen','123456','李陈',1,'1996-09-24 16:38:55'),('590d392f0f81b20062343a5938f4bff21b500272cb0113','huangjunlong','123456','黄俊龙',1,'2019-09-16 15:23:50'),('5bc5ee771f8f482cedf44b79bc8f27e96a6c86244e48cc','LiZhaopeng','123456','李朝蓬',1,'1999-02-02 15:15:15'),('5c9f15815fd6b745d7846d3b0a673d6b6fbdb4757562d4','chenfeihong','123456','陈飞宏',1,'1998-09-27 15:33:48'),('5ce8cb63424234f4677409d80690536263e704715b9cce','zhuchengbin','123456','朱诚斌',1,'2000-01-01 00:00:00'),('5ce8cb63424234f4677409d80690536263e704715b9crr','zhangzexing','123456','张泽星',1,'1996-06-12 15:24:06'),('5ce8cb634d913af4677409d80690536263e704715b9c11','weidongdong','123456','魏冬东',1,'1989-01-01 15:22:23'),('b8b1b87c2de305a3274d0583fbbd118bfb21191b81a11','anzhaowang','123456','安兆旺',1,'1998-08-30 15:25:38'),('b8b1b87c2de305a3274d0583fbbd118bfb21191b85648','lijie','123456','李杰',1,'1996-08-23 15:49:26');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-08 17:40:59
