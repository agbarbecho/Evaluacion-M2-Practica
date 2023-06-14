CREATE TABLE IF NOT EXISTS conference(
    id SERIAL,
    tittle VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    assistants INT NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS assistant(
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    conference_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (conference_id) REFERENCES conference(id)
    );
