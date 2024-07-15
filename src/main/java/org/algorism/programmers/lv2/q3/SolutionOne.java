package org.algorism.programmers.lv2.q3;

import java.util.Arrays;
import java.util.Collections;

public class SolutionOne {

    public static int solution(int [] A, int [] B) {
        int answer = 0;

        // 1.stream, 2.직접
        Integer[] wrapper2 = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            wrapper2[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(wrapper2, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * wrapper2[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        int answer = solution(a, b);

        System.out.println(answer);
    }
}
