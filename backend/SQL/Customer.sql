DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `code` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `phone1` varchar(250) NOT NULL,
  `phone2` varchar(250) NOT NULL,
  `creditLimit` decimal(10,2) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`code`, `name`, `address`, `phone1`, `phone2`, `creditLimit`)
VALUES
	('001','Koushik','Bangalore','9036012434','7676361187',20.00),
	('002','Indra','Bangalore','9036012434','7676361187',30.00);

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
