class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        // 각 배열의 GCD 초기화
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 배열 전체의 GCD 계산
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 상대 배열에 나누어지는 수가 하나라도 있다면 무효화
        gcdA = isNotDivisor(gcdA, arrayB) ? gcdA : 0;
        gcdB = isNotDivisor(gcdB, arrayA) ? gcdB : 0;

        // 조건을 만족하는 GCD 중 큰 값 반환
        return Math.max(gcdA, gcdB);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static boolean isNotDivisor(int d, int[] array) {
        for (int n : array) {
            if (n % d == 0) return false;  // 나눌 수 있는 수가 있으면 false
        }
        return true;  // 전부 나눌 수 없으면 true
    }
}