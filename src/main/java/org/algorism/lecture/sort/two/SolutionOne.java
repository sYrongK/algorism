package org.algorism.lecture.sort.two;

import java.util.Arrays;

/**
 * 버블정렬
 * N개의 자연수 배열 오름차순으로 정렬
 * 1 <= N >= 100
 */
public class SolutionOne {

    public static int[] solution(int[] arr) {
        //이웃한 두 수를 비교해서 swap
        //오름차순일 경우 제일 큰수가 계속 밀려서 맨 뒷자리로 가게 된다. -> 다음 루프는 맨 뒷자리 빼고 비교

        for (int i = arr.length-1; i > 0; i--) {//어디까지 비교할지 loop 범위를 줄여나가야 함
//            System.out.println("index 비교 범위 : " + 0 + " ~ " + i);
            for (int j = 0; j < i; j++) {
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
