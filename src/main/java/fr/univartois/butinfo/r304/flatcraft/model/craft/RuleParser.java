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

package fr.univartois.butinfo.r304.flatcraft.model.craft;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La classe {@link RuleParser} permet de lire un fichier de règles de craft.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class RuleParser implements RuleBuilder {

    /**
     * Le nom du fichier depuis lequel les règles doivent être lues.
     */
    private final String fileName;

    /**
     * Crée une nouvelle instance de RuleParser.
     *
     * @param fileName Le nom du fichier depuis lequel les règles doivent être lues.
     */
    public RuleParser(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Lit les règles depuis le fichier associé.
     *
     * @throws IOException Si une erreur se produit au cours de la lecture.
     */
    public void parse() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] splitted = line.split("=");
                String[] result = splitted[1].split(" ");
                if (result.length == 1) {
                    addRule(splitted[0], result[0], 1);
                } else {
                    addRule(splitted[0], result[0], Integer.parseInt(result[1]));
                }
            }
        }
    }

    /**
     * Ajoute une règle ayant été lue.
     *
     * @param rule La règle à ajouter.
     * @param product Le résultat de l'application de la règle.
     * @param quantity La quantité obtenue pour la ressource produite.
     */
    private void addRule(String rule, String product, int quantity) {
        // Choisissez le bon constructeur en fonction du type de règle (table de craft ou fourneau)
        RuleBuilder builder;

        // Assumez que le type de règle est déterminé par une logique quelconque, par exemple, en analysant la règle.
        // Vous devez adapter cela en fonction de la logique réelle de votre application.
        if (rule.contains("craft")) {
            builder = new CraftRuleBuilder();
        } else if (rule.contains("furnace")) {
            builder = new FurnaceRuleBuilder();
        } else {
            // Gestion d'erreur ou une logique par défaut
            throw new IllegalArgumentException("Type de règle non pris en charge");
        }

        // Utilisez le directeur pour construire la règle
        RuleDirector director = new RuleDirector(builder);
        director.constructRule(rule, product, "",2); // Ajoutez les conditions si nécessaires

        // Obtenez le résultat et ajoutez la règle à votre gestionnaire de règles
        CraftRule result = director.getRule();
        result.setQuantity(quantity);
        // Ajoutez la règle à votre gestionnaire de règles

    }


    @Override
    public void addInput(String input) {

    }

    @Override
    public void addOutput(String output) {

    }

    @Override
    public void setConditions(String conditions) {

    }

    @Override
    public CraftRule getResult() {
        return null;
    }

    @Override
    public void setQuantity(int quantity) {

    }
}
