package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class MyCell extends AbstractCell{

    private int row;
    private int column;

    public MyCell(int row, int column) {
        super(row, column);
    }


    public MyCell(Sprite sprite) {
        super(sprite);
    }

    public MyCell(Resource resource) {
        super(resource);
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
