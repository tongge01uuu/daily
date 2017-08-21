

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cc_resource
-- ----------------------------
DROP TABLE IF EXISTS `cc_resource`;
CREATE TABLE `cc_resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_parentId` int(11) DEFAULT NULL,
  `res_name` varchar(50) NOT NULL,
  `res_status` int(11) DEFAULT NULL,
  `res_model_code` varchar(30) DEFAULT NULL COMMENT '模块标识(暂时无用)',
  `res_link_address` varchar(200) DEFAULT NULL,
  `res_image` varchar(100) DEFAULT NULL,
  `res_type` int(11) DEFAULT NULL,
  `res_display_order` int(11) DEFAULT NULL,
  `res_remark` varchar(200) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of cc_resource
-- ----------------------------
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('2','5','用户管理','0','7JMoS6yG','/user/user_list.do','larry-10103','2','2','配置系统用户信息','admin','2016-11-25 16:57:22','admin','2017-07-28 22:52:22');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('3','5','角色管理','0','SPAn6H46','/role/role_list.do','larry-jiaoseguanli1','2','3','配置系统角色信息','admin','2016-11-25 16:57:25',NULL,'2017-08-11 18:53:09');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('4','5','菜单管理','0','0rbT8g7m','/res/res_list.do','larry-caidanguanli','2','4','配置系统菜单信息','admin','2016-11-25 16:57:31','admin','2016-12-14 16:01:09');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('5','7','系统设置','0','0rbT8g9m',NULL,'larry-xitongshezhi1','1','5','配置系统菜单信息','admin','2017-07-28 09:31:43',NULL,'2017-08-11 18:53:09');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('7','0','系统管理','0','0rbT8g8m',NULL,'larry-xitongshezhi1','0','6','配置系统菜单信息','admin','2017-07-28 13:24:57',NULL,'2017-08-11 18:53:09');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('8','0','微信公众','0','0rbT8g6m',NULL,'larry-weixingongzhongpingtai','0','7','配置系统菜单信息','admin','2017-07-28 13:26:50',NULL,'2017-08-11 18:53:10');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('9','7','我的面板','0','0rbT8g2m',NULL,'larry-gerenxinxi5','1','8','配置系统菜单信息','admin','2017-07-28 14:23:35',NULL,'2017-08-11 18:53:10');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('10','9','个人信息','0','0rbT8t2m','/user/user_info.do','larry-gerenxinxi1','2','9','配置系统菜单信息','admin','2017-07-28 17:07:55',NULL,'2017-08-11 19:20:38');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('11','0','test','0',NULL,'222/6','tianjia6','2','5','',NULL,'2017-08-11 19:16:08',NULL,'2017-08-11 19:18:55');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('12','7','业务','0',NULL,'','larry-neirongguanli','1','3','用户维护',NULL,'2017-08-16 11:24:01',NULL,'2017-08-16 11:24:01');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('13','12','数据概览','0',NULL,'','xiugai3','2','1','各流程节点数据统计',NULL,'2017-08-16 11:25:34',NULL,'2017-08-16 11:25:34');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('14','12','数据明细','0',NULL,'','','2','2','用户流程节点名明细数据',NULL,'2017-08-16 11:26:57',NULL,'2017-08-16 11:26:57');
INSERT INTO `cc_resource` (`res_id`, `res_parentId`, `res_name`, `res_status`, `res_model_code`, `res_link_address`, `res_image`, `res_type`, `res_display_order`, `res_remark`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES('15','12','字典管理','0',NULL,'/dictionary/dic_list.do','zidian','2','3','',NULL,'2017-08-16 15:29:42',NULL,'2017-08-18 11:32:40');

-- ----------------------------
-- Table structure for cc_role
-- ----------------------------
DROP TABLE IF EXISTS `cc_role`;
CREATE TABLE `cc_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_status` int(11) NOT NULL,
  `role_remark` varchar(255) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of cc_role
-- ----------------------------
INSERT INTO `cc_role` VALUES ('4', '超级管理员', '0', '最高角色', 'admin', '2017-07-24 17:37:08', 'admin', '2017-07-28 22:54:54');

-- ----------------------------
-- Table structure for cc_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `cc_role_resource`;
CREATE TABLE `cc_role_resource` (
  `role_res_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_id` INT(11) DEFAULT NULL,
  `resource_ids` VARCHAR(40) DEFAULT NULL COMMENT '逗号分隔的resource_id',
  `creator` VARCHAR(40) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `modifier` VARCHAR(40) DEFAULT NULL,
  `modifier_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`role_res_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色与资源关系表';

-- ----------------------------
-- Records of cc_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for cc_user
-- ----------------------------
DROP TABLE IF EXISTS `cc_user`;
CREATE TABLE `cc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login_name` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_status` bigint(20) NOT NULL,
  `creator` varchar(50) NOT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `modifier` varchar(50) DEFAULT NULL,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cc_user
-- ----------------------------
INSERT INTO `cc_user` VALUES ('8', 'admin', '超级管理员', '123456', '0', 'admin', '2017-07-14 11:31:52', 'admin', '2017-07-24 00:01:30');
INSERT INTO `cc_user` VALUES ('9', 'GS001', '甘肃001', '123456', '1', 'admin', '2016-12-07 21:38:06', 'admin', '2016-12-08 21:18:01');
INSERT INTO `cc_user` VALUES ('10', 'GS002', '甘肃002', '123456', '0', 'admin', '2016-12-07 21:38:27', null, null);
INSERT INTO `cc_user` VALUES ('11', 'GS003', '甘肃003', '123456', '0', 'admin', '2016-12-07 21:38:45', null, null);
INSERT INTO `cc_user` VALUES ('12', 'SH001', '上海001', '123456', '0', 'admin', '2016-12-07 22:47:59', null, null);
INSERT INTO `cc_user` VALUES ('13', 'SH002', '上海002', '123456', '0', 'admin', '2016-12-07 22:50:15', null, null);
INSERT INTO `cc_user` VALUES ('14', 'HZ001', '杭州001', '123456', '0', 'admin', '2016-12-07 22:51:02', null, null);
INSERT INTO `cc_user` VALUES ('15', 'HZ002', '杭州002', '123456', '0', 'admin', '2016-12-07 22:51:16', 'admin', '2017-07-27 17:23:37');
INSERT INTO `cc_user` VALUES ('16', 'ZJ001', '浙江001', '123456', '0', 'admin', '2016-12-07 22:51:30', null, null);
INSERT INTO `cc_user` VALUES ('17', 'ZJ002', '浙江002', '123456', '0', 'admin', '2016-12-07 22:51:49', 'admin', '2017-07-24 09:30:45');
INSERT INTO `cc_user` VALUES ('19', 'test', '测试账号', '123456', '1', 'admin', '2017-07-23 23:09:43', 'admin', '2017-07-24 00:01:27');
INSERT INTO `cc_user` VALUES ('20', 'test2', '测试账号2', '123456', '0', 'admin', '2017-07-27 01:21:07', 'admin', '2017-07-30 18:16:49');

-- ----------------------------
-- Table structure for cc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cc_user_role`;
CREATE TABLE `cc_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';

-- ----------------------------
-- Records of cc_user_role
-- ----------------------------
