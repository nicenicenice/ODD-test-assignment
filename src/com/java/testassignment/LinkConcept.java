package com.java.testassignment;

public class LinkConcept extends ConceptBase {
    LinkConcept(String text) {
        super(text);
    }

    @Override
    public String formattedText() {
        return "<a href=\"" + conceptText + "\">" + conceptText + "</a>";
    }
}