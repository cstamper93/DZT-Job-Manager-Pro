BEGIN TRANSACTION;

INSERT INTO job_card (job_number, client_name, phone_number,
    alt_phone_number, client_email, alt_email, job_address,
    job_type, job_status, complete_by) VALUES (2250, 'John Doe',
    '9102223333', '9103334444', 'johndoe@yahoo.com', 'janedoe@yahoo.com',
    '123 Street Name St, City, NC, 27272', 'Field Survey', 'Not started',
    TO_DATE('09/05/2024', 'MM/DD/YYYY'));

INSERT INTO job_card (job_number, client_name, phone_number,
    alt_phone_number, client_email, job_address,
    job_type, job_status, complete_by) VALUES (2251, 'Fartell Cluggins',
    '9101234567', '9107654321', 'fcluggins@google.com',
    '123 Avenue Name Ave, Clugginsville, NC, 27276', 'Construction Staking',
    'In progress', TO_DATE('09/27/2025', 'MM/DD/YYYY'));

    INSERT INTO job_card (job_number, client_name, phone_number,
        alt_phone_number, client_email, alt_email, job_address,
        job_type, job_status, complete_by) VALUES (2250, 'Cooper',
        '9101212121', '9102323232', 'cooper@yahoo.com', 'tars@yahoo.com',
        '123 Street Name St, Mars, NC, 27272', 'Existing Parcel', 'Finished',
        TO_DATE('10/05/2025', 'MM/DD/YYYY'));

COMMIT TRANSACTION;