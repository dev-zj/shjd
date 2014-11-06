/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:53:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_belonging`
-- ----------------------------
DROP TABLE IF EXISTS `equip_belonging`;
CREATE TABLE `equip_belonging` (
  `id` int(10) NOT NULL auto_increment,
  `equip_id` int(10) default NULL COMMENT '设备ID',
  `equip_group_id` int(10) default NULL COMMENT '归属课题组ID',
  `created_by` varchar(100) character set gbk default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_belonging
-- ----------------------------
