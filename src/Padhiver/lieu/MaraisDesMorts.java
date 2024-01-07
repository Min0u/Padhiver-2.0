package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class MaraisDesMorts extends Lieu implements InitialiseInstance {
    // Attributs
    private static MaraisDesMorts instance;

    // Constructeur
    private MaraisDesMorts() {
        super("Marais des Morts");
    }

    // Getters
    public static MaraisDesMorts getInstance() {
        if (instance == null) {
            instance = new MaraisDesMorts();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre cs = MonstreFactory.create("Chauve-souris");
        Monstre cs2 = MonstreFactory.create("Chauve-souris");
        Monstre cs3 = MonstreFactory.create("Chauve-souris");
        ajouterMonstre(cs);
        ajouterMonstre(cs2);
        ajouterMonstre(cs3);
        ajouterLieu(Crypte.getInstance());
        ajouterLieu(RouteSud.getInstance());
    }
}
