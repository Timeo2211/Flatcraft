package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import java.util.Random;

public class GenerateMap implements fr.univartois.butinfo.r304.flatcraft.model.IGenerateMap {

    private int height;
    private int width;
    private CellFactory cellFactory;

    private GameMap map;

    public GenerateMap(int height, int width, CellFactory cellFactory){
        this.height = height;
        this.width = width;
        this.cellFactory = cellFactory;
    }


    @Override
    public GameMap generate(int height, int width, CellFactory cellFactory){
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

        Random posTerril = new Random();
        int pos = posTerril.nextInt(75);
        Random nbTerril = new Random();
        int nb = nbTerril.nextInt(5) + 1;
        if(cellFactory.createTerril() != null) {
            for (int i = 0; i < nb; i++) {
                for (int j = 0; j < 5; j++) {
                    map.setAt(map.getSoilHeight() - 1, pos + j, cellFactory.createTerril());
                }
                for (int j = 1; j < 4; j++) {
                    map.setAt(map.getSoilHeight() - 2, pos + j, cellFactory.createTerril());
                }
                for (int j = 2; j < 3; j++) {
                    map.setAt(map.getSoilHeight() - 3, pos + j, cellFactory.createTerril());
                }
                pos = posTerril.nextInt(75);
            }
        }
        Random posTree = new Random();
        Random nbTree = new Random();
        int nbT = nbTree.nextInt(5) + 1;
        for (int i = 0; i < nbT; i++) {
            int posT = posTree.nextInt(75);

            while (map.getAt(map.getSoilHeight() - 1, posT) == cellFactory.createTerril()) {
                posT = posTree.nextInt(75);
            }
            if(cellFactory.createTree() != null) {
                for (int x = 0; x < 5; x++) {
                    map.setAt(map.getSoilHeight() - 1 - x, posT, cellFactory.createTree());
                }
            }
            if(cellFactory.createLeaves() != null){
                for (int x = 0; x < 7; x++) {
                    map.setAt(map.getSoilHeight() - 6, posT - 3 + x, cellFactory.createLeaves());
                }
                for (int x = 0; x < 5; x++) {
                    map.setAt(map.getSoilHeight() - 7, posT - 2 + x, cellFactory.createLeaves());
                }
                for (int x = 0; x < 3; x++) {
                    map.setAt(map.getSoilHeight() - 8, posT - 1 + x, cellFactory.createLeaves());
                }
                for (int x = 0; x < 1; x++) {
                    map.setAt(map.getSoilHeight() - 9, posT + x, cellFactory.createLeaves());
                }
            }
        }










        return map;
    }

}
