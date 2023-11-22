import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("");
        int count = str.length() - 1; //ispallendrom 함수가 진행되어도 count가 바뀌지 않는다면 가장 긴 수를 추가해야한다.

        for (int i = 0; i < arr.length; i++) {
            if (ispallendrom(arr, i)){
                count = i;
                break;
            }
        }
        System.out.println(str.length() + count);
    }

    public static boolean ispallendrom(String[] str, int index){ // 끝부분이 팰린드롬 수인가?
        int i = index;
        int j = str.length - 1;

        while (i <= j){
            if (!(str[i].equals(str[j])) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
