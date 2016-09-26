/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : db_cityinfo

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-09-26 20:48:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `info_type` int(6) DEFAULT NULL,
  `info_title` varchar(80) DEFAULT NULL,
  `info_content` varchar(1000) DEFAULT NULL,
  `info_linkman` varchar(50) DEFAULT NULL,
  `info_phone` varchar(50) DEFAULT NULL,
  `info_email` varchar(100) DEFAULT NULL,
  `info_date` datetime DEFAULT NULL,
  `info_state` varchar(1) DEFAULT NULL,
  `info_payfor` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_info
-- ----------------------------
INSERT INTO `tb_info` VALUES ('1', '1', 'info_title1通过已付费', 'info_content1通过已付费', 'info_linkman1', 'info_phone1', 'info_email1', '2016-09-01 14:40:07', '1', '1');
INSERT INTO `tb_info` VALUES ('2', '1', 'info_title2通过未付费', 'info_content2通过未付费', 'info_linkman2', 'info_phone2', 'info_email2', '2016-09-02 14:40:22', '1', '0');
INSERT INTO `tb_info` VALUES ('3', '2', 'info_title3通过已付费', 'info_content3通过已付费', 'info_linkman3', 'info_phone3', 'info_email3', '2016-09-03 14:40:28', '1', '1');
INSERT INTO `tb_info` VALUES ('4', '2', 'info_title4通过未付费', 'info_content4通过未付费', 'info_linkman4', 'info_phone4', 'info_email4', '2016-09-04 14:40:32', '1', '0');
INSERT INTO `tb_info` VALUES ('5', '1', 'info_title5未过未付费', 'info_content5未过未付费', 'info_linkman5', 'info_phone5', 'info_email5', '2016-09-05 16:04:56', '0', '0');
INSERT INTO `tb_info` VALUES ('6', '2', 'info_title6未过未付费', 'info_content6未过未付费', 'info_linkman6', 'nfo_phone6', 'nfo_email6', '2016-09-06 16:06:00', '0', '0');
INSERT INTO `tb_info` VALUES ('8', '1', '插入标题2', '插入内容2', '茶如联系人2', '插入电话2', '插入邮箱2', '2016-09-26 11:36:05', '1', '1');

-- ----------------------------
-- Table structure for `tb_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `type_sign` int(6) DEFAULT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  `type_intro` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '1', 'type_name1', 'type_intro1');
INSERT INTO `tb_type` VALUES ('2', '2', 'type_name2', 'type_intro2');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'lpp', '1111');
INSERT INTO `tb_user` VALUES ('2', 'sam', '1111');
INSERT INTO `tb_user` VALUES ('3', 'jim', '1111');
INSERT INTO `tb_user` VALUES ('4', null, null);
