package cyber.dojo;

class CountCoins {

    private CountCoins() {
        throw new IllegalStateException("Utility class");
    }

    static int count(int input) {
        if (input < 5 && input >= 0) {
            return 1;
        }

        int actual = input - input % 5 - 5;
        if (input < 15 && input >= 5) {
            return count(actual) * 2;
        } else {
            return count(actual) + actual / 5;
        }
    }
}

