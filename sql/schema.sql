CREATE TABLE `race_courses` (
  `race_id` int NOT NULL AUTO_INCREMENT,
  `race_name` varchar(256) NOT NULL,
  `laps` enum('3','5') NOT NULL,
  `closing_date` datetime NOT NULL,
  `organizer` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`race_id`)
)