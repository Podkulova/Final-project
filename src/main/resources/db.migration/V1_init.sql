CREATE TABLE teacher
(
    teacherId       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    teacherName    VARCHAR(100) NOT NULL,
    teacherSurname VARCHAR(100) NOT NULL
);

CREATE TABLE classRoom
(
    ClassRoomId               INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    classRoomName            VARCHAR(4) NOT NULL UNIQUE,
    teacher_id INTEGER    NOT NULL UNIQUE,
    FOREIGN KEY (teacher_id) REFERENCES teacher (teacherId)
);

CREATE TABLE student
(
    studentId       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    studentName    VARCHAR(100) NOT NULL,
    studentSurname VARCHAR(100) NOT NULL,
    classRoom_id SMALLINT     NOT NULL,
    FOREIGN KEY (classRoom_id) REFERENCES classRoom (classRoomId)
);

CREATE TABLE parent
(
    parentId       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    parentName    VARCHAR(100) NOT NULL,
    parentSurname VARCHAR(100) NOT NULL,
    parentEmail    VARCHAR(100),
    parentPhone  VARCHAR(13)
);

CREATE TABLE student_parent
(
    student_id INTEGER NOT NULL,
    parent_id   INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (studentId),
    FOREIGN KEY (parent_id) REFERENCES parent (parentId),
    UNIQUE (student_id, parent_id)
);



CREATE INDEX ON teacher (teacherSurname, teacherName);
CREATE INDEX ON student (studentSurname, studentName);
CREATE INDEX ON parent (parentSurname, parentName);
CREATE INDEX ON classRoom (classRoomName);
CREATE INDEX ON classRoom (teacher_id);
CREATE INDEX ON student (classRoom_id, studentSurname, studentName);
CREATE INDEX ON student_parent (student_id);
CREATE INDEX ON student_parent (parent_id);
