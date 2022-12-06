package vttp2022.project.repository;

public class Queries {
    public static final String SQL_SELECT_ALL_RACE_COURSES = "SELECT race_id, race_name, laps, DATE_FORMAT(closing_date, \"%d-%m-%Y\") as closing_date FROM race_courses";

    public static String SQL_INSERT_RACE_COURSE = "INSERT INTO race_courses(race_name, laps, closing_date) VALUES (?, ?, ?)";
}
