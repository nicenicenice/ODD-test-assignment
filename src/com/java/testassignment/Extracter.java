package com.java.testassignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extracter {
    private String textToExtract;
    Extracter(String text) {
        this.textToExtract = text;
    }

    private static final Pattern entityPattern = Pattern.compile("^[A-ZА-Я][a-zа-я\\-\\_\\,\\:\\#\\.0-9]+$");
    private static final Pattern lowerCaseWordPattern = Pattern.compile("^[^(A-ZА-Я@)][a-zа-яA-ZА-Я\\-\\_\\,\\:\\#\\.0-9]+$");
    private static final Pattern linkPattern = Pattern.compile("^(http:\\/\\/|https:\\/\\/)[a-zA-Zа-яА-Я0-9\\.\\%\\-\\?\\$\\=\\/\\#]+$");
    private static final Pattern twitterPattern = Pattern.compile("^[@][a-zа-я\\-\\_\\.]+$");

    private Queue<ConceptBase> concepts = new LinkedList<>();

    private ConceptBase getConceptByString(String word) {

        Matcher matcher;

        matcher = entityPattern.matcher(word);
        if (matcher.matches()) {
            return new EntityConcept(word);
        }

        matcher = lowerCaseWordPattern.matcher(word);
        if (matcher.matches()) {
            return new TextConcept(word);
        }

        matcher = linkPattern.matcher(word);
        if (matcher.matches()) {
            return new LinkConcept(word);
        }

        matcher = twitterPattern.matcher(word);
        if (matcher.matches()) {
            return new TwitterConcept(word.substring(1));
        }

        return null;
    }

    public Queue<ConceptBase> extractConcepts() {

        String[] words = textToExtract.split(" ");
        for (String word : words) {
            ConceptBase concept = getConceptByString(word);
            if (concept != null)
                concepts.offer(getConceptByString(word));
        }
        return concepts;
    }
}