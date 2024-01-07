package Padhiver.monstre;

import Padhiver.personnage.Joueur;
import Padhiver.sort.LanceSort;
import Padhiver.sort.Sort;
import Padhiver.sort.SouffleDuDragonVenerable;

public class DragonVenerable extends Monstre implements LanceSort {
    // Constructeur
    public DragonVenerable() {
        super("Dragon Vénérable", 220, 24, 48);
    }

    // Méthodes
    @Override
    public void lance(Joueur joueur) {
        Sort sddv = SouffleDuDragonVenerable.getInstance();
        if (this.getPointsDeMagieCourants() >= 16) {
            // Le Dragon Vénérable a assez de magie pour lancer le sort
            joueur.recevoirDegats(sddv.getDegats()); // Infliger des dégâts au joueur
            this.setMagie(this.getPointsDeMagieCourants() - sddv.getCoutMagie()); // Déduire les points de magie utilisés
            System.out.println("Le Dragon Vénérable lance un souffle de feu.");
            System.out.println("Le Dragon Vénérable a infligé " + sddv.getDegats() + S1);
        } else {
            System.out.println("Le Dragon Vénérable n'a pas assez de magie pour lancer le sort.");

            casGuerrier(joueur);
        }
    }
}
