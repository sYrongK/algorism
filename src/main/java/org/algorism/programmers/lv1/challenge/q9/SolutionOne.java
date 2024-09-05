package org.algorism.programmers.lv1.challenge.q9;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {

    public static int solution(int[][] board, int[] moves) {
        //board 인형뽑기 기계 5x5 ~ 30x30 2차원 배열
        //moves 크레인 위치 == 가로 위치 (크기는 1 ~ 1000) board의 가로위치 이하의 수
        //인형은 1 ~ 100 숫자가 같으면 같은 인형!
        //0은 비어있음 의미
        //바구니에 연속으로 동일한 인형 담으면 터져서 사라진다.

        int count = 0;
        List<Integer> basket = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int x = moves[i] - 1;
                int doll = board[j][x];
                if (doll > 0) {
                    board[j][x] = 0;
                    int forwardIndex = basket.size() - 1;
                    if (!basket.isEmpty() && (basket.get(forwardIndex) == doll)) {
                        basket.remove(forwardIndex);
                        count += 2;
                    } else {
                        basket.add(doll);
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
