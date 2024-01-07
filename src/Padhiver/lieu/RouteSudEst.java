package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class RouteSudEst extends Lieu implements InitialiseInstance {
    // Attributs
    private static RouteSudEst instance;

    // Constructeur
    private RouteSudEst() {
        super("Route Sud-Est");
    }

    // Getters
    public static RouteSudEst getInstance() {
        if (instance == null) {
            instance = new RouteSudEst();
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
        ajouterLieu(EauProfonde.getInstance());
        ajouterLieu(RouteNordEst.getInstance());
    }
}
