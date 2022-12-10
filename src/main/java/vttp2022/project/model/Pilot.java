package vttp2022.project.model;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Pilot {
    private String pilotId;
    private String pilotName;
    private String pilotDroneName;
    private List<String> lapTimings;

    public Pilot(String pilotName, String pilotDroneName, List<String> lapTimings) {
        this.pilotId = UUID.randomUUID().toString().substring(0, 8);
        this.pilotName = pilotName;
        this.pilotDroneName = pilotDroneName;
        this.lapTimings = lapTimings;
    }

    public Pilot() {
    }

    public String getPilotId() {
        return pilotId;
    }
    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }
    public String getPilotName() {
        return pilotName;
    }
    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }
    public String getPilotDroneName() {
        return pilotDroneName;
    }
    public void setPilotDroneName(String pilotDroneName) {
        this.pilotDroneName = pilotDroneName;
    }
    public List<String> getLaptimings() {
        return lapTimings;
    }
    public void setLaptimings(List<String> lapTimings) {
        this.lapTimings = lapTimings;
    }

    public static Pilot create(SqlRowSet rs) {
        Pilot pilot = new Pilot();
        pilot.setPilotId(rs.getString("pilot_id"));
        pilot.setPilotName(rs.getString("pilot_name"));
        pilot.setPilotDroneName(rs.getString("pilot_drone_name"));
        return pilot;
    }
}
