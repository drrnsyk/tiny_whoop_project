package vttp2022.project.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class RaceCourse {
    private Integer raceId;
    private String raceName;
    private Integer laps;
    private DateTime closingDate;

    public Integer getRaceId() {
        return raceId;
    }
    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }
    public String getRaceName() {
        return raceName;
    }
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
    public Integer getLaps() {
        return laps;
    }
    public void setLaps(Integer laps) {
        this.laps = laps;
    }
    public DateTime getClosingDate() {
        return closingDate;
    }
    public void setClosingDate(DateTime closingDate) {
        this.closingDate = closingDate;
    }

    public static RaceCourse create(SqlRowSet rs) {
        RaceCourse rc = new RaceCourse();
        rc.setRaceId(rs.getInt("race_id"));
        rc.setRaceName(rs.getString("race_name"));
        rc.setLaps(rs.getInt("laps"));
        System.out.println(rs.getString("closing_date"));
        rc.setClosingDate(new DateTime(DateTimeFormat.forPattern("yyyy-mm-dd hh:mm:ss.0").parseDateTime(rs.getString("closing_date"))));
        return rc;        
    }
    

}
