package org.algorism.programmers.lv1.challenge.q6;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionThree {

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = ranking.get(calling);

            if (rank > 0) {
                String curr = players[rank];
                String forward = players[rank - 1];

                ranking.put(calling, rank - 1);
                ranking.put(forward, rank);

                players[rank] = forward;
                players[rank - 1] = curr;
            }
        }
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }
}
