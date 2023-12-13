package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class LumpEtat implements IRessourceEtat {

    @Override
    public void nextEtat(Resource resource) {
        System.out.println("not yet implemented");
    }

    public static void newSprite(Resource resource) {
        String[] tab = resource.getSprite("lump").getImage().getUrl().split("/");
        String[] tab2 = tab[tab.length - 1].split("\\.");
        String name = tab2[1];
        switch (name) {
            case "stone":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_coble").getImage()));
                break;
            case "clay":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_caly_lump").getImage()));
                break;
            case "obsidian":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_obsidian_lump").getImage()));
                break;
            case "coal":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_coal_lump").getImage()));
                break;
            case "iron":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_iron_lump").getImage()));
                break;
            case "gold":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_gold_lump").getImage()));
                break;
            case "diamond":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_diamond_lump").getImage()));
                break;
            case "emerald":
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_emerald_lump").getImage()));
                break;
            default:
                name = tab2[2];
                resource.setSprite(new Sprite(resource.getSpriteStore().getSprite("default_" + name + "_lump").getImage()));
        }
    }
}
