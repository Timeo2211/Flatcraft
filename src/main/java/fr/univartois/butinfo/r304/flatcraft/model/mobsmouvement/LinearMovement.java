package fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement;

import fr.univartois.butinfo.r304.flatcraft.model.AbstractMob;

public class LinearMovement implements IMobsMovement{
    @Override
    public void move(AbstractMob abstractMob, long deltaTime) {
        if(abstractMob.getHorizontalSpeed() == 0)
            abstractMob.setHorizontalSpeed(50);
        else
            abstractMob.setHorizontalSpeed(-abstractMob.getHorizontalSpeed());
    }
}
