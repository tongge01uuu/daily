

DROP TABLE IF EXISTS `cc_dictionary`;
CREATE TABLE `cc_dictionary` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pid` INT(11) NOT NULL COMMENT '为0时属于类别',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `order_weight` INT(11) DEFAULT NULL COMMENT '排序',
  `type` INT(11) DEFAULT NULL COMMENT '类型 (备用)',
  `description` VARCHAR(200) DEFAULT NULL COMMENT '描述',
  `access` INT (5) DEFAULT 0 COMMENT '开关 0-失效 1-生效',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='字典';
INSERT INTO `cc_dictionary`(`id`,`pid`,`name`,`order_weight`,`type`,description,access) VALUES (1,0,'流程节点', '0', '0', '流程节点类',1);
INSERT INTO `cc_dictionary`(`id`,`pid`,`name`,`order_weight`,`type`,description,access) VALUES (2,1,'短信验证', '0', '0', '流程节点-元素',1);
INSERT INTO `cc_dictionary`(`id`,`pid`,`name`,`order_weight`,`type`,description,access) VALUES (3,1,'绑卡', '1', '0', '流程节点-元素',1);
INSERT INTO `cc_dictionary`(`id`,`pid`,`name`,`order_weight`,`type`,description,access) VALUES (4,1,'充值', '2', '0', '流程节点-元素',1);


DROP TABLE IF EXISTS `cc_user_flow_state`;
CREATE TABLE `cc_user_flow_state` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `real_name` VARCHAR (32) DEFAULT NULL  COMMENT '真实姓名',
  `mobile`  VARCHAR (32) DEFAULT NULL  COMMENT '手机号',
  `state_input` VARCHAR (512) DEFAULT NULL  COMMENT '民生回调返回数据',
  `order_id` VARCHAR (64) DEFAULT NULL  COMMENT 'order_id',
  `flow_id` INT(11) DEFAULT NULL COMMENT '流程节点id',
  `flow_status` INT(11) DEFAULT NULL COMMENT '流程节点状态 0-未完成 1-已完成',
  `handle_state` INT(11) DEFAULT 0 COMMENT '客服处理状态 0-未处理 1-处理中 2-已回访',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户流程状态';

INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('111', '1', '1', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('111', '2', '0', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('111', '3', '0', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('112', '1', '0', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('113', '1', '0', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('114', '1', '0', '0');
INSERT INTO `cc_user_flow_state`(`user_id`,`flow_id`,`flow_status`,handle_state) VALUES ('115', '1', '0', '0');



DROP TABLE IF EXISTS `cc_user_flow_count`;
CREATE TABLE `cc_user_flow_count` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `flow_id` INT(11) DEFAULT NULL COMMENT '流程节点id',
  `flow_status` INT(11) DEFAULT NULL COMMENT '流程节点状态',
  `user_count` INT(11) DEFAULT NULL COMMENT '人数',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户流程状态统计';


DROP TABLE IF EXISTS `cc_work_sheet`;
CREATE TABLE `cc_work_sheet` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `state_id` INT(11) NOT NULL1
  `description` VARCHAR(400) DEFAULT NULL COMMENT '描述',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='工作记录表';







