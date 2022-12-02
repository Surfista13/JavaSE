USE ParcAutos
GO

CREATE TABLE Voitures(
	id INT CONSTRAINT PK_voitures PRIMARY KEY IDENTITY(1,1),
	marque VARCHAR(50) NOT NULL ,
	modele VARCHAR(50) NOT NULL,
	vitesse_max INT CONSTRAINT CK_voitures_vitesseMax CHECK(vitesse_max >= 0)
)
	
