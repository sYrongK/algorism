package org.algorism.lecture.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리의 넓이우선탐색 (레벨탐색)
 *
 * 루트는 0레벨로 시작해서 간석 하나 추가할 때마다 +1 레벨 (레벨이 루트와 노드 간의 거리)
 * 넓이우선탐색은
 * 간선 한개로 방문할 수 있는 노드 전부 다 방문
 * 간선 두개로 방문할 수 있는 노드 전부 다 방문 ..
 *
 *       1
 *    /     \
 *   2       3
 *  /  \    /  \
 * 4    5  6    7
 * 레벨별로 방문. 1 > 2,3 > 4,5,6,7
 */
public class BfsOne {

    public static void solution(Node root) {
        /*
        선입선출로 큐를 사용
        루트부터 차례대로 넣으면 되는데, 다음 레벨로 보내는 방법 없으니
        자기자신 넣고 자식노드 넣고!
        그 다음 큐 자기자신 큐에서 제거한 후 (행동한 후) 큐가 not empty면 큐에 있는거 꺼내서 하기. (큐 사이즈만큼 돌면서 빼기)
         */
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

//        int L = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();

//            System.out.print(L + ": ");
            for (int i = 0; i < length; i++) {//현재 레벨 노드 각각 처리
                Node curr = queue.poll();
                System.out.print(curr.getData() + " ");//자기자신 빼기
                //자식 있으면 넣어서 while loop 반복되게 하기
                if(curr.getLeft() != null) queue.offer(curr.getLeft());
                if(curr.getRight() != null) queue.offer(curr.getRight());
            }
//            System.out.println();
//            L++;
        }
    }

    public static void main(String[] args) {
        Node root = Node.builder()
                .data(1)
                .left(Node.builder().data(2).left(new Node(4)).right(new Node(5)).build())
                .right(Node.builder().data(3).left(new Node(6)).right(new Node(7)).build())
                .build();
        solution(root);
    }
}
