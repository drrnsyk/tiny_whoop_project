package vttp2022.project.repository;

public class Queries {
    public static final String SQL_SELECT_ALL_RACE_COURSES = "SELECT race_id, race_name, laps, DATE_FORMAT(closing_date, \"%d-%m-%Y\") as closing_date, organizer FROM race_courses";

    public static String SQL_INSERT_RACE_COURSE = "INSERT INTO race_courses(race_name, laps, closing_date, organizer) VALUES (?, ?, ?, ?)";

    public static final String SQL_SELECT_RACE_COURSE_BY_RACEID = "SELECT race_id, race_name, laps, DATE_FORMAT(closing_date, \"%d-%m-%Y\") as closing_date, organizer FROM race_courses WHERE race_id = ?";

    // public static String SQL_UPDATE_RACE_COURSE_BY_RACEID = "UPDATE race_courses SET race_name = ?, laps = ?, closing_date = ? WHERE race_id = ?";

    public static String SQL_UPDATE_RACE_COURSE_BY_RACEID = "UPDATE race_courses SET race_name = ?, laps = ?, organizer = ? WHERE race_id = ?";

    public static String SQL_DELETE_RACE_COURSE_BY_RACEID = "DELETE FROM race_courses WHERE race_id = ?";

    public static final String SQL_SELECT_PILOTS_BY_RACE_ID = "SELECT DISTINCT pilots.pilot_id, pilots.pilot_name, pilot_drone_name FROM laps JOIN pilots ON laps.pilot_id = pilots.pilot_id WHERE race_id = ?";

    public static String SQL_INSERT_PILOT_TO_PILOTS_BY_RACE_ID = "INSERT INTO pilots(pilot_id, pilot_name, pilot_drone_name) VALUES (?, ?, ?)";

    public static String SQL_INSERT_PILOT_TO_LAPS_BY_RACE_ID = "INSERT INTO laps(lap_number, race_id, pilot_id, lap_time) VALUES (?, ?, ?, ?)";
}
