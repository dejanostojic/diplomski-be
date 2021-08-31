
--
-- Dumping data for table `climber`
--


INSERT INTO `climber` VALUES (1,'First climber SWAGGER UI','First climber e',1991),(3,'c3 update please','Last name',2000),(5,'C3 update','Last name',2000),(10,'Angular up','First',1989),(11,'Test 1','Last 1',1990),(12,'Test 1','Last 1',1990),(13,'Test 1','Last 1',1990),(14,'test','test',1990);


--
-- Dumping data for table `competition`
--


INSERT INTO `competition` (id,description,registration_open,registration_close,event_start_date,max_number_of_registrations,competition_name) VALUES (4,'nn',NULL,NULL,NULL,NULL,'nn aaa'),(5,'d2',NULL,NULL,NULL,NULL,'c2'),(6,'d3',NULL,NULL,NULL,NULL,'c3'),(7,'Samardzija',NULL,NULL,NULL,NULL,'Ivana'),(9,'test',NULL,NULL,NULL,NULL,'test'),(30,'asdf','2021-08-05 00:01:00','2021-08-14 23:59:00',NULL,NULL,'adsf'),(31,'asdf','2021-08-05 00:01:00','2021-08-14 23:59:00',NULL,NULL,'adsf'),(32,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(33,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(34,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(35,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'tttttt'),(36,'tttttttttt','2021-08-27 00:01:00','2021-08-27 00:01:00',NULL,NULL,'opa opa'),(37,'adsf 37 update swagger','1990-06-19 04:00:00','2021-08-05 06:01:00',NULL,NULL,'adsf 37 update swagger');
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;





--
-- Dumping data for table `registration_fee`
--


INSERT INTO `registration_fee` (competition_id,ord,`name`,amount, start_date, end_date) VALUES (30,1,'Early birds',100.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(30,2,'Regular',200.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(30,3,'Last minute',300.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,1,'Early birds',100.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,2,'Regular',200.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(31,3,'Last minute',300.00,'2021-08-09 22:12:44','2021-08-09 22:12:44'),(32,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(32,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(32,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(33,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(34,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(35,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,1,'Early birds',100.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,2,'Regular',200.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(36,3,'Last minute',300.00,'2021-08-09 22:52:21','2021-08-09 22:52:21'),(37,1,'Early birds swagger',100.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),(37,2,'Regular swagger',200.00,'2021-08-10 11:47:45','2021-08-10 11:47:45'),(37,3,'adsf',30000.00,'2021-08-21 00:00:00','2021-08-29 00:00:00');
--
-- Dumping data for table `route`
--



INSERT INTO `user` () VALUES (1,'student','fon','student','$2a$10$9sjlOz/YcJ9Uk88CC8YGzuM0RFDY8Rptwx9jz3k2OL9ZPJYyk8VeW');

