package com.java.testassignment;

public abstract class ConceptBase {
    protected String conceptText;

    ConceptBase(String text) {
        this.conceptText = text;
    }

    public abstract String formattedText();
}