package com.codurance;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Anagram {
    public static String[] generate(String input) {
        List<String> output = new ArrayList<>();

//        output.add(input);

        return anagramsOf(input).toArray(new String[0]);

//        if (input.length() >= 3) {
//            output.add("acb");
//            output.add("bac");
//            output.add("bca");
//            output.add("cab");
//            output.add("cba");
//
//            System.out.println((anagramsOf(input)));
//
//            System.out.println(anagramsOf("abcd"));
//        }
//
//        if (input.length() > 1 && input.length() < 3)
//            output.add("ba");

//        return output.toArray(new String[0]);
    }

    private static List<String> anagramsOf(String word) {
        List<String> anagrams = new ArrayList<>();

        String reversedWord = new StringBuilder(word).reverse().toString();

        if (isLength(word, 1))
            anagrams.add(word);
        if (isLength(word, 2))
            anagrams = asList(word, reversedWord);
        if (isLengthGreaterThanTwo(word)) {
            handleWordsLongerThanTwo(word, anagrams);
        }
        return anagrams;
    }

    private static void handleWordsLongerThanTwo(String word, List<String> anagrams) {
        for (int index = 0; index < word.length(); index++) {
            List<String> subgrams = anagramsOf(extractRemainingLetters(word, index));
            char firstLetter = word.charAt(index);
            anagrams.addAll(apendFirstLetterToSubgram(subgrams, firstLetter));
        }
    }

    private static String extractRemainingLetters(String word, int j) {
        StringBuilder remainingLetters = new StringBuilder(word);
        remainingLetters.deleteCharAt(j);
        return remainingLetters.toString();
    }

    private static List<String> apendFirstLetterToSubgram(List<String> subgrams, char firstLetter) {
        List<String> anagrams = new ArrayList<>();

        for (int i = 0; i < subgrams.size(); i++) {
            anagrams.add(firstLetter + subgrams.get(i));
        }
        return anagrams;
    }

    private static boolean isLengthGreaterThanTwo(String word) {
        return word.length() > 2;
    }

    private static boolean isLength(String word, int length) {
        return word.length() == length;
    }
}
