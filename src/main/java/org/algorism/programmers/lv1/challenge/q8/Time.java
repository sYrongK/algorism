package org.algorism.programmers.lv1.challenge.q8;

public class Time {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        estimate(() -> SolutionOne.solution(new_id));
        estimate(() -> SolutionTwo.solution(new_id));
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
