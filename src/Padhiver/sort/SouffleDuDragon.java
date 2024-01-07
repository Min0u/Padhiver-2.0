package Padhiver.sort;

public class SouffleDuDragon extends Sort {
    // Attributs
    private static final SouffleDuDragon instance = new SouffleDuDragon();

    // Constructeur
    private SouffleDuDragon() {
        super("Souffle du Dragon", 8, 20);
    }

    // Méthodes
    public static SouffleDuDragon getInstance() {
        return instance;
    }
}