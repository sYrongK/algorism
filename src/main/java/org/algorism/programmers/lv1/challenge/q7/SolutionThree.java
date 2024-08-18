package org.algorism.programmers.lv1.challenge.q7;

import java.util.Arrays;

public class SolutionThree {

    public static int[] solution(String[] wallpaper) {
        //wallpaper 크기는 최대 50x50
        int minX = 51;
        int minY = 51;
        int maxX = -1;
        int maxY = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return new int[] {minX, minY, maxX + 1, maxY + 1};
    }

    public static void main(String[] args) {
//        String[] wallpaper = {".#...", "..#..", "...#."};
//        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper = {"..", "#."};
        int[] answer = solution(wallpaper);
        System.out.println(Arrays.toString(answer));
    }
}
