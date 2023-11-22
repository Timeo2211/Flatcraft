package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement.IMobsMovement;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class NetherMob extends AbstractMob {
    public NetherMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, IMobsMovement movement) {
        super(game, xPosition, yPosition, new SpriteStore().getSprite("lava"), movement);
    }
}
