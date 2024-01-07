package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;
import Padhiver.personnage.PNJ;

public class RouteSud extends Lieu implements InitialiseInstance {
    // Attributs
    private static RouteSud instance;

    // Constructeur
    private RouteSud() {
        super("Route du Sud");
    }

    // Getters
    public static RouteSud getInstance() {
        if (instance == null) {
            instance = new RouteSud();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        PNJ pnj4 = new PNJ("PNJ 4", "Méfiez-vous des orcs qui rôdent dans le coin. La Route Sud mène au Marais des Morts, Padhiver, Eauprofonde et aux Montagnes.");
        Monstre o = MonstreFactory.create("Orc");
        Monstre o2 = MonstreFactory.create("Orc");
        ajouterPNJ(pnj4);
        ajouterMonstre(o);
        ajouterMonstre(o2);
        ajouterLieu(Padhiver.getInstance());
        ajouterLieu(MaraisDesMorts.getInstance());
        ajouterLieu(EauProfonde.getInstance());
        ajouterLieu(Montagnes.getInstance());
    }
}
