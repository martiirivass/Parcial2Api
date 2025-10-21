-- Profesores
INSERT INTO profesor (nombre, email) VALUES ('Carlos Gómez', 'carlos.gomez@gmail.com');
INSERT INTO profesor (nombre, email) VALUES ('Laura Fernández', 'laura.fernandez@gmail.com');

-- Estudiantes
INSERT INTO estudiante (nombre, matricula) VALUES ('Martín Pérez', 'MAT001');
INSERT INTO estudiante (nombre, matricula) VALUES ('Lucía Ramírez', 'MAT002');
INSERT INTO estudiante (nombre, matricula) VALUES ('Julián Torres', 'MAT003');

-- Cursos
INSERT INTO curso (nombre, profesor_id) VALUES ('Programación I', 1);
INSERT INTO curso (nombre, profesor_id) VALUES ('Base de Datos', 2);

-- Relación muchos a muchos (tabla intermedia)
INSERT INTO curso_estudiante (curso_id, estudiante_id) VALUES (1, 1);
INSERT INTO curso_estudiante (curso_id, estudiante_id) VALUES (1, 2);
INSERT INTO curso_estudiante (curso_id, estudiante_id) VALUES (2, 2);
INSERT INTO curso_estudiante (curso_id, estudiante_id) VALUES (2, 3);
