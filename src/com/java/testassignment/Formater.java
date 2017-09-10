package com.java.testassignment;

import java.util.Queue;

public class Formater {
    private static StringBuffer result = new StringBuffer();

    public static String getFormatedText(Queue<ConceptBase> concepts) {
        while (!concepts.isEmpty()) {
            ConceptBase concept = concepts.peek();
            result.append(concept.formattedText());

            concepts.poll();

            if (!concepts.isEmpty())
                result.append(" ");
        }
        return result.toString();
    }
}