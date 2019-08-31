/*
 Navicat Premium Data Transfer

 Source Server         : kk
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : lzwl

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 07/05/2019 19:37:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_dto
-- ----------------------------
DROP TABLE IF EXISTS `class_dto`;
CREATE TABLE `class_dto`  (
  `class_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  `class_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名称',
  `institute` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在学院',
  `grade` bigint(5) DEFAULT NULL COMMENT '年级',
  `class_master` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班主任',
  `student_quantity` int(5) DEFAULT NULL COMMENT '班级人数',
  `usage_status_flag` int(2) DEFAULT 1 COMMENT '启用标识',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_dto
-- ----------------------------
INSERT INTO `class_dto` VALUES (1, '数字媒体技术', '2班', '数字媒体技术学院', 138, '赵一娇', 35, 1, 3, -1, '2019-03-18 09:56:04', NULL, '2019-03-29 02:14:36');
INSERT INTO `class_dto` VALUES (2, '数字媒体技术', '3班', '数字媒体技术学院', 137, '赵旭媛', 33, 1, 9, NULL, '2019-03-18 06:25:22', NULL, '2019-04-04 08:46:19');
INSERT INTO `class_dto` VALUES (6, '数字媒体技术', '1班', '数字媒体技术学院', 135, '石宝明', 32, 1, 4, NULL, '2019-03-20 02:55:41', NULL, '2019-04-03 08:03:04');
INSERT INTO `class_dto` VALUES (7, '软件工程', '1班', '数字媒体技术学院', 135, '马少斌', 44, 1, 8, NULL, '2019-03-20 02:56:28', NULL, '2019-04-03 08:02:57');
INSERT INTO `class_dto` VALUES (10, '大数据', '1班', '文学院', 136, '无名', 33, 1, 4, NULL, '2019-03-28 13:43:25', NULL, '2019-04-03 08:03:34');
INSERT INTO `class_dto` VALUES (11, '汉语言文学', '1班', '文学院', 135, '刘光锐', 50, 1, 4, NULL, '2019-04-04 10:29:29', NULL, '2019-04-12 09:10:50');

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `room_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教室编号',
  `location` bigint(11) DEFAULT NULL COMMENT '所在位置',
  `floor` int(8) DEFAULT NULL COMMENT '楼层',
  `usage_status_flag` int(2) DEFAULT NULL COMMENT '使用状态',
  `manager` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 393 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (39, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (40, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (41, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (42, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (43, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (44, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (45, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (46, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (47, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (48, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (59, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:41', -1, '2019-03-08 15:40:41');
INSERT INTO `classroom` VALUES (67, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:42', -1, '2019-03-08 15:40:42');
INSERT INTO `classroom` VALUES (75, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:42', -1, '2019-03-08 15:40:42');
INSERT INTO `classroom` VALUES (105, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:43', -1, '2019-03-08 15:40:43');
INSERT INTO `classroom` VALUES (114, '机房', '5-104', 1, 1, 1, '张三', '123', 1, -1, '2019-03-08 15:40:43', -1, '2019-03-08 15:40:43');
INSERT INTO `classroom` VALUES (122, '多媒体教室', '4-103', 1, 2, 1, '张三', '123', 3, -1, '2019-03-08 15:40:43', NULL, '2019-03-23 02:57:08');
INSERT INTO `classroom` VALUES (126, '多媒体教室', '5-104', 129, 1, 1, '李四', '123', 6, -1, '2019-03-08 15:40:43', NULL, '2019-03-20 09:22:26');
INSERT INTO `classroom` VALUES (127, '大教室', '1-201', 1, 2, 1, '张三', '', 3, NULL, '2019-03-23 03:17:35', NULL, '2019-03-24 09:10:20');
INSERT INTO `classroom` VALUES (130, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:16', -1, '2019-03-25 16:37:16');
INSERT INTO `classroom` VALUES (131, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (132, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (133, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (134, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (135, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (136, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (137, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (298, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (299, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (300, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (301, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (302, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (303, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (304, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (305, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (306, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (307, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (308, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (309, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (310, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (311, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (312, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (313, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (314, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (315, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (316, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (319, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (320, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (321, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (322, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (323, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (324, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (325, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (326, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (327, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (328, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (329, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (330, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (331, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (332, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (333, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (334, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (335, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (336, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (337, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (338, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (339, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (340, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (341, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (342, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (343, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (344, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (345, '多媒体教室', '5-401', 1, 4, 1, '张三', '', 2, -1, '2019-03-25 16:37:30', NULL, '2019-03-27 06:58:27');
INSERT INTO `classroom` VALUES (346, '多媒体教室', '2-301', 130, 3, 1, '张三', '', 2, -1, '2019-03-25 16:37:30', NULL, '2019-03-27 06:58:02');
INSERT INTO `classroom` VALUES (347, '大教室', '1-201', 1, 2, 1, '张三', NULL, 1, -1, '2019-03-25 16:37:30', -1, '2019-03-25 16:37:30');
INSERT INTO `classroom` VALUES (348, '机房', '1-201', 129, 1, 1, '张三', '', 2, -1, '2019-03-25 16:37:30', NULL, '2019-03-27 06:57:25');
INSERT INTO `classroom` VALUES (392, '自习室', '3-104', 131, 1, 1, '谢丽', '', 1, NULL, '2019-04-04 10:28:01', NULL, '2019-04-04 10:28:01');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `course_num` bigint(11) DEFAULT NULL COMMENT '课程编号',
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `course_quantity` int(11) DEFAULT 1 COMMENT '一周的课程数',
  `teacher_id` bigint(11) DEFAULT NULL COMMENT '教师id',
  `room_id` bigint(11) DEFAULT NULL COMMENT '教室id',
  `class_id` bigint(11) DEFAULT NULL COMMENT '班级id',
  `usage_status_flag` int(2) NOT NULL DEFAULT 1 COMMENT '启用标识',
  `sort_status_flag` int(2) NOT NULL DEFAULT 0,
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 168 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (66, 1, '数字媒体导论', 4, 10, 348, 7, 1, 1, 37, NULL, '2019-03-27 06:59:37', NULL, '2019-04-19 12:14:36');
INSERT INTO `course` VALUES (67, 1, '数字媒体导论', 4, 10, 348, 7, 1, 1, 40, NULL, '2019-03-27 06:59:37', NULL, '2019-04-19 12:14:39');
INSERT INTO `course` VALUES (68, 1, '数字媒体导论', 4, 10, 348, 7, 1, 1, 53, NULL, '2019-03-27 06:59:37', NULL, '2019-04-19 12:18:15');
INSERT INTO `course` VALUES (69, 1, '数字媒体导论', 4, 10, 348, 7, 1, 1, 43, NULL, '2019-03-27 06:59:37', NULL, '2019-04-19 12:18:16');
INSERT INTO `course` VALUES (70, 2, 'HTML', 4, 7, 347, 7, 1, 1, 37, NULL, '2019-03-27 07:01:00', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (71, 2, 'HTML', 4, 7, 347, 7, 1, 1, 37, NULL, '2019-03-27 07:01:00', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (72, 2, 'HTML', 4, 7, 347, 7, 1, 1, 41, NULL, '2019-03-27 07:01:00', NULL, '2019-04-19 12:22:51');
INSERT INTO `course` VALUES (73, 2, 'HTML', 4, 7, 347, 7, 1, 1, 45, NULL, '2019-03-27 07:01:00', NULL, '2019-04-19 12:22:53');
INSERT INTO `course` VALUES (110, 3, '毛概', 2, 6, 346, 1, 1, 1, 28, NULL, '2019-04-04 09:10:48', NULL, '2019-04-19 12:17:14');
INSERT INTO `course` VALUES (111, 3, '毛概', 2, 6, 346, 1, 1, 1, 26, NULL, '2019-04-04 09:10:48', NULL, '2019-04-19 12:17:16');
INSERT INTO `course` VALUES (142, 7, '英语', 4, 10, 392, 10, 1, 1, 25, NULL, '2019-04-08 04:21:05', NULL, '2019-04-19 12:11:47');
INSERT INTO `course` VALUES (143, 7, '英语', 4, 10, 392, 10, 1, 1, 28, NULL, '2019-04-08 04:21:05', NULL, '2019-04-19 12:11:50');
INSERT INTO `course` VALUES (144, 7, '英语', 4, 10, 392, 10, 1, 1, 21, NULL, '2019-04-08 04:21:05', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (145, 7, '英语', 4, 10, 392, 10, 1, 1, 21, NULL, '2019-04-08 04:21:05', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (146, 8, '数学', 4, 10, 345, 2, 1, 1, 20, NULL, '2019-04-08 04:21:14', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (147, 8, '数学', 4, 10, 345, 2, 1, 1, 20, NULL, '2019-04-08 04:21:14', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (148, 8, '数学', 4, 10, 345, 2, 1, 1, 22, NULL, '2019-04-08 04:21:14', NULL, '2019-04-19 12:13:24');
INSERT INTO `course` VALUES (149, 8, '数学', 4, 10, 345, 2, 1, 1, 22, NULL, '2019-04-08 04:21:14', NULL, '2019-04-19 12:13:26');
INSERT INTO `course` VALUES (150, 9, 'PS', 4, 10, 346, 6, 1, 1, 22, NULL, '2019-04-08 04:21:22', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (151, 9, 'PS', 4, 10, 346, 6, 1, 1, 22, NULL, '2019-04-08 04:21:22', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (152, 9, 'PS', 4, 10, 346, 6, 1, 1, 24, NULL, '2019-04-08 04:21:22', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (153, 9, 'PS', 4, 10, 346, 6, 1, 1, 22, NULL, '2019-04-08 04:21:22', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (154, 10, '中国古代文学', 2, 10, 392, 11, 1, 1, 58, NULL, '2019-04-08 04:21:27', NULL, '2019-04-23 12:27:26');
INSERT INTO `course` VALUES (155, 10, '中国古代文学', 2, 10, 392, 11, 1, 1, 48, NULL, '2019-04-08 04:21:27', NULL, '2019-04-23 12:27:31');
INSERT INTO `course` VALUES (156, 11, '体育', 4, 1, 345, 2, 1, 1, 12, NULL, '2019-04-12 09:00:53', NULL, '2019-04-19 12:12:09');
INSERT INTO `course` VALUES (157, 11, '体育', 4, 1, 345, 2, 1, 1, 12, NULL, '2019-04-12 09:00:53', NULL, '2019-04-19 12:12:11');
INSERT INTO `course` VALUES (158, 11, '体育', 4, 1, 345, 2, 1, 1, 12, NULL, '2019-04-12 09:00:53', NULL, '2019-04-19 12:12:24');
INSERT INTO `course` VALUES (159, 11, '体育', 4, 1, 345, 2, 1, 1, 12, NULL, '2019-04-12 09:00:53', NULL, '2019-04-19 12:12:26');
INSERT INTO `course` VALUES (160, 12, '外国文学史', 4, 11, 348, 11, 1, 0, 7, NULL, '2019-04-12 12:38:49', NULL, '2019-04-23 03:19:12');
INSERT INTO `course` VALUES (161, 12, '外国文学史', 4, 11, 348, 11, 1, 1, 6, NULL, '2019-04-12 12:38:50', NULL, '2019-04-19 12:11:28');
INSERT INTO `course` VALUES (162, 12, '外国文学史', 4, 11, 348, 11, 1, 1, 4, NULL, '2019-04-12 12:38:50', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (163, 12, '外国文学史', 4, 11, 348, 11, 1, 1, 6, NULL, '2019-04-12 12:38:50', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (164, 12, '外国文学史', 4, 11, 348, 11, 1, 1, 4, NULL, '2019-04-12 12:38:50', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (165, 12, '外国文学史', 4, 11, 348, 11, 1, 1, 4, NULL, '2019-04-12 12:38:50', NULL, '2019-04-12 13:08:23');
INSERT INTO `course` VALUES (166, 12, '外国文学史', 4, 11, 348, 11, 1, 0, 7, NULL, '2019-04-12 12:38:50', NULL, '2019-04-23 03:19:08');
INSERT INTO `course` VALUES (167, 12, '外国文学史', 4, 11, 348, 11, 1, 0, 7, NULL, '2019-04-12 12:38:50', NULL, '2019-04-23 03:19:10');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `time_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(11) DEFAULT NULL COMMENT '课程id',
  `course_day` int(11) DEFAULT NULL COMMENT '课程日(第几天)',
  `course_time` int(11) DEFAULT NULL COMMENT '课程时间(第几节课)',
  `usage_status_flag` int(2) DEFAULT 1 COMMENT '启用标识',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`time_id`) USING BTREE,
  UNIQUE INDEX `UK_schedule_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 755 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '时间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (699, 70, 1, 5, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (702, 71, 1, 6, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (706, 144, 2, 1, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (707, 162, 2, 1, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (709, 145, 2, 2, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (710, 163, 2, 2, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (711, 146, 2, 3, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (712, 164, 2, 3, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (713, 147, 2, 4, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (714, 165, 2, 4, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (719, 150, 3, 1, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (720, 151, 3, 2, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (721, 152, 3, 3, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (722, 153, 3, 4, 1, 1, NULL, '2019-04-12 13:08:23', NULL, '2019-04-12 13:08:23');
INSERT INTO `schedule` VALUES (731, 161, 3, 4, 1, 1, NULL, '2019-04-19 12:11:28', NULL, '2019-04-19 12:11:28');
INSERT INTO `schedule` VALUES (732, 142, 5, 5, 1, 1, NULL, '2019-04-19 12:11:47', NULL, '2019-04-19 12:11:47');
INSERT INTO `schedule` VALUES (733, 143, 5, 6, 1, 1, NULL, '2019-04-19 12:11:50', NULL, '2019-04-19 12:11:50');
INSERT INTO `schedule` VALUES (734, 156, 4, 3, 1, 1, NULL, '2019-04-19 12:12:09', NULL, '2019-04-19 12:12:09');
INSERT INTO `schedule` VALUES (735, 157, 4, 4, 1, 1, NULL, '2019-04-19 12:12:11', NULL, '2019-04-19 12:12:11');
INSERT INTO `schedule` VALUES (736, 158, 3, 1, 1, 1, NULL, '2019-04-19 12:12:24', NULL, '2019-04-19 12:12:24');
INSERT INTO `schedule` VALUES (737, 159, 3, 2, 1, 1, NULL, '2019-04-19 12:12:26', NULL, '2019-04-19 12:12:26');
INSERT INTO `schedule` VALUES (738, 148, 4, 1, 1, 1, NULL, '2019-04-19 12:13:24', NULL, '2019-04-19 12:13:24');
INSERT INTO `schedule` VALUES (739, 149, 4, 2, 1, 1, NULL, '2019-04-19 12:13:26', NULL, '2019-04-19 12:13:26');
INSERT INTO `schedule` VALUES (740, 66, 4, 5, 1, 1, NULL, '2019-04-19 12:14:36', NULL, '2019-04-19 12:14:36');
INSERT INTO `schedule` VALUES (741, 67, 4, 6, 1, 1, NULL, '2019-04-19 12:14:39', NULL, '2019-04-19 12:14:39');
INSERT INTO `schedule` VALUES (744, 110, 3, 5, 1, 1, NULL, '2019-04-19 12:17:14', NULL, '2019-04-19 12:17:14');
INSERT INTO `schedule` VALUES (745, 111, 3, 6, 1, 1, NULL, '2019-04-19 12:17:16', NULL, '2019-04-19 12:17:16');
INSERT INTO `schedule` VALUES (746, 68, 5, 3, 1, 1, NULL, '2019-04-19 12:18:15', NULL, '2019-04-19 12:18:15');
INSERT INTO `schedule` VALUES (747, 69, 5, 4, 1, 1, NULL, '2019-04-19 12:18:16', NULL, '2019-04-19 12:18:16');
INSERT INTO `schedule` VALUES (748, 72, 1, 1, 1, 1, NULL, '2019-04-19 12:22:51', NULL, '2019-04-19 12:22:51');
INSERT INTO `schedule` VALUES (749, 73, 1, 2, 1, 1, NULL, '2019-04-19 12:22:53', NULL, '2019-04-19 12:22:53');
INSERT INTO `schedule` VALUES (753, 154, 4, 3, 1, 1, NULL, '2019-04-23 12:27:27', NULL, '2019-04-23 12:27:27');
INSERT INTO `schedule` VALUES (754, 155, 4, 4, 1, 1, NULL, '2019-04-23 12:27:31', NULL, '2019-04-23 12:27:31');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `sno_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`sno_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '值集名称',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限字符串',
  `type` int(11) DEFAULT 0 COMMENT '资源类型',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方式',
  `sort` int(11) DEFAULT 0 COMMENT '排序',
  `pid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父菜单ID',
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色id',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (134, '教室查询', 'list-room', 0, '/manage-room/rooms', 'get', 0, NULL, 134, 1, -1, '2019-03-12 19:59:50', -1, '2019-03-12 19:59:50');
INSERT INTO `sys_permission` VALUES (135, '教室添加', 'add-room', 0, '/manage-room/room', 'post', 0, NULL, 134, 1, -1, '2019-03-15 15:36:49', -1, '2019-03-15 15:36:49');
INSERT INTO `sys_permission` VALUES (136, '教室修改', 'update-room', 0, '/manage-room/room', 'put', 0, NULL, 134, 1, -1, '2019-03-15 15:40:11', -1, '2019-03-15 15:40:11');
INSERT INTO `sys_permission` VALUES (137, '教室删除', 'delete-room', 0, '/manage-room/room/{id}', 'delete', 0, NULL, 134, 1, -1, '2019-03-15 15:41:06', -1, '2019-03-15 15:41:06');
INSERT INTO `sys_permission` VALUES (138, '教师查询', 'list-teacher', 0, '/manage-teacher/rooms', 'get', 0, NULL, 135, 1, -1, '2019-03-16 15:06:15', -1, '2019-03-16 15:06:15');
INSERT INTO `sys_permission` VALUES (139, '教师添加', 'add-teacher', 0, '/manage-teacher/room', 'post', 0, NULL, 135, 1, -1, '2019-03-16 15:07:03', -1, '2019-03-16 15:07:03');
INSERT INTO `sys_permission` VALUES (140, '教师修改', 'update-teacher', 0, '/manage-teacher/teacher', 'put', 0, NULL, 135, 1, -1, '2019-03-16 15:07:29', -1, '2019-03-16 15:07:29');
INSERT INTO `sys_permission` VALUES (141, '教师删除', 'delete-teacher', 0, '/manage-teacher/teacher/{id}', 'delete', 0, NULL, 135, 1, -1, '2019-03-16 15:09:14', -1, '2019-03-16 15:09:14');
INSERT INTO `sys_permission` VALUES (142, '班级查询', 'list-classDto', 0, '/manage-classDto/classDtos', 'get', 0, NULL, 136, 1, -1, '2019-03-18 11:38:45', -1, '2019-03-18 11:38:45');
INSERT INTO `sys_permission` VALUES (143, '班级添加', 'add-classDto', 0, '/manage-classDto/classDto', 'post', 0, NULL, 136, 1, -1, '2019-03-18 11:39:25', -1, '2019-03-18 11:39:25');
INSERT INTO `sys_permission` VALUES (144, '班级修改', 'update-classDto', 0, '/manage-classDto/classDto', 'put', 0, NULL, 136, 1, -1, '2019-03-18 11:39:44', -1, '2019-03-18 11:39:44');
INSERT INTO `sys_permission` VALUES (145, '班级删除', 'delete-classDto', 0, '/manage-classDto/classDto/{id}', 'delete', 0, NULL, 136, 1, -1, '2019-03-18 11:39:57', -1, '2019-03-18 11:39:57');
INSERT INTO `sys_permission` VALUES (146, '课程查询', 'list-course', 0, '/manage-course/courses', 'get', 0, NULL, 137, 1, -1, '2019-03-19 11:27:01', -1, '2019-03-19 11:27:01');
INSERT INTO `sys_permission` VALUES (147, '课程添加', 'add-course', 0, '/manage-course/course', 'post', 0, NULL, 137, 1, -1, '2019-03-19 11:28:54', -1, '2019-03-19 11:28:54');
INSERT INTO `sys_permission` VALUES (148, '课程修改', 'update-course', 0, '/manage-course/course', 'put', 0, NULL, 137, 1, -1, '2019-03-19 11:29:48', -1, '2019-03-19 11:29:48');
INSERT INTO `sys_permission` VALUES (149, '课程删除', 'delete-course', 0, '/manage-course/course/{id}', 'delete', 0, NULL, 137, 1, -1, '2019-03-19 11:30:23', -1, '2019-03-19 11:30:23');
INSERT INTO `sys_permission` VALUES (150, '时间表查询', 'list-schedule', 0, '/manage-schedule/schedules', 'get', 0, NULL, 138, 1, -1, '2019-03-20 16:58:17', -1, '2019-03-20 16:58:17');
INSERT INTO `sys_permission` VALUES (151, '时间表添加', 'add-schedule', 0, '/manage-schedule/schedule', 'post', 0, NULL, 138, 1, -1, '2019-03-20 16:59:05', -1, '2019-03-20 16:59:05');
INSERT INTO `sys_permission` VALUES (152, '时间表修改', 'update-schedule', 0, '/manage-schedule/schedule', 'put', 0, NULL, 138, 1, -1, '2019-03-20 16:59:24', -1, '2019-03-20 16:59:24');
INSERT INTO `sys_permission` VALUES (153, '时间表删除', 'delete-schedule', 0, '/manage-schedule/schedule/{id}', 'delete', 0, NULL, 138, 1, -1, '2019-03-20 17:02:48', -1, '2019-03-20 17:02:48');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编码',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (134, '教室管理员', 'room-manager', 134, 1, -1, '2019-03-12 19:57:34', -1, '2019-03-12 19:57:34');
INSERT INTO `sys_role` VALUES (135, '教师管理员', 'teacher-manager', 134, 1, -1, '2019-03-16 15:05:02', -1, '2019-03-16 15:05:02');
INSERT INTO `sys_role` VALUES (136, '班级管理员', 'classDto-manager', 134, 1, -1, '2019-03-18 11:38:07', -1, '2019-03-18 11:38:07');
INSERT INTO `sys_role` VALUES (137, '课程管理员', 'course-manager', 134, 1, -1, '2019-03-19 11:23:14', -1, '2019-03-19 11:23:14');
INSERT INTO `sys_role` VALUES (138, '时间表管理员', 'schedule-manager', 134, 1, -1, '2019-03-20 17:51:43', -1, '2019-03-20 17:51:43');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户编号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `catename`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (134, 'admin', 'member', '$2a$10$EIfFrWGINQzP.tmtdLd2hurtowwsIEQaPFR9iffw2uSKCOutHnQEm', 1, -1, '2019-03-12 19:56:17', -1, '2019-03-12 19:56:17');
INSERT INTO `sys_user` VALUES (135, 'test', NULL, '$2a$10$EVEvJV9xvIWptwTQRyWck.bOB2/5DZ5BUiAV0fKTVu1vt.T/uUue.', 1, NULL, '2019-04-04 13:00:51', NULL, '2019-04-04 13:00:51');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师姓名',
  `gender` int(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `usage_status_flag` int(2) DEFAULT NULL COMMENT '使用状态',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '王万军', 1, '18182327728', '12182387@qq.com', 1, 1, NULL, '2019-03-16 09:02:56', NULL, '2019-03-16 09:02:56');
INSERT INTO `teacher` VALUES (6, '王世勇', 1, '18237727181', 'wioajd@qq.com', 1, 4, NULL, '2019-03-16 09:03:20', NULL, '2019-03-18 01:11:22');
INSERT INTO `teacher` VALUES (7, '吴万琴', 0, '18218882321', '18218882321@qq.com', 1, 4, NULL, '2019-03-18 01:07:57', NULL, '2019-03-20 02:53:54');
INSERT INTO `teacher` VALUES (10, '赵一娇', 0, '567890', '6543212345@qq.com', 1, 5, NULL, '2019-03-23 03:19:55', NULL, '2019-03-24 09:16:25');
INSERT INTO `teacher` VALUES (11, '谢丽', 0, '17352211720', '864994933@qq.com', 1, 3, NULL, '2019-04-04 10:28:44', NULL, '2019-04-04 10:33:56');

-- ----------------------------
-- Table structure for value_set
-- ----------------------------
DROP TABLE IF EXISTS `value_set`;
CREATE TABLE `value_set`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '值集名称',
  `value` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '值集值',
  `meaning` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '含义',
  `OBJECT_VERSION_NUMBER` bigint(20) DEFAULT 1,
  `CREATED_BY` bigint(20) DEFAULT -1,
  `CREATION_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` bigint(20) DEFAULT -1,
  `LAST_UPDATE_DATE` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值集表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of value_set
-- ----------------------------
INSERT INTO `value_set` VALUES (1, 'building', '综合楼', '楼号', 1, -1, '2019-03-11 10:56:00', -1, '2019-03-11 10:56:00');
INSERT INTO `value_set` VALUES (129, 'building', '一号楼', '楼号', 1, -1, '2019-03-11 10:56:34', -1, '2019-03-11 10:56:34');
INSERT INTO `value_set` VALUES (130, 'building', '二号楼', '楼号', 1, -1, '2019-03-11 10:56:55', -1, '2019-03-11 10:56:55');
INSERT INTO `value_set` VALUES (131, 'building', '三号楼', '楼号', 1, -1, '2019-03-11 10:57:09', -1, '2019-03-11 10:57:09');
INSERT INTO `value_set` VALUES (132, 'building', '四号楼', '楼号', 1, -1, '2019-03-11 10:57:18', -1, '2019-03-11 10:57:18');
INSERT INTO `value_set` VALUES (133, 'week-day', '7', '一周上课天数', 1, -1, '2019-03-11 11:22:54', -1, '2019-03-11 11:22:54');
INSERT INTO `value_set` VALUES (134, 'day-time', '6', '一天上课节数', 1, -1, '2019-03-23 14:16:59', -1, '2019-03-23 14:16:59');
INSERT INTO `value_set` VALUES (135, 'grade', '16级', '2016级', 1, -1, '2019-03-28 20:47:21', -1, '2019-03-28 20:47:21');
INSERT INTO `value_set` VALUES (136, 'grade', '17级', '2017级', 1, -1, '2019-03-28 20:48:06', -1, '2019-03-28 20:48:06');
INSERT INTO `value_set` VALUES (137, 'grade', '18级', '2018级', 1, -1, '2019-03-28 20:48:21', -1, '2019-03-28 20:48:21');
INSERT INTO `value_set` VALUES (138, 'grade', '19级', '2019级', 1, -1, '2019-03-28 20:48:34', -1, '2019-03-28 20:48:34');
INSERT INTO `value_set` VALUES (139, 'sort-condition', '教师ID', '教师ID', 1, -1, '2019-03-29 12:05:30', -1, '2019-03-29 12:05:30');
INSERT INTO `value_set` VALUES (140, 'sort-condition', '班级ID', '专业ID', 1, -1, '2019-03-29 12:05:56', -1, '2019-03-29 12:05:56');
INSERT INTO `value_set` VALUES (141, 'sort-condition', '教室ID', '教室ID', 1, -1, '2019-03-29 12:07:21', -1, '2019-03-29 12:07:21');

SET FOREIGN_KEY_CHECKS = 1;
