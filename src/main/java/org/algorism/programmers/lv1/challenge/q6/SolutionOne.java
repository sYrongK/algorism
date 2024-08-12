package org.algorism.programmers.lv1.challenge.q6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionOne {

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> ranking = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            Integer rank = ranking.get(calling);
            String forward = null;
            for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                if (entry.getValue() == rank - 1) {
                    forward = entry.getKey();
                }
            }

            ranking.put(calling, rank - 1);
            if (forward != null && !"".equals(forward)) {
                ranking.put(forward, rank);
            }
        }

        String[] result = new String[players.length];
        for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
            result[entry.getValue()] = entry.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }
}
