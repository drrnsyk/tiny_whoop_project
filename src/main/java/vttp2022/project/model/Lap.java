package vttp2022.project.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Lap {
    private String lapId;
    private String lapNumber;
    private String raceId;
    private String pilotId;
    private Integer lapTime;

    public String getLapId() {
        return lapId;
    }
    public void setLapId(String lapId) {
        this.lapId = lapId;
    }
    public String getLapNumber() {
        return lapNumber;
    }
    public void setLapNumber(String lapNumber) {
        this.lapNumber = lapNumber;
    }
    public String getRaceId() {
        return raceId;
    }
    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }
    public String getPilotId() {
        return pilotId;
    }
    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }
    public Integer getLapTime() {
        return lapTime;
    }
    public void setLapTime(Integer lapTime) {
        this.lapTime = lapTime;
    }

    public static Lap create(SqlRowSet rs) {
        Lap lap = new Lap();
        lap.setLapId(rs.getString("lap_id"));
        lap.setLapNumber(rs.getString("lap_number"));
        lap.setRaceId(rs.getString("race_id"));
        lap.setPilotId(rs.getString("pilot_id"));;
        lap.setLapTime(Integer.parseInt(rs.getString("lap_time")));
        return lap;
    }
    
}
