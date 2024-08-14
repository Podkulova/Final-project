DROP TABLE IF EXISTS student_parent;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS parent;
DROP TABLE IF EXISTS class_room;
DROP TABLE IF EXISTS teacher;

CREATE TABLE teacher
(
    teacher_id       INT AUTO_INCREMENT PRIMARY KEY,
    teacher_name     VARCHAR(100) NOT NULL,
    teacher_surname  VARCHAR(100) NOT NULL
);

CREATE TABLE class_room
(
    class_room_id    INT AUTO_INCREMENT PRIMARY KEY,
    class_room_name  VARCHAR(40) NOT NULL UNIQUE,
    teacher_id     INT UNIQUE,
    FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id)
);

CREATE TABLE student
(
    student_id       INT AUTO_INCREMENT PRIMARY KEY,
    student_name     VARCHAR(100) NOT NULL,
    student_surname  VARCHAR(100) NOT NULL,
    class_room_id    INT NOT NULL,
    FOREIGN KEY (class_room_id) REFERENCES class_room (class_room_id)
);

CREATE TABLE parent
(
    parent_id        INT AUTO_INCREMENT PRIMARY KEY,
    parent_name      VARCHAR(100) NOT NULL,
    parent_surname   VARCHAR(100) NOT NULL,
    parent_email     VARCHAR(100),
    parent_phone     VARCHAR(13)
);

CREATE TABLE student_parent
(
    student_id  INT NOT NULL,
    parent_id   INT NOT NULL,
    PRIMARY KEY (student_id, parent_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (parent_id) REFERENCES parent (parent_id)
);

CREATE INDEX idx_teacher_name_surname ON teacher (teacher_surname, teacher_name);
CREATE INDEX idx_student_surname_name ON student (student_surname, student_name);
CREATE INDEX idx_parent_surname_name ON parent (parent_surname, parent_name);
CREATE INDEX idx_classRoom_name ON class_room (class_room_name);
CREATE INDEX idx_classRoom_teacher_id ON class_room (teacher_id);
CREATE INDEX idx_student_classRoom_id_surname_name ON student (class_room_id, student_surname, student_name);
CREATE INDEX idx_student_parent_student_id ON student_parent (student_id);
CREATE INDEX idx_student_parent_parent_id ON student_parent (parent_id);
