package org.algorism.programmers.lv2.easy.q1;

//순수 알고리즘
public class SolutionTwo {

    public static String solution(String s) {
        String[] str = s.split(" ");

        int min, max, n;
        min = max = Integer.parseInt(str[0]);

        for (String element : str) {
            n = Integer.parseInt(element);

            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        String answer = solution("1 6 5 3 7");

        System.out.println(answer);
    }
}
