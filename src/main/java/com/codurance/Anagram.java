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

        StringBuilder tempWord = new StringBuilder(word);
        StringBuilder reversedWord = tempWord.reverse();

        if(word.length() == 1)
            anagrams.add(word);
        if(word.length() == 2)
            anagrams = asList(word, reversedWord.toString());
        if(word.length() > 2) {
            for(int j = 0; j < word.length(); j++){
                StringBuilder remainingLetters = new StringBuilder(word);
                remainingLetters.deleteCharAt(j);
                List<String> subgrams = anagramsOf(remainingLetters.toString());
                for(int i = 0; i < subgrams.size(); i++) {
                    anagrams.add(word.charAt(j) + subgrams.get(i));
                }
            }
        }

        return anagrams;
    }
}
