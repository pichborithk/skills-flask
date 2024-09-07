DROP TABLE IF EXISTS users_courses;
DROP TABLE IF EXISTS lectures;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

-- Roles Table
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Users Table: Many-to-One with roles
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) REFERENCES roles(name) DEFAULT 'USER'
);

-- Items Table: Many-to-One with users
CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    instructor_id INTEGER REFERENCES users(user_id)
);

CREATE TABLE users_courses (
    user_id INTEGER REFERENCES users(user_id),
    course_id INTEGER REFERENCES courses(course_id),
    PRIMARY KEY (user_id, course_id)
);

CREATE TABLE sections (
    section_id SERIAL PRIMARY KEY,
    sequence INTEGER,
    title VARCHAR(255) NOT NULL,
    course_id INTEGER REFERENCES courses(course_id)
);

CREATE TABLE lectures (
    lecture_id SERIAL PRIMARY KEY,
    sequence INTEGER,
    title VARCHAR(255) NOT NULL,
    length INTEGER NOT NULL,
    section_id INTEGER REFERENCES sections(section_id)
);