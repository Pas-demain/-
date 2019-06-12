/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2018-06-21 09:45:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password2` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('jin', '921204', '1', '921204');
INSERT INTO `user` VALUES ('v', '951230', '2', '951230');
INSERT INTO `user` VALUES ('suga', '930309', '3', '930309');
INSERT INTO `user` VALUES ('jk', '970901', '4', '970901');
INSERT INTO `user` VALUES ('jhope', '940218', '5', '940218');
INSERT INTO `user` VALUES ('rm', '940912', '6', '940912');
INSERT INTO `user` VALUES ('vagu', '980405', '7', '980405');
INSERT INTO `user` VALUES ('jimin', '951013', '8', '951013');

-- ----------------------------
-- Table structure for `已下载`
-- ----------------------------
DROP TABLE IF EXISTS `已下载`;
CREATE TABLE `已下载` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `music` varchar(50) DEFAULT NULL,
  `artist` varchar(50) DEFAULT NULL,
  `album` varchar(50) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `downtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of 已下载
-- ----------------------------
INSERT INTO `已下载` VALUES ('1', 'Spring day', 'BTS', 'FESTA', '06:17', '2013-06-13');

-- ----------------------------
-- Table structure for `我喜欢`
-- ----------------------------
DROP TABLE IF EXISTS `我喜欢`;
CREATE TABLE `我喜欢` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music` varchar(40) DEFAULT NULL,
  `artist` varchar(40) DEFAULT NULL,
  `album` varchar(40) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of 我喜欢
-- ----------------------------
INSERT INTO `我喜欢` VALUES ('1', 'Boys And Girls', 'Zico/Babylon', 'Boys And Girls', '03:20');
INSERT INTO `我喜欢` VALUES ('2', 'Spring day', 'BTS', 'FESTA', '06:17');

-- ----------------------------
-- Table structure for `默认列表`
-- ----------------------------
DROP TABLE IF EXISTS `默认列表`;
CREATE TABLE `默认列表` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music` varchar(40) DEFAULT NULL,
  `artist` varchar(40) DEFAULT NULL,
  `album` varchar(40) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of 默认列表
-- ----------------------------
INSERT INTO `默认列表` VALUES ('1', 'Boys And Girls', 'Zico/Babylon', 'Boys And Girls', '03:20', '\\Music\\Boys And Girls.mp3');
INSERT INTO `默认列表` VALUES ('2', 'Spring day', 'BTS', 'FESTA', '06:17', '\\Music\\Spring day.mp3');
INSERT INTO `默认列表` VALUES ('3', 'love yourself', 'hoodland', 'Hoodland cover', '3:36', '\\Music\\hoodland - LOVE YOURSELF.mp3');
