CREATE TABLE PARTICIPANT (
  id                  BIGSERIAL PRIMARY KEY,
  reference_number    VARCHAR NOT NULL UNIQUE,
  name                VARCHAR NOT NULL,
  date_of_birth       DATE NOT NULL,
  phone_number        VARCHAR NOT NULL,
  address             VARCHAR NOT NULL,
  modified_date       TIMESTAMPTZ,
  created_date        TIMESTAMPTZ DEFAULT NOW() NOT NULL
);

CREATE INDEX participant_reference on PARTICIPANT(reference_number);
