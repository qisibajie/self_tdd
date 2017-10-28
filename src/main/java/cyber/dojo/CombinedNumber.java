package cyber.dojo;

import java.util.ArrayList;
import java.util.List;

class CombinedNumber {
    static String combine(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return String.valueOf(numbers.get(0));
        }

        /*if (numbers.size() == 2) {
            String firstCombine = String.valueOf(numbers.get(0)) + String.valueOf(numbers.get(1));
            String secondCombine = String.valueOf(numbers.get(1)) + String.valueOf(numbers.get(0));
            return firstCombine.compareTo(secondCombine) >= 0 ? firstCombine : secondCombine;
        }*/
        String result = "";
        for (int i = 0; i < numbers.size(); i++) {
            String combinedStr = combine(listAfterDropOneNumberAt(numbers, i)) + combine(numbers.subList(i, i + 1));
            if (result.compareTo(combinedStr) < 0) {
                result = combinedStr;
            }
        }
        return result;
    }

    private static List<Integer> listAfterDropOneNumberAt(List<Integer> integers, int index) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(integers.subList(0, index));
        numbers.addAll(integers.subList(index + 1, integers.size()));
        return numbers;
    }
}
