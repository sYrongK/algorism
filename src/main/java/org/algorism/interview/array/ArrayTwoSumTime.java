package org.algorism.interview.array;

import org.algorism.programmers.lv1.challenge.q6.SolutionOne;
import org.algorism.programmers.lv1.challenge.q6.SolutionThree;
import org.algorism.programmers.lv1.challenge.q6.SolutionTwo;

public class ArrayTwoSumTime {

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        estimate(() -> ArrayTwoSum.bruteForce(nums, target));
        estimate(() -> ArrayTwoSum.balanceMap(nums, target));
        estimate(() -> ArrayTwoSum.balanceMap2(nums, target));
    }

    private static void estimate(Runnable runnable) {
        int iterations = 1000;
        long totalDuration = 0;
        for (int i = iterations; i > 0; i--) {
            long startTime = System.nanoTime();
            runnable.run();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            totalDuration += duration;
        }
        long averageDuration = totalDuration / iterations;
        System.out.println("평균 실행 시간: " + averageDuration + " 나노초");
    }
}
