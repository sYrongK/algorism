package org.algorism.lecture.fibonacci;

import java.util.Arrays;

/**
 * 피보나치 수열 - for 문
 */
public class SolutionTwo {

    public static int solution(int n) {
        int[] fibonacci = new int[n];

        for (int i = 0; i < n; i++) {
            if (i==0 || i==1) {
                fibonacci[i] = 1;
            } else {
                fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
            }
        }
        return fibonacci[n-1];
    }

    public static void main(String[] args) {
//        System.out.println(solution(45));// 1 1 2 3 5 8 13 21
        Time.estimate(() -> solution(45));
    }
}
