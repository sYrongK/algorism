package org.algorism.lecture.string.four;

import java.util.Scanner;

public class SolutionOne {

    private static void solution() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String word = scanner.nextLine();

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
