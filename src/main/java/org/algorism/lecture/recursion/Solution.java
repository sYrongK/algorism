package org.algorism.lecture.recursion;

/**
 * 재귀함수 - stackFrame
 */
public class Solution {

    public static void recurve1(int n) {
        /*
        1부터 n까지 출력
         */
        if (n == 0) return;//void type 에서 return 쓰면 메서드 종료 의미
        else {
            recurve1(n-1);
            System.out.println(n);//제일 마지막 호출된 재귀부터 처리하니까 - 스택프레임 순으로
        }
    }

    private static void recurve2(int n) {
        /*
        10진수 N 재귀함수 써서 2진수로 변환 출력
        10진수 -> 2진수
        n을 2로 나누어지지 않을 때까지 나눈 후 역순으로 나머지값들을 조합하면 2진수
         */
        if (n == 0) return;
        else {
            recurve2(n/2);
            System.out.print(n%2);
        }
    }

    private static int recurve3(int n) {
        /*
        팩토리얼
        자연수 N이 주어졌을 때 N! 출력
        */
        return n == 1
                ? n
                : n * recurve3(n - 1);
    }

    public static void main(String[] args) {
//        recurve1(10);
//        recurve2(11);
        System.out.println(recurve3(5));
    }
}
