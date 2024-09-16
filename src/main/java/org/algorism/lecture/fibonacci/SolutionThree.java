package org.algorism.lecture.fibonacci;

import java.util.Arrays;

/**
 * 피보나치 수열 - 재귀 + 스택프레임 (제일 빨라)
 */
public class SolutionThree {
    private static int[] fibonacci;

    public static int solution(int n) {
        if (fibonacci[n] > 0) return fibonacci[n];//이미 생성한 수는 그대로 사용하게. 이거 안하면 느리다
        else if (n==1 || n == 2) return fibonacci[n] = 1;
        else return fibonacci[n] = solution(n-2) + solution(n-1);
    }

    public static void main(String[] args) {
        int n = 45;
        fibonacci = new int[n+1];
//        solution(n);
        // 1 1 2 3 5 8 13 21
//        Arrays.stream(fibonacci).filter(i -> i > 0).forEach(o -> System.out.print(o + " "));
//        System.out.println(fibonacci[n]);
        Time.estimate(() -> solution(n));
    }
}
