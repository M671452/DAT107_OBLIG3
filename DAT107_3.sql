CREATE TABLE Ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(10) UNIQUE,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansettelsesdato DATE,
    stilling VARCHAR(50),
    maanedslonn DECIMAL(10, 2),
    avdeling_id INT REFERENCES Avdeling(avdeling_id)
);

CREATE TABLE Avdeling (
    avdeling_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    sjef_ansatt_id INT REFERENCES Ansatt(ansatt_id)
);

CREATE TABLE Prosjekt (
    prosjekt_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    beskrivelse TEXT
);
