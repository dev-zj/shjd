/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_price_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_price_info`;
CREATE TABLE `equip_price_info` (
  `equip_id` int(10) NOT NULL default '0' COMMENT '主键',
  `equip_price` decimal(18,2) default NULL COMMENT '单价',
  `equip_price_cate` varchar(100) character set gbk NOT NULL default '' COMMENT '计费类别(un-sch非本校；sch-dep本校本院；sch-undep本校非本院；internal内部专用;staff员工专用)',
  `equip_price_valid` date default '9999-12-31' COMMENT '有效期',
  `created_by` varchar(100) character set gbk default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`equip_id`,`equip_price_cate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_price_info
-- ----------------------------
INSERT INTO `equip_price_info` VALUES ('1', '100.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('1', '10.00', 'staff', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('2', '200.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('3', '150.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('4', '69.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('5', '70.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('6', '80.00', 'sch-dep', '9999-12-31', null, null);
INSERT INTO `equip_price_info` VALUES ('7', '35.00', 'sch-dep', '9999-12-31', null, null);
