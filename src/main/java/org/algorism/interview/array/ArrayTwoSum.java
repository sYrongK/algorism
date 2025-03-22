package org.algorism.interview.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [두 수의 합]
 * 두 수의 합이 목표값과 일치하는 인덱스를 찾아라
 */
public class ArrayTwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        int[] bruteForceResult = bruteForce(nums, target);
        System.out.println(Arrays.toString(bruteForceResult));

        int[] balanceMap = balanceMap(nums, target);
        System.out.println(Arrays.toString(balanceMap));

        int[] balanceMap2 = balanceMap2(nums, target);
        System.out.println(Arrays.toString(balanceMap2));

        int[] twoPointer = twoPointer(nums, target);
        System.out.println(Arrays.toString(twoPointer));

    }

    /*
    O(n)
    todo 포인터는 정렬이 되어야 한다. 이 문제는 index를 구하는 문제라, 정렬을 하면 index가 흐트러지기 떄문에 사실 two pointer로는 풀 수 없다.
     */
    private static int[] twoPointer(int[] nums, int target) {
        int left = 0, right = nums.length - 1;//양 끝에서부터 시작

        while (left != right) {
            if (nums[left] + nums[right] < target) {
                left+=1;
            } else if (nums[left] + nums[right] > target) {
                right-=1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    /*
    O(1) ~ O(n) (HashMap 이용)
     */
    public static int[] balanceMap2(int[] nums, int target) {
        //target 변수에서 첫 번째 수를 빼면 두 번째 수를 바로 알아낼 수 있다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

//            boolean balanceCondition = map.containsKey(target - nums[i]);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /*
    O(1) ~ O(n) (HashMap 이용)
     */
    public static int[] balanceMap(int[] nums, int target) {
        //target 변수에서 첫 번째 수를 빼면 두 번째 수를 바로 알아낼 수 있다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);//target과의 차액을 key로. array index를 value로
        }
        for (int i = 0; i < nums.length; i++) {
//            boolean balanceCondition = map.containsKey(target - nums[i]);
//            boolean notCurrentIndex = map.get(target - nums[i]) != i;//배열의 서로 다른 요소일 때
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    /*
    O(n의 2승)
     */
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; i++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
