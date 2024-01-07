package Padhiver.sort;

public class BouleDeFeu extends Sort {
    // Attributs
    private static final BouleDeFeu instance = new BouleDeFeu();

    // Constructeur
    private BouleDeFeu() {
        super("Boule de Feu", 9, 15);
    }

    // Méthodes
    public static BouleDeFeu getInstance() {
        return instance;
    }
}
