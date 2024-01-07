package Padhiver.personnage;

import Padhiver.lieu.Lieu;

public class Personnage {
    // Attributs
    private String nom;
    protected int pointsDeVieTotal;
    protected int pointsDeVieCourants;
    protected Lieu lieuActuel;
    protected int degats;
    protected int magie;

    // Constructeur
    public Personnage(String nom, int pointsDeVieTotal, int degats, int magie) {
        this.nom = nom;
        this.pointsDeVieTotal = pointsDeVieTotal;
        this.pointsDeVieCourants = pointsDeVieTotal;
        this.degats = degats;
        this.magie = magie;
    }

    // Setters
    public void setLieuActuel(Lieu lieuActuel) {
        this.lieuActuel = lieuActuel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    protected void setMagie(int magies) { this.magie = magies; }

    // Getters
    protected int getPointsDeMagieCourants() {
        return this.magie;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVieTotal() {
        return pointsDeVieTotal;
    }

    public int getPointsDeVieCourants() {
        return pointsDeVieCourants;
    }

    public Lieu getLieuActuel() {
        return lieuActuel;
    }

    public int getDegats() {
        return degats;
    }

    // Méthodes

    public void recevoirDegats(int degatsInfliges) {
        this.pointsDeVieCourants -= degatsInfliges;
    }

    protected boolean estEnVie() {
        return pointsDeVieCourants > 0;
    }
}

