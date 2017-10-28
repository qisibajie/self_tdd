package cyber.dojo;

import java.util.HashMap;
import java.util.Map;

class BalancedParentheses {

    private static final Map<String, String> parenthesMap = new HashMap<>();

    static {
        parenthesMap.put("}", "{");
        parenthesMap.put("]", "[");
        parenthesMap.put(")", "(");
    }

    static boolean isBalanced(String input) {
        if (input.length() % 2 != 0) {
            return false;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String currentChar = input.substring(i, i + 1);
            if (parenthesMap.get(currentChar) == null) {
                result.append(currentChar);
            } else {
                if (result.substring(result.length() - 1).equals(parenthesMap.get(currentChar))) {
                    result = new StringBuilder(result.substring(0, result.length() - 1));
                } else {
                    return false;
                }
            }
        }
        return result.length() == 0;
    }
}
