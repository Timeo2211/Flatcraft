package fr.univartois.butinfo.r304.flatcraft.model;

public interface IGenerateMap {
    GameMap generate(int height, int width, CellFactory cellFactory);
}
