/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : system_db_init

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2013-08-05 15:52:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `batch`
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_name` varchar(45) NOT NULL,
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch
-- ----------------------------

-- ----------------------------
-- Table structure for `batch_component`
-- ----------------------------
DROP TABLE IF EXISTS `batch_component`;
CREATE TABLE `batch_component` (
  `batch_id` int(11) NOT NULL,
  `component_id` varchar(45) NOT NULL,
  PRIMARY KEY (`batch_id`,`component_id`),
  KEY `FK_BB_batch` (`batch_id`),
  KEY `FK_BC_component` (`component_id`),
  CONSTRAINT `batch_component_ibfk_1` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `batch_component_ibfk_2` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch_component
-- ----------------------------

-- ----------------------------
-- Table structure for `component`
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component` (
  `component_id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `material` varchar(45) NOT NULL,
  `size` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  PRIMARY KEY (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component
-- ----------------------------

-- ----------------------------
-- Table structure for `component_procedure`
-- ----------------------------
DROP TABLE IF EXISTS `component_procedure`;
CREATE TABLE `component_procedure` (
  `component_id` varchar(45) NOT NULL,
  `procedure_id` int(11) NOT NULL,
  PRIMARY KEY (`component_id`,`procedure_id`),
  KEY `FK_CC_component` (`component_id`),
  KEY `FK_CP_procedure` (`procedure_id`),
  CONSTRAINT `component_procedure_ibfk_1` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `component_procedure_ibfk_2` FOREIGN KEY (`procedure_id`) REFERENCES `procedure` (`procedure_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_procedure
-- ----------------------------

-- ----------------------------
-- Table structure for `group`
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for `procedure`
-- ----------------------------
DROP TABLE IF EXISTS `procedure`;
CREATE TABLE `procedure` (
  `procedure_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `factor` float NOT NULL,
  PRIMARY KEY (`procedure_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of procedure
-- ----------------------------

-- ----------------------------
-- Table structure for `produce_work`
-- ----------------------------
DROP TABLE IF EXISTS `produce_work`;
CREATE TABLE `produce_work` (
  `worker_id` int(11) NOT NULL,
  `component_id` varchar(45) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `procedure_id` int(11) NOT NULL,
  `failed_num` int(11) NOT NULL,
  `passed_num` int(11) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`worker_id`,`component_id`,`batch_id`,`procedure_id`,`time`),
  KEY `FK_PW_worker` (`procedure_id`),
  KEY `FK_PB_batch` (`batch_id`),
  KEY `FK_component_procedure` (`component_id`,`procedure_id`),
  CONSTRAINT `produce_work_ibfk_1` FOREIGN KEY (`component_id`, `procedure_id`) REFERENCES `component_procedure` (`component_id`, `procedure_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `produce_work_ibfk_2` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `produce_work_ibfk_3` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`worker_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of produce_work
-- ----------------------------

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`name`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('berdy1019', '891019', '0');
INSERT INTO `system_user` VALUES ('xuqin1019', '891019', '1');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `worker_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `group_id` int(11) NOT NULL,
  `info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`worker_id`),
  KEY `FK_worker_group` (`group_id`),
  CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
