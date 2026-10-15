package com.example.textcounter;

public class TextCounter {

    public int countWords(String text) {
        String trimmedText = text.trim();

        if (trimmedText.isEmpty()) {
            return 0;
        }

        return trimmedText.split("\\s+").length;
    }

    public int countCharacters(String text) {
        return text.codePointCount(0, text.length());
    }
}