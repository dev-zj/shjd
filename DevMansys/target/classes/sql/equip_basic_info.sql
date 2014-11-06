/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-27 21:53:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equip_basic_info`
-- ----------------------------
DROP TABLE IF EXISTS `equip_basic_info`;
CREATE TABLE `equip_basic_info` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `cate_id` int(10) default NULL,
  `equip_name` varchar(100) default NULL COMMENT '仪器名称',
  `equip_model` varchar(1000) default NULL COMMENT '型号',
  `equip_merchant` varchar(100) default NULL COMMENT '厂商',
  `equip_standard` varchar(100) default NULL COMMENT '规格',
  `equip_value` varchar(20) default NULL COMMENT '价格',
  `equip_age` varchar(5) default NULL COMMENT '使用年限',
  `equip_introduce` varchar(2000) default NULL COMMENT '使用介绍',
  `equip_standard_introduce` varchar(2000) default NULL COMMENT '规格说明',
  `equip_opr_process` varchar(2000) default NULL COMMENT '操作流程',
  `equip_owner_id` int(11) default NULL COMMENT '所属管理人员',
  `can_book` varchar(10) default NULL COMMENT '是否可以预约yes;no',
  `equip_book_property` varchar(20) default NULL COMMENT '仪器所属预约属性(un-sch校外/sch-dep校内本院/sch-undep校内非本院)',
  `created_by` varchar(100) default NULL COMMENT '创建者',
  `created_date` date default NULL,
  `equip_pic` varchar(1000) default NULL COMMENT '图片地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of equip_basic_info
-- ----------------------------
INSERT INTO `equip_basic_info` VALUES ('1', '1', '场发射透射电子', 'Tecnai G2 F20', 'FEI1', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'un-sch', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('2', '2', '场射电子显微镜', 'Tecnai G2 F20', 'FEI2', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'sch-dep', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('3', '3', '场发射电子镜', 'Tecnai G2 F20', 'FEI3', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'sch-dep', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('4', '4', '场发电子显微镜1', 'Tecnai G2 F20', 'FEI4', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'un-sch', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('5', '5', '发射透射电子显微镜2', 'Tecnai G2 F20', 'FEI5', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'un-sch', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('6', '6', '场', 'Tecnai G2 F20', 'FEI6', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'sch-dep', 'system', '2014-08-24', null);
INSERT INTO `equip_basic_info` VALUES ('7', '1', '显微镜5', 'Tecnai G2 F20', 'FEI7', '该仪器为场发射、高分辨透射电子显微镜，其加速电压为200KV。\\n主要参数为：束斑的漂移率为：0.675nm/min； ', '1000W', '50', '该透射电镜可用于观察极微细材料的形貌、组织结构，并拍摄直观的图片，以及提供晶体结构、样品微区的化学成分和元素分布等方面信息。', '图像的分辨率指标为：点分辨率0.24nm，线分辨率0.102nm，信息分辨率0.15nm；\\n放大倍数：最高放大倍数达1.03MX。', '特色：该仪器具有高分辨率、高放大倍数的特点，且拍摄图片像素高。', '1', 'yes', 'un-sch', 'system', '2014-08-24', null);
