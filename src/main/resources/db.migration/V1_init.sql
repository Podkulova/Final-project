CREATE TABLE teacher
(
    teacherId       INT AUTO_INCREMENT PRIMARY KEY,
    teacherName     VARCHAR(100) NOT NULL,
    teacherSurname  VARCHAR(100) NOT NULL
);

CREATE TABLE classRoom
(
    classRoomId    INT AUTO_INCREMENT PRIMARY KEY,
    classRoomName  VARCHAR(4) NOT NULL UNIQUE,
    teacher_id     INT NOT NULL UNIQUE,
    FOREIGN KEY (teacher_id) REFERENCES teacher (teacherId)
);

CREATE TABLE student
(
    studentId       INT AUTO_INCREMENT PRIMARY KEY,
    studentName     VARCHAR(100) NOT NULL,
    studentSurname  VARCHAR(100) NOT NULL,
    classRoom_id    INT NOT NULL,
    FOREIGN KEY (classRoom_id) REFERENCES classRoom (classRoomId)
);

CREATE TABLE parent
(
    parentId        INT AUTO_INCREMENT PRIMARY KEY,
    parentName      VARCHAR(100) NOT NULL,
    parentSurname   VARCHAR(100) NOT NULL,
    parentEmail     VARCHAR(100),
    parentPhone     VARCHAR(13)
);

CREATE TABLE student_parent
(
    student_id  INT NOT NULL,
    parent_id   INT NOT NULL,
    PRIMARY KEY (student_id, parent_id),
    FOREIGN KEY (student_id) REFERENCES student (studentId),
    FOREIGN KEY (parent_id) REFERENCES parent (parentId)
);




CREATE INDEX idx_teacher_name_surname ON teacher (teacherSurname, teacherName);
CREATE INDEX idx_student_surname_name ON student (studentSurname, studentName);
CREATE INDEX idx_parent_surname_name ON parent (parentSurname, parentName);
CREATE INDEX idx_classRoom_name ON classRoom (classRoomName);
CREATE INDEX idx_classRoom_teacher_id ON classRoom (teacher_id);
CREATE INDEX idx_student_classRoom_id_surname_name ON student (classRoom_id, studentSurname, studentName);
CREATE INDEX idx_student_parent_student_id ON student_parent (student_id);
CREATE INDEX idx_student_parent_parent_id ON student_parent (parent_id);
