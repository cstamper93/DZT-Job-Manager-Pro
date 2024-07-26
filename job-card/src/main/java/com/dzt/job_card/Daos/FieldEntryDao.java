package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.FieldEntry;

import java.util.Date;
import java.util.List;

public interface FieldEntryDao {

    List<FieldEntry> getFieldEntriesByJobId(int jobId);

    boolean createFieldEntry(FieldEntry entry); // have to return boolean because pk is a combination of 3 variables

    FieldEntry editFieldEntry(FieldEntry entry);

    boolean deleteFieldEntry(int jobId, Date entryDate, String crewName1);
}
