package com.java.testassignment;

import java.util.Queue;

public class TestAssignment {
    public static void main(String[] args) {

        // module 1
        String twFeed = Loader.getTwitterFeed();
        System.out.println("Input: ");
        System.out.println(twFeed);

        // module 2
        Extracter twExtracter = new Extracter(twFeed);
        Queue<ConceptBase> concepts = twExtracter.extractConcepts();

        // module 3
        String resultString = Formater.getFormatedText(concepts);
        System.out.println("\nOutput: ");
        System.out.println(resultString);
    }
}
