package org.algorism.lecture.string.two;

import java.util.Scanner;

public class SolutionTwo {

    public String solution(String source) {
        StringBuilder text = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (Character.isUpperCase(c)) {
                text.append(Character.toLowerCase(c));
            }
            if (Character.isLowerCase(c)) {
                text.append(Character.toUpperCase(c));
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String source = scanner.next();

        System.out.println(new SolutionTwo().solution(source));
    }
}
