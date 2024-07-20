INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Karolína', 'Nováková');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Petra', 'Veselá');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Anna', 'Dvořáková');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Martin', 'Procházka');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Pavlína', 'Svobodová');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Lucie', 'Novotná');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Tomáš', 'Kříž');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Veronika', 'Malá');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Daniel', 'Horák');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Markéta', 'Šťastná');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Vojtěch', 'Kučera');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Kateřina', 'Němcová');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Ondřej', 'Pospíšil');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Adéla', 'Malíková');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Filip', 'Navrátil');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Ivana', 'Nová');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Marek', 'Kocourek');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Simona', 'Hájková');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Jakub', 'Kadeřábek');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Michaela', 'Kratochvílová');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Petr', 'Černý');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Lenka', 'Adamcová');
INSERT INTO teacher (teacher_name, teacher_surname)
VALUES ('Dominik', 'Novák');


INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('6.B', 12);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('7.B', 14);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('8.B', 16);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('5.A', 9);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('8.A', 15);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('9.B', 18);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('4.A', 7);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('1.A', 1);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('5.B', 10);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('9.A', 17);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('3.B', 6);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('6.A', 11);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('7.A', 13);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('2.B', 4);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('3.A', 5);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('4.B', 8);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('2.A', 3);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('1.B', 2);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Netřídní učitel', 19);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Netřídní učitel', 20);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Asistent třídy', 21);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Asistentka třídy', 22);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Asistent třídy', 23);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Asistentka třídy', 24);

INSERT INTO class_room (class_room_name, teacher_id)
VALUES ('Asistent třídy', 25);

-- studenti a rodiče



/*DELETE FROM student WHERE student_id = 19;
DELETE FROM parent WHERE parent_id = 8;*/




INSERT INTO student (student_name, student_surname, class_room_id)
VALUES ('Jan', 'Polák', 19);
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone)
VALUES ('Adam', 'Polák', 'adam.polak@example.com', '+420987456123');
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone)
VALUES ('Petra', 'Poláková', 'petra.polakova@example.com', '+420603603985');
INSERT INTO student_parent (student_id, parent_id)
VALUES (18, 9);
INSERT INTO student_parent (student_id, parent_id)
VALUES (18, 10);

INSERT INTO student (student_name, student_surname, class_room_id)
VALUES ('Anežka', 'Malá', 19);
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone)
VALUES ('Tomáš', 'Malej', 'tomas.malej@example.com', '+420603456123');
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone)
VALUES ('Alice', 'Malá', 'alice.mala@example.com', '+420604603985');
INSERT INTO student_parent (student_id, parent_id)
VALUES (20, 11);
INSERT INTO student_parent (student_id, parent_id)
VALUES (20, 12);