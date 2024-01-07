package Padhiver.lieu;
import Padhiver.Game;

import Padhiver.metier.Magicien;
import Padhiver.personnage.Joueur;
import Padhiver.personnage.PNJ;

public class Mirabar extends Lieu implements InitialiseInstance {
    // Attributs
    private static Mirabar instance;

    // Constructeur
    private Mirabar() {
        super("Mirabar");
    }

    // Getters
    public static Mirabar getInstance() {
        if (instance == null) {
            instance = new Mirabar();
            instance.initialisation();
        }
        return instance;
    }

    // Méthodes
    @Override
    public void initialisation() {
        Joueur joueur = Game.getInstance().getJoueur();
        PNJ pnj8 = new PNJ("PNJ 8", "Salutations, aventurier ! En tant que forgeron de Mirabar, je vous souhaite la bienvenue. Pour célébrer votre arrivée, j'ai amélioré votre arme. Désormais, ses dégâts de base ont été triplés. Puissiez-vous en faire bon usage dans vos futures quêtes ");
        PNJ pnj9;
        if (joueur.getMetier() instanceof Magicien) {
            pnj9 = new PNJ("PNJ 9", "Salutations, mage ! Je suis heureux de vous annoncer que vous avez désormais appris le sort \"Nuée de Météores\". Utilisez-le avec sagesse dans vos aventures futures. Les secrets magiques de Mirabar s'ouvrent à vous.");
        } else {
            pnj9 = new PNJ("PNJ 9", "Bienvenue à Mirabar, aventurier. Bien que le sort \"Nuée de Météores\" ne soit accessible qu'aux magiciens, nos forgerons locaux proposent des améliorations d'armes pour tous. Pour cela, consultez le PNJ 8.");
        }
        ajouterPNJ(pnj8);
        ajouterPNJ(pnj9);
        ajouterLieu(RouteNordEst.getInstance());
        ajouterLieu(RouteRiviere.getInstance());
    }
}
