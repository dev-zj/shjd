/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_category_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_category_info`;
CREATE TABLE `equip_category_info` (
  `cate_id` int(10) NOT NULL auto_increment COMMENT '仪器ID',
  `cate_code` varchar(100) character set gbk default NULL COMMENT '编码',
  `cate_name` varchar(100) character set gbk default NULL COMMENT '仪器名称',
  `created_by` varchar(100) character set gbk default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_category_info
-- ----------------------------
INSERT INTO `equip_category_info` VALUES ('1', 'equip_DJ', '电镜仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('2', 'equip_ZP', '质谱仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('3', 'equip_XSX', 'X射线仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('4', 'equip_GP', '光谱仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('5', 'equip_SP', '色谱仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('6', 'equip_HC', '核磁仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('7', 'equip_XWJ', '显微镜及图像分析仪器', 'system', '2014-08-24');
INSERT INTO `equip_category_info` VALUES ('8', 'equip_RFX', '热分析仪器', 'system', '2014-08-24');
