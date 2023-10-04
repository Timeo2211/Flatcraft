package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableMap;

public class Player extends AbstractMovable {

    private IntegerProperty life;
    private IntegerProperty experience;
    private ObservableMap<Resource, Integer> inventory;

    protected Player(fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame game, double xPosition, double yPosition, fr.univartois.butinfo.r304.flatcraft.view.Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }


}
