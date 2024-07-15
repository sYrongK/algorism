package org.algorism.programmers.lv2.q3;

public class Time {

    public static void main(String[] args) {
        estimate(() -> SolutionOne.solution(new int[] {1, 4, 2} , new int[] {5, 4, 4}));
        estimate(() -> SolutionTwo.solution(new int[] {1, 4, 2} , new int[] {5, 4, 4}));
        estimate(() -> SolutionThree.solution(new int[] {1, 4, 2} , new int[] {5, 4, 4}));
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
