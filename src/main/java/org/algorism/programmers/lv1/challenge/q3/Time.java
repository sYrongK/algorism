package org.algorism.programmers.lv1.challenge.q3;

public class Time {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        estimate(() -> SolutionOne.solution(id_list, report, k));
        estimate(() -> SolutionTwo.solution(id_list, report, k));
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
