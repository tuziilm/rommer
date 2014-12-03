/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : wxaddb

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-11-16 22:46:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
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

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'test', '8af4defdc62234faa80b02fa6ff2bea7', '0', '1', '1', null, '2014-11-15 20:06:01', '2014-11-04 15:38:20', 'a012234');
INSERT INTO `sys_user` VALUES ('2', 'test1', 'c96ef47007e3b0ebd89cdf54030a1fb8', '1', '1', '1', 'ceshi', '2014-11-15 20:05:56', '2014-11-05 17:45:50', 'a012233');
INSERT INTO `sys_user` VALUES ('3', 'test2', 'ce664eb5984f6aec856aa115b1fc3d69', '3', '1', '1', '', '2014-11-15 20:05:58', '2014-11-15 14:14:48', 'a012233');
