

CREATE TABLE parent
(
    parentId       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    parentName    VARCHAR(100) NOT NULL,
    parentSurname VARCHAR(100) NOT NULL,
    parentEmail    VARCHAR(100),
    parentPhone  VARCHAR(13)
);

