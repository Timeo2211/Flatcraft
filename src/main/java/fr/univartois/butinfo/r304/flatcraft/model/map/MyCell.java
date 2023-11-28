package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class MyCell extends AbstractCell{

    private int row;
    private int column;

    private Cell cell;

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

    //Implantez le code représentant le cas où la cellule est vide. Dans ce cas, lorsque le joueur essaye de creuser sur la cellule, il ne doit rien se passer. De plus, lorsque le joueur se trouve au dessus de la cellule, celle-ci doit le faire descendre d'une case.
    @Override
    public void celluleVide(Cell cell) {
        cell.celluleVide(this);

    }
    //Implantez le code représentant le cas où la cellule contient une ressource. Cette fois-ci, lorsque le joueur se trouve au dessus de la cellule, il ne bouge plus. En revanche, lorsqu'il essaye de creuser, la ressource contenue reçoit un coup, et si cela suffit à la récupérer, alors la cellule doit devenir vide.

    public Resource celluleRessource(Cell cell) {
        Sprite sprite = cell.getSprite();
        if (sprite.equals("mineral_coal")) {
            return new Resource("coal", cell.getSprite(), null, 1);
        } else if (sprite.equals("mineral_iron")) {
            return new Resource("iron", cell.getSprite(), null, 2);
        } else if (sprite.equals("mineral_gold")) {
            return new Resource("gold", cell.getSprite(), null, 3);
        } else if (sprite.equals("mineral_diamond")) {
            return new Resource("diamond", cell.getSprite(), null, 4);
        }else {
            return new Resource("air", cell.getSprite(), null, 0);
        }

    }

}
