INSERT INTO `competition`
(`id`,
`description`,
`registration_open`,
`registration_close`,
`event_start_date`,
`max_number_of_registrations`,
`competition_name`)
 VALUES (37,'Comp 37 desc','1990-06-19 04:00:00','2021-08-05 06:01:00',NULL,NULL,'Comp 37');


INSERT INTO `registration_fee`
(`competition_id`,
`ord`,
`name`,
`amount`,
`start_date`,
`end_date`)
VALUES
(37,1,'Early birds swagger',100.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),
(37,2,'Regular swagger',200.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),
(37,3,'adsf',30000.00,'2021-08-21 00:00:00','2021-08-29 00:00:00');
