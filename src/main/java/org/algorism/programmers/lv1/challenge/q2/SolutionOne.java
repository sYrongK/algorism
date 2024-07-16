package org.algorism.programmers.lv1.challenge.q2;

public class SolutionOne {
    //todo 코드 제출로는 맞는데, 답안 제출하면 안 맞음..

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int max_health = health;

        int bandage_success = 0;//붕대 성공 횟수
        int time = attacks[attacks.length - 1][0];

        //회복량 구하기
        for (int i = 0; i <= time; i++) {//총 시간만큼 loop
            //피해량 구하기
            boolean attacked = false;
            for (int j = 0; j < attacks.length; j++) {
                if (i == attacks[j][0]) {
                    int damage = attacks[j][1];
                    health -= damage;
                    attacked = true;
                }
            }
            if (health < max_health && !attacked) {
                health += x;
                bandage_success++;
            }
            if (attacked) {
                bandage_success = 0;
            }
            if (bandage_success == t) {
                bandage_success = 0;
                health += y;
            }
        }
        return health <= 0 ? -1 : health;
    }

    public static void main(String[] args) {
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        int answer = solution(bandage, health, attacks);
        System.out.println(answer);
    }
}
