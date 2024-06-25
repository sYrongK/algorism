package org.algorism.lecture.string.one;


import java.util.Scanner;

/**
 * [문자 찾기]
 * <p>
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요. 대소문자를 구분하지 않습니다.
 * 문자열의 길이는 100을 넘지 않습니다.
 * ▣ 입력설명
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
 * ▣ 출력설명
 * 첫 줄에 해당 문자의 개수를 출력한다.
 */
public class StringSearch {

    public static void main(String[] args) {
        String source = getSource();
        char keyword = getKeyword();

        System.out.println(new SolutionOne(source, keyword).search());

        System.out.println(new SolutionTwo(source, keyword).search());

        System.out.println(new SolutionThree(source, keyword).search());
    }

    private static char getKeyword() {
        System.out.print(">> ");
        Scanner scanner = new Scanner(System.in);
        return  scanner.next().charAt(0);
    }

    private static String getSource() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (input.length() >= 100 || !checkAlphabet(input)) {
            System.out.print("> ");
            input = scanner.next();
        }
        return input;
    }

    private static boolean checkAlphabet(String input) {
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (!(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'))) {
                return false;
            }
        }
        return true;
    }

}
