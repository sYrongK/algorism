package org.algorism.lecture.string.four;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionTwo {

    private static ArrayList<String> solution(int n, String[] words) {
        ArrayList<String> answer = new ArrayList<>();
        for (String word : words) {
            String str = new StringBuilder(word).reverse().toString();
            answer.add(str);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            String word = scanner.next();
            words[i] = word;
        }

        for (String s : solution(n, words)) {
            System.out.println(s);
        }

    }
}
