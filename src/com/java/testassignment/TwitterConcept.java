package com.java.testassignment;

public class TwitterConcept extends ConceptBase {
    TwitterConcept(String text) {
        super(text);
    }

    @Override
    public String formattedText() {
        return"@" + "<a href=\"http://twitter.com/@" + conceptText + "\">" + conceptText + "</a>";
    }
}
