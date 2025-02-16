import java.util.Stack;


class Solution
{
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 스택의 top과 현재 문자가 같다면 pop
            } else {
                stack.push(c); // 그렇지 않다면 push
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}