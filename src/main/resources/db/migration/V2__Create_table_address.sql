CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  `pin_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8yilrg13icyeudi9pi3ro0c1j` (`city_code`),
  CONSTRAINT `FK_8yilrg13icyeudi9pi3ro0c1j` FOREIGN KEY (`city_code`) REFERENCES `city` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
