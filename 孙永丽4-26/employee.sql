/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - employee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `employee`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Dname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `department` */

insert  into `department`(`id`,`Dname`,`userid`) values (1,'开发部',2),(2,'后勤部',10),(3,'开发部',3),(4,'安保部',4),(5,'运营部',11),(6,'客服部',12),(7,'运营部',8),(8,'开发部',7),(9,'客服部',9),(10,'系统管理',1);

/*Table structure for table `flowers` */

DROP TABLE IF EXISTS `flowers`;

CREATE TABLE `flowers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flowername` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `flowers` */

insert  into `flowers`(`id`,`flowername`) values (1,'棉花'),(2,'梅花'),(3,'迎春'),(4,'琼花'),(5,'海棠'),(6,'风信子'),(7,'金鱼草'),(8,'仙客来'),(9,'锦带花'),(10,'报春花');

/*Table structure for table `ls_menu` */

DROP TABLE IF EXISTS `ls_menu`;

CREATE TABLE `ls_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限名',
  `parentid` int(11) NOT NULL COMMENT '父类ID',
  `type` int(11) NOT NULL COMMENT '级别',
  `mbtn` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT 'button按钮',
  `mfunction` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '方法',
  `isdelete` int(11) unsigned DEFAULT NULL,
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ls_menu` */

insert  into `ls_menu`(`id`,`mname`,`parentid`,`type`,`mbtn`,`mfunction`,`isdelete`,`url`) values (1,'系统管理权限',0,1,'系统权限菜单','system',0,NULL),(2,'用户管理',1,2,'<li><a href=\"UserSelectServlet\">用户管理</a></li>',NULL,0,'Control'),(3,'账单管理',12,2,'<li><a href=\"BillSelectServlet\">账单管理</a></li>',NULL,0,NULL),(5,'ljhj',1,2,'ada',NULL,0,NULL),(6,'退出系统',12,2,'<li><a href=\"index.jsp\">退出系统</a></li>',NULL,0,NULL),(7,'权限管理',1,2,'<li><a href=\"quan?userid=1\">权限管理</a></li>',NULL,0,'Jurisdiction'),(8,'新增权限',7,3,'<button type=\"button\" lay-event=\"btn-add\" class=\"layui-btn layui-btn-greed\">新增权限<button>',NULL,0,NULL),(9,'删除权限',7,3,'<button type=\"button\" lay-event=\"btn-delete\" class=\"layui-btn layui-btn-danger\">删除权限<button>',NULL,0,NULL),(10,'修改权限',7,3,'<button type=\"button\" lay-event=\"btn-update\" class=\"layui-btn layui-btn-warm\">修改权限<button>',NULL,0,NULL),(11,'全部展开',12,3,'<button type=\"button\" lay-event=\"btn-expand\" class=\"layui-btn layui-border-green\">全部展开<button>',NULL,0,NULL),(12,'全部折叠',12,3,'<button type=\"button\" lay-event=\"btn-fold\" class=\"layui-btn layui-border-green\">全部折叠<button>',NULL,0,NULL),(16,'角色管理',1,2,'ad','',0,'RoleType'),(21,'修改用户',2,3,'<button type=\"button\" lay-event=\"user-update\" class=\"layui-btn layui-btn-warm\">修改用户<button>',NULL,0,NULL),(23,'新增用户',2,3,'<button type=\"button\" lay-event=\"user-insert\" class=\"layui-btn layui-btn-warm\">新增用户<button>',NULL,0,NULL),(24,'删除用户',2,3,'<button type=\"button\" lay-event=\"user-delete\" class=\"layui-btn layui-btn-warm\">删除用户<button>',NULL,0,NULL),(25,'Flowers',1,2,'<li><a href=\"FlowerSelectServlet\">Flowers</a></li>',NULL,NULL,'Flower');

/*Table structure for table `rs_menu` */

DROP TABLE IF EXISTS `rs_menu`;

CREATE TABLE `rs_menu` (
  `userid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rs_menu` */

insert  into `rs_menu`(`userid`,`menuid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,3),(2,5),(1,8),(1,9),(1,10),(1,7),(1,16),(1,21),(1,22),(1,23),(1,24),(1,25);

/*Table structure for table `smbms_role` */

DROP TABLE IF EXISTS `smbms_role`;

CREATE TABLE `smbms_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `smbms_role` */

insert  into `smbms_role`(`id`,`roleCode`,`roleName`) values (1,'SMBMS_ADMIN','系统管理员'),(2,'SMBMS_MANAGER','经理'),(3,'SMBMS_EMPLOYEE','普通员工');

/*Table structure for table `smbms_user` */

DROP TABLE IF EXISTS `smbms_user`;

CREATE TABLE `smbms_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userRole` int(10) DEFAULT NULL COMMENT '用户角色（取自角色表-角色id）',
  `Did` int(11) DEFAULT '1' COMMENT '部门ID',
  `Tid` int(11) DEFAULT '1' COMMENT '职称id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `smbms_user` */

insert  into `smbms_user`(`id`,`userCode`,`userName`,`userPassword`,`phone`,`address`,`userRole`,`Did`,`Tid`) values (1,'admin','系统管理员','123','13688889999','北京市海淀区成府路207号',1,10,10),(2,'liming','李明','123456','13688884457','北京市东城区前门东大街9号',3,1,1),(5,'hanlubiao','韩路彪','0000000','18567542321','北京市朝阳区北辰中心12号',2,2,2),(6,'zhanghua','张华','0000000','13544561111','北京市海淀区学院路61号',3,3,3),(7,'wangyang','王洋','0000000','13444561124','北京市海淀区西二旗辉煌国际16层',3,4,4),(8,'zhaoyan','赵燕','0000000','18098764545','北京市海淀区回龙观小区10号楼',3,5,5),(10,'sunlei','孙磊','0000000','13387676765','北京市朝阳区管庄新月小区12楼',3,6,6),(11,'sunxing','孙兴','0000000','13367890900','北京市朝阳区建国门南大街10号',3,7,7),(12,'zhangchen','张晨','0000000','0000000000','朝阳区管庄路口北柏林爱乐三期13号楼',3,8,8),(17,'lisanshi','续期','123456','13620968458','sichuan',2,9,9),(18,'san','续期','123456','13620968458','安徽合肥',2,1,1),(19,'1','1','1','1','1',3,1,1),(20,'ee','ee','123456','333','ee',3,1,1),(22,'yy','yy6','123456','66666666','yyy',3,1,1),(23,'qq1','qq','123456','111111','qq',2,1,1),(24,'rr','rr','123456','54345','rrr',3,1,1),(25,'pppp','lloo','123456','199999999','ooooooooo',3,1,1),(26,'iii','ii','123456','88888888888','iiii',3,1,1),(27,'ss','sss','123456','1111','sss',3,1,1),(30,'zzzzzzz','ddddd','123456','11111111','ddddd',3,1,1);

/*Table structure for table `title` */

DROP TABLE IF EXISTS `title`;

CREATE TABLE `title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `title` */

insert  into `title`(`id`,`Tname`,`userid`) values (1,'菜鸟工程师A',2),(2,'菜鸟工程师B',3),(3,'保安A',4),(4,'运营官A',8),(5,'运营官B',11),(6,'菜鸟工程师C',7),(7,'客服A',12),(8,'客服B',9),(9,'后勤A',10),(10,'系统管理',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
