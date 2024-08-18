USE defaultdb;

CREATE TABLE user
(
    user_id      INT AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    email        VARCHAR(50) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    role         VARCHAR(50) NOT NULL

);

-- Insert data into Teachers table
INSERT INTO user (user_id, first_name, last_name, email, password, role) VALUES
(1, 'John', 'Doe', 'John.Doe@seznam.cz', 'Pasword1', 'USER'),
(2, 'Jane', 'Smith', 'Jane.Smith@seznam.cz', 'Pasword1', 'ADMIN');
