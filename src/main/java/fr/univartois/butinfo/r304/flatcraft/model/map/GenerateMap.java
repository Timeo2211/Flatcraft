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


    public SimpleGameMap generateMap(){
        return new SimpleGameMap(height, width, 0);
    }
    public generateSky(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSky());
            }
        }
    }

    public generateSoilSurface(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSubSoil());
            }
        }
    }

    public generateSubSoil(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSubSoil());
            }
        }
    }
}
