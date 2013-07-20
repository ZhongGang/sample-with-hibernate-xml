DROP TABLE  IF EXISTS  examine;
CREATE TABLE `examine` (
  `id` int(11) NOT NULL auto_increment,
  `version` int(9) default 0,
  `active` tinyint(1) default '1',
  `guid` varchar(255) default NULL,
  `create_time` datetime ,
  `last_modify_time` datetime ,
  `start_date` date ,
  `end_date` date ,
  `department` varchar(255),
  `member` varchar(255),
  `score` decimal(8,2),
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;