-- Insert Roles
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('INSTRUCTOR');
INSERT INTO roles (name) VALUES ('ADMIN');


INSERT INTO users (username, password, role)
    VALUES ('will', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2', 'INSTRUCTOR'),
           ('nick', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2', 'USER'),
           ('david', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2', 'INSTRUCTOR'),
           ('bo', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2', 'ADMIN');


INSERT INTO courses (title, price, instructor_id)
    VALUES ('Introduction to Java', 99.99, 1),
           ('Advanced Python', 149.99, 1),
           ('Web Development with React', 199.99, 1),
           ('Data Science with R', 249.99, 1),
           ('Machine Learning Basics', 299.99, 3),
           ('Database Management with PostgreSQL', 129.99, 3),
           ('Cloud Computing with AWS', 199.99, 3),
           ('Mobile App Development with Swift', 179.99, 3);


INSERT INTO sections (title, course_id)
    VALUES ('Java Basics', 1),
           ('OOP in Java', 1),
           ('Java Data Types', 1),
           ('Exception Handling in Java', 1),
           ('Introduction to Python', 2),
           ('Python Advanced Topics', 2),
           ('Python File Handling', 2),
           ('Decorators and Generators', 2),
           ('React Components', 3),
           ('State and Props in React', 3),
           ('React Lifecycle Methods', 3),
           ('React Hooks', 3),
           ('Data Science Overview', 4),
           ('R for Data Analysis', 4),
           ('Data Wrangling in R', 4),
           ('Data Visualization with ggplot2', 4),
           ('Introduction to Machine Learning', 5),
           ('Supervised Learning', 5),
           ('Unsupervised Learning', 5),
           ('Model Evaluation Techniques', 5),
           ('Database Basics', 6),
           ('PostgreSQL Queries', 6),
           ('Advanced PostgreSQL Queries', 6),
           ('Indexing and Optimization', 6),
           ('AWS Overview', 7),
           ('Deploying on AWS', 7),
           ('AWS S3 Basics', 7),
           ('AWS EC2 Overview', 7),
           ('Introduction to Swift', 8),
           ('Swift UI Basics', 8),
           ('Swift Networking', 8),
           ('Core Data with Swift', 8);


-- For Java Basics (Section 1)
INSERT INTO lectures (title, length, section_id) VALUES
('What is Java?', 10, 1),
('Setting up Java Environment', 12, 1),
('First Java Program', 8, 1),
('Variables and Data Types', 15, 1);

-- For OOP in Java (Section 2)
INSERT INTO lectures (title, length, section_id) VALUES
('Introduction to OOP', 14, 2),
('Classes and Objects in Java', 18, 2),
('Inheritance and Polymorphism', 20, 2),
('Encapsulation and Abstraction', 16, 2);

-- For Introduction to Python (Section 3)
INSERT INTO lectures (title, length, section_id) VALUES
('Installing Python', 9, 3),
('Basic Python Syntax', 12, 3),
('Python Variables', 10, 3),
('Loops in Python', 13, 3);

-- For Python Advanced Topics (Section 4)
INSERT INTO lectures (title, length, section_id) VALUES
('Functions in Python', 18, 4),
('Working with Modules', 14, 4),
('Error Handling in Python', 20, 4),
('Regular Expressions', 17, 4);

-- For React Components (Section 5)
INSERT INTO lectures (title, length, section_id) VALUES
('Introduction to React Components', 11, 5),
('Functional vs Class Components', 15, 5),
('Component Lifecycle', 18, 5),
('Building Reusable Components', 14, 5);

-- For State and Props in React (Section 6)
INSERT INTO lectures (title, length, section_id) VALUES
('Understanding Props', 12, 6),
('Managing State in React', 16, 6),
('State Lifecycle', 13, 6),
('Lifting State Up', 14, 6);

-- For Data Science Overview (Section 7)
INSERT INTO lectures (title, length, section_id) VALUES
('What is Data Science?', 20, 7),
('Data Science in Business', 18, 7),
('Key Skills in Data Science', 15, 7),
('Challenges in Data Science', 17, 7);

-- For R for Data Analysis (Section 8)
INSERT INTO lectures (title, length, section_id) VALUES
('Introduction to R', 14, 8),
('Data Structures in R', 16, 8),
('Data Manipulation with dplyr', 19, 8),
('Plotting with ggplot2', 22, 8);

-- For Introduction to Machine Learning (Section 9)
INSERT INTO lectures (title, length, section_id) VALUES
('What is Machine Learning?', 12, 9),
('Supervised vs Unsupervised Learning', 18, 9),
('Key ML Algorithms', 20, 9),
('Bias-Variance Tradeoff', 17, 9);

-- For Supervised Learning (Section 10)
INSERT INTO lectures (title, length, section_id) VALUES
('Linear Regression', 14, 10),
('Logistic Regression', 16, 10),
('Decision Trees', 19, 10),
('Support Vector Machines', 20, 10);

-- For Database Basics (Section 11)
INSERT INTO lectures (title, length, section_id) VALUES
('Introduction to Databases', 13, 11),
('SQL Basics', 16, 11),
('Database Relationships', 14, 11),
('Database Normalization', 15, 11);

-- For PostgreSQL Queries (Section 12)
INSERT INTO lectures (title, length, section_id) VALUES
('Basic SELECT Queries', 12, 12),
('JOINs in PostgreSQL', 14, 12),
('GROUP BY and HAVING', 15, 12),
('Subqueries', 17, 12);

-- For AWS Overview (Section 13)
INSERT INTO lectures (title, length, section_id) VALUES
('What is AWS?', 15, 13),
('AWS Global Infrastructure', 18, 13),
('AWS Services Overview', 22, 13),
('AWS Pricing Model', 16, 13);

-- For Deploying on AWS (Section 14)
INSERT INTO lectures (title, length, section_id) VALUES
('Deploying Web Apps on EC2', 20, 14),
('Deploying with Elastic Beanstalk', 18, 14),
('Continuous Deployment with AWS CodePipeline', 22, 14),
('Setting Up Auto Scaling', 19, 14);

-- For Introduction to Swift (Section 15)
INSERT INTO lectures (title, length, section_id) VALUES
('Swift Basics', 10, 15),
('Variables and Constants in Swift', 12, 15),
('Control Flow in Swift', 14, 15),
('Functions in Swift', 13, 15);

-- For Swift UI Basics (Section 16)
INSERT INTO lectures (title, length, section_id) VALUES
('Introduction to SwiftUI', 16, 16),
('Building Views with SwiftUI', 18, 16),
('Handling User Input in SwiftUI', 17, 16),
('State and Binding in SwiftUI', 19, 16);