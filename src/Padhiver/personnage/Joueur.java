package Padhiver.personnage;

import Padhiver.lieu.Lieu;
import Padhiver.metier.Guerrier;
import Padhiver.metier.Metier;
import Padhiver.metier.Magicien;

import Padhiver.monstre.Dragon;
import Padhiver.monstre.Monstre;
import Padhiver.monstre.Necromant;
import Padhiver.sort.NueeDeMeteores;
import Padhiver.sort.Sort;

public class Joueur extends Personnage {
    // Attributs
    private static Joueur instance;
    protected Metier metier;
    protected int niveau;
    protected boolean talkedToPnj8 = false;
    protected boolean talkedToPnj9 = false;

    // Constructeur
    private Joueur(String nom, Metier metier) {
        super(nom, metier.getPvMaxParNiveau(), metier.getDegats(), metier.getMagieMaxParNiveau());
        this.metier = metier;
        this.niveau = 1;
    }

    // Getters
    public static Joueur getInstance(String nom, Metier metier) {
        if (instance == null) {
            instance = new Joueur(nom, metier);
        }
        return instance;
    }

    public int getNiveau() {
        return niveau;
    }

    public Metier getMetier() {
        return metier;
    }

    private String getMagieTotal() {
        if (metier instanceof Magicien magicien) {
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    @Override
    public int getPointsDeMagieCourants() {
        if (metier instanceof Magicien magicien) {
            return magicien.getMagieCourante();
        } else {
            return 0;
        }
    }

    public String getArme() {
        return metier.getArme();
    }

    public String getPointsDeMagieTotal() {
        if (metier instanceof Magicien magicien) {
            return String.valueOf(magicien.getMagieMaxParNiveau() * niveau);
        } else {
            return "0";
        }
    }

    public boolean getTalkedToPnj8() {
        return talkedToPnj8;
    }

    public boolean getTalkedToPnj9() {
        return talkedToPnj9;
    }

    // Méthodes
    public void attaquer(Personnage cible) {
        // Le joueur commence à attaquer
        boolean tourJoueur = true;
        String s1 = "Le monstre attaque et inflige ";
        String s2 = " dégâts au joueur.";
        int magieTotal = cible.getPointsDeMagieCourants();

        while (estEnVie() && cible.estEnVie()) {

            // Affichez les points de vie et de magie du joueur et du monstre
            System.out.println("\nVie du joueur : " + pointsDeVieCourants + "/" + pointsDeVieTotal);
            if (metier instanceof Magicien) {
                System.out.println("Magie du joueur : " + getPointsDeMagieCourants() + "/" + getMagieTotal());
            }
            System.out.println("\nVie du monstre : " + cible.getPointsDeVieCourants() + "/" + cible.getPointsDeVieTotal());
            if (cible instanceof Necromant || cible instanceof Dragon) {

                System.out.println("Magie du monstre : " + cible.getPointsDeMagieCourants() + "/" + magieTotal);
            }

            // Vérifiez à qui appartient le tour et laissez ce personnage attaquer
            if (tourJoueur) {
                System.out.println("\nC'est au tour du joueur !");
                if (metier instanceof Magicien magicien) {
                    magicien.lancer((Monstre) cible);
                } else {
                    int degatsInfliges = getDegats();
                    System.out.println("Vous attaquez avec votre " + getArme() + " et infligez " + degatsInfliges + " dégâts au monstre.");
                    cible.recevoirDegats(degatsInfliges);
                }
                tourJoueur = false; // Tour au monstre
            } else {
                System.out.println("\nC'est au tour du monstre !");
                if (cible instanceof Necromant) {
                    if (cible.getPointsDeMagieCourants() >= 5) {
                        ((Necromant) cible).lance(this);
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println(s1 + degatsInfliges + s2);
                        recevoirDegats(degatsInfliges);
                    }
                } else if (cible instanceof Dragon) {
                    if (cible.getPointsDeMagieCourants() >= 8) {
                        ((Dragon) cible).lance(this);
                    } else {
                        int degatsInfliges = cible.getDegats();
                        System.out.println(s1 + degatsInfliges + s2);
                        recevoirDegats(degatsInfliges);
                    }
                } else {
                    int degatsInfliges = cible.getDegats();
                    if (metier instanceof Guerrier) {
                        degatsInfliges -= 2; // Le Guerrier réduit les dégâts de 2 (hors sorts)
                    }
                    System.out.println(s1 + degatsInfliges + s2);
                    recevoirDegats(degatsInfliges);
                }
                tourJoueur = true; // Tour au joueur
            }

            // Vérifiez si l'un des personnages est mort
            if (!estEnVie()) {
                System.out.println("\nVous êtes mort.");
            } else if (!cible.estEnVie()) {
                System.out.println("\nLe monstre est mort.");
                gagnerNiveau();
                Lieu lieuActuel = getLieuActuel();
                lieuActuel.retirerMonstre((Monstre) cible);
            }
        }
    }

    public void gagnerNiveau() {
        niveau++;
        pointsDeVieTotal = metier.getPvMaxParNiveau() * niveau;
        System.out.println("\nVous avez gagné un niveau ! Vous êtes maintenant niveau " + niveau + ".");

        if (metier instanceof Magicien magicien) {
            magicien.gagnerMagie(niveau);
            if (niveau % 6 == 0) {
                int i = niveau / 6;
                for (Sort sort : magicien.getSorts()) {
                    sort.setDegats(sort.getDegatsDeBase() * (i + 1));
                }
                System.out.println("\nLes dégâts de vos sorts ont été multipliés par " + (i + 1) + ".");
            }
        }

        if (niveau % 3 == 0) {
            int i = niveau / 3;
            degats = metier.getDegats() * (i + 1);
            System.out.println("\nLes dégâts de votre arme ont été multipliés par " + (i + 1) + ".");
        }
    }

    public void seReposer(){
        if (metier instanceof Magicien) {
            System.out.print("\nVous vous reposez et regagnez tous vos points de vie et de magie.");
        }
        else {
            System.out.print("\nVous vous reposez et regagnez tous vos points de vie.");
        }
        pointsDeVieCourants = pointsDeVieTotal;
        if (metier instanceof Magicien magicien) {
            magicien.regenererMagie();
        }
    }

    public void talkedPNJ8() {
        talkedToPnj8 = true;
        metier.setDegats(metier.getDegats() * 3);
        degats = degats * 3;
        System.out.println("J'ai triplé les dégâts de votre arme.");
    }

    public void talkedPNJ9() {
        talkedToPnj9 = true;
        if (metier instanceof Magicien magicien) {
            magicien.addSort(NueeDeMeteores.getInstance());
            System.out.println("Je vous ai appris le sort Nuée De Météores.");
        } else {
            System.out.println("Vous n'êtes pas un magicien, je ne peux pas vous apprendre de sort.");
        }
    }

    public void guerir() {
        pointsDeVieCourants = pointsDeVieTotal;
    }
}
