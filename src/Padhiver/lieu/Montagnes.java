package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class Montagnes extends Lieu implements InitialiseInstance {
    // Attributs
    private static Montagnes instance;

    // Constructeur
    private Montagnes() {
        super("Montagnes");
    }

    // Getters
    public static Montagnes getInstance() {
        if (instance == null) {
            instance = new Montagnes();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre d = MonstreFactory.create("Dragon");
        Monstre d2 = MonstreFactory.create("Dragon");
        ajouterMonstre(d);
        ajouterMonstre(d2);
        ajouterLieu(RouteSud.getInstance());
        ajouterLieu(HautesMontagnes.getInstance());
    }
}
