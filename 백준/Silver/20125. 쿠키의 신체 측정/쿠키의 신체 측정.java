import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean head;
    static Point heart, waist;
    static String[][] cookie;
    static int leftArm, rightArm, wai, leftLeg, rightLeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 한 변의 길이
        cookie = new String[N + 1][N + 1]; // 1-based 배열

        // 쿠키 모양 입력
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                cookie[i][j] = String.valueOf(s.charAt(j - 1));
                if (!head && s.charAt(j - 1) == '*') {
                    head = true;
                    heart = new Point(i + 1, j);
                }
            }
        }

        // 왼팔
        for (int i = heart.y - 1; i >= 1; i--) {
            if (cookie[heart.x][i].equals("*")) {
                leftArm++;
            } else {
                break;
            }
        }

        // 오른팔
        for (int i = heart.y + 1; i <= N; i++) {
            if (cookie[heart.x][i].equals("*")) {
                rightArm++;
            } else {
                break;
            }
        }

        // 허리
        for (int i = heart.x + 1; i <= N; i++) {
            if (cookie[i][heart.y].equals("*")) {
                wai++;
            } else {
                waist = new Point(i - 1, heart.y);
                break;
            }
        }

        // 왼쪽 다리
        for (int i = waist.x + 1; i <= N; i++) {
            if (waist.y - 1 >= 1 && cookie[i][waist.y - 1].equals("*")) {
                leftLeg++;
            } else {
                break;
            }
        }

        // 오른쪽 다리
        for (int i = waist.x + 1; i <= N; i++) {
            if (waist.y + 1 <= N && cookie[i][waist.y + 1].equals("*")) {
                rightLeg++;
            } else {
                break;
            }
        }

        // 결과 출력
        System.out.println(heart.x + " " + heart.y);
        System.out.println(leftArm + " " + rightArm + " " + wai + " " + leftLeg + " " + rightLeg);
    }
}
