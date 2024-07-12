package org.algorism.programmers.lv2.q1;

public class Time {

    public static void main(String[] args) {

        estimate(() -> SolutionOne.solution("1 3 4 5 -1 3 -3 7"));
        estimate(() -> SolutionTwo.solution("1 3 4 5 -1 3 -3 7"));
        estimate(() -> SolutionThree.solution("1 3 4 5 -1 3 -3 7"));
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
