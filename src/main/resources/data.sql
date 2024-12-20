INSERT INTO student (name, age, grade) VALUES
                                           ('John Doe', 15, '9th'),
                                           ('Jane Smith', 16, '10th'),
                                           ('Bob Johnson', 14, '8th');

INSERT INTO teacher (name, subject) VALUES
                                        ('Mr. Anderson', 'Mathematics'),
                                        ('Mrs. Brown', 'English'),
                                        ('Mr. Wilson', 'Science');

INSERT INTO student_teacher (student_id, teacher_id) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 2),
                                                         (2, 3),
                                                         (3, 1),
                                                         (3, 3);