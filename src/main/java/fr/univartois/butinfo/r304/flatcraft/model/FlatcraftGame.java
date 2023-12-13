/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.r304.flatcraft.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import fr.univartois.butinfo.r304.flatcraft.model.craft.CraftRule;
import fr.univartois.butinfo.r304.flatcraft.model.map.GenerateMap;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import fr.univartois.butinfo.r304.flatcraft.model.movables.*;

/**
 * La classe {@link FlatcraftGame} permet de gérer une partie du jeu Flatcraft.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class FlatcraftGame {

    /**
     * La largeur de la carte du jeu affichée (en pixels).
     */
    private final int width;

    /**
     * La hauteur de la carte du jeu affichée (en pixels).
     */
    private final int height;

    /**
     * Le contrôleur de l'application.
     */
    private IFlatcraftController controller;

    /**
     * L'instance e {@link ISpriteStore} utilisée pour créer les sprites du jeu.
     */
    private ISpriteStore spriteStore;

    /**
     * L'instance de {@link CellFactory} utilisée pour créer les cellules du jeu.
     */
    private CellFactory cellFactory;

    /**
     * La carte du jeu, sur laquelle le joueur évolue.
     */
    private GameMap map;

    /**
     * Le temps écoulé depuis le début de la partie.
     */
    private IntegerProperty time = new SimpleIntegerProperty(12);

    /**
     * Le niveau actuel de la partie.
     */
    private IntegerProperty level = new SimpleIntegerProperty(1);

    /**
     * La représentation du joueur.
     */
    private IMovable player;

    private IMovable mob;

    /**
     * La liste des objets mobiles du jeu.
     */
    private List<IMovable> movableObjects = new CopyOnWriteArrayList<>();

    /**
     * L'animation simulant le temps qui passe dans le jeu.
     */
    private FlatcraftAnimation animation = new FlatcraftAnimation(this, movableObjects);

    private IGenerateMap generateMap;

    /**
     * Crée une nouvelle instance de FlatcraftGame.
     *
     * @param width La largeur de la carte du jeu (en pixels).
     * @param height La hauteur de la carte du jeu (en pixels).
     * @param spriteStore L'instance de {@link ISpriteStore} permettant de créer les
     *        {@link Sprite} du jeu.
     * @param factory La fabrique permettant de créer les cellules du jeux.
     */
    public FlatcraftGame(int width, int height, ISpriteStore spriteStore, CellFactory factory) {
        this.width = width;
        this.height = height;
        this.spriteStore = spriteStore;
        this.cellFactory = factory;
        this.cellFactory.setSpriteStore(spriteStore);
    }


    /**
     * Donne la largeur de la carte du jeu affichée (en pixels).
     *
     * @return La largeur de la carte du jeu affichée (en pixels).
     */
    public int getWidth() {
        return width;
    }

    /**
     * Donne la hauteur de la carte du jeu affichée (en pixels).
     *
     * @return La hauteur de la carte du jeu affichée (en pixels).
     */
    public int getHeight() {
        return height;
    }

    public void setGenerateMap(IGenerateMap generateMap){
        this.generateMap = generateMap;
    }

    /**
     * Associe à cette partie le contrôleur gérant l'affichage du jeu.
     *
     * @param controller Le contrôleur gérant l'affichage.
     */
    public void setController(IFlatcraftController controller) {
        this.controller = controller;
    }

    /**
     * Prépare la partie de Flatcraft avant qu'elle ne démarre.
     */
    public void prepare() {
        // On crée la carte du jeu.
        map = createMap();
        controller.prepare(map);
        // Ajoute a la liste movableObject ainsi qu'au controller pour crée ce joueur
        player = new Player(this, 0, (map.getSoilHeight()-1) *spriteStore.getSpriteSize(), spriteStore.getSprite("tool_steelpick"));
        movableObjects.add(player);
        controller.addMovable(player);
        controller.bindTime(time);
        controller.bindLevel(level);
        controller.bindHealth(((Player) player).lifeProperty());
        controller.bindXP(((Player) player).experienceProperty());

        // Ajoute a la liste movableObject ainsi qu'au controller pour crée ce mob
        mob = new OverworldMob(this, 0, (map.getSoilHeight()-1) *spriteStore.getSpriteSize(), spriteStore.getSprite("nc_front"), 0);
        movableObjects.add(mob);
        controller.addMovable(mob);


        // On démarre l'animation du jeu.
        animation.start();
    }

    /**
     * Crée la carte du jeu.
     *
     * @return La carte du jeu créée.
     */
    private GameMap createMap() {
        int mapHeight = height / spriteStore.getSpriteSize();
        int mapWidth = width / spriteStore.getSpriteSize();
        IGenerateMap generateMap = new GenerateMap(mapHeight, mapWidth, cellFactory);
        return generateMap.generate(mapHeight, mapWidth, cellFactory);

    }

    /**
     * Indique à cette partie de Flatcraft qu'une nouvelle heure s'est écoulée
     * (dans le jeu).
     */
    void oneHour() {
        time.set((time.get() + 1) % 24);
    }

    /**
     * Fait se déplacer le joueur vers le haut.
     */
    public void moveUp() {
        this.player.setVerticalSpeed(-100);
        if (this.player.getY() <= 0) {
            this.player.setVerticalSpeed(0);
        }
    }

    /**
     * Fait se déplacer le joueur vers le bas.
     */
    public void moveDown() {
        this.player.setVerticalSpeed(100);
        if (this.player.getY() >= (map.getSoilHeight()-1) *spriteStore.getSpriteSize()) {
            this.player.setVerticalSpeed(0);
        }
    }

    /**
     * Fait se déplacer le joueur vers la gauche.
     */
    public void moveLeft() {
        this.player.setHorizontalSpeed(-100);
    }

    /**
     * Fait se déplacer le joueur vers la droite.
     */
    public void moveRight() {
        this.player.setHorizontalSpeed(100);
    }

    /**
     * Déplace un objet mobile en tenant compte de la gravité.
     *
     * @param movable L'objet à déplacer.
     */
    private void move(IMovable movable) {
        Cell currentCell = getCellOf(movable);
        for (int row = currentCell.getRow() + 1; row < map.getHeight(); row++) {
            Cell below = map.getAt(row, currentCell.getColumn());
            if (!below.move(movable)) {
                break;
            }
        }
    }

    /**
     * Interrompt le déplacement du joueur.
     */
    public void stopMoving() {
        player.setHorizontalSpeed(0);
        this.player.setVerticalSpeed(0);
    }

    /**
     * Fait sauter le joueur.
     */
    public void jump() {
    }

    /**
     * Fait creuser le joueur vers le haut.
     */
    public void digUp() {
       // TODO : A compléter.
    }

    /**
     * Fait creuser le joueur vers le bas.
     */
    public void digDown() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getRow() + 1) < map.getHeight()) {
            dig(map.getAt(currentCell.getRow() + 1, currentCell.getColumn()));
        }
    }

    /**
     * Fait creuser le joueur vers la gauche.
     */
    public void digLeft() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getColumn() - 1) >= 0) {
            dig(map.getAt(currentCell.getRow(), currentCell.getColumn() - 1));
        }
    }

    /**
     * Fait creuser le joueur vers la droite.
     */
    public void digRight() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getColumn() + 1) < map.getWidth()) {
            dig(map.getAt(currentCell.getRow(), currentCell.getColumn() + 1));
        }
    }

    /**
     * Creuse la cellule donnée pour en extraire une ressource.
     *
     * @param toDig La cellule sur laquelle creuser.
     */
    private void dig(Cell toDig) {
        if (toDig!=null) {
            Cell sky = cellFactory.createSky();
            map.setAt(toDig.getRow(), toDig.getColumn(), sky);
        }
    }

    /**
     * Récupére la cellule correspondant à la position d'un objet mobile.
     * Il s'agit de la cellule sur laquelle l'objet en question occupe le plus de place.
     *
     * @param movable L'objet mobile dont la cellule doit être récupérée.
     *
     * @return La cellule occupée par l'objet mobile.
     */
    private Cell getCellOf(IMovable movable) {
        // On commence par récupérer la position du centre de l'objet.
        int midX = movable.getX() + (movable.getWidth() / 2);
        int midY = movable.getY() + (movable.getHeight() / 2);

        // On traduit cette position en position dans la carte.
        int row = midY / spriteStore.getSpriteSize();
        int column = midX / spriteStore.getSpriteSize();

        // On récupère enfin la cellule à cette position dans la carte.
        return map.getAt(row, column);
    }


    /**
     * Crée une nouvelle ressource à l'aide d'un ensemble de ressources, en suivant les
     * règles de la table de craft.
     *
     * @param inputResources Les ressources déposées sur la table de craft.
     *
     * @return La ressource produite.
     */
    public Resource craft(Resource[][] inputResources) {
        //Complétez les méthodes craft() et cook() de la classe FlatcraftGame afin d'appliquer les règles appropriées pour former une nouvelle ressource à partir de celles données en paramètres. Si aucune règle ne correspond, vous utiliserez la méthode displayError() du contrôleur afin d'afficher un message d'erreur à l'utilisateur.

        throw new UnsupportedOperationException("Pas encore implémentée !");
    }

    /**
     * Crée une nouvelle ressource à l'aide d'un combustible et d'une ressource, en suivant les
     * règles du fourneau.
     *
     * @param fuel Le matériau combustible utilisé dans le fourneau.
     * @param resource La ressource à transformer.
     *
     * @return La ressource produite.
     */
    public Resource cook(Resource fuel, Resource resource) {

        throw new UnsupportedOperationException("Pas encore implémentée !");
    }


}