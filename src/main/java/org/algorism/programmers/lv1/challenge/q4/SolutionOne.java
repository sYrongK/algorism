package org.algorism.programmers.lv1.challenge.q4;

import java.util.Arrays;

public class SolutionOne {
    //todo 못풀었음
    public static int[] solution(String[] park, String[] routes) {
        //시작 인덱스  h, w
        int h = 0, w = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                h = i;
                w = park[i].indexOf("S");
            }
        }
        for (String route : routes) {
            String way = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);

            int move_h = h;
            int move_w = w;

            for (int i = 0; i < move; i++) {

                switch (way) {
                    case "S" : move_h++; break;
                    case "N" : move_h--; break;
                    case "E" : move_w++; break;
                    case "W" : move_w--; break;
                }
                if (move_h >= 0 && move_h < park.length && move_w >= 0 && move_w < park[0].length()) {//공원 범위 체크
                    if (park[move_h].substring(move_w, move_w + 1).equals("X")) {
                        break;
                    }
                    if(i == move-1){//route 하나 끝날 때 이동하게 처리
                        w = move_w;
                        h = move_h;
                    }

                }
            }
        }
        return new int[]{h, w};
}

    public static void main(String[] args) {
        //S: 시작지머 O: 이동가능한 통로 X: 장애물
        //방향 거리
//        String[] park = {"SOO","OOO","OOO"};
//        String[] routes = {"E 2","S 2","W 1"};
//        String[] park = {"SOO", "OXX", "OOO"};
//        String[] routes = {"E 2", "S 2", "W 1"};
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        int[] answer = solution(park, routes);
        System.out.println(Arrays.toString(answer));
    }
}
