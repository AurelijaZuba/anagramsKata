package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AnagramShould {


//    Write a program to generate all potential anagrams of an input string.
//    For example, the potential anagrams of "biro" are
//    biro bior brio broi boir bori
//    ibro ibor irbo irob iobr iorb
//    rbio rboi ribo riob roib robi
//    obir obri oibr oirb orbi orib

    @Test
    void acceptance_test() {
        String[] expected = {
                "biro", "bior", "brio", "broi", "boir", "bori",
                "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                "rbio", "rboi", "ribo", "riob", "roib", "robi",
                "obir", "obri", "oibr", "oirb", "orbi", "orib"
        };


        String[] results = Anagram.generate("biro");
        assertArrayEquals(expected, results);
    }

    @Test
    void return_a_single_letter_for_the_word_a() {
        String[] expected = {"a"};

        String[] results = Anagram.generate("a");

        assertArrayEquals(expected, results);
    }
}
