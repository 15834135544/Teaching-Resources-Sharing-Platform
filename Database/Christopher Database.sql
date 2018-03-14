/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 5.6.24 : Database - christopher
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`christopher` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `christopher`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

/*Table structure for table `administrator_course` */

DROP TABLE IF EXISTS `administrator_course`;

CREATE TABLE `administrator_course` (
  `aid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`aid`,`cid`),
  KEY `FK6F2FEA0D43F5AA49` (`cid`),
  KEY `FK6F2FEA0D739F7499` (`aid`),
  CONSTRAINT `FK6F2FEA0D43F5AA49` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK6F2FEA0D739F7499` FOREIGN KEY (`aid`) REFERENCES `administrator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrator_course` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `period` double DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`),
  KEY `FK78A7CC3BC0650AF5` (`fid`),
  CONSTRAINT `FK78A7CC3BC0650AF5` FOREIGN KEY (`fid`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`id`,`course_id`,`course_name`,`credit`,`semester`,`period`,`introduction`,`image`,`fid`) values (1,'jlau1','计算机组成原理',NULL,'2017-2018第一学期',NULL,'国家级精品课程',NULL,1),(2,'jlau2','物联网导论',NULL,'2017-2018第一学期',NULL,'无纸化教育精品课程',NULL,2),(3,'jlau3','计算机基础实验',NULL,'2017-2018第一学期',NULL,'模范教师精品课程',NULL,3),(4,'jlau4','C++程序设计',NULL,'2017-2018第一学期',NULL,'全国慕课大赛一等奖',NULL,4),(5,'jlau5','java程序设计',NULL,'2017-2018第一学期',NULL,'全国微课大赛一等奖',NULL,5),(6,'jlau6','RFID射频识别',NULL,'2017-2018第一学期',NULL,'国家级精品实验课程',NULL,6),(7,'jlau7','数据库原理',NULL,'2017-2018第一学期',NULL,'国家级精品课程',NULL,7),(8,'jlau8','Python网络编程',NULL,'2017-2018第一学期',NULL,'无纸化教育精品课程',NULL,8),(9,'jlau9','C#程序设计',NULL,'2017-2018第一学期',NULL,'全国微课大赛一等奖',NULL,9),(10,'jlau10','短距无线通信原理',NULL,'2017-2018第一学期',NULL,'模范教师精品课程',NULL,10),(11,'jlau11','ARM嵌入式开发',NULL,'2017-2018第一学期',NULL,'国家级精品实验课程',NULL,11),(12,'jlau12','数据结构',NULL,'2017-2018第一学期',NULL,'全国微课大赛一等奖',NULL,12),(13,'jlau13','操作系统',NULL,'2017-2018第一学期',NULL,'国家级精品课程',NULL,13),(14,'jlau14','农业信息化',NULL,'2017-2018第一学期',NULL,'星火计划精品课程',NULL,14),(15,'jlau15','数据挖掘',NULL,'2017-2018第一学期',NULL,'模范教师精品课程',NULL,15),(16,'jlau16','计算机网络',NULL,'2017-2018第一学期',NULL,'全国微课大赛一等奖',NULL,16),(17,'jlau17','UI前端开发',NULL,'2017-2018第一学期',NULL,'国家级精品课程',NULL,17);

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `document_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3737353BD68D958B` (`uid`),
  KEY `FK3737353B43F5AA49` (`cid`),
  CONSTRAINT `FK3737353B43F5AA49` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK3737353BD68D958B` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `document` */

insert  into `document`(`id`,`document_name`,`url`,`update_time`,`cid`,`uid`,`image`,`type`) values (1,'数据的机器层次表示.ppt','http://192.168.1.104:8181/Christopher/document/1.ppt','2017-04-20 19:04:29',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(2,'指令系统.ppt','http://192.168.1.104:8181/Christopher/document/2.ppt','2017-04-21 10:05:20',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(3,'数值的机器运算.ppt','http://192.168.1.104:8181/Christopher/document/3.ppt','2017-04-22 09:32:03',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(4,'存储系统和结构.ppt','http://192.168.1.104:8181/Christopher/document/4.ppt','2017-04-23 10:06:44',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(5,'中央处理器.ppt','http://192.168.1.104:8181/Christopher/document/5.ppt','2017-04-24 20:08:00',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(6,'外部设备.ppt','http://192.168.1.104:8181/Christopher/document/6.ppt','2017-04-25 16:08:28',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt'),(7,'输入输出系统.ppt','http://192.168.1.104:8181/Christopher/document/7.ppt','2017-04-26 22:09:15',1,1,'http://192.168.1.104:8181/Christopher/pic/documentpic/ppt.jpg','.ppt');

/*Table structure for table `document_user` */

DROP TABLE IF EXISTS `document_user`;

CREATE TABLE `document_user` (
  `did` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`did`,`uid`),
  KEY `FK8E12F06FD68D958B` (`uid`),
  KEY `FK8E12F06F60E3030A` (`did`),
  CONSTRAINT `FK8E12F06F60E3030A` FOREIGN KEY (`did`) REFERENCES `document` (`id`),
  CONSTRAINT `FK8E12F06FD68D958B` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `document_user` */

/*Table structure for table `faculty` */

DROP TABLE IF EXISTS `faculty`;

CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_id` varchar(255) DEFAULT NULL,
  `faculty_name` varchar(255) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `faculty_id` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `faculty` */

insert  into `faculty`(`id`,`faculty_id`,`faculty_name`,`institution`,`title`,`position`,`introduction`,`image`) values (1,'jlau1','邓蕾蕾',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/1.jpg'),(2,'jlau2','于合龙',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/2.jpg'),(3,'jlau3','刘鹤',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/3.jpg'),(4,'jlau4','曹丽英',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/4.jpg'),(5,'jlau5','李东明',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/5.jpg'),(6,'jlau6','陈霄',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/6.jpg'),(7,'jlau7','毕春光',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/7.jpg'),(8,'jlau8','郭宏亮',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/8.jpg'),(9,'jlau9','韩永奇',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/9.jpg'),(10,'jlau10','徐兴梅',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/10.jpg'),(11,'jlau11','王明泉',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/11.jpg'),(12,'jlau12','司秀丽',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/12.jpg'),(13,'jlau13','王越',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/13.jpg'),(14,'jlau14','陈桂芬',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/14.jpg'),(15,'jlau15','张莹',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/15.jpg'),(16,'jlau16','马丽',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/16.jpg'),(17,'jlau17','林楠',NULL,NULL,NULL,NULL,'http://192.168.1.104:8181/Christopher/pic/facultypic/17.jpg');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`student_id`,`student_name`,`institution`,`title`,`position`) values (1,'jlau1','张达',NULL,NULL,NULL);

/*Table structure for table `student_course` */

DROP TABLE IF EXISTS `student_course`;

CREATE TABLE `student_course` (
  `cid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`cid`),
  KEY `FK3E4F2ADF91782399` (`sid`),
  KEY `FK3E4F2ADF43F5AA49` (`cid`),
  CONSTRAINT `FK3E4F2ADF43F5AA49` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK3E4F2ADF91782399` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student_course` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `encryptedPwd` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `aid` (`aid`),
  UNIQUE KEY `fid` (`fid`),
  UNIQUE KEY `sid` (`sid`),
  KEY `FK285FEBC0650AF5` (`fid`),
  KEY `FK285FEB91782399` (`sid`),
  KEY `FK285FEB739F7499` (`aid`),
  CONSTRAINT `FK285FEB739F7499` FOREIGN KEY (`aid`) REFERENCES `administrator` (`id`),
  CONSTRAINT `FK285FEB91782399` FOREIGN KEY (`sid`) REFERENCES `student` (`id`),
  CONSTRAINT `FK285FEBC0650AF5` FOREIGN KEY (`fid`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_id`,`user_name`,`pwd`,`encryptedPwd`,`avatar`,`birthday`,`gender`,`email`,`phone`,`fax`,`address`,`zip_code`,`country`,`nationality`,`id_card`,`aid`,`fid`,`sid`) values (1,'dengleilei@163.com','dengleilei','123456','49ba59abbe56e057',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(2,'zhangda@163.com','zhangda','123456','49ba59abbe56e057',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);

/*Table structure for table `user_course` */

DROP TABLE IF EXISTS `user_course`;

CREATE TABLE `user_course` (
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`cid`),
  KEY `FK84ABB0FD68D958B` (`uid`),
  KEY `FK84ABB0F43F5AA49` (`cid`),
  CONSTRAINT `FK84ABB0F43F5AA49` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK84ABB0FD68D958B` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_course` */

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ED245BD68D958B` (`uid`),
  KEY `FK4ED245B43F5AA49` (`cid`),
  CONSTRAINT `FK4ED245B43F5AA49` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK4ED245BD68D958B` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `video` */

insert  into `video`(`id`,`video_name`,`url`,`update_time`,`cid`,`uid`,`image`,`type`) values (1,'数据的机器层次表示.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-20 02:12:19',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(2,'指令系统.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-21 02:12:30',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(3,'数值的机器运算.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-22 02:12:55',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(4,'存储系统和结构.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-23 02:13:31',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(5,'中央处理器.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-24 02:14:00',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(6,'外部设备.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-25 02:14:35',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi'),(7,'输入输出系统.avi','http://192.168.1.104:8181/Christopher/video/数据的机器层次表示.avi','2017-04-26 02:15:03',1,1,'http://192.168.1.104:8181/Christopher/pic/videopic/avi.jpg','.avi');

/*Table structure for table `video_user` */

DROP TABLE IF EXISTS `video_user`;

CREATE TABLE `video_user` (
  `uid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  PRIMARY KEY (`vid`,`uid`),
  KEY `FK1655754FD68D958B` (`uid`),
  KEY `FK1655754FFAF9A51C` (`vid`),
  CONSTRAINT `FK1655754FD68D958B` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `FK1655754FFAF9A51C` FOREIGN KEY (`vid`) REFERENCES `video` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `video_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
