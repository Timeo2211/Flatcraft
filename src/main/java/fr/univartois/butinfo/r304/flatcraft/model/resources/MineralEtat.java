package fr.univartois.butinfo.r304.flatcraft.model.resources;

public class MineralEtat implements IRessourceEtat {
    LumpEtat lumpEtat;

    @Override
    public void nextEtat(Resource resource) {
           Resource.setResourceEtat(new LumpEtat());
           Resource.getSpriteStore().getSprite("lump");
    }
}
