CREATE DATABASE IF NOT EXISTS `ssmdb` DEFAULT CHARACTER SET utf8 COLLATE  utf8_general_ci;

CREATE USER 'ssm'@'%' IDENTIFIED BY 'ssm';

DROP USER xxpay

GRANT ALL ON ssmdb.* TO 'ssm'@'%'; 

REVOKE ALL ON xxpaydb.* FROM 'xxpay'@'%'; 




DROP TABLE IF EXISTS `user_t`;  
  
CREATE TABLE `user_t` (  
  `id` INT(11) NOT NULL AUTO_INCREMENT,  
  `user_name` VARCHAR(40) NOT NULL,  
  `password` VARCHAR(255) NOT NULL,  
  `age` INT(4) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  


INSERT  INTO `user_t`(`id`,`user_name`,`password`,`age`) VALUES (1,'≤‚ ‘','sfasgfaf',24)

