package psu.kit.tanya;

import java.util.Scanner;

public class TanyaCalculator {

    int[] countOfCharacters = new int[256];
    boolean[] used;

    public TanyaReaction calculate(String s, String t) {

 used = new boolean[s.length()];

        int countYay = tanyaYayCount(s, t);
        int countWhoops = tanyaWhoopsCount(s, t);

        return new TanyaReaction(countYay, countWhoops);
    }

    private int tanyaYayCount(String s, String t) {

        int countYay = 0;

        for (int i = 0; i < t.length(); i++) {
 countOfCharacters[t.charAt(i)] = countOfCharacters[t.charAt(i)] + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (countOfCharacters[s.charAt(i)] != 0) {
 countYay++;
 countOfCharacters[s.charAt(i)]--;
 used[i] = true;
            }
        }
        return countYay;
    }

    private int tanyaWhoopsCount(String s, String t) {

        char sStringSymbol;

        int countWhoops = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
 sStringSymbol = s.charAt(i);
                if (sStringSymbol <= 'Z') {
 sStringSymbol = Character.toLowerCase(sStringSymbol);
 } else {
 sStringSymbol = Character.toUpperCase(sStringSymbol);
                }
                if (countOfCharacters[sStringSymbol] != 0) {
 countOfCharacters[sStringSymbol]--;
 countWhoops++;
                }
            }
        }
        return countWhoops;
    }
}