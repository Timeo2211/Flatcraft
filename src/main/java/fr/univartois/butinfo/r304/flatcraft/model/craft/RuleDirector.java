package fr.univartois.butinfo.r304.flatcraft.model.craft;

public class RuleDirector {
    private RuleBuilder builder;

    public RuleDirector(RuleBuilder builder) {
        this.builder = builder;
    }

    public void constructRule(String input, String output, String conditions, int quantity) {
        builder.addInput(input);
        builder.addOutput(output);
        builder.setConditions(conditions);
        builder.setQuantity(quantity);

    }

    public CraftRule getRule() {
        return builder.getResult();
    }
}
