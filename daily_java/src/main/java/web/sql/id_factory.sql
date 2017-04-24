CREATE TABLE `id_factory` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `biz_tag` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '业务标签',
  `max_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '已分配最大id',
  `step` int(11) NOT NULL COMMENT 'ID步长',
  `desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;