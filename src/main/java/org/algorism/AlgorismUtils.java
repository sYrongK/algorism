package org.algorism;

public class AlgorismUtils {

    public static void main(String[] args) {

        getReverseIndexInForLoop();
    }

    /**
     * fori 내부에서 index 거꾸로 돌리고 싶을 때
     */
    private static void getReverseIndexInForLoop() {
        /*
            4 = 5 - (0 + 1);
            3 = 5 - (1 + 1);
            2 = 5 - (2 + 1);
            1 = 5 - (3 + 1);
            0 = 5 - (4 + 1)
         */
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            int reverseIndex = nums.length - (i + 1);
            System.out.println("index ::: " + reverseIndex);
        }
    }
}
