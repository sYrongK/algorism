package org.algorism.programmers.lv2.q4;

public class SolutionTwo {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String str = s.toLowerCase();

        String[] arr = str.split("");
        boolean flag = true;
        for (String s1 : arr) {
            answer.append(flag ? s1.toUpperCase() : s1);
            flag = s1.equals(" ");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String answer = solution("for   the last week                   ");
        System.out.println(answer);
    }
}
