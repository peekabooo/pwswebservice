/*
Navicat MySQL Data Transfer

Source Server         : mmy
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : pws

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-12-20 20:04:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(50) NOT NULL,
  `type_id` int(2) NOT NULL,
  `company_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `des_text` varchar(255) NOT NULL,
  `registration_text` varchar(255) NOT NULL,
  `deadline` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `quit_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publish_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(2) NOT NULL,
  `upload_text` varchar(255) NOT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `activity_type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for activity_comment
-- ----------------------------
DROP TABLE IF EXISTS `activity_comment`;
CREATE TABLE `activity_comment` (
  `dynamic_info_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `dynamic_info_id` int(11) NOT NULL,
  `context` text NOT NULL COMMENT '讨论内容',
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `first_comment_id` int(11) NOT NULL COMMENT '第一条为 0',
  `like_number` int(11) NOT NULL,
  PRIMARY KEY (`dynamic_info_comment_id`),
  KEY `activity_id` (`dynamic_info_id`) USING BTREE,
  CONSTRAINT `activity_comment_ibfk_1` FOREIGN KEY (`dynamic_info_id`) REFERENCES `dynamic_info` (`dynamic_info_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for activity_type
-- ----------------------------
DROP TABLE IF EXISTS `activity_type`;
CREATE TABLE `activity_type` (
  `type_id` int(2) NOT NULL,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `user_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`activity_id`),
  KEY `activity_id` (`activity_id`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `common_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for common_user
-- ----------------------------
DROP TABLE IF EXISTS `common_user`;
CREATE TABLE `common_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `gender` tinyint(10) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `university` varchar(255) NOT NULL,
  `department` varchar(50) NOT NULL,
  `student_id` varchar(50) NOT NULL,
  `point` int(11) NOT NULL,
  `level` decimal(3,2) NOT NULL,
  `personal_information` text NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dynamic_info
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_info`;
CREATE TABLE `dynamic_info` (
  `dynamic_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `context` text NOT NULL,
  `picture_address` varchar(255) NOT NULL,
  `company_id` int(11) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `like_number` int(11) NOT NULL,
  PRIMARY KEY (`dynamic_info_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `dynamic_info_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dynamic_info_comment
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_info_comment`;
CREATE TABLE `dynamic_info_comment` (
  `activity_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `context` text NOT NULL COMMENT '讨论内容',
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `first_comment_id` int(11) NOT NULL COMMENT '第一条为 0',
  `like_number` int(11) NOT NULL,
  PRIMARY KEY (`activity_comment_id`),
  KEY `activity_id` (`activity_id`) USING BTREE,
  CONSTRAINT `dynamic_info_comment_ibfk_1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) NOT NULL,
  `member_num` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_member
-- ----------------------------
DROP TABLE IF EXISTS `group_member`;
CREATE TABLE `group_member` (
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `group_member_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `group_member_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `common_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for join_activity
-- ----------------------------
DROP TABLE IF EXISTS `join_activity`;
CREATE TABLE `join_activity` (
  `user_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '1 出席， 0 不出席 ， 2退出不违约， 3 退出违约',
  `comment` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`activity_id`),
  KEY `activity_id` (`activity_id`),
  CONSTRAINT `join_activity_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `common_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `join_activity_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
