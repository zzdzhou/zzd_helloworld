START TRANSACTION;

INSERT INTO `timesheet` (`id`, `activity`,`date`,`days`,`description`,`resource`,`type`) VALUES (1, 'DSMID-100','2018-04-17',0.2,'test data, Glory !','Zhengde ZHOU','support');
INSERT INTO `timesheet` (`id`, `activity`,`date`,`days`,`description`,`resource`,`type`) VALUES (2, 'DSMID-101','2018-04-17',0.3,'Duke waving his hand!','Zhengde ZHOU','support');

COMMIT;