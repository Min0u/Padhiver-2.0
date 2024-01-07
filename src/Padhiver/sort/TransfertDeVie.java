package Padhiver.sort;

public class TransfertDeVie extends Sort {
    // Attributs
    private static final TransfertDeVie instance = new TransfertDeVie();

    // Constructeur
    private TransfertDeVie() {
        super("Transfert de Vie", 5, 12);
    }

    // Méthodes
    public static TransfertDeVie getInstance() {
        return instance;
    }
}