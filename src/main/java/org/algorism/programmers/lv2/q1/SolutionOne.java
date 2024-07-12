package org.algorism.programmers.lv2.q1;

public class SolutionOne {

    public static String solution(String s) {
        String[] str = s.split(" ");

        String minVal = str[0];
        String maxVal = str[0];

        for (String element : str) {
            int num = Integer.parseInt(element);

            if (num < Integer.parseInt(minVal)) {
                minVal = element;
            }
            if (num > Integer.parseInt(maxVal)) {
                maxVal = element;
            }
        }
        return minVal + " " + maxVal;
    }

    public static void main(String[] args) {
        String answer = solution("-1 -1");

        System.out.println(answer);
    }
}
