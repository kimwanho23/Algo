import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[] solution(int brown, int yellow) {

        int[] yellowHeight = arr(yellow); // 세로 길이

        int width = 0;
        int height = 0;

        for (int i : yellowHeight) {
            int yellowWidth = yellow / i; // 가로 길이

            if ((yellowWidth * 2) + (i * 2) + 4 == brown) {
                width = yellowWidth + 2;
                height = i + 2;
            }
        }

        return new int[]{width, height};
    }

    public static int[] arr(int x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}