package org.algorism.programmers.lv1.challenge.q2;

public class SolutionTwo {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];//회복 시간
        int x = bandage[1];//초당 회복량
        int y = bandage[2];//추가 회복량
        int now = health;
        int lastAttackedTime = 0;

        int attack_term = 0;
        int bondage_success = 0;

        for (int[] attack : attacks) {
            if (now <= 0) {
                return -1;
            }
            attack_term = attack[0] - lastAttackedTime - 1;//1 2 3 4 5 실행한걸 구해야 하니까 5 - 1 -1
            bondage_success = attack_term / t;

            lastAttackedTime = attack[0];
            now = Math.min(health, now + (attack_term * x));
            now = Math.min(health, now + (bondage_success * y));

            now -= attack[1];
        }

        return now <= 0 ? -1 : now;
    }

    public static void main(String[] args) {
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        int answer = solution(bandage, health, attacks);
        System.out.println(answer);
    }
}
