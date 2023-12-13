package fr.univartois.butinfo.r304.flatcraft.model.craft;

public class CraftRule {
    private String input;
    private String output;
    private String conditions;
    private int quantity;

    public CraftRule(String input, String output, String conditions, int quantity) {
        this.input = input;
        this.output = output;
        this.conditions = conditions;
        this.quantity = quantity;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public String getConditions() {
        return conditions;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CraftRule{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", conditions='" + conditions + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CraftRule)) return false;

        CraftRule craftRule = (CraftRule) o;

        if (quantity != craftRule.quantity) return false;
        if (input != null ? !input.equals(craftRule.input) : craftRule.input != null) return false;
        if (output != null ? !output.equals(craftRule.output) : craftRule.output != null) return false;
        return conditions != null ? conditions.equals(craftRule.conditions) : craftRule.conditions == null;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
