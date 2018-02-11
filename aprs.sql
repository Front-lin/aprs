# Host: localhost  (Version: 5.5.40)
# Date: 2018-02-02 23:46:17
# Generator: MySQL-Front 5.3  (Build 4.120)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(15) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(15) NOT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES ('lhl','123456');
