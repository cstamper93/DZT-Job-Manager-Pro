package com.dzt.job_card.Models;

import java.util.Date;

public class JobCard {

    private int jobNumber;
    private String clientName;
    private int phoneNumber;
    private int altPhoneNumber;
    private String clientEmail;
    private String altEmail;
    private String jobAddress;
    private String jobType;
    private String jobStatus;
    private Date completeBy;

    public JobCard(){}

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAltPhoneNumber() {
        return altPhoneNumber;
    }

    public void setAltPhoneNumber(int altPhoneNumber) {
        this.altPhoneNumber = altPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(Date completeBy) {
        this.completeBy = completeBy;
    }

}
