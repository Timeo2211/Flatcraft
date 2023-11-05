package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;



public class Mob implements IMovable {

    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private double speed;
    private Sprite sprite;


    /**
     * Donne la largeur de cet objet.
     *
     * @return La largeur de cet objet.
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Donne la hauteur de cet objet.
     *
     * @return La hauteur de cet objet.
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Modifie la position en x de cet objet.
     *
     * @param xPosition La nouvelle position en x de cet objet.
     */
    @Override
    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Donne la position en x de cet objet.
     *
     * @return La position en x de cet objet.
     */
    @Override
    public int getX() {
        return xPosition;
    }

    /**
     * Donne la propriété liée à la position en x de cet objet.
     *
     * @return La propriété liée à la position en x de cet objet.
     */
    @Override
    public DoubleProperty getXProperty() {
        return null;
    }

    /**
     * Modifie la position en y de cet objet.
     *
     * @param yPosition La nouvelle position en y de cet objet.
     */
    @Override
    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Donne la position en y de cet objet.
     *
     * @return La position en y de cet objet.
     */
    @Override
    public int getY() {
        return yPosition;
    }

    /**
     * Donne la propriété liée à la position en y de cet objet.
     *
     * @return La propriété liée à la position en y de cet objet.
     */
    @Override
    public DoubleProperty getYProperty() {
        return null;
    }

    /**
     * Modifie la vitesse horizontale de cet objet.
     *
     * @param speed La nouvelle vitesse horizontale de cet objet (en pixels/s).
     */
    @Override
    public void setHorizontalSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Donne la vitesse horizontale de cet objet.
     *
     * @return La vitesse horizontale de cet objet (en pixels/s).
     */
    @Override
    public double getHorizontalSpeed() {
        return speed;
    }

    /**
     * Modifie la vitesse verticale de cet objet.
     *
     * @param speed La nouvelle vitesse verticale de cet objet (en pixels/s).
     */
    @Override
    public void setVerticalSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Donne la vitesse verticale de cet objet.
     *
     * @return La vitesse verticale de cet objet (en pixels/s).
     */
    @Override
    public double getVerticalSpeed() {
        return speed;
    }

    /**
     * Modifie l'instance de {@link Sprite} représentant cet objet.
     *
     * @param sprite La nouvelle instance de {@link Sprite} représentant cet objet.
     */
    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Donne l'instance de {@link Sprite} représentant cet objet.
     *
     * @return L'instance de {@link Sprite} représentant cet objet.
     */
    @Override
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Donne la propriété de cet objet correspondant au {@link Sprite} qui le représente.
     *
     * @return La propriété de cet objet correspondant à son {@link Sprite}.
     */
    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return null;
    }

    /**
     * Déplace cet objet pour le mettre à sa nouvelle position, calculée à partir du temps
     * écoulé depuis son dernier déplacement et sa vitesse actuelle.
     *
     * @param timeDelta Le temps écoulé depuis le dernier déplacement de cet objet (en
     *        millisecondes).
     *
     * @return Si l'objet a pu être déplacé.
     *         Si ce n'est pas le cas, il a atteint le bord de la fenêtre, et est donc
     *         bloqué.
     */
    @Override
    public boolean move(long timeDelta) {
        double horizontalDistance = speed * timeDelta / 1000.0;

        xPosition += (int) horizontalDistance;

        if (xPosition < 0) {
            xPosition = 0;
            return false;
        } else if (xPosition > width) {
            xPosition =  width;
            return false;
        }
        return true;
    }

    /**
     * Donne l'objet réel qui implémente cette interface.
     *
     * @return L'objet réel.
     */
    @Override
    public IMovable self() {
        return this;
    }
}

