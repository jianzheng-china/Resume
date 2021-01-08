/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : bysx

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2021-01-08 10:00:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(10) NOT NULL COMMENT '用户名',
  `job` varchar(30) DEFAULT NULL COMMENT '求职意向',
  `cellphone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `education` varchar(255) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '现居地',
  `eduDate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '受教育时间段',
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(20) DEFAULT NULL,
  `courseInfo` varchar(255) DEFAULT NULL COMMENT '主修课程',
  `skillInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作技能',
  `workExperience` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作经历',
  `selfEvaluation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址，如：a.jpg b.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '搬砖', '13312344321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('2', '李四', 'WEB开发工程师', '13312333321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('3', '王五', '扫大街', '13312366321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('4', '赵六', '和稀泥', '13312366321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('5', '赵七', '划水', '13312366321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('7', '赵九', '鉴黄师', '13312366321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('8', '赵十', '后端开发工程师', '13312366321', '大学本科', '13312344321@qq.com', '江苏省南京市玄武区', '2016.9-2020.6', '南京工业大学', '计算机科学与技术', '电路原理、模拟电子技术、数字逻辑、数值分析、计算机原理、微型计算机技术，计算机系 统结构、计算机网络、高级语言、汇编语言、数据结构、操作系统、数据库原理', '熟练掌握Html5、javasript、jquery、css3、Ajax、vue.js 等前端开发语言, 熟练使用git、webstom、postman、vscode等开发平台', '2020.01~至今广州XX信息技术有限公司Web前端开发工程师', '本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。', null);
INSERT INTO `user` VALUES ('11', '李武', '或水泥', '18851768950', '博士', 'liwu@163.com', '江苏北京', '2017.5-2020.2', '北工大', '水泥专业', '或水泥', '或水泥', '<p>水泥厂实习</p>\r\n\r\n<p>2020.01~至今广州XX信息技术有限公司Web前端开发工程师</p>\r\n\r\n<h3>工作内容:</h3>\r\n\r\n<ol>\r\n	<li>根据产品设计完成前端项目需求的开发和维护工作</li>\r\n</ol>\r\n', '<p>或水泥一级棒。本人勤奋踏实,工作认真负责,自学能力强;性格开朗,容易与人相处,注重团队协作精神,且能承受较大压力。注重专业基础学习和实践能力的培养,在校期间不仅做过多个课程设计暑假期间也去过单位实践 过,对web前端开发具有浓厚的兴趣。</p>\r\n', null);
INSERT INTO `user` VALUES ('14', '仇千尺', '挖掘机司机', '18851768950', '高级技工', 'chouqian@163.com', '中原华山', '2020.9-2021.9', '蓝翔', '水泥专业', '挖掘机', '人机合一', '<p>北极工作一年</p>\r\n', '<p>一级棒</p>\r\n', '13b09e152db3499b9f7e2a03c76bf50felephant');
INSERT INTO `user` VALUES ('15', '小刘', '挖掘机司机', '13351768950', '高级技工', 'xiaozhang@163.com', '中原华山', '2018.9-2021.9', '蓝翔', '挖掘机', '挖掘机', '人机合一', '<p>2010.9-2020.8：翔蓝大赛，第一名</p>\r\n', '<p>超级棒，棒棒哒</p>\r\n', '54f49628e84d446fb83e5f48a3042b95dog');
INSERT INTO `user` VALUES ('16', '田中大', '看地势', '13588889999', '小学', '13355@163.com', '中原华山', '2018.9-2021.9', '茅山', '看地势', '风水', '寻龙探穴', '<p>2008.9-2020.10：看风水十年</p>\r\n', '<p>低调低调</p>\r\n', '2f2f7733096e42c9bf442639c9d89d89worf');
INSERT INTO `user` VALUES ('18', '田中二', '看风水', '13588889999', '小学', '13355@163.com', '中原华山', '2018.9-2021.9', '茅山', '风水师', '风水', '寻龙探穴', '<p>2008.9-2020.10：看风水十年</p>\r\n', '<p>低调低调</p>\r\n', '2f2f7733096e42c9bf442639c9d89d89worf');
