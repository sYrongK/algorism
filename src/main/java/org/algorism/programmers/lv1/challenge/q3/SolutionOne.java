package org.algorism.programmers.lv1.challenge.q3;

import java.util.*;

public class SolutionOne {

    //todo 더 빠르네
    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> index = new HashMap<>();
        int[] count = new int[id_list.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] mail = new int[id_list.length];

        //인덱스값 저장
        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);//아이디별 인덱스값 keep
        }
        //신고한 애들 목록(중복X)
        for (String str : report) {
            String[] arr = str.split(" ");
            Integer a = index.get(arr[0]);
            Integer b = index.get(arr[1]);
            if (map.containsKey(b)) {
                map.get(b).add(a);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(a);
                map.put(b, list);
            }
        }
        //아이디별 신고 당한 횟수
        for (int i = 0; i < id_list.length; i++) {
            if (map.containsKey(i)) {//중복 신고 X
                if (map.get(i).size() >= k) {//신고당한 횟수
                    for (Integer idx : map.get(i)) {
                        mail[idx]++;//신고한 애들 메일 배열 vault 증가
                    }
                }
            }
        }
        return mail;
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
