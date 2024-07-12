package org.algorism.programmers.lv2.two;

import java.util.EmptyStackException;
import java.util.Stack;

public class SolutionOne {

    public static boolean solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();//후입선출
        for (int i = 0; i < chars.length; i++) {
            if ('(' ==  chars[i]) {
                stack.push(i);
            } else {
                try {
                    stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean solution = solution("(((())))()()");
        //개수가 맞는 걸론 안 되고,짝이 맞아야 해
        //같은 (가 나오면 새로운 세트를 만들고
        //)가 나오면 최근 세트부터 닫아(삭제하자) -> 닫을 게 없으면 바로 false
        //그러고 세트가 다 닫혔는지? -> 루프 다 돌았는데, 남아있으면 false
        System.out.println(solution);

    }
}
