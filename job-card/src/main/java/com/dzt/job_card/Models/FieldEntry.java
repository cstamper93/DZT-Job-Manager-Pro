package com.dzt.job_card.Models;

import java.util.Date;

public class FieldEntry {

    private int jobId;
    private int jobNumber;
    private String crewName1;
    private String crewName2;
    private String crewName3;
    private Date entryDate;
    private int hoursWorked;
    private int minutesWorked;

    // add start time and end time

    public FieldEntry(){}

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getCrewName1() {
        return crewName1;
    }

    public void setCrewName1(String crewName1) {
        this.crewName1 = crewName1;
    }

    public String getCrewName2() {
        return crewName2;
    }

    public void setCrewName2(String crewName2) {
        this.crewName2 = crewName2;
    }

    public String getCrewName3() {
        return crewName3;
    }

    public void setCrewName3(String crewName3) {
        this.crewName3 = crewName3;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getMinutesWorked() {
        return minutesWorked;
    }

    public void setMinutesWorked(int minutesWorked) {
        this.minutesWorked = minutesWorked;
    }

}
