package fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement;

import fr.univartois.butinfo.r304.flatcraft.model.AbstractMob;

public class SmartMovement implements IMobsMovement{
    @Override
    public void move(AbstractMob abstractMob, long deltaTime) { //A revoir
        if(abstractMob.getHorizontalSpeed() == 0)
            abstractMob.setHorizontalSpeed(200);
        else
            abstractMob.setHorizontalSpeed(-abstractMob.getHorizontalSpeed());
    }
}
