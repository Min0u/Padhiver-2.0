package Padhiver.state;

import Padhiver.Game;
import Padhiver.personnage.Joueur;
import Padhiver.personnage.PNJ;

import java.util.List;
import java.util.Scanner;

public class TalkState implements State {
    // Méthodes
    @Override
    public void execute() {
        Joueur joueur = Game.getInstance().getJoueur();
        Scanner scanner = Game.scanner;

        System.out.println("\nPNJ(s) présent(s) :");
        List<PNJ> pnjs = joueur.getLieuActuel().getPNJ();
        for (int i = 0; i < pnjs.size(); i++) {
            PNJ pnj = pnjs.get(i);
            System.out.println((i + 1) + ". " + pnj.getNom());
        }
        System.out.print("Entrez le numéro du PNJ que vous souhaitez interroger : ");

        if (scanner.hasNextInt()) {
            int choixPNJ = scanner.nextInt();
            scanner.nextLine(); // Consommez la nouvelle ligne

            if (choixPNJ >= 1 && choixPNJ <= pnjs.size()) {
                PNJ pnjCible = pnjs.get(choixPNJ - 1);
                System.out.println("\n" + pnjCible.getReponse());
                if (pnjCible.getNom().equals("PNJ 8") && !joueur.getTalkedToPnj8()) {
                    joueur.talkedPNJ8();
                }
                if (pnjCible.getNom().equals("PNJ 9") && !joueur.getTalkedToPnj9()) {
                    joueur.talkedPNJ9();
                }
            } else {
                System.out.println("Choix invalide. Veuillez choisir un PNJ présent.");
            }
        } else {
            System.out.println("Veuillez entrer un numéro de PNJ valide.");
            scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
        }

        Game.getInstance().setState(new MainState());
    }
}
