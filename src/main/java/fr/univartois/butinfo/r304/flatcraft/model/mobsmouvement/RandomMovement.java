package fr.univartois.butinfo.r304.flatcraft.model.mobsmouvement;

import fr.univartois.butinfo.r304.flatcraft.model.AbstractMob;
import java.util.Random;

public class RandomMovement implements IMobsMovement{
    @Override
    public void move(AbstractMob abstractMob, long deltaTime) {
        Random random = new Random();
        int res = random.nextInt(1, 5);
        if((res % 2) == 0)
            abstractMob.setHorizontalSpeed(res*50);
        else
            abstractMob.setHorizontalSpeed(-res*50);
    }
}
