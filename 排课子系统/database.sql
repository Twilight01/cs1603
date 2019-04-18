/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : database

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 10/04/2019 08:52:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL,
  `capacity` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of classroom
-- ----------------------------
BEGIN;
INSERT INTO `classroom` VALUES (1, 'A阶101', '200');
INSERT INTO `classroom` VALUES (2, 'A阶102', '200');
INSERT INTO `classroom` VALUES (3, 'A阶103', '200');
INSERT INTO `classroom` VALUES (4, 'A101', '60');
INSERT INTO `classroom` VALUES (5, 'A102', '60');
COMMIT;

-- ----------------------------
-- Table structure for paike
-- ----------------------------
DROP TABLE IF EXISTS `paike`;
CREATE TABLE `paike` (
  `id` int(11) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `classroomname` varchar(255) DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  `start` int(2) DEFAULT NULL,
  `end` int(2) DEFAULT NULL,
  `stumajor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of paike
-- ----------------------------
BEGIN;
INSERT INTO `paike` VALUES (1, 'E001', '高等数学', 'A101', '160', '一,1,2,3', '老师A', 1, 10, '大一计科');
INSERT INTO `paike` VALUES (2, 'E001', '高等数学', 'A102', '160', '一,1,2,3', '老师B', 1, 10, '大一自控');
INSERT INTO `paike` VALUES (3, 'B002', '软件工程', 'B201', '120', '三,11,12,13', '老师D', 1, 10, '大三计科');
INSERT INTO `paike` VALUES (4, 'E003', '英语', 'A阶103', '120', '二,4,5', '老师F', 3, 7, '大二计科');
INSERT INTO `paike` VALUES (5, 'E003', '英语', 'A阶103', '120', '二,4,5', '老师G', 8, 10, '大二计科');
COMMIT;

-- ----------------------------
-- Table structure for paikepre
-- ----------------------------
DROP TABLE IF EXISTS `paikepre`;
CREATE TABLE `paikepre` (
  `id` int(11) NOT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stumajor` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  `capacity` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of paikepre
-- ----------------------------
BEGIN;
INSERT INTO `paikepre` VALUES (1, 'E001', '高等数学', '大一计科', '公共基础必修', '老师A', 160);
INSERT INTO `paikepre` VALUES (2, 'E001', '高等数学', '大一自控', '公共基础必修', '老师B', 160);
INSERT INTO `paikepre` VALUES (3, 'E002', '线性代数', '大一计科', '公共基础必修', '老师C', 60);
INSERT INTO `paikepre` VALUES (4, 'B002', '软件工程', '大三计科', '专业选修', '老师D', 120);
INSERT INTO `paikepre` VALUES (5, 'A110', '电影欣赏', '全校学生', '通识', '老师E', 180);
INSERT INTO `paikepre` VALUES (6, 'E003', '英语', '大二计科', '公共基础必修', '老师F,老师G', 120);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
