import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();

        String current = words[0];
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || current.charAt(current.length() - 1) != words[i].charAt(0) ) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            } else {
               set.add(words[i]);
                current = words[i];
            }
        }
        return new int[]{0, 0};
    }
}