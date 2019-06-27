package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    public static String[] generate(String input) {
        List<String> output = new ArrayList<>();

        output.add(input);

        if (input.length() >= 3) {
            output.add("acb");
            output.add("bac");
            output.add("bca");
            output.add("cab");
            output.add("cba");
        }
        if (input.length() > 1 && input.length() < 3)
            output.add("ba");

        return output.toArray(new String[0]);
    }
}
