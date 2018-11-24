START TRANSACTION;

CREATE SCHEMA IF NOT EXISTS `grocery_spring_boot`;
INSERT INTO `grocery_spring_boot`.`customer` (`id`, `confirmed`, `email`, `firstname`, `gender`, `lastname`, `phone`, `registration_date`, `title`) VALUES
('1', 1, 'zhengde.zhou@outlook.com', 'Zhengde', 'MALE', 'ZHOU', '1583234', '2018-05-04', 'MR');

COMMIT;