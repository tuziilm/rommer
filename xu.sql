/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.6.10 : Database - wxaddb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wxaddb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wxaddb`;

/*Table structure for table `activity_user` */

DROP TABLE IF EXISTS `activity_user`;

CREATE TABLE `activity_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channel` varchar(100) DEFAULT NULL,
  `lastShowAdDate` varchar(50) DEFAULT NULL,
  `country` varchar(150) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx` (`channel`,`lastShowAdDate`,`country`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Table structure for table `pop_info` */

DROP TABLE IF EXISTS `pop_info`;

CREATE TABLE `pop_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `netType` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `isShowAd` varchar(255) DEFAULT NULL,
  `lastShowAdDate` text,
  `country` varchar(255) DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `onLineTime` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

/*Table structure for table `pop_info_bak` */

DROP TABLE IF EXISTS `pop_info_bak`;

CREATE TABLE `pop_info_bak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(150) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `netType` varchar(255) DEFAULT NULL,
  `channel` varchar(150) DEFAULT NULL,
  `isShowAd` varchar(255) DEFAULT NULL,
  `lastShowAdDate` text,
  `country` varchar(150) DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `onLineTime` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_pop` (`uuid`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Table structure for table `send_info` */

DROP TABLE IF EXISTS `send_info`;

CREATE TABLE `send_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `homePageUrl` varchar(255) DEFAULT NULL,
  `countInstall` varchar(255) DEFAULT NULL,
  `homePageType` varchar(255) DEFAULT NULL,
  `clickRate` varchar(255) DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `isShowAd` varchar(255) DEFAULT NULL,
  `showAdDay` varchar(255) DEFAULT NULL,
  `isControlShow` varchar(255) DEFAULT NULL,
  `clickHour` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `send_indexs` (`uuid`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `passwd` varchar(96) DEFAULT NULL,
  `sys_user_type` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `privilege` varchar(300) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `channel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
