package by.epamtc.degtyarovea;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class StringFormatter {

    private final static String SPACE = " ";
    private final static String EMPTY = "";

    public static String getEvenChars(String text) {
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                even.append(text.charAt(i));
            }
        }

        return even.toString();
    }

    public static String getOddChars(String text) {
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                odd.append(text.charAt(i));
            }
        }

        return odd.toString();
    }

    public static double getUppercaseRatio(String text) {
        int countUpper = getCountUpper(text);
        int countLower = text.length() - countUpper;

        return (double) countUpper / countLower;
    }

    private static int getCountUpper(String text) {
        int countUpper = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                countUpper++;
            }
        }

        return countUpper;
    }

    public static String deleteSameChars(String text) {
        StringBuilder stringBuilder = new StringBuilder();

        text.chars().distinct().forEach(c -> stringBuilder.append((char) c));
        return stringBuilder.toString();
    }

    public static Map<Character, Integer> getCharsFrequency(String text) {
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
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public static String insertSubstring(String origin, String sub, int offset) {
        if (offset < 0 || offset > origin.length()) {
            return origin;
        }
        StringBuilder stringBuilder = new StringBuilder(origin);
        stringBuilder.insert(offset, sub);

        return stringBuilder.toString();
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
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = getWords(text);

        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            if (i != 0) {
                stringBuilder.append(SPACE);
            }
        }

        return stringBuilder.toString();
    }

    public static String replaceSpacesWithAsterisk(String text) {
        return text.replaceAll("\\s+", "*");
    }

    public static String replaceCharAtLongestWord(String text) {
        String[] words = getWords(text);
        int longestWord = getIndexOfLongestWord(words);

        words[longestWord] = words[longestWord].replaceAll("a", "b");

        return String.join(SPACE, words);
    }

    private static int getIndexOfLongestWord(String[] words) {
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[index].length() < words[i].length()) {
                index = i;
            }
        }

        return index;
    }

    public static int lengthOfShortestWord(String text) {
        String[] words = getWords(text);
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

    public static int getWordsCount(String text) {
        String[] words = getWords(text);
        return words.length;
    }

    public static String swapWords(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.length());
        String[] words = getWords(text);

        if (words.length < 2) {
            return words[0];
        }

        for (int i = 1; i < words.length; i += 2) {
            stringBuilder.append(words[i])
                    .append(SPACE)
                    .append(words[i - 1]);
            if (i != words.length - 1) {
                stringBuilder.append(SPACE);
            }
        }

        return stringBuilder.toString();
    }

    public static String removeLastWord(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = getWords(text.trim());

        for (int i = 0; i < words.length - 1; i++) {
            if (i != 0) {
                stringBuilder.append(SPACE);
            }
            stringBuilder.append(words[i]);
        }

        return stringBuilder.toString();
    }

    public static String addSpaces(String text) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(text.charAt(i))
                    .append(SPACE);
        }

        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String reversedText;

        reversedText = stringBuilder.reverse().toString();
        return text.equals(reversedText);
    }

    public static String replaceSubstring(String origin, String sub, String newSub) {
        return origin.replace(sub, newSub);
    }

    public static String addBigInteger(String operand1, String operand2) {
        BigInteger sum = new BigInteger(operand1);
        sum = sum.add(new BigInteger(operand2));

        return sum.toString();
    }

    public static String removeWordsByLength(String text, int wordLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = getWords(text);

        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                stringBuilder.append(SPACE);
            }
            if (words[i].length() != wordLength) {
                stringBuilder.append(words[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static String removeExactSpaces(String text) {
        return text.trim().replaceAll("\\s{2,}", SPACE);
    }

    public static String[] getWords(String text) {
        return text.split("[\\s]+");
    }
}
