package by.epamtc.degtyarovea;

import java.util.Arrays;

import static by.epamtc.degtyarovea.StringFormatter.*;

public class StringFormatterMain {

    public static void main(String[] args) {
        String originText = "hhhHHH";

        // Task 1
        System.out.printf("1. Even: '%s', odd: '%s'.%n",
                getEvenChars(originText),
                getOddChars(originText));

        // Task 2
        System.out.printf("2. Ratio of uppercase to lowercase is %.2f.%n",
                getUppercaseRatio(originText));

        // Task 3
        System.out.printf("3. Text without the same chars: %s.%n",
                deleteSameChars(originText));

        // Task 4
        System.out.printf("4. Chars frequency: %s.%n",
                getCharsFrequency(originText));

        // Task 5
        System.out.printf("5. Reversion: %s.%n", revert(originText));

        // Task 6
        System.out.printf("6. With insert substring: %s.%n",
                insertSubstring(originText, "_SUB_", 1));

        // Task 7
        System.out.printf("7. With delete substring: %s.%n",
                deleteSubstring(originText, "AA"));

        // Task 8
        System.out.printf("8. Substring copy: %s.%n",
                copySubstring(originText, 0, 2));

        // Task 9
        System.out.printf("9. Length of string: %d.%n", originText.length());

        // Task 10
        System.out.printf("10. Count substrings: %d.%n",
                countSubstrings(originText, "AA"));

        // Task 11
        System.out.printf("11. Words in revert order: %s.%n", revertWords(originText));

        // Task 12
        System.out.printf("12. String with replaced spaces on '*': %s.%n",
                replaceSpacesWithAsterisk(originText));

        // Task 13
        System.out.printf("13. Replace 'a' on 'b' in the longest word: %s.%n",
                replaceCharAtLongestWord(originText));

        // Task 14
        System.out.printf("14. Length of the shortest word: %d.%n",
                lengthOfShortestWord(originText));

        // Task 15
        System.out.printf("15. Count of word: %d.%n", getWordsCount(originText));

        // Task 16
        System.out.printf("16. Swap words: %s.%n", swapWords(originText));

        // Task 17
        System.out.printf("17. Without last word: %s.%n", removeLastWord(originText));

        // Task 18
        System.out.printf("18. With added spaces: %s.%n", addSpaces(originText));

        // Task 19
        System.out.printf("19. Is palindrome: %s.%n", isPalindrome(originText));

        // Task 20
        System.out.printf("20. Replaced substring: %s.%n",
                replaceSubstring(originText, "AA", "BB"));

        // Task 21
        String operand1 = "12345678";
        String operand2 = "87654321";
        System.out.printf("21. Add two numbers: %s + %s = %s.%n",
                operand1,
                operand2,
                addBigInteger(operand1, operand2));

        // Task 22
        int lengthToDelete = 3;
        System.out.printf("22. Remove words with length %d: %s.%n",
                lengthToDelete,
                removeWordsByLength(originText, lengthToDelete));

        // Task 23
        System.out.printf("23. Exact spaces are removed: %s.%n",
                removeExactSpaces(originText));

        // Task 24
        String[] words = getWords(originText);
        System.out.printf("24. Words: %s.%n", Arrays.toString(words));
    }
}
