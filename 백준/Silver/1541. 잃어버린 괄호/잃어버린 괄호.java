import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int left = 0;
        int right = 0;
        boolean hasMinus = false;

        c = 0;

        while (right <= s.length() - 1){
            if (s.charAt(right) == '+'){
                c += Integer.parseInt(s.substring(left, right));
                left = right + 1;
                right = left;
            }
            else if (s.charAt(right) == '-') {
                c += Integer.parseInt(s.substring(left, right));
                left = right + 1;
                right = left;
                hasMinus = true;
                break;
            }
            else{
                right++;
            }
        }
        while (right <= s.length() - 1){
            if (s.charAt(right) == '-' || s.charAt(right) == '+'){
                c -= Integer.parseInt(s.substring(left, right));
                left = right + 1;
                right = left;
            }
            else {
                right++;
            }
        }
        if (hasMinus){
            c -= Integer.parseInt(s.substring(left, right));
        }
        else {
            c += Integer.parseInt(s.substring(left, right));
        }


        System.out.print(c);

    }
}
