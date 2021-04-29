package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public static final char CHAR_0 = '0';
    public static final char CHAR_9 = '9';

    public int addDigits(String input) {
        int result = -1;
        if (input == null || input.isBlank()) {
            return result;
        }
        result = 0;
        for (char item:input.toCharArray()) {
            if (item >= CHAR_0 && item <= CHAR_9) {
                result += item - CHAR_0;
            }
        }
        return result;
    }
}
