/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2020-05-20 19:05:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dishesinfo
-- ----------------------------
DROP TABLE IF EXISTS `dishesinfo`;
CREATE TABLE `dishesinfo` (
  `dishesid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品编号，主键，自动增长',
  `dishesname` varchar(50) NOT NULL COMMENT '菜品名称',
  `dishesdiscript` varchar(100) NOT NULL COMMENT '菜品的简单介绍',
  `dishesimg` varchar(100) NOT NULL DEFAULT '0.jpg' COMMENT '菜品图片文件名称',
  `dishestxt` varchar(400) NOT NULL COMMENT '菜品详细介绍',
  `recommend` int(11) NOT NULL DEFAULT '0' COMMENT '是否推荐菜品：0-非推荐，1-推荐菜品',
  `dishesprice` varchar(50) NOT NULL COMMENT '菜品单价',
  PRIMARY KEY (`dishesid`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishesinfo
-- ----------------------------
INSERT INTO `dishesinfo` VALUES ('1', '白灼基围虾', '1', '1.jpg', '1', '1', '40');
INSERT INTO `dishesinfo` VALUES ('2', '冰糖湘莲', '1', '2.jpg', '1', '1', '25');
INSERT INTO `dishesinfo` VALUES ('3', '豉香黄花鱼', '1', '3.jpg', '1', '1', '40');
INSERT INTO `dishesinfo` VALUES ('4', '葱爆鱿鱼', '1', '4.jpg', '1', '1', '45');
INSERT INTO `dishesinfo` VALUES ('5', '大酱汤', '1', '5.jpg', '1', '1', '36');
INSERT INTO `dishesinfo` VALUES ('6', '蛋黄南瓜', '1', '6.jpg', '1', '1', '22');
INSERT INTO `dishesinfo` VALUES ('7', '灯影牛肉', '1', '7.jpg', '1', '1', '39');
INSERT INTO `dishesinfo` VALUES ('8', '地三鲜', '1', '8.jpg', '1', '1', '29');
INSERT INTO `dishesinfo` VALUES ('9', '东安子鸡', '1', '9.jpg', '1', '1', '50');
INSERT INTO `dishesinfo` VALUES ('10', '东坡肉', '1', '10.jpg', '1', '1', '59');
INSERT INTO `dishesinfo` VALUES ('11', '剁椒鱼头', '1', '11.jpg', '1', '1', '49');
INSERT INTO `dishesinfo` VALUES ('12', '飞龙汤', '1', '12.jpg', '1', '1', '45');
INSERT INTO `dishesinfo` VALUES ('13', '佛跳墙', '1', '13.jpg', '1', '1', '66');
INSERT INTO `dishesinfo` VALUES ('14', '夫妻肺片', '1', '14.jpg', '1', '1', '30');
INSERT INTO `dishesinfo` VALUES ('15', '宫保鸡丁', '1', '15.jpg', '1', '0', '29');
INSERT INTO `dishesinfo` VALUES ('16', '咕噜肉', '1', '16.jpg', '1', '0', '36');
INSERT INTO `dishesinfo` VALUES ('17', '广式糯米卷', '1', '17.jpg', '1', '0', '18');
INSERT INTO `dishesinfo` VALUES ('18', '蚝油杏鲍菇', '1', '18.jpg', '1', '0', '24');
INSERT INTO `dishesinfo` VALUES ('19', '荷塘小炒', '1', '19.jpg', '1', '0', '20');
INSERT INTO `dishesinfo` VALUES ('20', '红烧带鱼', '1', '20.jpg', '1', '0', '38');
INSERT INTO `dishesinfo` VALUES ('21', '红烧肉', '1', '21.jpg', '1', '0', '36');
INSERT INTO `dishesinfo` VALUES ('22', '红糖糍粑', '1', '22.jpg', '1', '0', '18');
INSERT INTO `dishesinfo` VALUES ('23', '虎皮青椒', '1', '23.jpg', '1', '0', '20');
INSERT INTO `dishesinfo` VALUES ('24', '回锅肉', '1', '24.jpg', '1', '0', '29');
INSERT INTO `dishesinfo` VALUES ('25', '鲫鱼汤', '1', '25.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('26', '咖喱鱼蛋', '1', '26.jpg', '1', '0', '24');
INSERT INTO `dishesinfo` VALUES ('27', '开水白菜', '1', '27.jpg', '1', '0', '15');
INSERT INTO `dishesinfo` VALUES ('28', '口水鸡', '1', '28.jpg', '1', '0', '35');
INSERT INTO `dishesinfo` VALUES ('29', '口味蛇', '1', '29.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('30', '腊味合蒸', '1', '30.jpg', '1', '0', '36');
INSERT INTO `dishesinfo` VALUES ('31', '辣椒炒肉', '1', '31.jpg', '1', '0', '29');
INSERT INTO `dishesinfo` VALUES ('32', '辣子鸡', '1', '32.jpg', '1', '0', '29');
INSERT INTO `dishesinfo` VALUES ('33', '凉拌黄豆芽', '1', '33.jpg', '1', '0', '12');
INSERT INTO `dishesinfo` VALUES ('34', '龙井虾仁', '1', '34.jpg', '1', '0', '32');
INSERT INTO `dishesinfo` VALUES ('35', '麻婆豆腐', '1', '35.jpg', '1', '0', '22');
INSERT INTO `dishesinfo` VALUES ('36', '毛血旺', '1', '36.jpg', '1', '0', '30');
INSERT INTO `dishesinfo` VALUES ('37', '排骨山药汤', '1', '37.jpg', '1', '0', '26');
INSERT INTO `dishesinfo` VALUES ('38', '皮蛋豆腐', '1', '38.jpg', '1', '0', '18');
INSERT INTO `dishesinfo` VALUES ('39', '清炒茭白', '1', '39.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('40', '清炒苦瓜', '1', '40.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('41', '清炒生菜', '1', '41.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('42', '清蒸江团', '1', '42.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('43', '肉沫茄子', '1', '43.jpg', '1', '0', '26');
INSERT INTO `dishesinfo` VALUES ('44', '十三香小龙虾', '1', '44.jpg', '1', '0', '68');
INSERT INTO `dishesinfo` VALUES ('45', '水晶肘子', '1', '45.jpg', '1', '0', '58');
INSERT INTO `dishesinfo` VALUES ('46', '四喜丸子', '1', '46.jpg', '1', '0', '36');
INSERT INTO `dishesinfo` VALUES ('47', '素炒空心菜', '1', '47.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('48', '酸菜鱼', '1', '48.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('49', '酸辣土豆丝', '1', '49.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('50', '酸溜白菜', '1', '50.jpg', '1', '0', '19');
INSERT INTO `dishesinfo` VALUES ('51', '蒜香荷兰豆', '1', '51.jpg', '1', '0', '22');
INSERT INTO `dishesinfo` VALUES ('52', '糖醋鱼块', '1', '52.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('53', '外婆菜', '1', '53.jpg', '1', '0', '20');
INSERT INTO `dishesinfo` VALUES ('54', '豌豆炒牛肉', '1', '54.jpg', '1', '0', '29');
INSERT INTO `dishesinfo` VALUES ('55', '莴笋炒山药', '1', '55.jpg', '1', '0', '26');
INSERT INTO `dishesinfo` VALUES ('56', '西红柿炒蛋', '1', '56.jpg', '1', '0', '20');
INSERT INTO `dishesinfo` VALUES ('57', '西红柿土豆炖牛肉', '1', '57.jpg', '1', '0', '30');
INSERT INTO `dishesinfo` VALUES ('58', '香菜豆腐羹', '1', '58.jpg', '1', '0', '26');
INSERT INTO `dishesinfo` VALUES ('59', '香菇青菜', '1', '59.jpg', '1', '0', '24');
INSERT INTO `dishesinfo` VALUES ('60', '盐焗花螺', '1', '60.jpg', '1', '0', '36');
INSERT INTO `dishesinfo` VALUES ('61', '永州血鸭', '1', '61.jpg', '1', '0', '39');
INSERT INTO `dishesinfo` VALUES ('62', '油焖大虾', '1', '62.jpg', '1', '0', '49');
INSERT INTO `dishesinfo` VALUES ('63', '鱼香茄子', '1', '63.jpg', '1', '0', '24');
INSERT INTO `dishesinfo` VALUES ('64', '鱼香肉丝', '1', '64.jpg', '1', '0', '20');
INSERT INTO `dishesinfo` VALUES ('69', '难吃的要死', '123123', '/img/upload/be6666a4-8d2a-4a30-9a8b-49bf6022ce94.jpg', '123123', '1', '33');
INSERT INTO `dishesinfo` VALUES ('70', '油炸香菜', '狗屎', '/img/upload/030bd15f-6f10-4ae5-a84c-9d5c3622c9d9.png', '一坨狗屎', '1', '200');

-- ----------------------------
-- Table structure for orderdishes
-- ----------------------------
DROP TABLE IF EXISTS `orderdishes`;
CREATE TABLE `orderdishes` (
  `odid` int(11) NOT NULL AUTO_INCREMENT COMMENT '详单编号，主键，自动增长',
  `orderreference` int(11) NOT NULL COMMENT '对应订单编号，外键\r\n',
  `dishes` int(11) NOT NULL COMMENT '对应菜品编号，外键',
  `num` int(11) NOT NULL COMMENT '菜品的数量',
  `status` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`odid`),
  KEY `orderdishes_orderreference` (`orderreference`),
  KEY `orderdishes_dishes` (`dishes`),
  CONSTRAINT `orderdishes_dishes` FOREIGN KEY (`dishes`) REFERENCES `dishesinfo` (`dishesid`),
  CONSTRAINT `orderdishes_orderreference` FOREIGN KEY (`orderreference`) REFERENCES `orderinfo` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdishes
-- ----------------------------
INSERT INTO `orderdishes` VALUES ('1', '1', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('2', '1', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('3', '2', '2', '3', '1');
INSERT INTO `orderdishes` VALUES ('4', '4', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('5', '4', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('6', '4', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('7', '5', '7', '3', '1');
INSERT INTO `orderdishes` VALUES ('8', '5', '6', '2', '1');
INSERT INTO `orderdishes` VALUES ('9', '5', '5', '2', '1');
INSERT INTO `orderdishes` VALUES ('10', '5', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('11', '6', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('12', '6', '7', '2', '1');
INSERT INTO `orderdishes` VALUES ('13', '6', '2', '2', '1');
INSERT INTO `orderdishes` VALUES ('14', '6', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('15', '7', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('16', '7', '7', '2', '1');
INSERT INTO `orderdishes` VALUES ('17', '7', '6', '2', '1');
INSERT INTO `orderdishes` VALUES ('18', '7', '5', '2', '1');
INSERT INTO `orderdishes` VALUES ('19', '8', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('20', '8', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('21', '9', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('22', '10', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('23', '10', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('24', '11', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('25', '11', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('26', '11', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('27', '12', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('28', '13', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('29', '14', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('30', '15', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('31', '16', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('32', '16', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('33', '16', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('34', '17', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('35', '17', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('36', '17', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('37', '18', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('38', '18', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('39', '18', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('40', '19', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('41', '19', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('42', '20', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('43', '20', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('44', '20', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('45', '21', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('46', '21', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('47', '22', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('48', '23', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('49', '24', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('50', '24', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('51', '24', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('52', '25', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('53', '25', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('54', '25', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('55', '26', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('56', '26', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('57', '26', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('58', '27', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('59', '28', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('60', '29', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('61', '30', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('62', '31', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('63', '32', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('64', '33', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('66', '35', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('67', '35', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('68', '35', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('69', '36', '7', '4', '1');
INSERT INTO `orderdishes` VALUES ('70', '37', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('71', '37', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('72', '37', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('73', '38', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('74', '38', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('75', '38', '8', '1', '1');
INSERT INTO `orderdishes` VALUES ('76', '38', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('77', '39', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('78', '39', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('79', '39', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('80', '40', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('81', '40', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('82', '40', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('83', '41', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('84', '41', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('85', '41', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('86', '41', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('87', '42', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('88', '42', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('89', '42', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('90', '43', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('91', '43', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('92', '43', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('93', '43', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('94', '44', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('95', '44', '2', '2', '1');
INSERT INTO `orderdishes` VALUES ('96', '44', '8', '1', '1');
INSERT INTO `orderdishes` VALUES ('97', '44', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('98', '45', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('99', '45', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('100', '45', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('101', '45', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('102', '46', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('103', '46', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('104', '46', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('105', '46', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('106', '46', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('107', '46', '70', '1', '1');
INSERT INTO `orderdishes` VALUES ('108', '46', '69', '1', '1');
INSERT INTO `orderdishes` VALUES ('109', '47', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('110', '47', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('111', '47', '5', '1', '1');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号，主键，自动增长',
  `orderbegindate` varchar(50) NOT NULL COMMENT '订单开始时间',
  `orderenddate` varchar(50) DEFAULT NULL COMMENT '订单结束时间',
  `waiterid` int(11) NOT NULL COMMENT '订单的点餐员ID，外键',
  `orderstate` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态：0-正在用餐，1-准备结账，2-已经结账，3-免单订单',
  `tableid` int(11) NOT NULL COMMENT '订单应的桌号',
  PRIMARY KEY (`orderid`),
  KEY `orderinfo_waiterid` (`waiterid`),
  KEY `table_tableid` (`tableid`),
  CONSTRAINT `orderinfo_waiterid` FOREIGN KEY (`waiterid`) REFERENCES `userinfo` (`userid`),
  CONSTRAINT `table_tableid` FOREIGN KEY (`tableid`) REFERENCES `tables` (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '2020-03-01 12:54', '2020-03-01 13:48', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('2', '2020-03-12 18:03', '2020-03-12 19:31', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('4', '2020-05-14 16:49:41', '2020-05-14 10:41', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('5', '2020-05-14 17:23:25', '2020-05-14 10:41', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('6', '2020-05-14 20:41:33', '2020-05-14 10:41', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('7', '2020-05-14 20:49:14', '2020-05-14 16:18', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('8', '2020-05-18 10:24:27', '2020-05-18 16:07', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('9', '2020-05-19 17:29:39', '2020-05-19 10:42', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('10', '2020-05-20 09:35:44', '2020-05-20 10:42', '3', '1', '7');
INSERT INTO `orderinfo` VALUES ('11', '2020-05-20 09:36:40', '2020-05-20 10:42', '3', '1', '8');
INSERT INTO `orderinfo` VALUES ('12', '2020-05-20 09:42:01', '2020-05-20 10:42', '3', '1', '9');
INSERT INTO `orderinfo` VALUES ('13', '2020-05-1509:53:32', '2020-05-15 10:42', '3', '1', '10');
INSERT INTO `orderinfo` VALUES ('14', '2020-05-1509:56:56', '2020-05-15 10:42', '3', '1', '11');
INSERT INTO `orderinfo` VALUES ('15', '2020-05-1510:31:29', '2020-05-15 10:42', '3', '1', '12');
INSERT INTO `orderinfo` VALUES ('16', '2020-05-1610:39:05', '2020-05-16 10:42', '3', '1', '13');
INSERT INTO `orderinfo` VALUES ('17', '2020-05-20 10:51:13', '2020-05-20 10:57', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('18', '2020-05-13 10:53:07', '2020-05-13 10:57', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('19', '2020-05-13 10:55:19', '2020-05-13 10:57', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('20', '2020-05-13 10:55:46', '2020-05-13 10:57', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('21', '2020-05-13 10:58:19', '2020-05-13 11:10', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('22', '2020-05-17 11:09:52', '2020-05-17 11:10', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('23', '2020-05-17 11:10:00', '2020-05-17 11:10', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('24', '2020-05-17 11:11:21', '2020-05-17 14:32', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('25', '2020-05-17 11:11:54', '2020-05-17 17:43', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('26', '2020-05-19 11:12:15', '2020-05-19 17:43', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('27', '2020-05-19 11:21:05', '2020-05-19 17:43', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('28', '2020-05-19 11:21:25', '2020-05-19 17:43', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('29', '2020-05-19 11:24:05', '2020-05-19 17:43', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('30', '2020-05-15 11:24:28', '2020-05-15 17:43', '3', '1', '7');
INSERT INTO `orderinfo` VALUES ('31', '2020-05-15 11:27:17', '2020-05-15 17:43', '3', '1', '8');
INSERT INTO `orderinfo` VALUES ('32', '2020-05-15 11:28:50', '2020-05-15 14:33', '3', '1', '9');
INSERT INTO `orderinfo` VALUES ('33', '2020-05-15 14:51:09', '2020-05-15 17:43', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('35', '2020-05-18 17:42:07', '2020-05-18 17:43', '3', '1', '10');
INSERT INTO `orderinfo` VALUES ('36', '2020-05-18 17:42:19', '2020-05-18 17:44', '3', '1', '11');
INSERT INTO `orderinfo` VALUES ('37', '2020-05-18 17:42:24', '2020-05-18 17:44', '3', '1', '12');
INSERT INTO `orderinfo` VALUES ('38', '2020-05-16 17:42:31', '2020-05-16 17:44', '3', '1', '13');
INSERT INTO `orderinfo` VALUES ('39', '2020-05-16 17:47:32', '2020-05-16 17:48', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('40', '2020-05-16 17:47:39', '2020-05-16 17:48', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('41', '2020-05-16 17:47:47', '2020-05-16 17:48', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('42', '2020-05-20 17:47:56', '2020-05-20 17:48', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('43', '2020-05-20 17:48:03', '2020-05-20 17:48', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('44', '2020-05-20 17:48:24', '2020-05-20 17:49', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('45', '2020-05-20 17:48:32', '2020-05-20 17:49', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('46', '2020-05-20 17:48:47', '2020-05-20 17:49', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('47', '2020-05-20 17:48:57', '2020-05-20 17:49', '3', '1', '3');

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号，主键，自动增长',
  `rolename` varchar(32) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('1', '后厨');
INSERT INTO `roleinfo` VALUES ('2', '管理员');
INSERT INTO `roleinfo` VALUES ('3', '点餐员');

-- ----------------------------
-- Table structure for tables
-- ----------------------------
DROP TABLE IF EXISTS `tables`;
CREATE TABLE `tables` (
  `tableid` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌编号',
  `tablename` varchar(50) NOT NULL COMMENT '餐桌名字',
  `tablestatus` int(11) NOT NULL DEFAULT '0' COMMENT '餐桌状态：0为未使用，1为正在使用',
  PRIMARY KEY (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tables
-- ----------------------------
INSERT INTO `tables` VALUES ('1', '春暖花开', '0');
INSERT INTO `tables` VALUES ('2', '合家小桌', '0');
INSERT INTO `tables` VALUES ('3', '暮春三月', '0');
INSERT INTO `tables` VALUES ('4', '江山如画', '0');
INSERT INTO `tables` VALUES ('5', '水天一色', '0');
INSERT INTO `tables` VALUES ('6', '一叶知秋', '0');
INSERT INTO `tables` VALUES ('7', '枯木逢春', '0');
INSERT INTO `tables` VALUES ('8', '流水落花', '0');
INSERT INTO `tables` VALUES ('9', '阳春白雪', '1');
INSERT INTO `tables` VALUES ('10', '松柏后凋', '0');
INSERT INTO `tables` VALUES ('11', '寒花晚节', '0');
INSERT INTO `tables` VALUES ('12', '金风玉露', '0');
INSERT INTO `tables` VALUES ('13', '啼饥号寒', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键，自动增长',
  `useraccount` varchar(20) NOT NULL COMMENT '账号名称',
  `userpass` varchar(32) NOT NULL COMMENT '登录密码',
  `role` int(11) NOT NULL COMMENT '用户的角色ID，外键',
  `locked` int(11) NOT NULL DEFAULT '1' COMMENT '用户是否被锁定：0-未锁定，1锁定',
  `faceimg` varchar(200) NOT NULL COMMENT '用户头像图片名',
  PRIMARY KEY (`userid`),
  KEY `userinfo_role` (`role`),
  CONSTRAINT `userinfo_role` FOREIGN KEY (`role`) REFERENCES `roleinfo` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '2', '2', '2', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('2', '1', '1', '1', '0', '/img/upload/e2044913-9bac-4773-ad7c-d1bff6958983.png');
INSERT INTO `userinfo` VALUES ('3', '3', '3', '3', '0', '/img/upload/4676fe68-b8ea-4191-a157-32d38d2a8582.png');
INSERT INTO `userinfo` VALUES ('4', '4', '4', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('6', '6', '6', '1', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('7', '7', '7', '2', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('8', '8', '8', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('11', '张三', 'a12345', '1', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('12', '王二麻子', 'a12345', '3', '1', '/img/upload/0b772986-d4e0-4585-9477-845d35486a80.png');
INSERT INTO `userinfo` VALUES ('14', '奥利戈啊', 'a123123', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('15', '顶顶顶', 'a12345', '1', '1', '/img/upload/2ffac10e-912d-4022-92e7-094b2a1953ba.png');
INSERT INTO `userinfo` VALUES ('16', '李四', 'a12345', '3', '1', '/img/upload/055928ec-5ded-460e-82d7-b02e2e8d61be.jpg');
INSERT INTO `userinfo` VALUES ('17', '王五', 'a12345', '3', '1', '/img/upload/d3eaf0e6-122e-4ada-93bd-789aa773cac1.png');
