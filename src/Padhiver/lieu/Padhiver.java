package Padhiver.lieu;

import Padhiver.personnage.PNJ;

public class Padhiver extends Lieu implements InitialiseInstance {
    // Attributs
    private static Padhiver instance;

    // Constructeur
    private Padhiver() {
        super("Padhiver");
    }

    // Getters
    public static Padhiver getInstance() {
        if (instance == null) {
            instance = new Padhiver();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        PNJ pnj1 = new PNJ("PNJ 1", "Bienvenue à Padhiver, aventurier. Si vous souhaitez explorer le Nord, prenez la Route Nord. Pour le Sud, empruntez la Route Sud.");
        PNJ pnj2 = new PNJ("PNJ 2", "Prenez garde aux dangers qui rôdent dans ces contrées. Les routes peuvent vous mener à des destinations surprenantes.");
        ajouterPNJ(pnj1);
        ajouterPNJ(pnj2);
        ajouterLieu(RouteNord.getInstance());
        ajouterLieu(RouteSud.getInstance());
    }
}

