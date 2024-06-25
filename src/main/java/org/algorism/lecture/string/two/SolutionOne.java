package org.algorism.lecture.string.two;

import java.util.Scanner;

public class SolutionOne {

    public String solution(String source) {
        StringBuilder text = new StringBuilder();
        for (char c : source.toCharArray()) {
//            if ('A' <= c && 'Z' >= c) {
            if (65 <= c && 90 >= c) {
                // 대소문자 간 아스키코드는 32 차이난다. a의 대문자는 a 변수 - 32하면 된다는 얘기!!
//                text.append(Character.toLowerCase(c));
                text.append((char) (c + 32));
            }
//            if ('a' <= c && 'z' >= c) {
            if (97 <= c && 122 >= c) {
//                text.append(Character.toUpperCase(c));
                text.append((char) (c - 32));
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
