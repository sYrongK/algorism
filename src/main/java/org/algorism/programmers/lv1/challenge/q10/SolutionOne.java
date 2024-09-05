package org.algorism.programmers.lv1.challenge.q10;

public class SolutionOne {

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = -1, right = -2;

        int[][] keypad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -2}
        };

        for (int number : numbers) {
            String str = null;
            if (number == 1 || number == 4 || number == 7) {//이것보다 그냥 조건문하는게 더 빠를까
                str = "L";
            } else if (number == 3 || number == 6 || number == 9) {
                str = "R";
            } else {
                //거리구하기 : 좌표 구하고, 거리차 구하기
                int[] number_position = getKeypadPosition(keypad, number);
                int[] left_position = getKeypadPosition(keypad, left);
                int[] right_position = getKeypadPosition(keypad, right);

                int left_distance = getDistance(number_position, left_position);
                int right_distance = getDistance(number_position, right_position);

                if (left_distance < right_distance) {
                    str = "L";
                } else if (right_distance < left_distance) {
                    str = "R";
                } else {
                    if ("left".equals(hand)) {
                        str = "L";
                    }
                    if ("right".equals(hand)) {
                        str = "R";
                    }
                }
            }
            if (str.equals("R")) {
                right = number;
            } else {
                left = number;
            }
            answer.append(str);
        }
        return answer.toString();
    }

    private static int getDistance(int[] position1, int[] position2) {
        return Math.abs(position1[0] - position2[0]) + Math.abs(position1[1] - position2[1]);
    }

    private static int[] getKeypadPosition(int[][] keypad, int number) {
        int[] position = new int[2];
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[0].length; j++) {
                if (keypad[i][j] == number) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        String answer = solution(numbers, hand);
        System.out.println(answer);
    }
}
