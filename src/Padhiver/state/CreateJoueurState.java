package Padhiver.state;

import Padhiver.factory.MetierFactory;
import Padhiver.metier.Metier;
import Padhiver.personnage.Joueur;
import Padhiver.lieu.Padhiver;
import Padhiver.Game;

public class CreateJoueurState implements State {
    @Override
    public void execute() {
        ////////////////////////////////////////////////////////////

        // Choix du nom du joueur
        System.out.println("Bienvenue dans 'Les Nuits de Padhiver' !");
        System.out.print("\nVeuillez entrer le nom de votre personnage : ");
        String nomJoueur = Game.scanner.nextLine();

        /////////////////////////////////////////////////////////////

        // Choix du métier
        System.out.println("\nMétier disponible :");
        System.out.println("1. Barbare");
        System.out.println("2. Guerrier");
        System.out.println("3. Magicien");

        int choixMetierInt;

        // Vérification que l'entrée est un nombre
        while (true) {
            System.out.println("Entrez le numéro correspondant à votre choix : ");
            if (Game.scanner.hasNextInt()) {
                choixMetierInt = Game.scanner.nextInt();
                if (choixMetierInt >= 1 && choixMetierInt <= 3) {
                    break;
                } else {
                    System.out.println("Choix invalide. Veuillez choisir un métier valide.");
                }
            } else {
                System.out.println("Choix invalide. Veuillez choisir un métier valide.");
                Game.scanner.next(); // Consommer l'entrée incorrecte de l'utilisateur
            }
        }

        Metier metier = MetierFactory.create(choixMetierInt);

        if (metier != null) {
            Game.getInstance().setJoueur(Joueur.getInstance(nomJoueur, metier));
        }

        Joueur joueur = Game.getInstance().getJoueur();

        //print toutes les infos du joueur
        System.out.println("\nNom : " + joueur.getNom());
        System.out.println("Metier : " + joueur.getMetier().getNom());
        System.out.println("Niveau : " + joueur.getNiveau());
        System.out.println("Points de vie : " + joueur.getPointsDeVieCourants() + "/" + joueur.getPointsDeVieTotal());
        System.out.println("Points de magie : " + joueur.getPointsDeMagieCourants() + "/" + joueur.getPointsDeMagieTotal());
        System.out.println("Arme : " + joueur.getArme());
        System.out.println("Degats : " + joueur.getDegats());

        joueur.setLieuActuel(Padhiver.getInstance());
        System.out.println("\nVous êtes à " + joueur.getLieuActuel().getNom() + ".");
        System.out.println("N'hésitez pas à parler aux PNJ pour avoir des informations sur le jeu.");
        Game.getInstance().setLieuAv(joueur.getLieuActuel());

        Game.getInstance().setState(new MainState());
    }
}