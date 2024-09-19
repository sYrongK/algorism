package org.algorism.lecture.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최단거리 구하기 2 - 거리가 가장 가까운 말단노드 구하기!
 * (첫문제는 BfsThree)
 *
 * BFS 로 구하는게 맞지만, 연습용으로 dfs, bfs 둘 다 공부!
 *
 *
 */
public class ClosestDistance {

    public static void dfs(Node root) {

    }

    public static int bfs(Node root) {
        //현재 레벨 노드 전부 처리 - 자기자신 poll, 자식 추가

        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //가장 높은 레벨을 구하기
        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {//현재 레벨 노드 전부 처리
                Node curr = queue.poll();
                //말단노드 중에 가장 짧은걸 구하는거니까

                if (curr.getLeft() == null && curr.getRight() == null) return level;//현재 레벨이 말단이구나!

                if (curr.getLeft() != null) queue.offer(curr.getLeft());
                if (curr.getRight() != null) queue.offer(curr.getRight());
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Node root = Node.builder()
                .data(1)
                .left(Node.builder().data(2).left(new Node(4)).right(new Node(5)).build())
                .right(Node.builder().data(3).build())
                .build();

        System.out.println(bfs(root));
    }
}
