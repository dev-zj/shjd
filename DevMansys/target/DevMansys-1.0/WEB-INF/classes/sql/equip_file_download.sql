/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:53:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_file_download`
-- ----------------------------
DROP TABLE IF EXISTS `equip_file_download`;
CREATE TABLE `equip_file_download` (
  `id` int(10) NOT NULL auto_increment,
  `path` varchar(400) default NULL,
  `name` varchar(400) default NULL,
  `cdate` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of equip_file_download
-- ----------------------------
INSERT INTO `equip_file_download` VALUES ('1', 'e:/test/', 'test.txt', '2014-09-26');
INSERT INTO `equip_file_download` VALUES ('2', 'e:/test/', 'test1.txt', '2014-10-09');
