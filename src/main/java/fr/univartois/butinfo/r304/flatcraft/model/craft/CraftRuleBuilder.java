package fr.univartois.butinfo.r304.flatcraft.model.craft;

public class CraftRuleBuilder implements RuleBuilder {
private String input;
    private String output;
    private String conditions;
    private int quantity;

    @Override
    public void addInput(String input) {
        this.input = input;
    }

    @Override
    public void addOutput(String output) {
        this.output = output;
    }

    @Override
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public CraftRule getResult() {
        return new CraftRule(input, output, conditions, quantity);
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
