package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement.IMobsMovement;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public abstract class AbstractMob extends AbstractMovable{
    private IMobsMovement movement;

    protected AbstractMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, IMobsMovement movement) {
        super(game, xPosition, yPosition, sprite);
        this.movement = movement;
    }

    public IMobsMovement getMovement() {
        return movement;
    }

    public void setMovement(IMobsMovement movement) {
        this.movement = movement;
    }

    @Override
    public boolean move(long deltaTime) {
        if(!super.move(deltaTime)){
            movement.move(this, deltaTime);
            return true;
        }
        return false;
    }

}
