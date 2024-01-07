package Padhiver.monstre;

import Padhiver.personnage.Joueur;
import Padhiver.sort.LanceSort;
import Padhiver.sort.Sort;
import Padhiver.sort.SouffleDuDragon;

public class Dragon extends Monstre implements LanceSort {
    // Constructeur
    public Dragon() {
        super("Dragon", 70, 12, 24);
    }

    // Méthodes
    @Override
    public void lance(Joueur joueur) {
        Sort sdd = SouffleDuDragon.getInstance();
        if (this.getPointsDeMagieCourants() >= 8) {
            // Le Dragon a assez de magie pour lancer le sort
            joueur.recevoirDegats(sdd.getDegats()); // Infliger des dégâts au joueur
            this.setMagie(this.getPointsDeMagieCourants() - sdd.getCoutMagie()); // Déduire les points de magie utilisés
            System.out.println("Le Dragon lance un souffle de feu.");
            System.out.println("Le Dragon a infligé " + sdd.getDegats() + S1);
        } else {
            System.out.println("Le Dragon n'a pas assez de magie pour lancer le sort.");

            casGuerrier(joueur);
        }
    }
}