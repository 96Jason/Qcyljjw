/*
Navicat MySQL Data Transfer

Source Server         : mysql8.0.20
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : qcyljjw

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-09-12 22:51:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fe_chat
-- ----------------------------
DROP TABLE IF EXISTS `fe_chat`;
CREATE TABLE `fe_chat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender` char(10) NOT NULL,
  `receiver` char(10) NOT NULL,
  `msg` varchar(200) NOT NULL,
  `sendTime` datetime NOT NULL,
  `senderStatus` int NOT NULL,
  `receiverStatus` int NOT NULL,
  `isRead` int NOT NULL DEFAULT '0' COMMENT '0未读，1已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fe_chat
-- ----------------------------
INSERT INTO `fe_chat` VALUES ('1', 'user8', 'Clement', '[em_52]', '2020-05-03 15:06:31', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('2', 'user4', 'user2', '希望得到您的青垂，以下是我的简历信息链接!<a href=http://localhost/html/article/fe-resume.html?id=3>点我前往</a>', '2020-05-03 15:49:59', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('3', 'user2', 'JasonXu', '希望得到您的青垂，以下是我的简历信息链接!<a href=http://localhost/html/article/fe-resume.html?id=22>点我前往</a>', '2020-05-03 16:02:04', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('4', 'user2', 'user8', '刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！<a href=http://localhost/html/article/fe-recruit.html?id=1>点我前往</a>', '2020-05-04 01:31:45', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('5', 'user2', 'JasonXu', '希望得到您的青垂，以下是我的简历信息链接!<a href=http://localhost/html/article/fe-resume.html?id=1>点我前往</a>', '2020-05-04 01:32:41', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('6', 'user2', 'user6', '刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！<a href=http://localhost/html/article/fe-recruit.html?id=1>点我前往</a>', '2020-05-04 05:57:36', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('7', 'user2', 'JasonXu', '[em_33]', '2020-05-04 10:43:11', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('8', 'user2', 'JasonXu', 'klkl', '2020-05-04 10:43:18', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('9', 'JasonXu', 'Clement', '[em_62]', '2020-05-04 11:57:19', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('10', 'JasonXu', 'Clement', '[em_22]', '2020-05-05 13:35:38', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('11', 'user2', 'JasonXu', '[em_53]', '2020-05-05 14:49:20', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('12', 'user2', 'JasonXu', '[em_52]', '2020-05-05 14:59:29', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('13', 'user2', 'JasonXu', '[em_63]', '2020-05-05 15:01:07', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('14', 'user4', 'JasonXu', '[em_62]', '2020-05-05 15:02:11', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('15', 'user3', 'JasonXu', '[em_52]', '2020-05-05 15:10:13', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('16', 'user2', 'JasonXu', '[em_53]', '2020-05-05 15:12:28', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('17', 'JasonXu', 'user10', '[em_53]', '2020-05-05 15:15:36', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('18', 'user2', 'JasonXu', '[em_63]', '2020-05-05 15:15:53', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('19', 'user3', 'JasonXu', '[em_53]', '2020-05-05 15:16:17', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('20', 'user3', 'JasonXu', '[em_52]', '2020-05-05 15:16:37', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('21', 'user2', 'JasonXu', '[em_62]', '2020-05-05 15:20:53', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('22', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:20:59', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('23', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:21:14', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('24', 'user2', 'JasonXu', '[em_62]', '2020-05-05 15:21:18', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('25', 'user2', 'JasonXu', '[em_32]', '2020-05-05 15:21:24', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('26', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:21:28', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('27', 'user2', 'JasonXu', '[em_72]', '2020-05-05 15:21:36', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('28', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:21:40', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('29', 'user2', 'JasonXu', '[em_35]', '2020-05-05 15:21:57', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('30', 'user2', 'JasonXu', '[em_62]', '2020-05-05 15:22:03', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('31', 'user2', 'JasonXu', '[em_63]', '2020-05-05 15:22:07', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('32', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:22:11', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('33', 'user2', 'JasonXu', '[em_13]', '2020-05-05 15:22:21', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('34', 'user2', 'JasonXu', '[em_62]', '2020-05-05 15:22:24', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('35', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:22:29', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('36', 'user2', 'JasonXu', '[em_52]', '2020-05-05 15:22:33', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('37', 'user2', 'JasonXu', '[em_62]', '2020-05-05 15:22:37', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('38', 'user2', 'JasonXu', '[em_71]', '2020-05-05 15:22:50', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('39', 'user3', 'JasonXu', '[em_63]', '2020-05-05 15:23:01', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('40', 'user3', 'JasonXu', '[em_63]', '2020-05-05 15:23:09', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('41', 'user3', 'JasonXu', '[em_62]', '2020-05-05 15:23:13', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('42', 'JasonXu', 'user2', '[em_62]', '2020-05-05 15:26:18', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('43', 'JasonXu', 'user2', '[em_62]', '2020-05-05 15:26:24', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('44', 'JasonXu', 'user2', '[em_12]', '2020-05-05 15:26:28', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('45', 'JasonXu', 'user2', '[em_42]', '2020-05-05 15:26:32', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('46', 'JasonXu', 'user2', '[em_53]', '2020-05-05 15:26:35', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('47', 'user3', 'user2', '[em_13]', '2020-05-05 15:26:45', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('48', 'user3', 'user2', '[em_52]', '2020-05-05 15:26:50', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('49', 'user3', 'user2', '[em_27]', '2020-05-05 15:26:54', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('50', 'user3', 'user2', '[em_53]', '2020-05-05 15:26:58', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('51', 'user3', 'user2', '[em_5]', '2020-05-05 15:27:03', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('52', 'user3', 'user2', '[em_13]', '2020-05-05 15:27:06', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('53', 'user3', 'user2', '[em_13]', '2020-05-05 15:27:10', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('54', 'user3', 'user2', '[em_13]', '2020-05-05 15:27:14', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('55', 'user3', 'user2', '[em_73]', '2020-05-05 15:27:24', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('56', 'JasonXu', 'user2', '[em_72]', '2020-05-05 15:27:30', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('57', 'JasonXu', 'user2', '[em_53]', '2020-05-05 15:27:34', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('58', 'JasonXu', 'user2', '[em_62]', '2020-05-05 15:27:38', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('59', 'JasonXu', 'user2', '[em_43]', '2020-05-05 15:27:42', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('60', 'JasonXu', 'user2', '[em_42]', '2020-05-05 15:27:48', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('61', 'user3', 'user2', '[em_63]', '2020-05-05 15:27:52', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('62', 'JasonXu', 'user2', '[em_63]', '2020-05-05 15:28:02', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('63', 'JasonXu', 'user2', '[em_52]', '2020-05-05 15:28:08', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('64', 'JasonXu', 'user2', '[em_52]', '2020-05-05 15:28:42', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('65', 'JasonXu', 'user2', '[em_72]', '2020-05-05 15:28:46', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('66', 'JasonXu', 'user2', '[em_63]', '2020-05-05 15:28:49', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('67', 'user3', 'user2', '[em_62]', '2020-05-05 15:29:05', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('68', 'user3', 'user2', '[em_52]', '2020-05-05 15:29:10', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('69', 'user3', 'user2', '[em_73]', '2020-05-05 15:29:13', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('70', 'user3', 'user2', '[em_43][em_53]', '2020-05-05 15:29:18', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('71', 'JasonXu', 'user2', '[em_72]', '2020-05-05 15:29:28', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('72', 'JasonXu', 'user2', '[em_62]', '2020-05-05 15:29:32', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('73', 'JasonXu', 'user2', '[em_52]', '2020-05-05 15:29:36', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('74', 'JasonXu', 'user2', '[em_52]', '2020-05-05 15:29:40', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('75', 'JasonXu', 'user2', '[em_63]', '2020-05-05 15:29:44', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('76', 'JasonXu', 'user2', '[em_63]', '2020-05-05 15:29:47', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('77', 'JasonXu', 'user2', '[em_63]', '2020-05-05 15:29:50', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('78', 'JasonXu', 'user2', '[em_64]', '2020-05-05 15:29:53', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('79', 'JasonXu', 'user2', '[em_43]', '2020-05-05 15:29:57', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('80', 'JasonXu', 'user2', '[em_33]', '2020-05-05 15:30:01', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('81', 'Jason', 'user8', '刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！<a href=http://localhost/html/article/fe-recruit.html?id=8>点我前往</a>', '2020-05-07 13:10:47', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('82', 'Jason', 'user8', '[em_27]', '2020-05-07 13:12:36', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('83', 'user3', 'user2', '[em_43]你好。', '2020-05-08 17:34:50', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('84', 'user3', 'user2', '[em_53]你好。', '2020-05-08 17:35:11', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('85', 'user2', 'user8', '刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！<a href=http://localhost/html/article/fe-recruit.html?id=1>点我前往</a>', '2020-05-10 03:16:41', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('86', 'user2', 'user8', '刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！<a href=http://localhost/html/article/fe-recruit.html?id=1>点我前往</a>', '2020-05-10 03:18:11', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('87', 'user8', 'user2', 'jkda', '2020-05-10 03:18:48', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('88', 'user8', 'user2', '希望得到您的青垂，以下是我的简历信息链接!<a href=http://localhost/html/article/fe-resume.html?id=21>点我前往</a>', '2020-05-10 03:19:22', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('89', 'user10', 'user2', '希望得到您的青垂，以下是我的简历信息链接!<a href=http://localhost/html/article/fe-resume.html?id=11>点我前往</a>', '2020-05-23 17:08:29', '1', '1', '1');
INSERT INTO `fe_chat` VALUES ('90', 'user10', 'JasonXu', '[em_53]', '2020-05-23 17:10:05', '1', '1', '0');
INSERT INTO `fe_chat` VALUES ('91', 'user10', 'user2', '[em_52]', '2020-05-23 17:10:10', '1', '1', '1');

-- ----------------------------
-- Table structure for fe_friend
-- ----------------------------
DROP TABLE IF EXISTS `fe_friend`;
CREATE TABLE `fe_friend` (
  `myid` varchar(10) NOT NULL,
  `friendid` varchar(10) NOT NULL,
  PRIMARY KEY (`myid`,`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fe_friend
-- ----------------------------
INSERT INTO `fe_friend` VALUES ('Clement', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('Clement', 'user2');
INSERT INTO `fe_friend` VALUES ('Clement', 'user3');
INSERT INTO `fe_friend` VALUES ('Clement', 'user4');
INSERT INTO `fe_friend` VALUES ('Clement', 'user8');
INSERT INTO `fe_friend` VALUES ('Jason', 'user8');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'Clement');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user10');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user11');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user12');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user13');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user14');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user15');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user16');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user17');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user18');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user2');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user3');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user4');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user5');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user6');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user7');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user8');
INSERT INTO `fe_friend` VALUES ('JasonXu', 'user9');
INSERT INTO `fe_friend` VALUES ('user10', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user10', 'user2');
INSERT INTO `fe_friend` VALUES ('user10', 'user3');
INSERT INTO `fe_friend` VALUES ('user11', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user11', 'user2');
INSERT INTO `fe_friend` VALUES ('user12', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user12', 'user2');
INSERT INTO `fe_friend` VALUES ('user13', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user13', 'user2');
INSERT INTO `fe_friend` VALUES ('user14', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user14', 'user2');
INSERT INTO `fe_friend` VALUES ('user15', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user15', 'user2');
INSERT INTO `fe_friend` VALUES ('user16', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user16', 'user2');
INSERT INTO `fe_friend` VALUES ('user17', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user17', 'user2');
INSERT INTO `fe_friend` VALUES ('user18', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user18', 'user2');
INSERT INTO `fe_friend` VALUES ('user2', 'Clement');
INSERT INTO `fe_friend` VALUES ('user2', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user2', 'user10');
INSERT INTO `fe_friend` VALUES ('user2', 'user11');
INSERT INTO `fe_friend` VALUES ('user2', 'user13');
INSERT INTO `fe_friend` VALUES ('user2', 'user14');
INSERT INTO `fe_friend` VALUES ('user2', 'user16');
INSERT INTO `fe_friend` VALUES ('user2', 'user17');
INSERT INTO `fe_friend` VALUES ('user2', 'user18');
INSERT INTO `fe_friend` VALUES ('user2', 'user3');
INSERT INTO `fe_friend` VALUES ('user2', 'user5');
INSERT INTO `fe_friend` VALUES ('user2', 'user6');
INSERT INTO `fe_friend` VALUES ('user2', 'user8');
INSERT INTO `fe_friend` VALUES ('user2', 'user9');
INSERT INTO `fe_friend` VALUES ('user3', 'Clement');
INSERT INTO `fe_friend` VALUES ('user3', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user3', 'user10');
INSERT INTO `fe_friend` VALUES ('user3', 'user2');
INSERT INTO `fe_friend` VALUES ('user3', 'user5');
INSERT INTO `fe_friend` VALUES ('user3', 'user8');
INSERT INTO `fe_friend` VALUES ('user4', 'Clement');
INSERT INTO `fe_friend` VALUES ('user4', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user4', 'user2');
INSERT INTO `fe_friend` VALUES ('user4', 'user3');
INSERT INTO `fe_friend` VALUES ('user4', 'user5');
INSERT INTO `fe_friend` VALUES ('user4', 'user8');
INSERT INTO `fe_friend` VALUES ('user5', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user5', 'user3');
INSERT INTO `fe_friend` VALUES ('user5', 'user4');
INSERT INTO `fe_friend` VALUES ('user5', 'user8');
INSERT INTO `fe_friend` VALUES ('user6', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user6', 'user2');
INSERT INTO `fe_friend` VALUES ('user6', 'user8');
INSERT INTO `fe_friend` VALUES ('user7', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user7', 'user8');
INSERT INTO `fe_friend` VALUES ('user8', 'Clement');
INSERT INTO `fe_friend` VALUES ('user8', 'Jason');
INSERT INTO `fe_friend` VALUES ('user8', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user8', 'user2');
INSERT INTO `fe_friend` VALUES ('user8', 'user3');
INSERT INTO `fe_friend` VALUES ('user8', 'user4');
INSERT INTO `fe_friend` VALUES ('user8', 'user5');
INSERT INTO `fe_friend` VALUES ('user8', 'user6');
INSERT INTO `fe_friend` VALUES ('user8', 'user7');
INSERT INTO `fe_friend` VALUES ('user9', 'JasonXu');
INSERT INTO `fe_friend` VALUES ('user9', 'user2');

-- ----------------------------
-- Table structure for fe_recruit
-- ----------------------------
DROP TABLE IF EXISTS `fe_recruit`;
CREATE TABLE `fe_recruit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` char(10) NOT NULL,
  `unit` varchar(20) NOT NULL COMMENT '单位',
  `subject` varchar(8) NOT NULL,
  `stu_intro` varchar(80) NOT NULL COMMENT '学员简介',
  `pattern` varchar(6) NOT NULL COMMENT '教学模式',
  `area` varchar(50) NOT NULL COMMENT '教学地区',
  `address` varchar(100) NOT NULL COMMENT '详细地址',
  `salary` double(18,2) NOT NULL,
  `work_require` varchar(300) NOT NULL COMMENT '工作要求',
  `send_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int NOT NULL COMMENT '发布状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fe_recruit
-- ----------------------------
INSERT INTO `fe_recruit` VALUES ('1', 'user2', '学生家长', '初中数学', '学习成绩中上，喜欢与人交流，听话。', '一对一', '广东 广州市 天河区', '广东省广州市天河区加小明大厦A3302', '60.00', '教学经验不限，最好周末都有时间，周一周五也可以，不过这样要在晚上才可以上课了。数学成绩要好，表达能力要能强。', '2020-03-01 05:36:34', null, '1');
INSERT INTO `fe_recruit` VALUES ('2', 'user3', '学生哥哥', '小学语文', '我弟弟的成绩中上，喜欢与人交流，不捣蛋。', '一对一', '广东 湛江市 廉江市', '广东省湛江市廉江市良垌镇阳光小区808', '60.00', '学历要求高中及以上，语文水平要好，普通话要流利。能够认真备好课。不能以任何理由打小孩，也不能以任何不友好的方式惩罚小孩。教学内容主要是辅导小孩写作业。', '2020-02-22 08:06:50', null, '0');
INSERT INTO `fe_recruit` VALUES ('3', 'user4', '学生监护人', '小学数学', '认真听教，不顽皮。', '一对一', '广东 河源市 和平县', '幸福大街906号', '55.00', '辅导数学作业；教学水平一般；教学经验不限；认真教学。', '2020-02-22 08:10:53', null, '1');
INSERT INTO `fe_recruit` VALUES ('5', 'user3', '学生哥哥', '初中数学', '爱学习，学习成绩稳定，有点小跳皮。', '一对一', '上海 闸北区 城区', '爱华区东风街1099号', '95.00', '教学经验不限，当然了，有经验的优先招聘。初中数学的知识基础要好。', '2020-02-23 15:17:24', null, '1');
INSERT INTO `fe_recruit` VALUES ('7', 'JasonXu', '个人', '高中数理化生', '认真听学，成绩优良。', '一对一', '重庆 长寿区 长寿湖镇', '龙区虎牙街1258号', '80.00', '要有教练经验。表达能力强。教学思路清晰。', '2020-02-24 00:05:51', null, '1');

-- ----------------------------
-- Table structure for fe_resume
-- ----------------------------
DROP TABLE IF EXISTS `fe_resume`;
CREATE TABLE `fe_resume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` char(10) NOT NULL,
  `salary` double(18,2) NOT NULL,
  `subject` varchar(8) NOT NULL,
  `pattern` varchar(6) NOT NULL,
  `motto` varchar(50) DEFAULT NULL,
  `address` varchar(50) NOT NULL,
  `intro` varchar(300) NOT NULL COMMENT '个人简介',
  `send_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int NOT NULL COMMENT '发布状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fe_resume
-- ----------------------------
INSERT INTO `fe_resume` VALUES ('3', 'user4', '60.00', '高中生物', '一对一', '上帝喜欢外向的人。', '广东 湛江市 麻章区', '生物成绩优秀，高考生物90（满分90）。个人总结了很多学习生物的方法，肯定会一种适合你的。可以让你在最短的时间内提升生物成绩，一周提升10分不是梦。性格开朗，乐于助人。', '2020-02-22 08:12:52', null, '1');
INSERT INTO `fe_resume` VALUES ('4', 'user5', '60.00', '初中化学', '一对一', '机会总是留给有准备的人。', '广东 湛江市 霞山区', '学习成绩优良，化学就特别厉害，中考化学满分。乐于助人，喜欢与人交流。工作认真，不迟到早退；会认真备好每一节课，让教学更有思路，让学生在短时间内可以完成更多的学生任务。教学水平高，曾多次做家教工作。', '2020-02-22 08:20:33', null, '1');
INSERT INTO `fe_resume` VALUES ('5', 'user6', '90.00', '音乐', '一对一', '我就是你要的人。', '北京 朝阳区 三环到四环之间', '自小音乐天赋就是好。学习成绩优良，音乐就特别厉害。乐于助人，喜欢与人交流。工作认真，不迟到早退；会认真备好每一节课，让教学更有思路，让学生在短时间内可以完成更多的学生任务。教学水平高，曾多次做家教工作。', '2020-03-15 06:54:39', null, '1');
INSERT INTO `fe_resume` VALUES ('6', 'user7', '80.00', '音乐', '一对一', '没有人比我更懂你。', '湖南 湘潭市 湘潭县', '不管你有没有音乐天赋，跟了我你就会有。', '2020-02-22 08:28:16', null, '1');
INSERT INTO `fe_resume` VALUES ('7', 'user8', '90.00', '表演', '一对一', '相信自己可以。', '北京 海淀区 三环以内', '没有人比我更懂你。我可以让你喜欢上表演。', '2020-05-10 03:20:32', null, '1');
INSERT INTO `fe_resume` VALUES ('8', 'JasonXu', '200.00', '音乐、表演', '一对一', '没有人比我更懂你，快来跟我学音乐表演吧！一定不能错过喔。', '重庆 长寿区 邻封镇', '2010年，肖战考入重庆工商大学现代国际设计艺术学院。从进校开始一直担任班级文艺委员，并进入了校艺术团合唱分团，担任校大学生艺术团声乐部部长、男声声部部长，同时担任校语言艺术分团的演员。大一时，肖战随语言艺术分团到北京演出《我有一个梦想》。大二时，参加重庆工商大学“校园十佳歌手”比赛，获“校园十佳歌手荣誉称号”。随后代表重庆工商大学参加重庆市市级“校园十佳歌手”的比赛，获得二等奖。肖战经常参加学校各类演出，并且在工商大学60年校庆晚会中担任歌唱类节目开场独唱。在校期间，曾荣获校级“文艺先进个人”、 “优秀艺术团干部”、“优秀团员”等荣誉称号。在学校举办的公益海报设计比赛中，还获得过“一等奖“。', '2020-02-22 09:00:38', null, '1');
INSERT INTO `fe_resume` VALUES ('9', 'user3', '88.00', '高中生物', '一对一', '敢受敢恨，做一个自由的人士。', '广东 湛江市 赤坎区', '学习成绩优秀，拿过高中生物全国比赛二等奖。爱与他人交流，表达能力强。有信心引领生快速的有效的学习更多的知识，让其可以在短时间内提分。', '2020-02-23 15:20:52', null, '1');
INSERT INTO `fe_resume` VALUES ('10', 'user9', '180.00', '高中政治', '一对一', '没有谁可以超越我。', '广东 广州市 海珠区', '许凯，1995年3月5日出生于广东，中国内地男演员、模特。2013年，获得中国（广州）国际模特大赛全国总决赛平面组冠军，以模特身份正式出道。2016年签约成为欢娱影视旗下艺人，同年，出演个人首部电视剧《朝歌》，从而正式进入演艺圈。2017年，主演电视剧《延禧攻略》，饰演富察傅恒；同年，搭档白鹿主演古装仙侠剧《招摇》。2018年，出演电视剧《烈火军校》，饰演男主顾燕帧。', '2020-02-24 09:52:44', null, '1');
INSERT INTO `fe_resume` VALUES ('11', 'user10', '150.00', '高中历史', '一对一', '塑造一个全新的自己。', '湖北 咸宁市 崇阳县', '李现，曾用名李晛，1991年10月19日出生于湖北省咸宁市，成长于湖北省荆州市，中国内地影视男演员，毕业于北京电影学院表演系2010级。2011年，出演个人首部电影《万箭穿心》，从而正式进入演艺圈。2012年，主演青春爱情电影《初恋未满》。2013年，出演绿色环保爱情喜剧电影《玩命试爱》。2014年，出演国内首部原创都市奇幻单元《奇妙世纪》中第二集“最长的25米”。', '2020-02-24 09:57:53', null, '0');
INSERT INTO `fe_resume` VALUES ('12', 'user11', '120.00', '初中地理', '一对一', '相信明天会更好。', '四川 成都市 金牛区', '张靓颖（Jane Zhang），1984年10月11日出生于四川成都，中国流行乐女歌手、词曲创作人。2004年，获得华纳唱片举办的《闪亮之星大学生歌手选拔赛》全国总冠军。次年，参加湖南卫视娱乐节目《2005超级女声》后正式出道。2006年，发行首张音乐专辑《The One》，凭该专辑获得第6届中国金唱片奖通俗类女演员奖。2007年，成为继崔健后、第二位在美国举行演唱会的中国内地歌手。', '2020-02-24 10:01:26', null, '1');
INSERT INTO `fe_resume` VALUES ('13', 'user12', '160.00', '初中化学', '一对一', '想唱就唱，唱得响亮。', '四川 成都市 锦江区', '李宇春（Chris Lee），1984年3月10日出生于成都，中国流行女歌手、演员、词曲创作人、演唱会导演。2005年，李宇春获得”超级女声“全国总冠军，登上美国《时代周刊》封面。2006年发行首张专辑《皇后与梦想》，年终销量137万张，创立品牌演唱会“WhyMe”。2007年发行专辑《我的》并首次开展全国巡演，再登美国《时代周刊》。2008年发行专辑《少年中国》，获得MTV亚洲音乐大奖中国最受欢迎。', '2020-02-24 10:04:59', null, '1');
INSERT INTO `fe_resume` VALUES ('14', 'user13', '600.00', '音乐', '一对一', '做自己想做的事情。', '湖南 长沙市 天心区', '周笔畅，1985年7月26日出生于湖南长沙，中国内地女歌手、词曲创作人、演员、Begins品牌主理人兼设计总监。2005年获超级女声全国亚军出道；2006年发行首张个人专辑《谁动了我的琴弦》，并先后在电影《春田花花同学会》及《第601个电话》中担任女主角；2007年赴美国洛杉矶音乐学院进修并以全A成绩毕业。', '2020-02-24 10:08:33', null, '1');
INSERT INTO `fe_resume` VALUES ('15', 'user14', '230.00', '高中语文', '一对一', '我就是你想找的人。', '台湾 台湾 台湾市区内', '郑元畅（Joseph Cheng），本名郑综腾，1982年6月19日出生于台湾省台中市北屯区，中国台湾影视男演员、流行乐歌手、模特，毕业于私立醒吾技术学院。\r\n2003年，出演个人首部电视剧《蔷薇之恋》，从而正式进入演艺圈  。2004年，在都市言情喜剧《爱情魔戒》中饰演男主角杜竞航  。2005年，在青春偶像剧《恶作剧之吻》中饰演男主角江直树 。2006年，主演清装武侠剧《庚子风云》。2007年，主演青春偶像剧《热情仲夏》，并为该剧演唱插曲《亲夏天一下》 。2008年，主演青春偶像剧《我的亿万面包》 。2009年，获得“亚洲模特奖颁奖礼', '2020-02-24 10:13:11', null, '1');
INSERT INTO `fe_resume` VALUES ('16', 'user15', '110.00', '高中生物', '一对一', '我就是那么嚣张，怎么地。', '北京 西城区 内环到二环里', '张一山，1992年5月5日出生于北京市西城区，毕业于北京电影学院，中国内地男演员。2000年，张一山开始拍摄广告片，后被导演徐耿相中，出演首部电视剧作品《小兵张嘎》。2004年，因在少儿题材的情景喜剧《家有儿女》中饰演刘星后而被观众们熟知。2007年，获得腾讯星光大典年度潜力演艺新人奖。2008年，出演少年励志电影电影《扣篮对决》。2009年，主演儿童电影《寻找成龙》。', '2020-02-24 10:15:18', null, '1');
INSERT INTO `fe_resume` VALUES ('17', 'user16', '168.00', '高中英语', '一对一', '别我小，可我力量大。', '湖南 怀化市 会同县', '易烊千玺，2000年11月28日生于湖南怀化，中国内地男歌手、舞者、演员，TFBOYS成员 ，就读于中央戏剧学院。2009年，易烊千玺加入飞炫少年组合。2010年，首部影视剧《铁梨花》播出。2013年，加入TFBOYS组合。2014年，书法作品“挥斥方遒”被丹麦王国驻华大使馆收藏。', '2020-02-24 10:19:12', null, '1');
INSERT INTO `fe_resume` VALUES ('18', 'user17', '360.00', '高中理综', '一对一', '没有什么是不可能的。', '港澳 香港特别行政区 九龙城区', '张曼玉于1964年9月20日（中秋节）出生于香港，在香港时曾就读于圣保罗小学  。8岁时随家人移居英国 ，少年时期在英格兰肯特郡度过。张曼玉自小被母亲以传统方式严加管教  ，中学毕业后曾在伦敦一家书店做过店员  。1982年，张曼玉返回香港度假期间被广告公司的星探相中，之后开始担任兼职模特   。', '2020-02-24 10:22:12', null, '1');
INSERT INTO `fe_resume` VALUES ('19', 'user18', '800.00', '高中化学', '一对一', '相信自己是可以的。', '港澳 香港特别行政区 湾仔区', '1995年参加无线电视第14届《新秀歌唱大赛》获得季军进入歌坛。2000年以《少女的祈祷》一曲获得香港乐坛四台颁奖典礼多个金曲奖项。2002年发行专辑《Miriam\'s Music Box》，其中歌曲《可惜我是水瓶座》成为其代表作之一。2002年、2008年与2009年三度夺得十大劲歌金曲最受欢迎女歌星。2005年凭借电影《千杯不醉》获第42届台湾电影金马奖最佳女主角提名。2011年凭借电影《抱抱俏佳人》获得第17届香港电影评论学会大奖最佳女主角。2013年凭借《春娇与志明》夺得第32届香港电影金像奖最佳女主角，2014年主演电影《五个小孩的校长》，同年推出国语单曲《色惑》。', '2020-02-24 10:24:59', null, '1');
INSERT INTO `fe_resume` VALUES ('20', 'Clement', '90.00', '初中英语', '一对一', '你尽管努力，其他的交给天意。', '广东 湛江市 赤坎区', '初中英语成绩良好。中考成绩139，所以我认为我有能力胜任这份工作。请相信我。', '2020-02-28 00:08:06', null, '1');
INSERT INTO `fe_resume` VALUES ('21', 'user8', '60.00', '高中数学', '一对一', '林', '上海 闸北区 城区', '式', '2020-05-03 15:11:05', null, '0');
INSERT INTO `fe_resume` VALUES ('22', 'user2', '50.00', '高中数学', '一对一', '一分耕耘一分收获。', '河南 周口市 商水县', '数学成绩优越，有较强的抗压能力，有教学经验。', '2020-05-03 16:00:05', null, '0');
INSERT INTO `fe_resume` VALUES ('23', 'user2', '60.00', '高中生物', '一对一', '没有付出就没有回报。', '天津 河东区 全境', '勤奋好学，学习成绩优越。有教好学生的能力。', '2020-05-03 16:01:45', null, '0');
INSERT INTO `fe_resume` VALUES ('24', 'user2', '55.00', '英语', '一对一', '做好自己', '上海 闸北区 城区', '没有什么要评价的了', '2020-05-23 10:49:39', null, '1');
INSERT INTO `fe_resume` VALUES ('25', 'user10', '50.00', '高中数学', '一对一', '努力才有胜利的机会', '', '做好自己', '2020-05-23 17:09:55', null, '1');

-- ----------------------------
-- Table structure for fe_user
-- ----------------------------
DROP TABLE IF EXISTS `fe_user`;
CREATE TABLE `fe_user` (
  `uid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `uname` varchar(10) DEFAULT NULL COMMENT '实名',
  `nickname` varchar(10) NOT NULL COMMENT '昵称',
  `pwd` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `power` int NOT NULL COMMENT '权限1学生、2家长、3管理员',
  `status` int NOT NULL COMMENT '用户状态',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `photo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `regist_time` datetime NOT NULL COMMENT '注册时间',
  `logout_time` datetime DEFAULT NULL COMMENT '注销时间',
  `school` varchar(30) DEFAULT NULL COMMENT '院校',
  `degree` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学位',
  `profession` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位',
  `studentCard` varchar(30) DEFAULT NULL COMMENT '学生证',
  `isIdentify` int DEFAULT NULL COMMENT '是否已认证',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fe_user
-- ----------------------------
INSERT INTO `fe_user` VALUES ('admin', '系统箮员', 'ms', '123456', '3', '1', null, null, 'userPhoto/userPhoto.jpg', '18900848929', null, '2020-05-17 15:52:02', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('Clement', '魏巡', 'Clement', '123456', '1', '1', '23', '男', 'userPhoto/Clement.jpg', '18218432901', 'Clement@familyedu.com', '2020-02-22 16:00:48', null, '广东工业大学', '本科', null, null, 'userPhoto/Clementedu.png', '1');
INSERT INTO `fe_user` VALUES ('JasonXu', '肖战', '战战', '123456', '1', '1', '28', '男', 'userPhoto/JasonXu.jpg', '18218432907', 'JasonXu@familyedu.com', '2020-01-30 15:45:19', null, '中央戏剧学院', '本科', null, null, 'userPhoto/JasonXuedu.png', '0');
INSERT INTO `fe_user` VALUES ('user10', '李现', '李现', '123456', '1', '1', '30', '男', 'userPhoto/user10.jpg', '15926488599', 'user10@familyedu.com', '2020-02-24 17:30:10', null, '北京电影学院', '本科', null, null, 'userPhoto/user10edu.png', '0');
INSERT INTO `fe_user` VALUES ('user11', '张靓颖', '张靓颖', '123456', '1', '1', '27', '女', 'userPhoto/user11.jpg', '13926688599', 'user11@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user12', '李宇春', '李宇春', '123456', '2', '1', '21', '女', 'userPhoto/user12.jpg', '16326488699', 'user12@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user13', '周笔畅', '周笔畅', '123456', '2', '1', '26', '女', 'userPhoto/user13.jpg', '17936486599', 'user13@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user14', '郑元畅', '郑元畅', '123456', '1', '1', '21', '男', 'userPhoto/user14.jpg', '18923486599', 'user14@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user15', '张一山', '张一山', '123456', '2', '0', '17', '男', 'userPhoto/user15.jpg', '18926688599', 'user15@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user16', '易烊千玺', '易烊千玺', '123456', '2', '1', '18', '男', 'userPhoto/user16.jpg', '13626338599', 'user16@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user17', '张曼玉', '张曼玉', '123456', '2', '1', '32', '女', 'userPhoto/user17.jpg', '17926483599', 'user17@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user18', '杨千嬅', '杨千嬅', '123456', '2', '1', '28', '女', 'userPhoto/user18.jpg', '15966488539', 'user18@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user2', '吴尊', 'Wuzun', '123456', '1', '1', '21', '女', 'userPhoto/user2.jpg', '13659874477', 'user2@familyedu.com', '2020-01-31 16:27:27', null, '北京大学', '本科', '学生', '', 'userPhoto/user2edu.png', '1');
INSERT INTO `fe_user` VALUES ('user4', '黄圣池', '黄圣池', '123456', '1', '1', '22', '男', 'userPhoto/shengchi.jpg', '14787456982', 'user4@familyedu.com', '2020-01-31 16:26:26', null, null, null, ',学生', null, null, null);
INSERT INTO `fe_user` VALUES ('user5', '黄晓明', '小明', '123456', '2', '1', '20', '男', 'userPhoto/user5.jpg', '18900831604', 'user5@familyedu.com', '2020-02-02 22:02:24', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user6', '黄榕生', '小生', '123456', '1', '1', '22', '男', 'userPhoto/user6.jpg', '13432896770', 'user6@familyedu.com', '2020-02-02 21:54:29', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user7', '洪雨雷', '鱼雷', '123456', '1', '1', '22', '男', 'userPhoto/yulei.jpg', '13456895521', 'user7@familyedu.com', '2020-01-31 16:25:25', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user8', '刘亦菲', '菲菲', '147258', '1', '1', '23', '女', 'userPhoto/user8.jpg', '18901548796', 'user8@famliyedu.com', '2020-01-31 15:35:25', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('user9', '许凯', '许凯', '123456', '2', '1', '29', '男', 'userPhoto/user9.png', '15926488599', 'user9@familyedu.com', '2020-02-24 17:30:10', null, null, null, null, null, null, null);
INSERT INTO `fe_user` VALUES ('xujhui', '许辉', 'xujhui', '123456', '1', '1', '22', '男', 'userPhoto/xujhui.jpg', '18218432906', 'xujhui@foxmail.com', '2020-05-17 15:15:18', null, null, null, '学生家长 ', null, null, '0');
