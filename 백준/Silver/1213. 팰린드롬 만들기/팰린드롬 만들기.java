import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[26];

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'A';
            arr[idx]++;
        }

        StringBuilder center = new StringBuilder();
        // 짝수일 때,
         if (isPal()){
             for (int i = 0; i < arr.length; i++) {
                 for (int j = 0; j < arr[i] / 2; j++) {
                     char ch = (char) ('A' + i);
                     sb.append(ch);
                 }

                 if (arr[i] % 2 == 1) {
                     center.append((char) ('A' + i));
                 }
             }
         } else {
             System.out.println("I'm Sorry Hansoo");
             return;
         }
        String result = sb.toString() + center + sb.reverse();
        System.out.println(result);
    }


    static boolean isPal() {
        int oddCount = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
