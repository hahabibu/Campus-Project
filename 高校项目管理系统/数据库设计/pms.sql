/*
Navicat MySQL Data Transfer

Source Server         : hahabibu
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-12-28 00:18:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `authorty_info`
-- ----------------------------
DROP TABLE IF EXISTS `authorty_info`;
CREATE TABLE `authorty_info` (
  `authorty_id` varchar(40) NOT NULL COMMENT '权限id',
  `authorty_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `authorty_desc` varchar(1000) DEFAULT NULL COMMENT '权限描述',
  `parent_id` varchar(40) DEFAULT NULL COMMENT '上级权限id',
  `authorty_url` varchar(1000) DEFAULT NULL COMMENT '权限url',
  `authorty_class` varchar(40) DEFAULT NULL COMMENT '权限等级',
  PRIMARY KEY (`authorty_id`),
  KEY `FK_Reference_2` (`parent_id`),
  CONSTRAINT `authorty_info_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `authorty_info` (`authorty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorty_info
-- ----------------------------

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `data_id` varchar(40) NOT NULL COMMENT '数据id',
  `data_content` varchar(100) DEFAULT NULL COMMENT '数据内容',
  `data_type` varchar(100) DEFAULT NULL COMMENT '数据类型',
  `data_descr` varchar(2000) DEFAULT NULL COMMENT '数据描述',
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO `data_dictionary` VALUES ('1', '信息学院', 'department', '部门-信息学院');
INSERT INTO `data_dictionary` VALUES ('2', '启新学院', 'department', '部门-启新学院');
INSERT INTO `data_dictionary` VALUES ('3', '教育部', 'department', '部门-教育部');
INSERT INTO `data_dictionary` VALUES ('5', '申报管理', 'message', '消息类型-项目管理');
INSERT INTO `data_dictionary` VALUES ('6', '立项管理', 'message', '消息类型-立项管理');
INSERT INTO `data_dictionary` VALUES ('7', '中期检查管理', 'message', '消息类型-中期检查管理');
INSERT INTO `data_dictionary` VALUES ('8', '结题验收管理', 'message', '消息类型-结题验收管理');

-- ----------------------------
-- Table structure for `declare_record`
-- ----------------------------
DROP TABLE IF EXISTS `declare_record`;
CREATE TABLE `declare_record` (
  `declare_id` varchar(40) NOT NULL COMMENT '申报id',
  `item_id` varchar(40) DEFAULT NULL COMMENT '申报项目id',
  `type_id` varchar(40) DEFAULT NULL COMMENT '申报类型',
  `user_id` varchar(40) DEFAULT NULL COMMENT '申报用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `process_status` varchar(40) DEFAULT NULL COMMENT '申报处理状态',
  `result` varchar(1000) DEFAULT NULL COMMENT '申报结果',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识（0.保存 1.删除）',
  PRIMARY KEY (`declare_id`),
  KEY `FK_Reference_7` (`type_id`),
  KEY `FK_Reference_8` (`item_id`),
  KEY `FK_Reference_9` (`user_id`),
  CONSTRAINT `declare_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `declare_record_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `declare_type` (`type_id`),
  CONSTRAINT `declare_record_ibfk_3` FOREIGN KEY (`item_id`) REFERENCES `item_info` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of declare_record
-- ----------------------------
INSERT INTO `declare_record` VALUES ('1', '1', '253ac3c456144c91bed702a8ff205cfa', '1', null, '2018-12-27 22:01:00', null, null, '0');
INSERT INTO `declare_record` VALUES ('2', '1', '253ac3c456144c91bed702a8ff205cfa', '1', null, '2018-12-27 22:08:04', '1', null, '0');
INSERT INTO `declare_record` VALUES ('2c413e6181e4422485a52859512dca91', '6658258df63e451380150aa911d33ca3', '253ac3c456144c91bed702a8ff205cfa', '1', null, '2018-12-27 22:08:56', '0', null, '0');
INSERT INTO `declare_record` VALUES ('3', '1', '253ac3c456144c91bed702a8ff205cfa', '1', '2018-12-23 00:00:00', '2018-12-27 22:15:17', '2', null, '0');
INSERT INTO `declare_record` VALUES ('cb51616ea24c4f5f83242a1cf84e1560', '68cbe0ec9db1453b8ea54f2ca8236aa2', '253ac3c456144c91bed702a8ff205cfa', '1', '2018-12-23 00:00:00', '2018-12-27 22:15:27', '0', null, '0');

-- ----------------------------
-- Table structure for `declare_type`
-- ----------------------------
DROP TABLE IF EXISTS `declare_type`;
CREATE TABLE `declare_type` (
  `type_id` varchar(40) NOT NULL COMMENT '申报类型id',
  `type_name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `type_descr` varchar(2000) DEFAULT NULL COMMENT '类型描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `middle_time` datetime DEFAULT NULL COMMENT '中期检查时间',
  `end_time` datetime DEFAULT NULL COMMENT '结题验收时间',
  `start_status` varchar(40) DEFAULT NULL COMMENT '开始状态',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识(0.保存 1.删除）',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of declare_type
-- ----------------------------
INSERT INTO `declare_type` VALUES ('253ac3c456144c91bed702a8ff205cfa', '啦啦啦啦', '咔咔咔咔咔咔', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '1', '0');
INSERT INTO `declare_type` VALUES ('f9326f64dd41426f8cd7b7e5cbed9c13', '2018测试', '哈哈哈哈哈哈', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '2018-12-22 00:00:00', '1', '0');

-- ----------------------------
-- Table structure for `item_info`
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `item_id` varchar(40) NOT NULL COMMENT '项目id',
  `item_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `item_class` varchar(100) DEFAULT NULL COMMENT '项目类型',
  `principal` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(500) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `profession` varchar(100) DEFAULT NULL COMMENT '所属专业',
  `members` varchar(200) DEFAULT NULL COMMENT '项目成员',
  `commitment` varchar(1000) DEFAULT NULL COMMENT '立项承诺',
  `annex` varchar(1000) DEFAULT NULL COMMENT '附件资料',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识（0.保存 1.删除）',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_info
-- ----------------------------
INSERT INTO `item_info` VALUES ('1', '测试项目', '校级', '小傻子', '1585555', 'hah@163.com', '', '大傻子、二傻子', '测试项目', 'kkkkk', '0');
INSERT INTO `item_info` VALUES ('6658258df63e451380150aa911d33ca3', '高校项目管理', '校级', 'hahabibu', '13800138000', 'haha@126.com', '', 'haha、xixi', '测试。。。。。。', null, '0');
INSERT INTO `item_info` VALUES ('68cbe0ec9db1453b8ea54f2ca8236aa2', '测试1', '校级', 'hahabibu', '13800138000', 'haha@163.com', '', 'hahabibu、cc', '啥也不知道', null, '0');

-- ----------------------------
-- Table structure for `message_info`
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id` varchar(40) NOT NULL COMMENT '消息id',
  `message_type` varchar(100) DEFAULT NULL COMMENT '消息类型',
  `message_content` varchar(2000) DEFAULT NULL COMMENT '消息内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `receiver` varchar(40) DEFAULT NULL COMMENT '接收人',
  `read_status` varchar(40) DEFAULT NULL COMMENT '已读标识（0.未读 1.已读）',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识（0.保存 1.删除）',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', '5', '测试', '2018-12-19 20:51:48', '1', '1', '0');

-- ----------------------------
-- Table structure for `role_authorty_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_authorty_info`;
CREATE TABLE `role_authorty_info` (
  `role_authorty_id` varchar(40) NOT NULL COMMENT '角色权限id',
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色id',
  `authorty_id` varchar(40) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`role_authorty_id`),
  KEY `FK_Reference_10` (`authorty_id`),
  KEY `FK_Reference_3` (`role_id`),
  CONSTRAINT `role_authorty_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`),
  CONSTRAINT `role_authorty_info_ibfk_2` FOREIGN KEY (`authorty_id`) REFERENCES `authorty_info` (`authorty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authorty_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` varchar(40) NOT NULL COMMENT '角色id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_descr` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识（0.保存 1.删除）',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '超级管理员', '超级管理员：super power！', '2018-12-12 00:00:00', '2018-12-22 00:00:00', '0');
INSERT INTO `role_info` VALUES ('2', '普通学生', '普通学生：可以访问申报管理模块', '2018-12-23 15:44:17', '2018-12-23 15:44:20', '0');
INSERT INTO `role_info` VALUES ('3', '立项管理员', '立项管理员：可以访问立项管理模块', '2018-12-23 15:44:53', '2018-12-23 15:44:56', '0');
INSERT INTO `role_info` VALUES ('4', '中期检查管理员', '中期检查管理员：可以访问项目类型管理模块和中期检查管理模块', '2018-12-23 15:45:21', '2018-12-23 15:45:24', '0');
INSERT INTO `role_info` VALUES ('5', '结题验收管理员', '结题验收管理员：可以访问项目类型管理模块和结题验收管理模块', '2018-12-23 15:46:38', '2018-12-23 15:46:41', '0');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(40) NOT NULL COMMENT '用户id',
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色id',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `department` varchar(40) DEFAULT NULL COMMENT '用户所属部门',
  `email` varchar(40) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(40) DEFAULT NULL COMMENT '联系方式',
  `idCard` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_descr` varchar(2000) DEFAULT NULL COMMENT '用户描述',
  `user_state` varchar(40) DEFAULT NULL COMMENT '用户状态（0.启用 1.禁用）',
  `login_account` varchar(100) DEFAULT NULL COMMENT '用户登录名',
  `login_password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `del_tag` varchar(40) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_5` (`role_id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', 'hahabibu', '1', '243864959@qq.com', '00000', '000000', '2018-12-26 00:00:00', '2018-12-20 00:00:00', '我是超级管理员', '0', 'hahabibu', '000000', '0');
INSERT INTO `user_info` VALUES ('2', '2', '2018002', '1', '135222@163.com', '00000', '000000', '2018-12-23 15:48:22', '2018-12-23 15:48:28', '我是学生', '0', '2018002', '000000', '0');
INSERT INTO `user_info` VALUES ('3', '3', '2018003', '1', '25365428@qq.com', '000000', '111111', '2018-12-23 15:50:04', '2018-12-23 15:50:07', '我是立项检查管理员', '0', '2018003', '000000', '0');
INSERT INTO `user_info` VALUES ('4', '4', '2018004', '1', '4478963@qq.com', '123456', '555555', '2018-12-23 15:51:00', '2018-12-23 15:51:04', '我是中期检查管理员', '0', '2018004', '000000', '0');
INSERT INTO `user_info` VALUES ('5', '5', '2018005', '1', '1353622@126.com', '555555', '444444', '2018-12-23 15:51:44', '2018-12-23 15:51:47', '我是结题验收管理员', '0', '2018005', '000000', '0');
