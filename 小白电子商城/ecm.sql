/*
Navicat MySQL Data Transfer

Source Server         : hahabibu
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : ecm

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-09-13 15:42:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `addr_detail` varchar(500) DEFAULT NULL,
  `postcode` int(10) DEFAULT NULL,
  `receiver_name` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `isdefault` int(11) DEFAULT NULL,
  PRIMARY KEY (`addr_id`),
  KEY `FK_Reference_7` (`user_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '广东省', '惠州市', '小溪洋', '0', '嘻嘻', '13255266598', '1', '0');
INSERT INTO `address` VALUES ('3', '广东省', '潮州市', '大潮州', '310000', 'wakaka', '15855655896', '1', '0');
INSERT INTO `address` VALUES ('4', '江苏省', '南通市', '哈哈哈哈哈哈', '333333', '滚滚滚', '13522655289', '1', '1');
INSERT INTO `address` VALUES ('5', '浙江省', '杭州市', '杭州电子科技大学', '111222', '测试2', '13522655896', '1', '0');
INSERT INTO `address` VALUES ('6', '广东省', '惠州市', 'hhhh', '310000', 'hahaha', '15868255569', '1', '0');
INSERT INTO `address` VALUES ('7', '广东省', '惠州市', 'hhhh', '310000', 'hahaha', '15868255569', '1', '0');
INSERT INTO `address` VALUES ('8', '广东省', '惠州市', 'hhhh', '310000', 'hahaha', '15868255569', '1', '0');
INSERT INTO `address` VALUES ('9', '广东省', '惠州市', 'hhhh', '310000', 'hahaha', '15868255569', '1', '0');
INSERT INTO `address` VALUES ('10', '广东省', '惠州市', 'd大大大', '310000', '110101', '13564522355', '1', '0');

-- ----------------------------
-- Table structure for `alldata`
-- ----------------------------
DROP TABLE IF EXISTS `alldata`;
CREATE TABLE `alldata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taizhan_num` varchar(255) DEFAULT NULL,
  `tem` varchar(255) DEFAULT NULL,
  `hum` varchar(255) DEFAULT NULL,
  `pa` varchar(255) DEFAULT NULL,
  `rain` varchar(255) DEFAULT NULL,
  `win_dir` varchar(255) DEFAULT NULL,
  `win_sp` varchar(255) DEFAULT NULL,
  `dateStr` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alldata
-- ----------------------------
INSERT INTO `alldata` VALUES ('1', 'A0001', '23', '321', '122', '232', '232', '321', '2017-03-08 00:00:00', '2017-03-08 00:00:00');
INSERT INTO `alldata` VALUES ('2', 'A0001', '32', '231', '323', '323', '663', '322', '2017-03-08 00:00:00', '2017-03-08 00:00:00');
INSERT INTO `alldata` VALUES ('3', 'A0001', '22', '321', '324', '323', '322', '322', '2017-03-08 00:00:00', '2017-03-08 00:00:00');
INSERT INTO `alldata` VALUES ('4', 'A0001', '32', '323', '321', '322', '322', '324', '2017-03-08 00:00:00', '2017-03-08 00:00:00');
INSERT INTO `alldata` VALUES ('5', 'A0001', '32', '234', '321', '322', '325', '421', '2017-03-08 00:00:00', '2017-03-08 00:00:00');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `user_id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_2` (`prod_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2', '1', '1');

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `data_content` varchar(100) DEFAULT NULL,
  `data_type` varchar(100) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO `data_dictionary` VALUES ('1', '手机', '商品类型', '1');
INSERT INTO `data_dictionary` VALUES ('2', '电脑', '商品类型', '1');
INSERT INTO `data_dictionary` VALUES ('3', '数码', '商品类型', '1');

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_master_id` int(11) DEFAULT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `unit_price` double(10,2) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `evaluate` varchar(1000) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  KEY `FK_Reference_4` (`order_master_id`),
  KEY `FK_Reference_5` (`prod_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`order_master_id`) REFERENCES `order_master` (`order_master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '4', '4000.00', '16000.00', '0', '1');
INSERT INTO `order_detail` VALUES ('2', '1', '1', '4000.00', '4000.00', '0', '1');
INSERT INTO `order_detail` VALUES ('3', '1', '1', '4000.00', '3000.00', '0', '1');
INSERT INTO `order_detail` VALUES ('1', '1', '1', '2000.00', '2000.00', '0', '1');
INSERT INTO `order_detail` VALUES ('1', '1', '4', '4000.00', '16000.00', '0', '1');
INSERT INTO `order_detail` VALUES ('1', '2', '1', '4200.00', '4200.00', '0', '1');
INSERT INTO `order_detail` VALUES ('6', '2', '1', '4200.00', '4200.00', '0', '1');
INSERT INTO `order_detail` VALUES ('6', '1', '1', '4000.00', '4000.00', '0', '1');

-- ----------------------------
-- Table structure for `order_master`
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_master_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(10) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `addr_id` int(11) DEFAULT NULL,
  `handle_time` date DEFAULT NULL,
  `sign` int(1) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`order_master_id`),
  KEY `FK_Reference_3` (`user_id`),
  KEY `FK_Reference_6` (`addr_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`addr_id`) REFERENCES `address` (`addr_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1', '2018091101', '1', '2', '2018-09-11', '0', '1', '0');
INSERT INTO `order_master` VALUES ('2', '2018091102', '1', '3', '2018-09-12', '2', '1', '0');
INSERT INTO `order_master` VALUES ('3', '2018091103', '1', '6', '2018-09-13', '2', '1', '0');
INSERT INTO `order_master` VALUES ('5', '2018091106', '1', '2', '2018-09-13', '0', '1', '0');
INSERT INTO `order_master` VALUES ('6', '48042578', '1', '2', '2018-09-13', '1', '1', '0');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(30) DEFAULT NULL,
  `prod_cost` double(10,2) DEFAULT NULL,
  `prod_price` double(10,2) DEFAULT NULL,
  `safe_stock` int(10) DEFAULT NULL,
  `prod_origin` varchar(100) DEFAULT NULL,
  `prod_date` date DEFAULT NULL,
  `prod_pic` varchar(1000) DEFAULT NULL,
  `prod_type` int(11) DEFAULT NULL,
  `prod_descr` varchar(200) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'acer笔记本', '3900.00', '4000.00', '19', '中国香港', '2018-09-11', null, null, 'acer笔记本', '1');
INSERT INTO `product` VALUES ('2', '华硕笔记本', '3000.00', '4200.00', '20', '广东深圳', '2018-09-01', '', '0', '华硕笔记本', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `loginname` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `limits` int(3) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hahabibu', '18', '男', '15868154584', '892944741@qq.com', '江苏省', 'hahabibu', '000000', null, '0', '1');
INSERT INTO `user` VALUES ('2', 'admin', '20', '女', '13536302899', '729943698@163.com', '广东省', 'admin', '000000', null, '1', '1');
INSERT INTO `user` VALUES ('3', '测试', '18', '女', '13522655255', '892944741@qq.com', '广东省', '测试', '000000', null, '1', '0');
INSERT INTO `user` VALUES ('4', '测试', '18', '男', '13511544856', '892944741@qq.com', '浙江省', '测试', '000000', null, '1', '1');
