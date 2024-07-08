package org.algorism.lecture.string.four;

import java.util.Scanner;

public class SolutionOne {

    private static void solution() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        /*
        nextInt() -> 줄바꿈 문자가 입력 스트림에 남아 있다.
        이 상태에서 nextLine()으로 다음 입력값을 받으려하면, 줄바꿈 문자를 인식해서 빈 문자열을 입력으로 받아들인다.
         */


        for (int i = 0; i < count; i++) {
            String word = scanner.next();

            char[] chars = word.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution();
    }
}
