package vttp2022.project.repository;

public class Queries {
    public static final String SQL_SELECT_ALL_RACE_COURSES = """
            SELECT * FROM race_courses
            """;

    public static String SQL_INSERT_RACE_COURSE = "INSERT INTO race_courses(race_name, laps, closing_date) VALUES (?, ?, SYSDATE())";
}
