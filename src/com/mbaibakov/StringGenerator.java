package com.mbaibakov;

import java.util.Comparator;

public class StringGenerator {

    private static final char FIRST_CHAR = 'A';
    private static final char LAST_UPPERCASE_CHAR = 'Z';
    private static final char FIRST_LOWERCASE_CHAR = 'a';
    private static final char LAST_CHAR = 'z';
    private static final StringComparatorByLength COMPARATOR = new StringComparatorByLength();

    public void generateAndPrintStringsBetweenFirstAndSecond(String first, String second) {
        checkValidity(first);
        checkValidity(second);

        System.out.println("Starting to generate and print all strings between '" + first + "' and '" + second + "'");
        while (COMPARATOR.compare(first, second) < 0) {
            first = getNext(first);
            if (COMPARATOR.compare(first, second) < 0) {
                System.out.println(first);
            }
        }
        System.out.println("Generated and printed all strings between '" + first + "' and '" + second + "'");
    }

    private void checkValidity(String input) {
        if (!input.matches("[A-Za-z]*")) {
            throw new IllegalArgumentException("String '" + input + "' is not valid. It must consist only of letters.");
        }
    }

    private String getNext(String input) {
        char lastChar = input.charAt(input.length() - 1);
        String predicate = input.substring(0, input.length() - 1);
        if (LAST_CHAR == lastChar && input.length() == 1) {
            return "" + FIRST_CHAR + FIRST_CHAR;
        } else if (LAST_CHAR == lastChar) {
            return getNext(predicate) + FIRST_CHAR;
        }
        return predicate + String.valueOf(getNextChar(lastChar));
    }

    private char getNextChar(char character) {
        if (character == LAST_UPPERCASE_CHAR) {
            return FIRST_LOWERCASE_CHAR;
        }
        return (char) (character + 1);
    }

    static class StringComparatorByLength implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1 == null) {
                if (o2 == null) {
                    return 0;
                } else {
                    return -1;
                }
            }
            if (o2 == null) {
                return 1;
            }
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }
    }
}
