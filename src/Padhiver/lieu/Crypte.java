package Padhiver.lieu;

import Padhiver.factory.MonstreFactory;
import Padhiver.monstre.Monstre;

public class Crypte extends Lieu implements InitialiseInstance {
    // Attributs
    private static Crypte instance;

    // Constructeur
    private Crypte() {
        super("Crypte");
    }

    // Getters
    public static Crypte getInstance() {
        if (instance == null) {
            instance = new Crypte();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Monstre n = MonstreFactory.create("Necromant");
        ajouterMonstre(n);
        ajouterLieu(MaraisDesMorts.getInstance());
    }
}
