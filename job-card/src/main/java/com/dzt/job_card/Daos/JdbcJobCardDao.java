package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJobCardDao implements JobCardDao {

    private final JdbcTemplate template; // used to communicate with db

    public JdbcJobCardDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public JobCard createNewJobCard(JobCard jobCard) {
        String sql = "INSERT INTO job_card (job_number, client_name, phone_number, " +
                "alt_phone_number, client_email, alt_email, job_address, job_type, " +
                "job_status, complete_by) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING id;";
        Integer newJobId = template.queryForObject(sql, Integer.class, jobCard.getJobNumber(), jobCard.getClientName(),
                jobCard.getPhoneNumber(), jobCard.getAltPhoneNumber(), jobCard.getClientEmail(),
                jobCard.getAltEmail(), jobCard.getJobAddress(), jobCard.getJobType(), jobCard.getJobStatus(),
                jobCard.getCompleteBy());

        return getCardById(newJobId); // Null pointer??
    }

    @Override
    public JobCard getCardById(int id) {
        JobCard jobCard = null;
        String sql = "SELECT * FROM job_card WHERE id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, id);
        if(results.next()) {
            jobCard = mapRowToJobCard(results);
        }
        return jobCard;
    }

    @Override
    public List<JobCard> getAllJobCards() {
        List<JobCard> jobCardList = new ArrayList<>();
        String sql = "SELECT * FROM job_card;";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()) {
            jobCardList.add(mapRowToJobCard(results));
        }
        return jobCardList;
    }

    @Override
    public List<JobCard> filterByNumber(Integer jobNum) {
        List<JobCard> jobCardList = new ArrayList<>();
        String sql = "SELECT * FROM job_card WHERE job_number = ?;";
        SqlRowSet results = template.queryForRowSet(sql,  jobNum);
        while(results.next()) {
            jobCardList.add(mapRowToJobCard(results));
        }
        return jobCardList;
    }

    @Override
    public List<JobCard> filterByType(boolean type) {
        return null;
    }

    @Override
    public JobCard editJobCard(JobCard updatedCard) {
        String sql = "UPDATE job_card SET job_number = ?, client_name = ?, phone_number = ?, alt_phone_number = ?, " +
                "client_email = ?, alt_email = ?, job_address = ?, job_type = ?, job_status = ?, complete_by = ? " +
                "WHERE id = ?;";
        template.update(sql, updatedCard.getJobNumber(), updatedCard.getClientName(), updatedCard.getPhoneNumber(),
                updatedCard.getAltPhoneNumber(), updatedCard.getClientEmail(), updatedCard.getAltEmail(),
                updatedCard.getJobAddress(), updatedCard.getJobType(), updatedCard.getJobStatus(),
                updatedCard.getCompleteBy(), updatedCard.getId());

        return getCardById(updatedCard.getId());
    }

    @Override
    public boolean deleteJobCard(int id) {
        boolean success = false;
        String sql = "DELETE FROM job_card WHERE id = ?;";
        int linesUpdated = template.update(sql, id);
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    // Mapping method to help other methods that return a JobCard object and have to read from db
    private JobCard mapRowToJobCard(SqlRowSet rowSet) {
        JobCard jobCard = new JobCard();
        jobCard.setId(rowSet.getInt("id"));
        jobCard.setJobNumber(rowSet.getInt("job_number"));
        jobCard.setClientName(rowSet.getString("client_name"));
        jobCard.setPhoneNumber(rowSet.getString("phone_number"));
        jobCard.setAltPhoneNumber(rowSet.getString("alt_phone_number"));
        jobCard.setClientEmail(rowSet.getString("client_email"));
        jobCard.setAltEmail(rowSet.getString("alt_email"));
        jobCard.setJobAddress(rowSet.getString("job_address"));
        jobCard.setJobType(rowSet.getString("job_type"));
        jobCard.setJobStatus(rowSet.getString("job_status"));
        jobCard.setCompleteBy(rowSet.getDate("complete_by"));
        return jobCard;
    }
}
