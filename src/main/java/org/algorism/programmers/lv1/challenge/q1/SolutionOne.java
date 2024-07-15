package org.algorism.programmers.lv1.challenge.q1;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {

    /**
     * 누가 가장 선물 많이 받을지 선물받을 개수의 최대값 구하기
     * @param friends
     * @param gifts
     * @return
     */
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        //friends -> 각각 예상 받을 선물 갯수 구하기
        //gifts -> 친구별로 누가누구에게 몇개씩 줬는지
        //친구별로 받은 갯수 / 준 갯수 구하기

        //muzi는 ryan에게 몇개줬는지 ryan에게 몇 개 받았는지
        Map<String, Integer> receiveCount = new HashMap<>();
        for (String friend : friends) {
            receiveCount.put(friend, 0);
        }


        Map<String, Map<String, Integer>> giverRecords = new HashMap<>();//누가 누구에게 몇개 줬는지

        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            String giver = arr[0];
            String receiver = arr[1];

            //giver 기록 있는지 (없음 만들어)
            Map<String, Integer> records = giverRecords.get(giver);
            if (records == null) {
                Map<String, Integer> aa = new HashMap<>();
                aa.put(receiver, 1);
                giverRecords.put(giver, aa);
            } else {
                //giver 가 누구한테 줬는지(없음 만들어)
                Integer gaveCount = records.get(receiver);
                int count = gaveCount == null
                        ? 1
                        : gaveCount + 1;
                records.put(receiver, count);
            }
        }

        //최대값 구하기
        for (int i = 0; i < friends.length; i++) {
            String friendResult = null;

            String friend1 = friends[i];
            Map<String, Integer> friend1Map = giverRecords.get(friend1);
            //선물한 수
            Integer gaveSum1 = getTotalGaveSum(giverRecords, friend1, friend1Map);
            //받은 수
            Integer receiveSum1 = getTotalReceiveSum(giverRecords, friend1, friend1Map);


            for (int j = i + 1; j < friends.length; j++) {
                String friend2 = friends[j];

                //친구1 친구2가 서로에게 준 기록이 있는지
                int count1 = getGiveCount(giverRecords, friend1, friend2);
                int count2 = getGiveCount(giverRecords, friend2, friend1);

                //없거나 같다면
                if (count1 == count2) {
                    Map<String, Integer> friend2Map = giverRecords.get(friend2);
                    //선물한 수
                    Integer gaveSum2 = getTotalGaveSum(giverRecords, friend2, friend2Map);
                    //받은 수
                    Integer receiveSum2 = getTotalReceiveSum(giverRecords, friend2, friend2Map);

                    //선물지수
                    int result1 = gaveSum1 - receiveSum1;
                    int result2 = gaveSum2 - receiveSum2;

                    friendResult = result1 == result2
                            ? null
                            : result1 > result2
                            ? friend1
                            : friend2;
                } else {
                    friendResult = count1 > count2 ? friend1 : friend2;
                }
                if (friendResult != null) receiveCount.put(friendResult, receiveCount.get(friendResult) + 1);
            }
        }

        for (String key : receiveCount.keySet()) {
            Integer count = receiveCount.get(key);
            answer = count > answer ? count : answer;
        }
        return answer;
    }

    private static Integer getTotalReceiveSum(Map<String, Map<String, Integer>> giverRecords, String friend1, Map<String, Integer> friend1Map) {
        Integer receiveSum1 = friend1Map == null
                ? 0
                : giverRecords.values().stream()
                    .filter(x -> x.containsKey(friend1))
                    .map(x -> x.get(friend1))
                    .reduce(0, Integer::sum);
        return receiveSum1;
    }

    private static int getTotalGaveSum(Map<String, Map<String, Integer>> giverRecords, String friend1, Map<String, Integer> friend1Map) {
        return friend1Map == null ? 0 : giverRecords.get(friend1).values().stream().reduce(0, Integer::sum);
    }

    private static int getGiveCount(Map<String, Map<String, Integer>> giverRecords, String giver, String receiver) {
        Map<String, Integer> records = giverRecords.get(giver);

        return records == null
                ? 0
                : records.get(receiver) != null
                ? records.get(receiver)
                : 0;
    }

    public static void main(String[] args) {
        /*
        이번 달 선물기록으로 다음달에 누가 많이 받을지 예측

         */
//        둘 중에 많이 받은 쪾이 다음 달에 하나 받음
//        선물 안 받았거나 동일하게 받았으면 선물 지수 고려 -> 선물 지수가 큰 사람이 하나 받음 (선물 지수 = 이번달에 내가 친구들에게 준 선물 - 받은 선물 수)
//        선물지수도 같다면 다음달은 주고받지 않음

        //친구들 목록
        String[] friends = new String[] {"a", "b", "c"};
        //이번달 주고받은 기록
        String[] gifts = new String[] {"a b", "b a", "c a", "a c", "a c", "c a"};

        int answer = solution(friends, gifts);
        System.out.println(answer);
    }
}
