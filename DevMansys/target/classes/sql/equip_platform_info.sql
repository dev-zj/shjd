/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_platform_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_platform_info`;
CREATE TABLE `equip_platform_info` (
  `id` int(10) NOT NULL auto_increment,
  `platform_desc` varchar(3000) character set gbk default NULL,
  `status` varchar(2) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_platform_info
-- ----------------------------
INSERT INTO `equip_platform_info` VALUES ('1', '张均', '1');
