package com.platzi.javatest.RomanNumbers;

import org.junit.Test;

import static com.platzi.javatest.RomanNumbers.RomanNumbers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class RomanNumbersShould {

    @Test
    public void return_added_letters(){
        assertThat(arabicToRoman(1), is("I"));
        assertThat(arabicToRoman(2), is("II"));
        assertThat(arabicToRoman(3), is("III"));
        assertThat(arabicToRoman(5), is("V"));
        assertThat(arabicToRoman(6), is("VI"));
        assertThat(arabicToRoman(7), is("VII"));
        assertThat(arabicToRoman(10), is("X"));
        assertThat(arabicToRoman(11), is("XI"));
        assertThat(arabicToRoman(15), is("XV"));
        assertThat(arabicToRoman(16), is("XVI"));
        assertThat(arabicToRoman(50), is("L"));
        assertThat(arabicToRoman(51), is("LI"));
        assertThat(arabicToRoman(55), is("LV"));
        assertThat(arabicToRoman(56), is("LVI"));
        assertThat(arabicToRoman(60), is("LX"));
        assertThat(arabicToRoman(70), is("LXX"));
        assertThat(arabicToRoman(80), is("LXXX"));
        assertThat(arabicToRoman(81), is("LXXXI"));
        assertThat(arabicToRoman(85), is("LXXXV"));
        assertThat(arabicToRoman(86), is("LXXXVI"));
        assertThat(arabicToRoman(126), is("CXXVI"));
        assertThat(arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void return_letters_when_substracted_numbers(){
        assertThat(arabicToRoman(4), is("IV"));
        assertThat(arabicToRoman(9), is("IX"));
        assertThat(arabicToRoman(14), is("XIV"));
        assertThat(arabicToRoman(19), is("XIX"));
        assertThat(arabicToRoman(24), is("XXIV"));
        assertThat(arabicToRoman(40), is("XL"));
        assertThat(arabicToRoman(49), is("XLIX"));
        assertThat(arabicToRoman(90), is("XC"));
        assertThat(arabicToRoman(99), is("XCIX"));
        assertThat(arabicToRoman(400), is("CD"));
        assertThat(arabicToRoman(900), is("CM"));

    }
}