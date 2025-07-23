import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n]; // 2차원 보드로 변형
        boolean [][] erase; // 지워야 할 것
        Stack<Character> stack = new Stack<>(); // 스택

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        System.out.println(Arrays.deepToString(map));

        boolean loop = true; // 루프 여부 검증
        while (loop) {
            loop = false;
            erase = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != ' '
                            && map[i][j] == map[i + 1][j]
                            && map[i][j] == map[i][j + 1]
                            && map[i][j] == map[i + 1][j + 1]) {
                        erase[i][j] = true;
                        erase[i + 1][j] = true;
                        erase[i][j + 1] = true;
                        erase[i + 1][j + 1] = true;
                        loop = true;
                    }
                }
            } // 판정

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (erase[i][j]) {
                        map[i][j] = ' '; // 지운다
                        answer++; // 정답 + 1
                    }
                }
            }

            for (int j = 0; j < n; j++) { // 열 기준
                for (int i = 0; i < m; i++) {
                    if (map[i][j] != ' ') {
                        stack.push(map[i][j]);
                        map[i][j] = ' ';
                    }
                }

                // 2. 아래에서부터 스택에서 꺼내서 채우기
                for (int i = m - 1; i >= 0; i--) {
                    if (!stack.isEmpty()) {
                        map[i][j] = stack.pop();
                    } else {
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.deepToString(map));

        return answer;
    }
}