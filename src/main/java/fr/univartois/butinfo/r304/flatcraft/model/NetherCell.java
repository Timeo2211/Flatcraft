package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.ObjectProperty;

public class NetherCell implements Cell {
    @Override
    public int getRow() {
        // Implémentez la logique pour obtenir la ligne spécifique au Nether.
        return 0;
    }

    @Override
    public int getColumn() {
        // Implémentez la logique pour obtenir la colonne spécifique au Nether.
        return 0;
    }

    @Override
    public Sprite getSprite() {
        // Implémentez la logique pour obtenir le sprite spécifique au Nether.
        return null;
    }

    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        // Implémentez la logique pour obtenir la propriété du sprite spécifique au Nether.
        return null;
    }

    @Override
    public Resource getResource() {
        // Implémentez la logique pour obtenir la ressource spécifique au Nether.
        return null;
    }

    @Override
    public ObjectProperty<Resource> getResourceProperty() {
        // Implémentez la logique pour obtenir la propriété de la ressource spécifique au Nether.
        return null;
    }

    @Override
        public void replaceBy(Cell cell) {
        // Implémentez la logique pour remplacer cette cellule du Nether par une autre.
    }

    @Override
    public boolean move(IMovable movable) {
        // Implémentez la logique pour gérer le déplacement d'un objet mobile spécifique au Nether.
        return false;
    }

    @Override
    public boolean dig(IMovable player) {
        // Implémentez la logique pour extraire des ressources dans le Nether.
        return false;
    }
}
