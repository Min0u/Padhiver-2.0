package Padhiver.lieu;

import Padhiver.personnage.PNJ;
import Padhiver.monstre.Monstre;

import java.util.ArrayList;
import java.util.List;

public abstract class Lieu {
    // Attributs
    protected String nom;
    protected int nbMonstres;
    protected int nbPNJ;
    protected final List<PNJ> pnjs;
    protected final List<Monstre> monstres;
    protected final List<Lieu> lieuxAccessibles;

    // Constructeur
    protected Lieu(String nom) {
        this.nom = nom;
        this.nbMonstres = 0;
        this.nbPNJ = 0;
        this.monstres = new ArrayList<>();
        this.pnjs = new ArrayList<>();
        this.lieuxAccessibles = new ArrayList<>();
    }

    // Getters
    public static Lieu[] getLieuxAccessibles(Lieu lieuActuel) {
        return lieuActuel.lieuxAccessibles.toArray(new Lieu [0]);
    }

    public Monstre[] getMonstres() {
        return monstres.toArray(new Monstre[0]);
    }

    public List<PNJ> getPNJ() {
        return pnjs;
    }

    public int getNbPNJ() {
        return nbPNJ;
    }

    public int getNbMonstres() {
        return nbMonstres;
    }

    public String getNom() {
        return nom;
    }

    // Méthodes
    public void ajouterLieu(Lieu lieu) {
        lieuxAccessibles.add(lieu);
    }

    public void ajouterMonstre(Monstre monstre) {
        monstres.add(monstre);
        nbMonstres++;
    }

    public void retirerMonstre(Monstre monstre) {
        monstres.remove(monstre);
        nbMonstres--;
    }

    public void ajouterPNJ(PNJ pnj) {
        pnjs.add(pnj);
        nbPNJ++;
    }
}