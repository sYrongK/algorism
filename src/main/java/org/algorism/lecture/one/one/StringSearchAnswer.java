package org.algorism.lecture.one.one;

import java.util.Scanner;

public class StringSearchAnswer {

    public long solution(String source, char keyword) {
        long count = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == Character.toUpperCase(keyword) || c == Character.toLowerCase(keyword)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        StringSearchAnswer instance = new StringSearchAnswer();

        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();
        char keyword = scanner.next().charAt(0);

        System.out.println(instance.solution(source, keyword));
    }
}
