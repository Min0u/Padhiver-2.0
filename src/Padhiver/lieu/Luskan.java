package Padhiver.lieu;

import Padhiver.personnage.PNJ;

public class Luskan extends Lieu implements InitialiseInstance {
    // Attributs
    private static Luskan instance;

    // Constructeur
    private Luskan() {
        super("Luskan");
    }

    // Getters
    public static Luskan getInstance() {
        if (instance == null) {
            instance = new Luskan();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        PNJ pnj5 = new PNJ("PNJ 5", "De retour des terres du nord? Ou vous envisagez la Route de la Rivière vers le sud?");
        ajouterPNJ(pnj5);
        ajouterLieu(RouteNord.getInstance());
        ajouterLieu(RouteRiviere.getInstance());
    }
}
