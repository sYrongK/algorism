package org.algorism.programmers.lv1.challenge.q9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolutionTwo {

    public static int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int x = move - 1;
                int doll = board[j][x];
                if (doll > 0) {
                    board[j][x] = 0;
                    if (!basket.empty() && (basket.peek() == doll)) {
                        basket.pop();
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
