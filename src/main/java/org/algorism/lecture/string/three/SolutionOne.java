package org.algorism.lecture.string.three;

import java.util.Scanner;

/**
 * [문장 속 단어]
 *
 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.
 ▣ 입력설명
 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성 되어 있습니다.
 ▣ 출력설명
 첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위 치한 단어를 답으로 합니다.
 */
public class SolutionOne {

    private String solution(String text) {
        String[] arr = text.split(" ");

        String answer = "";
        for (String word : arr) {
            if (word.length() > answer.length()) {
                //길이가 같은 단어일 경우, for loop 순차적으로 돌기 때문에 가장 앞쪽에 단어가 들어가고 나머진 안들어간다.
                answer = word;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String text = scanner.nextLine();//scanner.next() 쓰려면, 공백으로 단어 구분하기 때문에 hasNext 로 loop 돌면서 받아야 함
        System.out.println(new SolutionOne().solution(text));
    }
}
