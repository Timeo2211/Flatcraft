package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public class CreateInstance implements CellFactory {
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        // ajouter un valeur

    }

    @Override
    public Cell createSky() {
    }

    @Override
    public Cell createSoilSurface() {
        return null;
    }

    @Override
    public Cell createSubSoil() {
        return null;
    }

    @Override
    public Cell createTrunk() {
        return null;
    }

    @Override
    public Cell createLeaves() {
        return null;
    }
}
