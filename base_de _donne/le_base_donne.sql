-- Table pour les utilisateurs (étudiants et administrateurs)
CREATE TABLE Utilisateurs (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(100) NOT NULL,
    Prenom VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Mot_de_passe VARCHAR(100) NOT NULL,
    Est_Administrateur BOOLEAN NOT NULL
);

-- Table pour les cours
CREATE TABLE Cours (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(100) NOT NULL,
    Description TEXT
);

-- Table pour les inscriptions aux cours
CREATE TABLE Inscriptions (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Utilisateur INT,
    ID_Cours INT,
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateurs(ID),
    FOREIGN KEY (ID_Cours) REFERENCES Cours(ID)
);

-- Table pour les notes des étudiants
CREATE TABLE Notes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Utilisateur INT,
    ID_Cours INT,
    Note DECIMAL(5, 2),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateurs(ID),
    FOREIGN KEY (ID_Cours) REFERENCES Cours(ID)
);

-- Table pour stocker les informations sur les fichiers PDF avec les codes QR
CREATE TABLE Fichiers_PDF (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Utilisateur INT,
    Chemin_PDF VARCHAR(255),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateurs(ID)
);
