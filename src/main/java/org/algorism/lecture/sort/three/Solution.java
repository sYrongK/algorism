package org.algorism.lecture.sort.three;

import java.util.Arrays;

/**
 * 삽입정렬
 * N개의 자연수 배열 오름차순으로 정렬
 *  * 1 <= N >= 100
 */
public class Solution {

    public static int[] solution(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) arr[j+1] = arr[j];//기준값보다 큰 애들 뒤로 하나씩 밀고
                else break;
//                System.out.println(Arrays.toString(arr));
            }
            arr[j+1] = tmp;//큰 애들 다 처리하고 난 자리에 기준값 넣기
//            System.out.println("i end: " + Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] nums = {13, 5, 11, 7, 23, 15};
        int[] nums = {11, 7, 5, 6, 10, 9};
        int[] answer = solution(nums);
        System.out.println(Arrays.toString(answer));
    }
}
