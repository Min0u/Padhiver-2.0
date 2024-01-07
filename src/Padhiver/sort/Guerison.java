package Padhiver.sort;

public class Guerison extends Sort {
    // Attributs
    private static Guerison instance;

    // Constructeur
    private Guerison() {
        super("Guerison", 10, 0);
    }

    // Getters
    public static Guerison getInstance() {
        if (instance == null) {
            instance = new Guerison();
        }
        return instance;
    }
}
