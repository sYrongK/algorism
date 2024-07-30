package org.algorism.programmers.lv1.challenge.q5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SolutionOne {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> index = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        HashMap<String, String> monthMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            monthMap.put(t[0], t[1]);
        }


        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String month = monthMap.get(p[1]);

            LocalDate date = LocalDate.parse(p[0], formatter)
                    .plusMonths(Integer.parseInt(month))
                    .minusDays(1L);

            boolean result = todayDate.isAfter(date);
            if (result) index.add(i+1);
        }
        return index.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] answer = solution(today, terms, privacies);
        System.out.println(Arrays.toString(answer));
    }
}
