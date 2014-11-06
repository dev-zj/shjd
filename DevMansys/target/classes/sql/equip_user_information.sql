/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:54:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_user_information`
-- ----------------------------
DROP TABLE IF EXISTS `equip_user_information`;
CREATE TABLE `equip_user_information` (
  `id` int(10) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(20) character set gbk default NULL COMMENT '姓名',
  `sex` varchar(20) character set gbk default NULL COMMENT '性别(female女性male男性)',
  `this_school` varchar(10) character set gbk default NULL COMMENT '是否本校(yes;no)',
  `tgroup` varchar(20) character set gbk default NULL COMMENT '所属学校或者单位',
  `series` varchar(30) character set gbk default NULL COMMENT '所属院系或者部门',
  `card_no` varchar(40) character set gbk default NULL COMMENT '一卡通卡号',
  `tel_no` varchar(20) character set gbk default NULL COMMENT '联系电话',
  `address` varchar(200) character set gbk default NULL COMMENT '联系地址',
  `email` varchar(200) character set gbk default NULL COMMENT '联系邮箱',
  `user_property` varchar(10) character set gbk default NULL COMMENT '用户性质(long长期用户；book预约用户)',
  `is_tleader` varchar(10) character set gbk default NULL COMMENT '是否课题组长(yes;no)',
  `team_id` bigint(10) default NULL COMMENT '所属课题组(外键)',
  `is_administrator` varchar(10) character set gbk default NULL COMMENT '是否管理员yes;no',
  `admin_property` varchar(10) character set gbk default NULL COMMENT '管理员属性',
  `created_by` varchar(20) character set gbk default NULL COMMENT '创建者',
  `created_date` date default NULL COMMENT '创建日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_user_information
-- ----------------------------
INSERT INTO `equip_user_information` VALUES ('1', '超级管理员', 'male', 'yes', null, null, null, '021-54742571', '上海市东川路800号', 'sjtuscce@163.com', 'long', 'no', null, 'yes', 'super', 'sysdate', '2014-08-20');
INSERT INTO `equip_user_information` VALUES ('2', '张三', 'female', 'yes', '数科院', '计算机系', '06030623', '021-38634567', '上海市东川路', 'zhangsan@hotmail.com', 'book', 'no', '1', 'no', 'user', 'sysdate', '2014-08-20');
INSERT INTO `equip_user_information` VALUES ('4', '张均', 'male', 'yes', '南京师范大学', '计算机科学与技术', '0603-623', '13167219006', '上海市浦东新区华夏东路', 'zhangjun@hotmail.com', null, null, null, 'no', 'user', 'system', '2014-09-04');
INSERT INTO `equip_user_information` VALUES ('5', '李四', 'female', 'no', '上海交通大学', '新传院', '123123123123', '13776575623', '上海市浦东新区', 'lisi@164.com', null, null, null, 'no', 'user', 'system', '2014-09-04');
