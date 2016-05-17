package psu.kit.tanya;

import java.util.Scanner;

public class TanyaCalculator {


    public TanyaReaction calculate(String s, String t) {

        int[] cnt = new int[256];

        for (char i : t.toCharArray()) {
            cnt[i]++;
        }

        int yayCount = 0, whoopsCount = 0;
        boolean[] done = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] > 0) {
                yayCount++;
                cnt[s.charAt(i)]--;
                done[i] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!done[i]) {
                char c = s.charAt(i);
                if (c <= 'Z') {
                    c += 32;
                } else {
                    c -= 32;
                }
                if (cnt[c] > 0) {
                    cnt[c]--;
                    whoopsCount++;
                }
            }
        }
        return new TanyaReaction(yayCount, whoopsCount);

    }
}
