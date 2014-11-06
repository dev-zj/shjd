/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_role_info`;
CREATE TABLE `equip_role_info` (
  `role_id` int(10) NOT NULL auto_increment COMMENT '角色ID',
  `role_property` varchar(10) character set gbk default NULL COMMENT '角色属性(super、normal、user)',
  `role_desc` varchar(20) character set gbk default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_role_info
-- ----------------------------
INSERT INTO `equip_role_info` VALUES ('1', 'super', '超级管理员');
INSERT INTO `equip_role_info` VALUES ('2', 'normal', '普通管理员');
INSERT INTO `equip_role_info` VALUES ('3', 'user', '普通用户');
INSERT INTO `equip_role_info` VALUES ('4', 'tleader', '课题组长');
