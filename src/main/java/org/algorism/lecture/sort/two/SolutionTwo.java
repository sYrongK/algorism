package org.algorism.lecture.sort.two;

import java.util.Arrays;

/**
 * 버블정렬
 * N개의 자연수 배열 오름차순으로 정렬
 * 1 <= N >= 100
 */
public class SolutionTwo {

    public static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println("index 비교 범위 : " + 0 + " ~ " + (arr.length-i-1));
            for (int j = 0; j < arr.length-i-1; j++) {
//                System.out.println("j : " + j);
                if (arr[j+1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {13, 5, 11, 7, 23, 15};
        int[] answer = solution(nums);
        System.out.println(Arrays.toString(answer));
    }
}
