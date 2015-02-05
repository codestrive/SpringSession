DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `code` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;

INSERT INTO `product` (`code`, `description`, `price`, `quantity`)
VALUES
	('p001','machine',30,20),
	('p002','washingMac',30,20),
	('p003','washingMac',30,20),
	('p004','mobile',10,50),
	('p005','tv',30,20);

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
