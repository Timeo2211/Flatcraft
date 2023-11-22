package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.map.MyCell;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class Ender implements CellFactory{
    private ISpriteStore spriteStore;

    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public Cell createSky() {
        Sprite sprite = spriteStore.getSprite("sky");
        MyCell cell= new MyCell(sprite);
        return cell;
    }

    public Cell createSoilSurface() {
        return new MyCell(spriteStore.getSprite("sandstone_brick"));
    }

    public Cell createSubSoil() {
        return new MyCell(spriteStore.getSprite("sand"));
    }

    public Cell createTrunk() {
        return null;
    }

    public Cell createLeaves() {
        return null;
    }

    public Cell createTerril() {
        return null;
    }

    @Override
    public Cell createTree() {
        return null;
    }

    @Override
    public Cell createWater() {
        return null;
    }

    @Override
    public Cell createRessource(int i) {
        return new MyCell(spriteStore.getSprite("mineral_diamond"));
    }
}
