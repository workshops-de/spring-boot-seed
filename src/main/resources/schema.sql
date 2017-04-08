CREATE TABLE IF NOT EXISTS publishers (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(512),
  url VARCHAR(8192)
);

CREATE TABLE IF NOT EXISTS books (
  id INTEGER IDENTITY PRIMARY KEY,
  title VARCHAR(512),
  subtitle VARCHAR(512),
  isbn VARCHAR(512),
  abstract_text VARCHAR(16384),
  num_pages INTEGER,
  author VARCHAR(2048),
  publisher_id INTEGER NOT NULL,
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);
