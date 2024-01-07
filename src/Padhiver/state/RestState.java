package Padhiver.state;

import Padhiver.Game;
import Padhiver.personnage.Joueur;

public class RestState implements State {
    // Méthodes
    @Override
    public void execute() {
        Joueur joueur = Game.getInstance().getJoueur();

        if (joueur.getLieuActuel().getNbMonstres() == 0) {
            joueur.seReposer();
        }

        Game.getInstance().setState(new MainState());
    }
}
