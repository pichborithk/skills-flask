DROP TABLE IF EXISTS courses;


CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    price DECIMAL(10, 2),
    author_id VARCHAR(255) NOT NUll
)
