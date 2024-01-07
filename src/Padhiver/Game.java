package Padhiver;

import Padhiver.lieu.Lieu;
import Padhiver.personnage.Joueur;
import Padhiver.state.CreateJoueurState;
import Padhiver.state.State;

import java.util.Scanner;

public class Game {
    // Attributs
    private State state = new CreateJoueurState();
    private Joueur joueur;
    private Lieu lieuAv;
    public static final Scanner scanner = new Scanner(System.in);
    private static Game instance;

    // Constructeur
    private Game() {
    }

    // Getters
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Lieu getLieuAv() {
        return lieuAv;
    }

    // Setters
    public void setState(State state) {
        this.state = state;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setLieuAv(Lieu lieuAv) {
        this.lieuAv = lieuAv;
    }

    // Méthodes
    public void play() {
        while (state != null) {
            state.execute();
        }

        // Le jeu est terminé (soit le joueur à gagner, soit il a perdu)
        if (joueur.getNiveau() >= 20) {
            System.out.println("\nFélicitations, vous avez atteint le niveau 20. Vous avez gagné :)");
        } else {
            System.out.println("\nDommage, vos points de vie ont atteint 0. Vous avez perdu :(");
        }
    }
}
