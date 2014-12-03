/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : wxaddb

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-11-16 22:46:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `send_info`
-- ----------------------------
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

-- ----------------------------
-- Records of send_info
-- ----------------------------
INSERT INTO `send_info` VALUES ('1', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'http://www.wxad2014.com', '5', '0', '20', 'brower_info', 'true', '20', 'true', null);
INSERT INTO `send_info` VALUES ('2', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'http://www.wxad2014.com/', '5', '0', '20', 'brower_info', 'true', '20', 'true', null);
