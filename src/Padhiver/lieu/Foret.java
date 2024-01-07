package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class Foret extends Lieu implements InitialiseInstance {
    // Attributs
    private static Foret instance;

    // Constructeur
    private Foret() {
        super("Foret");
    }

    // Getters
    public static Foret getInstance() {
        if (instance == null) {
            instance = new Foret();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre g1 = MonstreFactory.create("Gobelin");
        Monstre g2 = MonstreFactory.create("Gobelin");
        ajouterMonstre(g1);
        ajouterMonstre(g2);
        ajouterLieu(RouteNord.getInstance());
        ajouterLieu(Volcan.getInstance());
    }
}
