package org.algorism.interview.array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] heightArr = new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = twoPointer(heightArr);
        System.out.println(result);
    }

    private static int twoPointer(int[] heightArr) {
        int volume = 0;//물이 채워지는 횟수
        int leftIndex = 0;
        int rightIndex = heightArr.length - 1;
        int leftHeightMax = heightArr[leftIndex];//left 최대 높이
        int rightHeightMax = heightArr[rightIndex];//right 최대 높이

        //todo 더 낮은 쪽이 물이 얼마나 찰지를 결정한다.
        while (leftIndex < rightIndex) {
            leftHeightMax = Math.max(leftHeightMax, heightArr[leftIndex]);
            rightHeightMax = Math.max(rightHeightMax, heightArr[rightIndex]);

            if (leftHeightMax <= rightHeightMax) {
                //더 높은 쪽으로 이동
                volume += leftHeightMax - heightArr[leftIndex];
                leftIndex += 1;
            } else {
                volume += rightHeightMax - heightArr[rightIndex];
                rightIndex -= 1;
            }
        }
        return volume;
    }
}
