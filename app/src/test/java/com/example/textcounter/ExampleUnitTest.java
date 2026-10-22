package com.example.textcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {

    private final TextCounter textCounter = new TextCounter();

    @Test
    public void countWords_emptyText_returnsZero() {
        assertEquals(0, textCounter.countWords(""));
    }

    @Test
    public void countWords_normalText_returnsThree() {
        assertEquals(3, textCounter.countWords("Labas mano pasauli"));
    }

    @Test
    public void countWords_onlySpaces_returnsZero() {
        assertEquals(0, textCounter.countWords("   "));
    }

    @Test
    public void countWords_onlyTabs_returnsZero() {
        assertEquals(0, textCounter.countWords("\t\t"));
    }

    @Test
    public void countWords_extraSpaces_returnsTwo() {
        assertEquals(2, textCounter.countWords("  Labas   pasauli  "));
    }

    @Test
    public void countWords_tabsBetweenWords_returnsTwo() {
        assertEquals(2, textCounter.countWords("Labas\tpasauli"));
    }

    @Test
    public void countWords_newLinesBetweenWords_returnsThree() {
        assertEquals(3, textCounter.countWords("Labas\nmano\npasauli"));
    }

    @Test
    public void countCharacters_emptyText_returnsZero() {
        assertEquals(0, textCounter.countCharacters(""));
    }

    @Test
    public void countCharacters_normalText_returnsThirteen() {
        assertEquals(13, textCounter.countCharacters("Labas pasauli"));
    }

    @Test
    public void countCharacters_onlySpaces_returnsThree() {
        assertEquals(3, textCounter.countCharacters("   "));
    }

    @Test
    public void countCharacters_onlyTabs_returnsTwo() {
        assertEquals(2, textCounter.countCharacters("\t\t"));
    }

    @Test
    public void countCharacters_newLine_countsAsCharacter() {
        assertEquals(3, textCounter.countCharacters("A\nB"));
    }

    @Test
    public void countCharacters_lithuanianLetters_returnsNine() {
        assertEquals(9, textCounter.countCharacters("ąčęėįšųūž"));
    }

    @Test
    public void countCharacters_singleEmoji_returnsOne() {
        assertEquals(1, textCounter.countCharacters("\uD83D\uDE00"));
    }
}