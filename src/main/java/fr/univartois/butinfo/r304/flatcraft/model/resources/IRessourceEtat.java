package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public interface IRessourceEtat {

    SpriteStore spriteStore = new SpriteStore();

    void nextEtat(Resource resource);

}
