package Padhiver.state;

import Padhiver.Game;
import Padhiver.metier.Magicien;
import Padhiver.monstre.Monstre;
import Padhiver.personnage.Joueur;

import java.util.List;
import java.util.Scanner;

public class AttackHealState implements State {
    // Méthodes
    @Override
    public void execute() {
        Joueur joueur = Game.getInstance().getJoueur();
        Scanner scanner = Game.scanner;

        if (joueur.getMetier() instanceof Magicien) {
            System.out.println("\nChoisissez une action :");
            System.out.println("1. Attaquer un monstre");
            System.out.println("2. Se soigner");

            System.out.print("Entrez le numéro de votre choix : ");
            if (scanner.hasNextInt()) {
                int choixAction2 = scanner.nextInt();
                scanner.nextLine(); // Consommez la nouvelle ligne

                switch (choixAction2) {
                    case 1:
                        System.out.println("\nMonstre(s) présent(s) :");
                        List<Monstre> monstres = List.of(joueur.getLieuActuel().getMonstres());
                        for (int i = 0; i < monstres.size(); i++) {
                            Monstre monstre = monstres.get(i);
                            System.out.println((i + 1) + ". " + monstre.getNom());
                        }
                        System.out.print("Entrez le numéro du monstre que vous souhaitez attaquer : ");

                        choixMonstre(monstres);
                        break;
                    case 2:
                        ((Magicien) joueur.getMetier()).guerison(joueur);
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une action valide.");
                }
            }
        } else {
            System.out.println("\nMonstre(s) présent(s) :");
            List<Monstre> monstres = List.of(joueur.getLieuActuel().getMonstres());
            for (int i = 0; i < monstres.size(); i++) {
                Monstre monstre = monstres.get(i);
                System.out.println((i + 1) + ". " + monstre.getNom());
            }
            System.out.print("Entrez le numéro du monstre que vous souhaitez attaquer : ");

            choixMonstre(monstres);
        }

        Game.getInstance().setState(new MainState());
    }

    public static void choixMonstre(List<Monstre> monstres) {
        Joueur joueur = Game.getInstance().getJoueur();
        Scanner scanner = Game.scanner;

        if (scanner.hasNextInt()) {
            int choixMonstre = scanner.nextInt();
            scanner.nextLine(); // Consommez la nouvelle ligne

            if (choixMonstre >= 1 && choixMonstre <= monstres.size()) {
                Monstre monstreCible = monstres.get(choixMonstre - 1);
                joueur.attaquer(monstreCible);
            } else {
                System.out.println("Choix invalide. Veuillez choisir un monstre présent.");
            }
        } else {
            System.out.println("Veuillez entrer un numéro de monstre valide.");
            scanner.nextLine(); // Consommez l'entrée invalide de l'utilisateur
        }
    }
}
