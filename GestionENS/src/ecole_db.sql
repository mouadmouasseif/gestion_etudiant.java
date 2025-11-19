-- 1. Création de la base de données
CREATE DATABASE IF NOT EXISTS ecole_db;
USE ecole_db;

-- 2. Table des étudiants
CREATE TABLE etudiants (
    id_etudiant INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    date_naissance DATE,
    email VARCHAR(100) UNIQUE,
    date_inscription DATE DEFAULT CURRENT_DATE
);

-- 3. Table des professeurs
CREATE TABLE professeurs (
    id_prof INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- 4. Table des matières
CREATE TABLE matieres (
    id_matiere INT AUTO_INCREMENT PRIMARY KEY,
    nom_matiere VARCHAR(50) NOT NULL,
    description TEXT
);

-- 5. Table des cours (relation professeur - matière)
CREATE TABLE cours (
    id_cours INT AUTO_INCREMENT PRIMARY KEY,
    id_prof INT NOT NULL,
    id_matiere INT NOT NULL,
    salle VARCHAR(20),
    horaire TIME,
    FOREIGN KEY (id_prof) REFERENCES professeurs(id_prof) ON DELETE CASCADE,
    FOREIGN KEY (id_matiere) REFERENCES matieres(id_matiere) ON DELETE CASCADE
);

-- 6. Table des inscriptions (relation étudiant - cours)
CREATE TABLE inscriptions (
    id_inscription INT AUTO_INCREMENT PRIMARY KEY,
    id_etudiant INT NOT NULL,
    id_cours INT NOT NULL,
    date_inscription DATE DEFAULT CURRENT_DATE,
    note DECIMAL(5,2),
    FOREIGN KEY (id_etudiant) REFERENCES etudiants(id_etudiant) ON DELETE CASCADE,
    FOREIGN KEY (id_cours) REFERENCES cours(id_cours) ON DELETE CASCADE
);

-- 7. Table des examens
CREATE TABLE examens (
    id_examen INT AUTO_INCREMENT PRIMARY KEY,
    id_cours INT NOT NULL,
    date_examen DATE NOT NULL,
    type_examen ENUM('Controle','Partiel','Final') DEFAULT 'Controle',
    FOREIGN KEY (id_cours) REFERENCES cours(id_cours) ON DELETE CASCADE
);

-- 8. Table des résultats (relation étudiant - examen)
CREATE TABLE resultats (
    id_resultat INT AUTO_INCREMENT PRIMARY KEY,
    id_etudiant INT NOT NULL,
    id_examen INT NOT NULL,
    note DECIMAL(5,2),
    FOREIGN KEY (id_etudiant) REFERENCES etudiants(id_etudiant) ON DELETE CASCADE,
    FOREIGN KEY (id_examen) REFERENCES examens(id_examen) ON DELETE CASCADE
);

-- 9. Insertion de données exemples

-- Étudiants
INSERT INTO etudiants (nom, prenom, date_naissance, email)
VALUES
('Doe', 'John', '2002-05-12', 'john.doe@example.com'),
('Smith', 'Anna', '2003-07-20', 'anna.smith@example.com');

-- Professeurs
INSERT INTO professeurs (nom, prenom, email)
VALUES
('Dupont', 'Pierre', 'pierre.dupont@example.com'),
('Martin', 'Sophie', 'sophie.martin@example.com');

-- Matières
INSERT INTO matieres (nom_matiere, description)
VALUES
('Mathématiques', 'Cours de mathématiques de base et avancé'),
('Physique', 'Cours de physique appliquée');

-- Cours
INSERT INTO cours (id_prof, id_matiere, salle, horaire)
VALUES
(1, 1, 'A101', '08:00:00'),
(2, 2, 'B202', '10:00:00');

-- Inscriptions
INSERT INTO inscriptions (id_etudiant, id_cours)
VALUES
(1, 1),
(1, 2),
(2, 1);

-- Examens
INSERT INTO examens (id_cours, date_examen, type_examen)
VALUES
(1, '2025-12-15', 'Partiel'),
(2, '2025-12-18', 'Final');

-- Résultats
INSERT INTO resultats (id_etudiant, id_examen, note)
VALUES
(1, 1, 15.50),
(1, 2, 18.00),
(2, 1, 12.75);
