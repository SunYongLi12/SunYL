/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - a
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `a`;

/*Table structure for table `bm` */

DROP TABLE IF EXISTS `bm`;

CREATE TABLE `bm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `bm` */

insert  into `bm`(`id`,`branch`) values (1,'产品'),(2,'开发'),(3,'运维');

/*Table structure for table `btn` */

DROP TABLE IF EXISTS `btn`;

CREATE TABLE `btn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `button` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `btn` */

insert  into `btn`(`id`,`button`) values (1,'<button type=\"button\" lay-event=\"btn-add\" class=\"layui-btn layui-btn-greed\"><i class=\"layui-icon\">&#xe640;</i>新增</button>'),(2,'<button type=\"button\" lay-event=\"btn-delete\" class=\"layui-btn layui-btn-danger\"><i class=\"layui-icon\">&#xe640;</i>删除</button>'),(3,'<button type=\"button\" lay-event=\"btn-update\" class=\"layui-btn layui-btn-warm\"><i class=\"layui-icon\">&#xe640;</i>修改</button>'),(4,'<button type=\'button\' lay-event=\'shangFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\'layui-icon\'>&#xe681;</i>上传</button>'),(5,'<button type=\'button\' lay-event=\'xiaFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\"layui-icon\">&#xe601;</i>下载</button>'),(6,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*Table structure for table `js` */

DROP TABLE IF EXISTS `js`;

CREATE TABLE `js` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `js` */

insert  into `js`(`id`,`role`) values (1,'管理员'),(2,'员工');

/*Table structure for table `qx` */

DROP TABLE IF EXISTS `qx`;

CREATE TABLE `qx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `btn` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `js` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qx` */

insert  into `qx`(`id`,`qname`,`btn`,`fid`,`type`,`url`,`js`) values (1,'全部员工','员工信息',4,2,'http://localhost:8080/Exercise0425/Servlet?action=YG','YG.js'),(2,'权限管理','权限管理',4,2,'http://localhost:8080/Exercise0425/Servlet?action=QX','QX.js'),(3,'角色管理','角色管理',4,2,'http://localhost:8080/Exercise0425/Servlet?action=JS','JS.js'),(4,'xx','<div>XX</div>',0,1,NULL,NULL),(5,'增','<button type=\"button\" lay-event=\"btn-add\" class=\"layui-btn layui-btn-greed\">新增</button>',1,3,NULL,NULL),(6,'删','<button type=\"button\" lay-event=\"btn-delete\" class=\"layui-btn layui-btn-danger\">删除</button>',1,3,NULL,NULL),(7,'改','<button type=\"button\" lay-event=\"btn-update\" class=\"layui-btn layui-btn-warm\">修改</button>',1,3,NULL,NULL),(8,'分','<button type=\"button\" lay-event=\"fenFunc\" class=\"layui-btn layui-btn-primary xz\">分配</button>',3,3,NULL,NULL),(9,'增','<button type=\"button\" lay-event=\"btn-add\" class=\"layui-btn layui-btn-greed\">新增</button>',2,3,NULL,NULL),(10,'删','<button type=\"button\" lay-event=\"btn-delete\" class=\"layui-btn layui-btn-danger\">删除</button>',2,3,NULL,NULL),(11,'改','<button type=\"button\" lay-event=\"btn-update\" class=\"layui-btn layui-btn-warm\">修改</button>',2,3,NULL,NULL);

/*Table structure for table `qxjs` */

DROP TABLE IF EXISTS `qxjs`;

CREATE TABLE `qxjs` (
  `qxid` int(11) NOT NULL,
  `jsid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qxjs` */

insert  into `qxjs`(`qxid`,`jsid`) values (1,1),(2,1),(3,1),(2,1),(3,2),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1);

/*Table structure for table `yg` */

DROP TABLE IF EXISTS `yg`;

CREATE TABLE `yg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `jsid` int(11) NOT NULL,
  `bmid` int(11) NOT NULL,
  `zcid` int(11) NOT NULL,
  `pwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `yg` */

insert  into `yg`(`id`,`name`,`sex`,`jsid`,`bmid`,`zcid`,`pwd`) values (1,'zs',1,1,2,1,'123'),(2,'lisi',2,2,1,2,'123'),(3,'ww',2,1,2,2,'123'),(4,'zl',1,2,3,2,'123'),(6,'add',2,2,1,1,'123');

/*Table structure for table `zc` */

DROP TABLE IF EXISTS `zc`;

CREATE TABLE `zc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ygid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zc` */

insert  into `zc`(`id`,`rank`,`ygid`) values (1,'组长',1),(2,'员工',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
