/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_user_login`
-- ----------------------------
DROP TABLE IF EXISTS `equip_user_login`;
CREATE TABLE `equip_user_login` (
  `user_id` int(10) NOT NULL default '0' COMMENT '用户ID',
  `login_name` varchar(100) character set gbk default NULL COMMENT '登陆用户名',
  `login_pass` varchar(10) character set gbk default NULL COMMENT '登陆密码',
  `created_by` varchar(100) default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_user_login
-- ----------------------------
INSERT INTO `equip_user_login` VALUES ('1', 'super_admin', '1234567890', 'sysdate', '2014-08-20');
INSERT INTO `equip_user_login` VALUES ('2', 'zhangsan', 'zhangsan', 'sysdate', '2014-08-20');
INSERT INTO `equip_user_login` VALUES ('4', 'zhangjun', 'zhangnjun', 'system', '2014-09-04');
INSERT INTO `equip_user_login` VALUES ('5', 'lisi', 'lisi', 'system', '2014-09-04');
