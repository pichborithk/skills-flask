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


INSERT INTO sections (sequence, title, course_id)
    VALUES (1, 'Java Basics', 1),
           (2, 'OOP in Java', 1),
           (3, 'Java Data Types', 1),
           (4, 'Exception Handling in Java', 1),
           (1, 'Introduction to Python', 2),
           (2, 'Python Advanced Topics', 2),
           (3, 'Python File Handling', 2),
           (4, 'Decorators and Generators', 2),
           (1, 'React Components', 3),
           (2, 'State and Props in React', 3),
           (3, 'React Lifecycle Methods', 3),
           (4, 'React Hooks', 3),
           (1, 'Data Science Overview', 4),
           (2, 'R for Data Analysis', 4),
           (3, 'Data Wrangling in R', 4),
           (4, 'Data Visualization with ggplot2', 4),
           (1, 'Introduction to Machine Learning', 5),
           (2, 'Supervised Learning', 5),
           (3, 'Unsupervised Learning', 5),
           (4, 'Model Evaluation Techniques', 5),
           (1, 'Database Basics', 6),
           (2, 'PostgreSQL Queries', 6),
           (3, 'Advanced PostgreSQL Queries', 6),
           (4, 'Indexing and Optimization', 6),
           (1, 'AWS Overview', 7),
           (2, 'Deploying on AWS', 7),
           (3, 'AWS S3 Basics', 7),
           (4, 'AWS EC2 Overview', 7),
           (1, 'Introduction to Swift', 8),
           (2, 'Swift UI Basics', 8),
           (3, 'Swift Networking', 8),
           (4, 'Core Data with Swift', 8);


-- For Java Basics (Section 1)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'What is Java?', 10, 1),
(2, 'Setting up Java Environment', 12, 1),
(3, 'First Java Program', 8, 1),
(4, 'Variables and Data Types', 15, 1);

-- For OOP in Java (Section 2)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Introduction to OOP', 14, 2),
(2, 'Classes and Objects in Java', 18, 2),
(3, 'Inheritance and Polymorphism', 20, 2),
(4, 'Encapsulation and Abstraction', 16, 2);

-- For Introduction to Python (Section 3)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Installing Python', 9, 3),
(2, 'Basic Python Syntax', 12, 3),
(3, 'Python Variables', 10, 3),
(4, 'Loops in Python', 13, 3);

-- For Python Advanced Topics (Section 4)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Functions in Python', 18, 4),
(2, 'Working with Modules', 14, 4),
(3, 'Error Handling in Python', 20, 4),
(4, 'Regular Expressions', 17, 4);

-- For React Components (Section 5)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Introduction to React Components', 11, 5),
(2, 'Functional vs Class Components', 15, 5),
(3, 'Component Lifecycle', 18, 5),
(4, 'Building Reusable Components', 14, 5);

-- For State and Props in React (Section 6)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Understanding Props', 12, 6),
(2, 'Managing State in React', 16, 6),
(3, 'State Lifecycle', 13, 6),
(4, 'Lifting State Up', 14, 6);

-- For Data Science Overview (Section 7)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'What is Data Science?', 20, 7),
(2, 'Data Science in Business', 18, 7),
(3, 'Key Skills in Data Science', 15, 7),
(4, 'Challenges in Data Science', 17, 7);

-- For R for Data Analysis (Section 8)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Introduction to R', 14, 8),
(2, 'Data Structures in R', 16, 8),
(3, 'Data Manipulation with dplyr', 19, 8),
(4, 'Plotting with ggplot2', 22, 8);

-- For Introduction to Machine Learning (Section 9)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'What is Machine Learning?', 12, 9),
(2, 'Supervised vs Unsupervised Learning', 18, 9),
(3, 'Key ML Algorithms', 20, 9),
(4, 'Bias-Variance Tradeoff', 17, 9);

-- For Supervised Learning (Section 10)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Linear Regression', 14, 10),
(2, 'Logistic Regression', 16, 10),
(3, 'Decision Trees', 19, 10),
(4, 'Support Vector Machines', 20, 10);

-- For Database Basics (Section 11)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Introduction to Databases', 13, 11),
(2, 'SQL Basics', 16, 11),
(3, 'Database Relationships', 14, 11),
(4, 'Database Normalization', 15, 11);

-- For PostgreSQL Queries (Section 12)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Basic SELECT Queries', 12, 12),
(2, 'JOINs in PostgreSQL', 14, 12),
(3, 'GROUP BY and HAVING', 15, 12),
(4, 'Subqueries', 17, 12);

-- For AWS Overview (Section 13)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'What is AWS?', 15, 13),
(2, 'AWS Global Infrastructure', 18, 13),
(3, 'AWS Services Overview', 22, 13),
(4, 'AWS Pricing Model', 16, 13);

-- For Deploying on AWS (Section 14)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Deploying Web Apps on EC2', 20, 14),
(2, 'Deploying with Elastic Beanstalk', 18, 14),
(3, 'Continuous Deployment with AWS CodePipeline', 22, 14),
(4, 'Setting Up Auto Scaling', 19, 14);

-- For Introduction to Swift (Section 15)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Swift Basics', 10, 15),
(2, 'Variables and Constants in Swift', 12, 15),
(3, 'Control Flow in Swift', 14, 15),
(4, 'Functions in Swift', 13, 15);

-- For Swift UI Basics (Section 16)
INSERT INTO lectures (sequence, title, length, section_id) VALUES
(1, 'Introduction to SwiftUI', 16, 16),
(2, 'Building Views with SwiftUI', 18, 16),
(3, 'Handling User Input in SwiftUI', 17, 16),
(4, 'State and Binding in SwiftUI', 19, 16);
