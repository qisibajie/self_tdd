package cyber.dojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BalancedParentheses {

    private BalancedParentheses() {
        throw new IllegalStateException("Utility class");
    }

    private static final Map<String, String> parenthesesMap = new HashMap<>();
    private static final List<String> parenhtheses = Arrays.asList("}", "]", ")");

    static {
        parenthesesMap.put("{", "}");
        parenthesesMap.put("[", "]");
        parenthesesMap.put("(", ")");
    }

    static boolean isBalanced(String input) {
        if (input.length() == 0) {
            return true;
        }
        if (input.length() % 2 != 0) {
            return false;
        }
        int minIndex = input.length();
        for (String str : parenhtheses) {
            if (minIndex > input.indexOf(str) && input.contains(str)) {
                minIndex = input.indexOf(str);
            }
        }
        String currentBalancedStr = input.substring(0, minIndex) + getCorrespondingStr(input.substring(0, minIndex));
        boolean isCurrentBalanced = (currentBalancedStr.length() <= input.length()) && input.substring(0, currentBalancedStr.length()).equals(currentBalancedStr);
        return isCurrentBalanced && isBalanced(input.substring(currentBalancedStr.length()));
    }

    private static String getCorrespondingStr(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.insert(0, parenthesesMap.get(str.substring(i, i + 1)));
        }
        return result.toString();
    }
}
