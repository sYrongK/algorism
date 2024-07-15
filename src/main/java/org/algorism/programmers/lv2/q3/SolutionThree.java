package org.algorism.programmers.lv2.q3;

import java.util.Arrays;

public class SolutionThree {

    public static int solution(int [] A, int [] B) {
        int answer = 0;
        quickSort(A, 0, A.length - 1);//정렬
        quickSort(B, 0, B.length - 1);//정렬

        for (int i = 0; i < A.length; i++) {
            int reverseIndex = B.length - (i + 1);
            answer += A[i] * B[reverseIndex];
        }
        return answer;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int i, j, pivot, tmp;

        if (left < right) {//배열의 크기가 1보다 클 때 실행
            i = left;
            j = right;
            pivot = arr[left];//첫번째 값

            //분할 - left right 값 찾아서 자리 교환
            //left 가 pivot 보다 크거나 같은 값이면 stop
            //right 는 pivot 보다 작거나 같은 값이면 stop
            while (i < j) {//i와 j가 교차하지 않을 때까지 반복
                while (i < j && arr[i] <= pivot) i++;//첫번쨰 값부터 하나씩 뒤로 이동
                while (arr[j] > pivot) j--;//마지막 값부터 하나씩 앞으로 이동

                //교환
//                swap(arr, i, j);
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            //pivot 보다 크거나 같은 왼쪽 값과 pivot 자리 교환 (큰 값과 작은 값 사이에 오면 되니까)
//            swap(arr, left, i);
            arr[left] = arr[i];
            arr[i] = pivot;

            quickSort(arr, left, i - 1);//첫번째 ~ pivot 왼쪽 값 정렬
            quickSort(arr, i + 1, right);//pivot 오른쪽값 ~ 끝까지 정렬
        }

    }

    /**
     * i 와 j 자리 교환
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        int answer = solution(a, b);

        System.out.println(answer);
    }
}
