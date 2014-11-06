/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:53:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_book_order`
-- ----------------------------
DROP TABLE IF EXISTS `equip_book_order`;
CREATE TABLE `equip_book_order` (
  `order_id` int(10) NOT NULL auto_increment,
  `equip_id` int(10) default NULL COMMENT '仪器设备号',
  `equip_name` varchar(100) character set gbk default NULL COMMENT '仪器名称',
  `use_start_time` datetime default NULL COMMENT '使用开始时间',
  `use_end_time` datetime default NULL COMMENT '使用结束时间',
  `use_time` decimal(6,1) default NULL COMMENT '使用时长',
  `unit_price` decimal(10,2) default NULL COMMENT '单价',
  `use_price` decimal(10,2) default NULL COMMENT '使用计费',
  `user_id` int(10) default NULL COMMENT '使用者',
  `order_time` datetime default NULL COMMENT '流水生成时间',
  `order_status` varchar(10) character set gbk default NULL COMMENT '预约状态(tocheck待审核;checked审核通过；unchecked审核不通过;cancle取消）',
  `audit_user` int(10) default NULL COMMENT '审核者',
  `audit_time` datetime default NULL COMMENT '审核日期',
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equip_book_order
-- ----------------------------
INSERT INTO `equip_book_order` VALUES ('1', '2', '场射电子显微镜', '2014-08-31 01:47:00', '2014-09-01 01:48:22', null, '200.00', null, '2', '2014-08-31 01:48:37', 'cancle', '1', '2014-08-31 01:49:01');
INSERT INTO `equip_book_order` VALUES ('2', '2', '场射电子显微镜', '2014-08-29 04:28:43', '2014-08-29 06:29:01', null, '100.00', null, '2', '2014-08-29 14:29:27', 'cancle', '1', '2014-08-31 14:29:53');
INSERT INTO `equip_book_order` VALUES ('3', '2', '场射电子显微镜', '2014-08-29 07:30:05', '2014-08-29 09:30:13', null, '200.00', null, '2', '2014-08-31 14:30:30', 'checked', '1', '2014-08-31 14:29:53');
INSERT INTO `equip_book_order` VALUES ('4', '2', '场射电子显微镜', '2014-08-30 08:30:51', '2014-08-30 14:30:58', null, '200.00', null, '2', '2014-08-31 14:31:10', 'tocheck', '1', '2014-08-31 14:29:53');
INSERT INTO `equip_book_order` VALUES ('7', '3', '场发射电子镜1', '2014-08-31 17:00:00', '2014-08-31 18:00:00', '0.0', null, null, '2', '2014-08-31 18:28:04', 'cancle', '1', null);
INSERT INTO `equip_book_order` VALUES ('8', '3', '场发射电子镜', '2014-08-31 00:00:00', '2014-08-31 01:00:00', '0.0', null, null, '2', '2014-08-31 18:29:18', 'cancle', '1', null);
INSERT INTO `equip_book_order` VALUES ('9', '3', '场发射电子镜', '2014-08-31 01:13:00', '2014-08-31 01:38:00', '0.0', null, null, '2', '2014-08-31 18:32:09', 'unchecked', '1', null);
INSERT INTO `equip_book_order` VALUES ('10', '2', '场射电子显微镜', '2014-08-29 00:00:00', '2014-08-30 00:00:00', '0.0', null, null, '2', '2014-08-31 21:32:15', 'cancle', '1', null);
INSERT INTO `equip_book_order` VALUES ('11', '2', '场射电子显微镜', '2014-08-01 00:00:00', '2014-08-30 00:00:00', '0.0', null, null, '2', '2014-08-31 21:33:20', 'tocheck', '1', null);
INSERT INTO `equip_book_order` VALUES ('12', '2', '场射电子显微镜', '2015-02-05 00:00:08', '2015-03-20 00:00:00', '0.0', null, null, '2', '2014-09-06 16:18:41', 'cancle', '1', null);
INSERT INTO `equip_book_order` VALUES ('13', '1', '场发射透射电子', '2014-09-06 00:00:00', '2014-09-06 03:00:00', '0.0', null, null, '5', '2014-09-06 21:11:24', 'tocheck', '1', null);
