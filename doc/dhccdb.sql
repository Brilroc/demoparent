/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.28 : Database - dhccdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dhccdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dhccdb`;

/*Table structure for table `achievement` */

DROP TABLE IF EXISTS `achievement`;

CREATE TABLE `achievement` (
  `Achv_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Achv_MbID` int(11) DEFAULT NULL,
  `Achv_Name` varchar(200) DEFAULT NULL,
  `Achv_Partner` varchar(100) DEFAULT NULL,
  `Achv_Journal` varchar(200) DEFAULT NULL,
  `Achv_Abstract` text,
  `Achv_Keyword` varchar(200) DEFAULT NULL,
  `Achv_Institution` varchar(200) DEFAULT NULL,
  `Achv_Content` text,
  `Achv_Section` varchar(50) DEFAULT NULL,
  `Achv_UploadTime` varchar(20) DEFAULT NULL,
  `Achv_Icon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Achv_Id`),
  KEY `FK_Reference_8` (`Achv_MbID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`Achv_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `achievement` */

insert  into `achievement`(`Achv_Id`,`Achv_MbID`,`Achv_Name`,`Achv_Partner`,`Achv_Journal`,`Achv_Abstract`,`Achv_Keyword`,`Achv_Institution`,`Achv_Content`,`Achv_Section`,`Achv_UploadTime`,`Achv_Icon`) values (1,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `eduexp` */

DROP TABLE IF EXISTS `eduexp`;

CREATE TABLE `eduexp` (
  `EE_Id` int(11) NOT NULL AUTO_INCREMENT,
  `EE_MbID` int(11) DEFAULT NULL,
  `EE_University` varchar(50) DEFAULT NULL,
  `EE_Discipline` varchar(100) DEFAULT NULL,
  `EE_EduBackground` varchar(50) DEFAULT NULL,
  `EE_Time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EE_Id`),
  KEY `FK_Reference_5` (`EE_MbID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`EE_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `eduexp` */

insert  into `eduexp`(`EE_Id`,`EE_MbID`,`EE_University`,`EE_Discipline`,`EE_EduBackground`,`EE_Time`) values (1,4,'首都医科大学','内科学（临床流行病学）','博士',' 2004/9 - 2007/7');

/*Table structure for table `instrument` */

DROP TABLE IF EXISTS `instrument`;

CREATE TABLE `instrument` (
  `Inst_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Inst_LabID` int(11) DEFAULT NULL,
  `Inst_Icon` varchar(50) DEFAULT NULL,
  `Inst_Desc` varchar(100) DEFAULT NULL,
  `Inst_Sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`Inst_Id`),
  KEY `FK_Reference_13` (`Inst_LabID`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`Inst_LabID`) REFERENCES `lab` (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `instrument` */

/*Table structure for table `keywords` */

DROP TABLE IF EXISTS `keywords`;

CREATE TABLE `keywords` (
  `KW_Id` int(11) NOT NULL AUTO_INCREMENT,
  `KW_MbID` int(11) DEFAULT NULL,
  `KW_KeyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`KW_Id`),
  KEY `FK_Reference_2` (`KW_KeyID`),
  KEY `FK_Reference_4` (`KW_MbID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`KW_KeyID`) REFERENCES `keywordsdic` (`KWD_Id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`KW_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `keywords` */

insert  into `keywords`(`KW_Id`,`KW_MbID`,`KW_KeyID`) values (1,4,1),(2,4,2),(3,4,3),(4,4,4),(5,4,5);

/*Table structure for table `keywordsdic` */

DROP TABLE IF EXISTS `keywordsdic`;

CREATE TABLE `keywordsdic` (
  `KWD_Id` int(11) NOT NULL AUTO_INCREMENT,
  `KWD_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`KWD_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `keywordsdic` */

insert  into `keywordsdic`(`KWD_Id`,`KWD_Name`) values (1,'临床流行病学'),(2,'脑血管病'),(3,'心血管病'),(4,'分子流行病学'),(5,'心血管疾病');

/*Table structure for table `lab` */

DROP TABLE IF EXISTS `lab`;

CREATE TABLE `lab` (
  `L_Id` int(11) NOT NULL AUTO_INCREMENT,
  `L_Name` varchar(100) DEFAULT NULL,
  `L_Tag` varchar(200) DEFAULT NULL,
  `L_Desc` varchar(500) DEFAULT NULL,
  `L_Address` varchar(200) DEFAULT NULL,
  `L_Tel` varchar(20) DEFAULT NULL,
  `L_Email` varchar(50) DEFAULT NULL,
  `L_Supervisor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lab` */

/*Table structure for table `labapplications` */

DROP TABLE IF EXISTS `labapplications`;

CREATE TABLE `labapplications` (
  `LA_Id` int(11) NOT NULL AUTO_INCREMENT,
  `LA_LabID` int(11) DEFAULT NULL,
  `LA_Icon` varchar(50) DEFAULT NULL,
  `LA_Sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`LA_Id`),
  KEY `FK_Reference_15` (`LA_LabID`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`LA_LabID`) REFERENCES `lab` (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `labapplications` */

/*Table structure for table `labcoarticle` */

DROP TABLE IF EXISTS `labcoarticle`;

CREATE TABLE `labcoarticle` (
  `LCA_Id` int(11) NOT NULL AUTO_INCREMENT,
  `LCA_LabID` int(11) DEFAULT NULL,
  `LCA_Title` varchar(200) DEFAULT NULL,
  `LCA_Journal` varchar(200) DEFAULT NULL,
  `LCA_Page` varchar(50) DEFAULT NULL,
  `LCA_Sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`LCA_Id`),
  KEY `FK_Reference_16` (`LCA_LabID`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`LCA_LabID`) REFERENCES `lab` (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `labcoarticle` */

/*Table structure for table `labservicetype` */

DROP TABLE IF EXISTS `labservicetype`;

CREATE TABLE `labservicetype` (
  `LST_Id` int(11) NOT NULL AUTO_INCREMENT,
  `LST_LabID` int(11) DEFAULT NULL,
  `LST_Title` varchar(100) DEFAULT NULL,
  `LST_Desc` text,
  `LST_Sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`LST_Id`),
  KEY `FK_Reference_14` (`LST_LabID`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`LST_LabID`) REFERENCES `lab` (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `labservicetype` */

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `MB_Id` int(11) NOT NULL AUTO_INCREMENT,
  `MB_Name` varchar(50) DEFAULT NULL,
  `MB_PhoneNumber` varchar(20) DEFAULT NULL,
  `MB_Email` varchar(50) DEFAULT NULL,
  `MB_Age` int(11) DEFAULT NULL,
  `MB_Education` varchar(50) DEFAULT NULL,
  `MB_University` varchar(100) DEFAULT NULL,
  `MB_Field` varchar(100) DEFAULT NULL,
  `MB_Research` varchar(100) DEFAULT NULL,
  `MB_ResearchGroup` varchar(100) DEFAULT NULL,
  `MB_Lab` varchar(100) DEFAULT NULL,
  `MB_Profile` text,
  `MB_Icon` varchar(50) DEFAULT NULL,
  `MB_Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`MB_Id`,`MB_Name`,`MB_PhoneNumber`,`MB_Email`,`MB_Age`,`MB_Education`,`MB_University`,`MB_Field`,`MB_Research`,`MB_ResearchGroup`,`MB_Lab`,`MB_Profile`,`MB_Icon`,`MB_Address`) values (1,'张健',NULL,'jian.zhang@sjtu.edu.cn 或jzhang.dr@gmail.com',NULL,'博士','上海交通大学医学院',NULL,NULL,'分子设计课题组','细胞分化与凋亡教育部重点实验室',NULL,NULL,NULL),(2,'Zhengzhong Shen',NULL,'zhengzhongshen@csu.edu.cn',NULL,NULL,NULL,'抠像学研究','口腔肿瘤及细胞生物学',NULL,NULL,NULL,NULL,NULL),(3,'冯丽',NULL,'lifen_shutcm@yahoo.com',NULL,NULL,NULL,'药物化学',NULL,NULL,NULL,NULL,NULL,NULL),(4,'周永',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'周永，男，1978年2月出生。毕业于首都医科大学，临床流行病学博士。首都医科大学附属北京安贞医院／北京市心肺血管研究所精准医疗中心副研究员。曾任首都医科大学附属北京天坛医院脑血管病中心人群血管健康研究室主任。2009年入选北京市科技新星计划，北京市优秀人才培养计划。中华预防医学会慢病防控委员会青年委员。中国营养学会营养与慢病分会委员；第一负责人实施国家自然科学基金项目两项；作为项目骨干，承担/参与 “十二五国家科技支撑计划” 、“十一五国家科技支撑计划”、 “国家卒中登记研究项目”、“国家重大新药创制平台：脑血管病创新药物临床评价技术平台：CHANCE研究”等多项研究。主要涉及急性卒中的预警模型、诊断、分型、规范治疗、康复计划、卒中登记系统、远程救治等方面。主要负责项目的设计、组织实施和撰写报告。担任中华医学会杂志、“中国卒中杂志”、“中国循证心血管病杂志”编辑。迄今已在“Circulation: Cardiovascular Quality and Outcomes”、“Stroke”、“Journal of Cardiology”、“CNS neuroscience & therapeutics”、“PLOS ONE”等SCI杂志中发表学术论文50余篇。',NULL,'中国，北京市'),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'');

/*Table structure for table `memberlab` */

DROP TABLE IF EXISTS `memberlab`;

CREATE TABLE `memberlab` (
  `ML_Id` int(11) NOT NULL AUTO_INCREMENT,
  `ML_MbID` int(11) DEFAULT NULL,
  `ML_LabID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ML_Id`),
  KEY `FK_Reference_10` (`ML_MbID`),
  KEY `FK_Reference_12` (`ML_LabID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`ML_MbID`) REFERENCES `member` (`MB_Id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`ML_LabID`) REFERENCES `lab` (`L_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `memberlab` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`price`) values (1,'apple',5),(2,'orange',2),(3,'banana',3);

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `Prj_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Prj_MbID` int(11) DEFAULT NULL,
  `Prj_Name` varchar(200) DEFAULT NULL,
  `Prj_Partner` varchar(100) DEFAULT NULL,
  `Prj_Inst` varchar(100) DEFAULT NULL,
  `Prj_Funds` varchar(50) DEFAULT NULL,
  `Prj_Time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Prj_Id`),
  KEY `FK_Reference_7` (`Prj_MbID`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`Prj_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`Prj_Id`,`Prj_MbID`,`Prj_Name`,`Prj_Partner`,`Prj_Inst`,`Prj_Funds`,`Prj_Time`) values (1,4,'脂蛋白磷脂酶A2对颈动脉斑块人群卒中发病预警价值的队列研究','*周永; 王安心','国家自然科学基金委员会','RMB 240,000','2013-01-01 ~ 2015-12-31');

/*Table structure for table `sciencefield` */

DROP TABLE IF EXISTS `sciencefield`;

CREATE TABLE `sciencefield` (
  `SF_Id` int(11) NOT NULL AUTO_INCREMENT,
  `SF_MbID` int(11) DEFAULT NULL,
  `SF_FieldID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SF_Id`),
  KEY `FK_Reference_1` (`SF_FieldID`),
  KEY `FK_Reference_3` (`SF_MbID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`SF_FieldID`) REFERENCES `sciencefielddic` (`SFD_Id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`SF_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sciencefield` */

insert  into `sciencefield`(`SF_Id`,`SF_MbID`,`SF_FieldID`) values (1,4,1),(2,4,2),(3,4,3);

/*Table structure for table `sciencefielddic` */

DROP TABLE IF EXISTS `sciencefielddic`;

CREATE TABLE `sciencefielddic` (
  `SFD_Id` int(11) NOT NULL AUTO_INCREMENT,
  `SFD_FieldName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SFD_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sciencefielddic` */

insert  into `sciencefielddic`(`SFD_Id`,`SFD_FieldName`) values (1,'公共卫生'),(2,'临床医学'),(3,'中医中药');

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `Tm_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tm_Name` varchar(50) DEFAULT NULL,
  `Tm_Desc` varchar(200) DEFAULT NULL,
  `Tm_CreateTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Tm_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `team` */

insert  into `team`(`Tm_Id`,`Tm_Name`,`Tm_Desc`,`Tm_CreateTime`) values (1,'','',NULL);

/*Table structure for table `teammember` */

DROP TABLE IF EXISTS `teammember`;

CREATE TABLE `teammember` (
  `TmM_Id` int(11) NOT NULL AUTO_INCREMENT,
  `TmM_MbID` int(11) DEFAULT NULL,
  `TmM_TmID` int(11) DEFAULT NULL,
  `TmM_Role` varchar(50) DEFAULT NULL,
  `TmM_JoinTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TmM_Id`),
  KEY `FK_Reference_11` (`TmM_TmID`),
  KEY `FK_Reference_9` (`TmM_MbID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`TmM_TmID`) REFERENCES `team` (`Tm_Id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`TmM_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `teammember` */

insert  into `teammember`(`TmM_Id`,`TmM_MbID`,`TmM_TmID`,`TmM_Role`,`TmM_JoinTime`) values (1,1,1,'组长',NULL),(2,2,1,'组员','2018.10'),(3,3,1,'组员','2016.08');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `perms` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`perms`) values (1,'dayu','123456','aaa'),(2,'haha','123456','user:add'),(3,'hehe','123456','user:update');

/*Table structure for table `workexp` */

DROP TABLE IF EXISTS `workexp`;

CREATE TABLE `workexp` (
  `WE_Id` int(11) NOT NULL AUTO_INCREMENT,
  `WE_MbID` int(11) DEFAULT NULL,
  `WE_Institution` varchar(50) DEFAULT NULL,
  `WE_Dept` varchar(50) DEFAULT NULL,
  `WE_JobTitle` varchar(50) DEFAULT NULL,
  `WE_Time` varchar(50) DEFAULT NULL,
  `WE_Detail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`WE_Id`),
  KEY `FK_Reference_6` (`WE_MbID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`WE_MbID`) REFERENCES `member` (`MB_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `workexp` */

insert  into `workexp`(`WE_Id`,`WE_MbID`,`WE_Institution`,`WE_Dept`,`WE_JobTitle`,`WE_Time`,`WE_Detail`) values (1,4,'首都医科附属北京安贞医院','心肺疾病研究所','副研究员','2016/1 - 至今','心脑血管转化医学研究'),(2,4,'首都医科大学','附属北京天坛医院(第五临床医学院)','副研究员','2007/8 - 2015/12','脑血管病的转化医学');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
