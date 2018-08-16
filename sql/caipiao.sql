DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `rid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  KEY `fk_ur_uid_idx` (`uid`),
  KEY `fk_ur_rid_idx` (`rid`),
  CONSTRAINT `fk_ur_rid` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`rid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_ur_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `pid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  KEY `fk_rp_rid_idx` (`rid`),
  KEY `fk_rp_pid_idx` (`pid`),
  CONSTRAINT `fk_rp_pid` FOREIGN KEY (`pid`) REFERENCES `sys_permission` (`pid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_rp_rid` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`rid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'admin','7f034c75e3cc0e7bd00b5a3344c5af5a','d3c59d25033dbf980d29554025c23a75','管理员',0);
UNLOCK TABLES;


LOCK TABLES `sys_role` WRITE;
INSERT INTO `sys_role` VALUES (1,0,'管理员','admin'),(2,0,'vip会员','vip'),(3,1,'测试','test');
UNLOCK TABLES;


LOCK TABLES `sys_permission` WRITE;
INSERT INTO `sys_permission` VALUES (1,0,'用户管理',0,'0/','user:view','menu','user/list'),(2,0,'用户添加',1,'0/1','user:add','button','user/add'),(3,0,'用户删除',1,'0/1','user:del','button','user/del');
UNLOCK TABLES;


LOCK TABLES `sys_user_role` WRITE;
INSERT INTO `sys_user_role` VALUES (1,1);
UNLOCK TABLES;


LOCK TABLES `sys_role_permission` WRITE;
INSERT INTO `sys_role_permission` VALUES (1,1),(2,1),(3,2);
UNLOCK TABLES;







