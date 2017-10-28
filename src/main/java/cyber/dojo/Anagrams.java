package cyber.dojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Anagrams {
    private Anagrams() {
        throw new IllegalStateException("Utility class");
    }


    static List<String> of(String input) {
        if (input.length() < 2) {
            return Collections.singletonList(input);
        }
        List<String> anagrams = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            List<String> anagramsAfterLetterDropped = of(getInputAfterDrop(input, i));
            for (String anAnagramAfterLetterDropped : anagramsAfterLetterDropped) {
                anagrams.add(input.substring(i, i + 1) + anAnagramAfterLetterDropped);
            }
        }
        return anagrams;
    }

    private static String getInputAfterDrop(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1, input.length());
    }
}
