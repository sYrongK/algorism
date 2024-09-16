package org.algorism.lecture.sort.one;

import java.util.Arrays;

/**
 * 선택정렬
 * N개의 자연수 입력되면 오름차순 정렬하여 출력
 * 1 <= N >= 100
 */
public class Solution {

    public static int[] solution(int[] nums) {
        //이중 for문:
        //배열의 자리 순차대로 비교하면서 그 자리에 들어올 가장 작은 수를 구할 것. i loop
        //기준값 idx(i로 시작해서 작은 값의 idx로 바꿔준다.)을 두고
        // j = i + 1로 j loop를 돌면서
        //배열의 idx보다 배열의 j가 더 작다면 idx = j 대입.
        // or
        // 배열의 idx보다 작은 수가 없다면(배열의 idx가 제일 작다면) 배열의 i에 배열의 idx값 대입.
        // 이걸 loop 반복.

        for (int i = 0; i < nums.length - 1; i++) {//마지막까지 돌 필요는 없음 앞에서 비교해서 바꾸니까.
            int idx = i;// i번째 자리에 들어올 숫자의 index 찾기
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[idx]) idx = j;
            }
            //i번째 숫자와 idx번째 숫자 swap
            System.out.println("i : " + i);
            System.out.println("idx : " + idx);
            if (idx != i) {
                System.out.println("Swap >>>> ");
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {13, 5, 11, 7, 23, 15};
        int[] answer = solution(nums);
        System.out.println(Arrays.toString(answer));
    }
}
