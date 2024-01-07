package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class RouteRiviere extends Lieu implements InitialiseInstance {
    // Attributs
    private static RouteRiviere instance;

    // Constructeur
    private RouteRiviere() {
        super("Route Riviere");
    }

    // Getters
    public static RouteRiviere getInstance() {
        if (instance == null) {
            instance = new RouteRiviere();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre o = MonstreFactory.create("Orc");
        Monstre o2 = MonstreFactory.create("Orc");
        Monstre o3 = MonstreFactory.create("Orc");
        ajouterMonstre(o);
        ajouterMonstre(o2);
        ajouterMonstre(o3);
        ajouterLieu(Mirabar.getInstance());
        ajouterLieu(Luskan.getInstance());
    }
}
