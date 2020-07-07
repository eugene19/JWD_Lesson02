package by.epamtc.degtyarovea;

import java.util.Map;
import java.util.TreeMap;

public class StringFormatter {

    private final static String SPACE = " ";
    private final static String EMPTY = "";

    public static String evenChars(String text) {
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                even.append(text.charAt(i));
            }
        }

        return even.toString();
    }

    public static String oddChars(String text) {
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                odd.append(text.charAt(i));
            }
        }

        return odd.toString();
    }

    public static double uppercaseRatio(String text) {
        int countUpper = countUpper(text);

        return (double) countUpper / text.length();
    }

    private static int countUpper(String text) {
        int countUpper = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                countUpper++;
            }
        }

        return countUpper;
    }

    public static String deleteSameChars(String text) {
        StringBuilder builder = new StringBuilder();

        text.chars().distinct().forEach(c -> builder.append((char) c));
        return builder.toString();
    }

    public static Map<Character, Integer> charsFrequency(String text) {
        Map<Character, Integer> charFrequency = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            Integer frequency = charFrequency.get(currentChar);

            if (frequency != null) {
                charFrequency.put(currentChar, frequency + 1);
            } else {
                charFrequency.put(currentChar, 1);
            }
        }

        return charFrequency;
    }

    public static String revert(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();

        return builder.toString();
    }

    public static String insertSubstring(String origin, String sub, int offset) {
        if (offset < 0 || offset > origin.length()) {
            return origin;
        }
        StringBuilder builder = new StringBuilder(origin);
        builder.insert(offset, sub);

        return builder.toString();
    }

    public static String deleteSubstring(String origin, String sub) {
        return origin.replace(sub, EMPTY);
    }

    public static String copySubstring(String origin, int beginIndex, int endIndex) {
        return origin.substring(beginIndex, endIndex);
    }

    public static int countSubstrings(String text, String sub) {
        int count = 0;

        while (text.contains(sub)) {
            text = text.replaceFirst(sub, EMPTY);
            count++;
        }

        return count;
    }

    public static String revertWords(String text) {
        StringBuilder builder = new StringBuilder();
        String[] words = words(text);

        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i != 0) {
                builder.append(SPACE);
            }
        }

        return builder.toString();
    }

    public static String replaceSpacesWithAsterisk(String text) {
        String spaceSequenceRegex = "\\s+";
        return text.replaceAll(spaceSequenceRegex, "*");
    }

    public static String replaceCharAtLongestWord(String text) {
        String[] words = words(text);
        int maxLength = lengthOfLongestWord(words);

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == maxLength) {
                words[i] = words[i].replaceAll("a", "b");
            }
        }

        return String.join(SPACE, words);
    }

    private static int lengthOfLongestWord(String[] words) {
        int maxLength = words[0].length();
        int wordLength;

        for (String word : words) {
            wordLength = word.length();
            if (wordLength > maxLength) {
                maxLength = wordLength;
            }
        }

        return maxLength;
    }

    public static int lengthOfShortestWord(String text) {
        String[] words = words(text);
        int minLength = words[0].length();
        int wordLength;

        for (String word : words) {
            wordLength = word.length();
            if (wordLength < minLength) {
                minLength = wordLength;
            }
        }

        return minLength;
    }

    public static int wordsCount(String text) {
        String[] words = words(text);
        return words.length;
    }

    public static String swapWords(String text) {
        StringBuilder builder = new StringBuilder(text.length());
        String[] words = words(text);

        if (words.length < 2) {
            return words[0];
        }

        for (int i = 1; i < words.length; i += 2) {
            if (i != 1) {
                builder.append(SPACE);
            }
            builder.append(words[i])
                    .append(SPACE)
                    .append(words[i - 1]);
        }

        return builder.toString();
    }

    public static String removeLastWord(String text) {
        String[] words = words(text.trim());
        words[words.length - 1] = EMPTY;

        return String.join(SPACE, words);
    }

    public static String addSpaces(String text) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            builder.append(text.charAt(i))
                    .append(SPACE);
        }

        return builder.toString();
    }

    public static boolean isPalindrome(String text) {
        StringBuilder builder = new StringBuilder(text);
        String reversedText = builder.reverse().toString();

        return text.equals(reversedText);
    }

    public static String replaceSubstring(String origin, String sub, String newSub) {
        return origin.replace(sub, newSub);
    }

    public static String addBigInteger(String operand1, String operand2) {
        StringBuilder builder = new StringBuilder();
        int inMemory = 0;
        int currentSum;
        int currentDigit1;
        int currentDigit2;

        for (int i = operand1.length() - 1, j = operand2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i < 0) {
                currentDigit2 = Character.digit(operand2.charAt(j), 10);
                currentSum = currentDigit2 + inMemory;
            } else if (j < 0) {
                currentDigit1 = Character.digit(operand1.charAt(i), 10);
                currentSum = currentDigit1 + inMemory;
            } else {
                currentDigit1 = Character.digit(operand1.charAt(i), 10);
                currentDigit2 = Character.digit(operand2.charAt(j), 10);
                currentSum = currentDigit1 + currentDigit2 + inMemory;
            }

            if (currentSum >= 10) {
                inMemory = currentSum / 10;
                currentSum %= 10;
            } else {
                inMemory = 0;
            }

            builder.append(currentSum);
        }

        if (inMemory > 0) {
            builder.append(inMemory);
        }

        return builder.reverse().toString();
    }

    public static String removeWordsByLength(String text, int wordLength) {
        StringBuilder builder = new StringBuilder();
        String[] words = words(text);

        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                builder.append(SPACE);
            }
            if (words[i].length() != wordLength) {
                builder.append(words[i]);
            }
        }

        return builder.toString();
    }

    public static String removeExactSpaces(String text) {
        return text.trim().replaceAll("\\s{2,}", SPACE);
    }

    public static String[] words(String text) {
        return text.split("[\\s]+");
    }
}
