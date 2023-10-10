package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

public class GenerateMap {

    //Dans cette classe définissez une méthode retournant la carte générée.
    //Pour la génération, vous aurez besoin de la hauteur et de la largeur
    //(en nombre de cellules) de la carte à générer, ainsi que d'une
    //instance de CellFactory.

    private int height;
    private int width;
    private CellFactory cellFactory;

    private GameMap map;

    public GenerateMap(int height, int width, CellFactory cellFactory){
        this.height = height;
        this.width = width;
        this.cellFactory = cellFactory;
    }


    public static GameMap generate(int height, int width, CellFactory cellFactory){
        GameMap map = new SimpleGameMap(height, width, 2 * height / 3);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSky());
            }
        }

        for(int j = 0; j < width; j++){
            map.setAt(map.getSoilHeight(), j, cellFactory.createSoilSurface());
        }

        for(int i = map.getSoilHeight() + 1; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSubSoil());
            }
        }
        return map;
    }

}
