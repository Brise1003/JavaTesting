package com.platzi.javatest.RomanNumbers;

import java.util.List;

public class RomanNumbers {

    public static String arabicToRoman(int n){
        if (n <=0 || n>4000){
            throw new IllegalArgumentException(n + " is not in range (0,4000].");
        }

        List<RomanNumerals> romanNumerals = RomanNumerals.getReverseSortedValues();

        int i=0;
        StringBuilder sb = new StringBuilder();

        while (n>0 && i< romanNumerals.size()){
            RomanNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= n){
                sb.append(currentSymbol.name());
                n -= currentSymbol.getValue();
            } else {i++;}
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(arabicToRoman(2144));
    }
}
