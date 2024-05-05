CREATE TABLE IF NOT EXISTS notes
(
    ID            INT AUTO_INCREMENT PRIMARY KEY,
    header_note   varchar(40) NOT NULL,
    body_note     varchar(max) NOT NULL,
    dt_created    TIMESTAMP
);