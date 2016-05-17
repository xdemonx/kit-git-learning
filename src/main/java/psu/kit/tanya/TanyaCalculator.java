package psu.kit.tanya;

public class TanyaCalculator {

    final static int ALPHABET_SIZE = 26;

    public TanyaReaction calculate(String s, String t) {

        int whoopsCount = 0;
        int yayCount = 0;

        int[] countT = new int[ALPHABET_SIZE * 2];
        int[] countS = new int[ALPHABET_SIZE * 2];

        countLetters(countS, s);
        countLetters(countT, t);

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            while (countS[i] > 0 && countT[i] > 0) {
                yayCount++;
                countS[i]--;
                countT[i]--;
            }
            while (countS[i + ALPHABET_SIZE] > 0 && countT[i + ALPHABET_SIZE] > 0) {
                yayCount++;
                countS[i + ALPHABET_SIZE]--;
                countT[i + ALPHABET_SIZE]--;
            }
            while (countS[i] > 0 && countT[i + ALPHABET_SIZE] > 0) {
                whoopsCount++;
                countS[i]--;
                countT[i + ALPHABET_SIZE]--;
            }
            while (countS[i + ALPHABET_SIZE] > 0 && countT[i] > 0) {
                whoopsCount++;
                countS[i + ALPHABET_SIZE]--;
                countT[i]--;
            }
        }

        return new TanyaReaction(yayCount, whoopsCount);
    }

    private int convertLetterToIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        } else {
            return c - 'a' + ALPHABET_SIZE;
        }
    }

    private void countLetters(int[] a, String s) {
        for (int i = 0; i < s.length(); i++) {
            a[convertLetterToIndex(s.charAt(i))]++;
        }
    }

}