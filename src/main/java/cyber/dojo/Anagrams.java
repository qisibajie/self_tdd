package cyber.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {

    public static List<String> of(String input) {
        if (input.length() < 2) {
            return Arrays.asList(input);
        }
        List<String> anagrams = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            List<String> anagramsAfterLetterDropped = of(getInputAfterDrop(input, i));
            for (int j = 0; j < anagramsAfterLetterDropped.size(); j++) {
                anagrams.add(input.substring(i, i + 1) + anagramsAfterLetterDropped.get(j));
            }
        }
        return anagrams;
    }

    private static String getInputAfterDrop(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1, input.length());
    }
}
