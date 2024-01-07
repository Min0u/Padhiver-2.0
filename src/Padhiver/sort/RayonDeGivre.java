package Padhiver.sort;

public class RayonDeGivre extends Sort {
    // Attributs
    private static final RayonDeGivre instance = new RayonDeGivre();

    // Constructeur
    private RayonDeGivre() {
        super("Rayon de Givre", 2, 4);
    }

    // Méthodes
    public static RayonDeGivre getInstance() {
        return instance;
    }

}
