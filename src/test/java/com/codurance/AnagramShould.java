package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
                "rbio", "rboi", "ribo", "riob",  "robi","roib",
                "obir", "obri", "oibr", "oirb", "orbi", "orib"
        };


        String[] results = Anagram.generate("biro");
        assertArrayEquals(expected, results);
    }

    private static Stream<Arguments> letterAnagrams(){
        return Stream.of(
                arguments(new String[]{"a"}, "a"),
                arguments(new String[]{"ab", "ba"}, "ab"),
                arguments(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}, "abc"),
                arguments(new String[]{"bcd", "bdc", "cbd", "cdb", "dbc", "dcb"}, "bcd")
        );
    }
    @ParameterizedTest
    @MethodSource("letterAnagrams")
    void generate_list_of_anagrams(String[] expected, String word) {
        String[] results = Anagram.generate(word);

        assertArrayEquals(expected, results);
    }
}
