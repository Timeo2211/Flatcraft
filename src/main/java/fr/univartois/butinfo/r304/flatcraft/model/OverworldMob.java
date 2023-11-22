package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement.IMobsMovement;
import fr.univartois.butinfo.r304.flatcraft.view.*;
import fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement.*;

public class OverworldMob extends AbstractMob{
    public OverworldMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, IMobsMovement movement) {
        super(game, xPosition, yPosition, new SpriteStore().getSprite("nc_front"), movement);
    }

    public OverworldMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, int movement) {
        super(game, xPosition, yPosition, new SpriteStore().getSprite("nc_front"), null);
        switch (movement) {
            case 0 : this.setMovement(new LinearMovement()); System.out.println("Linear"); break;
            case 1 : this.setMovement(new RandomMovement()); System.out.println("Random"); break;
            case 2 : this.setMovement(new SmartMovement()); System.out.println("Smart"); break;
            default: break;
        }
    }
}
