use finalProject;

-- Drop tables if they exist
DROP TABLE IF EXISTS student_parent;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS parent;
DROP TABLE IF EXISTS class_room;
DROP TABLE IF EXISTS teacher;

-- Create Teachers table
CREATE TABLE teacher (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    teacher_name VARCHAR(255) NOT NULL,
    teacher_surname VARCHAR(255) NOT NULL
);

-- Create ClassRooms table
CREATE TABLE class_room (
    class_room_id INT AUTO_INCREMENT PRIMARY KEY,
    class_room_name VARCHAR(255) NOT NULL,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

-- Create Students table
CREATE TABLE student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(255) NOT NULL,
    student_surname VARCHAR(255) NOT NULL,
    class_room_id INT,
    FOREIGN KEY (class_room_id) REFERENCES class_room(class_room_id)
);

-- Create Parents table
CREATE TABLE parent (
    parent_id INT AUTO_INCREMENT PRIMARY KEY,
    parent_name VARCHAR(255) NOT NULL,
    parent_surname VARCHAR(255) NOT NULL,
    parent_email VARCHAR(255),
    parent_phone VARCHAR(255)
);

-- Create student_parent table for Many-to-Many relationship
CREATE TABLE student_parent (
    student_id INT,
    parent_id INT,
    PRIMARY KEY (student_id, parent_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (parent_id) REFERENCES parent(parent_id)
);

-- Insert data into Teachers table
INSERT INTO teacher (teacher_name, teacher_surname) VALUES
('John', 'Doe'),
('Jane', 'Smith');

-- Insert data into ClassRooms table
INSERT INTO class_room (class_room_name, teacher_id) VALUES
('Math 101', 1),
('Science 102', 2);

-- Insert data into Students table
INSERT INTO student (student_name, student_surname, class_room_id) VALUES
('Alice', 'Johnson', 1),
('Bob', 'Brown', 1),
('Charlie', 'Davis', 2);

-- Insert data into Parents table
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone) VALUES
('Michael', 'Johnson', 'michael.johnson@example.com', '555-1234'),
('Emily', 'Brown', 'emily.brown@example.com', '555-5678'),
('David', 'Davis', 'david.davis@example.com', '555-8765');

-- Insert data into student_parent table
INSERT INTO student_parent (student_id, parent_id) VALUES
(1, 1), -- Alice's parent
(2, 1), -- Bob's parent
(3, 3); -- Charlie's parent
