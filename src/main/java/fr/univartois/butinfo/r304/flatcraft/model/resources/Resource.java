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

package fr.univartois.butinfo.r304.flatcraft.model.resources;

import java.util.Objects;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

/**
 * Une ressource est un élément de la carte avec lequel le joueur peut interagir.
 * Il peut soit l'extraire, soit la laisser sur place.
 *
 * @author Daniel Le Berre
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class Resource {

    /**
     * Le nom unique identifiant le type de cette ressource.
     */
    private final String name;

    /**
     * Le sprite représentant cette ressource.
     */
    private final Sprite sprite;

    /**
     * Le type d'outils nécessaire pour extraire cette ressource de la carte.
     */
    private final ToolType toolType;

    /**
     * La dureté de cette ressource.
     * Il s'agit du nombre de coups devant être appliqués avec un outil pour extraire
     * cette ressource depuis la map.
     */
    private int hardness;

    /**
     * Crée une nouvelle instance de Resource.
     *
     * @param name Le nom unique identifiant le type de la ressource.
     * @param sprite Le sprite représentant la ressource.
     * @param toolType Le type d'outils nécessaire pour extraire la ressource de la carte.
     * @param hardness La dureté initiale de la ressource.
     *
     * @throws IllegalArgumentException Si la valeur de {@code hardness} est négative.
     */
    public Resource(String name, Sprite sprite, ToolType toolType, int hardness) {
        if (hardness < 0) {
            throw new IllegalArgumentException("Resource hardness should be non-negative!");
        }

        this.name = name;
        this.sprite = sprite;
        this.toolType = toolType;
        this.hardness = hardness;
    }

    /**
     * Donne le nom unique identifiant le type de cette ressource.
     *
     * @return Le nom de cette ressource.
     */
    public String getName() {
        return name;
    }

    /**
     * Donne le sprite représentant cette ressource.
     *
     * @return Le sprite représentant cette ressource.
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Donne le type d'outils nécessaire pour extraire cette ressource de la carte.
     *
     * @return Le type d'outils à utiliser.
     */
    public ToolType getToolType() {
        return toolType;
    }

    /**
     * Donne la dureté de cette ressource.
     * Il s'agit du nombre de coups devant être appliqués avec un outil pour extraire
     * cette ressource depuis la map.
     *
     * @return La dureté de cette ressource.
     */
    public int getHardness() {
        return hardness;
    }

    /**
     * Donne un coup sur cette ressource pour l'extraire de la carte.
     * Cela réduit sa dureté.
     *
     * @throws IllegalStateException Si la dureté de la ressource est déjà égale
     *         à {@code 0}.
     */
    public void dig() {
        if (hardness <= 0) {
            throw new IllegalStateException("Cannot dig resource with 0 hardness!");
        }
        hardness--;
    }

    /**
     * Donne la ressource obtenue lorsque cette ressource est extraite de la carte.
     * Par défaut, la ressource obtenue ne change pas.
     *
     * @return La ressource obtenue après son extraction.
     */
    public void inflictDamage() {
        if (hardness > 0) {
            hardness--;
        }
    }

    public Resource digBlock() {
        if (hardness == 0) {
            System.out.println("La ressource a été prélevée.");
            return new Resource(name, sprite, toolType, hardness);
        } else {
            System.out.println("La ressource ne peut pas encore être prélevée.");
            return null;
        }
    }

    public int getState() {
        if (hardness == 0) {
            return 0; // État de la ressource une fois prélevée
        } else if (hardness >= 3) {
            return 1; // État intact ou légèrement endommagé
        } else if (hardness == 2) {
            return 2; // État partiellement endommagé
        } else if (hardness == 1) {
            return 3; // État endommagé
        } else {
            return 4; // État très endommagé
        }
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Resource resource) {
            return name.equals(resource.name);
        }
        return false;
    }

}
