package org.algorism.programmers.lv2.q3;

import java.util.Arrays;

public class SolutionTwo {

    public static int solution(int [] A, int [] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int reverseIndex = B.length - (i + 1);
            answer += A[i] * B[reverseIndex];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        int answer = solution(a, b);

        System.out.println(answer);
    }
}
