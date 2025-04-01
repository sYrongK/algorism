package org.algorism.ninety.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SolutionOne {

    public static void main(String[] args) {
        int n = 0;
        List<String> text = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();//엔터 버퍼 정리
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.length() > 100) {
                throw new IllegalArgumentException();
            }
            text.add(input);
        }

        for (String t : text) {
            int lower = 0;
            int upper = 0;
            int number = 0;
            int whiteSpace = 0;
            for (char c : t.toCharArray()) {
                if (Pattern.matches("[a-z]", String.valueOf(c))) lower++;
                if (Pattern.matches("[A-Z]", String.valueOf(c))) upper++;
                if (Pattern.matches("[0-9]", String.valueOf(c))) number++;
                if (Pattern.matches("\\s", String.valueOf(c))) whiteSpace++;
            }
            String result = String.format("%d %d %d %d", lower, upper, number, whiteSpace);
            System.out.println(result);
        }

    }
}
