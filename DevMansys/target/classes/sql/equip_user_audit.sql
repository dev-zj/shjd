/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_user_audit`
-- ----------------------------
DROP TABLE IF EXISTS `equip_user_audit`;
CREATE TABLE `equip_user_audit` (
  `id` int(10) NOT NULL COMMENT '用户ID',
  `user_status` varchar(10) character set gbk default NULL COMMENT '用户状态(todo待审核；doing审核通过待注册；done注册完成)',
  `check_date` date default NULL COMMENT '审核日期',
  `check_user_id` int(10) default NULL COMMENT '审核人员',
  `created_by` varchar(20) character set gbk default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_user_audit
-- ----------------------------
INSERT INTO `equip_user_audit` VALUES ('2', 'done', '2014-08-26', '1', 'sysdate', '2014-08-26');
INSERT INTO `equip_user_audit` VALUES ('4', 'done', '2014-09-06', '1', 'system', '2014-09-04');
INSERT INTO `equip_user_audit` VALUES ('5', 'done', '2014-09-06', '1', 'system', '2014-09-04');
