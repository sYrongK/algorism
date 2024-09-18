package org.algorism.lecture.tree;

import java.util.stream.IntStream;

/**
 * 부분집합 구하기 (DFS)
 * 자연수 N. 1부터 N 까지의 원소를 갖는 집합의 부분집합을 출력해라. 공집합은 제외
 *
 * 원소가 n개인 집합의 부분집합은 2의 N승이다. (공집합 포함)
 * 3개: 2 * 2 * 2 = 8가지
 */
public class DfsTwo {

    public static void solution(int n) {
        int[] arr = new int[n+1];//각 index 가 자연수(노드의 data)가 되는 것!
        traverse(arr, n, 1);
    }

    public static void traverse(int[] arr, int n, int L) {
        /*
        사용한다 & 사용 안 한다 경우의 수를 자식 노드로!!

        깊이를 L.
        n까지 사용한다 안한다 경우의 수 뻗어나가야 하니까 일단 n+1 레벨까진 내려가야 함!
        -> L == n + 1 이면 말단노드 끝.
        -> 말단노드에서 출력 등 하고 싶은 일 해주기
         */
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            IntStream.range(1, arr.length)//인덱스 출력
                    .filter(i -> arr[i] == 1)//공집합 제외됨
                    .forEach(i -> sb.append(i).append(" "));
            if (sb.length() > 0) System.out.println(sb.toString());
        }
        else {
            arr[L] = 1;//사용하는 경우
            traverse(arr, n, L+1);
// -> 사용하는 경우 체크하고, 사용 안 하는 경우 체크!
            arr[L] = 0;//사용 안 하는 경우
            traverse(arr, n, L+1);
        }

    }

    public static void main(String[] args) {
        solution(3);
    }
}
