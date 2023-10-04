package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableMap;

public class Player extends AbstractMovable {

    private IntegerProperty life;
    private IntegerProperty experience;
    private ObservableMap<Resource, Integer> inventory;

    protected Player(FlatcraftGame game, double xPosition, double yPosition, fr.univartois.butinfo.r304.flatcraft.view.Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }

    public int getLife() {
        return life.get();
    }

    public IntegerProperty lifeProperty() {
        return life;
    }

    public void setLife(int life) {
        this.life.set(life);
    }

    public int getExperience() {
        return experience.get();
    }

    public IntegerProperty experienceProperty() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience.set(experience);
    }

    public ObservableMap<Resource, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(ObservableMap<Resource, Integer> inventory) {
        this.inventory = inventory;
    }
}
