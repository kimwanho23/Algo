import java.util.*;

class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];     // 첫 번째 컬럼 내림차순
            }
            return o1[col - 1] - o2[col - 1]; // col 번째 컬럼 오름차순
        });
        

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            answer ^= sum;
        }
        return answer;
    }
}