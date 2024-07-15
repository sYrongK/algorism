package org.algorism.programmers.lv2.easy.q1;

import java.util.Arrays;

//Arrays.sort 이용
public class SolutionThree {

    public static String solution(String s) {
        String[] str = s.split(" ");

        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);//오름차순 정렬
        return arr[0] + " " + arr[arr.length - 1];
    }

    public static void main(String[] args) {
        String answer = solution("-1 -2 -3 -4");

        System.out.println(answer);
    }
}
