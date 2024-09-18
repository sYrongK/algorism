package org.algorism.lecture.tree;

/**
 * 이진트리에서의 깊이우선탐색
 * 한 방향 마지막 노드까지 가고 막히면 안 가본 방향 탐색
 *
 * 3가지 순회있음. 루트(부모)를 언제 방문하느냐 기준이다.
 * 1.전위순회: 부모 > 왼 > 오
 * 2.중위순회: 왼 > 부모 > 오 (왼쪽가려는데 자식이 또 있으면 자식 왼쪽 간다. 깊이우선탐색이니까)
 * 3.후위순회: 왼 > 오 > 부모
 *
 *       1
 *    /     \
 *   2       3
 *  /  \    /  \
 * 4    5  6    7
 *
 * 전위순회: 1 2 4 5 3 6 7
 * 중위순회: 4 2 5 1 6 3 7
 * 후위순회: 4 5 2 6 7 3 1
 */
public class DfsOne {

    public static void preoder(Node root) {
        if (root == null) return;//left 혹은 right 넣어서 호출했는데 없는거니까 말단 노드
        else {
            System.out.print(root.getData() + " ");//전위순회
            preoder(root.getLeft());
            preoder(root.getRight());
        }
    }
    public static void inorder(Node root) {
        if (root == null) return;//left 혹은 right 넣어서 호출했는데 없는거니까 말단 노드
        else {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");//중위순회 (제일 깊은 왼쪽 노드부터 출력 > 부모 > 오른쪽)
            inorder(root.getRight());
        }

    }

    public static void postorder(Node root) {
        if (root == null) return;//left 혹은 right 넣어서 호출했는데 없는거니까 말단 노드
        else {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " ");//후위순회 (제일 깊은 왼쪽 노드부터 출력 > 오른쪽 > 부모)
        }
    }

    public static void main(String[] args) {
        Node root = Node.builder()
                .data(1)
                .left(Node.builder().data(2).left(new Node(4)).right(new Node(5)).build())
                .right(Node.builder().data(3).left(new Node(6)).right(new Node(7)).build())
                .build();

        preoder(root);
        inorder(root);
        postorder(root);
    }
}
