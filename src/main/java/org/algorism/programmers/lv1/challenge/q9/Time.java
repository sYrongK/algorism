package org.algorism.programmers.lv1.challenge.q9;

public class Time {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};


        estimate(() -> SolutionOne.solution(board, moves));
        estimate(() -> SolutionTwo.solution(board, moves));
        estimate(() -> SolutionThree.solution(board, moves));
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
