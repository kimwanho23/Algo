import java.util.ArrayList;

class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;

        for (int station : stations) {
            int left = index;
            int right = station - w - 1;

            if (right >= left) {
                int length = right - left + 1;
                answer += (int) Math.ceil((double) length / (2 * w + 1));
            }

            index = station + w + 1;
        }

        if (index <= n) {
            int length = n - index + 1;
            answer += (int) Math.ceil((double) length / (2 * w + 1));
        }
        return answer;
    }
}