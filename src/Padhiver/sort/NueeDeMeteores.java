package Padhiver.sort;

public class NueeDeMeteores extends Sort {
    // Attributs
    private static NueeDeMeteores instance;

    // Constructeur
    private NueeDeMeteores() {
        super("Nuee de meteores", 15, 30);
    }

    // Getters
    public static NueeDeMeteores getInstance() {
        if (instance == null) {
            instance = new NueeDeMeteores();
        }
        return instance;
    }
}
