package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.*;
import javafx.collections.*;

public class Player extends AbstractMovable {

    private IntegerProperty life;
    private IntegerProperty experience;
    private ObservableMap<Resource, Integer> inventory;

    public Player(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.life = new SimpleIntegerProperty();
        this.experience = new SimpleIntegerProperty();
        this.inventory = FXCollections.observableHashMap();
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

    public void addResource(Resource resource, int quantity) {
        inventory.put(resource, inventory.get(resource) + quantity);
    }

    public void removeItemFromInventory(Resource resource) {
        int count = inventory.getOrDefault(resource, 0);
        if (count > 1) {
            inventory.put(resource, count - 1);
        } else {
            inventory.remove(resource);
        }
    }
}
