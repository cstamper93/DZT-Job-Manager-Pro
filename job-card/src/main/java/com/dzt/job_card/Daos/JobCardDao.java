package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobCard;

import java.util.List;

public interface JobCardDao {

    // CRUD: create, read, update, delete

    JobCard createNewJobCard(JobCard jobCard);

    JobCard getCardById(int id);

    List<JobCard> getAllJobCards();

    // add ways to filter job card searches (ex: getCardsBy...clientName, city, associated crew members, etc...)

    List<JobCard> filterByNumber(int num);

    List<JobCard> filterByType(boolean type); // change type to t/f or boundary/construction

    JobCard editJobCard(JobCard updatedCard);

    boolean deleteJobCard(int id);

}
