package org.algorism.lecture.one.two;

import java.util.Scanner;

public class SolutionOne {

    public String solution(String source) {
        StringBuilder text = new StringBuilder();
        for (char c : source.toCharArray()) {
//            if ('A' <= c && 'Z' >= c) {
            if (65 <= c && 90 >= c) {
                text.append(Character.toLowerCase(c));
            }
//            if ('a' <= c && 'z' >= c) {
            if (97 <= c && 122 >= c) {
                text.append(Character.toUpperCase(c));
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String source = scanner.next();

        System.out.println(new SolutionOne().solution(source));
    }
}
