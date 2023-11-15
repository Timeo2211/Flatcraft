package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Ender;
import fr.univartois.butinfo.r304.flatcraft.model.Nether;
import fr.univartois.butinfo.r304.flatcraft.model.OverWorld;

public class WorldCell implements AbstractFactory{

    @Override
    public Nether createCellNether() { return new Nether();}

    @Override
    public Ender createCellEnder() { return new Ender();}

    @Override
    public OverWorld createCellOverWorld(){return new OverWorld();}
}



