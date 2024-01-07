package Padhiver.lieu;

import Padhiver.personnage.PNJ;

public class EauProfonde extends Lieu implements InitialiseInstance {
    // Attributs
    private static EauProfonde instance;

    // Constructeur
    private EauProfonde() {
        super("Eau Profonde");
    }

    // Getters
    public static EauProfonde getInstance() {
        if (instance == null) {
            instance = new EauProfonde();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        PNJ pnj6 = new PNJ("PNJ 6", "Salutations, étranger. Bienvenue à Eauprofonde. Si vous choisissez la Route Sud, vous explorerez des terres riches en opportunités. Pour ceux qui cherchent l'aventure vers le Sud-Est, empruntez la Route Sud-Est.");
        PNJ pnj7 = new PNJ("PNJ 7", "Restez sur vos gardes, étranger. Les routes sont dangereuses.");
        ajouterPNJ(pnj6);
        ajouterPNJ(pnj7);
        ajouterLieu(RouteSudEst.getInstance());
        ajouterLieu(RouteSud.getInstance());
    }
}
