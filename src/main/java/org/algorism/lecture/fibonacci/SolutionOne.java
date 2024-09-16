package org.algorism.lecture.fibonacci;

/**
 * 피보나치 수열 - 재귀 (기본)
 */
public class SolutionOne {

    public static int solution(int n) {
        // 6 -> func(4) + func(5) = 3 + 5
        // 5 -> func(3) + func(4) = 2 + 3
        // 4 -> func(2) + func(3) = 1 + func(3)
        // 3 -> func(1) + func(2) = 1 + 1
        if (n==1) return 1;
        else if (n==2) return 1;
        else return solution(n-2) + solution(n-1);
    }

    public static void main(String[] args) {
        System.out.println(solution(45));// 1 1 2 3 5 8 13 21
//        Time.estimate(() -> solution(45));
    }
}
