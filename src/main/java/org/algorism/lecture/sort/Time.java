package org.algorism.lecture.sort;

import org.algorism.lecture.sort.one.Solution;
import org.algorism.lecture.sort.two.SolutionOne;

public class Time {

    public static void main(String[] args) {
        int[] nums = {13, 5, 11, 7, 23, 15};

        estimate(() -> Solution.solution(nums));
        estimate(() -> SolutionOne.solution(nums));
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
