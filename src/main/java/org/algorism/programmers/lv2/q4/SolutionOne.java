package org.algorism.programmers.lv2.q4;

public class SolutionOne {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ", -1);//끝의 공백 무시되지 않게

        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {//(first > 64 && first < 91) || (first > 96 && first < 123)
                    if (chars[j] > 96 && chars[j] < 123) chars[j] -= 32;

                } else {
                    if (chars[j] > 64 && chars[j] < 91) chars[j] += 32;
                }
                sb.append(chars[j]);
            }
            if (i != arr.length - 1) sb.append(" ");
        }

        return "\"" + sb.toString() + "\"";
    }

    public static void main(String[] args) {
        String answer = solution("for   the last week  ");
        System.out.println(answer);
    }
}
