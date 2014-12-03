/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : wxaddb

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-11-16 22:46:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pop_info`
-- ----------------------------
DROP TABLE IF EXISTS `pop_info`;
CREATE TABLE `pop_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `netType` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `isShowAd` varchar(255) DEFAULT NULL,
  `lastShowAdDate` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pop_info
-- ----------------------------
INSERT INTO `pop_info` VALUES ('1', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('2', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('3', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('4', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('5', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('6', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('7', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('8', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('9', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('10', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('11', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('12', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('13', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('14', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('15', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('16', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('17', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('18', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('19', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('20', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('21', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('22', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('23', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('24', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('25', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('26', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('27', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('28', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('29', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('30', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('31', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('32', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('33', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('34', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('35', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('36', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('37', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('38', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('39', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('40', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('41', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('42', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('43', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('44', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('45', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('46', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('47', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('48', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('49', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('50', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('51', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('52', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('53', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('54', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('55', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('56', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('57', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('58', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('59', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('60', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('61', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('62', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('63', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('64', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('65', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('66', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('67', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('68', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('69', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('70', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('71', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('72', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('73', '2471235e-9e76-4cc5-b8a6-fd03d007fd6d', 'zh', 'WIFI', 'a012233', 'true', '2014-09-12', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('74', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('75', '5cecc3bd-d534-4749-92b4-3649181cd06f', 'en', 'WIFI', 'a012233', 'true', '2014-09-19', 'US', null, null);
INSERT INTO `pop_info` VALUES ('76', '5cecc3bd-d534-4749-92b4-3649181cd06f', 'en', 'WIFI', 'a012233', 'true', '2014-09-19', 'US', null, null);
INSERT INTO `pop_info` VALUES ('77', '5cecc3bd-d534-4749-92b4-3649181cd06f', 'en', 'WIFI', 'a012233', 'true', '2014-09-19', 'US', null, null);
INSERT INTO `pop_info` VALUES ('78', 'f6d2af0b-a832-4491-a482-02e4db5fc626', 'en', 'WIFI', 'a012233', 'true', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('79', 'f6d2af0b-a832-4491-a482-02e4db5fc626', 'en', 'WIFI', 'a012233', 'true', '2014-09-19', 'US', null, null);
INSERT INTO `pop_info` VALUES ('80', '4ec06f12-29cc-458a-b04e-328de6c95e31', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('81', '4ec06f12-29cc-458a-b04e-328de6c95e31', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('82', '661c4126-5a29-46a7-b0b5-9920da69c282', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('83', '661c4126-5a29-46a7-b0b5-9920da69c282', 'en', 'WIFI', '', 'true', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('84', '661c4126-5a29-46a7-b0b5-9920da69c282', 'en', 'WIFI', '', 'true', '2014-10-20', 'US', null, null);
INSERT INTO `pop_info` VALUES ('85', '4ec06f12-29cc-458a-b04e-328de6c95e31', 'en', 'WIFI', 'a012233', 'true', '2014-10-19', 'US', null, null);
INSERT INTO `pop_info` VALUES ('86', '51f5d6b1-a535-46ef-af03-344354225da8', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('87', '8d9929a3-eb1c-4b99-a06d-bc8fe9fa103c', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('88', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('89', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('90', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-10-31', 'US', null, null);
INSERT INTO `pop_info` VALUES ('91', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-10-31', 'US', null, null);
INSERT INTO `pop_info` VALUES ('92', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-11-05', 'US', null, null);
INSERT INTO `pop_info` VALUES ('93', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-11-16', 'US', null, null);
INSERT INTO `pop_info` VALUES ('94', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-11-22', 'US', null, null);
INSERT INTO `pop_info` VALUES ('95', 'cebd5f30-8642-41c1-9d6b-75cb7ec4a8cd', 'en', 'WIFI', '', 'true', '2014-11-23', 'US', null, null);
INSERT INTO `pop_info` VALUES ('96', 'e9f1342d-ec74-4cb8-8bbb-4af5366a371d', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('97', 'e9f1342d-ec74-4cb8-8bbb-4af5366a371d', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('98', 'e9f1342d-ec74-4cb8-8bbb-4af5366a371d', 'en', 'WIFI', '', 'true', '2014-10-24', 'US', null, null);
INSERT INTO `pop_info` VALUES ('99', 'fa13676a-f591-4fa6-994d-99468cfcf8d0', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('100', 'a2a9b864-f244-44d1-a2f0-c403de730395', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('101', '098ebe20-0ff1-49a3-b7bf-a5c54213b500', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('102', 'd60abd0b-d3e2-4a13-bd4e-080000060a1e', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('103', 'd60abd0b-d3e2-4a13-bd4e-080000060a1e', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('104', 'b342b341-f09e-4ba2-9059-c53db994e2ba', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('105', '577d7d42-6d6d-4174-9efe-2d2f75375568', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('106', '577d7d42-6d6d-4174-9efe-2d2f75375568', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('107', '577d7d42-6d6d-4174-9efe-2d2f75375568', 'en', 'WIFI', '', 'true', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('108', '577d7d42-6d6d-4174-9efe-2d2f75375568', 'en', 'WIFI', '', 'true', '2014-10-25', 'US', null, null);
INSERT INTO `pop_info` VALUES ('109', '0f3e9dfd-18f2-4f03-81a8-2741d7665dd1', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('110', '0f3e9dfd-18f2-4f03-81a8-2741d7665dd1', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('111', '4ec06f12-29cc-458a-b04e-328de6c95e31', 'en', 'WIFI', 'a012233', 'true', '2014-10-22', 'US', null, null);
INSERT INTO `pop_info` VALUES ('112', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('113', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('114', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('115', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('116', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-11-26', 'US', null, null);
INSERT INTO `pop_info` VALUES ('117', '9dd25d69-7e93-44a6-9243-32416bc7fd87', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('118', '9dd25d69-7e93-44a6-9243-32416bc7fd87', 'en', 'WIFI', '', 'true', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('119', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-12-27', 'US', null, null);
INSERT INTO `pop_info` VALUES ('120', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-12-27', 'US', null, null);
INSERT INTO `pop_info` VALUES ('121', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-12-27', 'US', null, null);
INSERT INTO `pop_info` VALUES ('122', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-09-25', 'US', null, null);
INSERT INTO `pop_info` VALUES ('123', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-09-26', 'US', null, null);
INSERT INTO `pop_info` VALUES ('124', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-09-25', 'US', null, null);
INSERT INTO `pop_info` VALUES ('125', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-09-25', 'US', null, null);
INSERT INTO `pop_info` VALUES ('126', '26666cf2-ff64-4743-954b-b453ef83fc94', 'en', 'WIFI', 'a012233', 'true', '2014-09-25', 'US', null, null);
INSERT INTO `pop_info` VALUES ('127', 'f1b3fc88-2d3d-4cdc-b7ca-9ba73d1f349b', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('128', '6f603a3c-21fd-4259-b529-d6e89302c890', 'en', 'WIFI', 'a012233', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('129', '0baacdd0-d3bd-48a9-af33-5a96f8f91f1f', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('130', '0baacdd0-d3bd-48a9-af33-5a96f8f91f1f', 'en', 'WIFI', '', 'false', '', 'US', null, null);
INSERT INTO `pop_info` VALUES ('131', '0baacdd0-d3bd-48a9-af33-5a96f8f91f1f', 'en', 'WIFI', '', 'true', '2014-10-26', 'US', null, null);
INSERT INTO `pop_info` VALUES ('132', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('133', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('134', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('135', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('136', '82698809-b3f5-4b04-9b00-9f31e9d9bda8', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('137', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('138', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('139', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', null, null);
INSERT INTO `pop_info` VALUES ('140', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('141', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('142', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('143', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('144', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('145', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('146', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0:0:0:0:0:0:0:1');
INSERT INTO `pop_info` VALUES ('147', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0:0:0:0:0:0:0:1');
INSERT INTO `pop_info` VALUES ('148', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('149', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('150', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('151', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '广东省');
INSERT INTO `pop_info` VALUES ('152', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '{country : 广东省');
INSERT INTO `pop_info` VALUES ('153', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '\\u4e2d\\u56fd : 广东省');
INSERT INTO `pop_info` VALUES ('154', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '中国 : 广东省');
INSERT INTO `pop_info` VALUES ('155', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('156', '392eb63b-de2d-466b-8d34-21a3b9b1de0d', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('157', '392eb63b-de2d-466b-8d34-21a3b9b1de0d', 'zh', 'WIFI', 'a012233', 'false', '', 'CN', '', '0');
INSERT INTO `pop_info` VALUES ('158', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
INSERT INTO `pop_info` VALUES ('159', 'bd7d967f-b3f8-43f4-a42a-a9067a708fc0', 'zh', 'WIFI', '', 'false', '', 'CN', '', null);
