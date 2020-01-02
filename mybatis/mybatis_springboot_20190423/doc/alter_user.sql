-- to test INT(6)
use `mmal`;

alter table `user`
    add number INT(6) ZEROFILL;

UPDATE `user` SET `number` = 1 WHERE `id` = 2;