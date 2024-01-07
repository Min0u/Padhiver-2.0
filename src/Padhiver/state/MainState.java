package Padhiver.state;

import Padhiver.Game;
import Padhiver.lieu.Lieu;
import Padhiver.metier.Magicien;
import Padhiver.personnage.Joueur;

import java.util.Scanner;

public class MainState implements State {
    // Méthodes
    @Override
    public void execute() {
        Scanner scanner = Game.scanner;
        Joueur joueur = Game.getInstance().getJoueur();
        Lieu lieuAv = Game.getInstance().getLieuAv();

        if (Game.getInstance().getJoueur().getNiveau() >= 20 || Game.getInstance().getJoueur().getPointsDeVieCourants() <= 0) {
            Game.getInstance().setState(null);
            return;
        }

        // Afficher le lieu actuel
        if (!joueur.getLieuActuel().getNom().equals(lieuAv.getNom())){
            System.out.println("\nVous êtes à " + joueur.getLieuActuel().getNom() + ".");
        }
        // Afficher informations du joueur
        System.out.println("\nVie : " + joueur.getPointsDeVieCourants() + "/" + joueur.getPointsDeVieTotal());
        if (joueur.getMetier() instanceof Magicien) {
            System.out.println("Magie : " + joueur.getPointsDeMagieCourants() + "/" + joueur.getPointsDeMagieTotal());
        }

        // Afficher les actions possibles
        System.out.println("\nActions possibles :");
        System.out.println("1. Se déplacer");
        //si le lieu a plus de monstre, on peut se reposer
        if (joueur.getLieuActuel().getNbMonstres() == 0) {
            System.out.println("2. Se reposer");
        }
        else {
            if (joueur.getMetier() instanceof Magicien) {
                System.out.println("2. Attaquer un monstre ou se Soigner");
            } else {
                System.out.println("2. Attaquer un monstre");
            }
        }
        if (joueur.getLieuActuel().getNbPNJ() > 0) {
            System.out.println("3. Parler à un PNJ");
        }

        System.out.print("Entrez le numéro de votre choix : ");

        // Verifie si cest un nombre
        if (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
        }
        int choixAction = scanner.nextInt();
        scanner.nextLine();

        if (choixAction == 2 && joueur.getLieuActuel().getNbMonstres() == 0) {
            Game.getInstance().setState(new RestState());
        } else {
            if (choixAction == 1) {
                Game.getInstance().setState(new MoveState());
            } else if (choixAction == 2) {
                Game.getInstance().setState(new AttackHealState());
            } else if (choixAction == 3 && joueur.getLieuActuel().getNbPNJ() != 0) {
                Game.getInstance().setState(new TalkState());
            } else {
                System.out.println("Choix invalide. Veuillez choisir une action valide.");
            }
        }
    }
}
