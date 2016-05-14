package psu.kit.tanya;

public class TanyaCalculator {
    public TanyaReaction calculate(String s, String t) {
        int[] tArray = new int[255];
        String sCopy = s;
        StringBuilder tmp = new StringBuilder();
        int yay, whoops;

        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i)]++;
        }

        yay = countReaction(sCopy, tArray, tmp) ;
        sCopy = tmp.toString();
        whoops = countReaction(sCopy, tArray, tmp);

        return new TanyaReaction(yay, whoops);
    }

    private int countReaction(String s, int[] tArray, StringBuilder reversedLastCharacters) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (tArray[s.charAt(i)]  0) {
                count++;
                tArray[s.charAt(i)]--;
            } else {
                reversedLastCharacters.append(
                        (Character.isUpperCase(s.charAt(i)))
                        Character.toLowerCase(s.charAt(i))
                        Character.toUpperCase(s.charAt(i)));
            }
        }
        return count;
    }

}
