package com.example.TASK1;

/**
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * <p>
 * <p>
 * <p>
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
    private String palindrome = "madam";

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }

    public boolean isPalindrome() {
        int lengthPalidrome = palindrome.length() - 1;
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != palindrome.charAt(lengthPalidrome)) {
                return false;
            }
            lengthPalidrome--;
        }
        return true;
    }
}