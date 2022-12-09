CREATE TABLE `race_courses` (
  `race_id` int NOT NULL AUTO_INCREMENT,
  `race_name` varchar(256) NOT NULL,
  `laps` enum('3','5') NOT NULL,
  `closing_date` datetime NOT NULL,
  `organizer` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`race_id`)
)

CREATE TABLE `pilots` (
  `pilot_id` char(8) NOT NULL,
  `pilot_name` varchar(256) NOT NULL,
  `pilot_drone_name` varchar(256) NOT NULL,
  PRIMARY KEY (`pilot_id`)
)

CREATE TABLE `laps` (
  `lap_id` int NOT NULL AUTO_INCREMENT,
  `lap_number` int NOT NULL,
  `race_id` int NOT NULL,
  `pilot_id` char(8) NOT NULL,
  `lap_time` int NOT NULL,
  PRIMARY KEY (`lap_id`),
  KEY `fk_race_id` (`race_id`),
  KEY `fk_pilot_id` (`pilot_id`),
  CONSTRAINT `fk_pilot_id` FOREIGN KEY (`pilot_id`) REFERENCES `pilots` (`pilot_id`),
  CONSTRAINT `fk_race_id` FOREIGN KEY (`race_id`) REFERENCES `race_courses` (`race_id`)
)