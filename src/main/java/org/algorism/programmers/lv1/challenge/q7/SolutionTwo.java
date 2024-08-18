package org.algorism.programmers.lv1.challenge.q7;

import java.util.Arrays;

/**
 * 파일이 있는 첫번쨰 행의 자리에서부터
 * 파일이 마지막으로 있는 행의 자리까지
 * 파일은 최소 하나 이상
 * loop에서 row는 계속 늘어남(최소 한 번만 체크하면 됨). column은 최소,최대 계속 늘어남
 */
public class SolutionTwo {

    public static int[] solution(String[] wallpaper) {
        int maxColumn, minColumn, maxRow, minRow;
        maxColumn = minColumn = maxRow = minRow = -1;//파일이 0,0에 올 수도 있으니까 구분되게 음수로 표현


        for (int i = 0; i < wallpaper.length; i++) {
            String[] str = wallpaper[i].split("");
            for (int j = 0; j < str.length; j++) {
                if ("#".equals(str[j])) {

                    if (minRow == -1) minRow = i;//row는 계속 늘어남
                    maxRow = Math.max(maxRow, i);

                    if (minColumn == -1 || minColumn > j)  minColumn = j;//column은 최소,최대 row 마다 바뀜
                    maxColumn = Math.max(maxColumn, j);
                }
            }
        }
        return new int[]{minRow, minColumn, maxRow + 1, maxColumn + 1};
    }

    public static void main(String[] args) {
//        String[] wallpaper = {".#...", "..#..", "...#."};
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
//        String[] wallpaper = {"..", "#."};
        int[] answer = solution(wallpaper);
        System.out.println(Arrays.toString(answer));
    }
}
