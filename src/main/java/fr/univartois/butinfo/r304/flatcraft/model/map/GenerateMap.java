package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.*;

public class GenerateMap implements fr.univartois.butinfo.r304.flatcraft.model.IGenerateMap {

    //création d'un dictionnaire contenant les ressources et les cellules associées
    public static Map<Cell, Resource> resources = new HashMap<>();
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
            Resource newResource = new Resource("grass", cellFactory.createSubSoil().getSprite(), null, 1);
            resources.put(map.getAt(map.getSoilHeight(), j), newResource);
        }

        for(int i = map.getSoilHeight() + 1; i < height; i++){
            for(int j = 0; j < width; j++){
                map.setAt(i, j, cellFactory.createSubSoil());
                Resource newResource = new Resource("dirt", cellFactory.createSubSoil().getSprite(), null, 2);
                resources.put(map.getAt(i, j), newResource);
            }
        }

        Random posTerril = new Random();
        int pos = posTerril.nextInt(75);
        Random nbTerril = new Random();
        int nb = nbTerril.nextInt(5) + 1;
        for (int i = 0; i < nb; i++) {
            for(int j = 0; j < 5; j++){
                map.setAt(map.getSoilHeight() - 1, pos+j, cellFactory.createTerril());
                Resource newResource = new Resource("terril", cellFactory.createTerril().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 1, pos+j), newResource);
            }
            for(int j = 1; j < 4; j++){
                map.setAt(map.getSoilHeight() - 2, pos+j, cellFactory.createTerril());
                Resource newResource = new Resource("terril", cellFactory.createTerril().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 2, pos+j), newResource);
            }
            for(int j = 2; j < 3; j++){
                map.setAt(map.getSoilHeight() - 3, pos+j, cellFactory.createTerril());
                Resource newResource = new Resource("terril", cellFactory.createTerril().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 3, pos+j), newResource);
            }
            pos = posTerril.nextInt(75);
        }

        Random posTree = new Random();
        Random nbTree = new Random();
        int nbT = nbTree.nextInt(5) + 1;
        for (int i = 0; i < nbT; i++) {
            int posT = posTree.nextInt(75);

            while (map.getAt(map.getSoilHeight() - 1, posT) == cellFactory.createTerril()) {
                posT = posTree.nextInt(75);
            }

            for (int x = 0; x < 5; x++) {
                map.setAt(map.getSoilHeight() - 1 - x, posT, cellFactory.createTree());
                Resource newResource = new Resource("tronc", cellFactory.createTree().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 1 - x, posT), newResource);
            }
            for (int x = 0; x < 7; x++) {
                map.setAt(map.getSoilHeight() - 6, posT - 3 + x, cellFactory.createLeaves());
                Resource newResource = new Resource("leaves", cellFactory.createLeaves().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 6, posT - 3 + x), newResource);
            }
            for (int x = 0; x < 5; x++) {
                map.setAt(map.getSoilHeight() - 7, posT - 2 + x, cellFactory.createLeaves());
                Resource newResource = new Resource("leaves", cellFactory.createLeaves().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 7, posT - 2 + x), newResource);
            }
            for (int x = 0; x < 3; x++) {
                map.setAt(map.getSoilHeight() - 8, posT - 1 + x, cellFactory.createLeaves());
                Resource newResource = new Resource("leaves", cellFactory.createLeaves().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 8, posT - 1 + x), newResource);
            }
            for (int x = 0; x < 1; x++) {
                map.setAt(map.getSoilHeight() - 9, posT + x, cellFactory.createLeaves());
                Resource newResource = new Resource("leaves", cellFactory.createLeaves().getSprite(), null, 0);
                resources.put(map.getAt(map.getSoilHeight() - 9, posT + x), newResource);
            }
        }



        map.setAt(map.getSoilHeight() -1, 10, cellFactory.createMob());

        Random posRessource = new Random();
        int posH = posRessource.nextInt(74);
        int posV = posRessource.nextInt(height - map.getSoilHeight() - 1);
        int nbRessources= posRessource.nextInt(15) + 1;
        //Génération de plusieurs minerais placé aléatoirement
        for (int i = 0; i < nbRessources; i++) {
            int ressource = posRessource.nextInt(4);
            while (map.getAt(map.getSoilHeight() + posV, posH-1) == cellFactory.createRessource(ressource)) {
                posH = posRessource.nextInt(74);
                posV = posRessource.nextInt(height - map.getSoilHeight() - 1);
            }

            map.setAt(map.getSoilHeight() + posV, posH-1, cellFactory.createRessource(ressource));

            Cell cell = map.getAt(map.getSoilHeight() + posV, posH-1);
            Sprite sprite = cell.getSprite();
            resources.remove(cell);
            System.out.println(ressource);
            Resource newResource = new Resource("minerai", cellFactory.createSubSoil().getSprite(), null, ressource);
            resources.put(cell, newResource);

            posH = posRessource.nextInt(74);
            posV = posRessource.nextInt(height - map.getSoilHeight() - 1);
        }



        return map;
    }

}
