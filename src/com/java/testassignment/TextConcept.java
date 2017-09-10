package com.java.testassignment;

public class TextConcept extends ConceptBase {
    TextConcept(String text) {
        super(text);
    }

    @Override
    public String formattedText() {
        return conceptText;
    }
}