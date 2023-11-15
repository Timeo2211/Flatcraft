package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.map.MyCell;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class Ender implements CellFactory{
    private ISpriteStore spriteStore;

    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    @Override
    public Cell createSky() {
        Sprite sprite = spriteStore.getSprite("sky");
        MyCell cell= new MyCell(sprite);
        return cell;
    }

    @Override
    public Cell createSoilSurface() {
        return new MyCell(spriteStore.getSprite("sandstone_brick"));
    }

    @Override
    public Cell createSubSoil() {
        return new MyCell(spriteStore.getSprite("sand"));
    }

    @Override
    public Cell createTrunk() {
        return null;
    }

    @Override
    public Cell createLeaves() {
        return new MyCell(spriteStore.getSprite("leaves"));
    }

    @Override
    public Cell createTerril() {
        return new MyCell(spriteStore.getSprite("sand"));
    }

    @Override
    public Cell createTree() {
        return new MyCell(spriteStore.getSprite("tree"));
    }
}

