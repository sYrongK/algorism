package org.algorism.programmers.lv1.challenge.q5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SolutionTwo {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> index = new ArrayList<>();

        //todo 한달 28일 제약이 있으니, 년 월 일 무의미하게 만들기
        int todayDays = getDays(today);

        HashMap<String, String> monthMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            monthMap.put(t[0], t[1]);
        }


        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int month = Integer.parseInt(monthMap.get(p[1]));

            int days = getDays(p[0]) + (month * 28);

            if (todayDays >=  days) index.add(i + 1);
        }
        return index.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getDays(String today) {
        String[] t = today.split("\\.");
        int year = Integer.parseInt(t[0]);
        int month = Integer.parseInt(t[1]);
        int day = Integer.parseInt(t[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] answer = solution(today, terms, privacies);
        System.out.println(Arrays.toString(answer));
    }
}
