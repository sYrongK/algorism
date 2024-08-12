package org.algorism.programmers.lv1.challenge.q6;

import java.util.*;

public class SolutionTwo {

    public static String[] solution(String[] players, String[] callings) {
        String[] position = new String[players.length];
        HashMap<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
            position[i] = players[i];
        }

        for (String calling : callings) {
            Integer rank = ranking.get(calling);

            if (rank > 0) {
                String curr = position[rank];
                String forward = position[rank - 1];

                ranking.put(calling, rank - 1);
                ranking.put(forward, rank);

                position[rank] = forward;
                position[rank - 1] = curr;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }
}
