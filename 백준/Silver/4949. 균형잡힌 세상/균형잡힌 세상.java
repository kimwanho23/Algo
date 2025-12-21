import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            sb.append(getResult(s)).append("\n");
        }
        System.out.println(sb);
    }

    public static String getResult(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    deque.push(ch);
                    break;
                case '[':
                    deque.push(ch);
                    break;
                case ')' :
                    if (deque.isEmpty() || deque.peekFirst() != '('){
                        return "no";
                    }
                    deque.pop();
                    break;
                case ']' :
                    if (deque.isEmpty() || deque.peekFirst() != '['){
                        return "no";
                    }
                    deque.pop();
                    break;
                default:
            }
        }
        if (deque.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
