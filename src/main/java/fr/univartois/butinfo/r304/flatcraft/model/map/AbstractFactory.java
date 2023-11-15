package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Ender;
import fr.univartois.butinfo.r304.flatcraft.model.Nether;
import fr.univartois.butinfo.r304.flatcraft.model.OverWorld;

public interface AbstractFactory {

    Nether createCellNether();

    Ender createCellEnder();

    OverWorld createCellOverWorld();
}
