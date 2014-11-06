/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:52:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_announcement`
-- ----------------------------
DROP TABLE IF EXISTS `equip_announcement`;
CREATE TABLE `equip_announcement` (
  `id` int(100) NOT NULL auto_increment COMMENT '主键',
  `announce_title` varchar(1000) default NULL COMMENT '公告标题',
  `announce_content` varchar(10000) default NULL COMMENT '公告内容',
  `created_by` varchar(100) default NULL COMMENT '创建者',
  `created_date` datetime default NULL COMMENT '创建日期',
  `status` varchar(10) default NULL COMMENT '状态：1有效；2无效',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of equip_announcement
-- ----------------------------
INSERT INTO `equip_announcement` VALUES ('1', '学院公告', '最近有色狼活动，请大家注意安全', '张均', '2014-08-19 23:47:17', '1');
INSERT INTO `equip_announcement` VALUES ('2', '学员新闻', '今天又有人跳楼了，请后面男女同学注意', '毛泽东', '2014-08-20 23:48:10', '1');
INSERT INTO `equip_announcement` VALUES ('3', '学员动态', '毛泽东死而复生', '江泽民', '2014-08-29 23:48:38', '2');
INSERT INTO `equip_announcement` VALUES ('4', '学员招聘', '最近招聘搬运工，请大家踊跃报名', '校长', '2014-08-21 00:16:40', '1');
INSERT INTO `equip_announcement` VALUES ('5', '美术学院征婚', '征婚启事：找个男人回家结婚去', '凤姐', '2014-08-30 00:17:10', '1');
INSERT INTO `equip_announcement` VALUES ('6', '数科院公告', '最近发现小偷比较多，大家要注意', '管理员', '2014-08-27 00:17:50', '1');
INSERT INTO `equip_announcement` VALUES ('7', '新闻学院', '最近凤姐要来学校演讲，请大家积极参加演讲会', '校长', '2014-08-14 00:18:34', '1');
