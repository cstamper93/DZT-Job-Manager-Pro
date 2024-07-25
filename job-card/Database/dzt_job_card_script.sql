BEGIN TRANSACTION;

DROP TABLE IF EXISTS job_card, field_entry;

CREATE TABLE job_card(
    job_number INTEGER, --maybe serial?? Probs not but maybe they want to give it the next available job number...
    client_name VARCHAR(100),
    phone_number INTEGER,
    alt_phone_number INTEGER,
    client_email VARCHAR(150),
    alt_email VARCHAR(150),
    job_address VARCHAR(200),
    job_type VARCHAR(50),
    job_status VARCHAR(50),
    complete_by DATE,
    CONSTRAINT PK_job_card PRIMARY KEY(job_number)
);

CREATE TABLE field_entry(
    job_number INTEGER,
    crewName1 VARCHAR(100),
    crewName2 VARCHAR(100),
    crewName3 VARCHAR(100),
    entry_date DATE,
    hours_worked INTEGER,
    minutes_worked INTEGER,
    CONSTRAINT PK_field_entry PRIMARY KEY(job_number, crewName1, entry_date),
    CONSTRAINT FK_field_entry_job_card FOREIGN KEY (job_number) REFERENCES job_card(job_number)
);

COMMIT;