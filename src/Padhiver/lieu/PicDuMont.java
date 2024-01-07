package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class PicDuMont extends Lieu implements InitialiseInstance {
    // Attributs
    private static PicDuMont instance;

    // Constructeur
    private PicDuMont() {
        super("Pic du Mont");
    }

    // Getters
    public static PicDuMont getInstance() {
        if (instance == null) {
            instance = new PicDuMont();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre dv = MonstreFactory.create("Dragon Vénérable");
        ajouterMonstre(dv);
        ajouterLieu(HautesMontagnes.getInstance());
    }
}
