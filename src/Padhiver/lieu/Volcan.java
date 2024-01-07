package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class Volcan extends Lieu implements InitialiseInstance {
    // Attributs
    private static Volcan instance;

    // Constructeur
    private Volcan() {
        super("Volcan");
    }

    // Getters
    public static Volcan getInstance() {
        if (instance == null) {
            instance = new Volcan();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre d = MonstreFactory.create("Dragon");
        ajouterMonstre(d);
        ajouterLieu(Foret.getInstance());
    }
}
