CREATE TABLE PARTICIPANT (
  reference_id        VARCHAR PRIMARY KEY,
  name                VARCHAR NOT NULL,
  date_of_birth       DATE NOT NULL,
  phone_number        VARCHAR NOT NULL,
  address             VARCHAR NOT NULL,
  date_created        TIMESTAMPTZ DEFAULT NOW() NOT NULL
);

CREATE INDEX participant_reference on PARTICIPANT(reference_id);
