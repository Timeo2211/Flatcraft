package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.map.MyCell;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class OverWorld implements CellFactory {

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
        return new MyCell(spriteStore.getSprite("grass"));
    }

    @Override
    public Cell createSubSoil() {
        return new MyCell(spriteStore.getSprite("dirt"));
    }

    @Override
    public Cell createTrunk() {
        return new MyCell(spriteStore.getSprite("trunk"));
    }

    @Override
    public Cell createLeaves() {
        return new MyCell(spriteStore.getSprite("leaves_simple"));
    }

    @Override
    public Cell createTerril() {
        return new MyCell(spriteStore.getSprite("sand"));
    }

    @Override
    public Cell createTree() {
        return new MyCell(spriteStore.getSprite("tree"));
    }


    public Cell createMob() {
        return new MyCell(spriteStore.getSprite("tool_diamondsword"));
    }
}
