package Padhiver.factory;

import Padhiver.monstre.*;

public class MonstreFactory {
    // Constructeur
    private MonstreFactory() {
    }

    // Méthodes
    public static Monstre create(String nom) {
        return switch (nom) {
            case "Dragon" -> new Dragon();
            case "Gobelin" -> new Gobelin();
            case "Chauve-souris" -> new ChauveSouris();
            case "Necromant" -> new Necromant();
            case "Orc" -> new Orc();
            case "Géant" -> new Geant();
            case "Dragon Vénérable" -> new DragonVenerable();
            default -> null;
        };
    }
}
