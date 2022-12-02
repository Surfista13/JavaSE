package fr.eni.parcauto.test;

import fr.eni.parcauto.bo.Voiture;

public class TestBO {
    public static void main(String[] args) {
        Voiture v1 = new Voiture(1,"Renault","Clio",200);
        System.out.println(v1);
        Voiture v2 = new Voiture(2,"Peugeot","208",205);
        v2.setVitessemax(180);
        v1.setId(3);
        System.out.println(v2);
    }
}
