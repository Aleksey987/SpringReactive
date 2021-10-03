DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS professors;

create table courses
(
    id   integer not null,
    name varchar(255),
    primary key (id)
);
create table professors
(
    id         integer not null,
    course_id  integer not null,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);
create table students
(
    id         integer not null,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

INSERT INTO courses (id, name)
VALUES (1, 'Algorithms'),
       (2, 'Computer Science');

INSERT INTO professors (id, course_id, first_name, last_name)
VALUES (1, 1, 'Bob', 'Smith'),
       (2, 2, 'Alex', 'Brown');

INSERT INTO students (id, first_name, last_name)
VALUES (1, 'James', 'Davis'),
       (2, 'Brian', 'Davis');