DROP TABLE IF EXISTS student_teacher;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;

CREATE TABLE IF NOT EXISTS student (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       age INTEGER NOT NULL,
                                       grade VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS teacher (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       subject VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS student_teacher (
                                               id SERIAL PRIMARY KEY,
                                               student_id INTEGER REFERENCES student(id),
                                               teacher_id INTEGER REFERENCES teacher(id)
);