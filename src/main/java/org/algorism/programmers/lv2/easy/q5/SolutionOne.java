package org.algorism.programmers.lv2.easy.q5;

import java.util.Arrays;

public class SolutionOne {

    public static int[] solution(String s) {
        int[] answer = new int[2];

        int temp;

        while (!s.equals("1")) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);//1111 2진법으로 변경
            answer[0]++;
            answer[1] -= temp;// 원래 length - 0 제거 length
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] solution = solution("0111010");
        System.out.println(Arrays.toString(solution));
    }
}
