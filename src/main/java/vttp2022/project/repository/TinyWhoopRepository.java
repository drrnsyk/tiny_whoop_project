package vttp2022.project.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.project.model.RaceCourse;

import static vttp2022.project.repository.Queries.*;

@Repository
public class TinyWhoopRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RaceCourse> getAllRaceCourses() {
        final List<RaceCourse> raceCourses = new LinkedList<>();
        SqlRowSet rs = null;
        rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_RACE_COURSES);

        while (rs.next()) {
            raceCourses.add(RaceCourse.create(rs));
        }
        return raceCourses;
    }
}
