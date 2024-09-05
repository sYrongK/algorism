package org.algorism.programmers.lv1.challenge.q9;

import java.util.ArrayDeque;
import java.util.Stack;

public class SolutionThree {

    public static int solution(int[][] board, int[] moves) {
        int count = 0;
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        for (int move : moves) {
            for (int y = 0; y < board.length; y++) {
                int x = move - 1;
                int doll = board[y][x];
                if (doll > 0) {
                    board[y][x] = 0;
                    if (!basket.isEmpty() && (basket.peek() == doll)) {
                        basket.pop();//삭제
                        count += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int answer = solution(board, moves);
        System.out.println(answer);
    }
}
