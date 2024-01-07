package Padhiver.monstre;

import Padhiver.metier.Guerrier;
import Padhiver.personnage.Joueur;
import Padhiver.personnage.Personnage;

public class Monstre extends Personnage {
    // Attributs
    protected static final String S1 = " dégâts au joueur.";

    // Constructeur
    public Monstre(String nom, int pointsDeVieTotal, int degats, int magie) {
        super(nom, pointsDeVieTotal, degats, magie);
    }

    // Méthodes
    void casGuerrier(Joueur joueur) {

        if (joueur.getMetier() instanceof Guerrier) {
            int degatsInfliges = getDegats() - 2;
            System.out.println("Le Padhiver.monstre attaque et inflige " + degatsInfliges + S1);
            joueur.recevoirDegats(degatsInfliges);
        } else {
            int degatsInfliges = getDegats();
            System.out.println("Le Padhiver.monstre attaque et inflige " + degatsInfliges + S1);
            joueur.recevoirDegats(degatsInfliges);
        }
    }

    void regenererPointsDeVie() {
        // Implémentation spécifique au Padhiver.monstre.Monstre pour régénérer des points de vie
        this.pointsDeVieCourants += 6;
    }
}
