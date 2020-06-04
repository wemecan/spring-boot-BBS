/*
SQLyog Ultimate v8.32 
MySQL - 5.1.32-community : Database - bbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bbs`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1024) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

LOCK TABLES `comment` WRITE;

insert  into `comment`(`id`,`content`,`parent_id`,`type`,`user_id`,`create_time`,`update_time`,`like_count`,`question_id`) values (2,'评论内容',0,0,1,'2020-01-01 00:00:00','2020-01-01 00:00:00',7,21),(3,'<p><span style=\"color: rgb(249, 150, 59);\">测试评论</span></p>',0,0,1,'2020-04-10 15:21:12','2020-04-10 15:21:12',4,21),(4,'<p><span style=\"color: rgb(28, 72, 127);\">最新评论</span></p>',0,0,1,'2020-04-10 15:31:35','2020-04-10 15:31:35',2,21),(5,'<p><img src=\"/static/images/faces/1.gif\" alt=\"[贱笑]\" data-w-e=\"1\">哈哈哈笑话！！<br></p>',0,0,1,'2020-04-10 16:45:45','2020-04-10 16:45:45',1,21),(6,'这是一条回复',5,1,1,'2020-01-01 00:00:00','2020-01-01 00:00:00',2,21),(7,'这是一条回复',5,1,1,'2020-01-01 00:00:00','2020-01-01 00:00:00',2,21),(8,'这是一条回复',5,1,1,'2020-01-01 00:00:00','2020-01-01 00:00:00',2,21),(9,'回复平',2,1,1,'2020-04-10 22:30:04','2020-04-10 22:30:04',0,21),(10,'回复平',5,1,1,'2020-04-10 22:39:16','2020-04-10 22:39:16',0,21),(11,'回复平',5,1,1,'2020-04-10 22:42:09','2020-04-10 22:42:09',0,21),(12,'测试二级回复！',5,1,1,'2020-04-11 10:20:43','2020-04-11 10:20:43',0,21),(13,'测试回复',3,1,1,'2020-04-11 10:21:07','2020-04-11 10:21:07',0,21),(14,'测试回复！！！！',4,1,1,'2020-04-11 10:21:14','2020-04-11 10:21:14',0,21),(15,'再次测试回复！',3,1,1,'2020-04-11 10:23:35','2020-04-11 10:23:35',0,21),(16,'测试测试',3,1,1,'2020-04-11 10:25:43','2020-04-11 10:25:43',0,21),(17,'<p>来啦 回复！！！！</p>',0,0,1,'2020-04-11 10:25:55','2020-04-11 10:25:55',1,20),(18,'<p>评论来了来了！！！<img src=\"/static/images/faces/1.gif\" alt=\"[贱笑]\" data-w-e=\"1\"></p>',0,0,1,'2020-04-11 10:55:05','2020-04-11 10:55:05',0,17),(19,'<p>又来一条！！</p>',0,0,1,'2020-04-11 10:56:36','2020-04-11 10:56:36',0,17),(20,'<p>我来评论啦！！！！</p>',0,0,1,'2020-04-11 11:00:13','2020-04-11 11:00:13',0,16),(21,'我路过了',20,1,1,'2020-04-11 11:00:46','2020-04-11 11:00:46',0,16),(22,'<p>我来评论啦&nbsp; &nbsp;亚瑟在此</p>',0,0,2,'2020-04-12 11:52:00','2020-04-12 11:52:00',0,21),(23,'我是亚瑟',5,1,2,'2020-04-12 11:53:06','2020-04-12 11:53:06',0,21),(26,'<p><img src=\"/static/images/faces/1.gif\" alt=\"[贱笑]\" data-w-e=\"1\">测试评论啦！！！<br></p>',0,0,1,'2020-04-12 17:20:49','2020-04-12 17:20:49',0,22),(27,'<p>自己评论自己！！</p>',0,0,1,'2020-04-12 22:47:32','2020-04-12 22:47:32',0,17),(28,'<p>这是秘密？ 不相信吖<img src=\"/static/images/faces/7.gif\" alt=\"[腼腆]\" data-w-e=\"1\"></p>',0,0,2,'2020-04-12 22:54:39','2020-04-12 22:54:39',0,23),(29,'<p>我自己评论我自己啦！！</p>',0,0,2,'2020-04-12 22:56:14','2020-04-12 22:56:14',0,24),(30,'哈哈哈，为什么不相信？',28,1,1,'2020-04-12 22:56:54','2020-04-12 22:56:54',0,23),(31,'啊啊啊为什么',28,1,1,'2020-04-12 23:04:27','2020-04-12 23:04:27',0,23),(32,'<p>自己评论自己嘛</p>',0,0,1,'2020-04-12 23:04:38','2020-04-12 23:04:38',0,23),(33,'那我来评论你 亚瑟',29,1,1,'2020-04-12 23:25:26','2020-04-12 23:25:26',0,24),(34,'<p>亚瑟来也</p>',0,0,2,'2020-04-12 23:27:12','2020-04-12 23:27:12',0,17),(35,'<p>亚瑟？什么玩意<img src=\"/static/images/faces/15.gif\" alt=\"[恶心]\" data-w-e=\"1\"></p>',0,0,1,'2020-04-13 10:11:45','2020-04-13 10:11:45',0,24),(36,'<p>尼玛尼玛</p>',0,0,1,'2020-05-31 09:47:25','2020-05-31 09:47:25',0,24);

UNLOCK TABLES;

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notifier` int(11) DEFAULT NULL,
  `receiver` int(11) DEFAULT NULL,
  `outer_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `notification` */

LOCK TABLES `notification` WRITE;

insert  into `notification`(`id`,`notifier`,`receiver`,`outer_id`,`type`,`create_time`,`status`) values (1,2,1,21,0,'2020-04-12 11:52:00',1),(2,2,1,5,1,'2020-04-12 11:53:06',1),(3,1,1,22,0,'2020-04-12 17:20:49',1),(4,1,1,17,0,'2020-04-12 22:47:32',0),(5,2,1,23,0,'2020-04-12 22:54:39',1),(6,2,2,24,0,'2020-04-12 22:56:14',0),(7,1,2,28,1,'2020-04-12 22:56:54',1),(8,1,2,28,1,'2020-04-12 23:04:27',1),(9,1,1,23,0,'2020-04-12 23:04:38',0),(10,1,2,29,1,'2020-04-12 23:25:26',1),(11,2,1,17,0,'2020-04-12 23:27:12',1),(12,1,2,24,0,'2020-04-13 10:11:45',1),(13,1,2,24,0,'2020-05-31 09:47:25',0);

UNLOCK TABLES;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `question` */

LOCK TABLES `question` WRITE;

insert  into `question`(`id`,`title`,`description`,`create_time`,`update_time`,`creator`,`comment_count`,`view_count`,`like_count`,`tag`) values (1,'修改标题！！！！','内容&nbsp;<h1><span style=\"color: rgb(194, 79, 74);\">h哈哈哈</span></h1><div><font color=\"#c24f4a\">测试修改</font></div>','2020-01-01 00:00:00','2020-04-08 21:15:14',1,0,14,10,'java'),(2,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 17:28:10','2020-04-08 21:09:57',1,0,3,0,'java'),(3,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 17:38:41','2020-04-08 21:09:57',1,0,2,0,'java'),(4,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 17:47:44','2020-04-08 21:09:57',1,0,2,0,'java'),(5,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 17:53:38','2020-04-08 21:09:57',1,0,0,0,'java'),(6,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 18:32:06','2020-04-08 21:09:57',1,0,1,0,'java'),(7,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-03 18:33:44','2020-04-08 21:09:57',1,0,6,0,'java'),(8,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,10,10,'java'),(9,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,11,10,'java'),(10,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,12,10,'java'),(11,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,10,10,'java'),(12,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,10,10,'java'),(13,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,10,10,'java'),(14,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1><div><font color=\"#8baa4a\">你笑啥????</font></div>','2020-01-01 11:29:00','2020-04-09 22:34:14',1,0,16,10,'java'),(15,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,0,13,10,'java'),(16,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,2,19,10,'java'),(17,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-01-01 11:29:00','2020-04-08 21:09:57',1,4,35,10,'java'),(20,'标题','内容&nbsp;<h1><span style=\"color: rgb(139, 170, 74);\">h哈哈哈</span></h1>','2020-04-08 21:08:23','2020-04-08 21:09:57',1,1,17,0,'java'),(21,'java是什么','<p><span style=\"color: rgb(123, 91, 161);\">高级编程语言</span></p>','2020-04-08 21:32:47','2020-04-08 21:34:12',1,5,250,0,'java,mybatis'),(22,'这是一条测试问题','<p><span style=\"background-color: rgb(139, 170, 74); color: rgb(249, 150, 59);\">别跟我比比来啦</span></p>','2020-04-11 12:42:20','2020-04-11 12:42:20',1,1,33,0,'Hibernate,java,spring boot'),(23,'java的秘密','<p><img src=\"/static/images/faces/20.gif\" alt=\"[别吵吵]\" data-w-e=\"1\">这可不能说的<img src=\"/static/images/faces/2.gif\" alt=\"[大笑]\" data-w-e=\"1\"><br></p>','2020-04-12 17:34:31','2020-04-12 17:34:31',1,3,38,0,'spring,java'),(24,'亚瑟的第一条问题','<h3><span style=\"color: rgb(194, 79, 74);\">java</span>为什么这么热门？<img src=\"/static/images/faces/11.gif\" alt=\"[萌萌哒]\" data-w-e=\"1\"></h3>','2020-04-12 22:55:26','2020-04-12 22:55:26',2,3,26,0,'java'),(25,'测试图片文章','<p><img src=\"http://img.xiaotaozy.cn/bbs/2020-04-13/07cd0dc677ce4ba39f588d460c23bb7f-car_step8.gif\" style=\"max-width:100%;\"><img src=\"http://img.xiaotaozy.cn/bbs/2020-04-13/8255bb09dc8e4496825f39becc05a3ce-infobg.gif\" style=\"max-width: 100%;\">&nbsp;哈哈哈哈<br></p>','2020-04-13 16:53:10','2020-04-13 16:53:10',1,0,9,0,'spring,spring boot');

UNLOCK TABLES;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

LOCK TABLES `test` WRITE;

insert  into `test`(`id`,`name`) values (1,'小'),(2,'小');

UNLOCK TABLES;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) DEFAULT NULL,
  `account_id` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `face` varchar(255) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`id`,`nickName`,`account_id`,`password`,`sex`,`face`,`reg_time`,`email`,`mobile`) values (1,'小恶魔','123','e53bf958d2995734f502e39f3516ec31','男','https://elasticsearch.cn/uploads/avatar/000/01/16/33_avatar_max.jpg','2020-04-03 11:46:00','1551282386@qq.com','110'),(2,'亚瑟','123','1d5fe0c45d57cc381a03b5cab9069d56','男','https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3788695993,2392089703&fm=111&gp=0.jpg','2020-04-12 11:46:00','1551282386@qq.com','110');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
