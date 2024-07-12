package org.algorism.programmers.lv2.two;

public class SolutionTwo {

    public static boolean solution(String s) {
        char[] chars = s.toCharArray();

        int n = 0;

        for (char c : chars) {
            if ('(' == c) {
                n++;
            } else {
                n--;
            }
            if (n < 0) {
                return false;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        boolean solution = solution("((((((()))()()()()()(())))");
        System.out.println(solution);
    }
}
