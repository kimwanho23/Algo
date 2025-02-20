import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] solution(int[] answers) {
        int[] scores = new int[3];

        int[] onePattern = {1, 2, 3, 4, 5};
        int[] twoPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] threePattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (onePattern[i % onePattern.length] == answers[i]) scores[0]++;
            if (twoPattern[i % twoPattern.length] == answers[i]) scores[1]++;
            if (threePattern[i % threePattern.length] == answers[i]) scores[2]++;
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        int count = 0;
        for (int score : scores) {
            if (score == max) count++;
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                result[index++] = i + 1;
            }
        }

        return result;
    }
}