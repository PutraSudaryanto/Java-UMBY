/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.24 : Database - _kampus_java_crud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `ommu_core_zone_city` */

DROP TABLE IF EXISTS `ommu_core_zone_city`;

CREATE TABLE `ommu_core_zone_city` (
  `city_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `publish` tinyint(1) NOT NULL DEFAULT '1',
  `province_id` smallint(5) unsigned DEFAULT NULL,
  `city` varchar(64) NOT NULL,
  `mfdonline` char(4) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'trigger',
  `modified_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'trigger',
  PRIMARY KEY (`city_id`),
  KEY `FK_province` (`province_id`),
  CONSTRAINT `ommu_core_zone_city_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `ommu_core_zone_province` (`province_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=533 DEFAULT CHARSET=utf8;

/*Table structure for table `ommu_core_zone_districts` */

DROP TABLE IF EXISTS `ommu_core_zone_districts`;

CREATE TABLE `ommu_core_zone_districts` (
  `district_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `publish` tinyint(1) NOT NULL DEFAULT '1',
  `city_id` int(11) unsigned DEFAULT NULL,
  `district_name` varchar(64) NOT NULL,
  `mfdonline` char(7) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'trigger',
  `modified_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'trigger',
  PRIMARY KEY (`district_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `ommu_core_zone_districts_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `ommu_core_zone_city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6880 DEFAULT CHARSET=utf8;

/*Table structure for table `ommu_core_zone_province` */

DROP TABLE IF EXISTS `ommu_core_zone_province`;

CREATE TABLE `ommu_core_zone_province` (
  `province_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `publish` tinyint(1) NOT NULL DEFAULT '1',
  `province` varchar(64) NOT NULL,
  `mfdonline` char(2) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'trigger',
  `modified_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'trigger',
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Table structure for table `ommu_core_zone_village` */

DROP TABLE IF EXISTS `ommu_core_zone_village`;

CREATE TABLE `ommu_core_zone_village` (
  `village_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `publish` tinyint(1) NOT NULL DEFAULT '1',
  `district_id` int(11) unsigned DEFAULT NULL,
  `village_name` varchar(64) NOT NULL,
  `zipcode` char(5) NOT NULL,
  `mfdonline` char(10) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'trigger',
  `modified_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'trigger',
  PRIMARY KEY (`village_id`),
  KEY `district_id` (`district_id`),
  CONSTRAINT `ommu_core_zone_village_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `ommu_core_zone_districts` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/* Trigger structure for table `ommu_core_zone_city` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeInsertCity` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeInsertCity` BEFORE INSERT ON `ommu_core_zone_city` FOR EACH ROW BEGIN
	DECLARE province_id_tr SMALLINT;
	
	/*CALL getOmmuZoneProvinceIdWithCityMfdonline(NEW.mfdonline, province_id_tr);*/
	SELECT `province_id` INTO province_id_tr FROM `ommu_core_zone_province` WHERE `mfdonline`=LEFT(NEW.mfdonline,2);
	IF (province_id_tr IS NOT NULL) THEN
		SET NEW.province_id = province_id_tr;
	END IF;	
	
	SET NEW.city = TRIM(NEW.city);
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_city` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeUpdateCity` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeUpdateCity` BEFORE UPDATE ON `ommu_core_zone_city` FOR EACH ROW BEGIN
	DECLARE province_id_tr SMALLINT;
	
	IF (NEW.mfdonline <> OLD.mfdonline) THEN	
		/*CALL getOmmuZoneProvinceIdWithCityMfdonline(NEW.mfdonline, province_id_tr);*/
		SELECT `province_id` INTO province_id_tr FROM `ommu_core_zone_province` WHERE `mfdonline`=LEFT(NEW.mfdonline,2);
		IF (province_id_tr IS NOT NULL) THEN
			SET NEW.province_id = province_id_tr;
		END IF;
	END IF;
	SET NEW.city = TRIM(NEW.city);
	SET NEW.modified_date = NOW();
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_districts` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeInsertDistricts` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeInsertDistricts` BEFORE INSERT ON `ommu_core_zone_districts` FOR EACH ROW BEGIN
	DECLARE `city_id_tr` INT;
	
	/*CALL getOmmuZoneCityIdWithDistrictMfdonline(NEW.mfdonline, city_id_tr);*/
	SELECT `city_id` INTO city_id_tr FROM `ommu_core_zone_city` WHERE `mfdonline`=LEFT(NEW.mfdonline,4);
	IF (city_id_tr IS NOT NULL) THEN
		SET NEW.city_id = city_id_tr;
	END IF;	
	
	SET NEW.district_name = TRIM(NEW.district_name);
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_districts` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeUpdateDistricts` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeUpdateDistricts` BEFORE UPDATE ON `ommu_core_zone_districts` FOR EACH ROW BEGIN
	DECLARE `city_id_tr` INT;
	
	IF (NEW.mfdonline <> OLD.mfdonline) THEN	
		/*CALL getOmmuZoneCityIdWithDistrictMfdonline(NEW.mfdonline, city_id_tr);*/
		SELECT `city_id` INTO city_id_tr FROM `ommu_core_zone_city` WHERE `mfdonline`=LEFT(NEW.mfdonline,4);
		IF (city_id_tr IS NOT NULL) THEN
			SET NEW.city_id = city_id_tr;
		END IF;
	END IF;
	SET NEW.district_name = TRIM(NEW.district_name);
	SET NEW.modified_date = NOW();
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_province` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeInsertProvince` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeInsertProvince` BEFORE INSERT ON `ommu_core_zone_province` FOR EACH ROW BEGIN
	SET NEW.province = TRIM(NEW.province);
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_province` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeUpdateProvince` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeUpdateProvince` BEFORE UPDATE ON `ommu_core_zone_province` FOR EACH ROW BEGIN
	SET NEW.province = TRIM(NEW.province);
	SET NEW.modified_date = NOW();
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_village` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeInsertVillage` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeInsertVillage` BEFORE INSERT ON `ommu_core_zone_village` FOR EACH ROW BEGIN
	DECLARE `district_id_tr` INT;
		
	/*CALL getOmmuZoneCityIdWithDistrictMfdonline(NEW.mfdonline, city_id_tr);*/
	SELECT `district_id` INTO district_id_tr FROM `ommu_core_zone_districts` WHERE `mfdonline`=LEFT(NEW.mfdonline,7);
	IF (district_id_tr IS NOT NULL) THEN
		SET NEW.district_id = district_id_tr;
	END IF;
	
	SET NEW.village_name = TRIM(NEW.village_name);
	SET NEW.zipcode = TRIM(NEW.zipcode);
    END */$$


DELIMITER ;

/* Trigger structure for table `ommu_core_zone_village` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `coreBeforeUpdateVillage` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `coreBeforeUpdateVillage` BEFORE UPDATE ON `ommu_core_zone_village` FOR EACH ROW BEGIN
	DECLARE `district_id_tr` INT;
	
	IF (NEW.mfdonline <> OLD.mfdonline) THEN	
		/*CALL getOmmuZoneCityIdWithDistrictMfdonline(NEW.mfdonline, city_id_tr);*/
		SELECT `district_id` INTO district_id_tr FROM `ommu_core_zone_districts` WHERE `mfdonline`=LEFT(NEW.mfdonline,7);
		IF (district_id_tr IS NOT NULL) THEN
			SET NEW.district_id = district_id_tr;
		END IF;
	END IF;
	SET NEW.village_name = TRIM(NEW.village_name);
	SET NEW.zipcode = TRIM(NEW.zipcode);
	SET NEW.modified_date = NOW();
    END */$$


DELIMITER ;

/* Procedure structure for procedure `getOmmuZoneCityIdWithDistrictMfdonline` */

/*!50003 DROP PROCEDURE IF EXISTS  `getOmmuZoneCityIdWithDistrictMfdonline` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getOmmuZoneCityIdWithDistrictMfdonline`(IN `mfdonline_sp` CHAR, OUT `city_id_sp` INT)
BEGIN
	SELECT `city_id` INTO city_id_sp FROM `ommu_core_zone_city` WHERE `mfdonline`=LEFT(mfdonline_sp,4);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getOmmuZoneCountryId` */

/*!50003 DROP PROCEDURE IF EXISTS  `getOmmuZoneCountryId` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getOmmuZoneCountryId`(IN `province_id_sp` SMALLINT, OUT `country_id_sp` SMALLINT)
BEGIN
	SELECT `country_id` INTO country_id_sp FROM `ommu_core_zone_province` WHERE `province_id`=province_id_sp;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getOmmuZoneProvinceId` */

/*!50003 DROP PROCEDURE IF EXISTS  `getOmmuZoneProvinceId` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getOmmuZoneProvinceId`(in `city_id_sp` INT, OUT `province_id_sp` SMALLINT)
BEGIN
	SELECT `province_id` INTO province_id_sp FROM `ommu_core_zone_city` WHERE `city_id`=city_id_sp;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getOmmuZoneProvinceIdWithCityMfdonline` */

/*!50003 DROP PROCEDURE IF EXISTS  `getOmmuZoneProvinceIdWithCityMfdonline` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getOmmuZoneProvinceIdWithCityMfdonline`(IN `mfdonline_sp` CHAR, OUT `province_id_sp` SMALLINT)
BEGIN
	SELECT `province_id` INTO province_id_sp FROM `ommu_core_zone_province` WHERE `mfdonline`=LEFT(mfdonline_sp,2);
	/*
	CALL getOmmuZoneProvinceIdWithCityMfdonline(NEW.mfdonline, province_id_tr);
	SELECT `province_id` INTO province_id_tr FROM `ommu_core_zone_province` WHERE `mfdonline`=LEFT(NEW.mfdonline,2);*/
    END */$$
DELIMITER ;

/*Table structure for table `_view_core_zone_city` */

DROP TABLE IF EXISTS `_view_core_zone_city`;

/*!50001 DROP VIEW IF EXISTS `_view_core_zone_city` */;
/*!50001 DROP TABLE IF EXISTS `_view_core_zone_city` */;

/*!50001 CREATE TABLE  `_view_core_zone_city`(
 `city_id` int(11) unsigned ,
 `city` varchar(64) ,
 `province` varchar(64) 
)*/;

/*Table structure for table `_view_core_zone_districts` */

DROP TABLE IF EXISTS `_view_core_zone_districts`;

/*!50001 DROP VIEW IF EXISTS `_view_core_zone_districts` */;
/*!50001 DROP TABLE IF EXISTS `_view_core_zone_districts` */;

/*!50001 CREATE TABLE  `_view_core_zone_districts`(
 `district_id` int(11) unsigned ,
 `district_name` varchar(64) ,
 `city` varchar(64) ,
 `province` varchar(64) 
)*/;

/*View structure for view _view_core_zone_city */

/*!50001 DROP TABLE IF EXISTS `_view_core_zone_city` */;
/*!50001 DROP VIEW IF EXISTS `_view_core_zone_city` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `_view_core_zone_city` AS select `a`.`city_id` AS `city_id`,`a`.`city` AS `city`,`b`.`province` AS `province` from (`ommu_core_zone_city` `a` left join `ommu_core_zone_province` `b` on((`a`.`province_id` = `b`.`province_id`))) */;

/*View structure for view _view_core_zone_districts */

/*!50001 DROP TABLE IF EXISTS `_view_core_zone_districts` */;
/*!50001 DROP VIEW IF EXISTS `_view_core_zone_districts` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `_view_core_zone_districts` AS select `a`.`district_id` AS `district_id`,`a`.`district_name` AS `district_name`,`b`.`city` AS `city`,`b`.`province` AS `province` from (`ommu_core_zone_districts` `a` left join `_view_core_zone_city` `b` on((`a`.`city_id` = `b`.`city_id`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
