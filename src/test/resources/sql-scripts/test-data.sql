DROP TABLE IF EXISTS movies;

CREATE TABLE IF NOT EXISTS movies(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
minutes INT NOT NULL,
genre VARCHAR(50) NOT NULL
);

insert into movies(name, minutes, genre) values('Dark knight', 152, 'ACTION');
insert into movies(name, minutes, genre) values('Memento', 113, 'THRILLER');
insert into movies(name, minutes, genre) values('Matrix', 136,'ACTION');


