package fr.univartois.butinfo.r304.flatcraft.model.craft;

// Builder interface
public interface RuleBuilder {
    void addInput(String input);
    void addOutput(String output);
    void setConditions(String conditions);
    CraftRule getResult();
    void setQuantity(int quantity);
}
