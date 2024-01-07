package Padhiver.factory;

import Padhiver.metier.Barbare;
import Padhiver.metier.Guerrier;
import Padhiver.metier.Magicien;
import Padhiver.metier.Metier;

public class MetierFactory {
    // Constructeur
    private MetierFactory() {
    }

    // Méthodes
    public static Metier create(int choixMetierInt) {
        return switch (choixMetierInt) {
            case 1 -> new Barbare();
            case 2 -> new Guerrier();
            case 3 -> new Magicien();
            default -> null;
        };
    }
}
