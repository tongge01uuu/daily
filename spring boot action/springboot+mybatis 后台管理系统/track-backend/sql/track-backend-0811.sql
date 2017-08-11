/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.20-log : Database - renrendai_0513
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`renrendai_0513` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `renrendai_0513`;

/*Table structure for table `cc_resource` */

DROP TABLE IF EXISTS `cc_resource`;

CREATE TABLE `cc_resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_parentId` int(11) DEFAULT NULL,
  `res_name` varchar(50) NOT NULL,
  `res_status` int(11) DEFAULT NULL,
  `res_model_code` varchar(30) DEFAULT NULL COMMENT '模块标识',
  `res_link_address` varchar(200) DEFAULT NULL,
  `res_image` varchar(100) DEFAULT NULL,
  `res_type` int(11) DEFAULT NULL,
  `res_display_order` int(11) DEFAULT NULL,
  `res_remark` varchar(200) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `cc_resource` */

insert  into `cc_resource`(`res_id`,`res_parentId`,`res_name`,`res_status`,`res_model_code`,`res_link_address`,`res_image`,`res_type`,`res_display_order`,`res_remark`,`creator`,`create_time`,`modifier`,`modify_time`) values (2,5,'用户管理',0,'7JMoS6yG','/user/user_list.do','larry-10103',2,2,'配置系统用户信息','admin','2016-11-25 16:57:22','admin','2017-07-28 22:52:22'),(3,5,'角色管理',0,'SPAn6H46','/role/role_list.do','larry-jiaoseguanli1',2,3,'配置系统角色信息','admin','2016-11-25 16:57:25',NULL,'2017-08-11 18:53:09'),(4,5,'菜单管理',0,'0rbT8g7m','/res/res_list.do','larry-caidanguanli',2,4,'配置系统菜单信息','admin','2016-11-25 16:57:31','admin','2016-12-14 16:01:09'),(5,7,'系统设置',0,'0rbT8g9m',NULL,'larry-xitongshezhi1',1,5,'配置系统菜单信息','admin','2017-07-28 09:31:43',NULL,'2017-08-11 18:53:09'),(7,0,'系统管理',0,'0rbT8g8m',NULL,'larry-xitongshezhi1',0,6,'配置系统菜单信息','admin','2017-07-28 13:24:57',NULL,'2017-08-11 18:53:09'),(8,0,'微信公众',0,'0rbT8g6m',NULL,'larry-weixingongzhongpingtai',0,7,'配置系统菜单信息','admin','2017-07-28 13:26:50',NULL,'2017-08-11 18:53:10'),(9,7,'我的面板',0,'0rbT8g2m',NULL,'larry-gerenxinxi5',1,8,'配置系统菜单信息','admin','2017-07-28 14:23:35',NULL,'2017-08-11 18:53:10'),(10,9,'个人信息',0,'0rbT8t2m',NULL,'larry-gerenxinxi1',2,9,'配置系统菜单信息','admin','2017-07-28 17:07:55',NULL,'2017-08-11 18:53:10');

/*Table structure for table `cc_role` */

DROP TABLE IF EXISTS `cc_role`;

CREATE TABLE `cc_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_status` int(11) NOT NULL,
  `role_remark` varchar(255) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `cc_role` */

insert  into `cc_role`(`role_id`,`role_name`,`role_status`,`role_remark`,`creator`,`create_time`,`modifier`,`modifier_time`) values (4,'超级管理员',0,'最高角色','admin','2017-07-24 17:37:08','admin','2017-07-28 22:54:54'),(5,'客服',0,'','admin','2017-08-09 16:21:45','admin','2017-08-10 15:09:17'),(6,'客户经理',0,'','admin','2017-08-09 16:31:22',NULL,NULL);

/*Table structure for table `cc_role_resource` */

DROP TABLE IF EXISTS `cc_role_resource`;

CREATE TABLE `cc_role_resource` (
  `role_res_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `resource_ids` varchar(40) DEFAULT NULL COMMENT '逗号分隔的resource_id',
  `creator` varchar(40) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '5.6.5+有效',
  PRIMARY KEY (`role_res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与资源关系表';

/*Data for the table `cc_role_resource` */

/*Table structure for table `cc_user` */

DROP TABLE IF EXISTS `cc_user`;

CREATE TABLE `cc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login_name` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_status` bigint(20) NOT NULL,
  `creator` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `cc_user` */

insert  into `cc_user`(`user_id`,`user_login_name`,`user_name`,`user_password`,`user_status`,`creator`,`create_time`,`modifier`,`update_time`) values (8,'admin','超级管理员','123456',0,'admin','2017-07-14 11:31:52','admin','2017-07-24 00:01:30'),(9,'GS001','甘肃001','123456',1,'admin','2016-12-07 21:38:06','admin','2016-12-08 21:18:01'),(10,'GS002','甘肃002','123456',0,'admin','2016-12-07 21:38:27',NULL,NULL),(11,'GS003','甘肃003','123456',0,'admin','2016-12-07 21:38:45',NULL,NULL),(12,'SH001','上海001','123456',0,'admin','2016-12-07 22:47:59',NULL,NULL),(13,'SH002','上海002','123456',0,'admin','2016-12-07 22:50:15',NULL,NULL),(14,'HZ001','杭州001','123456',0,'admin','2016-12-07 22:51:02',NULL,NULL),(15,'HZ002','杭州002','123456',0,'admin','2016-12-07 22:51:16','admin','2017-07-27 17:23:37'),(16,'ZJ001','浙江001','123456',0,'admin','2016-12-07 22:51:30',NULL,NULL),(17,'ZJ002','浙江002','123456',0,'admin','2016-12-07 22:51:49','admin','2017-07-24 09:30:45'),(19,'test','测试账号','123456',0,'admin','2017-07-23 23:09:43','admin','2017-08-09 16:30:48'),(20,'test297','测试账号','123456',1,'admin','2017-07-27 01:21:07','admin','2017-08-09 18:11:37');

/*Table structure for table `cc_user_role` */

DROP TABLE IF EXISTS `cc_user_role`;

CREATE TABLE `cc_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modifier_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';

/*Data for the table `cc_user_role` */

insert  into `cc_user_role`(`user_role_id`,`user_id`,`role_id`,`creator`,`create_time`,`modifier`,`modifier_time`) values (2,19,5,'admin','2017-08-10 11:18:15',NULL,NULL),(3,19,4,'admin','2017-08-10 11:18:15',NULL,NULL);

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `e_loan_material_count` */

/*!50106 DROP EVENT IF EXISTS `e_loan_material_count`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `e_loan_material_count` ON SCHEDULE EVERY 60 SECOND STARTS '2015-01-22 11:02:06' ON COMPLETION PRESERVE DISABLE ON SLAVE DO BEGIN
	    CALL proc_loan_material_count();
	END */$$
DELIMITER ;

/* Procedure structure for procedure `add_timer` */

/*!50003 DROP PROCEDURE IF EXISTS  `add_timer` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`36.110.112.98` PROCEDURE `add_timer`()
BEGIN
	DECLARE timer_id INT(11);
	
	delete from task_timer where task_class='syncNewFundStatusAndVersionJob';
	
	INSERT INTO `task_timer` ( `task_name`, `task_class`, `task_status`, `is_timing`, `enable`, `server_ip`, `version`, `task_desc`, `creater`, `create_time`) 
	VALUES('同步代销基金为展示状态及版本号','syncNewFundStatusAndVersionJob','RUNNING','0','1',NULL,'master','同步过去一周无版本号代销基金为前台展示及版本号','lanyanxiang',NOW());
	SELECT `id` INTO timer_id FROM task_timer WHERE task_class='syncNewFundStatusAndVersionJob';
	
	INSERT INTO `task_timer_param` ( `task_id`, `param_key`, `param_value`, `display_name`, `task_param_desc`, `creater`, `create_time`) 
	VALUES(timer_id,'intervalDate','604800000','每周定时任务syncNewFundStatusAndVersionJob','SyncNewFundStatusAndVersionJob','lanyanxiang',NOW());
    END */$$
DELIMITER ;

/* Procedure structure for procedure `proc_loan_material_count` */

/*!50003 DROP PROCEDURE IF EXISTS  `proc_loan_material_count` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_loan_material_count`()
LABEL_PROC:
BEGIN
  DECLARE v_cnt INT;
  DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
  START TRANSACTION;
  TRUNCATE TABLE tnt_loan_material_count;
  SELECT COUNT(*) INTO v_cnt FROM tnt_loan_material_count;
  IF v_cnt=0 THEN
         INSERT INTO tnt_loan_material_count(userId,typeCount)
		     SELECT      t_m_count.borrower AS borrower,COUNT(t_m_count.borrower) AS typeCount 
				 FROM
					(SELECT 
						t_material_batch_inner.userId AS borrower 
					 FROM
						loan AS t_loan_inner,
						T_MaterialBatch AS t_material_batch_inner 
					 WHERE t_loan_inner.borrower = t_material_batch_inner.userId 
						AND t_material_batch_inner.status != 1 
						AND t_material_batch_inner.type IN (0, 1, 3, 19) 
						AND t_loan_inner.status = 7 
					 GROUP BY t_material_batch_inner.userId,
						t_material_batch_inner.type) AS t_m_count 
				 GROUP BY t_m_count.borrower;
  ELSE
         ROLLBACK;
         INSERT INTO tnt_error_log(proc_name,error,date_time) VALUES ('proc_loan_material_count','truncate is failure!',NOW());
         LEAVE LABEL_PROC;
  END IF;
  COMMIT;
END LABEL_PROC */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
