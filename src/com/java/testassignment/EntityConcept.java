package com.java.testassignment;

public class EntityConcept extends ConceptBase {
    EntityConcept(String text) {
        super(text);
    }

    @Override
    public String formattedText() {
        return "<strong>" + conceptText + "</strong>";
    }
}
