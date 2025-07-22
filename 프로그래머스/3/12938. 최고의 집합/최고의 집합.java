class Solution {
    public static int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        // 자연수 집합
        // n개의 원소, 원소의 합 = s
        // 곱이 최대가 되는 집합 반환
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        int remain = s % n;
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i] += 1;
        }

        return answer;
    }
}