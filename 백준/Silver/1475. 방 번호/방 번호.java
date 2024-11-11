import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9]; // 0 ~ 8까지

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int number = s.charAt(i) - '0'; //현재 번호
            if (number == 9){
                number = 6;
            }
            if (arr[number] == 0){
                for (int j = 0; j < 9; j++) {
                    if (j == 6){
                        arr[j] += 2;
                    } else{
                        arr[j]++; // 한 세트 구매
                    }
                }
                count++;
            }
            arr[number]--;
        }
        System.out.println(count);
    }
}
