package org.algorism.programmers.lv1.challenge.q1;

import java.util.HashMap;
import java.util.Map;

public class SolutionTwo {

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i < friends.length; i++) {
            map.put(friends[i], i);//각 친구의 인덱스값 킵
        }
        int[] index = new int[friends.length];//각 친구가 선물 준 횟수와 받은 횟수의 차이
        int[][] record = new int[friends.length][friends.length];//각 친구가 다른 친구에게 준 선물의 개수

        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            index[map.get(arr[0])]++;
            index[map.get(arr[1])]--;
            record[map.get(arr[0])][map.get(arr[1])]++;
        }

        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (record[i][j] > record[j][i]) count++;
                else if ((record[i][j] == record[j][i]) && (index[i] > index[j])) count++;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] friends = new String[] {"a", "b", "c"};
        //이번달 주고받은 기록
        String[] gifts = new String[] {"a b", "b a", "c a", "a c", "a c", "c a"};

        int answer = solution(friends, gifts);
        System.out.println(answer);
    }
}
