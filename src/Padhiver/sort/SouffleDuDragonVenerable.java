package Padhiver.sort;

public class SouffleDuDragonVenerable extends Sort {
    // Attributs
    private static final SouffleDuDragonVenerable instance = new SouffleDuDragonVenerable();

    // Constructeur
    private SouffleDuDragonVenerable() {
        super("Souffle du Dragon Vénérable", 16, 60);
    }

    // Méthodes
    public static SouffleDuDragonVenerable getInstance() {
        return instance;
    }
}
