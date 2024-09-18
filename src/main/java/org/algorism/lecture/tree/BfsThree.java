package org.algorism.lecture.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 로 최단거리 구하기 (송아지 찾기) 2
 *
 * 현재 위치 5, 송아지 위치 14
 * 앞으로 1, 뒤로 1, 앞으로 5 3가지 방법으로 이동할 수 있다.
 * 한 번의 점프로 위 3가지 중 하나로 이동 가능
 *
 * 최소 몇 번의 점프로 송아지를 찾아갈 수 있는지
 */
public class BfsThree {

    public static int solution(int start, int destination) {
        /*
        미리 노드가 정의되어 있는 것이 아님. 굳이 노드를 그릴 필요도 없다. 큐에 쌓기만 해서 처리!
         */
        int level = 0;
        int[] distance = {1, -1, 5};
        int[] history = new int[10001];//만 까지라고 제한이 있네
        Queue<Integer> queue =  new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {//현재 레벨 노드 각각 처리
                int curr = queue.poll();

                for (int d : distance) {
                    int val = curr + d;
                    if (val == destination) return level+1;
                    if (val >= 1 && val <= 10000 && history[val] == 0) {
                        queue.offer(val);
                        history[val] = 1;
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        int answer = solution(5, 14);
        System.out.println("answer: " +answer);
    }
}
