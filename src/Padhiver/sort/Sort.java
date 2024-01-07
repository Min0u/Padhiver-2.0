package Padhiver.sort;

public abstract class Sort {
    // Attributs
    private final String nom;
    private final int coutMagie;
    int degats;
    int degtsDeBase;

    // Constructeur
    protected Sort(String nom, int coutMagie, int degats) {
        this.nom = nom;
        this.coutMagie = coutMagie;
        this.degats = degats;
        this.degtsDeBase = degats;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getCoutMagie() {
        return coutMagie;
    }

    public int getDegats() {
        return degats;
    }

    public int getDegatsDeBase() {
        return degtsDeBase;
    }

    // Setters

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
