/*
 Navicat Premium Data Transfer

 Source Server         : 开发库
 Source Server Type    : MySQL

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 09/12/2019 10:01:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_lcn_1
-- ----------------------------
DROP TABLE IF EXISTS `test_lcn_1`;
CREATE TABLE `test_lcn_1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `a1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_lcn_2
-- ----------------------------
DROP TABLE IF EXISTS `test_lcn_2`;
CREATE TABLE `test_lcn_2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_lcn_3
-- ----------------------------
DROP TABLE IF EXISTS `test_lcn_3`;
CREATE TABLE `test_lcn_3`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
