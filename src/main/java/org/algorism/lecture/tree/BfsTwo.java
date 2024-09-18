package org.algorism.lecture.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 로 최단거리 구하기 (송아지 찾기)
 *
 * 현재 위치 5, 송아지 위치 14
 * 앞으로 1, 뒤로 1, 앞으로 5 3가지 방법으로 이동할 수 있다.
 * 한 번의 점프로 위 3가지 중 하나로 이동 가능
 *
 * 최소 몇 번의 점프로 송아지를 찾아갈 수 있는지
 */
public class BfsTwo {

    public static int solution(int start, int destination) {
        /*
        미리 노드가 정의되어 있는 것이 아님. 굳이 노드를 그릴 필요도 없다. 큐에 쌓기만 해서 처리!
         */
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> history = new ArrayList<>();//이미 넘어간 숫자인지 체크용. length 알 수 없으니 List 써서 contains 체크

        int level = 0;
        queue.offer(start);
        history.add(start);

        while (!queue.isEmpty()) {
            int length = queue.size();

            System.out.print(level + ": ");
            queue.forEach(o -> System.out.print(o + " "));
            System.out.println();

            //현재 레벨에 14가 포함되면 종료!
            if (queue.contains(destination)) break;

            for (int i = 0; i < length; i++) {//현재 레벨 하나씩 처리
                int curr = queue.poll();

                if (!history.contains(curr+1)) {
                    queue.offer(curr+1);
                    history.add(curr+1);
                }
                if (!history.contains(curr-1)) {
                    queue.offer(curr-1);
                    history.add(curr-1);
                }
                if (!history.contains(curr+5)) {
                    queue.offer(curr+5);
                    history.add(curr+5);
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
