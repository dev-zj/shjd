/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_group_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_group_info`;
CREATE TABLE `equip_group_info` (
  `group_id` bigint(10) NOT NULL auto_increment COMMENT '课题组编号',
  `group_name` varchar(100) character set gbk default NULL COMMENT '课题组名称',
  `group_owner_id` int(10) default NULL COMMENT '课题组组长编号',
  `created_by` varchar(100) character set gbk default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_group_info
-- ----------------------------
INSERT INTO `equip_group_info` VALUES ('1', '张均的课题组', '1', 'sysdate', '2014-08-27');
