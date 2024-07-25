package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.FieldEntry;

import java.util.Date;

public interface FieldEntryDao {

    FieldEntry getFieldEntriesByJobId(int jobId);

    FieldEntry createFieldEntry(FieldEntry entry);

    FieldEntry editFieldEntry(FieldEntry entry);

    boolean deleteFieldEntry(int jobId, Date entryDate, String crewName1);
}
