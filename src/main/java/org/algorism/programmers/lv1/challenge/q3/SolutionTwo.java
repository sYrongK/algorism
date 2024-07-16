package org.algorism.programmers.lv1.challenge.q3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionTwo {

    public static int[] solution(String[] id_list, String[] report, int k) {
        Set<String> content = Arrays.stream(report).collect(Collectors.toSet());//중복 제거한 신고 내용

        Map<String, Integer> count = new HashMap<>();//신고 당한 횟수
        for (String id : content) {
            String target = id.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list)
                .map(id -> content
                        .stream()
                        .filter(s -> s.startsWith(id + " "))
                        .filter(s -> {
                            String b = s.split(" ")[1];
                            return count.getOrDefault(b, 0) >= k;
                        })
                        .count())
                .mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        int[] answer = solution(id_list, report, k);
        System.out.println(Arrays.toString(answer));
    }
}
