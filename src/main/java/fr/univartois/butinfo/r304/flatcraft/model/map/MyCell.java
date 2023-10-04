package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class MyCell extends AbstractCell{

    private int row;
    private int column;

    protected MyCell(int row, int column) {
        super(row, column);
    }


    protected void AbstractCell(Sprite sprite) {
        this.getSpriteProperty().set(sprite);
    }

    protected void AbstractCell(Resource resource) {
        this.getResourceProperty().set(resource);
        this.getSpriteProperty().set(resource.getSprite());
    }

    @Override
    public boolean move(IMovable movable) {
        if (this.getResourceProperty().get() == null) {
            movable.setX(this.getColumn() * this.getSpriteProperty().get().getWidth());
            movable.setY(this.getRow() * this.getSpriteProperty().get().getHeight());
            return true;
        }
        return false;
    }



    @Override
    public boolean dig(IMovable player) {
        if (this.getResourceProperty().get() != null) {
            player.setX(this.getColumn() * this.getSpriteProperty().get().getWidth());
            player.setY(this.getRow() * this.getSpriteProperty().get().getHeight());
            this.getResourceProperty().set(null);
            this.getSpriteProperty().set(null);
            return true;
        }
        return false;
    }
}
