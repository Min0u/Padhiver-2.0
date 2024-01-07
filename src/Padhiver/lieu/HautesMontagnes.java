package Padhiver.lieu;

public class HautesMontagnes extends Lieu implements InitialiseInstance {
    // Attributs
    private static HautesMontagnes instance;

    // Constructeur
    private HautesMontagnes() {
        super("Hautes Montagnes");
    }

    // Getters
    public static HautesMontagnes getInstance() {
        if (instance == null) {
            instance = new HautesMontagnes();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        ajouterLieu(Montagnes.getInstance());
        ajouterLieu(PicDuMont.getInstance());
    }
}
