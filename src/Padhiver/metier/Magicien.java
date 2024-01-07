package Padhiver.metier;

import Padhiver.monstre.Monstre;

import Padhiver.personnage.Joueur;
import Padhiver.sort.*;

import java.util.ArrayList;
import java.util.List;

public class Magicien extends Metier {
    // Attributs
    private static final List<Sort> sorts = new ArrayList<>();
    private final int magieMax;
    private int magieCourante;
    private int magieTotal;

    static {
        sorts.add(BouleDeFeu.getInstance());
        sorts.add(RayonDeGivre.getInstance());
    }

    // Constructeur
    public Magicien() {
        super("Magicien", "Dague", 2, 7, 4);
        this.magieMax = 4; // Magie max spécifique au Magicien
        this.magieCourante = 4; // Magie courante spécifique au Magicien
        this.magieTotal = 4;
    }

    // Getters
    public List<Sort> getSorts() {
        return sorts;
    }

    public int getMagieCourante() {
        return magieCourante;
    }

    @Override
    public int getMagieMaxParNiveau() {
        return magieMax;
    }

    // Méthodes
    public void lancer(Monstre monstre) {
        Sort sort = null;
        if (magieCourante >= 9) {
            sort = BouleDeFeu.getInstance();
        } else if (magieCourante >= 2) {
            sort = RayonDeGivre.getInstance();
        } else {
            if (magieCourante >= 15 && sorts.contains(NueeDeMeteores.getInstance())) {
                if (sorts.contains(NueeDeMeteores.getInstance())) {
                    sort = NueeDeMeteores.getInstance();
                }
            } else {
                System.out.println(nom + " n'a pas assez de magie pour lancer de sort.");
                int degats = getDegats();
                System.out.println("Le joueur attaque avec son arme et inflige " + degats + " dégâts au monstre.");
                monstre.recevoirDegats(degats);
            }
        }

        if (sort != null) {
            monstre.recevoirDegats(sort.getDegats());
            magieCourante -= sort.getCoutMagie();
            System.out.println(nom + " lance " + sort.getNom() + " sur " + monstre.getNom() + " et inflige " + sort.getDegats() + " dégâts.");
        }
    }

    public void guerison(Joueur joueur) {
        Sort sort = Guerison.getInstance();
        if (magieCourante >= sort.getCoutMagie()) {
            magieCourante -= sort.getCoutMagie();
            System.out.println(nom + " utilise Guérison et récupère tous ses points de vie.");
            joueur.guerir();
        } else {
            System.out.println(nom + " n'a pas assez de magie pour la Guérison.");
        }
    }

    public void addSort(Sort sort) {
        sorts.add(sort);
    }

    public void regenererMagie() {
        magieCourante = magieTotal;
    }

    public void gagnerMagie(int niveau) {
        magieTotal = magieMax * niveau;
    }
}
