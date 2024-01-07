package Padhiver.monstre;

import Padhiver.personnage.Joueur;
import Padhiver.sort.LanceSort;
import Padhiver.sort.Sort;
import Padhiver.sort.TransfertDeVie;


public class Necromant extends Monstre implements LanceSort {
    // Constructeur
    public Necromant() {
        super("Nécromant", 30, 8, 10);
    }

    // Méthodes
    @Override
    public void lance(Joueur joueur) {

        if (this.getPointsDeMagieCourants() >= 5) {
            Sort tdv = TransfertDeVie.getInstance();
            // Le Nécromant a assez de magie pour lancer le sort
            joueur.recevoirDegats(tdv.getDegats()); // Infliger des dégâts au joueur
            this.regenererPointsDeVie(); // Redonner 6 PV au Nécromant
            this.setMagie(this.getPointsDeMagieCourants() - tdv.getCoutMagie()); // Déduire les points de magie utilisés

            System.out.println("Le Nécromant effectue un transfert de vie.");
            System.out.println("Le Nécromant a infligé " + tdv.getDegats() + S1);
            System.out.println("Le Nécromant a récupéré 6 points de vie.");
        } else {
            System.out.println("Le Nécromant n'a pas assez de magie pour lancer le sort.");
            casGuerrier(joueur);
        }
    }
}