
import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {
        int answer = 1;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
               stack.add(s.charAt(i));
            } else {
                char s1 = stack.peek();
                if (s.charAt(i) == s1) {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return answer;
    }
}