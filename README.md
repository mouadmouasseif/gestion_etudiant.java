# gestion_etudiant.java
project de gestion des etudiants des personnel administreateur et prof en 


Gestion des Etudiant Ecole

Java Project

MOUASSEIF MOUAD

 
Table des matières
1. Présentation du projet	1
2. Diagramme UML (texte)	2
3. Description des classes et responsabilités	3
4. Proposition de base de données relationnelle	3
5. Exemple de relations	5
6. Avantages et améliorations	6



 
1. Présentation du projet
Le projet est une application Java de gestion d’une université.
Il gère :
•	Les étudiants et leurs notes.
•	Les professeurs et les matières qu’ils enseignent.
•	Les départements avec leur chef, étudiants et professeurs.
•	Les personnels administratifs (scolarité) qui créent des emplois du temps et reçoivent les notes.
•	Les emplois du temps pour chaque département, semestre et année.
Le projet est conçu initialement en mode console, mais a été adapté pour une interface graphique Swing.

2. Diagramme UML (texte)
Version UML en texte (diagramme de classes)

Je vais te décrire ça comme si c’était un diagramme UML, mais en format texte / console.

🎯 Classes et héritage
               +------------------+
               |    Personnels    |  (classe mère)
               +------------------+
               | - LIMITE_SALARY  |
               | - salary : double|
               | - nom : String   |
               | - conges : int   |
               +------------------+
               | +get/set...      |
               +------------------+
                  ^          ^
                  |          |
        extends   |          | extends
                  |          |
+-----------------+--+   +---+------------------+
|       Prof         |   |    PersonnelsAdmin   |
+--------------------+   +----------------------+
| - departement :    |   | - role : String      |
|   Departement      |   +----------------------+
| - matiere :        |   | +creeEmploiTemps(...)|
|   ArrayList<String>|   | +informerProf(...)   |
+--------------------+   | +recevoirNotes(...)  |
| +teach(...)        |   +----------------------+
| +sendNotes(...)    |
+--------------------+

+-------------------------+
|        Etudiant         |
+-------------------------+
| - nom : String          |
| - listNumber : int      |
| - notes : ArrayList<Double> |
+-------------------------+
| +calculerBulletin()     |
+-------------------------+

+-------------------------------+
|          Departement          |
+-------------------------------+
| - nom : String                |
| - chefDepartement : String    |
| - etudiants : ArrayList<Etudiant> |
| - profs : ArrayList<Prof>     |
| - annees : ArrayList<String>  |
+-------------------------------+
| +addAnnee(...)                |
| +deleteAnnee(...)             |
| +collaborate(Departement)     |
+-------------------------------+

+---------------------------------------+
|              EmploiTemps              |
+---------------------------------------+
| - departement : Departement           |
| - semestre : String                   |
| - annee : String                      |
| - salles : ArrayList<String>          |
| - matieres : ArrayList<String>        |
| - crenaux : ArrayList<String>         |
+---------------------------------------+
 Personnels
+ nom: String
+ salary: double
+ conges: int
-----------------
+ getNom(): String
+ getSalary(): double
+ getConges(): int
+ setNom(String)
+ setSalary(double)
+ setConges(double)

   ^
   |
   |---------------------
   |                    |
Prof                  PersonnelsAdmin
+ departement: Departement  + role: String
+ matiere: ArrayList<String>
-----------------------------
+ getDepartement(): Departement
+ getMatieres(): ArrayList<String>
+ teach(ArrayList<Etudiant>)
+ sendNotes(PersonnelsAdmin)
+ informerProf(Prof,String)
+ CreeEmploiTemps(...)
+ recieveNotes(Prof)

Etudiant
+ nom: String
+ listNumber: int
+ notes: ArrayList<Double>
--------------------------
+ getNom()
+ getListNumber()
+ getNotes()
+ calculerBulletin(): double

Departement
+ nom: String
+ chefDepartement: String
+ etudiants: ArrayList<Etudiant>
+ prof: ArrayList<Prof>
+ annee: ArrayList<String>
-----------------------------------
+ addEtudiant(Etudiant)
+ addProf(Prof)
+ addAnnee(String)
+ deleteAnnee(String)
+ collaborate(Departement)
+ toString()

EmploiTemps
+ departement: Departement
+ semestre: String
+ annee: String
+ salles: ArrayList<String>
+ matieres: ArrayList<String>
+ crenaux: ArrayList<String>
-----------------------------------
+ getDepartement()
+ getSalles()
+ getMatieres()
+ getCrenaux()
+ getSemestre()
+ getAnnee()
+ toString()

Relations UML
•	Prof hérite de Personnels.
•	PersonnelsAdmin hérite de Personnels.
•	Departement contient Prof et Etudiant (composition / agrégation).
•	EmploiTemps associe un Departement.
•	Prof enseigne plusieurs Etudiant (association).
•	PersonnelsAdmin informe et reçoit notes de Prof (association).
Relations entre classes (associations)

Je te les fais en mode UML texte.

1. Héritage

Prof hérite de Personnels

Prof ─────────▷ Personnels   (extends)


PersonnelsAdmin hérite de Personnels

PersonnelsAdmin ─────────▷ Personnels   (extends)
2. Associations principales

Departement ↔ Prof

Un Departement possède une liste de profs :

Departement 1 ───── 0..* Prof


Et chaque Prof peut avoir un seul Departement :

Prof 1 ───── 0..1 Departement
Departement ↔ Etudiant

Un Departement possède une liste d’étudiants :

Departement 1 ───── 0..* Etudiant
PersonnelsAdmin ↔ EmploiTemps

PersonnelsAdmin crée un EmploiTemps :

PersonnelsAdmin ──(crée)──▶ EmploiTemps
Un EmploiTemps est lié à un seul Departement :

EmploiTemps 1 ───── 1 Departement
Prof ↔ PersonnelsAdmin

Prof.sendNotes(PersonnelsAdmin)

PersonnelsAdmin.recevoirNotes(Prof)

PersonnelsAdmin.informerProf(Prof)
Prof 1 ───── 0..* PersonnelsAdmin
(communication : envoi/réception de notes, informations)
Prof ↔ Etudiant

Prof.teach(ArrayList<Etudiant>) → le prof enseigne à une liste d’étudiants

Prof 1 ───── 0..* Etudiant

3. Description des classes et responsabilités
Classe	Responsabilité principale
Etudiant	Gérer les informations d’un étudiant, ses notes, calculer le bulletin
Prof	Enseigner des matières, gérer le département et envoyer les notes
PersonnelsAdmin	Créer emploi du temps, gérer les informations administratives
Departement	Gérer les étudiants et professeurs d’un département, collaborer
EmploiTemps	Représenter le planning d’un département pour un semestre
Personnels	Classe parent pour Prof et PersonnelsAdmin

4. Proposition de base de données relationnelle
On peut représenter le projet avec les tables suivantes :
Tables
1.	Departement
CREATE TABLE Departement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    chefDepartement VARCHAR(100)
);
2.	Etudiant
CREATE TABLE Etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    listNumber INT,
    departement_id INT,
    FOREIGN KEY (departement_id) REFERENCES Departement(id)
);
3.	Prof
CREATE TABLE Prof (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    salary DOUBLE,
    departement_id INT,
    FOREIGN KEY (departement_id) REFERENCES Departement(id)
);
4.	Matiere
CREATE TABLE Matiere (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);
5.	ProfMatiere (relation N-N entre Prof et Matiere)
CREATE TABLE ProfMatiere (
    prof_id INT,
    matiere_id INT,
    PRIMARY KEY(prof_id, matiere_id),
    FOREIGN KEY (prof_id) REFERENCES Prof(id),
    FOREIGN KEY (matiere_id) REFERENCES Matiere(id)
);
6.	Notes (relation N-N entre Etudiant et Matiere)
CREATE TABLE Notes (
    etudiant_id INT,
    matiere_id INT,
    note DOUBLE,
    PRIMARY KEY(etudiant_id, matiere_id),
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id),
    FOREIGN KEY (matiere_id) REFERENCES Matiere(id)
);

7.	PersonnelsAdmin
CREATE TABLE PersonnelsAdmin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    role VARCHAR(50),
    salary DOUBLE
);
8.	EmploiTemps
CREATE TABLE EmploiTemps (
    id INT AUTO_INCREMENT PRIMARY KEY,
    departement_id INT,
    semestre VARCHAR(10),
    annee VARCHAR(10),
    FOREIGN KEY (departement_id) REFERENCES Departement(id)
);
9.	EmploiTempsDetail (pour les salles, matières et créneaux)
CREATE TABLE EmploiTempsDetail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emploiTemps_id INT,
    salle VARCHAR(50),
    matiere VARCHAR(100),
    crenau VARCHAR(50),
    FOREIGN KEY (emploiTemps_id) REFERENCES EmploiTemps(id)
);


5. Exemple de relations
•	1 Département → N Etudiants
•	1 Département → N Professeurs
•	1 Professeur → N Matières
•	1 Etudiant → N Notes / Matières
•	1 PersonnelsAdmin → peut créer N emplois du temps
•	1 EmploiTemps → N détails (salles/matières/créneaux)

6. Avantages et améliorations
•	La structure permet d’ajouter facilement :
o	Une interface graphique Java Swing ou JavaFX.
o	Une persistance avec MySQL ou SQLite.
•	L’UML texte peut être transformé en diagramme visuel UML avec un outil comme draw.io, StarUML, ou Lucidchart.
•	On peut créer une interface pour afficher les tableaux d’étudiants, profs, emplois du temps, etc.


 
