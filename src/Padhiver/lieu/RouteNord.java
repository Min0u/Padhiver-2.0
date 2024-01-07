package Padhiver.lieu;

import Padhiver.personnage.PNJ;

public class RouteNord extends Lieu implements InitialiseInstance {
    // Attributs
    private static RouteNord instance;

    // Constructeur
    private RouteNord() {
        super("Route du Nord");
    }

    // Getters
    public static RouteNord getInstance() {
        if (instance == null) {
            instance = new RouteNord();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        PNJ pnj3 = new PNJ("PNJ 3", "Vous êtes sur la Route Nord. De là, vous pouvez accéder à la Forêt, Padhiver, et Luskan.");
        ajouterPNJ(pnj3);
        ajouterLieu(Padhiver.getInstance());
        ajouterLieu(Foret.getInstance());
        ajouterLieu(Luskan.getInstance());
    }
}
