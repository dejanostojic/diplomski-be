
CREATE TABLE IF NOT EXISTS `climber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `year_of_birth` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE IF NOT EXISTS `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `registration_open` datetime DEFAULT NULL,
  `registration_close` datetime DEFAULT NULL,
  `event_start_date` datetime DEFAULT NULL,
  `max_number_of_registrations` int(11) DEFAULT NULL,
  `competition_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `registration` (
  `competition_id` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `start_number` int(11) DEFAULT NULL,
  `total_ord` int(11) DEFAULT NULL,
  `paid` tinyint(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `paid_date` datetime DEFAULT NULL,
  `fee_ord` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`climber_id`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`),
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
);

CREATE TABLE IF NOT EXISTS `registration_fee` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` decimal(15,2) unsigned DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `registration_fee_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
);

CREATE TABLE IF NOT EXISTS `route` (
  `competition_id` int(11) NOT NULL,
  `ord` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`ord`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
) ;

CREATE TABLE IF NOT EXISTS `route_climbed` (
  `competition_id` int(11) NOT NULL,
  `route_ord` int(11) NOT NULL,
  `climber_id` int(11) NOT NULL,
  `from_attempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`route_ord`,`climber_id`),
  CONSTRAINT `route_climbed_ibfk_1` FOREIGN KEY (`competition_id`, `route_ord`) REFERENCES `route` (`competition_id`, `ord`),
  CONSTRAINT `route_climbed_ibfk_2` FOREIGN KEY (`climber_id`) REFERENCES `climber` (`id`)
);

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
