package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.FieldEntry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcFieldEntryDao implements FieldEntryDao {

    private final JdbcTemplate template;

    public JdbcFieldEntryDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<FieldEntry> getFieldEntriesByJobId(int jobId) {
        List<FieldEntry> fieldEntries = new ArrayList<>();
        String sql = "SELECT * FROM field_entry WHERE job_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, jobId);
        if(results.next()) {
            fieldEntries.add(mapRowToFieldEntry(results));
        }
        return fieldEntries;
    }

    @Override
    public boolean createFieldEntry(FieldEntry entry) {
        boolean success = false;
        String sql = "INSERT INTO field_entry (job_id, job_number, crew_name_1, crew_name_2, " +
                "crew_name_3, entry_date, hours_worked, minutes_worked) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        int linesUpdated = template.update(sql, entry.getJobId(), entry.getJobNumber(), entry.getCrewName1(), entry.getCrewName2(),
                entry.getCrewName3(), entry.getEntryDate(), entry.getHoursWorked(), entry.getMinutesWorked());
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public FieldEntry editFieldEntry(FieldEntry entry) {
        String sql = "UPDATE field_entry SET job_id = ?, job_number = ?, crew_name_1 = ?, crew_name_2 = ?, " +
                "crew_name_3 = ?, entry_date = ?, hours_worked = ?, minutes_worked = ? " +
                "WHERE job_id = ?, entry_date = ?, crew_name_1 = ?;";
        template.update(sql, entry.getJobId(), entry.getJobNumber(), entry.getCrewName1(), entry.getCrewName2(),
                entry.getCrewName3(), entry.getEntryDate(), entry.getHoursWorked(), entry.getMinutesWorked(),
                entry.getJobId(), entry.getEntryDate(), entry.getCrewName1());

        return null; // return field entry when proper get method is assigned (using pk)
    }

    @Override
    public boolean deleteFieldEntry(int jobId, Date entryDate, String crewName1) {
        boolean success = false;
        String sql = "DELETE FROM field_entry WHERE job_id = ?, entry_date = ?, crew_name_1 = ?;";
        // pk will change once stop and start times are added to model...
        int linesUpdated = template.update(sql, jobId, entryDate, crewName1);
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    private FieldEntry mapRowToFieldEntry(SqlRowSet rowSet) {
        FieldEntry fieldEntry = new FieldEntry();
        fieldEntry.setJobNumber(rowSet.getInt("job_number"));
        fieldEntry.setCrewName1(rowSet.getString("crew_name_1"));
        fieldEntry.setCrewName2(rowSet.getString("crew_name_2"));
        fieldEntry.setCrewName3(rowSet.getString("crew_name_3"));
        fieldEntry.setEntryDate(rowSet.getDate("entry_date"));
        fieldEntry.setHoursWorked(rowSet.getInt("hours_worked"));
        fieldEntry.setMinutesWorked(rowSet.getInt("minutes_worked"));
        return fieldEntry;
    }
}
