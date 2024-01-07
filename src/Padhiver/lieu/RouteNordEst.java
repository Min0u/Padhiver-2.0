package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class RouteNordEst extends Lieu implements InitialiseInstance {
    // Attributs
    private static RouteNordEst instance;

    // Constructeur
    private RouteNordEst() {
        super("Route Nord-Est");
    }

    // Getters
    public static RouteNordEst getInstance() {
        if (instance == null) {
            instance = new RouteNordEst();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre g = MonstreFactory.create("Géant");
        Monstre g2 = MonstreFactory.create("Géant");
        ajouterMonstre(g);
        ajouterMonstre(g2);
        ajouterLieu(Mirabar.getInstance());
        ajouterLieu(RouteSudEst.getInstance());
    }
}