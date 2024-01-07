package Padhiver.state;

import Padhiver.Game;
import Padhiver.lieu.Lieu;
import Padhiver.personnage.Joueur;

import java.util.List;
import java.util.Scanner;

public class MoveState implements State {
    // Méthodes
    @Override
    public void execute() {
        Joueur joueur = Game.getInstance().getJoueur();
        Scanner scanner = Game.scanner;

        List<Lieu> lieuxAccessibles = List.of(Lieu.getLieuxAccessibles(joueur.getLieuActuel()));
        System.out.println("\nLieu(s) accessible(s) :");
        for (int i = 0; i < lieuxAccessibles.size(); i++) {
            Lieu lieu = lieuxAccessibles.get(i);
            System.out.println((i + 1) + ". " + lieu.getNom()); // Affichez le numéro du lieu et son nom
        }
        System.out.print("Entrez le numéro du lieu vers lequel vous souhaitez vous déplacer : ");

        // Vérifiez que l'entrée de l'utilisateur est un nombre
        if (scanner.hasNextInt()) {
            int choixLieu = scanner.nextInt();
            scanner.nextLine(); // Consommez la nouvelle ligne

            // Vérifiez que le choix est dans la plage des lieux accessibles
            if (choixLieu >= 1 && choixLieu <= lieuxAccessibles.size()) {
                joueur.setLieuActuel(lieuxAccessibles.get(choixLieu - 1));
            } else {
                System.out.println("Choix invalide. Veuillez choisir un lieu accessible.");
            }
        } else {
            System.out.println("Veuillez entrer un numéro de lieu valide.");
            scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
        }

        Game.getInstance().setState(new MainState());
    }
}