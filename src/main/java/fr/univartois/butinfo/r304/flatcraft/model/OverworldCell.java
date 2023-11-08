package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.ObjectProperty;

public class OverworldCell implements Cell {
    @Override
    public int getRow() {
        // Implémentez la logique pour obtenir la ligne.
        return 0;
    }

    @Override
    public int getColumn() {
        // Implémentez la logique pour obtenir la colonne.
        return 0;
    }

    @Override
    public Sprite getSprite() {
        // Implémentez la logique pour obtenir le sprite.
        return null;
    }

    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        // Implémentez la logique pour obtenir la propriété du sprite.
        return null;
    }

    @Override
    public Resource getResource() {
        // Implémentez la logique pour obtenir la ressource.
        return null;
    }

    @Override
    public ObjectProperty<Resource> getResourceProperty() {
        // Implémentez la logique pour obtenir la propriété de la ressource.
        return null;
    }

    @Override
    public void replaceBy(Cell cell) {
        // Implémentez la logique pour remplacer cette cellule par une autre.
    }

    @Override
    public boolean move(IMovable movable) {
        // Implémentez la logique pour gérer le déplacement d'un objet mobile.
        return false;
    }

    @Override
    public boolean dig(IMovable player) {
        // Implémentez la logique pour extraire des ressources.
        return false;
    }
}
